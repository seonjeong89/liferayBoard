package sjkim.web.command;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import sjkim.model.Reply;
import sjkim.service.ReplyLocalServiceUtil;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.OSPRequestUtil;
import sjkim.web.util.OSPTimeUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+SjkimWebPortletKeys.SJKIMWEB,
				"mvc.command.name="+SjkimWebCommandKeys.BOARD_REPLY_LIST_RESOURCE
		},
		service = MVCResourceCommand.class
		)

public class BoardReplyListMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		// jsp에서 보낸 파라미터를 Map에 담는다.
		Map<String, Object> params = OSPRequestUtil.getParameterMap(resourceRequest);
		// 게시글 번호 받아온다.
		long boardNo = GetterUtil.getLong(params.get("boardNo"), 0);
		// 댓글 레벨 받아온다.
		long replyLevel = GetterUtil.getLong(params.get("replyLevel"), 0);
		int startNum = GetterUtil.getInteger(params.get("startNum"), 0);
		
		// 서비스에 정보 넘겨주고 list를 출력 한다.
		try {
			List<Reply> reply = ReplyLocalServiceUtil.listReply(boardNo,replyLevel,startNum);
			JSONArray replyListJson = JSONFactoryUtil.createJSONArray();
			for (int i = 0; i < reply.size(); i++) { //배열 사이즈 만큼 for문 돌려서 JSONObject 만들고 JSONArray에 넣는다.
				JSONObject sObject = JSONFactoryUtil.createJSONObject();//배열 내에 들어갈 json
				sObject.put("replyNo", reply.get(i).getReplyNo());
				sObject.put("boardNo", reply.get(i).getBoardNo());
				sObject.put("replyContent", reply.get(i).getReplyContent());
				sObject.put("replyWriter", reply.get(i).getReplyWriter());
				sObject.put("replyParentReplyNo", reply.get(i).getReplyParentReplyNo());
				sObject.put("replyLevel", reply.get(i).getReplyLevel());
				sObject.put("replyWriteDate", OSPTimeUtil.getTimeBySecond(reply.get(i).getReplyWriteDate()));
				sObject.put("replyUpdateDate", OSPTimeUtil.getTimeBySecond(reply.get(i).getReplyUpdateDate()));
				sObject.put("replyDeleteYN", reply.get(i).getReplyDeleteYN());
				replyListJson.put(sObject);
			}
			resourceResponse.getWriter().print(replyListJson.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
