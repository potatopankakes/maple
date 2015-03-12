package com.gnoras.maple.itest.web.services.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gnoras.maple.itest.impl.MapleWebTestBase;
import com.gnoras.maple.itest.web.services.json.objects.JsonBasicResponse;

public class ProductPlanServiceTest extends MapleWebTestBase {
	 
	@Test(groups = { "productplan" })
	public void testCreate(String baseUrl, int productPlanId, int maxChildren, int maxChoreAlertsPerWk, int reportLevel, int rewardLevel, int planWeeks) throws IOException, InstantiationException, IllegalAccessException {
		
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("productPlanId", String.valueOf(productPlanId)));
		params.add(new BasicNameValuePair("maxChildren", String.valueOf(maxChildren)));
		params.add(new BasicNameValuePair("maxChoreAlertsPerWk", String.valueOf(maxChoreAlertsPerWk)));
		params.add(new BasicNameValuePair("reportLevel", String.valueOf(reportLevel)));
		params.add(new BasicNameValuePair("rewardLevel", String.valueOf(rewardLevel)));
		params.add(new BasicNameValuePair("planWeeks", String.valueOf(planWeeks)));
		
		JsonBasicResponse o = super.makePostRequest(baseUrl + "/svc/ProductPlanSvcV1/create", params, JsonBasicResponse.class);
		
		Assert.assertTrue(o.success, "Json response had success != true");
		Assert.assertNull(o.result, "Json response had a NON null result");
	}
 
}
