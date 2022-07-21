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
import sjkim.service.UploadFileServiceUtil;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+SjkimWebPortletKeys.SJKIMWEB,
				"mvc.command.name="+SjkimWebCommandKeys.BOARD_FILE_DELETE_RESOURCE
		},
		service = MVCResourceCommand.class
		)

public class BoardFileDeleteMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		// jsp에서 보낸 파라미터를 Map에 담는다.
		Map<String, Object> params = OSPRequestUtil.getParameterMap(resourceRequest);
		
		// 파일 번호 받아온다.
		long uploadFileNo = GetterUtil.getLong(params.get("uploadFileNo"), 0);
		// 서비스에 정보 넘겨주고 삭제 한다.
		try {
			UploadFile uploadFile = UploadFileLocalServiceUtil.getUploadFile(uploadFileNo);
			
			String fileName = uploadFile.getUploadFileName();
			String uploadPath = uploadFile.getUploadFileUploadPath();
			File file = new File(uploadPath+File.separator+fileName);
			
			if( file.exists() ){
	    		if(file.delete()){
	    			UploadFileLocalServiceUtil.deleteUploadFile(uploadFileNo);
	    			System.out.println("파일삭제 성공");
	    		}else{
	    			System.out.println("파일삭제 실패");
	    		}
	    	}else{
	    		System.out.println("파일이 존재하지 않습니다.");
	    	}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
