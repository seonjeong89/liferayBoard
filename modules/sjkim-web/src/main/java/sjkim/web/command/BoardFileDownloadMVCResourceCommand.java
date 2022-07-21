package sjkim.web.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import sjkim.model.UploadFile;
import sjkim.service.UploadFileLocalServiceUtil;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+SjkimWebPortletKeys.SJKIMWEB,
				"mvc.command.name="+SjkimWebCommandKeys.BOARD_FILE_DOWNLOAD_RESOURCE
		},
		service = MVCResourceCommand.class
		)

public class BoardFileDownloadMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		// jsp에서 보낸 파라미터를 Map에 담는다.
		Map<String, Object> params = OSPRequestUtil.getParameterMap(resourceRequest);
		//System.out.println("params : "+ params);
		
		// 파일 번호 받아온다.
		long uploadFileNo = GetterUtil.getLong(params.get("uploadFileNo"), 0);
		// 서비스에 정보 넘겨주고 다운로드 한다.
		try {
			UploadFile uploadFile = UploadFileLocalServiceUtil.getUploadFile(uploadFileNo);
			
			String fileName = uploadFile.getUploadFileName();
			String realFileName = uploadFile.getUploadRealFileName();
			realFileName = new String(realFileName.getBytes("UTF-8"), "ISO-8859-1");
			System.out.println(realFileName);
			String uploadPath = uploadFile.getUploadFileUploadPath();
			String contentType = uploadFile.getUploadFileMimeType();
			File file = new File(uploadPath+File.separator+fileName);
			long fileLength = file.length();
			resourceResponse.setContentType(contentType);
			resourceResponse.setContentLengthLong(fileLength);
			String contentDispositionValue = "attachment; filename=\"" + realFileName + "\"";
			resourceResponse.addProperty("Content-Disposition", contentDispositionValue);
			
			OutputStream out = resourceResponse.getPortletOutputStream();
			
			InputStream in = new FileInputStream(file);
			
			// 파일 읽을 만큼 크기의 buffer를 생성한 후 
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			
			// outputStream에 씌워준다
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
			out.flush();
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
