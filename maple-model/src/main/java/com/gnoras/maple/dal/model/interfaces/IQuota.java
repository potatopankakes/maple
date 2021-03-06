package com.gnoras.maple.dal.model.interfaces;


/** 
 * Object interface mapping for hibernate-handled table: quota.
 * @author autogenerated
 */

public interface IQuota {



    /**
     * Return the value associated with the column: choreAlertsUsedThisWk.
	 * @return A Integer object (this.choreAlertsUsedThisWk)
	 */
	Integer getChoreAlertsUsedThisWk();
	

  
    /**  
     * Set the value related to the column: choreAlertsUsedThisWk.
	 * @param choreAlertsUsedThisWk the choreAlertsUsedThisWk value you wish to set
	 */
	void setChoreAlertsUsedThisWk(final Integer choreAlertsUsedThisWk);

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
     * Return the value associated with the column: maxChoreAlertsThisWeek.
	 * @return A Integer object (this.maxChoreAlertsThisWeek)
	 */
	Integer getMaxChoreAlertsThisWeek();
	

  
    /**  
     * Set the value related to the column: maxChoreAlertsThisWeek.
	 * @param maxChoreAlertsThisWeek the maxChoreAlertsThisWeek value you wish to set
	 */
	void setMaxChoreAlertsThisWeek(final Integer maxChoreAlertsThisWeek);

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