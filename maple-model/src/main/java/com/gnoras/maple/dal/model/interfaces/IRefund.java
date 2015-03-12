package com.gnoras.maple.dal.model.interfaces;
import com.gnoras.maple.dal.model.Purchase;
import com.gnoras.maple.dal.model.TransactionItem;
import java.util.Set;


/** 
 * Object interface mapping for hibernate-handled table: refund.
 * @author autogenerated
 */

public interface IRefund {



    /**
     * Return the value associated with the column: daysRefunded.
	 * @return A Integer object (this.daysRefunded)
	 */
	Integer getDaysRefunded();
	

  
    /**  
     * Set the value related to the column: daysRefunded.
	 * @param daysRefunded the daysRefunded value you wish to set
	 */
	void setDaysRefunded(final Integer daysRefunded);

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
     * Return the value associated with the column: purchase.
	 * @return A Purchase object (this.purchase)
	 */
	Purchase getPurchase();
	

  
    /**  
     * Set the value related to the column: purchase.
	 * @param purchase the purchase value you wish to set
	 */
	void setPurchase(final Purchase purchase);

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