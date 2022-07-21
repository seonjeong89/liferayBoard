package sjkim.web.command;

import com.liferay.portal.kernel.exception.PortalException;
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
import sjkim.model.UploadFile;
import sjkim.service.BoardLocalServiceUtil;
import sjkim.service.UploadFileLocalServiceUtil;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + SjkimWebPortletKeys.SJKIMWEB,
				"mvc.command.name="+SjkimWebCommandKeys.BOARD_UPDATE_RENDER
		},
		service = MVCRenderCommand.class
		)


public class BoardUpdateMVCRenderCommand implements MVCRenderCommand{
	//로그 선언
	private final Log _log = LogFactoryUtil.getLog(BoardViewMVCRenderCommand.class);
		
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Map<String, Object> params = OSPRequestUtil.getParameterMap(renderRequest);
		long boardNo = GetterUtil.getLong(params.get("boardNo"), 0);
		
		Board board = null;
		List<UploadFile> uploadFileList = null; 
		try {
			board = BoardLocalServiceUtil.getBoard(boardNo);
			uploadFileList = UploadFileLocalServiceUtil.uploadFileList(boardNo);
		} catch (PortalException e) {
			_log.error(e);
		}
		
		renderRequest.setAttribute("board", board);
		renderRequest.setAttribute("uploadFileList", uploadFileList);
		return "/updateForm.jsp";
	}

}
