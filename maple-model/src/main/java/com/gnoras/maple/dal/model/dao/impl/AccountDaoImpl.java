package com.gnoras.maple.dal.model.dao.impl;

import java.io.Serializable;
import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import com.gnoras.maple.dal.model.Account;
import org.springframework.stereotype.Repository;
import com.gnoras.maple.dal.model.dao.AccountDao;

/**
 * DAO for table: Account.
 * @author autogenerated
 */
@Repository
public class AccountDaoImpl extends GenericHibernateDaoImpl<Account, Serializable> implements AccountDao {
	
	/** Constructor method. */
		public AccountDaoImpl() {
			super(Account.class);
		}
	}
