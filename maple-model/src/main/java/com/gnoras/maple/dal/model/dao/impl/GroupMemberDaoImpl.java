package com.gnoras.maple.dal.model.dao.impl;

import java.io.Serializable;
import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import com.gnoras.maple.dal.model.GroupMember;
import org.springframework.stereotype.Repository;
import com.gnoras.maple.dal.model.dao.GroupMemberDao;

/**
 * DAO for table: GroupMember.
 * @author autogenerated
 */
@Repository
public class GroupMemberDaoImpl extends GenericHibernateDaoImpl<GroupMember, Serializable> implements GroupMemberDao {
	
	/** Constructor method. */
		public GroupMemberDaoImpl() {
			super(GroupMember.class);
		}
	}
