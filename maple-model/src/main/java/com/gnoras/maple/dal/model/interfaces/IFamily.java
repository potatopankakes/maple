package com.gnoras.maple.dal.model.interfaces;
import com.gnoras.maple.dal.model.Account;
import com.gnoras.maple.dal.model.Chore;
import com.gnoras.maple.dal.model.FamilyChild;
import com.gnoras.maple.dal.model.FamilyParent;
import com.gnoras.maple.dal.model.RewardPolicy;
import com.gnoras.maple.dal.model.RewardType;
import java.util.Set;


/** 
 * Object interface mapping for hibernate-handled table: family.
 * @author autogenerated
 */

public interface IFamily {



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
     * Return the value associated with the column: chore.
	 * @return A Set&lt;Chore&gt; object (this.chore)
	 */
	Set<Chore> getChores();
	
	/**
	 * Adds a bi-directional link of type Chore to the chores set.
	 * @param chore item to add
	 */
	void addChore(Chore chore);

  
    /**  
     * Set the value related to the column: chore.
	 * @param chore the chore value you wish to set
	 */
	void setChores(final Set<Chore> chore);

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
     * Return the value associated with the column: familyChild.
	 * @return A Set&lt;FamilyChild&gt; object (this.familyChild)
	 */
	Set<FamilyChild> getFamilyChilds();
	
	/**
	 * Adds a bi-directional link of type FamilyChild to the familyChilds set.
	 * @param familyChild item to add
	 */
	void addFamilyChild(FamilyChild familyChild);

  
    /**  
     * Set the value related to the column: familyChild.
	 * @param familyChild the familyChild value you wish to set
	 */
	void setFamilyChilds(final Set<FamilyChild> familyChild);

    /**
     * Return the value associated with the column: familyParent.
	 * @return A Set&lt;FamilyParent&gt; object (this.familyParent)
	 */
	Set<FamilyParent> getFamilyParents();
	
	/**
	 * Adds a bi-directional link of type FamilyParent to the familyParents set.
	 * @param familyParent item to add
	 */
	void addFamilyParent(FamilyParent familyParent);

  
    /**  
     * Set the value related to the column: familyParent.
	 * @param familyParent the familyParent value you wish to set
	 */
	void setFamilyParents(final Set<FamilyParent> familyParent);

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
     * Return the value associated with the column: name.
	 * @return A String object (this.name)
	 */
	String getName();
	

  
    /**  
     * Set the value related to the column: name.
	 * @param name the name value you wish to set
	 */
	void setName(final String name);

    /**
     * Return the value associated with the column: rewardPolicy.
	 * @return A Set&lt;RewardPolicy&gt; object (this.rewardPolicy)
	 */
	Set<RewardPolicy> getRewardPolicies();
	
	/**
	 * Adds a bi-directional link of type RewardPolicy to the rewardPolicies set.
	 * @param rewardPolicy item to add
	 */
	void addRewardPolicy(RewardPolicy rewardPolicy);

  
    /**  
     * Set the value related to the column: rewardPolicy.
	 * @param rewardPolicy the rewardPolicy value you wish to set
	 */
	void setRewardPolicies(final Set<RewardPolicy> rewardPolicy);

    /**
     * Return the value associated with the column: rewardType.
	 * @return A Set&lt;RewardType&gt; object (this.rewardType)
	 */
	Set<RewardType> getRewardTypes();
	
	/**
	 * Adds a bi-directional link of type RewardType to the rewardTypes set.
	 * @param rewardType item to add
	 */
	void addRewardType(RewardType rewardType);

  
    /**  
     * Set the value related to the column: rewardType.
	 * @param rewardType the rewardType value you wish to set
	 */
	void setRewardTypes(final Set<RewardType> rewardType);

	// end of interface
}