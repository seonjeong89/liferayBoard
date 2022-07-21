package sjkim.web.dataType.command;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.FileWriter;
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
				"mvc.command.name="+SjkimWebCommandKeys.DATATYPE_JSON_FILE_DOWNLOAD_RESOURCE
		},
		service = MVCResourceCommand.class
		)

public class DataTypeJSONFileDownloadResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		Map<String, Object> params = OSPRequestUtil.getParameterMap(resourceRequest);
		
		Map<Locale, String> localizedMap1 = LocalizationUtil.getLocalizationMap(resourceRequest, "dataTypeStructureDisplayName");
		Map<Locale, String> localizedMap2 = LocalizationUtil.getLocalizationMap(resourceRequest, "dataTypeStructureExplanation");
		
		//System.out.println("localizedMap1 : " + localizedMap1);
		//System.out.println("localizedMap2 : " + localizedMap2);
//		resourceRequest.setAttribute("test", localizedMap);
		
		JSONObject localized = JSONFactoryUtil.createJSONObject();
		localized.put("dataTypeStructureDiaplayName", localizedMap1);
		localized.put("dataTypeStructureExplanation", localizedMap2);
		
		JSONArray objArray = JSONFactoryUtil.createJSONArray();
		objArray.put(params);
		objArray.put(localized);
		
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put("objTest", params);
		
		System.out.println("objectArray = " + objArray);
		System.out.println("jsonObject = " + obj);
		
		try {
			FileWriter file = new FileWriter("D:\\uploadfiletest\\test.json");
			file.write(objArray.toString());
			file.flush();
			file.close();
			
			resourceResponse.getWriter().write(objArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}
