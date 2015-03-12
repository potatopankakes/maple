package com.gnoras.maple.dal.model.interfaces;
import com.gnoras.maple.dal.model.AccountProductPlan;
import com.gnoras.maple.dal.model.AccountProductPlanAdjustment;
import com.gnoras.maple.dal.model.Offering;
import com.gnoras.maple.dal.model.PlanText;
import java.util.Set;


/** 
 * Object interface mapping for hibernate-handled table: product_plan.
 * @author autogenerated
 */

public interface IProductPlan {



    /**
     * Return the value associated with the column: accountProductPlan.
	 * @return A Set&lt;AccountProductPlan&gt; object (this.accountProductPlan)
	 */
	Set<AccountProductPlan> getAccountProductPlans();
	
	/**
	 * Adds a bi-directional link of type AccountProductPlan to the accountProductPlans set.
	 * @param accountProductPlan item to add
	 */
	void addAccountProductPlan(AccountProductPlan accountProductPlan);

  
    /**  
     * Set the value related to the column: accountProductPlan.
	 * @param accountProductPlan the accountProductPlan value you wish to set
	 */
	void setAccountProductPlans(final Set<AccountProductPlan> accountProductPlan);

    /**
     * Return the value associated with the column: accountProductPlanAdjustment.
	 * @return A Set&lt;AccountProductPlanAdjustment&gt; object (this.accountProductPlanAdjustment)
	 */
	Set<AccountProductPlanAdjustment> getAccountProductPlanAdjustments();
	
	/**
	 * Adds a bi-directional link of type AccountProductPlanAdjustment to the accountProductPlanAdjustments set.
	 * @param accountProductPlanAdjustment item to add
	 */
	void addAccountProductPlanAdjustment(AccountProductPlanAdjustment accountProductPlanAdjustment);

  
    /**  
     * Set the value related to the column: accountProductPlanAdjustment.
	 * @param accountProductPlanAdjustment the accountProductPlanAdjustment value you wish to set
	 */
	void setAccountProductPlanAdjustments(final Set<AccountProductPlanAdjustment> accountProductPlanAdjustment);

    /**
     * Return the value associated with the column: createdAt.
	 * @return A Long object (this.createdAt)
	 */
	Long getCreatedAt();
	

  
    /**  
     * Set the value related to the column: createdAt.
	 * @param createdAt the createdAt value you wish to set
	 */
	void setCreatedAt(final Long createdAt);

    /**
     * Return the value associated with the column: deletedAt.
	 * @return A Long object (this.deletedAt)
	 */
	Long getDeletedAt();
	

  
    /**  
     * Set the value related to the column: deletedAt.
	 * @param deletedAt the deletedAt value you wish to set
	 */
	void setDeletedAt(final Long deletedAt);

    /**
     * Return the value associated with the column: id.
	 * @return A Integer object (this.id)
	 */
	Integer getId();
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	void setId(final Integer id);

    /**
     * Return the value associated with the column: maxChildren.
	 * @return A Integer object (this.maxChildren)
	 */
	Integer getMaxChildren();
	

  
    /**  
     * Set the value related to the column: maxChildren.
	 * @param maxChildren the maxChildren value you wish to set
	 */
	void setMaxChildren(final Integer maxChildren);

    /**
     * Return the value associated with the column: maxChoreAlertsPerWk.
	 * @return A Integer object (this.maxChoreAlertsPerWk)
	 */
	Integer getMaxChoreAlertsPerWk();
	

  
    /**  
     * Set the value related to the column: maxChoreAlertsPerWk.
	 * @param maxChoreAlertsPerWk the maxChoreAlertsPerWk value you wish to set
	 */
	void setMaxChoreAlertsPerWk(final Integer maxChoreAlertsPerWk);

    /**
     * Return the value associated with the column: offering.
	 * @return A Set&lt;Offering&gt; object (this.offering)
	 */
	Set<Offering> getOfferings();
	
	/**
	 * Adds a bi-directional link of type Offering to the offerings set.
	 * @param offering item to add
	 */
	void addOffering(Offering offering);

  
    /**  
     * Set the value related to the column: offering.
	 * @param offering the offering value you wish to set
	 */
	void setOfferings(final Set<Offering> offering);

    /**
     * Return the value associated with the column: planText.
	 * @return A Set&lt;PlanText&gt; object (this.planText)
	 */
	Set<PlanText> getPlanTexts();
	
	/**
	 * Adds a bi-directional link of type PlanText to the planTexts set.
	 * @param planText item to add
	 */
	void addPlanText(PlanText planText);

  
    /**  
     * Set the value related to the column: planText.
	 * @param planText the planText value you wish to set
	 */
	void setPlanTexts(final Set<PlanText> planText);

    /**
     * Return the value associated with the column: planDays.
	 * @return A Integer object (this.planDays)
	 */
	Integer getPlanDays();
	

  
    /**  
     * Set the value related to the column: planDays.
	 * @param planDays the planDays value you wish to set
	 */
	void setPlanDays(final Integer planDays);

    /**
     * Return the value associated with the column: reportLevel.
	 * @return A Integer object (this.reportLevel)
	 */
	Integer getReportLevel();
	

  
    /**  
     * Set the value related to the column: reportLevel.
	 * @param reportLevel the reportLevel value you wish to set
	 */
	void setReportLevel(final Integer reportLevel);

    /**
     * Return the value associated with the column: rewardLevel.
	 * @return A Integer object (this.rewardLevel)
	 */
	Integer getRewardLevel();
	

  
    /**  
     * Set the value related to the column: rewardLevel.
	 * @param rewardLevel the rewardLevel value you wish to set
	 */
	void setRewardLevel(final Integer rewardLevel);

	// end of interface
}