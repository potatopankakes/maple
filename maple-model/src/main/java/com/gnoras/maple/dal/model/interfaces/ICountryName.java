package com.gnoras.maple.dal.model.interfaces;
import com.gnoras.maple.dal.model.Country;
import com.gnoras.maple.dal.model.Language;


/** 
 * Object interface mapping for hibernate-handled table: country_name.
 * @author autogenerated
 */

public interface ICountryName {



    /**
     * Return the value associated with the column: commonName.
	 * @return A String object (this.commonName)
	 */
	String getCommonName();
	

  
    /**  
     * Set the value related to the column: commonName.
	 * @param commonName the commonName value you wish to set
	 */
	void setCommonName(final String commonName);

    /**
     * Return the value associated with the column: country.
	 * @return A Country object (this.country)
	 */
	Country getCountry();
	

  
    /**  
     * Set the value related to the column: country.
	 * @param country the country value you wish to set
	 */
	void setCountry(final Country country);

    /**
     * Return the value associated with the column: formalName.
	 * @return A String object (this.formalName)
	 */
	String getFormalName();
	

  
    /**  
     * Set the value related to the column: formalName.
	 * @param formalName the formalName value you wish to set
	 */
	void setFormalName(final String formalName);

    /**
     * Return the value associated with the column: id.
	 * @return A Integer object (this.id)
	 */
	Integer getId();
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	void setId(final Integer id);

    /**
     * Return the value associated with the column: language.
	 * @return A Language object (this.language)
	 */
	Language getLanguage();
	

  
    /**  
     * Set the value related to the column: language.
	 * @param language the language value you wish to set
	 */
	void setLanguage(final Language language);

	// end of interface
}