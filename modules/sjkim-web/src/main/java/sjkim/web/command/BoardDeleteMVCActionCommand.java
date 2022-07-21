package sjkim.web.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import sjkim.service.BoardLocalServiceUtil;
import sjkim.service.ReplyLocalServiceUtil;
import sjkim.service.UploadFileLocalServiceUtil;
import sjkim.service.persistence.BoardPersistence;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+SjkimWebPortletKeys.SJKIMWEB,
				"mvc.command.name="+SjkimWebCommandKeys.BOARD_DELETE_ACTION
		},
		service = MVCActionCommand.class
		)

public class BoardDeleteMVCActionCommand implements MVCActionCommand {
	//로그 선언
	private final Log _log = LogFactoryUtil.getLog(BoardDeleteMVCActionCommand.class);
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		// jsp에서 보낸 파라미터를 Map에 담는다.
		Map<String, Object> params = OSPRequestUtil.getParameterMap(actionRequest);
		// 게시글 번호 받아온다.
		long boardNo = GetterUtil.getLong(params.get("boardNo"), 0);
		
			// 삭제 진행
			try {
				BoardLocalServiceUtil.deleteBoardWithFileList(boardNo);
				//BoardLocalServiceUtil.deleteBoard(boardNo);
				System.out.println("deleteBoard complete");
			} catch (PortalException e) {
				e.printStackTrace();
			}
		return false;
	}
	
}
