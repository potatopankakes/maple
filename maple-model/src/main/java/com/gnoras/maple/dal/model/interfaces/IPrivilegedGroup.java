package com.gnoras.maple.dal.model.interfaces;
import com.gnoras.maple.dal.model.Group;
import com.gnoras.maple.dal.model.Privilege;


/** 
 * Object interface mapping for hibernate-handled table: privileged_group.
 * @author autogenerated
 */

public interface IPrivilegedGroup {



    /**
     * Return the value associated with the column: group.
	 * @return A Group object (this.group)
	 */
	Group getGroup();
	

  
    /**  
     * Set the value related to the column: group.
	 * @param group the group value you wish to set
	 */
	void setGroup(final Group group);

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
     * Return the value associated with the column: privilege.
	 * @return A Privilege object (this.privilege)
	 */
	Privilege getPrivilege();
	

  
    /**  
     * Set the value related to the column: privilege.
	 * @param privilege the privilege value you wish to set
	 */
	void setPrivilege(final Privilege privilege);

	// end of interface
}