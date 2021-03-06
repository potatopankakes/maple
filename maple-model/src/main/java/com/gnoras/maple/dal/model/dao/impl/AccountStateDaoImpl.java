package com.gnoras.maple.dal.model.dao.impl;

import java.io.Serializable;
import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import com.gnoras.maple.dal.model.AccountState;
import org.springframework.stereotype.Repository;
import com.gnoras.maple.dal.model.dao.AccountStateDao;

/**
 * DAO for table: AccountState.
 * @author autogenerated
 */
@Repository
public class AccountStateDaoImpl extends GenericHibernateDaoImpl<AccountState, Serializable> implements AccountStateDao {
	
	/** Constructor method. */
		public AccountStateDaoImpl() {
			super(AccountState.class);
		}
	}

