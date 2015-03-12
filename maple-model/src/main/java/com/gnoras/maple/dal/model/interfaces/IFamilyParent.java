package com.gnoras.maple.dal.model.interfaces;
import com.gnoras.maple.dal.model.Family;
import com.gnoras.maple.dal.model.Parent;


/** 
 * Object interface mapping for hibernate-handled table: family_parent.
 * @author autogenerated
 */

public interface IFamilyParent {



    /**
     * Return the value associated with the column: family.
	 * @return A Family object (this.family)
	 */
	Family getFamily();
	

  
    /**  
     * Set the value related to the column: family.
	 * @param family the family value you wish to set
	 */
	void setFamily(final Family family);

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
     * Return the value associated with the column: parent.
	 * @return A Parent object (this.parent)
	 */
	Parent getParent();
	

  
    /**  
     * Set the value related to the column: parent.
	 * @param parent the parent value you wish to set
	 */
	void setParent(final Parent parent);

	// end of interface
}