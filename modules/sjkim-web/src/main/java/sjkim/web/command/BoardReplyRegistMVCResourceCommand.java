package sjkim.web.command;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.PortletResourcesUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import sjkim.model.Reply;
import sjkim.service.BoardLocalServiceUtil;
import sjkim.service.ReplyLocalServiceUtil;
import sjkim.service.ReplyServiceUtil;
import sjkim.service.persistence.ReplyPersistence;
import sjkim.service.persistence.ReplyUtil;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+SjkimWebPortletKeys.SJKIMWEB,
				"mvc.command.name="+SjkimWebCommandKeys.BOARD_REPLY_REGIST_RESOURCE
		},
		service = MVCResourceCommand.class
		)

public class BoardReplyRegistMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		// 테마 디스플레이 선언(유저 정보 가져오기 위해서)
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		// jsp에서 보낸 파라미터를 Map에 담는다.
		Map<String, Object> params = OSPRequestUtil.getParameterMap(resourceRequest);
		System.out.println("params : "+ params);
		// 게시글 번호 받아온다.
		long boardNo = GetterUtil.getLong(params.get("boardNo"), 0);
		// 댓글 내용 받아온다.
		String content =(String) params.get("replyContent");
		// 유저 정보 가져온다.
		User user = themeDisplay.getUser();
		String writer = (String) user.getScreenName();
		// 서비스에 정보 넘겨주고 insert 한다.
		try {
			ReplyLocalServiceUtil.insertReply(content,boardNo,writer);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
