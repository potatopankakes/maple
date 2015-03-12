package com.gnoras.maple.dal.model.interfaces;
import com.gnoras.maple.dal.model.TransactionItemPK;


/** 
 * Object interface mapping for hibernate-handled table: transaction_item.
 * @author autogenerated
 */

public interface ITransactionItem {



    /**
     * Return the value associated with the column: id.
	 * @return A TransactionItemPK object (this.id)
	 */
	TransactionItemPK getId();
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	void setId(final TransactionItemPK id);

	// end of interface
}