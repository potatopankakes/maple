package com.gnoras.maple.dal.model.interfaces;
import com.gnoras.maple.dal.model.ChoreAssignment;
import com.gnoras.maple.dal.model.FamilyParent;
import com.gnoras.maple.dal.model.User;
import java.util.Set;


/** 
 * Object interface mapping for hibernate-handled table: parent.
 * @author autogenerated
 */

public interface IParent {



    /**
     * Return the value associated with the column: choreAssignment.
	 * @return A Set&lt;ChoreAssignment&gt; object (this.choreAssignment)
	 */
	Set<ChoreAssignment> getChoreAssignments();
	
	/**
	 * Adds a bi-directional link of type ChoreAssignment to the choreAssignments set.
	 * @param choreAssignment item to add
	 */
	void addChoreAssignment(ChoreAssignment choreAssignment);

  
    /**  
     * Set the value related to the column: choreAssignment.
	 * @param choreAssignment the choreAssignment value you wish to set
	 */
	void setChoreAssignments(final Set<ChoreAssignment> choreAssignment);

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
     * Return the value associated with the column: user.
	 * @return A User object (this.user)
	 */
	User getUser();
	

  
    /**  
     * Set the value related to the column: user.
	 * @param user the user value you wish to set
	 */
	void setUser(final User user);

	// end of interface
}