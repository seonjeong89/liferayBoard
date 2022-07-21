package sjkim.web.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceParameters;
import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequest;

public final class OSPRequestUtil {
	public static Map<String,Object> getParameterMap(RenderRequest request) {
		return getParameterMap(request.getRenderParameters(), request.getWindowID());
	}	
	public static Map<String,Object> getParameterMap(HttpServletRequest request) {
		return getParameterMap(request.getParameterMap(), request.getServletPath());
	}	
	public static Map<String,Object> getParameterMap(ActionRequest request) {
		return getParameterMap(request.getActionParameters(), request.getWindowID());
	}
	public static Map<String,Object> getParameterMap(ResourceRequest request) {
		return getParameterMap(request.getResourceParameters(), request.getResourceID());
	}	
	public static Map<String,Object> getParameterMap(UploadPortletRequest request) {
		return getMultiParameterMap(request, "");
	}
	
	private static Map<String,Object> getParameterMap(ActionParameters paramerterMap, String serverName) {
		Map<String,Object> map = new HashMap<String,Object>();
		paramerterMap.getNames().stream().forEach(
				k ->
				map.put(k,paramerterMap.getValues(k).length> 1?paramerterMap.getValues(k):paramerterMap.getValue(k))
				);
		if(logger.isDebugEnabled()) {
			debugParameters(map, serverName);
		}
		return map;
	}
	
	private static Map<String,Object> getParameterMap(ResourceParameters paramerterMap, String serverName) {
		Map<String,Object> map = new HashMap<String,Object>();
		paramerterMap.getNames().stream().forEach(
				k ->
				map.put(k,paramerterMap.getValues(k).length> 1?paramerterMap.getValues(k):paramerterMap.getValue(k))
				);
		if(logger.isDebugEnabled()) {
			debugParameters(map, serverName);
		}
		return map;
	}

	private static Map<String,Object> getParameterMap(RenderParameters paramerterMap, String serverName) {
		Map<String,Object> map = new HashMap<String,Object>();
		paramerterMap.getNames().stream().forEach(
				k ->
				map.put(k,paramerterMap.getValues(k).length> 1?paramerterMap.getValues(k):paramerterMap.getValue(k))
				);
		if(logger.isDebugEnabled()) {
			debugParameters(map, serverName);
		}
		return map;
	}
	
	/**
	 * getParameterMap
	 */
	private static Map<String,Object> getParameterMap(Map paramerterMap, String serverName) {
		debugParameters(paramerterMap, serverName);
		Map<String,Object> map = new HashMap<String,Object>();
        try {
            Iterator iter = paramerterMap.keySet().iterator();
            String key = null;
            String[] value = null;
            while(iter.hasNext()) {
                key = (String)iter.next();
                value = (String []) paramerterMap.get(key);
                
                if(value.length > 1){
                	map.put(key, value);
                }else{
                	map.put(key, value[0]);
                }               
            }
        } catch(Exception e) {
        
        	logger.error("            <<<ReqUtils - getParameterMap(HttpServletRequest request)>>>");
        	logger.error("            "+e.getMessage());
        }
        return map;
	}
	
	/**
	 * getMultiParameterMap
	 */
	private static Map<String, Object> getMultiParameterMap(UploadPortletRequest request, String serverName){
		Map map = new HashMap();
		try {
			Enumeration rEnum = request.getParameterNames();					
			while (rEnum.hasMoreElements()) {
				String name = (String) rEnum.nextElement();
				if(request.getParameterValues(name) != null) {
					if(request.getParameterValues(name).length > 1){
						map.put(name, request.getParameterValues(name));
					}else{
						map.put(name, request.getParameter(name));
					}				
				}else{
					map.put(name, request.getFile(name));
				}
			}
		} catch(Exception e) {
			logger.error("            <<<ReqUtils - getParameterMap(MultipartRequest multi)>>>");
			logger.error("            "+e.getMessage());
		}
		
		if(logger.isDebugEnabled()) {
			debugParameters(map, serverName);
		}
		
		return map;
	}

	/**
	 * debugParameters
	 */
	private static void debugParameters(Map param, String serverName) {
		Iterator iter = param.entrySet().iterator();
		Map.Entry entry = null;
		String paramName = null;
		String[] paramValues = null;

		logger.debug("**************************************************************************************************************");
		logger.debug("***** "+serverName+".do DEBUGGING PARAMETERS *****************************************************************");
		logger.debug("**************************************************************************************************************");
		while (iter.hasNext()) {
			entry = (Map.Entry) iter.next();
			paramName = (String) entry.getKey();			
			
			if(entry.getValue() instanceof String){
				paramValues = new String[]{OSPStringUtil.strNull(entry.getValue())};
			}else if(entry.getValue() instanceof File){
				paramValues = new String[]{"IS FILE"};
			}else{
				paramValues = (String[]) entry.getValue();
			}
			
			if(paramValues == null){
				logger.debug(paramName + " : [NULL]");
			}else{
				logger.debug(paramName + " : [" + StringUtil.merge(paramValues, ",") + "]");
			}
		}
		logger.debug("**************************************************************************************************************");
	}
	
	
			
	
	private static Log logger = LogFactoryUtil.getLog(OSPRequestUtil.class);
}
