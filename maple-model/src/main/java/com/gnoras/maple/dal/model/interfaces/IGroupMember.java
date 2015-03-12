package com.gnoras.maple.dal.model.interfaces;
import com.gnoras.maple.dal.model.Group;
import com.gnoras.maple.dal.model.User;


/** 
 * Object interface mapping for hibernate-handled table: group_member.
 * @author autogenerated
 */

public interface IGroupMember {



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