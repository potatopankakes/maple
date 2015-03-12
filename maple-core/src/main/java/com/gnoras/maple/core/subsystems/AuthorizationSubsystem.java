package com.gnoras.maple.core.subsystems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.gnoras.maple.core.constants.SystemPrivileges;
import com.gnoras.maple.core.exceptions.ItemNotFoundException;
import com.gnoras.maple.core.exceptions.UnauthorizedAccessException;
import com.gnoras.maple.core.interfaces.IAuthorizationSubsystem;
import com.gnoras.maple.core.interfaces.ILoginSubsystem;
import com.gnoras.maple.core.interfaces.ISessionRequestContext;
import com.gnoras.maple.dal.factories.HibernateMapleDaoFactory;
import com.gnoras.maple.dal.model.Group;
import com.gnoras.maple.dal.model.GroupMember;
import com.gnoras.maple.dal.model.PrivilegedGroup;
import com.gnoras.maple.dal.model.ProductPlan;
import com.gnoras.maple.dal.model.Purchase;
import com.gnoras.maple.dal.model.User;
import com.gnoras.maple.dal.model.interfaces.IGroup;
import com.gnoras.maple.dal.model.interfaces.IProductPlan;
import com.gnoras.maple.dal.model.interfaces.IUser;
import com.gnoras.maple.dal.services.DataLayerMapleImpl;

public class AuthorizationSubsystem implements IAuthorizationSubsystem {

	private int timeout = 5000;

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int t) {
		timeout = t;
	}

	private ILoginSubsystem loginSubsystem;

	public void setLoginSubsystem(ILoginSubsystem ss) {
		loginSubsystem = ss;
	}
	
	private void validate(String uuid) throws IllegalArgumentException {
		UUID.fromString(uuid);
	}
	
	private List<IGroup> _listGroupsWithPrivilege(String privilegeId) throws UnauthorizedAccessException, IllegalArgumentException {
		validate(privilegeId);
		
//		HibernateMapleDaoFactory.getPrivilegedGroupDao().findByCriteria(criterion);
				
//		List<IGroup> finalList = new ArrayList<IGroup>(list.size());
//		for (IGroup g : list) {
//			finalList.add(g);
//		}
//		return finalList;
		
		return null;
	}
	
	private List<IUser> _listUsersInGroup(String groupId) throws UnauthorizedAccessException, IllegalArgumentException {
		return null;
	}


	@Override
	public boolean havePrivilege(String privilegeId, ISessionRequestContext rc)
			throws IllegalArgumentException {
		String loggedInUserId = loginSubsystem.getLoggedUserId(rc);
		
		Criteria criteria = DataLayerMapleImpl.getInstance().createCriteria(User.class);
		criteria.setTimeout(getTimeout());
		criteria.add(Restrictions.eq("User.id", loggedInUserId));
		criteria.add(Restrictions.eq("User.deleted_at", 0));
		criteria.createAlias("GroupMember", "gm");
		criteria.createAlias("gm.Group", "g");
		criteria.createAlias("g.PrivilegedGroup", "pg");
		criteria.add(Restrictions.eq("pg.privilege_id", privilegeId));
		criteria.setLockMode(LockMode.NONE);
		@SuppressWarnings("unchecked")
		List<User> users = criteria.list();
		return users.size() > 0 ? true : false;
		
		
		// get groups that have the privilege
//		List<IGroup> groups = _listGroupsWithPrivilege(privilegeId);
//		// get users in each group
//		for (IGroup group : groups) {
//			List<IUser> users = _listUsersInGroup(group.getId());
//			for (IUser user : users) { // TODO look at doing this in O(lg(n)) ... not O(n)
//				if (user.getId() == loggedInUserId) {
//					return true;
//				}
//			}
//		}
//		return false;
	}

	@Override
	public boolean havePrivileges(List<String> privilegeIds, ISessionRequestContext rc)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public String createGroup(String name, String description) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteGroup(String groupId) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<IGroup> listGroups() throws UnauthorizedAccess {
//		String loggedInUserId = getLoginSubsystem().getLoggedUserId();
//		if (belongsToGroup(loggedInUserId, SystemGroups.Administrators)) {
//			
//			@SuppressWarnings("unchecked")
//			List<Group> list = (List<Group>) DataLayerMapleImpl
//					.getInstance().createCriteria(Group.class).list();
//			List<IGroup> finalList = new ArrayList<IGroup>(list.size());
//			for (IGroup g : list) {
//				finalList.add(g);
//			}
//			return finalList;
//		}
//		else {
//			throw new UnauthorizedAccess("Access denied");
//		}
//	}
//
//	@Override
//	public void addToGroup(String userId, String groupId) throws UnauthorizedAccess, IllegalArgumentException {
//		validate(groupId);
//		validate(userId);
//		String loggedInUserId = getLoginSubsystem().getLoggedUserId();
//		if (belongsToGroup(loggedInUserId, SystemGroups.Administrators)) {
//			
//			User user = new User();
//			user.setId(userId);
//			
//			Group group = new Group();
//			group.setId(groupId);
//			
//			GroupMember groupMember = new GroupMember();
//			groupMember.setUser(user);
//			groupMember.setGroup(group);
//			
//			DataLayerMapleImpl.getInstance().save(groupMember);
//		}
//		else {
//			throw new UnauthorizedAccess("Access denied");
//		}
//	}
//	
//	@Override
//	public void removeFromGroup(String userId, String groupId) throws UnauthorizedAccess, IllegalArgumentException, ItemNotFoundException {
//		validate(groupId);
//		validate(userId);
//		String loggedInUserId = getLoginSubsystem().getLoggedUserId();
//		if (belongsToGroup(loggedInUserId, SystemGroups.Administrators)) {
//			
//			Criteria criteria = DataLayerMapleImpl.getInstance().createCriteria(
//					GroupMember.class);
//			criteria.setTimeout(getTimeout());
//			criteria.add(Restrictions.eq("group_id", groupId)).add(
//					Restrictions.eq("user_id", userId));
//			GroupMember gm = (GroupMember) criteria.uniqueResult();
//			if ( gm != null ) {
//				DataLayerMapleImpl.getInstance().delete(gm);
//			}
//			else {
//				throw new ItemNotFoundException("Group membership was not found.");
//			}
//		}
//		else {
//			throw new UnauthorizedAccess("Access denied.");
//		}
//	}
//
//	@Override
//	public void removeFromAllGroups(String userId) {
//		validate(userId);
//		String loggedInUserId = getLoginSubsystem().getLoggedUserId();
//		if (belongsToGroup(loggedInUserId, SystemGroups.Administrators)) {
//			
//			Query q = DataLayerMapleImpl.getInstance().createQuery("delete from GroupMember as gm where gm.user_id = :uid");
//			q.setParameter("uid", userId);
//			int i = q.executeUpdate();
//			
//			if (i == 0 ){
//				throw new ItemNotFoundException("Group membership was not found.");
//			}
//		}
//		else {
//			throw new UnauthorizedAccess("Access denied.");
//		}
//	}
//
//	@Override
//	public boolean belongsToGroup(String userId, String groupId) {
//		validate(groupId);
//		validate(userId);
//		String loggedInUserId = getLoginSubsystem().getLoggedUserId();
//		if (belongsToGroup(loggedInUserId, SystemGroups.Administrators)) {
//			
//			Criteria criteria = DataLayerMapleImpl.getInstance().createCriteria(
//					GroupMember.class);
//			criteria.setTimeout(getTimeout());
//			criteria.add(Restrictions.eq("group_id", groupId)).add(
//					Restrictions.eq("user_id", userId));
//			GroupMember gm = (GroupMember) criteria.uniqueResult();
//			if ( gm != null ) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		}
//		else {
//			throw new UnauthorizedAccess("Access denied");
//		return false;
//	}
//
//	@Override
//	public boolean belongsToGroup(String userId, List<String> groupIds) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean belongsToAllGroups(String userId, List<String> groupIds) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public List<String> listUsersInGroup(String groupId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void joinGroup(String groupId) throws IllegalArgumentException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void leaveGroup(String groupId) throws IllegalArgumentException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void leaveAllGroups() throws IllegalArgumentException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public boolean belongsToGroup(String groupId)
//			throws IllegalArgumentException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean belongsToGroup(List<String> groupIds)
//			throws IllegalArgumentException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean belongsToAllGroups(List<String> groupIds)
//			throws IllegalArgumentException {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
