package com.gnoras.maple.itest.web.services.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gnoras.maple.itest.impl.MapleWebTestBase;
import com.gnoras.maple.itest.web.services.json.objects.JsonLanguage;
import com.gnoras.maple.itest.web.services.json.objects.JsonLanguageListResponse;

public class LanguageServiceTest extends MapleWebTestBase {

	@Test(groups = { "language" })
	@Parameters({ "baseUrl" })
	public void testList(String baseUrl) throws IOException, InstantiationException, IllegalAccessException {

		JsonLanguageListResponse o = super.makeGetRequest(baseUrl + "/svc/language/list", null, JsonLanguageListResponse.class);
				
		Assert.assertTrue(o.success, "Json response had success != true");
		Assert.assertNotNull(o.result, "Json response had a null result");
		Assert.assertTrue(o.result.size() > 0, "Json response result had zero languages");
		int i = 0;
		for (JsonLanguage language : o.result) {
			Assert.assertNotNull(language, "Json response result had null language for item " + i);
			Assert.assertTrue(language.id > 0, "Json response result had an invalid id " + language.id
					+ " for language item " + i);
			Assert.assertEquals(language.iso693A3.length(), 3,
					"Json response result had an invalid size for the ISO code " + language.iso693A3 + " for language item "
							+ i++);
		}
	}
}