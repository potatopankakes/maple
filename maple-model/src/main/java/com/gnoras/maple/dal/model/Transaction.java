package com.gnoras.maple.dal.model;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import com.felees.hbnpojogen.persistence.validator.Mandatory;
import com.gnoras.maple.dal.model.PaymentFromCc;
import com.gnoras.maple.dal.model.PaymentFromPaypal;
import com.gnoras.maple.dal.model.TransactionItem;
import com.gnoras.maple.dal.model.interfaces.ITransaction;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.validator.Length;
import org.hibernate.validator.Valid;


/** 
 * Object mapping for hibernate-handled table: transaction.
 * @author autogenerated
 */

@Entity
@Table(name = "transaction", catalog = "maple")
public class Transaction implements Cloneable, Serializable, IPojoGenEntity, ITransaction {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559024012L;
	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, String> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, String>());
	
	/** hashCode temporary storage. */
	private volatile String hashCode;
	

	/** Field mapping. */
	private Long createdAt;
	/** Field mapping. */
	private String id;
	/** Field mapping. */
	private Set<PaymentFromCc> paymentFromCcs = new HashSet<PaymentFromCc>();

	/** Field mapping. */
	private Set<PaymentFromPaypal> paymentFromPaypals = new HashSet<PaymentFromPaypal>();

	/** Field mapping. */
	private PaymentType paymentType;
	/** Field mapping. */
	private Set<TransactionItem> transactionItems = new HashSet<TransactionItem>();

	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Transaction() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Transaction(String id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param createdAt Long object;
	 * @param id String object;
	 * @param paymentType PaymentType object;
	 */
	public Transaction(Long createdAt, String id, PaymentType paymentType) {

		this.createdAt = createdAt;
		this.id = id;
		this.paymentType = paymentType;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Transaction.class;
	}
 

    /**
     * Return the value associated with the column: createdAt.
	 * @return A Long object (this.createdAt)
	 */
	@Mandatory
	@Column( name = "created_at"  )
	public Long getCreatedAt() {
		return this.createdAt;
		
	}
	

  
    /**  
     * Set the value related to the column: createdAt.
	 * @param createdAt the createdAt value you wish to set
	 */
	public void setCreatedAt(final Long createdAt) {
		this.createdAt = createdAt;
	}

    /**
     * Return the value associated with the column: id.
	 * @return A String object (this.id)
	 */
    @Id 
	@Mandatory
	@Length(max=36)
	@Column( name = "id", length = 36  )
	public String getId() {
		return this.id;
		
	}
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final String id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null ) &&
				(id != null) &&
				(this.hashCode != null) ) {
			SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

    /**
     * Return the value associated with the column: paymentFromCc.
	 * @return A Set&lt;PaymentFromCc&gt; object (this.paymentFromCc)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "transaction"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Valid
	public Set<PaymentFromCc> getPaymentFromCcs() {
		return this.paymentFromCcs;
		
	}
	
	/**
	 * Adds a bi-directional link of type PaymentFromCc to the paymentFromCcs set.
	 * @param paymentFromCc item to add
	 */
	public void addPaymentFromCc(PaymentFromCc paymentFromCc) {
		paymentFromCc.setTransaction(this);
		this.paymentFromCcs.add(paymentFromCc);
	}

  
    /**  
     * Set the value related to the column: paymentFromCc.
	 * @param paymentFromCc the paymentFromCc value you wish to set
	 */
	public void setPaymentFromCcs(final Set<PaymentFromCc> paymentFromCc) {
		this.paymentFromCcs = paymentFromCc;
	}

    /**
     * Return the value associated with the column: paymentFromPaypal.
	 * @return A Set&lt;PaymentFromPaypal&gt; object (this.paymentFromPaypal)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "transaction"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Valid
	public Set<PaymentFromPaypal> getPaymentFromPaypals() {
		return this.paymentFromPaypals;
		
	}
	
	/**
	 * Adds a bi-directional link of type PaymentFromPaypal to the paymentFromPaypals set.
	 * @param paymentFromPaypal item to add
	 */
	public void addPaymentFromPaypal(PaymentFromPaypal paymentFromPaypal) {
		paymentFromPaypal.setTransaction(this);
		this.paymentFromPaypals.add(paymentFromPaypal);
	}

  
    /**  
     * Set the value related to the column: paymentFromPaypal.
	 * @param paymentFromPaypal the paymentFromPaypal value you wish to set
	 */
	public void setPaymentFromPaypals(final Set<PaymentFromPaypal> paymentFromPaypal) {
		this.paymentFromPaypals = paymentFromPaypal;
	}

    /**
     * Return the value associated with the column: paymentType.
	 * @return A PaymentType object (this.paymentType)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "payment_type_id" )
	@Valid
	public PaymentType getPaymentType() {
		return this.paymentType;
		
	}
	

  
    /**  
     * Set the value related to the column: paymentType.
	 * @param paymentType the paymentType value you wish to set
	 */
	public void setPaymentType(final PaymentType paymentType) {
		this.paymentType = paymentType;
	}

    /**
     * Return the value associated with the column: transactionItem.
	 * @return A Set&lt;TransactionItem&gt; object (this.transactionItem)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "id.transaction"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Valid
	public Set<TransactionItem> getTransactionItems() {
		return this.transactionItems;
		
	}
	
	/**
	 * Adds a bi-directional link of type TransactionItem to the transactionItems set.
	 * @param transactionItem item to add
	 */
	public void addTransactionItem(TransactionItem transactionItem) {
		transactionItem.getId().setTransaction(this);
		this.transactionItems.add(transactionItem);
	}

  
    /**  
     * Set the value related to the column: transactionItem.
	 * @param transactionItem the transactionItem value you wish to set
	 */
	public void setTransactionItems(final Set<TransactionItem> transactionItem) {
		this.transactionItems = transactionItem;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Transaction clone() throws CloneNotSupportedException {
		super.clone();  // keep hierarchy
        final Transaction copy = new Transaction();

		copy.setCreatedAt(this.getCreatedAt());
		copy.setId(this.getId());
		if (this.getPaymentFromCcs() != null) {
			copy.getPaymentFromCcs().addAll(this.getPaymentFromCcs());
		}
		if (this.getPaymentFromPaypals() != null) {
			copy.getPaymentFromPaypals().addAll(this.getPaymentFromPaypals());
		}
		copy.setPaymentType(this.getPaymentType());
		if (this.getTransactionItems() != null) {
			copy.getTransactionItems().addAll(this.getTransactionItems());
		}
		return copy;
	}
	
 
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("createdAt: " + this.getCreatedAt() + ", ");
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
		
		final Transaction that; 
		try {
			that = (Transaction) proxyThat;
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
		result = result && (((getCreatedAt() == null) && (that.getCreatedAt() == null)) || (getCreatedAt() != null && getCreatedAt().equals(that.getCreatedAt())));
		result = result && (((getPaymentType() == null) && (that.getPaymentType() == null)) || (getPaymentType() != null && getPaymentType().equals(that.getPaymentType())));
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
					String newHashCode = null;

					if ( getId() != null ) {
						newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null ) {
							newHashCode = getId();
						} else {
						newHashCode = String.valueOf(super.hashCode());

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
	return this.hashCode.hashCode();
	}
	
	

	
}
