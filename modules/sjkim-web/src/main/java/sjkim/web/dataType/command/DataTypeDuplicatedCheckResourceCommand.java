package sjkim.web.dataType.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.IOException;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import sjkim.service.DataTypeLocalServiceUtil;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+SjkimWebPortletKeys.SJKIMWEBDATATYPE,
				"mvc.command.name="+SjkimWebCommandKeys.DATATYPE_DUPLICATED_CHECK_RESOURCE

		},
		service = MVCResourceCommand.class
		)

public class DataTypeDuplicatedCheckResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		Map<String, Object> params = OSPRequestUtil.getParameterMap(resourceRequest);
		
		String dataTypeName =(String) params.get("dataTypeName");
		String dataTypeVersion =(String) params.get("dataTypeVersion");
		String dataTypeNV = dataTypeName + " " + dataTypeVersion;
		String msg = "";
		int duplicatedNum = DataTypeLocalServiceUtil.searchDataTypeListCount(dataTypeNV);
		
		if(duplicatedNum > 0) {
			msg = "no";
		} else {
			msg = "ok";
		}
			
		try {
			resourceResponse.getWriter().write(msg.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
