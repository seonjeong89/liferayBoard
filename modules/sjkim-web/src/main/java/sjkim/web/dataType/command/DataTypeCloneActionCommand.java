package sjkim.web.dataType.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

import sjkim.model.DataType;
import sjkim.service.DataTypeLocalServiceUtil;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.CustomUtil;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+SjkimWebPortletKeys.SJKIMWEBDATATYPE,
				"mvc.command.name="+SjkimWebCommandKeys.DATATYPE_CLONE_ACTION
		},
		service = MVCActionCommand.class
		)

public class DataTypeCloneActionCommand implements MVCActionCommand {
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		// 테마 디스플레이 선언(유저 정보 가져오기 위해서)
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		// jsp에서 보낸 파라미터를 Map에 담는다.
		Map<String, Object> params = OSPRequestUtil.getParameterMap(actionRequest);
		System.out.println("params : " + params);
		// 데이터 타입 번호, 버전 정보 받아온다.
		long dataTypeNo = GetterUtil.getLong(params.get("dataTypeNo"));
		String dataTypeVersion = GetterUtil.getString(params.get("dataTypeVersion"));
		
		// 유저 정보 가져온다.
		User user = themeDisplay.getUser();
		String dataTypeWriter = (String) user.getScreenName();
		
		// 서비스에 정보 넘겨주고 insert 한다.
	
		try {
			DataType dataType = DataTypeLocalServiceUtil.cloneDataType(dataTypeNo, dataTypeVersion, dataTypeWriter);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, PortalUtil.getPortletId(actionRequest), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		portletURL.setPortletMode(PortletMode.VIEW);
		//portletURL.getRenderParameters().setValue("mvcPath", "dataTypeList.jsp");
		try {
			actionResponse.sendRedirect(portletURL.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		return false;
	}
	
}
