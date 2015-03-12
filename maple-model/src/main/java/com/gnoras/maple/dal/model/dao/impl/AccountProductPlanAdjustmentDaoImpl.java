package com.gnoras.maple.dal.model.dao.impl;

import java.io.Serializable;
import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import com.gnoras.maple.dal.model.AccountProductPlanAdjustment;
import org.springframework.stereotype.Repository;
import com.gnoras.maple.dal.model.dao.AccountProductPlanAdjustmentDao;

/**
 * DAO for table: AccountProductPlanAdjustment.
 * @author autogenerated
 */
@Repository
public class AccountProductPlanAdjustmentDaoImpl extends GenericHibernateDaoImpl<AccountProductPlanAdjustment, Serializable> implements AccountProductPlanAdjustmentDao {
	
	/** Constructor method. */
		public AccountProductPlanAdjustmentDaoImpl() {
			super(AccountProductPlanAdjustment.class);
		}
	}

