package com.gnoras.maple.dal.services;

import com.gnoras.maple.dal.model.Account;
import com.gnoras.maple.dal.model.AccountProductPlan;
import com.gnoras.maple.dal.model.AccountProductPlanAdjustment;
import com.gnoras.maple.dal.model.AccountState;
import com.gnoras.maple.dal.model.Child;
import com.gnoras.maple.dal.model.Chore;
import com.gnoras.maple.dal.model.ChoreAssignment;
import com.gnoras.maple.dal.model.Country;
import com.gnoras.maple.dal.model.CountryCurrency;
import com.gnoras.maple.dal.model.CountryName;
import com.gnoras.maple.dal.model.Currency;
import com.gnoras.maple.dal.model.CurrencyName;
import com.gnoras.maple.dal.model.EmailAddress;
import com.gnoras.maple.dal.model.Family;
import com.gnoras.maple.dal.model.FamilyChild;
import com.gnoras.maple.dal.model.FamilyParent;
import com.gnoras.maple.dal.model.Group;
import com.gnoras.maple.dal.model.GroupMember;
import com.gnoras.maple.dal.model.Language;
import com.gnoras.maple.dal.model.LanguageName;
import com.gnoras.maple.dal.model.Offering;
import com.gnoras.maple.dal.model.Parent;
import com.gnoras.maple.dal.model.PaymentFromCc;
import com.gnoras.maple.dal.model.PaymentFromPaypal;
import com.gnoras.maple.dal.model.PaymentType;
import com.gnoras.maple.dal.model.PlanText;
import com.gnoras.maple.dal.model.Privilege;
import com.gnoras.maple.dal.model.PrivilegedGroup;
import com.gnoras.maple.dal.model.ProductPlan;
import com.gnoras.maple.dal.model.Purchase;
import com.gnoras.maple.dal.model.Quota;
import com.gnoras.maple.dal.model.RecurringChoreAssignment;
import com.gnoras.maple.dal.model.Refund;
import com.gnoras.maple.dal.model.Reward;
import com.gnoras.maple.dal.model.RewardEarlyFunction;
import com.gnoras.maple.dal.model.RewardLateFunction;
import com.gnoras.maple.dal.model.RewardPolicy;
import com.gnoras.maple.dal.model.RewardType;
import com.gnoras.maple.dal.model.Transaction;
import com.gnoras.maple.dal.model.TransactionItem;
import com.gnoras.maple.dal.model.User;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import java.util.Collection;
import com.felees.hbnpojogen.persistence.IPojoGenEntity;
/** 
 * Data layer.
 * @author autogenerated
 */
public interface DataLayerMaple {

    /**
     * Deletes the given object from disk.
     * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to delete
     */
    <T> void delete(T persistentObject);
    /**
     * Refresh the object $class.className from disk.
     * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to reload
     */
    <T> void refresh(T persistentObject);

    /**
     * Saves the given object to disk.
     * @param persistentObject Object to save
	 * @param <T> A DataLayerObject-derived type
     * @return Identifier of saved object 
     */
    <T> Serializable save(T persistentObject);
    /**
     * Saves or updates the given $class.className object to disk.
	 * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to save 
     */
    <T> void saveOrUpdate(T persistentObject);
    /**
     * Updates the given object to disk.
	 * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to update 
     */
    <T> void update(T persistentObject);


    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Account obj) directly
     * @param id Identifier to delete
     */
    void deleteAccount(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Account object
     */
    Account loadAccount(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Account getAccount(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (AccountProductPlan obj) directly
     * @param id Identifier to delete
     */
    void deleteAccountProductPlan(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a AccountProductPlan object
     */
    AccountProductPlan loadAccountProductPlan(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     AccountProductPlan getAccountProductPlan(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (AccountProductPlanAdjustment obj) directly
     * @param id Identifier to delete
     */
    void deleteAccountProductPlanAdjustment(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a AccountProductPlanAdjustment object
     */
    AccountProductPlanAdjustment loadAccountProductPlanAdjustment(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     AccountProductPlanAdjustment getAccountProductPlanAdjustment(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (AccountState obj) directly
     * @param id Identifier to delete
     */
    void deleteAccountState(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a AccountState object
     */
    AccountState loadAccountState(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     AccountState getAccountState(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Child obj) directly
     * @param id Identifier to delete
     */
    void deleteChild(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Child object
     */
    Child loadChild(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Child getChild(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Chore obj) directly
     * @param id Identifier to delete
     */
    void deleteChore(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Chore object
     */
    Chore loadChore(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Chore getChore(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (ChoreAssignment obj) directly
     * @param id Identifier to delete
     */
    void deleteChoreAssignment(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a ChoreAssignment object
     */
    ChoreAssignment loadChoreAssignment(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     ChoreAssignment getChoreAssignment(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Country obj) directly
     * @param id Identifier to delete
     */
    void deleteCountry(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Country object
     */
    Country loadCountry(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Country getCountry(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (CountryCurrency obj) directly
     * @param id Identifier to delete
     */
    void deleteCountryCurrency(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a CountryCurrency object
     */
    CountryCurrency loadCountryCurrency(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     CountryCurrency getCountryCurrency(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (CountryName obj) directly
     * @param id Identifier to delete
     */
    void deleteCountryName(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a CountryName object
     */
    CountryName loadCountryName(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     CountryName getCountryName(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Currency obj) directly
     * @param id Identifier to delete
     */
    void deleteCurrency(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Currency object
     */
    Currency loadCurrency(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Currency getCurrency(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (CurrencyName obj) directly
     * @param id Identifier to delete
     */
    void deleteCurrencyName(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a CurrencyName object
     */
    CurrencyName loadCurrencyName(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     CurrencyName getCurrencyName(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (EmailAddress obj) directly
     * @param id Identifier to delete
     */
    void deleteEmailAddress(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a EmailAddress object
     */
    EmailAddress loadEmailAddress(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     EmailAddress getEmailAddress(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Family obj) directly
     * @param id Identifier to delete
     */
    void deleteFamily(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Family object
     */
    Family loadFamily(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Family getFamily(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (FamilyChild obj) directly
     * @param id Identifier to delete
     */
    void deleteFamilyChild(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a FamilyChild object
     */
    FamilyChild loadFamilyChild(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     FamilyChild getFamilyChild(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (FamilyParent obj) directly
     * @param id Identifier to delete
     */
    void deleteFamilyParent(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a FamilyParent object
     */
    FamilyParent loadFamilyParent(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     FamilyParent getFamilyParent(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Group obj) directly
     * @param id Identifier to delete
     */
    void deleteGroup(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Group object
     */
    Group loadGroup(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Group getGroup(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (GroupMember obj) directly
     * @param id Identifier to delete
     */
    void deleteGroupMember(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a GroupMember object
     */
    GroupMember loadGroupMember(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     GroupMember getGroupMember(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Language obj) directly
     * @param id Identifier to delete
     */
    void deleteLanguage(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Language object
     */
    Language loadLanguage(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Language getLanguage(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (LanguageName obj) directly
     * @param id Identifier to delete
     */
    void deleteLanguageName(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a LanguageName object
     */
    LanguageName loadLanguageName(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     LanguageName getLanguageName(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Offering obj) directly
     * @param id Identifier to delete
     */
    void deleteOffering(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Offering object
     */
    Offering loadOffering(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Offering getOffering(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Parent obj) directly
     * @param id Identifier to delete
     */
    void deleteParent(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Parent object
     */
    Parent loadParent(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Parent getParent(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (PaymentFromCc obj) directly
     * @param id Identifier to delete
     */
    void deletePaymentFromCc(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a PaymentFromCc object
     */
    PaymentFromCc loadPaymentFromCc(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     PaymentFromCc getPaymentFromCc(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (PaymentFromPaypal obj) directly
     * @param id Identifier to delete
     */
    void deletePaymentFromPaypal(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a PaymentFromPaypal object
     */
    PaymentFromPaypal loadPaymentFromPaypal(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     PaymentFromPaypal getPaymentFromPaypal(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (PaymentType obj) directly
     * @param id Identifier to delete
     */
    void deletePaymentType(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a PaymentType object
     */
    PaymentType loadPaymentType(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     PaymentType getPaymentType(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (PlanText obj) directly
     * @param id Identifier to delete
     */
    void deletePlanText(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a PlanText object
     */
    PlanText loadPlanText(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     PlanText getPlanText(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Privilege obj) directly
     * @param id Identifier to delete
     */
    void deletePrivilege(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Privilege object
     */
    Privilege loadPrivilege(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Privilege getPrivilege(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (PrivilegedGroup obj) directly
     * @param id Identifier to delete
     */
    void deletePrivilegedGroup(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a PrivilegedGroup object
     */
    PrivilegedGroup loadPrivilegedGroup(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     PrivilegedGroup getPrivilegedGroup(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (ProductPlan obj) directly
     * @param id Identifier to delete
     */
    void deleteProductPlan(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a ProductPlan object
     */
    ProductPlan loadProductPlan(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     ProductPlan getProductPlan(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Purchase obj) directly
     * @param id Identifier to delete
     */
    void deletePurchase(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Purchase object
     */
    Purchase loadPurchase(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Purchase getPurchase(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Quota obj) directly
     * @param id Identifier to delete
     */
    void deleteQuota(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Quota object
     */
    Quota loadQuota(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Quota getQuota(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (RecurringChoreAssignment obj) directly
     * @param id Identifier to delete
     */
    void deleteRecurringChoreAssignment(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a RecurringChoreAssignment object
     */
    RecurringChoreAssignment loadRecurringChoreAssignment(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     RecurringChoreAssignment getRecurringChoreAssignment(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Refund obj) directly
     * @param id Identifier to delete
     */
    void deleteRefund(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Refund object
     */
    Refund loadRefund(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Refund getRefund(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Reward obj) directly
     * @param id Identifier to delete
     */
    void deleteReward(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Reward object
     */
    Reward loadReward(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Reward getReward(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (RewardEarlyFunction obj) directly
     * @param id Identifier to delete
     */
    void deleteRewardEarlyFunction(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a RewardEarlyFunction object
     */
    RewardEarlyFunction loadRewardEarlyFunction(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     RewardEarlyFunction getRewardEarlyFunction(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (RewardLateFunction obj) directly
     * @param id Identifier to delete
     */
    void deleteRewardLateFunction(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a RewardLateFunction object
     */
    RewardLateFunction loadRewardLateFunction(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     RewardLateFunction getRewardLateFunction(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (RewardPolicy obj) directly
     * @param id Identifier to delete
     */
    void deleteRewardPolicy(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a RewardPolicy object
     */
    RewardPolicy loadRewardPolicy(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     RewardPolicy getRewardPolicy(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (RewardType obj) directly
     * @param id Identifier to delete
     */
    void deleteRewardType(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a RewardType object
     */
    RewardType loadRewardType(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     RewardType getRewardType(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Transaction obj) directly
     * @param id Identifier to delete
     */
    void deleteTransaction(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Transaction object
     */
    Transaction loadTransaction(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Transaction getTransaction(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (TransactionItem obj) directly
     * @param id Identifier to delete
     */
    void deleteTransactionItem(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a TransactionItem object
     */
    TransactionItem loadTransactionItem(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     TransactionItem getTransactionItem(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (User obj) directly
     * @param id Identifier to delete
     */
    void deleteUser(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a User object
     */
    User loadUser(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     User getUser(final Serializable id);  
    /** Returns a query handle.
     * @param query Query to use
     * @return A query instance
     */
     Query createQuery(final String query);
    /** Returns a criteria handle.
     * @param criteria Criteria to use
     * @return A criteria instance
     */
     Criteria createCriteria(final String criteria);
    /** Returns a Query handle based on your package-level named query.
     * @param query Query to use
     * @return A query instance
     */
     Query getNamedQuery(final String query);
    /** Create a new Criteria instance, for the given entity class, or a superclass of an entity class.
	* @param persistentObject a class, which is persistent, or has persistent subclasses 
	* @return Criteria instance
	*/
	@SuppressWarnings("unchecked")
	Criteria createCriteria(Class persistentObject);
    /** Flushes the currently open session.
	*/
	void flushSession();
    /** Clears the currently open session.
	*/
	void clearSession();
    /** Flushes and clears the currently open session.
	*/
	void flushAndClearSession();
	/** Call currentSession.replicate.
	 * @param obj to replicate
	 * @param replicationMode mode
	 */ 
	void replicate(Object obj, ReplicationMode replicationMode);
	/** Hibernate Merge. 
	 * @param obj to merge
	 * @return obj merged.
	 */
	Object merge(Object obj);
	/** Returns the current session.
	 * @return the currently active session
	 */
	Session getCurrentSession();
	/** Returns a query handle.
     * @param query Query to use
     * @return A query instance
     */
     SQLQuery createSQLQuery(final String query);
    /** Remove this instance from the session cache. 
	 * Changes to the instance will not be synchronized with the database
	 * @param obj object to evict
	 */
	void evict(Object obj);
    /**
     * Return the persistent instance of the given entity class with the given 
     * identifier, or null if there is no such persistent instance. 
     * (If the instance, or a proxy for the instance, is already 
     * associated with the session, return that instance or proxy)
     *
     * @param clazz a persistent class
     * @param id a valid identifier of an existing persistent instance of the class
     * @return a persistent instance or null
     * @throws HibernateException
     */
	Object get(Class<?> clazz, Serializable id) throws HibernateException;	


    /**
     * Return the persistent instance of the given entity class with the given identifier, assuming that the instance exists.
     *You should not use this method to determine if an instance exists (use get() instead). Use this only to retrieve an instance that you assume exists, where non-existence would be an actual error.
     *
     * @param clazz a persistent class
     * @param id a valid identifier of an existing persistent instance of the class
     * @return the persistent instance or proxy
     * @throws HibernateException
     */
	Object load(Class<?> clazz, Serializable id) throws HibernateException;
	/**
	 * Reattaches the given entity to the current session using LockMode.NONE
	 *
	 * @param entity to reattach
	 */
	void reattachEntityWithNoLock(IPojoGenEntity entity);
	/**
	 * Reattaches the given entities to the current session.
	 *
	 * @param entities to attach
	 */
	void reattachEntitiesWithNoLock(Collection<? extends IPojoGenEntity> entities);}

