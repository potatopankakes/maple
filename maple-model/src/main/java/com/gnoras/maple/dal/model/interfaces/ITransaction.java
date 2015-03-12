package com.gnoras.maple.dal.model.interfaces;
import com.gnoras.maple.dal.model.PaymentFromCc;
import com.gnoras.maple.dal.model.PaymentFromPaypal;
import com.gnoras.maple.dal.model.PaymentType;
import com.gnoras.maple.dal.model.TransactionItem;
import java.util.Set;


/** 
 * Object interface mapping for hibernate-handled table: transaction.
 * @author autogenerated
 */

public interface ITransaction {



    /**
     * Return the value associated with the column: createdAt.
	 * @return A Long object (this.createdAt)
	 */
	Long getCreatedAt();
	

  
    /**  
     * Set the value related to the column: createdAt.
	 * @param createdAt the createdAt value you wish to set
	 */
	void setCreatedAt(final Long createdAt);

    /**
     * Return the value associated with the column: id.
	 * @return A String object (this.id)
	 */
	String getId();
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	void setId(final String id);

    /**
     * Return the value associated with the column: paymentFromCc.
	 * @return A Set&lt;PaymentFromCc&gt; object (this.paymentFromCc)
	 */
	Set<PaymentFromCc> getPaymentFromCcs();
	
	/**
	 * Adds a bi-directional link of type PaymentFromCc to the paymentFromCcs set.
	 * @param paymentFromCc item to add
	 */
	void addPaymentFromCc(PaymentFromCc paymentFromCc);

  
    /**  
     * Set the value related to the column: paymentFromCc.
	 * @param paymentFromCc the paymentFromCc value you wish to set
	 */
	void setPaymentFromCcs(final Set<PaymentFromCc> paymentFromCc);

    /**
     * Return the value associated with the column: paymentFromPaypal.
	 * @return A Set&lt;PaymentFromPaypal&gt; object (this.paymentFromPaypal)
	 */
	Set<PaymentFromPaypal> getPaymentFromPaypals();
	
	/**
	 * Adds a bi-directional link of type PaymentFromPaypal to the paymentFromPaypals set.
	 * @param paymentFromPaypal item to add
	 */
	void addPaymentFromPaypal(PaymentFromPaypal paymentFromPaypal);

  
    /**  
     * Set the value related to the column: paymentFromPaypal.
	 * @param paymentFromPaypal the paymentFromPaypal value you wish to set
	 */
	void setPaymentFromPaypals(final Set<PaymentFromPaypal> paymentFromPaypal);

    /**
     * Return the value associated with the column: paymentType.
	 * @return A PaymentType object (this.paymentType)
	 */
	PaymentType getPaymentType();
	

  
    /**  
     * Set the value related to the column: paymentType.
	 * @param paymentType the paymentType value you wish to set
	 */
	void setPaymentType(final PaymentType paymentType);

    /**
     * Return the value associated with the column: transactionItem.
	 * @return A Set&lt;TransactionItem&gt; object (this.transactionItem)
	 */
	Set<TransactionItem> getTransactionItems();
	
	/**
	 * Adds a bi-directional link of type TransactionItem to the transactionItems set.
	 * @param transactionItem item to add
	 */
	void addTransactionItem(TransactionItem transactionItem);

  
    /**  
     * Set the value related to the column: transactionItem.
	 * @param transactionItem the transactionItem value you wish to set
	 */
	void setTransactionItems(final Set<TransactionItem> transactionItem);

	// end of interface
}