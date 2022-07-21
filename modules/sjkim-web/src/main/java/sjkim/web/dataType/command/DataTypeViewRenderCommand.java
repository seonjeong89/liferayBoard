package sjkim.web.dataType.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import sjkim.model.Board;
import sjkim.model.DataType;
import sjkim.model.UploadFile;
import sjkim.service.BoardLocalServiceUtil;
import sjkim.service.DataTypeLocalServiceUtil;
import sjkim.service.UploadFileLocalServiceUtil;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + SjkimWebPortletKeys.SJKIMWEBDATATYPE,
				"mvc.command.name="+SjkimWebCommandKeys.DATATYPE_VIEW_RENDER
		},
		service = MVCRenderCommand.class
		)


public class DataTypeViewRenderCommand implements MVCRenderCommand{
	//로그 선언
	private final Log _log = LogFactoryUtil.getLog(DataTypeViewRenderCommand.class);
		
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Map<String, Object> params = OSPRequestUtil.getParameterMap(renderRequest);
		
		long dataTypeNo = GetterUtil.getLong(params.get("dataTypeNo"));
		
		DataType dataType = null;
		try {
			dataType = DataTypeLocalServiceUtil.getDataType(dataTypeNo);
		} catch (Exception e) {
			_log.error(e);
		}
		
		renderRequest.setAttribute("dataType", dataType);
		
		return "/dataType/dataTypeViewDetail.jsp";
	}

}
