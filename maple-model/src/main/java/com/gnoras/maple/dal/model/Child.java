package com.gnoras.maple.dal.model;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import com.felees.hbnpojogen.persistence.validator.Mandatory;
import com.gnoras.maple.dal.model.ChoreAssignment;
import com.gnoras.maple.dal.model.FamilyChild;
import com.gnoras.maple.dal.model.RecurringChoreAssignment;
import com.gnoras.maple.dal.model.interfaces.IChild;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.validator.Length;
import org.hibernate.validator.Valid;


/** 
 * Object mapping for hibernate-handled table: child.
 * @author autogenerated
 */

@Entity
@Table(name = "child", catalog = "maple")
public class Child implements Cloneable, Serializable, IPojoGenEntity, IChild {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559024046L;
	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, String> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, String>());
	
	/** hashCode temporary storage. */
	private volatile String hashCode;
	

	/** Field mapping. */
	private Set<ChoreAssignment> choreAssignments = new HashSet<ChoreAssignment>();

	/** Field mapping. */
	private Long createdAt;
	/** Field mapping. */
	private Long deletedAt;
	/** Field mapping. */
	private Set<FamilyChild> familyChilds = new HashSet<FamilyChild>();

	/** Field mapping. */
	private String id;
	/** Field mapping. */
	private String name;
	/** Field mapping. */
	private Set<RecurringChoreAssignment> recurringChoreAssignments = new HashSet<RecurringChoreAssignment>();

	/** Field mapping. */
	private User user;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Child() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Child(String id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param createdAt Long object;
	 * @param deletedAt Long object;
	 * @param id String object;
	 */
	public Child(Long createdAt, Long deletedAt, String id) {

		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
		this.id = id;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Child.class;
	}
 

    /**
     * Return the value associated with the column: choreAssignment.
	 * @return A Set&lt;ChoreAssignment&gt; object (this.choreAssignment)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "child"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Valid
	public Set<ChoreAssignment> getChoreAssignments() {
		return this.choreAssignments;
		
	}
	
	/**
	 * Adds a bi-directional link of type ChoreAssignment to the choreAssignments set.
	 * @param choreAssignment item to add
	 */
	public void addChoreAssignment(ChoreAssignment choreAssignment) {
		choreAssignment.setChild(this);
		this.choreAssignments.add(choreAssignment);
	}

  
    /**  
     * Set the value related to the column: choreAssignment.
	 * @param choreAssignment the choreAssignment value you wish to set
	 */
	public void setChoreAssignments(final Set<ChoreAssignment> choreAssignment) {
		this.choreAssignments = choreAssignment;
	}

    /**
     * Return the value associated with the column: createdAt.
	 * @return A Long object (this.createdAt)
	 */
	@Mandatory
	@Column( name = "created_at"  )
	public Long getCreatedAt() {
		return this.createdAt;
		
	}
	

  
    /**  
     * Set the value related to the column: createdAt.
	 * @param createdAt the createdAt value you wish to set
	 */
	public void setCreatedAt(final Long createdAt) {
		this.createdAt = createdAt;
	}

    /**
     * Return the value associated with the column: deletedAt.
	 * @return A Long object (this.deletedAt)
	 */
	@Mandatory
	@Column( name = "deleted_at"  )
	public Long getDeletedAt() {
		return this.deletedAt;
		
	}
	

  
    /**  
     * Set the value related to the column: deletedAt.
	 * @param deletedAt the deletedAt value you wish to set
	 */
	public void setDeletedAt(final Long deletedAt) {
		this.deletedAt = deletedAt;
	}

    /**
     * Return the value associated with the column: familyChild.
	 * @return A Set&lt;FamilyChild&gt; object (this.familyChild)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "child"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Valid
	public Set<FamilyChild> getFamilyChilds() {
		return this.familyChilds;
		
	}
	
	/**
	 * Adds a bi-directional link of type FamilyChild to the familyChilds set.
	 * @param familyChild item to add
	 */
	public void addFamilyChild(FamilyChild familyChild) {
		familyChild.setChild(this);
		this.familyChilds.add(familyChild);
	}

  
    /**  
     * Set the value related to the column: familyChild.
	 * @param familyChild the familyChild value you wish to set
	 */
	public void setFamilyChilds(final Set<FamilyChild> familyChild) {
		this.familyChilds = familyChild;
	}

    /**
     * Return the value associated with the column: id.
	 * @return A String object (this.id)
	 */
    @Id 
	@Mandatory
	@Length(max=36)
	@Column( name = "id", length = 36  )
	public String getId() {
		return this.id;
		
	}
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final String id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null ) &&
				(id != null) &&
				(this.hashCode != null) ) {
			SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

    /**
     * Return the value associated with the column: name.
	 * @return A String object (this.name)
	 */
	@Length(max=50)
	@Column( length = 50  )
	public String getName() {
		return this.name;
		
	}
	

  
    /**  
     * Set the value related to the column: name.
	 * @param name the name value you wish to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

    /**
     * Return the value associated with the column: recurringChoreAssignment.
	 * @return A Set&lt;RecurringChoreAssignment&gt; object (this.recurringChoreAssignment)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "child"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Valid
	public Set<RecurringChoreAssignment> getRecurringChoreAssignments() {
		return this.recurringChoreAssignments;
		
	}
	
	/**
	 * Adds a bi-directional link of type RecurringChoreAssignment to the recurringChoreAssignments set.
	 * @param recurringChoreAssignment item to add
	 */
	public void addRecurringChoreAssignment(RecurringChoreAssignment recurringChoreAssignment) {
		recurringChoreAssignment.setChild(this);
		this.recurringChoreAssignments.add(recurringChoreAssignment);
	}

  
    /**  
     * Set the value related to the column: recurringChoreAssignment.
	 * @param recurringChoreAssignment the recurringChoreAssignment value you wish to set
	 */
	public void setRecurringChoreAssignments(final Set<RecurringChoreAssignment> recurringChoreAssignment) {
		this.recurringChoreAssignments = recurringChoreAssignment;
	}

    /**
     * Return the value associated with the column: user.
	 * @return A User object (this.user)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "user_id", nullable = true  )
	@Valid
	public User getUser() {
		return this.user;
		
	}
	

  
    /**  
     * Set the value related to the column: user.
	 * @param user the user value you wish to set
	 */
	public void setUser(final User user) {
		this.user = user;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Child clone() throws CloneNotSupportedException {
		super.clone();  // keep hierarchy
        final Child copy = new Child();

		if (this.getChoreAssignments() != null) {
			copy.getChoreAssignments().addAll(this.getChoreAssignments());
		}
		copy.setCreatedAt(this.getCreatedAt());
		copy.setDeletedAt(this.getDeletedAt());
		if (this.getFamilyChilds() != null) {
			copy.getFamilyChilds().addAll(this.getFamilyChilds());
		}
		copy.setId(this.getId());
		copy.setName(this.getName());
		if (this.getRecurringChoreAssignments() != null) {
			copy.getRecurringChoreAssignments().addAll(this.getRecurringChoreAssignments());
		}
		copy.setUser(this.getUser());
		return copy;
	}
	
 
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("createdAt: " + this.getCreatedAt() + ", ");
		sb.append("deletedAt: " + this.getDeletedAt() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("name: " + this.getName() + ", ");
		return sb.toString();		
	}


	/** Equals implementation. 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		Object proxyThat = aThat;
		
		if ( this == aThat ) {
			 return true;
		}

		
		if (aThat instanceof HibernateProxy) {
 			// narrow down the proxy to the class we are dealing with.
 			try {
				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation(); 
			} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		   	}
		}
		if (aThat == null)  {
			 return false;
		}
		
		final Child that; 
		try {
			that = (Child) proxyThat;
			if ( !(that.getClassType().equals(this.getClassType()))){
				return false;
			}
		} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		} catch (ClassCastException e) {
				return false;
		}
		
		
		boolean result = true;
		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
		result = result && (((getCreatedAt() == null) && (that.getCreatedAt() == null)) || (getCreatedAt() != null && getCreatedAt().equals(that.getCreatedAt())));
		result = result && (((getDeletedAt() == null) && (that.getDeletedAt() == null)) || (getDeletedAt() != null && getDeletedAt().equals(that.getDeletedAt())));
		result = result && (((getName() == null) && (that.getName() == null)) || (getName() != null && getName().equals(that.getName())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().equals(that.getUser())));
		return result;
	}
	
	
	/** Calculate the hashcode.
	 * @see java.lang.Object#hashCode()
	 * @return a calculated number
	 */
	@Override
	public int hashCode() {
		if ( this.hashCode == null ) {
			synchronized ( this ) {
				if ( this.hashCode == null ) {
					String newHashCode = null;

					if ( getId() != null ) {
						newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null ) {
							newHashCode = getId();
						} else {
						newHashCode = String.valueOf(super.hashCode());

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
	return this.hashCode.hashCode();
	}
	
	

	
}
