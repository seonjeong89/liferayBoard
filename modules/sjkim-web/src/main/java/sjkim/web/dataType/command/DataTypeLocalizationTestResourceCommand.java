package sjkim.web.dataType.command;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+SjkimWebPortletKeys.SJKIMWEBDATATYPE,
				"mvc.command.name=localizationTest"
		},
		service = MVCResourceCommand.class
		)

public class DataTypeLocalizationTestResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		// 테마 디스플레이 선언(유저 정보 가져오기 위해서)
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Map<String, Object> params = OSPRequestUtil.getParameterMap(resourceRequest);
		System.out.println("params : " + params);
		
		Map<Locale, String> localizedMap = LocalizationUtil.getLocalizationMap(resourceRequest, "test");
		
		System.out.println("localizedMap : " + localizedMap);
		resourceRequest.setAttribute("test", localizedMap);
		
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put("result", "sucess");
		
		try {
			resourceResponse.getWriter().write(obj.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}
