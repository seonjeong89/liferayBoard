package sjkim.web.dataType.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + SjkimWebPortletKeys.SJKIMWEBDATATYPE,
				"mvc.command.name="+SjkimWebCommandKeys.DATATYPE_LIST_RENDER
		},
		service = MVCRenderCommand.class
		)


public class DataTypeListRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return "/dataType/dataTypeList.jsp";
	}

}
