package com.gnoras.maple.itest.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.gnoras.maple.itest.interfaces.IMapleWebTestContext;
import com.gnoras.maple.itest.web.services.json.objects.JsonErrorInfo;
import com.gnoras.maple.itest.web.services.json.objects.JsonErrorResponse;
import com.gnoras.maple.itest.web.services.json.objects.JsonExceptionErrorInfo;
import com.gnoras.maple.itest.web.services.json.objects.JsonExceptionInfo;
import com.gnoras.maple.itest.web.services.json.objects.JsonExceptionResponse;

public abstract class MapleWebTestBase extends MapleWebTestContextConfiguration {

	private boolean requireInternalResponse = false;
	
	@BeforeClass
	@Parameters({ "requireInternalResponse" })
	public void setRequireInternalResponse(boolean require) {
		requireInternalResponse = require;
	}
	
	protected boolean getRequireInternalResponse() {
		return requireInternalResponse;
	}
	
	public Class<?> getErrorResponseType() {
		return getRequireInternalResponse() ? JsonExceptionResponse.class : JsonErrorResponse.class;
	}
	
	protected void validateStandardErrorResponse(Object o, String expectedErrorId) {
		if ( o instanceof JsonErrorResponse ) {
			validateErrorResponse((JsonErrorResponse)o, expectedErrorId);
		}
		else if ( o instanceof JsonExceptionResponse ) {
			validateExceptionResponse((JsonExceptionResponse)o, expectedErrorId);
		}
		else {
			Assert.fail("Error response was not of type JsonErrorResponse or JsonExceptionResponse. Code test support for additional error response types. ");
		}
	}
	
	private void validateErrorResponse(JsonErrorResponse o, String expectedErrorId) {
		validateErrorResult(o.result, o.success, expectedErrorId);
	}
	
	private void validateExceptionResponse(JsonExceptionResponse o, String expectedErrorId) {
		JsonExceptionErrorInfo eei = o.result;
		validateErrorResult(eei, o.success, expectedErrorId);
		validateExceptionResult(eei.exception);
	}
	
	private void validateErrorResult(JsonErrorInfo ei, boolean success, String expectedErrorId) {
		Assert.assertNotNull(ei, "JsonErrorInfo was null. ");
		Assert.assertFalse(success, "Json response had success == true. ");
		Assert.assertEquals(ei.errorId.toLowerCase(), expectedErrorId.toLowerCase(), "ErrorIds did not match, ");
	}
	
	private void validateExceptionResult(JsonExceptionInfo exi) {
		Assert.assertNotNull(exi, "JsonExceptionInfo was null. ");
		Assert.assertNotNull(exi.message, "JsonExceptionInfo.message was null. ");
		Assert.assertNotNull(exi.stackTrace, "JsonExceptionInfo.stackTrace was null. ");
		if ( exi.cause != null ) {
			validateExceptionResult(exi.cause);
		}
	}
	
	protected HttpEntity makeRequest(HttpRequestBase request) {
		IMapleWebTestContext tc = super.getTestContext();
		Assert.assertNotNull(tc, "TC was null");

		HttpClient client = tc.getHttpConnection();
		try {
			HttpResponse response = client.execute(request);

			StatusLine sl = response.getStatusLine();
			Assert.assertEquals(sl.getStatusCode(), HttpStatus.SC_OK, "HTTP Success not returned");

			HttpEntity entity = response.getEntity();
			Assert.assertTrue(entity.getContentLength() > 0, "No content returned");
			return entity;
		} catch (Exception e) {
			String msg = makeErrorString("Exception caught in makeRequest(HttpRequestBase).", null, e);
			Assert.fail(msg, e);
			return null; // never executed... but eclipse doesn't understand the
								// line above
		}
	}
	
	private ObjectMapper om = new ObjectMapper();
	
	protected <T> T makeRequest(HttpRequestBase request, Class<T> clazz) {
		HttpEntity entity = makeRequest(request);
		if (entity != null) {
			try {
				T o = om.readValue(entity.getContent(), clazz);
//				Schema<T> schema = RuntimeSchema.getSchema(clazz);
//				T o = clazz.newInstance();
//				boolean numeric = false;
//				JsonIOUtil.mergeFrom(entity.getContent(), o, schema, numeric);
				return o;
//			} catch (IllegalAccessException e) {
//				String msg = makeErrorString("Exception caught in makeRequest(HttpRequestBase, Class<T>). Failed creating type T ("
//						+ clazz.getName() + "). ", entity, e);
//				Assert.fail(msg, e);
			} catch (IOException e) {
				String msg = makeErrorString(
						"Exception caught in makeRequest(HttpRequestBase, Class<T>). Failed merging data into T (" + clazz.getName()
								+ "). ", entity, e);
				Assert.fail(msg, e);
//			} catch (InstantiationException e) {
//				String msg = makeErrorString("Exception caught in makeRequest(HttpRequestBase, Class<T>). Failed creating type T ("
//						+ clazz.getName() + "). ", entity, e);
//				Assert.fail(msg, e);
			}
			finally{
				try {
					EntityUtils.consume(entity);
				} catch (IOException eall) {
					System.err.println(this.getClass().getSimpleName() + ": Unexpected Exception consuming Entity.\r\n" + eall.getMessage() + "\r\n");
					eall.printStackTrace(System.err);
				}
			}
		}
		return null;
	}

	private String makeErrorString(String prefix, HttpEntity entity, Exception e) {
		return makeErrorString(prefix, entity, e, "");
	}

	private String makeErrorString(String prefix, HttpEntity entity, Exception e, String suffix) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		pw.println(prefix);

		pw.println(e.getMessage());
		e.printStackTrace(pw);

		pw.close();
		sw.append(suffix);
		
		try {
			sw.close();
		} catch (Exception e2) {
			System.err.println(this.getClass().getSimpleName() + ": Unexpected Exception closing StringWriter.\r\n" + e2.getMessage() + "\r\n");
			e2.printStackTrace(System.err);
		}
		String msg = sw.toString();
		System.out.println(msg); // print since TestNG is only printing the first line of the message
		return msg;
	}

	protected <T> T makePostRequest(String url, List<NameValuePair> params, Class<T> clazz) throws InstantiationException,
			IllegalAccessException, IllegalStateException, IOException {
		HttpPost request = new HttpPost(url);
		request.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
		return makeRequest(request, clazz);
	}

	protected <T> T makeGetRequest(String url, List<NameValuePair> params, Class<T> clazz) throws IOException,
			InstantiationException, IllegalAccessException {
		String queryString = params != null ? URLEncodedUtils.format(params, "UTF-8") : "";
		URI u = URI.create(url + "?" + queryString);
		HttpGet request = new HttpGet(u);
		return makeRequest(request, clazz);
	}

}
