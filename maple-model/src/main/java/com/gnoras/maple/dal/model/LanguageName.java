package com.gnoras.maple.dal.model;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import com.felees.hbnpojogen.persistence.validator.Mandatory;
import com.gnoras.maple.dal.model.interfaces.ILanguageName;
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
 * Object mapping for hibernate-handled table: language_name.
 * @author autogenerated
 */

@Entity
@Table(name = "language_name", catalog = "maple")
public class LanguageName implements Cloneable, Serializable, IPojoGenEntity, ILanguageName {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559024031L;
	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Integer> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Integer>());
	
	/** hashCode temporary storage. */
	private volatile Integer hashCode;
	

	/** Field mapping. */
	private Integer id;
	/** Field mapping. */
	private Language language;
	/** Field mapping. */
	private Language language2;
	/** Field mapping. */
	private String nameInL2;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public LanguageName() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public LanguageName(Integer id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param id Integer object;
	 * @param language Language object;
	 * @param language2 Language object;
	 * @param nameInL2 String object;
	 */
	public LanguageName(Integer id, Language language, Language language2, 					
			String nameInL2) {

		this.id = id;
		this.language = language;
		this.language2 = language2;
		this.nameInL2 = nameInL2;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return LanguageName.class;
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
     * Return the value associated with the column: language2.
	 * @return A Language object (this.language2)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "language2_id" )
	@Valid
	public Language getLanguage2() {
		return this.language2;
		
	}
	

  
    /**  
     * Set the value related to the column: language2.
	 * @param language2 the language2 value you wish to set
	 */
	public void setLanguage2(final Language language2) {
		this.language2 = language2;
	}

    /**
     * Return the value associated with the column: nameInL2.
	 * @return A String object (this.nameInL2)
	 */
	@Mandatory
	@Length(max=50)
	@Column( name = "name_in_l2", length = 50  )
	public String getNameInL2() {
		return this.nameInL2;
		
	}
	

  
    /**  
     * Set the value related to the column: nameInL2.
	 * @param nameInL2 the nameInL2 value you wish to set
	 */
	public void setNameInL2(final String nameInL2) {
		this.nameInL2 = nameInL2;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public LanguageName clone() throws CloneNotSupportedException {
		super.clone();  // keep hierarchy
        final LanguageName copy = new LanguageName();

		copy.setId(this.getId());
		copy.setLanguage(this.getLanguage());
		copy.setLanguage2(this.getLanguage2());
		copy.setNameInL2(this.getNameInL2());
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
		sb.append("nameInL2: " + this.getNameInL2());
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
		
		final LanguageName that; 
		try {
			that = (LanguageName) proxyThat;
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
		result = result && (((getLanguage() == null) && (that.getLanguage() == null)) || (getLanguage() != null && getLanguage().equals(that.getLanguage())));
		result = result && (((getLanguage2() == null) && (that.getLanguage2() == null)) || (getLanguage2() != null && getLanguage2().equals(that.getLanguage2())));
		result = result && (((getNameInL2() == null) && (that.getNameInL2() == null)) || (getNameInL2() != null && getNameInL2().equals(that.getNameInL2())));
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