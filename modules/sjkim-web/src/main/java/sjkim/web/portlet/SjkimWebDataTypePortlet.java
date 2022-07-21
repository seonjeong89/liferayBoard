package sjkim.web.portlet;

import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.CustomRoleConstants;
import sjkim.web.util.OSPUsersUtil;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author gplus
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DataType",
		"javax.portlet.init-param.template-path=/dataType/",
		"javax.portlet.init-param.view-template=/dataType/dataTypeList.jsp",
		"javax.portlet.name=" + SjkimWebPortletKeys.SJKIMWEBDATATYPE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.add-default-resource=true",
		"javax.portlet.version=3.0"
	},
	service = Portlet.class
)
public class SjkimWebDataTypePortlet extends MVCPortlet {
	
	public void render(RenderRequest renderRequest,RenderResponse renderResponse) throws IOException, PortletException{ 
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		if(OSPUsersUtil.isSiteRole(themeDisplay.getUser(), themeDisplay.getScopeGroupId(), CustomRoleConstants.SITE_ADMINISTRATOR)
				|| OSPUsersUtil.isRegularRole(themeDisplay.getUser(), CustomRoleConstants.ADMINISTRATOR)) {
			renderRequest.setAttribute("isAdmin", true);
		}else {
			renderRequest.setAttribute("isAdmin", false);
		}	
		super.render(renderRequest, renderResponse);
	}
}