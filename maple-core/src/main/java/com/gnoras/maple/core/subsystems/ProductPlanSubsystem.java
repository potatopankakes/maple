package com.gnoras.maple.core.subsystems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.gnoras.maple.core.constants.SystemPrivileges;
import com.gnoras.maple.core.exceptions.UnauthorizedAccessException;
import com.gnoras.maple.core.interfaces.IAuthorizationSubsystem;
import com.gnoras.maple.core.interfaces.ILoginSubsystem;
import com.gnoras.maple.core.interfaces.IProductPlanSubsystem;
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

public class ProductPlanSubsystem implements IProductPlanSubsystem {

	private int timeout = 5000;

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int t) {
		timeout = t;
	}

	private ILoginSubsystem loginSubsystem;

	public ILoginSubsystem getLoginSubsystem() {
		return loginSubsystem;
	}

	public void setLoginSubsystem(ILoginSubsystem ss) {
		loginSubsystem = ss;
	}

	@Override
	public void createProductPlan(int planId,
			int maxChildren,
			int maxChoreAlertsPerWk,
			int reportLevel,
			int rewardLevel,
			int planWeeks) throws UnauthorizedAccessException {
		
		IAuthorizationSubsystem ia = new AuthorizationSubsystem();
		// TODO put in a valid RequestContext
		if ( !ia.havePrivilege(SystemPrivileges.privCreatePlans, null) ) {
			throw new UnauthorizedAccessException("No privileges to create a Product Plan. ");
		}

		validate(maxChoreAlertsPerWk, maxChildren, reportLevel, rewardLevel,
				planWeeks, planId);

		ProductPlan prod = new ProductPlan(new Date().getTime(), 0L, planId,
				maxChildren, maxChoreAlertsPerWk, planWeeks * 7, reportLevel,
				rewardLevel);

		Serializable newID = DataLayerMapleImpl.getInstance().save(prod);
	}

	@Override
	public void updateProductPlan(int planId,
			int maxChildren,
			int maxChoreAlertsPerWk,
			int reportLevel,
			int rewardLevel,
			int planWeeks) throws Exception {
		// TODO check logged in user is allowed to update plans

		validate(maxChoreAlertsPerWk, maxChildren, reportLevel, rewardLevel,
				planWeeks, planId);

		// verify that the product plan exists and is not deleted
		Criteria criteria = DataLayerMapleImpl.getInstance().createCriteria(
				ProductPlan.class);
		criteria.setTimeout(getTimeout());
		criteria.add(Restrictions.eq("product_plan_id", planId)).add(
				Restrictions.eq("deleted_at", 0L));
		ProductPlan prod = (ProductPlan) criteria.uniqueResult();

		if (prod != null) {
			// see if any offerings have started
			boolean existsPurchase = DataLayerMapleImpl.getInstance()
					.createCriteria(Purchase.class)
					.createAlias("Offering", "o")
					.createAlias("o.ProductPlan", "p")
					.add(Restrictions.eq("p.id", prod.getId()))
					.setProjection(Projections.rowCount()).setReadOnly(true)
					.setLockMode(LockMode.NONE).uniqueResult().toString()
					.equals("0");

			if (existsPurchase) {
				throw new Exception(
						"Purchase of the Product Plan does not exist, so it cannot be updated.");
			} else {
				prod.setMaxChildren(maxChildren);
				prod.setMaxChoreAlertsPerWk(maxChoreAlertsPerWk);
				prod.setPlanDays(planWeeks * 7);
				prod.setReportLevel(reportLevel);
				prod.setRewardLevel(rewardLevel);

				DataLayerMapleImpl.getInstance().update(prod);

				// TOOD consider these questions:
				// create an update date?
				// or should i just do a update log for those entities?...
				// probably best

			}
		} else {
			throw new Exception("Product Plan does not exist. ");
		}
	}

	@Override
	public Boolean deleteProductPlan(int planId) {
		// TODO check logged in user is allowed to delete plans

		validateProductPlanId(planId);

		Criteria criteria = DataLayerMapleImpl.getInstance().createCriteria(
				ProductPlan.class);
		criteria.setTimeout(getTimeout());
		criteria.add(Restrictions.eq("product_plan_id", planId)).add(
				Restrictions.eq("deleted_at", 0L));
		ProductPlan prod = (ProductPlan) criteria.uniqueResult();
		if (prod != null) {
			prod.setDeletedAt(new Date().getTime());

			DataLayerMapleImpl.getInstance().update(prod);
		}
		else {
			return false;
		}

		return true;
	}

	@Override
	public List<IProductPlan> listProductPlans() {
		@SuppressWarnings("unchecked")
		List<ProductPlan> list = (List<ProductPlan>) DataLayerMapleImpl
				.getInstance().createCriteria(ProductPlan.class).list();
		List<IProductPlan> finalList = new ArrayList<IProductPlan>(list.size());
		for (IProductPlan pp : list) {
			finalList.add(pp);
		}
		return finalList;
	}

	@Override
	public ProductPlan getProductPlan(int planId) {
		// TODO check logged in user is allowed to delete plans

		validateProductPlanId(planId);

		ProductPlan prod = DataLayerMapleImpl.getInstance().loadProductPlan(
				planId);
		return prod;
	}

	@Override
	public String createPlanText(int planId,
			int languageId,
			String planName,
			String planDescription) {
		// TODO check logged in user is allowed to add plan text

		validate(planId, languageId, planName, planDescription);

		// TODO add criteria to not create plan text for deleted plans
		PlanText planText = new PlanText();
		planText.setCreatedAt(new Date().getTime());
		planText.setDeletedAt(0L);
		planText.setPlanDescription(planDescription);
		planText.setPlanName(planName);
		planText.setLanguage(new Language(languageId));
		planText.setProductPlan(new ProductPlan(planId));

		Serializable newID = DataLayerMapleImpl.getInstance().save(planText);
		return newID.toString();
	}

	@Override
	public void updatePlanText(int planId,
			int languageId,
			String planName,
			String planDescription) throws Exception {
		// TODO check logged in user is allowed to update plan text

		validate(planId, languageId, planName, planDescription);

		// TODO add criteria to not update plan text for deleted plans
		Criteria criteria = DataLayerMapleImpl.getInstance().createCriteria(
				PlanText.class);
		criteria.setTimeout(getTimeout());
		criteria.add(Restrictions.eq("product_plan_id", planId))
				.add(Restrictions.eq("language_id", languageId))
				.add(Restrictions.eq("deleted_at", 0L));
		PlanText planText = (PlanText) criteria.uniqueResult();
		if (planText != null) {
			planText.setPlanDescription(planDescription);
			planText.setPlanName(planName);

			DataLayerMapleImpl.getInstance().update(planText);

		} else {
			throw new Exception("Plan Text does not exist. ");
		}
	}

	@Override
	public boolean deletePlanText(int planId, int languageId) {
		// TODO check logged in user is allowed to delete plan text

		validateProductPlanId(planId);
		validateLanguageId(languageId);

		// TODO add criteria to not update plan text for deleted plans
		Criteria criteria = DataLayerMapleImpl.getInstance().createCriteria(
				PlanText.class);
		criteria.setTimeout(getTimeout());
		criteria.add(Restrictions.eq("product_plan_id", planId))
				.add(Restrictions.eq("language_id", languageId))
				.add(Restrictions.eq("deleted_at", 0L));
		PlanText planText = (PlanText) criteria.uniqueResult();
		if (planText != null) {
			planText.setDeletedAt(new Date().getTime());

			DataLayerMapleImpl.getInstance().update(planText);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<IPlanText> listPlanTexts(int planId) {
		// TODO check logged in user is allowed to delete plan text

		validateProductPlanId(planId);

		Criteria criteria = DataLayerMapleImpl.getInstance().createCriteria(
				PlanText.class);
		criteria.setTimeout(getTimeout());
		criteria.add(Restrictions.eq("product_plan_id", planId)).add(
				Restrictions.eq("deleted_at", 0L));
		@SuppressWarnings("unchecked")
		List<PlanText> list = (List<PlanText>) criteria.list();

		List<IPlanText> finalList = new ArrayList<IPlanText>(list.size());
		for (IPlanText pp : list) {
			finalList.add(pp);
		}
		return finalList;
	}

	@Override
	public IPlanText getPlanText(int planId, int languageId) throws Exception {
		// TODO check logged in user is allowed to delete plan text

		validateProductPlanId(planId);
		validateLanguageId(languageId);

		Criteria criteria = DataLayerMapleImpl.getInstance().createCriteria(
				PlanText.class);
		criteria.setTimeout(getTimeout());
		criteria.add(Restrictions.eq("product_plan_id", planId))
				.add(Restrictions.eq("language_id", languageId))
				.add(Restrictions.eq("deleted_at", 0L));
		PlanText planText = (PlanText) criteria.uniqueResult();

		if (planText != null) {
			return planText;
		} else {
			throw new Exception("Plan Text does not exist. ");
		}
	}

	@Override
	public String createPlanOffering(int planId,
			long startUtcDt,
			long expireUtcDt,
			double price,
			int currencyId) {
		// TODO check logged in user is allowed to create an offering

		validateOffering(planId, startUtcDt, expireUtcDt, price, currencyId);

		// add criteria to not create plan text for deleted plans

		Offering offering = new Offering();
		offering.setStartAt(new Date().getTime());
		offering.setExpireAt(0L);
		offering.setPrice(price);
		offering.setCurrency(new Currency(currencyId));
		offering.setProductPlan(new ProductPlan(planId));

		Serializable newID = DataLayerMapleImpl.getInstance().save(offering);

		return newID.toString();
	}

	@Override
	public void updatePlanOffering(int offerId,
			int planId,
			long startUtcDt,
			long expireUtcDt,
			double price,
			int currencyId) throws Exception {
		// TODO check logged in user is allowed to update an offering

		validateOffering(planId, startUtcDt, expireUtcDt, price, currencyId);
		validateOfferingId(offerId);

		Offering offering = DataLayerMapleImpl.getInstance().loadOffering(
				offerId);

		// if offering has NOT expired, then consider updating
		if (offering.getExpireAt() > (new Date().getTime())) {

			// TODO make sure the product plan is not deleted

			if (planId != offering.getProductPlan().getId()
					&& DataLayerMapleImpl.getInstance()
							.createCriteria(Purchase.class)
							.add(Restrictions.eq("offering_id", offerId))
							.setProjection(Projections.rowCount())
							.setReadOnly(true).setLockMode(LockMode.NONE)
							.uniqueResult().toString().equals("0")) {
				// someone has the offering, then error out
				throw new Exception(
						"Offering has customers, so the plan can't be changed");
			} else {
				offering.setStartAt(startUtcDt);
				offering.setExpireAt(expireUtcDt);
				offering.setPrice(price);
				offering.setCurrency(new Currency(currencyId));
				offering.setProductPlan(new ProductPlan(planId));
				DataLayerMapleImpl.getInstance().update(offering);

			}
		} else {
			throw new Exception("Offering has expired, it can't be changed");
		}
	}

	@Override
	public List<IOffering> listProductOfferings(int planId,
			long lessThanStartDt,
			long greaterThanOrEqualToStartDt,
			long lessThanExpireDt,
			long greaterThanOrEqualToExpireDt,
			double lessThanPrice,
			double greaterThanOrEqualToPrice,
			int currencyId) {
		// TODO check logged in user is allowed to list an offering

		validateOfferingSearch(planId, lessThanStartDt,
				greaterThanOrEqualToStartDt, lessThanExpireDt,
				greaterThanOrEqualToExpireDt, lessThanPrice,
				greaterThanOrEqualToPrice, currencyId);

		// TODO list all offerings that have not expired and have started

		return null;
	}

	@Override
	public IOffering getProductOffering(int offerId) {
		// check logged in user is allowed to update an offering

		validateOfferingId(offerId);
		Offering offering = DataLayerMapleImpl.getInstance().loadOffering(
				offerId);
		return offering;
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
