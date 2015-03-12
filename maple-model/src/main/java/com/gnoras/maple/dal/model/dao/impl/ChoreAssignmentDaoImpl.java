package com.gnoras.maple.dal.model.dao.impl;

import java.io.Serializable;
import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import com.gnoras.maple.dal.model.ChoreAssignment;
import org.springframework.stereotype.Repository;
import com.gnoras.maple.dal.model.dao.ChoreAssignmentDao;

/**
 * DAO for table: ChoreAssignment.
 * @author autogenerated
 */
@Repository
public class ChoreAssignmentDaoImpl extends GenericHibernateDaoImpl<ChoreAssignment, Serializable> implements ChoreAssignmentDao {
	
	/** Constructor method. */
		public ChoreAssignmentDaoImpl() {
			super(ChoreAssignment.class);
		}
	}

