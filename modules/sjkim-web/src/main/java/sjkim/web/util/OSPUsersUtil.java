package sjkim.web.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

public class OSPUsersUtil {
	
	private static Log _log = LogFactoryUtil.getLog(OSPUsersUtil.class);
	
	/**
	 * 해당 유저의 해당 사이트룰 삭제
	 * @param user
	 * @param groupId
	 * @param siteRoleName
	 */
	public static void deleteSiteRole(User user,Long groupId, String siteRoleName){
		try{
			Role role = RoleLocalServiceUtil.getRole(user.getCompanyId(), siteRoleName);
			UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(user.getUserId(), groupId, new long[] {role.getRoleId()});
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
		}
		
	}

	/**
	 * Get OSP's used Roles by Role Type.
	 * 
	 * @param roleType
	 * @return
	 */
	public static List<Role> getOSPRoleList(int roleType){
		List<Role> returnList = new ArrayList<Role>();
		try{
			long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();
			List<Role> roleList = RoleLocalServiceUtil.getRoles(companyId);
			for(Role role : roleList){
				if(role.getType()==roleType){
					returnList.add(role);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
		}
		return returnList;
	}
	
	/**
	 * Get User's Regular Roles.
	 * 
	 * @param user
	 * @return
	 */
	public static List<Role> getUserRegularRoles(User user){
		List<Role> returnList = new ArrayList<Role>();
		try{
			returnList = RoleLocalServiceUtil.getUserRoles(user.getUserId());
			for(UserGroup userGroup : user.getUserGroups()){
				List<Role> roleList =RoleLocalServiceUtil.getGroupRoles(userGroup.getGroup().getGroupId());
				for(Role role:roleList){
					returnList.add(role);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
		}
		
		return returnList;
	}
	
	/**
	 * 해당 유저에게 레귤러 룰 추가
	 * @param user
	 * @param roleName
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static boolean addRegularRole(User user,String roleName) throws PortalException, SystemException{
		if(ArrayUtil.contains(CustomRoleConstants.SYSTEM_REGULAR_ROLES,roleName)){
			if(isRegularRole(user, roleName)){return false;}else{
				Role role = RoleLocalServiceUtil.getRole(user.getCompanyId(), roleName);
				RoleLocalServiceUtil.addUserRole(user.getUserId(), role.getRoleId());
				return true;
			}
		}else{
			_log.error(roleName+"<<---IS NOT Regular ROLE");
			return false;
		}
	}
	
	/**
	 * Remove User's Regular Rols.
	 * 
	 * @param user
	 * @param roleName
	 */
	public static void removeUserRegularRole(User user,String roleName){
		try{
			Role role = RoleLocalServiceUtil.getRole(user.getCompanyId(), roleName);
			RoleLocalServiceUtil.deleteUserRole(user.getUserId(),role.getRoleId());
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
		}
	}
	
	/**
	 * Checking for regular roles inclusion.
	 * 
	 * @param user
	 * @param roleName
	 * @return
	 */
	public static boolean isRegularRole(User user, String roleName){
		try{
			long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();
			return RoleServiceUtil.hasUserRole(user.getUserId(), companyId, roleName, true);
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}

	}
	
	/**
	 * Get User's Site Roles.
	 * 
	 * @param user
	 * @return
	 */
	public static List<Role> getUserSiteRoles(User user){
		List<Role> returnList = new ArrayList<Role>();
		
		try{
			List<UserGroupRole> userGroupList = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user.getUserId());
			for(UserGroupRole userGroupRole:userGroupList){
				returnList.add(userGroupRole.getRole());
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
		}
		return returnList;
	}
	
	/**
	 * Add Site Role to User.
	 * 
	 * @param user
	 * @param groupId
	 * @param siteRoleName
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static boolean addUserSiteRole(User user,Long groupId, String siteRoleName) throws PortalException, SystemException{
		if(ArrayUtil.contains(CustomRoleConstants.SYSTEM_SITE_ROLES,siteRoleName)){
			if(isSiteRole(user,groupId,siteRoleName)){return false;}else{
				Role role = RoleLocalServiceUtil.getRole(user.getCompanyId(), siteRoleName);
				UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(),groupId, new long[] {role.getRoleId()});
				return true;
			}
		}else{
			_log.error(siteRoleName+"<<---IS NOT SITE ROLE");
			return false;
		}
	}
	
	/**
	 * Remove User's Site Role.
	 * 
	 * @param user
	 * @param groupId
	 * @param siteRoleName
	 */
	public static void removeUserSiteRole(User user,Long groupId, String siteRoleName){
		try{
			Role role = RoleLocalServiceUtil.getRole(user.getCompanyId(), siteRoleName);
			UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(user.getUserId(), groupId, new long[] {role.getRoleId()});
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
		}
		
	}
	
	/**
	 * Checking for site roles inclusion.
	 * 
	 * @param user
	 * @param groupId
	 * @param siteRoleName
	 * @return
	 */
	public static boolean isSiteRole(User user,Long groupId, String siteRoleName){
		try{
			if(siteRoleName.equals(CustomRoleConstants.SITE_MEMBER)){
				return GroupLocalServiceUtil.hasUserGroup(user.getUserId(), groupId);
			}else{
				return UserGroupRoleLocalServiceUtil.hasUserGroupRole(user.getUserId(),groupId,siteRoleName);
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
		
	}
	
	/**
	 * Checking is Site Administrator OR Owner
	 * @param themeDisplay
	 * @param groupId
	 * @return
	 */
	public static boolean isSiteAdminOrOwner(ThemeDisplay themeDisplay, long groupId){
		if(themeDisplay.getPermissionChecker().isGroupAdmin(groupId)||
				themeDisplay.getPermissionChecker().isGroupOwner(groupId)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 사용자에게 Organization role이 할당되어 있는지 체크
	 * @param user
	 * @param organizationName
	 * @param roleName
	 * @return
	 * @since 2021.06.30
	 */
	public static boolean hasOrganizationRole(User user, String organizationName, String roleName){
		try{
			long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();
			Organization organization = OrganizationLocalServiceUtil.getOrganization(companyId, organizationName);
			return hasOrganizationRole(user, organization, roleName);
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 사용자에게 Organization role이 할당되어 있는지 체크
	 * @param user
	 * @param organization
	 * @param roleName
	 * @return
	 * @since 2021.06.30
	 */
	public static boolean hasOrganizationRole(User user, Organization organization, String roleName){
		try{
			long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();
			Group organizationGroup = GroupLocalServiceUtil.getOrganizationGroup(companyId, organization.getOrganizationId());
			return UserGroupRoleLocalServiceUtil.hasUserGroupRole(user.getUserId(), organizationGroup.getGroupId(), roleName);
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 사용자에게 Organization Role 할당
	 * @param user
	 * @param organization
	 * @param roleName
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 * @since 2021.06.30
	 */
	public static boolean addUserOrganizationRole(User user, Organization organization, String roleName) throws PortalException, SystemException{
		// Organization의 권한이 아닌 경우 return false;
		if(!_isOrganizationRole(roleName)) {
			_log.warn("##### This role("+roleName+") is not organization role.");
			return false;
		}
		
		// User에 이미 권한이 할당되어 있는 경우 return false
		if(hasOrganizationRole(user, organization, roleName)) {
			_log.warn("##### This user("+user.getScreenName()+") has '"+roleName+"' organization role.");
			return false;
		}
		
		Role role = RoleLocalServiceUtil.getRole(organization.getCompanyId(), roleName);
		UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(), organization.getGroupId(), new long[] {role.getRoleId()});
		_log.info("##### Permission assignment successful. (User : "+user.getScreenName()+", Role : "+roleName+")");
		return true;
	}
	
	/**
	 * User에게 할당된 Organization Role 삭제
	 * @param user
	 * @param organization
	 * @param roleName
	 * @since 2021.06.30
	 */
	public static void removeUserOrganizationRole(User user, Organization organization, String roleName) {
		if(hasOrganizationRole(user, organization, roleName) ) {
			try{
				Role role = RoleLocalServiceUtil.getRole(organization.getCompanyId(), roleName);
				UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(user.getUserId(), organization.getGroupId(), new long[] {role.getRoleId()});
				_log.info("##### Success removed user organization role. (User : "+user.getScreenName()+", Role : "+roleName+")");
			}catch(Exception e){
				e.printStackTrace();
				_log.error("##### Failed remove user's organization role.\n" + e.getMessage());
			}
		}
	}
	
	/**
	 * roleName이 Organization Role에 등록되어 있는지 체크
	 * @param roleName
	 * @return
	 * @since 2021.06.30
	 */
	private static boolean _isOrganizationRole(String roleName) {
		return ArrayUtil.contains(CustomRoleConstants.SYSTEM_ORGANIZATION_ROLES, roleName);
	}
	
	/**
	 * Add Group To User.
	 * 
	 * @param user
	 * @param groupName
	 * @throws SystemException 
	 */
	public static boolean addGroupToUser(User user, String groupName) throws SystemException{
		if(isGroup(user,groupName)){return false;}else{
			List<UserGroup> userGroupList = UserGroupLocalServiceUtil.getUserGroups(user.getCompanyId());
			UserGroup targetUserGroup = null;
			userFor:for(UserGroup userGroup : userGroupList){
				if(userGroup.getName().equals(groupName)){
					targetUserGroup = userGroup;
					break userFor;
				}
			}
			
			UserGroupLocalServiceUtil.addUserUserGroup(user.getUserId(),targetUserGroup.getUserGroupId());
			return true;
		}
	}
	
	/**
	 * Remove User's Group.
	 * 
	 * @param user
	 * @param groupName
	 */
	public static void removeGroup(User user, String groupName){
		try{
			List<UserGroup> userGroupList = UserGroupLocalServiceUtil.getUserGroups(user.getCompanyId());
			UserGroup targetUserGroup = null;
			userFor:for(UserGroup userGroup : userGroupList){
				if(userGroup.getName().equals(groupName)){
					targetUserGroup = userGroup;
					break userFor;
				}
			}
			UserGroupLocalServiceUtil.deleteUserUserGroup(user.getUserId(),targetUserGroup.getUserGroupId());
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
		}
	}
	
	/**
	 * Checking for group inclusion.
	 * 
	 * @param user
	 * @param groupName
	 * @return
	 */
	public static boolean isGroup(User user, String groupName){
		try{
			List<UserGroup> userGroupList = UserGroupLocalServiceUtil.getUserGroups(user.getCompanyId());
			UserGroup targetUserGroup = null;
			userFor:for(UserGroup userGroup : userGroupList){
				if(userGroup.getName().equals(groupName)){
					targetUserGroup = userGroup;
					break userFor;
				}
			}
			return UserGroupLocalServiceUtil.hasUserUserGroup(user.getUserId(), targetUserGroup.getUserGroupId());
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 해당 사이트의 튜터 권한을 가지고 있는지 조회
	 * @param user
	 * @param groupId
	 * @return
	 */
	public static boolean isSiteTutorThan(User user,Long groupId){
		try{
			if(isRegularRole(user,CustomRoleConstants.ADMINISTRATOR)){
				return true;
			}else if(isRegularRole(user,CustomRoleConstants.POWER_USER)){
				return true;
//			}else if(isRegularRole(user,CustomRoleConstants.TUTOR)){
//				TODO
//				if(isSiteRole(user, groupId, CustomRoleConstants.VIRTUAL_LAB_OWNER)){
//					return true;
//				}else if(isSiteRole(user, groupId, CustomRoleConstants.VIRTUAL_LAB_MANAGER)){
//					return true;
//				}else if(isSiteRole(user, groupId, CustomRoleConstants.VIRTUAL_LAB_MANAGER)){
//					return true;
//				}else if(isSiteRole(user, groupId, CustomRoleConstants.VIRTUAL_CLASS_OWNER)){
//					return true;
//				}else if(isSiteRole(user, groupId, CustomRoleConstants.VIRTUAL_CLASS_MANAGER)){
//					return true;
//				}else{
//					return false;
//				}
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 해당 사이트의 개발자 권한을 가지고 있는지 조회
	 * @param user
	 * @param groupId
	 * @return
	 */
	public static boolean isSiteDeveloperThan(User user,Long groupId){
		try{
			if(isRegularRole(user,CustomRoleConstants.ADMINISTRATOR)){
				return true;
			}else if(isRegularRole(user,CustomRoleConstants.POWER_USER)){
				return true;
//			}else if(isRegularRole(user,CustomRoleConstants.DEVELOPER)){
//				TODO
//				if(isSiteRole(user, groupId, CustomRoleConstants.SOLVER_OWNER)){
//					return true;
//				}else if(isSiteRole(user, groupId, CustomRoleConstants.SOLVER_MANAGER)){
//					return true;
//				}else{
//					return false;
//				}
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 레귤러롤을 기준으로 DEVELOPER 이상의 권한이 있는지를 확인
	 * @param user
	 * @return
	 */
	public static boolean isDeveloperThan(User user){
		try{
			if(isRegularRole(user,CustomRoleConstants.ADMINISTRATOR)){
				return true;
			}else if(isRegularRole(user,CustomRoleConstants.POWER_USER)){
				return true;
//			}else if(isRegularRole(user,CustomRoleConstants.DEVELOPER)){
//				TODO
//				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 레귤러롤을 기준으로 Professor 이상의 권한이 있는지를 확인
	 * @param user
	 * @return
	 */
	public static boolean isProfessorThan(User user){
		try{
			if(isRegularRole(user,CustomRoleConstants.ADMINISTRATOR)){
				return true;
			}else if(isRegularRole(user,CustomRoleConstants.POWER_USER)){
				return true;
//			}else if(isRegularRole(user,CustomRoleConstants.PROFESSOR)){
//				TODO
//				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 레귤러롤을 기준으로 TUTOR 이상의 권한이 있는지를 확인
	 * @param user
	 * @return
	 */
	public static boolean isTutorThan(User user){
		try{
			if(isRegularRole(user,CustomRoleConstants.ADMINISTRATOR)){
				return true;
			}else if(isRegularRole(user,CustomRoleConstants.POWER_USER)){
				return true;
//			}else if(isRegularRole(user,CustomRoleConstants.TUTOR)){
//				TODO
//				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 레귤러롤을 기준으로 powerUser 이상의 권한이 있는지 확인
	 * @param user
	 * @return
	 */
	public static boolean isPowerUserThan(User user){
		try{
			if(isRegularRole(user,CustomRoleConstants.ADMINISTRATOR)){
				return true;
			}else if(isRegularRole(user,CustomRoleConstants.POWER_USER)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 프로젝트롤을 기준으로 PROJECT 이상의 권한이 있는지 확인
	 * 
	 * @param user
	 * @return
	 */
	public static boolean isProjectThan(User user){
		try {
			if(isRegularRole(user, CustomRoleConstants.ADMINISTRATOR)){
				return true;
			}else if(isRegularRole(user,CustomRoleConstants.POWER_USER)){
				return true;
//			}else if(isRegularRole(user, CustomRoleConstants.PROJECT)){
//				TODO
//				return true;
			}else{
				return false;
			}	
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e.getMessage());
			return false;
		}
	}
	
	
	
	
	
}
