package sjkim.web.util;

public class CustomRoleConstants {
	
	// ##############################
	// #####		TYPES		#####
	// ##############################
	
	public static final int TYPE_REGULAR = 1;
	
	public static final String TYPE_REGULAR_LABEL = "regular";
	
	public static final int TYPE_SITE = 2;
	
	public static final String TYPE_SITE_LABEL = "site";
	
	public static final int TYPE_ORGANIZATION = 3;

	public static final String TYPE_ORGANIZATION_LABEL = "organization";
	
	public static final int[] TYPES_REGULAR = {
			TYPE_REGULAR
	};
	
	public static final int[] TYPES_REGULAR_AND_SITE = {
		TYPE_REGULAR, TYPE_SITE
	};
	
	public static final int[] TYPES_REGULAR_AND_ORGANIZATION = {
		TYPE_REGULAR, TYPE_ORGANIZATION
	};

	public static final int[] TYPES_REGULAR_AND_SITE_AND_ORGANIZATION = {
		TYPE_REGULAR, TYPE_SITE, TYPE_ORGANIZATION
	};
	
	public static final int[] TYPES_SITE = {
		TYPE_SITE
	};
	
	public static final int[] TYPES_SITE_AND_ORGANIZATION = {
		TYPE_SITE, TYPE_ORGANIZATION
	};
	
	public static final int[] TYPES_ORGANIZATION = {
		TYPE_ORGANIZATION
	};
	
	public static String getTypeLabel(int type) {
		if (type == TYPE_ORGANIZATION) {
			return TYPE_ORGANIZATION_LABEL;
		} else if (type == TYPE_SITE) {
			return TYPE_SITE_LABEL;
		} else {
			return TYPE_REGULAR_LABEL;
		}
	}
	
	
	// ##############################
	// #####		ROLES		#####
	// ##############################
	
	/*
	 *  Regular Roles 
	 */
	public static final String ADMINISTRATOR = "Administrator";
	
	public static final String ANALYTICS_ADMINISTRATOR = "Analytics Administrator";

	public static final String GUEST = "Guest";

	public static final String OWNER = "Owner";
	
	public static final String PORTAL_CONTENT_REVIEWER = "Portal Content Reviewer";
	
	public static final String POWER_USER = "Power User";
	
	public static final String USER = "User";
	
	public static final String OTP_USER = "OTP_USER";
	
	
	public static final String[] SYSTEM_REGULAR_ROLES = {
		ADMINISTRATOR, ANALYTICS_ADMINISTRATOR, GUEST, OWNER, PORTAL_CONTENT_REVIEWER ,POWER_USER, USER, OTP_USER
	};
	
	/* 
	 * Site Roles
	 */
	public static final String SITE_ADMINISTRATOR = "Site Administrator";

	public static final String SITE_CONTENT_REVIEWER = "Site Content Reviewer";

	public static final String SITE_MEMBER = "Site Member";

	public static final String SITE_OWNER = "Site Owner";
	
	public static final String SITE_DATABASE_MANAGER = "Site Database Manager";
	
	public static final String SITE_DATABASE_ONWER = "Site Database Owner";
	
	public static final String SITE_CURATION = "Site Data Curation";
	
	public static final String[] SYSTEM_SITE_ROLES = {
		SITE_ADMINISTRATOR, SITE_CONTENT_REVIEWER, SITE_MEMBER, SITE_OWNER,SITE_DATABASE_MANAGER,SITE_DATABASE_ONWER,SITE_CURATION
	};
	
	/* 
	 * Organization Roles
	 */
	public static final String ORGANIZATION_ADMINISTRATOR = "Organization Administrator";
	
	public static final String ORGANIZATION_CONTENT_REVIEWER = "Organization Content Reviewer";

	public static final String ORGANIZATION_OWNER = "Organization Owner";

	public static final String ORGANIZATION_USER = "Organization User";
	
	public static final String[] SYSTEM_ORGANIZATION_ROLES = {
			ORGANIZATION_ADMINISTRATOR, ORGANIZATION_CONTENT_REVIEWER, ORGANIZATION_OWNER, ORGANIZATION_USER
	};
	
	
	// ##################################
	// #####		USER GROUPS		#####
	// ##################################
	
}
