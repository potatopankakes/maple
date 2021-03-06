package com.gnoras.maple.dal.model;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import com.felees.hbnpojogen.persistence.validator.Mandatory;
import com.gnoras.maple.dal.model.Chore;
import com.gnoras.maple.dal.model.ChoreAssignment;
import com.gnoras.maple.dal.model.interfaces.IRewardPolicy;
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
 * Object mapping for hibernate-handled table: reward_policy.
 * @author autogenerated
 */

@Entity
@Table(name = "reward_policy", catalog = "maple")
public class RewardPolicy implements Cloneable, Serializable, IPojoGenEntity, IRewardPolicy {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559024014L;
	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, String> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, String>());
	
	/** hashCode temporary storage. */
	private volatile String hashCode;
	

	/** Field mapping. */
	private Set<Chore> chores = new HashSet<Chore>();

	/** Field mapping. */
	private Set<ChoreAssignment> choreAssignments = new HashSet<ChoreAssignment>();

	/** Field mapping. */
	private Double earlyArg1;
	/** Field mapping. */
	private Double earlyArg2;
	/** Field mapping. */
	private Family family;
	/** Field mapping. */
	private String id;
	/** Field mapping. */
	private Double lateArg1;
	/** Field mapping. */
	private Double lateArg2;
	/** Field mapping. */
	private RewardEarlyFunction rewardEarlyFunction;
	/** Field mapping. */
	private RewardLateFunction rewardLateFunction;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public RewardPolicy() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public RewardPolicy(String id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param earlyArg1 Double object;
	 * @param earlyArg2 Double object;
	 * @param family Family object;
	 * @param id String object;
	 * @param lateArg1 Double object;
	 * @param lateArg2 Double object;
	 * @param rewardEarlyFunction RewardEarlyFunction object;
	 * @param rewardLateFunction RewardLateFunction object;
	 */
	public RewardPolicy(Double earlyArg1, Double earlyArg2, Family family, 					
			String id, Double lateArg1, Double lateArg2, 					
			RewardEarlyFunction rewardEarlyFunction, RewardLateFunction rewardLateFunction) {

		this.earlyArg1 = earlyArg1;
		this.earlyArg2 = earlyArg2;
		this.family = family;
		this.id = id;
		this.lateArg1 = lateArg1;
		this.lateArg2 = lateArg2;
		this.rewardEarlyFunction = rewardEarlyFunction;
		this.rewardLateFunction = rewardLateFunction;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return RewardPolicy.class;
	}
 

    /**
     * Return the value associated with the column: chore.
	 * @return A Set&lt;Chore&gt; object (this.chore)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "defRewardPolicy"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Valid
	public Set<Chore> getChores() {
		return this.chores;
		
	}
	
	/**
	 * Adds a bi-directional link of type Chore to the chores set.
	 * @param chore item to add
	 */
	public void addChore(Chore chore) {
		chore.setDefRewardPolicy(this);
		this.chores.add(chore);
	}

  
    /**  
     * Set the value related to the column: chore.
	 * @param chore the chore value you wish to set
	 */
	public void setChores(final Set<Chore> chore) {
		this.chores = chore;
	}

    /**
     * Return the value associated with the column: choreAssignment.
	 * @return A Set&lt;ChoreAssignment&gt; object (this.choreAssignment)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "rewardPolicy"  )
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
		choreAssignment.setRewardPolicy(this);
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
     * Return the value associated with the column: earlyArg1.
	 * @return A Double object (this.earlyArg1)
	 */
	@Mandatory
	@Column( name = "early_arg1"  )
	public Double getEarlyArg1() {
		return this.earlyArg1;
		
	}
	

  
    /**  
     * Set the value related to the column: earlyArg1.
	 * @param earlyArg1 the earlyArg1 value you wish to set
	 */
	public void setEarlyArg1(final Double earlyArg1) {
		this.earlyArg1 = earlyArg1;
	}

    /**
     * Return the value associated with the column: earlyArg2.
	 * @return A Double object (this.earlyArg2)
	 */
	@Mandatory
	@Column( name = "early_arg2"  )
	public Double getEarlyArg2() {
		return this.earlyArg2;
		
	}
	

  
    /**  
     * Set the value related to the column: earlyArg2.
	 * @param earlyArg2 the earlyArg2 value you wish to set
	 */
	public void setEarlyArg2(final Double earlyArg2) {
		this.earlyArg2 = earlyArg2;
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
     * Return the value associated with the column: lateArg1.
	 * @return A Double object (this.lateArg1)
	 */
	@Mandatory
	@Column( name = "late_arg1"  )
	public Double getLateArg1() {
		return this.lateArg1;
		
	}
	

  
    /**  
     * Set the value related to the column: lateArg1.
	 * @param lateArg1 the lateArg1 value you wish to set
	 */
	public void setLateArg1(final Double lateArg1) {
		this.lateArg1 = lateArg1;
	}

    /**
     * Return the value associated with the column: lateArg2.
	 * @return A Double object (this.lateArg2)
	 */
	@Mandatory
	@Column( name = "late_arg2"  )
	public Double getLateArg2() {
		return this.lateArg2;
		
	}
	

  
    /**  
     * Set the value related to the column: lateArg2.
	 * @param lateArg2 the lateArg2 value you wish to set
	 */
	public void setLateArg2(final Double lateArg2) {
		this.lateArg2 = lateArg2;
	}

    /**
     * Return the value associated with the column: rewardEarlyFunction.
	 * @return A RewardEarlyFunction object (this.rewardEarlyFunction)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "reward_early_function_id" )
	@Valid
	public RewardEarlyFunction getRewardEarlyFunction() {
		return this.rewardEarlyFunction;
		
	}
	

  
    /**  
     * Set the value related to the column: rewardEarlyFunction.
	 * @param rewardEarlyFunction the rewardEarlyFunction value you wish to set
	 */
	public void setRewardEarlyFunction(final RewardEarlyFunction rewardEarlyFunction) {
		this.rewardEarlyFunction = rewardEarlyFunction;
	}

    /**
     * Return the value associated with the column: rewardLateFunction.
	 * @return A RewardLateFunction object (this.rewardLateFunction)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "reward_late_function_id" )
	@Valid
	public RewardLateFunction getRewardLateFunction() {
		return this.rewardLateFunction;
		
	}
	

  
    /**  
     * Set the value related to the column: rewardLateFunction.
	 * @param rewardLateFunction the rewardLateFunction value you wish to set
	 */
	public void setRewardLateFunction(final RewardLateFunction rewardLateFunction) {
		this.rewardLateFunction = rewardLateFunction;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public RewardPolicy clone() throws CloneNotSupportedException {
		super.clone();  // keep hierarchy
        final RewardPolicy copy = new RewardPolicy();

		if (this.getChores() != null) {
			copy.getChores().addAll(this.getChores());
		}
		if (this.getChoreAssignments() != null) {
			copy.getChoreAssignments().addAll(this.getChoreAssignments());
		}
		copy.setEarlyArg1(this.getEarlyArg1());
		copy.setEarlyArg2(this.getEarlyArg2());
		copy.setFamily(this.getFamily());
		copy.setId(this.getId());
		copy.setLateArg1(this.getLateArg1());
		copy.setLateArg2(this.getLateArg2());
		copy.setRewardEarlyFunction(this.getRewardEarlyFunction());
		copy.setRewardLateFunction(this.getRewardLateFunction());
		return copy;
	}
	
 
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("earlyArg1: " + this.getEarlyArg1() + ", ");
		sb.append("earlyArg2: " + this.getEarlyArg2() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("lateArg1: " + this.getLateArg1() + ", ");
		sb.append("lateArg2: " + this.getLateArg2() + ", ");
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
		
		final RewardPolicy that; 
		try {
			that = (RewardPolicy) proxyThat;
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
		result = result && (((getEarlyArg1() == null) && (that.getEarlyArg1() == null)) || (getEarlyArg1() != null && getEarlyArg1().equals(that.getEarlyArg1())));
		result = result && (((getEarlyArg2() == null) && (that.getEarlyArg2() == null)) || (getEarlyArg2() != null && getEarlyArg2().equals(that.getEarlyArg2())));
		result = result && (((getFamily() == null) && (that.getFamily() == null)) || (getFamily() != null && getFamily().equals(that.getFamily())));
		result = result && (((getLateArg1() == null) && (that.getLateArg1() == null)) || (getLateArg1() != null && getLateArg1().equals(that.getLateArg1())));
		result = result && (((getLateArg2() == null) && (that.getLateArg2() == null)) || (getLateArg2() != null && getLateArg2().equals(that.getLateArg2())));
		result = result && (((getRewardEarlyFunction() == null) && (that.getRewardEarlyFunction() == null)) || (getRewardEarlyFunction() != null && getRewardEarlyFunction().equals(that.getRewardEarlyFunction())));
		result = result && (((getRewardLateFunction() == null) && (that.getRewardLateFunction() == null)) || (getRewardLateFunction() != null && getRewardLateFunction().equals(that.getRewardLateFunction())));
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
