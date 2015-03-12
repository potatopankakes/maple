package com.gnoras.maple.dal.model;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import com.felees.hbnpojogen.persistence.validator.Mandatory;
import com.gnoras.maple.dal.model.interfaces.ICountryName;
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
import org.hibernate.validator.Length;
import org.hibernate.validator.Valid;


/** 
 * Object mapping for hibernate-handled table: country_name.
 * @author autogenerated
 */

@Entity
@Table(name = "country_name", catalog = "maple")
public class CountryName implements Cloneable, Serializable, IPojoGenEntity, ICountryName {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559024041L;
	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Integer> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Integer>());
	
	/** hashCode temporary storage. */
	private volatile Integer hashCode;
	

	/** Field mapping. */
	private String commonName;
	/** Field mapping. */
	private Country country;
	/** Field mapping. */
	private String formalName;
	/** Field mapping. */
	private Integer id;
	/** Field mapping. */
	private Language language;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public CountryName() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public CountryName(Integer id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param commonName String object;
	 * @param country Country object;
	 * @param formalName String object;
	 * @param id Integer object;
	 * @param language Language object;
	 */
	public CountryName(String commonName, Country country, String formalName, 					
			Integer id, Language language) {

		this.commonName = commonName;
		this.country = country;
		this.formalName = formalName;
		this.id = id;
		this.language = language;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return CountryName.class;
	}
 

    /**
     * Return the value associated with the column: commonName.
	 * @return A String object (this.commonName)
	 */
	@Mandatory
	@Length(max=50)
	@Column( name = "common_name", length = 50  )
	public String getCommonName() {
		return this.commonName;
		
	}
	

  
    /**  
     * Set the value related to the column: commonName.
	 * @param commonName the commonName value you wish to set
	 */
	public void setCommonName(final String commonName) {
		this.commonName = commonName;
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
     * Return the value associated with the column: formalName.
	 * @return A String object (this.formalName)
	 */
	@Mandatory
	@Length(max=100)
	@Column( name = "formal_name", length = 100  )
	public String getFormalName() {
		return this.formalName;
		
	}
	

  
    /**  
     * Set the value related to the column: formalName.
	 * @param formalName the formalName value you wish to set
	 */
	public void setFormalName(final String formalName) {
		this.formalName = formalName;
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
     * Return the value associated with the column: language.
	 * @return A Language object (this.language)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "language_id" )
	@Valid
	public Language getLanguage() {
		return this.language;
		
	}
	

  
    /**  
     * Set the value related to the column: language.
	 * @param language the language value you wish to set
	 */
	public void setLanguage(final Language language) {
		this.language = language;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public CountryName clone() throws CloneNotSupportedException {
		super.clone();  // keep hierarchy
        final CountryName copy = new CountryName();

		copy.setCommonName(this.getCommonName());
		copy.setCountry(this.getCountry());
		copy.setFormalName(this.getFormalName());
		copy.setId(this.getId());
		copy.setLanguage(this.getLanguage());
		return copy;
	}
	
 
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("commonName: " + this.getCommonName() + ", ");
		sb.append("formalName: " + this.getFormalName() + ", ");
		sb.append("id: " + this.getId() + ", ");
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
		
		final CountryName that; 
		try {
			that = (CountryName) proxyThat;
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
		result = result && (((getCommonName() == null) && (that.getCommonName() == null)) || (getCommonName() != null && getCommonName().equals(that.getCommonName())));
		result = result && (((getCountry() == null) && (that.getCountry() == null)) || (getCountry() != null && getCountry().equals(that.getCountry())));
		result = result && (((getFormalName() == null) && (that.getFormalName() == null)) || (getFormalName() != null && getFormalName().equals(that.getFormalName())));
		result = result && (((getLanguage() == null) && (that.getLanguage() == null)) || (getLanguage() != null && getLanguage().equals(that.getLanguage())));
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
