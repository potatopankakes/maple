package com.gnoras.maple.web.services;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.gnoras.maple.core.exceptions.UnauthorizedAccessException;
import com.gnoras.maple.core.interfaces.ILoginReservation;
import com.gnoras.maple.core.interfaces.ILoginSubsystem;
import com.gnoras.maple.core.interfaces.IProductPlanSubsystem;
import com.gnoras.maple.core.subsystems.LoginSubsystem;
import com.gnoras.maple.core.subsystems.ProductPlanSubsystem;
import com.gnoras.maple.dal.model.Currency;
import com.gnoras.maple.dal.model.Language;
import com.gnoras.maple.dal.model.Offering;
import com.gnoras.maple.dal.model.PlanText;
import com.gnoras.maple.dal.model.ProductPlan;
import com.gnoras.maple.dal.model.Purchase;
import com.gnoras.maple.dal.model.interfaces.IOffering;
import com.gnoras.maple.dal.model.interfaces.IPlanText;
import com.gnoras.maple.dal.model.interfaces.IProductPlan;
import com.gnoras.maple.dal.services.DataLayerMapleImpl;
import com.gnoras.maple.web.results.ErrorResponse;
import com.gnoras.maple.web.results.ExceptionResponse;
import com.gnoras.maple.web.results.Response;
import com.gnoras.maple.web.results.SuccessResponse;
import com.gnoras.maple.web.results.interfaces.IResponse;

import flexjson.JSONSerializer;

@Path("/ProductPlanSvcV1")
public class ProductPlanServiceImpl {

	private IProductPlanSubsystem pps;
	
	public void setProductPlanSubsystem(IProductPlanSubsystem value) {
		pps = value;
	}
	
	@POST
	@Produces("application/json")
	@Path("/create")
	public String createProductPlan(@FormParam("productPlanId") int planId,
			@FormParam("maxChildren") int maxChildren,
			@FormParam("maxChoreAlertsPerWk") int maxChoreAlertsPerWk,
			@FormParam("reportLevel") int reportLevel,
			@FormParam("rewardLevel") int rewardLevel,
			@FormParam("planWeeks") int planWeeks) throws UnauthorizedAccessException {
		JSONSerializer resultSerializer = new JSONSerializer().exclude(
				"*.class", "*.classType");
		pps.createProductPlan(planId, maxChildren,
				maxChoreAlertsPerWk, reportLevel, rewardLevel, planWeeks);

		return resultSerializer.serialize(new SuccessResponse());
	}

	@POST
	@Produces("application/json")
	@Path("/update")
	public String updateProductPlan(@FormParam("productPlanId") int planId,
			@FormParam("maxChildren") int maxChildren,
			@FormParam("maxChoreAlertsPerWk") int maxChoreAlertsPerWk,
			@FormParam("reportLevel") int reportLevel,
			@FormParam("rewardLevel") int rewardLevel,
			@FormParam("planWeeks") int planWeeks) throws Exception {
		JSONSerializer resultSerializer = new JSONSerializer().exclude(
				"*.class", "*.classType");
		pps.updateProductPlan(planId, maxChildren, maxChoreAlertsPerWk, reportLevel, rewardLevel, planWeeks);
		return resultSerializer.serialize(new SuccessResponse());
	}

	@POST
	@Produces("application/json")
	@Path("/delete")
	public String deleteProductPlan(@FormParam("productPlanId") int planId) {
		JSONSerializer resultSerializer = new JSONSerializer().exclude(
				"*.class", "*.classType");
		Boolean success = pps.deleteProductPlan(planId);
		return resultSerializer.serialize(new Response(success, success ? null : "Item could not be found."));
	}

	@GET
	@Produces("application/json")
	@Path("/list")
	public String listProductPlans() {
		JSONSerializer resultSerializer = new JSONSerializer().exclude(
				"*.class", "*.classType");
		List<IProductPlan> list = pps.listProductPlans();
		return resultSerializer.serialize(new SuccessResponse(list));
	}

	@GET
	@Produces("application/json")
	public String getProductPlan(@QueryParam("productPlanId") int planId) {
		JSONSerializer resultSerializer = new JSONSerializer().exclude(
				"*.class", "*.classType");
		IProductPlan pp = pps.getProductPlan(planId);
		return resultSerializer.serialize(new SuccessResponse(pp));
	}

	@POST
	@Produces("application/json")
	@Path("/text/create")
	public String createPlanText(@FormParam("planId") int planId,
			@FormParam("langId") int languageId,
			@FormParam("name") String planName,
			@FormParam("desc") String planDescription) {
		JSONSerializer resultSerializer = new JSONSerializer().exclude(
				"*.class", "*.classType");
		Serializable newID = pps.createPlanText(planId, languageId, planName, planDescription);
		return resultSerializer.serialize(new SuccessResponse(newID));
	}

	@POST
	@Produces("application/json")
	@Path("/text/update")
	public String updatePlanText(@FormParam("planId") int planId,
			@FormParam("langId") int languageId,
			@FormParam("name") String planName,
			@FormParam("desc") String planDescription) throws Exception {
		JSONSerializer resultSerializer = new JSONSerializer().exclude(
				"*.class", "*.classType");
		pps.updatePlanText(planId, languageId, planName, planDescription);
		return resultSerializer.serialize(new SuccessResponse());
	}

	@POST
	@Produces("application/json")
	@Path("/text/delete")
	public String deletePlanText(@FormParam("planId") int planId,
			@FormParam("langId") int languageId) {
		JSONSerializer resultSerializer = new JSONSerializer().exclude(
				"*.class", "*.classType");
		Boolean success = pps.deletePlanText(planId, languageId);
		return resultSerializer.serialize(new Response(success, success ? null : "Item could not be found."));
	}

	@SuppressWarnings("unchecked")
	@GET
	@Produces("application/json")
	@Path("/text/list")
	public String listPlanTexts(@QueryParam("planId") int planId) {
		JSONSerializer resultSerializer = new JSONSerializer().exclude(
				"*.class", "*.classType");
		List<IPlanText> list = pps.listPlanTexts(planId);
		return resultSerializer.serialize(new SuccessResponse(list));
	}

	@GET
	@Produces("application/json")
	public String getPlanText(@QueryParam("planId") int planId,
			@QueryParam("langId") int languageId) throws Exception {
		JSONSerializer resultSerializer = new JSONSerializer().exclude(
				"*.class", "*.classType");
		IPlanText pt = pps.getPlanText(planId, languageId);
		return resultSerializer.serialize(new SuccessResponse(pt));
	}

	@POST
	@Produces("application/json")
	@Path("/offer/create")
	public String createPlanOffering(@FormParam("planId") int planId,
			@FormParam("startDt") long startUtcDt,
			@FormParam("expireDt") long expireUtcDt,
			@FormParam("price") double price,
			@FormParam("currId") int currencyId) {
		JSONSerializer resultSerializer = new JSONSerializer().exclude(
				"*.class", "*.classType");
		String newId = pps.createPlanOffering(planId, startUtcDt, expireUtcDt, price, currencyId);
		return resultSerializer.serialize(new SuccessResponse(newId));
	}

	@POST
	@Produces("application/json")
	@Path("/offer/update")
	public String updatePlanOffering(@QueryParam("offerId") int offerId,
			@FormParam("planId") int planId,
			@FormParam("startDt") long startUtcDt,
			@FormParam("expireDt") long expireUtcDt,
			@FormParam("price") double price,
			@FormParam("currId") int currencyId) throws Exception {
		JSONSerializer resultSerializer = new JSONSerializer().exclude(
				"*.class", "*.classType");
		pps.updatePlanOffering(offerId, planId, startUtcDt, expireUtcDt, price, currencyId);
		return resultSerializer.serialize(new SuccessResponse());
	}

	@GET
	@Produces("application/json")
	@Path("/offer/list")
	public String listProductOfferings(@QueryParam("planId") int planId,
			@QueryParam("lt-startDt") long lessThanStartDt,
			@QueryParam("ge-startDt") long greaterThanOrEqualToStartDt,
			@QueryParam("lt-expireDt") long lessThanExpireDt,
			@QueryParam("ge-expireDt") long greaterThanOrEqualToExpireDt,
			@QueryParam("lt-price") double lessThanPrice,
			@QueryParam("ge-price") double greaterThanOrEqualToPrice,
			@QueryParam("currId") int currencyId) {
		JSONSerializer resultSerializer = new JSONSerializer().exclude(
				"*.class", "*.classType");
		List<IOffering> list = pps.listProductOfferings(planId, lessThanStartDt, greaterThanOrEqualToStartDt, lessThanExpireDt, greaterThanOrEqualToExpireDt, lessThanPrice, greaterThanOrEqualToPrice, currencyId);
		return resultSerializer.serialize(new SuccessResponse(list));
	}

	@GET
	@Produces("application/json")
	@Path("/offer")
	public String getProductOffering(@QueryParam("offerId") int offerId) {
		JSONSerializer resultSerializer = new JSONSerializer().exclude(
				"*.class", "*.classType");
		IOffering offering= pps.getProductOffering(offerId);
		return resultSerializer.serialize(new SuccessResponse(offering));
	}

	private void validateOfferingSearch(int planId,
			long lessThanStartDt,
			long greaterThanOrEqualToStartDt,
			long lessThanExpireDt,
			long greaterThanOrEqualToExpireDt,
			double lessThanPrice,
			double greaterThanOrEqualToPrice,
			int currencyId) throws IllegalArgumentException {
		validateProductPlanId(planId);
		if (lessThanStartDt < -1) {
			throw new IllegalArgumentException(
					"Offering Search must have 'Less than Start Date' greater than or equal to 0, or -1 (unspecified)");
		}
		if (greaterThanOrEqualToStartDt < -1) {
			throw new IllegalArgumentException(
					"Offering Search must have 'Greater than or equal to Start Date' greater than or equal to 0, or -1 (unspecified)");
		}
		if (lessThanExpireDt < -1) {
			throw new IllegalArgumentException(
					"Offering Search must have 'Less than Expire Date' greater than or equal to 0, or -1 (unspecified)");
		}
		if (greaterThanOrEqualToExpireDt < -1) {
			throw new IllegalArgumentException(
					"Offering Search must have 'Greater than or equal to Expire Date' greater than or equal to 0, or -1 (unspecified)");
		}
		if (lessThanPrice != -1.0 && lessThanPrice < 0.0) {
			throw new IllegalArgumentException(
					"Offering must have 'Less than Price' greater than or equal to 0 or -1 (unspecified)");
		}
		if (greaterThanOrEqualToPrice != -1.0
				&& greaterThanOrEqualToPrice < 0.0) {
			throw new IllegalArgumentException(
					"Offering must have 'Less than Price' greater than or equal to 0 or -1 (unspecified)");
		}
		if (currencyId != -1 && currencyId <= 0) {
			throw new IllegalArgumentException(
					"Offering must have 'CurrencyId' greater than 0 or -1(unspecified)");
		}
		if (currencyId == -1
				&& (lessThanPrice != -1 || greaterThanOrEqualToPrice != -1)) {
			throw new IllegalArgumentException(
					"Offering must have 'CurrencyId' must be set if price is specified");
		}
	}

	private void validateOffering(int planId,
			long startUtcDt,
			long expireUtcDt,
			double price,
			int currencyId) throws IllegalArgumentException {
		validateProductPlanId(planId);
		if (startUtcDt <= 0) {
			throw new IllegalArgumentException(
					"Offering must have 'Start Date' greater than 0");
		}
		if (expireUtcDt < 0) {
			throw new IllegalArgumentException(
					"Offering must have 'Expire Date' greater than or equal to 0");
		}
		if (expireUtcDt != 0 && expireUtcDt <= startUtcDt) {
			throw new IllegalArgumentException(
					"Offering must have 'Expire Date' greater than 'Start Date'");
		}
		if (price < 0) {
			throw new IllegalArgumentException(
					"Offering must have 'Price' greater than or equal to 0");
		}
		if (currencyId <= 0) {
			throw new IllegalArgumentException(
					"Offering must have 'CurrencyId' greater than 0");
		}
	}

	private void validateOfferingId(int offerId)
			throws IllegalArgumentException {
		if (offerId <= 0) {
			throw new IllegalArgumentException(
					"Offering must have 'id' greater than 0");
		}
	}

	private static void validateProductPlanId(int planId)
			throws IllegalArgumentException {
		if (planId <= 0) {
			throw new IllegalArgumentException(
					"Product plan must have 'id' greater than 0");
		}
	}

	private static void validateLanguageId(int languageId)
			throws IllegalArgumentException {
		if (!(languageId > 0)) {
			throw new IllegalArgumentException(
					"Language must have 'id' greater than 0");
		}
	}

	private static void validate(int maxChoreAlertsPerWk,
			int maxChildren,
			int reportLevel,
			int rewardLevel,
			int planWeeks,
			int planId) throws IllegalArgumentException {
		if (!(maxChoreAlertsPerWk >= 0)) {
			throw new IllegalArgumentException(
					"Product plan must have 'maxChoreAlertsPerWk' greater than or equal to 0");
		}
		if (!(maxChildren > 0)) {
			throw new IllegalArgumentException(
					"Product plan must have 'maxChildren' greater than 0");
		}
		if (!(reportLevel >= 0)) {
			throw new IllegalArgumentException(
					"Product plan must have 'reportLevel' greater than or equal to 0");
		}
		if (!(rewardLevel >= 0)) {
			throw new IllegalArgumentException(
					"Product plan must have 'rewardLevel' greater than or equal to 0");
		}
		if (!(planWeeks > 0)) {
			throw new IllegalArgumentException(
					"Product plan must have 'planWeeks' greater than 0");
		}
		validateProductPlanId(planId);
	}

	private void validate(int planId,
			int languageId,
			String planName,
			String planDescription) throws IllegalArgumentException {
		if (planName.length() == 0) {
			throw new IllegalArgumentException(
					"Product plan name cannot be empty");
		}
		if (planDescription.length() == 0) {
			throw new IllegalArgumentException(
					"Product plan description cannot be empty");
		}
		if (planDescription.length() == 0) {
			throw new IllegalArgumentException(
					"Product plan description cannot be empty");
		}
		validateLanguageId(languageId);
		validateProductPlanId(planId);
	}

}
