package com.gnoras.maple.core.interfaces;

import java.util.List;

import com.gnoras.maple.core.exceptions.UnauthorizedAccessException;
import com.gnoras.maple.dal.model.interfaces.IOffering;
import com.gnoras.maple.dal.model.interfaces.IPlanText;
import com.gnoras.maple.dal.model.interfaces.IProductPlan;

public interface IProductPlanSubsystem {

	public IOffering getProductOffering(int offerId);

	public List<IOffering> listProductOfferings(int planId,
			long lessThanStartDt,
			long greaterThanOrEqualToStartDt,
			long lessThanExpireDt,
			long greaterThanOrEqualToExpireDt,
			double lessThanPrice,
			double greaterThanOrEqualToPrice,
			int currencyId);

	public void updatePlanOffering(int offerId,
			int planId,
			long startUtcDt,
			long expireUtcDt,
			double price,
			int currencyId) throws Exception;

	public String createPlanOffering(int planId, long startUtcDt, long expireUtcDt, double price, int currencyId);

	public IPlanText getPlanText(int planId, int languageId) throws Exception;

	public List<IPlanText> listPlanTexts(int planId);

	public boolean deletePlanText(int planId, int languageId);

	public void updatePlanText(int planId, int languageId, String planName, String planDescription) throws Exception;

	public String createPlanText(int planId, int languageId, String planName, String planDescription);

	public IProductPlan getProductPlan(int planId);

	public List<IProductPlan> listProductPlans();

	public Boolean deleteProductPlan(int planId);

	public void updateProductPlan(int planId,
			int maxChildren,
			int maxChoreAlertsPerWk,
			int reportLevel,
			int rewardLevel,
			int planWeeks) throws Exception;

	public void createProductPlan(int planId,
			int maxChildren,
			int maxChoreAlertsPerWk,
			int reportLevel,
			int rewardLevel,
			int planWeeks) throws UnauthorizedAccessException;

}
