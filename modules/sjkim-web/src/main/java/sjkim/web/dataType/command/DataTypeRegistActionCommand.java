package sjkim.web.dataType.command;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

import sjkim.model.DataType;
import sjkim.service.DataTypeLocalServiceUtil;
import sjkim.service.UploadFileLocalServiceUtil;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.CustomUtil;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+SjkimWebPortletKeys.SJKIMWEBDATATYPE,
				"mvc.command.name="+SjkimWebCommandKeys.DATATYPE_REGIST_ACTION
		},
		service = MVCActionCommand.class
		)

public class DataTypeRegistActionCommand implements MVCActionCommand {
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		// 테마 디스플레이 선언(유저 정보 가져오기 위해서)
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		// jsp에서 보낸 파라미터를 Map에 담는다.
		Map<String, Object> params = OSPRequestUtil.getParameterMap(actionRequest);
		
		// 데이터타입명, 버전, 구조, 유저 정보 받아온다.
		String dataTypeName =(String) params.get("dataTypeName");
		String dataTypeVersion =(String) params.get("dataTypeVersion");
		String dataTypeStructure =(String) params.get("dataTypeStructure");
		String sampleFileExist =(String) params.get("sampleFileExist");
		Map<Locale, String> dataTypeExplanation = LocalizationUtil.getLocalizationMap(actionRequest, "dataTypeExplanation");
		Map<Locale, String> dataTypeDisplayName = LocalizationUtil.getLocalizationMap(actionRequest, "dataTypeDisplayName");
		User user = themeDisplay.getUser();
		String writer = (String) user.getScreenName();
		
		// 샘플 파일 업로드
		String realPath = "D:\\uploadfiletest";
		
		byte[] bytes = null;
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String, FileItem[]> files= uploadRequest.getMultipartParameterMap();
		String contentType = null;
		String fileName = null;
		String uploadFileName = null;
		InputStream is = null;
		if(sampleFileExist.equals("true")) {
			for (Entry<String, FileItem[]> file2 : files.entrySet()) {
				FileItem item[] =file2.getValue();
				for(FileItem fileItem : item) {
					fileName = fileItem.getFileName();
					contentType = fileItem.getContentType();
					try {
						is = fileItem.getInputStream();
					
					UUID uuid = UUID.randomUUID();
					uploadFileName = uuid.toString() + "_" + fileName;
						bytes = FileUtil.getBytes(is);
					File newFile = null;
					if ((bytes != null) && (bytes.length > 0)) {
							newFile = new File(realPath,uploadFileName);
							FileOutputStream fileOutputStream = new FileOutputStream(newFile);
							fileOutputStream.write(bytes, 0, bytes.length);
							fileOutputStream.close();
					}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		// 서비스에 정보 넘겨주고 insert 한다.
		DataType dataType = DataTypeLocalServiceUtil.insertDataType(dataTypeName, dataTypeVersion, dataTypeExplanation, dataTypeDisplayName, writer, dataTypeStructure,fileName,uploadFileName,contentType,realPath);
		
		PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, PortalUtil.getPortletId(actionRequest), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		portletURL.setPortletMode(PortletMode.VIEW);
		//portletURL.getRenderParameters().setValue("mvcPath", "dataTypeList.jsp");
		try {
			actionResponse.sendRedirect(portletURL.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
	

