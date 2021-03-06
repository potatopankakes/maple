package com.gnoras.maple.dal.model;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import com.felees.hbnpojogen.persistence.validator.Mandatory;
import com.gnoras.maple.dal.model.interfaces.ICountryCurrency;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.validator.Valid;


/** 
 * Object mapping for hibernate-handled table: country_currency.
 * @author autogenerated
 */

@Entity
@Table(name = "country_currency", catalog = "maple")
public class CountryCurrency implements Cloneable, Serializable, IPojoGenEntity, ICountryCurrency {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559024042L;
	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Integer> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Integer>());
	
	/** hashCode temporary storage. */
	private volatile Integer hashCode;
	

	/** Field mapping. */
	private Country country;
	/** Field mapping. */
	private Currency currency;
	/** Field mapping. */
	private Integer id;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public CountryCurrency() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public CountryCurrency(Integer id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param country Country object;
	 * @param currency Currency object;
	 * @param id Integer object;
	 */
	public CountryCurrency(Country country, Currency currency, Integer id) {

		this.country = country;
		this.currency = currency;
		this.id = id;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return CountryCurrency.class;
	}
 

    /**
     * Return the value associated with the column: country.
	 * @return A Country object (this.country)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "country_id" )
	@Valid
	public Country getCountry() {
		return this.country;
		
	}
	

  
    /**  
     * Set the value related to the column: country.
	 * @param country the country value you wish to set
	 */
	public void setCountry(final Country country) {
		this.country = country;
	}

    /**
     * Return the value associated with the column: currency.
	 * @return A Currency object (this.currency)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "currency_id" )
	@Valid
	public Currency getCurrency() {
		return this.currency;
		
	}
	

  
    /**  
     * Set the value related to the column: currency.
	 * @param currency the currency value you wish to set
	 */
	public void setCurrency(final Currency currency) {
		this.currency = currency;
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
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public CountryCurrency clone() throws CloneNotSupportedException {
		super.clone();  // keep hierarchy
        final CountryCurrency copy = new CountryCurrency();

		copy.setCountry(this.getCountry());
		copy.setCurrency(this.getCurrency());
		copy.setId(this.getId());
		return copy;
	}
	
 
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("id: " + this.getId());
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
		
		final CountryCurrency that; 
		try {
			that = (CountryCurrency) proxyThat;
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
		result = result && (((getCountry() == null) && (that.getCountry() == null)) || (getCountry() != null && getCountry().equals(that.getCountry())));
		result = result && (((getCurrency() == null) && (that.getCurrency() == null)) || (getCurrency() != null && getCurrency().equals(that.getCurrency())));
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
