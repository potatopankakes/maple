package com.gnoras.maple.dal.factories;

import com.felees.hbnpojogen.randomlib.data.dataGeneration.*;
import com.gnoras.maple.dal.factories.MapleDataPoolFactory;
import com.gnoras.maple.dal.model.*;
import org.springframework.stereotype.Component;



/** 
 * DAO factory implementation.
 * @author autogenerated
 */
@Component
public class MapleDataPoolFactory {
	/** DB commit order. */
	private static final String[] commitOrder = new String[]{"RecurringChoreAssignment", "ChoreAssignment", "Chore", "Reward", "FamilyParent", "RewardType", "RewardPolicy", "Refund", "Purchase", "PlanText", "PaymentFromPaypal", "PaymentFromCc", "Parent", "Offering", "GroupMember", "FamilyChild", "Family", "EmailAddress", "CurrencyName", "CountryName", "CountryCurrency", "AccountProductPlanAdjustment", "AccountProductPlan", "Account", "User", "TransactionItem", "Transaction", "RewardLateFunction", "RewardEarlyFunction", "Quota", "ProductPlan", "PrivilegedGroup", "Privilege", "PaymentType", "LanguageName", "Language", "Group", "Currency", "Country", "Child", "AccountState"};

    /**
     * Data pool factory for Account.
     * @return Account A Account object
     */
    public static Account getAccount() {
		
        Account account =  getAccount(
	        getAccountState());

		return account;
       
    }

     /**
     * Data pool factory for Account.
     * @param state A valid AccountState object
     * @return Account A Account object
     */
    public static Account getAccount(AccountState state) {

        Account account = new Account();     
        account.setChoreAlertsUsedThisWk(BasicDataGenerator.generateRandomInt());
        account.setCreatedAt(BasicDataGenerator.generateRandomLong());
        account.setDeletedAt(BasicDataGenerator.generateRandomLong());
        account.setId(BasicDataGenerator.generateRandomStringChar(36));
        account.setMaxChildren(BasicDataGenerator.generateRandomInt());
        account.setMaxChoreAlertsThisWeek(BasicDataGenerator.generateRandomInt());
        account.setQuotaId(BasicDataGenerator.generateRandomStringChar(36));
        account.setReportLevel(BasicDataGenerator.generateRandomInt());
        account.setRewardLevel(BasicDataGenerator.generateRandomInt());
		if (state != null) {
			state.addAccount (account);
		}

        return account;
    }

    /**
     * Data pool factory for AccountProductPlan.
     * @return AccountProductPlan A AccountProductPlan object
     */
    public static AccountProductPlan getAccountProductPlan() {
		
        AccountProductPlan accountProductPlan =  getAccountProductPlan(
	        getAccount(), getProductPlan());

		return accountProductPlan;
       
    }

     /**
     * Data pool factory for AccountProductPlan.
     * @param account A valid Account object
     * @param productPlan A valid ProductPlan object
     * @return AccountProductPlan A AccountProductPlan object
     */
    public static AccountProductPlan getAccountProductPlan(Account account, ProductPlan productPlan) {

        AccountProductPlan accountProductPlan = new AccountProductPlan();     
		if (account != null) {
			account.addAccountProductPlan (accountProductPlan);
		}
        accountProductPlan.setEndAt(BasicDataGenerator.generateRandomLong());
        accountProductPlan.setId(BasicDataGenerator.generateRandomStringChar(36));
		if (productPlan != null) {
			productPlan.addAccountProductPlan (accountProductPlan);
		}
        accountProductPlan.setStartAt(BasicDataGenerator.generateRandomLong());

        return accountProductPlan;
    }

    /**
     * Data pool factory for AccountProductPlanAdjustment.
     * @return AccountProductPlanAdjustment A AccountProductPlanAdjustment object
     */
    public static AccountProductPlanAdjustment getAccountProductPlanAdjustment() {
		
        AccountProductPlanAdjustment accountProductPlanAdjustment =  getAccountProductPlanAdjustment(
	        getAccount(), getProductPlan());

		return accountProductPlanAdjustment;
       
    }

     /**
     * Data pool factory for AccountProductPlanAdjustment.
     * @param account A valid Account object
     * @param productPlan A valid ProductPlan object
     * @return AccountProductPlanAdjustment A AccountProductPlanAdjustment object
     */
    public static AccountProductPlanAdjustment getAccountProductPlanAdjustment(Account account, ProductPlan productPlan) {

        AccountProductPlanAdjustment accountProductPlanAdjustment = new AccountProductPlanAdjustment();     
		if (account != null) {
			account.addAccountProductPlanAdjustment (accountProductPlanAdjustment);
		}
        accountProductPlanAdjustment.setDaysSpanned(BasicDataGenerator.generateRandomInt());
        accountProductPlanAdjustment.setId(BasicDataGenerator.generateRandomStringChar(36));
		if (productPlan != null) {
			productPlan.addAccountProductPlanAdjustment (accountProductPlanAdjustment);
		}
        accountProductPlanAdjustment.setStartAt(BasicDataGenerator.generateRandomLong());

        return accountProductPlanAdjustment;
    }

    /**
     * Data pool factory for AccountState.
     * @return AccountStateA AccountState object
     */
    public static AccountState getAccountState() {

        AccountState accountState = new AccountState();    
        
        accountState.setDescription(BasicDataGenerator.generateRandomString(250));
        accountState.setEnumName(BasicDataGenerator.generateRandomString(50));
        accountState.setId(BasicDataGenerator.generateRandomInt());
        accountState.setName(BasicDataGenerator.generateRandomString(50));

        return accountState;
    }

    /**
     * Data pool factory for Child.
     * @return Child A Child object
     */
    public static Child getChild() {
		
        Child child =  getChild(
	        null);

		return child;
       
    }

     /**
     * Data pool factory for Child.
     * @param user A valid User object
     * @return Child A Child object
     */
    public static Child getChild(User user) {

        Child child = new Child();     
        child.setCreatedAt(BasicDataGenerator.generateRandomLong());
        child.setDeletedAt(BasicDataGenerator.generateRandomLong());
        child.setId(BasicDataGenerator.generateRandomStringChar(36));
        child.setName(BasicDataGenerator.generateRandomString(50));
		if (user != null) {
			user.addChild (child);
		}

        return child;
    }

    /**
     * Data pool factory for Chore.
     * @return Chore A Chore object
     */
    public static Chore getChore() {
		
        Chore chore =  getChore(
	        getReward(), getRewardPolicy(), getFamily());

		return chore;
       
    }

     /**
     * Data pool factory for Chore.
     * @param defReward A valid Reward object
     * @param defRewardPolicy A valid RewardPolicy object
     * @param family A valid Family object
     * @return Chore A Chore object
     */
    public static Chore getChore(Reward defReward, RewardPolicy defRewardPolicy, Family family) {

        Chore chore = new Chore();     
        chore.setCreatedDt(BasicDataGenerator.generateRandomLong());
		if (defReward != null) {
			defReward.addChore (chore);
		}
		if (defRewardPolicy != null) {
			defRewardPolicy.addChore (chore);
		}
        chore.setDeletedDt(BasicDataGenerator.generateRandomLong());
        chore.setDescription(BasicDataGenerator.generateRandomString(250));
		if (family != null) {
			family.addChore (chore);
		}
        chore.setId(BasicDataGenerator.generateRandomStringChar(36));
        chore.setName(BasicDataGenerator.generateRandomString(50));
        chore.setRetired((byte)(BasicDataGenerator.generateRandomTinyInt()));

        return chore;
    }

    /**
     * Data pool factory for ChoreAssignment.
     * @return ChoreAssignment A ChoreAssignment object
     */
    public static ChoreAssignment getChoreAssignment() {
		
        ChoreAssignment choreAssignment =  getChoreAssignment(
	        getChild(), getChore(), getParent(), getRewardPolicy());

		return choreAssignment;
       
    }

     /**
     * Data pool factory for ChoreAssignment.
     * @param child A valid Child object
     * @param chore A valid Chore object
     * @param parent A valid Parent object
     * @param rewardPolicy A valid RewardPolicy object
     * @return ChoreAssignment A ChoreAssignment object
     */
    public static ChoreAssignment getChoreAssignment(Child child, Chore chore, Parent parent, RewardPolicy rewardPolicy) {

        ChoreAssignment choreAssignment = new ChoreAssignment();     
		if (child != null) {
			child.addChoreAssignment (choreAssignment);
		}
		if (chore != null) {
			chore.addChoreAssignment (choreAssignment);
		}
        choreAssignment.setCompletedAt(BasicDataGenerator.generateRandomLong());
        choreAssignment.setDueAt(BasicDataGenerator.generateRandomLong());
        choreAssignment.setId(BasicDataGenerator.generateRandomStringChar(36));
		if (parent != null) {
			parent.addChoreAssignment (choreAssignment);
		}
        choreAssignment.setRewardGranted(BasicDataGenerator.generateRandomDouble());
        choreAssignment.setRewardId(BasicDataGenerator.generateRandomStringChar(36));
		if (rewardPolicy != null) {
			rewardPolicy.addChoreAssignment (choreAssignment);
		}

        return choreAssignment;
    }

    /**
     * Data pool factory for Country.
     * @return CountryA Country object
     */
    public static Country getCountry() {

        Country country = new Country();    
        
        country.setId(BasicDataGenerator.generateRandomInt());
        country.setIso3166A2(BasicDataGenerator.generateRandomString(2));
        country.setIso3166A3(BasicDataGenerator.generateRandomString(3));

        return country;
    }

    /**
     * Data pool factory for CountryCurrency.
     * @return CountryCurrency A CountryCurrency object
     */
    public static CountryCurrency getCountryCurrency() {
		
        CountryCurrency countryCurrency =  getCountryCurrency(
	        getCountry(), getCurrency());

		return countryCurrency;
       
    }

     /**
     * Data pool factory for CountryCurrency.
     * @param country A valid Country object
     * @param currency A valid Currency object
     * @return CountryCurrency A CountryCurrency object
     */
    public static CountryCurrency getCountryCurrency(Country country, Currency currency) {

        CountryCurrency countryCurrency = new CountryCurrency();     
		if (country != null) {
			country.addCountryCurrency (countryCurrency);
		}
		if (currency != null) {
			currency.addCountryCurrency (countryCurrency);
		}
        countryCurrency.setId(BasicDataGenerator.generateRandomInt());

        return countryCurrency;
    }

    /**
     * Data pool factory for CountryName.
     * @return CountryName A CountryName object
     */
    public static CountryName getCountryName() {
		
        CountryName countryName =  getCountryName(
	        getCountry(), getLanguage());

		return countryName;
       
    }

     /**
     * Data pool factory for CountryName.
     * @param country A valid Country object
     * @param language A valid Language object
     * @return CountryName A CountryName object
     */
    public static CountryName getCountryName(Country country, Language language) {

        CountryName countryName = new CountryName();     
        countryName.setCommonName(BasicDataGenerator.generateRandomString(50));
		if (country != null) {
			country.addCountryName (countryName);
		}
        countryName.setFormalName(BasicDataGenerator.generateRandomString(100));
        countryName.setId(BasicDataGenerator.generateRandomInt());
		if (language != null) {
			language.addCountryName (countryName);
		}

        return countryName;
    }

    /**
     * Data pool factory for Currency.
     * @return CurrencyA Currency object
     */
    public static Currency getCurrency() {

        Currency currency = new Currency();    
        
        currency.setId(BasicDataGenerator.generateRandomInt());
        currency.setIso4217(BasicDataGenerator.generateRandomString(3));
        currency.setSymbol(BasicDataGenerator.generateRandomString(4));

        return currency;
    }

    /**
     * Data pool factory for CurrencyName.
     * @return CurrencyName A CurrencyName object
     */
    public static CurrencyName getCurrencyName() {
		
        CurrencyName currencyName =  getCurrencyName(
	        getCurrency(), getLanguage());

		return currencyName;
       
    }

     /**
     * Data pool factory for CurrencyName.
     * @param currency A valid Currency object
     * @param language A valid Language object
     * @return CurrencyName A CurrencyName object
     */
    public static CurrencyName getCurrencyName(Currency currency, Language language) {

        CurrencyName currencyName = new CurrencyName();     
		if (currency != null) {
			currency.addCurrencyName (currencyName);
		}
        currencyName.setId(BasicDataGenerator.generateRandomInt());
		if (language != null) {
			language.addCurrencyName (currencyName);
		}
        currencyName.setName(BasicDataGenerator.generateRandomString(50));

        return currencyName;
    }

    /**
     * Data pool factory for EmailAddress.
     * @return EmailAddress A EmailAddress object
     */
    public static EmailAddress getEmailAddress() {
		
        EmailAddress emailAddress =  getEmailAddress(
	        getUser());

		return emailAddress;
       
    }

     /**
     * Data pool factory for EmailAddress.
     * @param user A valid User object
     * @return EmailAddress A EmailAddress object
     */
    public static EmailAddress getEmailAddress(User user) {

        EmailAddress emailAddress = new EmailAddress();     
        emailAddress.setAddress(BasicDataGenerator.generateRandomString(384));
        emailAddress.setId(BasicDataGenerator.generateRandomStringChar(36));
        emailAddress.setResponseCode(BasicDataGenerator.generateRandomBinary(32));
        emailAddress.setSentAt(BasicDataGenerator.generateRandomLong());
        emailAddress.setState((byte)(BasicDataGenerator.generateRandomTinyInt()));
		if (user != null) {
			user.addEmailAddress (emailAddress);
		}

        return emailAddress;
    }

    /**
     * Data pool factory for Family.
     * @return Family A Family object
     */
    public static Family getFamily() {
		
        Family family =  getFamily(
	        getAccount());

		return family;
       
    }

     /**
     * Data pool factory for Family.
     * @param account A valid Account object
     * @return Family A Family object
     */
    public static Family getFamily(Account account) {

        Family family = new Family();     
		if (account != null) {
			account.addFamily (family);
		}
        family.setCreatedAt(BasicDataGenerator.generateRandomLong());
        family.setDeletedAt(BasicDataGenerator.generateRandomLong());
        family.setId(BasicDataGenerator.generateRandomStringChar(36));
        family.setName(BasicDataGenerator.generateRandomString(50));

        return family;
    }

    /**
     * Data pool factory for FamilyChild.
     * @return FamilyChild A FamilyChild object
     */
    public static FamilyChild getFamilyChild() {
		
        FamilyChild familyChild =  getFamilyChild(
	        getChild(), getFamily());

		return familyChild;
       
    }

     /**
     * Data pool factory for FamilyChild.
     * @param child A valid Child object
     * @param family A valid Family object
     * @return FamilyChild A FamilyChild object
     */
    public static FamilyChild getFamilyChild(Child child, Family family) {

        FamilyChild familyChild = new FamilyChild();     
		if (child != null) {
			child.addFamilyChild (familyChild);
		}
		if (family != null) {
			family.addFamilyChild (familyChild);
		}
        familyChild.setId(BasicDataGenerator.generateRandomStringChar(36));

        return familyChild;
    }

    /**
     * Data pool factory for FamilyParent.
     * @return FamilyParent A FamilyParent object
     */
    public static FamilyParent getFamilyParent() {
		
        FamilyParent familyParent =  getFamilyParent(
	        getFamily(), getParent());

		return familyParent;
       
    }

     /**
     * Data pool factory for FamilyParent.
     * @param family A valid Family object
     * @param parent A valid Parent object
     * @return FamilyParent A FamilyParent object
     */
    public static FamilyParent getFamilyParent(Family family, Parent parent) {

        FamilyParent familyParent = new FamilyParent();     
		if (family != null) {
			family.addFamilyParent (familyParent);
		}
        familyParent.setId(BasicDataGenerator.generateRandomStringChar(36));
		if (parent != null) {
			parent.addFamilyParent (familyParent);
		}

        return familyParent;
    }

    /**
     * Data pool factory for Group.
     * @return GroupA Group object
     */
    public static Group getGroup() {

        Group group = new Group();    
        
        group.setCreatedAt(BasicDataGenerator.generateRandomLong());
        group.setDeletedAt(BasicDataGenerator.generateRandomLong());
        group.setDescription(BasicDataGenerator.generateRandomString(250));
        group.setId(BasicDataGenerator.generateRandomStringChar(36));
        group.setName(BasicDataGenerator.generateRandomString(50));

        return group;
    }

    /**
     * Data pool factory for GroupMember.
     * @return GroupMember A GroupMember object
     */
    public static GroupMember getGroupMember() {
		
        GroupMember groupMember =  getGroupMember(
	        getGroup(), getUser());

		return groupMember;
       
    }

     /**
     * Data pool factory for GroupMember.
     * @param group A valid Group object
     * @param user A valid User object
     * @return GroupMember A GroupMember object
     */
    public static GroupMember getGroupMember(Group group, User user) {

        GroupMember groupMember = new GroupMember();     
		if (group != null) {
			group.addGroupMember (groupMember);
		}
        groupMember.setId(BasicDataGenerator.generateRandomStringChar(36));
		if (user != null) {
			user.addGroupMember (groupMember);
		}

        return groupMember;
    }

    /**
     * Data pool factory for Language.
     * @return LanguageA Language object
     */
    public static Language getLanguage() {

        Language language = new Language();    
        
        language.setId(BasicDataGenerator.generateRandomInt());
        language.setIso693A3(BasicDataGenerator.generateRandomString(3));

        return language;
    }

    /**
     * Data pool factory for LanguageName.
     * @return LanguageName A LanguageName object
     */
    public static LanguageName getLanguageName() {
		
        LanguageName languageName =  getLanguageName(
	        getLanguage(), getLanguage());

		return languageName;
       
    }

     /**
     * Data pool factory for LanguageName.
     * @param language A valid Language object
     * @param language2 A valid Language object
     * @return LanguageName A LanguageName object
     */
    public static LanguageName getLanguageName(Language language, Language language2) {

        LanguageName languageName = new LanguageName();     
        languageName.setId(BasicDataGenerator.generateRandomInt());
		if (language != null) {
			language.addLanguageName (languageName);
		}
        languageName.setLanguage2(language2);
        languageName.setNameInL2(BasicDataGenerator.generateRandomString(50));

        return languageName;
    }

    /**
     * Data pool factory for Offering.
     * @return Offering A Offering object
     */
    public static Offering getOffering() {
		
        Offering offering =  getOffering(
	        getCurrency(), getProductPlan());

		return offering;
       
    }

     /**
     * Data pool factory for Offering.
     * @param currency A valid Currency object
     * @param productPlan A valid ProductPlan object
     * @return Offering A Offering object
     */
    public static Offering getOffering(Currency currency, ProductPlan productPlan) {

        Offering offering = new Offering();     
		if (currency != null) {
			currency.addOffering (offering);
		}
        offering.setExpireAt(BasicDataGenerator.generateRandomLong());
        offering.setId(BasicDataGenerator.generateRandomInt());
        offering.setPrice(BasicDataGenerator.generateRandomDouble());
		if (productPlan != null) {
			productPlan.addOffering (offering);
		}
        offering.setStartAt(BasicDataGenerator.generateRandomLong());

        return offering;
    }

    /**
     * Data pool factory for Parent.
     * @return Parent A Parent object
     */
    public static Parent getParent() {
		
        Parent parent =  getParent(
	        getUser());

		return parent;
       
    }

     /**
     * Data pool factory for Parent.
     * @param user A valid User object
     * @return Parent A Parent object
     */
    public static Parent getParent(User user) {

        Parent parent = new Parent();     
        parent.setCreatedAt(BasicDataGenerator.generateRandomLong());
        parent.setDeletedAt(BasicDataGenerator.generateRandomLong());
        parent.setId(BasicDataGenerator.generateRandomStringChar(36));
		if (user != null) {
			user.addParent (parent);
		}

        return parent;
    }

    /**
     * Data pool factory for PaymentFromCc.
     * @return PaymentFromCc A PaymentFromCc object
     */
    public static PaymentFromCc getPaymentFromCc() {
		
        PaymentFromCc paymentFromCc =  getPaymentFromCc(
	        getTransaction());

		return paymentFromCc;
       
    }

     /**
     * Data pool factory for PaymentFromCc.
     * @param transaction A valid Transaction object
     * @return PaymentFromCc A PaymentFromCc object
     */
    public static PaymentFromCc getPaymentFromCc(Transaction transaction) {

        PaymentFromCc paymentFromCc = new PaymentFromCc();     
        paymentFromCc.setId(BasicDataGenerator.generateRandomString(50));
		if (transaction != null) {
			transaction.addPaymentFromCc (paymentFromCc);
		}

        return paymentFromCc;
    }

    /**
     * Data pool factory for PaymentFromPaypal.
     * @return PaymentFromPaypal A PaymentFromPaypal object
     */
    public static PaymentFromPaypal getPaymentFromPaypal() {
		
        PaymentFromPaypal paymentFromPaypal =  getPaymentFromPaypal(
	        getTransaction());

		return paymentFromPaypal;
       
    }

     /**
     * Data pool factory for PaymentFromPaypal.
     * @param transaction A valid Transaction object
     * @return PaymentFromPaypal A PaymentFromPaypal object
     */
    public static PaymentFromPaypal getPaymentFromPaypal(Transaction transaction) {

        PaymentFromPaypal paymentFromPaypal = new PaymentFromPaypal();     
        paymentFromPaypal.setId(BasicDataGenerator.generateRandomString(50));
		if (transaction != null) {
			transaction.addPaymentFromPaypal (paymentFromPaypal);
		}

        return paymentFromPaypal;
    }

    /**
     * Data pool factory for PaymentType.
     * @return PaymentTypeA PaymentType object
     */
    public static PaymentType getPaymentType() {

        PaymentType paymentType = new PaymentType();    
        
        paymentType.setEnumName(BasicDataGenerator.generateRandomString(50));
        paymentType.setId(BasicDataGenerator.generateRandomInt());
        paymentType.setName(BasicDataGenerator.generateRandomString(50));

        return paymentType;
    }

    /**
     * Data pool factory for PlanText.
     * @return PlanText A PlanText object
     */
    public static PlanText getPlanText() {
		
        PlanText planText =  getPlanText(
	        getLanguage(), getProductPlan());

		return planText;
       
    }

     /**
     * Data pool factory for PlanText.
     * @param language A valid Language object
     * @param productPlan A valid ProductPlan object
     * @return PlanText A PlanText object
     */
    public static PlanText getPlanText(Language language, ProductPlan productPlan) {

        PlanText planText = new PlanText();     
        planText.setCreatedAt(BasicDataGenerator.generateRandomLong());
        planText.setDeletedAt(BasicDataGenerator.generateRandomLong());
        planText.setId(BasicDataGenerator.generateRandomStringChar(36));
		if (language != null) {
			language.addPlanText (planText);
		}
        planText.setPlanDescription(BasicDataGenerator.generateRandomString(250));
        planText.setPlanName(BasicDataGenerator.generateRandomString(50));
		if (productPlan != null) {
			productPlan.addPlanText (planText);
		}

        return planText;
    }

    /**
     * Data pool factory for Privilege.
     * @return PrivilegeA Privilege object
     */
    public static Privilege getPrivilege() {

        Privilege privilege = new Privilege();    
        
        privilege.setDescription(BasicDataGenerator.generateRandomString(250));
        privilege.setId(BasicDataGenerator.generateRandomStringChar(36));
        privilege.setName(BasicDataGenerator.generateRandomString(50));

        return privilege;
    }

    /**
     * Data pool factory for PrivilegedGroup.
     * @return PrivilegedGroup A PrivilegedGroup object
     */
    public static PrivilegedGroup getPrivilegedGroup() {
		
        PrivilegedGroup privilegedGroup =  getPrivilegedGroup(
	        getGroup(), getPrivilege());

		return privilegedGroup;
       
    }

     /**
     * Data pool factory for PrivilegedGroup.
     * @param group A valid Group object
     * @param privilege A valid Privilege object
     * @return PrivilegedGroup A PrivilegedGroup object
     */
    public static PrivilegedGroup getPrivilegedGroup(Group group, Privilege privilege) {

        PrivilegedGroup privilegedGroup = new PrivilegedGroup();     
		if (group != null) {
			group.addPrivilegedGroup (privilegedGroup);
		}
        privilegedGroup.setId(BasicDataGenerator.generateRandomStringChar(36));
		if (privilege != null) {
			privilege.addPrivilegedGroup (privilegedGroup);
		}

        return privilegedGroup;
    }

    /**
     * Data pool factory for ProductPlan.
     * @return ProductPlanA ProductPlan object
     */
    public static ProductPlan getProductPlan() {

        ProductPlan productPlan = new ProductPlan();    
        
        productPlan.setCreatedAt(BasicDataGenerator.generateRandomLong());
        productPlan.setDeletedAt(BasicDataGenerator.generateRandomLong());
        productPlan.setId(BasicDataGenerator.generateRandomInt());
        productPlan.setMaxChildren(BasicDataGenerator.generateRandomInt());
        productPlan.setMaxChoreAlertsPerWk(BasicDataGenerator.generateRandomInt());
        productPlan.setPlanDays(BasicDataGenerator.generateRandomInt());
        productPlan.setReportLevel(BasicDataGenerator.generateRandomInt());
        productPlan.setRewardLevel(BasicDataGenerator.generateRandomInt());

        return productPlan;
    }

    /**
     * Data pool factory for Purchase.
     * @return Purchase A Purchase object
     */
    public static Purchase getPurchase() {
		
        Purchase purchase =  getPurchase(
	        getAccount(), getOffering());

		return purchase;
       
    }

     /**
     * Data pool factory for Purchase.
     * @param account A valid Account object
     * @param offering A valid Offering object
     * @return Purchase A Purchase object
     */
    public static Purchase getPurchase(Account account, Offering offering) {

        Purchase purchase = new Purchase();     
		if (account != null) {
			account.addPurchase (purchase);
		}
        purchase.setId(BasicDataGenerator.generateRandomStringChar(36));
		if (offering != null) {
			offering.addPurchase (purchase);
		}

        return purchase;
    }

    /**
     * Data pool factory for Quota.
     * @return QuotaA Quota object
     */
    public static Quota getQuota() {

        Quota quota = new Quota();    
        
        quota.setChoreAlertsUsedThisWk(BasicDataGenerator.generateRandomInt());
        quota.setId(BasicDataGenerator.generateRandomStringChar(36));
        quota.setMaxChildren(BasicDataGenerator.generateRandomInt());
        quota.setMaxChoreAlertsThisWeek(BasicDataGenerator.generateRandomInt());
        quota.setReportLevel(BasicDataGenerator.generateRandomInt());
        quota.setRewardLevel(BasicDataGenerator.generateRandomInt());

        return quota;
    }

    /**
     * Data pool factory for RecurringChoreAssignment.
     * @return RecurringChoreAssignment A RecurringChoreAssignment object
     */
    public static RecurringChoreAssignment getRecurringChoreAssignment() {
		
        RecurringChoreAssignment recurringChoreAssignment =  getRecurringChoreAssignment(
	        getChild(), getChore());

		return recurringChoreAssignment;
       
    }

     /**
     * Data pool factory for RecurringChoreAssignment.
     * @param child A valid Child object
     * @param chore A valid Chore object
     * @return RecurringChoreAssignment A RecurringChoreAssignment object
     */
    public static RecurringChoreAssignment getRecurringChoreAssignment(Child child, Chore chore) {

        RecurringChoreAssignment recurringChoreAssignment = new RecurringChoreAssignment();     
		if (child != null) {
			child.addRecurringChoreAssignment (recurringChoreAssignment);
		}
		if (chore != null) {
			chore.addRecurringChoreAssignment (recurringChoreAssignment);
		}
        recurringChoreAssignment.setId(BasicDataGenerator.generateRandomStringChar(36));
        recurringChoreAssignment.setRecurrArg1(BasicDataGenerator.generateRandomInt());
        recurringChoreAssignment.setRecurrArg2(BasicDataGenerator.generateRandomInt());
        recurringChoreAssignment.setRecurrNTimes(BasicDataGenerator.generateRandomInt());
        recurringChoreAssignment.setRecurrType(BasicDataGenerator.generateRandomInt());
        recurringChoreAssignment.setRecurrUntil(BasicDataGenerator.generateRandomLong());
        recurringChoreAssignment.setStartAt(BasicDataGenerator.generateRandomLong());

        return recurringChoreAssignment;
    }

    /**
     * Data pool factory for Refund.
     * @return Refund A Refund object
     */
    public static Refund getRefund() {
		
        Refund refund =  getRefund(
	        getPurchase());

		return refund;
       
    }

     /**
     * Data pool factory for Refund.
     * @param purchase A valid Purchase object
     * @return Refund A Refund object
     */
    public static Refund getRefund(Purchase purchase) {

        Refund refund = new Refund();     
        refund.setDaysRefunded(BasicDataGenerator.generateRandomInt());
        refund.setId(BasicDataGenerator.generateRandomStringChar(36));
		if (purchase != null) {
			purchase.addRefund (refund);
		}

        return refund;
    }

    /**
     * Data pool factory for Reward.
     * @return Reward A Reward object
     */
    public static Reward getReward() {
		
        Reward reward =  getReward(
	        getRewardType());

		return reward;
       
    }

     /**
     * Data pool factory for Reward.
     * @param rewardType A valid RewardType object
     * @return Reward A Reward object
     */
    public static Reward getReward(RewardType rewardType) {

        Reward reward = new Reward();     
        reward.setId(BasicDataGenerator.generateRandomStringChar(36));
		if (rewardType != null) {
			rewardType.addReward (reward);
		}
        reward.setRewardUnits(BasicDataGenerator.generateRandomDouble());

        return reward;
    }

    /**
     * Data pool factory for RewardEarlyFunction.
     * @return RewardEarlyFunctionA RewardEarlyFunction object
     */
    public static RewardEarlyFunction getRewardEarlyFunction() {

        RewardEarlyFunction rewardEarlyFunction = new RewardEarlyFunction();    
        
        rewardEarlyFunction.setId(BasicDataGenerator.generateRandomInt());
        rewardEarlyFunction.setInternalDescription(BasicDataGenerator.generateRandomString(250));
        rewardEarlyFunction.setInternalName(BasicDataGenerator.generateRandomString(50));

        return rewardEarlyFunction;
    }

    /**
     * Data pool factory for RewardLateFunction.
     * @return RewardLateFunctionA RewardLateFunction object
     */
    public static RewardLateFunction getRewardLateFunction() {

        RewardLateFunction rewardLateFunction = new RewardLateFunction();    
        
        rewardLateFunction.setId(BasicDataGenerator.generateRandomInt());
        rewardLateFunction.setInternalDescription(BasicDataGenerator.generateRandomString(250));
        rewardLateFunction.setInternalName(BasicDataGenerator.generateRandomString(50));

        return rewardLateFunction;
    }

    /**
     * Data pool factory for RewardPolicy.
     * @return RewardPolicy A RewardPolicy object
     */
    public static RewardPolicy getRewardPolicy() {
		
        RewardPolicy rewardPolicy =  getRewardPolicy(
	        getFamily(), getRewardEarlyFunction(), getRewardLateFunction());

		return rewardPolicy;
       
    }

     /**
     * Data pool factory for RewardPolicy.
     * @param family A valid Family object
     * @param rewardEarlyFunction A valid RewardEarlyFunction object
     * @param rewardLateFunction A valid RewardLateFunction object
     * @return RewardPolicy A RewardPolicy object
     */
    public static RewardPolicy getRewardPolicy(Family family, RewardEarlyFunction rewardEarlyFunction, RewardLateFunction rewardLateFunction) {

        RewardPolicy rewardPolicy = new RewardPolicy();     
        rewardPolicy.setEarlyArg1(BasicDataGenerator.generateRandomDouble());
        rewardPolicy.setEarlyArg2(BasicDataGenerator.generateRandomDouble());
		if (family != null) {
			family.addRewardPolicy (rewardPolicy);
		}
        rewardPolicy.setId(BasicDataGenerator.generateRandomStringChar(36));
        rewardPolicy.setLateArg1(BasicDataGenerator.generateRandomDouble());
        rewardPolicy.setLateArg2(BasicDataGenerator.generateRandomDouble());
		if (rewardEarlyFunction != null) {
			rewardEarlyFunction.addRewardPolicy (rewardPolicy);
		}
		if (rewardLateFunction != null) {
			rewardLateFunction.addRewardPolicy (rewardPolicy);
		}

        return rewardPolicy;
    }

    /**
     * Data pool factory for RewardType.
     * @return RewardType A RewardType object
     */
    public static RewardType getRewardType() {
		
        RewardType rewardType =  getRewardType(
	        getFamily());

		return rewardType;
       
    }

     /**
     * Data pool factory for RewardType.
     * @param family A valid Family object
     * @return RewardType A RewardType object
     */
    public static RewardType getRewardType(Family family) {

        RewardType rewardType = new RewardType();     
        rewardType.setCreatedAt(BasicDataGenerator.generateRandomLong());
        rewardType.setDeletedAt(BasicDataGenerator.generateRandomLong());
        rewardType.setDescription(BasicDataGenerator.generateRandomString(250));
		if (family != null) {
			family.addRewardType (rewardType);
		}
        rewardType.setId(BasicDataGenerator.generateRandomStringChar(36));
        rewardType.setName(BasicDataGenerator.generateRandomString(50));

        return rewardType;
    }

    /**
     * Data pool factory for Transaction.
     * @return Transaction A Transaction object
     */
    public static Transaction getTransaction() {
		
        Transaction transaction =  getTransaction(
	        getPaymentType());

		return transaction;
       
    }

     /**
     * Data pool factory for Transaction.
     * @param paymentType A valid PaymentType object
     * @return Transaction A Transaction object
     */
    public static Transaction getTransaction(PaymentType paymentType) {

        Transaction transaction = new Transaction();     
        transaction.setCreatedAt(BasicDataGenerator.generateRandomLong());
        transaction.setId(BasicDataGenerator.generateRandomStringChar(36));
		if (paymentType != null) {
			paymentType.addTransaction (transaction);
		}

        return transaction;
    }

    /**
     * Data pool factory for TransactionItem.
     * @return TransactionItemA TransactionItem object
     */
    public static TransactionItem getTransactionItem() {

        TransactionItem transactionItem = new TransactionItem();    
        
        transactionItem.setId(getTransactionItemPK());

        return transactionItem;
    }

    /**
     * Data pool factory for TransactionItemPK.
     * @return TransactionItemPK A TransactionItemPK object
     */
    public static TransactionItemPK getTransactionItemPK() {
		
        TransactionItemPK transactionItemPK =  getTransactionItemPK(
	        null, null, getTransaction());

		return transactionItemPK;
       
    }

     /**
     * Data pool factory for TransactionItemPK.
     * @param purchase A valid Purchase object
     * @param refund A valid Refund object
     * @param transaction A valid Transaction object
     * @return TransactionItemPK A TransactionItemPK object
     */
    public static TransactionItemPK getTransactionItemPK(Purchase purchase, Refund refund, Transaction transaction) {

        TransactionItemPK transactionItemPK = new TransactionItemPK();     
        transactionItemPK.setPurchase(purchase);
        transactionItemPK.setRefund(refund);
        transactionItemPK.setTransaction(transaction);

        return transactionItemPK;
    }

    /**
     * Data pool factory for User.
     * @return UserA User object
     */
    public static User getUser() {

        User user = new User();    
        
        user.setCreatedAt(BasicDataGenerator.generateRandomLong());
        user.setDeletedAt(BasicDataGenerator.generateRandomLong());
        user.setId(BasicDataGenerator.generateRandomStringChar(36));
        user.setName(BasicDataGenerator.generateRandomString(50));
        user.setPassword(BasicDataGenerator.generateRandomBinary(32));
        user.setSalt(BasicDataGenerator.generateRandomBinary(32));

        return user;
    }
    /** Returns the commit order of this database. 
	 * Useful for iterating through the classes for deletion in the right order. 
	 * @return String[] list of classes
	 */
	public static String[] getDBCommitOrder() {
		return commitOrder;
	}
}