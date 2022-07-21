package sjkim.web.dataType.command;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
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
				"mvc.command.name=JSONTest"
		},
		service = MVCResourceCommand.class
		)

public class DataTypeJSONTestResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		Map<String, Object> params = OSPRequestUtil.getParameterMap(resourceRequest);
		String dataTypeStructureName = (String) params.get("dataTypeStructureName");
		String dataTypeStructureType = (String) params.get("dataTypeStructureType");
		
		Map<Locale, String> localizedMap1 = LocalizationUtil.getLocalizationMap(resourceRequest, "dataTypeStructureDisplayName");
		Map<Locale, String> localizedMap2 = LocalizationUtil.getLocalizationMap(resourceRequest, "dataTypeStructureExplanation");
		
		JSONObject dataTypeStructure = JSONFactoryUtil.createJSONObject();
		dataTypeStructure.put("dataTypeStructureName", dataTypeStructureName);
		dataTypeStructure.put("dataTypeStructureType", dataTypeStructureType);
		dataTypeStructure.put("dataTypeStructureDiaplayName", localizedMap1);
		dataTypeStructure.put("dataTypeStructureExplanation", localizedMap2);
		
		try {
			resourceResponse.getWriter().write(dataTypeStructure.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}
