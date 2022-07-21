package sjkim.web.dataType.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import sjkim.model.DataType;
import sjkim.service.BoardLocalServiceUtil;
import sjkim.service.DataTypeLocalServiceUtil;
import sjkim.service.ReplyLocalServiceUtil;
import sjkim.service.UploadFileLocalServiceUtil;
import sjkim.service.persistence.BoardPersistence;
import sjkim.web.constants.SjkimWebCommandKeys;
import sjkim.web.constants.SjkimWebPortletKeys;
import sjkim.web.util.OSPRequestUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+SjkimWebPortletKeys.SJKIMWEBDATATYPE,
				"mvc.command.name="+SjkimWebCommandKeys.DATATYPE_DELETE_ACTION
		},
		service = MVCActionCommand.class
		)

public class DataTypeDeleteActionCommand implements MVCActionCommand {
	//로그 선언
	private final Log _log = LogFactoryUtil.getLog(DataTypeDeleteActionCommand.class);
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		// jsp에서 보낸 파라미터를 Map에 담는다.
		Map<String, Object> params = OSPRequestUtil.getParameterMap(actionRequest);
		// 데이터 타입 정보 받아온다.
		long dataTypeNo = GetterUtil.getLong(params.get("dataTypeNo"));
			
			// 삭제 진행
			
			try {
				DataType dataType = DataTypeLocalServiceUtil.getDataType(dataTypeNo);
				
				String fileName = dataType.getSampleFileName();
				String uploadPath = dataType.getSampleFileUploadPath();
				
				File file = new File(uploadPath+File.separator+fileName);
				
				if( file.exists() ){
		    		file.delete();
		    		DataTypeLocalServiceUtil.daleteDataType(dataTypeNo);
				}
			} catch (PortalException e) {
				e.printStackTrace();
				_log.error(e);
			}
		return false;
	}
}
