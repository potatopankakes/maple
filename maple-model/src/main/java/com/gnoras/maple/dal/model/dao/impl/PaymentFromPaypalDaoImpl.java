package com.gnoras.maple.dal.model.dao.impl;

import java.io.Serializable;
import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import com.gnoras.maple.dal.model.PaymentFromPaypal;
import org.springframework.stereotype.Repository;
import com.gnoras.maple.dal.model.dao.PaymentFromPaypalDao;

/**
 * DAO for table: PaymentFromPaypal.
 * @author autogenerated
 */
@Repository
public class PaymentFromPaypalDaoImpl extends GenericHibernateDaoImpl<PaymentFromPaypal, Serializable> implements PaymentFromPaypalDao {
	
	/** Constructor method. */
		public PaymentFromPaypalDaoImpl() {
			super(PaymentFromPaypal.class);
		}
	}

