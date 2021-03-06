package com.gnoras.maple.dal.model.dao.impl;

import java.io.Serializable;
import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import com.gnoras.maple.dal.model.FamilyParent;
import org.springframework.stereotype.Repository;
import com.gnoras.maple.dal.model.dao.FamilyParentDao;

/**
 * DAO for table: FamilyParent.
 * @author autogenerated
 */
@Repository
public class FamilyParentDaoImpl extends GenericHibernateDaoImpl<FamilyParent, Serializable> implements FamilyParentDao {
	
	/** Constructor method. */
		public FamilyParentDaoImpl() {
			super(FamilyParent.class);
		}
	}

