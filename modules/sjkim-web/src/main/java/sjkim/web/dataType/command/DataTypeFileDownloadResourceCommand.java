package sjkim.web.dataType.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import sjkim.model.DataType;
import sjkim.model.UploadFile;
import sjkim.service.DataTypeLocalServiceUtil;
import sjkim.service.UploadFileLocalServiceUtil;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+SjkimWebPortletKeys.SJKIMWEBDATATYPE,
				"mvc.command.name="+SjkimWebCommandKeys.DATATYPE_FILE_DOWNLOAD_RESOURCE
		},
		service = MVCResourceCommand.class
		)

public class DataTypeFileDownloadResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		// jsp에서 보낸 파라미터를 Map에 담는다.
		Map<String, Object> params = OSPRequestUtil.getParameterMap(resourceRequest);
		
		// 데이터타입 번호 받아온다.
		long dataTypeNo = GetterUtil.getLong(params.get("dataTypeNo"), 0);
		
		// 서비스에 정보 넘겨주고 다운로드 한다.
			DataType dataType = null;
			OutputStream out = null;
			InputStream in = null;
			
			try {
				dataType = DataTypeLocalServiceUtil.getDataType(dataTypeNo);
				String fileName = dataType.getSampleFileName();
				String realFileName = dataType.getSampleRealFileName();
				realFileName = new String(realFileName.getBytes("UTF-8"), "ISO-8859-1");
				String uploadPath = dataType.getSampleFileUploadPath();
				String contentType = dataType.getSampleFileType();
				File file = new File(uploadPath+File.separator+fileName);
				long fileLength = file.length();
				resourceResponse.setContentType(contentType);
				resourceResponse.setContentLengthLong(fileLength);
				String contentDispositionValue = "attachment; filename=\"" + realFileName + "\"";
				resourceResponse.addProperty("Content-Disposition", contentDispositionValue);
				
				out = resourceResponse.getPortletOutputStream();
				
				in = new FileInputStream(file);
				
				// 파일 읽을 만큼 크기의 buffer를 생성한 후 
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				
				// outputStream에 씌워준다
				while ((bytesRead = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytesRead);
				}
				out.flush();
				out.close();
			} catch (PortalException | IOException e) {
				e.printStackTrace();
			}
		return false;
	}
}
