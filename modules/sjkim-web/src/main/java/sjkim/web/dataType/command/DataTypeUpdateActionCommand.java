package sjkim.web.dataType.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
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
import sjkim.service.BoardLocalServiceUtil;
import sjkim.service.DataTypeLocalServiceUtil;
import sjkim.service.UploadFileLocalServiceUtil;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+SjkimWebPortletKeys.SJKIMWEBDATATYPE,
				"mvc.command.name="+SjkimWebCommandKeys.DATATYPE_UPDATE_ACTION
		},
		service = MVCActionCommand.class
		)

public class DataTypeUpdateActionCommand implements MVCActionCommand {
	//로그 선언
	private final Log _log = LogFactoryUtil.getLog(DataTypeViewRenderCommand.class);
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		// 테마 디스플레이 선언(유저 정보 가져오기 위해서)
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// jsp에서 보낸 파라미터를 Map에 담는다.
		Map<String, Object> params = OSPRequestUtil.getParameterMap(actionRequest);
		
		// 데이터 타입 번호, 설명, 구조, 유저 정보 받아온다.
		long dataTypeNo = GetterUtil.getLong(params.get("dataTypeNo"));
		String dataTypeStructure = GetterUtil.getString(params.get("dataTypeStructure"));
		String sampleFileExist = GetterUtil.getString(params.get("sampleFileExist"));
		String sampleOldFileExist = GetterUtil.getString(params.get("sampleOldFileExist"));
		Map<Locale, String> dataTypeExplanation = LocalizationUtil.getLocalizationMap(actionRequest, "dataTypeExplanation");
		Map<Locale, String> dataTypeDisplayName = LocalizationUtil.getLocalizationMap(actionRequest, "dataTypeDisplayName");
		User user = themeDisplay.getUser();
		String dataTypeWriter = (String) user.getScreenName();
		
		if(sampleFileExist.equals("true")) {	// 새 파일 업로드 O
			// 기존 파일 파일 삭제 후 새로운 파일 업로드 하고 내용 바꿈
			DataType dataType;
			try {
				dataType = DataTypeLocalServiceUtil.getDataType(dataTypeNo);
				
				// 기존 파일 삭제
				String oldFileName = dataType.getSampleFileName();
				String oldUploadPath = dataType.getSampleFileUploadPath();
				
				File file = new File(oldUploadPath+File.separator+oldFileName);
				
				if( file.exists() ){
					file.delete();
				}
			} catch (PortalException e1) {
				e1.printStackTrace();
			}
						
			// 샘플 파일 업로드
			String realPath = "D:\\uploadfiletest";
			
			byte[] bytes = null;
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
			
			try {
				DataTypeLocalServiceUtil.updateDataTypeAll(dataTypeNo, dataTypeExplanation, dataTypeDisplayName, dataTypeStructure, dataTypeWriter, fileName, uploadFileName, contentType, realPath);
				PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, PortalUtil.getPortletId(actionRequest), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				portletURL.setPortletMode(PortletMode.VIEW);
				//portletURL.getRenderParameters().setValue("mvcPath", "dataTypeList.jsp");
				actionResponse.sendRedirect(portletURL.toString());
			} catch (PortalException | IOException e) {
				e.printStackTrace();
			}
		}
		
	if(sampleFileExist.equals("false") && sampleOldFileExist.equals("false")) {	// 기존파일 X, 새 파일 업로드 X - 파일 삭제 후 내용 변경
		
		try {
			DataType dataType = DataTypeLocalServiceUtil.getDataType(dataTypeNo);
			
			// 기존 파일 삭제
			String oldFileName = dataType.getSampleFileName();
			String oldUploadPath = dataType.getSampleFileUploadPath();
			
			File file = new File(oldUploadPath+File.separator+oldFileName);
			
			if( file.exists() ){
				file.delete();
			}
			
			String fileName = null;
			String uploadFileName = null;
			String contentType = null;
			String realPath = null;
			
			DataTypeLocalServiceUtil.updateDataTypeAll(dataTypeNo, dataTypeExplanation, dataTypeDisplayName, dataTypeStructure, dataTypeWriter, fileName, uploadFileName, contentType, realPath);
			PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, PortalUtil.getPortletId(actionRequest), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			portletURL.setPortletMode(PortletMode.VIEW);
			//portletURL.getRenderParameters().setValue("mvcPath", "dataTypeList.jsp");
			actionResponse.sendRedirect(portletURL.toString());
		} catch (PortalException | IOException e) {
			e.printStackTrace();
		}
		
	}

	if(sampleFileExist.equals("false") && sampleOldFileExist.equals("true")) { // 기존 파일 O, 새 파일 업로드 X - 내용만 변경
		try {
			DataTypeLocalServiceUtil.updateDataTypeWithoutFile(dataTypeNo, dataTypeExplanation, dataTypeDisplayName, dataTypeStructure, dataTypeWriter);
			PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, PortalUtil.getPortletId(actionRequest), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			portletURL.setPortletMode(PortletMode.VIEW);
			//portletURL.getRenderParameters().setValue("mvcPath", "dataTypeList.jsp");
			actionResponse.sendRedirect(portletURL.toString());
		} catch (PortalException | IOException e) {
			e.printStackTrace();
		}
	}
		return false;
	}
}
