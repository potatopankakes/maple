package com.gnoras.maple.dal.model;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import com.felees.hbnpojogen.persistence.validator.Mandatory;
import com.gnoras.maple.dal.model.Account;
import com.gnoras.maple.dal.model.interfaces.IAccountState;
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
 * Object mapping for hibernate-handled table: account_state.
 * @author autogenerated
 */

@Entity
@Table(name = "account_state", catalog = "maple")
public class AccountState implements Cloneable, Serializable, IPojoGenEntity, IAccountState {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559024047L;
	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Integer> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Integer>());
	
	/** hashCode temporary storage. */
	private volatile Integer hashCode;
	

	/** Field mapping. */
	private Set<Account> accounts = new HashSet<Account>();

	/** Field mapping. */
	private String description;
	/** Field mapping. */
	private String enumName;
	/** Field mapping. */
	private Integer id;
	/** Field mapping. */
	private String name;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public AccountState() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public AccountState(Integer id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param description String object;
	 * @param enumName String object;
	 * @param id Integer object;
	 * @param name String object;
	 */
	public AccountState(String description, String enumName, Integer id, 					
			String name) {

		this.description = description;
		this.enumName = enumName;
		this.id = id;
		this.name = name;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return AccountState.class;
	}
 

    /**
     * Return the value associated with the column: account.
	 * @return A Set&lt;Account&gt; object (this.account)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "state"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Valid
	public Set<Account> getAccounts() {
		return this.accounts;
		
	}
	
	/**
	 * Adds a bi-directional link of type Account to the accounts set.
	 * @param account item to add
	 */
	public void addAccount(Account account) {
		account.setState(this);
		this.accounts.add(account);
	}

  
    /**  
     * Set the value related to the column: account.
	 * @param account the account value you wish to set
	 */
	public void setAccounts(final Set<Account> account) {
		this.accounts = account;
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
     * Return the value associated with the column: enumName.
	 * @return A String object (this.enumName)
	 */
	@Mandatory
	@Length(max=50)
	@Column( name = "enum_name", length = 50  )
	public String getEnumName() {
		return this.enumName;
		
	}
	

  
    /**  
     * Set the value related to the column: enumName.
	 * @param enumName the enumName value you wish to set
	 */
	public void setEnumName(final String enumName) {
		this.enumName = enumName;
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
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public AccountState clone() throws CloneNotSupportedException {
		super.clone();  // keep hierarchy
        final AccountState copy = new AccountState();

		if (this.getAccounts() != null) {
			copy.getAccounts().addAll(this.getAccounts());
		}
		copy.setDescription(this.getDescription());
		copy.setEnumName(this.getEnumName());
		copy.setId(this.getId());
		copy.setName(this.getName());
		return copy;
	}
	
 
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("description: " + this.getDescription() + ", ");
		sb.append("enumName: " + this.getEnumName() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("name: " + this.getName());
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
		
		final AccountState that; 
		try {
			that = (AccountState) proxyThat;
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
		result = result && (((getDescription() == null) && (that.getDescription() == null)) || (getDescription() != null && getDescription().equals(that.getDescription())));
		result = result && (((getEnumName() == null) && (that.getEnumName() == null)) || (getEnumName() != null && getEnumName().equals(that.getEnumName())));
		result = result && (((getName() == null) && (that.getName() == null)) || (getName() != null && getName().equals(that.getName())));
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