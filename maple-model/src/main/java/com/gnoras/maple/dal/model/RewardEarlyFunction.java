package com.gnoras.maple.dal.model;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import com.felees.hbnpojogen.persistence.validator.Mandatory;
import com.gnoras.maple.dal.model.RewardPolicy;
import com.gnoras.maple.dal.model.interfaces.IRewardEarlyFunction;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.validator.Length;
import org.hibernate.validator.Valid;


/** 
 * Object mapping for hibernate-handled table: reward_early_function.
 * @author autogenerated
 */

@Entity
@Table(name = "reward_early_function", catalog = "maple")
public class RewardEarlyFunction implements Cloneable, Serializable, IPojoGenEntity, IRewardEarlyFunction {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559024016L;
	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Integer> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Integer>());
	
	/** hashCode temporary storage. */
	private volatile Integer hashCode;
	

	/** Field mapping. */
	private Integer id;
	/** Field mapping. */
	private String internalDescription;
	/** Field mapping. */
	private String internalName;
	/** Field mapping. */
	private Set<RewardPolicy> rewardPolicies = new HashSet<RewardPolicy>();

	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public RewardEarlyFunction() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public RewardEarlyFunction(Integer id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param id Integer object;
	 * @param internalDescription String object;
	 * @param internalName String object;
	 */
	public RewardEarlyFunction(Integer id, String internalDescription, String internalName) {

		this.id = id;
		this.internalDescription = internalDescription;
		this.internalName = internalName;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return RewardEarlyFunction.class;
	}
 

    /**
     * Return the value associated with the column: id.
	 * @return A Integer object (this.id)
	 */
    @Id 
	@Mandatory
	@Column( name = "id"  )
	public Integer getId() {
		return this.id;
		
	}
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final Integer id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null || this.id == 0) &&
				(id != null) &&
				(this.hashCode != null) ) {
			SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

    /**
     * Return the value associated with the column: internalDescription.
	 * @return A String object (this.internalDescription)
	 */
	@Mandatory
	@Length(max=250)
	@Column( name = "internal_description", length = 250  )
	public String getInternalDescription() {
		return this.internalDescription;
		
	}
	

  
    /**  
     * Set the value related to the column: internalDescription.
	 * @param internalDescription the internalDescription value you wish to set
	 */
	public void setInternalDescription(final String internalDescription) {
		this.internalDescription = internalDescription;
	}

    /**
     * Return the value associated with the column: internalName.
	 * @return A String object (this.internalName)
	 */
	@Mandatory
	@Length(max=50)
	@Column( name = "internal_name", length = 50  )
	public String getInternalName() {
		return this.internalName;
		
	}
	

  
    /**  
     * Set the value related to the column: internalName.
	 * @param internalName the internalName value you wish to set
	 */
	public void setInternalName(final String internalName) {
		this.internalName = internalName;
	}

    /**
     * Return the value associated with the column: rewardPolicy.
	 * @return A Set&lt;RewardPolicy&gt; object (this.rewardPolicy)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "rewardEarlyFunction"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Valid
	public Set<RewardPolicy> getRewardPolicies() {
		return this.rewardPolicies;
		
	}
	
	/**
	 * Adds a bi-directional link of type RewardPolicy to the rewardPolicies set.
	 * @param rewardPolicy item to add
	 */
	public void addRewardPolicy(RewardPolicy rewardPolicy) {
		rewardPolicy.setRewardEarlyFunction(this);
		this.rewardPolicies.add(rewardPolicy);
	}

  
    /**  
     * Set the value related to the column: rewardPolicy.
	 * @param rewardPolicy the rewardPolicy value you wish to set
	 */
	public void setRewardPolicies(final Set<RewardPolicy> rewardPolicy) {
		this.rewardPolicies = rewardPolicy;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public RewardEarlyFunction clone() throws CloneNotSupportedException {
		super.clone();  // keep hierarchy
        final RewardEarlyFunction copy = new RewardEarlyFunction();

		copy.setId(this.getId());
		copy.setInternalDescription(this.getInternalDescription());
		copy.setInternalName(this.getInternalName());
		if (this.getRewardPolicies() != null) {
			copy.getRewardPolicies().addAll(this.getRewardPolicies());
		}
		return copy;
	}
	
 
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("id: " + this.getId() + ", ");
		sb.append("internalDescription: " + this.getInternalDescription() + ", ");
		sb.append("internalName: " + this.getInternalName() + ", ");
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
		
		final RewardEarlyFunction that; 
		try {
			that = (RewardEarlyFunction) proxyThat;
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
		result = result && (((getInternalDescription() == null) && (that.getInternalDescription() == null)) || (getInternalDescription() != null && getInternalDescription().equals(that.getInternalDescription())));
		result = result && (((getInternalName() == null) && (that.getInternalName() == null)) || (getInternalName() != null && getInternalName().equals(that.getInternalName())));
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
					Integer newHashCode = null;

					if ( getId() != null ) {
						newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null && getId() != 0) {
							newHashCode = getId();
						} else {
							newHashCode = super.hashCode();

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
	return this.hashCode;
	}
	
	

	
}
