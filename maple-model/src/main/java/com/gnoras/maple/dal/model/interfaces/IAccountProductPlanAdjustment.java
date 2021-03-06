package com.gnoras.maple.dal.model.interfaces;
import com.gnoras.maple.dal.model.Account;
import com.gnoras.maple.dal.model.ProductPlan;


/** 
 * Object interface mapping for hibernate-handled table: account_product_plan_adjustment.
 * @author autogenerated
 */

public interface IAccountProductPlanAdjustment {



    /**
     * Return the value associated with the column: account.
	 * @return A Account object (this.account)
	 */
	Account getAccount();
	

  
    /**  
     * Set the value related to the column: account.
	 * @param account the account value you wish to set
	 */
	void setAccount(final Account account);

    /**
     * Return the value associated with the column: daysSpanned.
	 * @return A Integer object (this.daysSpanned)
	 */
	Integer getDaysSpanned();
	

  
    /**  
     * Set the value related to the column: daysSpanned.
	 * @param daysSpanned the daysSpanned value you wish to set
	 */
	void setDaysSpanned(final Integer daysSpanned);

    /**
     * Return the value associated with the column: id.
	 * @return A String object (this.id)
	 */
	String getId();
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	void setId(final String id);

    /**
     * Return the value associated with the column: productPlan.
	 * @return A ProductPlan object (this.productPlan)
	 */
	ProductPlan getProductPlan();
	

  
    /**  
     * Set the value related to the column: productPlan.
	 * @param productPlan the productPlan value you wish to set
	 */
	void setProductPlan(final ProductPlan productPlan);

    /**
     * Return the value associated with the column: startAt.
	 * @return A Long object (this.startAt)
	 */
	Long getStartAt();
	

  
    /**  
     * Set the value related to the column: startAt.
	 * @param startAt the startAt value you wish to set
	 */
	void setStartAt(final Long startAt);

	// end of interface
}