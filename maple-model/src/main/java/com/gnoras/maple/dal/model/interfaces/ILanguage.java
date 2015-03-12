package com.gnoras.maple.dal.model.interfaces;
import com.gnoras.maple.dal.model.CountryName;
import com.gnoras.maple.dal.model.CurrencyName;
import com.gnoras.maple.dal.model.LanguageName;
import com.gnoras.maple.dal.model.PlanText;
import java.util.Set;


/** 
 * Object interface mapping for hibernate-handled table: language.
 * @author autogenerated
 */

public interface ILanguage {



    /**
     * Return the value associated with the column: countryName.
	 * @return A Set&lt;CountryName&gt; object (this.countryName)
	 */
	Set<CountryName> getCountryNames();
	
	/**
	 * Adds a bi-directional link of type CountryName to the countryNames set.
	 * @param countryName item to add
	 */
	void addCountryName(CountryName countryName);

  
    /**  
     * Set the value related to the column: countryName.
	 * @param countryName the countryName value you wish to set
	 */
	void setCountryNames(final Set<CountryName> countryName);

    /**
     * Return the value associated with the column: currencyName.
	 * @return A Set&lt;CurrencyName&gt; object (this.currencyName)
	 */
	Set<CurrencyName> getCurrencyNames();
	
	/**
	 * Adds a bi-directional link of type CurrencyName to the currencyNames set.
	 * @param currencyName item to add
	 */
	void addCurrencyName(CurrencyName currencyName);

  
    /**  
     * Set the value related to the column: currencyName.
	 * @param currencyName the currencyName value you wish to set
	 */
	void setCurrencyNames(final Set<CurrencyName> currencyName);

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
     * Return the value associated with the column: iso693A3.
	 * @return A String object (this.iso693A3)
	 */
	String getIso693A3();
	

  
    /**  
     * Set the value related to the column: iso693A3.
	 * @param iso693A3 the iso693A3 value you wish to set
	 */
	void setIso693A3(final String iso693A3);

    /**
     * Return the value associated with the column: languageName.
	 * @return A Set&lt;LanguageName&gt; object (this.languageName)
	 */
	Set<LanguageName> getLanguageNames();
	
	/**
	 * Adds a bi-directional link of type LanguageName to the languageNames set.
	 * @param languageName item to add
	 */
	void addLanguageName(LanguageName languageName);

  
    /**  
     * Set the value related to the column: languageName.
	 * @param languageName the languageName value you wish to set
	 */
	void setLanguageNames(final Set<LanguageName> languageName);

    /**
     * Return the value associated with the column: planText.
	 * @return A Set&lt;PlanText&gt; object (this.planText)
	 */
	Set<PlanText> getPlanTexts();
	
	/**
	 * Adds a bi-directional link of type PlanText to the planTexts set.
	 * @param planText item to add
	 */
	void addPlanText(PlanText planText);

  
    /**  
     * Set the value related to the column: planText.
	 * @param planText the planText value you wish to set
	 */
	void setPlanTexts(final Set<PlanText> planText);

	// end of interface
}