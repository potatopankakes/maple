package com.gnoras.maple.core.interfaces;

import java.util.List;

import com.gnoras.maple.core.exceptions.ItemNotFoundException;
import com.gnoras.maple.core.exceptions.UnauthorizedAccessException;
import com.gnoras.maple.dal.model.interfaces.IGroup;
import com.gnoras.maple.dal.model.interfaces.IPrivilege;
import com.gnoras.maple.dal.model.interfaces.IUser;

public interface IAuthorizationSubsystem {

	// active caller query privileges
	public boolean havePrivilege(String privilegeId, ISessionRequestContext rc) throws IllegalArgumentException;
	public boolean havePrivileges(List<String> privilegeIds, ISessionRequestContext rc) throws IllegalArgumentException;
	
	
/*	
	// privileges
	void givePrivilegeToGroup(String privilegeId, String groupId) throws UnauthorizedAccess, IllegalArgumentException;
	void givePrivilegeToGroups(String privilegeId, List<String> groupIds) throws UnauthorizedAccess, IllegalArgumentException;
	
	void revokePrivilegeFromGroup(String privilegeId, String groupId) throws UnauthorizedAccess, IllegalArgumentException;
	void revokePrivilegeFromGroups(String privilegeId, List<String> groupIds) throws UnauthorizedAccess, IllegalArgumentException;

	List<IPrivilege> listPrivileges() throws UnauthorizedAccess;
	IPrivilege getPrivilege(String PrivilegeId)  throws UnauthorizedAccess, IllegalArgumentException;
	
	List<IGroup> listGroupsWithPrivilege(String privilegeId) throws UnauthorizedAccess, IllegalArgumentException;
	List<IUser> listUsersWithPrivilege(String privilegeId) throws UnauthorizedAccess, IllegalArgumentException;

	List<IPrivilege> listPrivilegesOfUser(String userId)  throws UnauthorizedAccess, IllegalArgumentException;
	List<IPrivilege> listPrivilegesOfGroup(String groupId)  throws UnauthorizedAccess, IllegalArgumentException;
	
	boolean hasPrivilege(String privilegeId, String userId) throws UnauthorizedAccess, IllegalArgumentException;
	boolean hasPrivileges(List<String> privilegeIds, String userId) throws UnauthorizedAccess, IllegalArgumentException;
	
	// groups
	String createGroup(String name, String description) throws UnauthorizedAccess, IllegalArgumentException;
	void deleteGroup(String groupId) throws UnauthorizedAccess, IllegalArgumentException;
	IGroup getGroup(String groupId) throws UnauthorizedAccess, IllegalArgumentException;
	List<IGroup> listGroups() throws UnauthorizedAccess;

	void addToGroup(String userId, String groupId) throws UnauthorizedAccess, IllegalArgumentException;
	void removeFromGroup(String userId, String groupId) throws UnauthorizedAccess, IllegalArgumentException, ItemNotFoundException;
	void removeFromAllGroups(String userId) throws UnauthorizedAccess, IllegalArgumentException;

	boolean belongsToGroup(String userId, String groupId) throws UnauthorizedAccess, IllegalArgumentException;
	boolean belongsToGroup(String userId, List<String> groupIds) throws UnauthorizedAccess, IllegalArgumentException;

	void joinGroup(String groupId) throws IllegalArgumentException;
	void leaveGroup(String groupId) throws IllegalArgumentException;
	void leaveAllGroups() throws IllegalArgumentException;

	boolean belongsToGroup(String groupId) throws IllegalArgumentException;
	boolean belongsToGroup(List<String> groupIds) throws IllegalArgumentException;
	boolean belongsToAllGroups(List<String> groupIds) throws IllegalArgumentException;

	List<String> listUsersInGroup(String groupId) throws UnauthorizedAccess, IllegalArgumentException;
*/
}
