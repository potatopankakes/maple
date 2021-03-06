package com.gnoras.maple.dal.model.interfaces;
import com.gnoras.maple.dal.model.Child;
import com.gnoras.maple.dal.model.EmailAddress;
import com.gnoras.maple.dal.model.GroupMember;
import com.gnoras.maple.dal.model.Parent;
import java.util.Set;


/** 
 * Object interface mapping for hibernate-handled table: user.
 * @author autogenerated
 */

public interface IUser {



    /**
     * Return the value associated with the column: child.
	 * @return A Set&lt;Child&gt; object (this.child)
	 */
	Set<Child> getChildren();
	
	/**
	 * Adds a bi-directional link of type Child to the children set.
	 * @param child item to add
	 */
	void addChild(Child child);

  
    /**  
     * Set the value related to the column: child.
	 * @param child the child value you wish to set
	 */
	void setChildren(final Set<Child> child);

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
     * Return the value associated with the column: emailAddress.
	 * @return A Set&lt;EmailAddress&gt; object (this.emailAddress)
	 */
	Set<EmailAddress> getEmailAddresses();
	
	/**
	 * Adds a bi-directional link of type EmailAddress to the emailAddresses set.
	 * @param emailAddress item to add
	 */
	void addEmailAddress(EmailAddress emailAddress);

  
    /**  
     * Set the value related to the column: emailAddress.
	 * @param emailAddress the emailAddress value you wish to set
	 */
	void setEmailAddresses(final Set<EmailAddress> emailAddress);

    /**
     * Return the value associated with the column: groupMember.
	 * @return A Set&lt;GroupMember&gt; object (this.groupMember)
	 */
	Set<GroupMember> getGroupMembers();
	
	/**
	 * Adds a bi-directional link of type GroupMember to the groupMembers set.
	 * @param groupMember item to add
	 */
	void addGroupMember(GroupMember groupMember);

  
    /**  
     * Set the value related to the column: groupMember.
	 * @param groupMember the groupMember value you wish to set
	 */
	void setGroupMembers(final Set<GroupMember> groupMember);

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
     * Return the value associated with the column: parent.
	 * @return A Set&lt;Parent&gt; object (this.parent)
	 */
	Set<Parent> getParents();
	
	/**
	 * Adds a bi-directional link of type Parent to the parents set.
	 * @param parent item to add
	 */
	void addParent(Parent parent);

  
    /**  
     * Set the value related to the column: parent.
	 * @param parent the parent value you wish to set
	 */
	void setParents(final Set<Parent> parent);

    /**
     * Return the value associated with the column: password.
	 * @return A Byte[] object (this.password)
	 */
	Byte[] getPassword();
	

  
    /**  
     * Set the value related to the column: password.
	 * @param password the password value you wish to set
	 */
	void setPassword(final Byte[] password);

    /**
     * Return the value associated with the column: salt.
	 * @return A Byte[] object (this.salt)
	 */
	Byte[] getSalt();
	

  
    /**  
     * Set the value related to the column: salt.
	 * @param salt the salt value you wish to set
	 */
	void setSalt(final Byte[] salt);

	// end of interface
}