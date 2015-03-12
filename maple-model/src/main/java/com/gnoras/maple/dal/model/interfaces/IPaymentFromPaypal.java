package com.gnoras.maple.dal.model.interfaces;
import com.gnoras.maple.dal.model.Transaction;


/** 
 * Object interface mapping for hibernate-handled table: payment_from_paypal.
 * @author autogenerated
 */

public interface IPaymentFromPaypal {



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
     * Return the value associated with the column: transaction.
	 * @return A Transaction object (this.transaction)
	 */
	Transaction getTransaction();
	

  
    /**  
     * Set the value related to the column: transaction.
	 * @param transaction the transaction value you wish to set
	 */
	void setTransaction(final Transaction transaction);

	// end of interface
}