package com.gnoras.maple.dal.model;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import com.felees.hbnpojogen.persistence.validator.Mandatory;
import com.gnoras.maple.dal.model.ChoreAssignment;
import com.gnoras.maple.dal.model.RecurringChoreAssignment;
import com.gnoras.maple.dal.model.interfaces.IChore;
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
 * Object mapping for hibernate-handled table: chore.
 * @author autogenerated
 */

@Entity
@Table(name = "chore", catalog = "maple")
public class Chore implements Cloneable, Serializable, IPojoGenEntity, IChore {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559024045L;
	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, String> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, String>());
	
	/** hashCode temporary storage. */
	private volatile String hashCode;
	

	/** Field mapping. */
	private Set<ChoreAssignment> choreAssignments = new HashSet<ChoreAssignment>();

	/** Field mapping. */
	private Long createdDt;
	/** Field mapping. */
	private Reward defReward;
	/** Field mapping. */
	private RewardPolicy defRewardPolicy;
	/** Field mapping. */
	private Long deletedDt;
	/** Field mapping. */
	private String description;
	/** Field mapping. */
	private Family family;
	/** Field mapping. */
	private String id;
	/** Field mapping. */
	private String name;
	/** Field mapping. */
	private Set<RecurringChoreAssignment> recurringChoreAssignments = new HashSet<RecurringChoreAssignment>();

	/** Field mapping. */
	private Byte retired;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Chore() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Chore(String id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param createdDt Long object;
	 * @param defReward Reward object;
	 * @param defRewardPolicy RewardPolicy object;
	 * @param deletedDt Long object;
	 * @param description String object;
	 * @param family Family object;
	 * @param id String object;
	 * @param name String object;
	 * @param retired Byte object;
	 */
	public Chore(Long createdDt, Reward defReward, RewardPolicy defRewardPolicy, 					
			Long deletedDt, String description, Family family, 					
			String id, String name, Byte retired) {

		this.createdDt = createdDt;
		this.defReward = defReward;
		this.defRewardPolicy = defRewardPolicy;
		this.deletedDt = deletedDt;
		this.description = description;
		this.family = family;
		this.id = id;
		this.name = name;
		this.retired = retired;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Chore.class;
	}
 

    /**
     * Return the value associated with the column: choreAssignment.
	 * @return A Set&lt;ChoreAssignment&gt; object (this.choreAssignment)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "chore"  )
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
		choreAssignment.setChore(this);
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
     * Return the value associated with the column: createdDt.
	 * @return A Long object (this.createdDt)
	 */
	@Mandatory
	@Column( name = "created_dt"  )
	public Long getCreatedDt() {
		return this.createdDt;
		
	}
	

  
    /**  
     * Set the value related to the column: createdDt.
	 * @param createdDt the createdDt value you wish to set
	 */
	public void setCreatedDt(final Long createdDt) {
		this.createdDt = createdDt;
	}

    /**
     * Return the value associated with the column: defReward.
	 * @return A Reward object (this.defReward)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "def_reward_id" )
	@Valid
	public Reward getDefReward() {
		return this.defReward;
		
	}
	

  
    /**  
     * Set the value related to the column: defReward.
	 * @param defReward the defReward value you wish to set
	 */
	public void setDefReward(final Reward defReward) {
		this.defReward = defReward;
	}

    /**
     * Return the value associated with the column: defRewardPolicy.
	 * @return A RewardPolicy object (this.defRewardPolicy)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "def_reward_policy_id" )
	@Valid
	public RewardPolicy getDefRewardPolicy() {
		return this.defRewardPolicy;
		
	}
	

  
    /**  
     * Set the value related to the column: defRewardPolicy.
	 * @param defRewardPolicy the defRewardPolicy value you wish to set
	 */
	public void setDefRewardPolicy(final RewardPolicy defRewardPolicy) {
		this.defRewardPolicy = defRewardPolicy;
	}

    /**
     * Return the value associated with the column: deletedDt.
	 * @return A Long object (this.deletedDt)
	 */
	@Mandatory
	@Column( name = "deleted_dt"  )
	public Long getDeletedDt() {
		return this.deletedDt;
		
	}
	

  
    /**  
     * Set the value related to the column: deletedDt.
	 * @param deletedDt the deletedDt value you wish to set
	 */
	public void setDeletedDt(final Long deletedDt) {
		this.deletedDt = deletedDt;
	}

    /**
     * Return the value associated with the column: description.
	 * @return A String object (this.description)
	 */
	@Mandatory
	@Length(max=250)
	@Column( length = 250  )
	public String getDescription() {
		return this.description;
		
	}
	

  
    /**  
     * Set the value related to the column: description.
	 * @param description the description value you wish to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

    /**
     * Return the value associated with the column: family.
	 * @return A Family object (this.family)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "family_id" )
	@Valid
	public Family getFamily() {
		return this.family;
		
	}
	

  
    /**  
     * Set the value related to the column: family.
	 * @param family the family value you wish to set
	 */
	public void setFamily(final Family family) {
		this.family = family;
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
	@Mandatory
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
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "chore"  )
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
		recurringChoreAssignment.setChore(this);
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
     * Return the value associated with the column: retired.
	 * @return A Byte object (this.retired)
	 */
	@Mandatory
	public Byte getRetired() {
		return this.retired;
		
	}
	

  
    /**  
     * Set the value related to the column: retired.
	 * @param retired the retired value you wish to set
	 */
	public void setRetired(final Byte retired) {
		this.retired = retired;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Chore clone() throws CloneNotSupportedException {
		super.clone();  // keep hierarchy
        final Chore copy = new Chore();

		if (this.getChoreAssignments() != null) {
			copy.getChoreAssignments().addAll(this.getChoreAssignments());
		}
		copy.setCreatedDt(this.getCreatedDt());
		copy.setDefReward(this.getDefReward());
		copy.setDefRewardPolicy(this.getDefRewardPolicy());
		copy.setDeletedDt(this.getDeletedDt());
		copy.setDescription(this.getDescription());
		copy.setFamily(this.getFamily());
		copy.setId(this.getId());
		copy.setName(this.getName());
		if (this.getRecurringChoreAssignments() != null) {
			copy.getRecurringChoreAssignments().addAll(this.getRecurringChoreAssignments());
		}
		copy.setRetired(this.getRetired());
		return copy;
	}
	
 
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("createdDt: " + this.getCreatedDt() + ", ");
		sb.append("deletedDt: " + this.getDeletedDt() + ", ");
		sb.append("description: " + this.getDescription() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("name: " + this.getName() + ", ");
		sb.append("retired: " + this.getRetired());
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
		
		final Chore that; 
		try {
			that = (Chore) proxyThat;
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
		result = result && (((getCreatedDt() == null) && (that.getCreatedDt() == null)) || (getCreatedDt() != null && getCreatedDt().equals(that.getCreatedDt())));
		result = result && (((getDefReward() == null) && (that.getDefReward() == null)) || (getDefReward() != null && getDefReward().equals(that.getDefReward())));
		result = result && (((getDefRewardPolicy() == null) && (that.getDefRewardPolicy() == null)) || (getDefRewardPolicy() != null && getDefRewardPolicy().equals(that.getDefRewardPolicy())));
		result = result && (((getDeletedDt() == null) && (that.getDeletedDt() == null)) || (getDeletedDt() != null && getDeletedDt().equals(that.getDeletedDt())));
		result = result && (((getDescription() == null) && (that.getDescription() == null)) || (getDescription() != null && getDescription().equals(that.getDescription())));
		result = result && (((getFamily() == null) && (that.getFamily() == null)) || (getFamily() != null && getFamily().equals(that.getFamily())));
		result = result && (((getName() == null) && (that.getName() == null)) || (getName() != null && getName().equals(that.getName())));
		result = result && (((getRetired() == null) && (that.getRetired() == null)) || (getRetired() != null && getRetired().equals(that.getRetired())));
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