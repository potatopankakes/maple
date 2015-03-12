package com.gnoras.maple.itest.web.services.tests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.CharEncoding;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jasypt.contrib.org.apache.commons.codec_1_3.binary.Base64;
import org.jasypt.digest.StandardByteDigester;
import org.jasypt.digest.config.SimpleDigesterConfig;
import org.jasypt.salt.FixedByteArraySaltGenerator;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gnoras.maple.common.util.ByteConverter;
import com.gnoras.maple.itest.impl.MapleWebTestBase;
import com.gnoras.maple.itest.web.services.json.objects.JsonBasicResponse;
import com.gnoras.maple.itest.web.services.json.objects.JsonErrorInfo;
import com.gnoras.maple.itest.web.services.json.objects.JsonErrorResponse;
import com.gnoras.maple.itest.web.services.json.objects.JsonExceptionErrorInfo;
import com.gnoras.maple.itest.web.services.json.objects.JsonExceptionInfo;
import com.gnoras.maple.itest.web.services.json.objects.JsonExceptionResponse;
import com.gnoras.maple.itest.web.services.json.objects.JsonLoginReservationResponse;

public class LoginServiceTest extends MapleWebTestBase {

	private final static int numBytesInSalt = 32;
	private final static int numIterationsPhase1 = 1000;
	private final static int numIterationsPhase2 = 10;
	private final static String hashingAlgo = "SHA-256"; // http://download.oracle.com/docs/cd/E17476_01/javase/1.5.0/docs/guide/security/CryptoSpec.html#AppA

	private byte[] bySalt;
	private long seqNo;
	
	private class LoginParams {
		public String encryptedCredentials;
		public long seqNo;
	}

	@Test
	@Parameters({ "baseUrl", "email" })
	public void testGetSalt(String baseUrl, String email) throws IOException, InstantiationException, IllegalAccessException {
		
		JsonLoginReservationResponse o = testGetSaltHelper(baseUrl, email, JsonLoginReservationResponse.class);

		Assert.assertTrue(o.success, "Json response had success == false. ");
		Assert.assertNotNull(o.result, "Json response had a null result. ");

		seqNo = o.result.seqNo;
		long milliSecNowUTC = new Date().getTime();
		long milliSecTillSaltExpires = milliSecNowUTC - seqNo;
		Assert.assertTrue(milliSecTillSaltExpires < 1000, "Json response's seqNo on login salt was old, should be under 1sec. ");

		String strSalt = o.result.salt;
		Assert.assertTrue(strSalt.length() >= numBytesInSalt, "Json response's salt is less than " + numBytesInSalt + " characters");
		byte[] byEncodedSalt = strSalt.getBytes(CharEncoding.UTF_8);

		bySalt = Base64.decodeBase64(byEncodedSalt);
		Assert.assertTrue(bySalt.length >= 8, "Json response's binary salt is less than 8 bytes");
	}
	
	@Test
	@Parameters({ "baseUrl", "email" })
	public void testGetSaltFailure(String baseUrl, String email) throws IOException, InstantiationException, IllegalAccessException {
		String expectedErrorId = "381B90E8-F87B-11E0-AA03-90AF4824019B";
		Class<?> errorResponseType = getErrorResponseType(); // see what we are configured to get/require
		Object o = testGetSaltHelper(baseUrl, email, errorResponseType);
		validateStandardErrorResponse(o, expectedErrorId);
	}

	private <T> T testGetSaltHelper(String baseUrl, String email, Class<T> clazz) throws IOException, InstantiationException, IllegalAccessException {
		
		List<NameValuePair> params = new ArrayList<NameValuePair>(1);
		params.add(new BasicNameValuePair("email", email));
		String url = baseUrl + "/svc/LoginSvcV1/salt";
		T o = super.makeGetRequest(url, params, clazz);
		return o;
	}

	private LoginParams createCredentials(String strPassword) throws UnsupportedEncodingException {
		byte[] byPassword = strPassword.getBytes(CharEncoding.UTF_8);

		// form salt generator
		FixedByteArraySaltGenerator sg = new FixedByteArraySaltGenerator();
		sg.setSalt(bySalt);

		// form the digester
		SimpleDigesterConfig sdc = new SimpleDigesterConfig();
		sdc.setAlgorithm(hashingAlgo);
		sdc.setSaltGenerator(sg);
		sdc.setSaltSizeBytes(numBytesInSalt);
		sdc.setIterations(numIterationsPhase1);

		StandardByteDigester sd = new StandardByteDigester();
		sd.setConfig(sdc);

		// produce the phase 1 digest
		byte[] byStoredCredentials = sd.digest(byPassword);
		
		StandardByteDigester sd2 = new StandardByteDigester();
		sd2.setConfig(sdc);
		
		String strMilliSecNowUTC = String.valueOf(seqNo);
		byte[] byMilliSecNowUTC = strMilliSecNowUTC.getBytes(CharEncoding.UTF_8);
		byte[] byFinalMessage = ByteConverter.Join(byMilliSecNowUTC, byStoredCredentials);

		// produce the phase 2 digest
		sdc.setIterations(numIterationsPhase2);
		byte[] byEncryptedFinalMessage = sd2.digest(byFinalMessage);
		byte[] byStrEncryptedFinalMessage = Base64.encodeBase64(byEncryptedFinalMessage);
		String strEncryptedFinalMessage = new String(byStrEncryptedFinalMessage, CharEncoding.UTF_8);

		LoginParams lp = new LoginParams();
		lp.seqNo = seqNo;
		lp.encryptedCredentials = strEncryptedFinalMessage;
		return lp;
	}

	@Test
	@Parameters({ "baseUrl", "email", "password" })
	public void testSuccessfulLogin(String baseUrl, String email, String password) throws IOException, InstantiationException, IllegalAccessException {
		JsonBasicResponse o = testLoginHelper(baseUrl, email, password, JsonBasicResponse.class);
		Assert.assertTrue(o.success, "Json response had success != true");
		Assert.assertNull(o.result, "Json response had a NON null result");
	}
	
	private <T> T testLoginHelper(String baseUrl, String email, String password, Class<T> clazz) throws IOException, InstantiationException, IllegalAccessException {
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("email", email));
		LoginParams lp = createCredentials(password);
		params.add(new BasicNameValuePair("seqNo", String.valueOf(lp.seqNo)));
		params.add(new BasicNameValuePair("cred", lp.encryptedCredentials));
		
		T o = super.makePostRequest(baseUrl + "/svc/LoginSvcV1/login", params, clazz);
		return o;
	}

	@Test
	@Parameters({ "baseUrl", "email", "password", "errorId" })
	public void testFailedLogin(String baseUrl, String email, String password, String expectedErrorId) throws IOException, InstantiationException, IllegalAccessException {
		Class<?> errorResponseType = getErrorResponseType(); // see what we are configured to get/require
		Object o = testLoginHelper(baseUrl, email, password, errorResponseType);
		validateStandardErrorResponse(o, expectedErrorId);
	}

}
