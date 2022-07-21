package sjkim.web.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import sjkim.service.ReplyLocalServiceUtil;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+SjkimWebPortletKeys.SJKIMWEB,
				"mvc.command.name="+SjkimWebCommandKeys.BOARD_REPLY_DELETE_RESOURCE
		},
		service = MVCResourceCommand.class
		)

public class BoardReplyDeleteMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		// jsp에서 보낸 파라미터를 Map에 담는다.
		Map<String, Object> params = OSPRequestUtil.getParameterMap(resourceRequest);
		// 댓글 번호 받아온다.
		long replyNo = GetterUtil.getLong(params.get("replyNo"), 0);
		// 댓글 내용 받아온다.
		String replyContent =(String) params.get("replyContent");
		// 서비스에 정보 넘겨주고 delete 한다.
		try {
			ReplyLocalServiceUtil.deleteReply(replyNo, replyContent);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
