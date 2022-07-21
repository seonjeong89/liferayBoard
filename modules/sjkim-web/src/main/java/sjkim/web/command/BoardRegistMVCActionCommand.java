package sjkim.web.command;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import sjkim.model.Board;
import sjkim.service.BoardLocalServiceUtil;
import sjkim.service.UploadFileLocalServiceUtil;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.CustomUtil;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+SjkimWebPortletKeys.SJKIMWEB,
				"mvc.command.name="+SjkimWebCommandKeys.BOARD_REGIST_ACTION
		},
		service = MVCActionCommand.class
		)

public class BoardRegistMVCActionCommand implements MVCActionCommand {
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		// 테마 디스플레이 선언(유저 정보 가져오기 위해서)
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		// jsp에서 보낸 파라미터를 Map에 담는다.
		Map<String, Object> params = OSPRequestUtil.getParameterMap(actionRequest);
		
		// 제목, 내용, 유저 정보 받아온다.
		String title =(String) params.get("title");
		String content =(String) params.get("content");
		User user = themeDisplay.getUser();
		String writer = (String) user.getScreenName();
		
		content = CustomUtil.deleteScriptTag(content);
		
		// 서비스에 정보 넘겨주고 insert 한다.
		try {
			Board board = BoardLocalServiceUtil.insertBoard(title,content,writer);
			long boardNo = board.getBoardNo();
			fileUpload(actionRequest, boardNo, writer);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 파일 업로드 메소드
	public void fileUpload(ActionRequest actionRequest, long boardNo, String writer){
		String realPath = "D:\\uploadfiletest";
		byte[] bytes = null;
			try {
				UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
				Map<String, FileItem[]> files= uploadRequest.getMultipartParameterMap();
				String contentType = null;
				String fileName = null;
				String uploadFileName = null;
				InputStream is = null;
				for (Entry<String, FileItem[]> file2 : files.entrySet()) {
					FileItem item[] =file2.getValue();
				
					for(FileItem fileItem : item) {
						fileName = fileItem.getFileName();
						contentType = fileItem.getContentType();
						is = fileItem.getInputStream();
						
						UUID uuid = UUID.randomUUID();
						uploadFileName = uuid.toString() + "_" + fileName;
						try {
							bytes = FileUtil.getBytes(is);
						} catch (IOException e2) {
							e2.printStackTrace();
						}
						File newFile = null;
						if ((bytes != null) && (bytes.length > 0)) {
							try {
								newFile = new File(realPath,uploadFileName);
								FileOutputStream fileOutputStream = new FileOutputStream(newFile);
								fileOutputStream.write(bytes, 0, bytes.length);
								fileOutputStream.close();
								UploadFileLocalServiceUtil.uploadFiles(boardNo, writer, fileName, uploadFileName, contentType, realPath);
							} catch (FileNotFoundException e) {
								System.out.println("File Not Found.");
								e.printStackTrace();
							} catch (IOException e1) {
								System.out.println("Error Reading The File.");
								e1.printStackTrace();
							}
						}
					}
				}
			}
			catch (Exception e) {
				System.out.println("Exception::::" + e.getMessage());
			}
	}
}
