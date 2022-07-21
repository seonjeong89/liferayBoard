<%@page import="sjkim.model.DataType"%>
<%@page import="sjkim.web.display.DataTypeDisplayContext"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="sjkim.web.constants.SjkimWebCommandKeys"%>
<%@page import="sjkim.web.constants.SjkimWebPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="sjkim.web.display.BoardDisplayContext"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ include file="./init.jsp"%>
<%
// 포틀릿에서 보낸 파라미터 받기
	String displayStyle = GetterUtil.getString(request.getAttribute("displayStyle"), "list");
	
// DisplayContext로 파라미터 넘기기
	DataTypeDisplayContext dataTypeDisplayContext = new DataTypeDisplayContext(
		request,
		renderRequest,
		renderResponse
	);
	SearchContainer dataTypeSearchContainer = dataTypeDisplayContext.getSearchContainer();
	boolean isAdmin = (boolean) renderRequest.getAttribute("isAdmin");
// 	DataType dataType = null;
// 	dataType.getDataTypeNV();
// 	dataType.getDataTypeWriteDate();
// 	dataType.getDataTypeUpdateDate();
// 	dataType.getDataTypeWriter();
%>

<liferay-portlet:renderURL var="dataTypeViewURL">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%= SjkimWebCommandKeys.DATATYPE_VIEW_RENDER %>"/>
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="dataTypeUpdateFormURL">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%=SjkimWebCommandKeys.DATATYPE_UPDATE_RENDER %>"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="dataTypeDeleteURL" name="<%=SjkimWebCommandKeys.DATATYPE_DELETE_ACTION %>" >
</liferay-portlet:actionURL>

<liferay-portlet:actionURL var="dataTypeCloneURL" name="<%=SjkimWebCommandKeys.DATATYPE_CLONE_ACTION %>" />
<liferay-portlet:resourceURL var="dataTypeDuplicatedCheckURL" id="<%=SjkimWebCommandKeys.DATATYPE_DUPLICATED_CHECK_RESOURCE %>" />
<liferay-portlet:actionURL var="dataTypeUpgradeURL" name="<%=SjkimWebCommandKeys.DATATYPE_UPGRADE_ACTION %>" />

<h2>DataType</h2>

<clay:management-toolbar componentId="tableSearchToolbar"
	clearResultsURL="<%=dataTypeDisplayContext.getClearResultsURL()%>" 
	filterDropdownItems="<%=dataTypeDisplayContext.getFilterDropdownItems()%>" 
	searchActionURL="<%=dataTypeDisplayContext.getSearchActionURL()%>" 
	searchFormName="searchFm" 
	showSearch="<%=true%>"
	selectable="<%=false%>" 
	searchFormMethod="POST" 
 	searchContainerId="assigneesSearch" 
	itemsTotal="<%=dataTypeSearchContainer.getTotal()%>" 
	showCreationMenu="<%=dataTypeDisplayContext.showCreationMenu()%>" 
	creationMenu="<%=dataTypeDisplayContext.getCreationMenu()%>" 
	sortingURL="<%=dataTypeDisplayContext.getSortingURL()%>" 
	sortingOrder="<%=dataTypeSearchContainer.getOrderByType()%>"
 	namespace="<%=renderResponse.getNamespace()%>" 
	infoPanelId="infoPanelId" 
	showInfoButton="<%=false%>" 
	filterLabelItems="<%=dataTypeDisplayContext.getFilterLabelItems()%>"
/>

<div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />infoPanelId">
	<liferay-frontend:sidebar-panel
	resourceURL="<%=dataTypeDisplayContext.getClearResultsURL()%>"
	searchContainerId="assigneesSearch" 
	> 
		<div class="sidebar-header">
			<h4 class="sidebar-title"></h4>
		</div>
		<div class="sidenav-content">
			<div class="alert alert-success">
				<liferay-ui:message key="x-saved-successfully" />
			</div>
		</div>
	</liferay-frontend:sidebar-panel>
</div>

<liferay-ui:search-container
id="dataTypeSearchContainer" 
searchContainer="<%=dataTypeSearchContainer%>" 
var="searchContainer"
cssClass="text-center theme-table"
>
<liferay-ui:search-container-row
	className="sjkim.model.DataType"
	escapedModel="<%=true%>"
	keyProperty="dataTypeNo"
	modelVar="dataType"
	rowIdProperty="dataTypeNo"
	cssClass="text-center"
	indexVar="index"
>
	<%@ include file="dataTypeList.jspf"%>
 		 
</liferay-ui:search-container-row>
<liferay-ui:search-iterator displayStyle="<%=displayStyle%>" markupView="lexicon" />
</liferay-ui:search-container>

<script type="text/javascript">
function viewDataType(dataTypeNo){
	window.location.href = '${dataTypeViewURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'dataTypeNo' : dataTypeNo
			})));
}

// DisplayContext에서 호출하는 함수
function updateFormDataType(dataTypeNo){
	window.location.href = '${dataTypeUpdateFormURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'dataTypeNo' : dataTypeNo
			})));
}

// 복제 실행 하는 함수
function cloneDataType(dataTypeNo,dataTypeName,dataTypeVersion){
	var result = confirm("복제하시겠습니까?");
	
	if(result){
		var newDataTypeVersion = prompt("새로운 버전을 입력하세요", dataTypeVersion);
		
		if(newDataTypeVersion != null){ // 새로운 버전을 입력했을 때 중복값 확인 후 복제
			
			// 정규식 검사(입력값이 숫자.숫자.숫자인지)
			var reg = /^(?:(\d+)\.)+(?:(\d+)\.)+(?:(\d+))$/;
			
			if(!reg.test(newDataTypeVersion)){ // 잘못된 형식을 입력한 경우
				alert("잘못된 형식을 입력하셨습니다. 확인 후 다시 입력해주시기 바랍니다.");
				return;
			} else{ // 형식을 제대로 입력한 경우 중복 검사 후 복제 액션 실행
				var resourceURL = '${dataTypeDuplicatedCheckURL}'.concat('&',
						$.param(Liferay.Util.ns('<portlet:namespace/>',{
							'dataTypeName' : dataTypeName,
							'dataTypeVersion' : newDataTypeVersion
						})));
				
				$.ajax({
					type:"post"
					,url: resourceURL
					,success:function(data){
						if(data == "no"){
							alert("중복되는 버전이 있습니다. 확인 후 다시 입력해주시기 바랍니다.");
						} else if(data == "ok"){
							window.location.href = '${dataTypeCloneURL}'.concat('&',
									$.param(Liferay.Util.ns('<portlet:namespace/>',{
										'dataTypeNo' : dataTypeNo,
										'dataTypeVersion' : newDataTypeVersion
									})));
						}
					}
					,error:function(){
						alert("에러입니다.");
					}
				});
			}
			
		}else{ // 입력한 새로운 버전 값이 없을 때
			alert("아무 값도 입력되지 않았습니다. 버전을 입력하세요.");
		}
	} else{ // 컨펌창에서 취소 눌렀을 때
		alert("취소되었습니다.");
	}
	
}

function upgradeDataType(dataTypeNo){
	var result = confirm("업그레이드하시겠습니까?");
	
	if(result){
		window.location.href = '${dataTypeUpgradeURL}'.concat('&',
				$.param(Liferay.Util.ns('<portlet:namespace/>',{
					'dataTypeNo' : dataTypeNo
				})));
	}  else{ // 컨펌창에서 취소 눌렀을 때
		alert("취소되었습니다.");
	}
}

function deleteDataTypeAction(dataTypeNo){
	var result = confirm("정말 삭제하시겠습니까?");
	
	if(result){
		window.location.href = '${dataTypeDeleteURL}'.concat('&',
				$.param(Liferay.Util.ns('<portlet:namespace/>',{
					'dataTypeNo' : dataTypeNo
				})));
	} else{
		alert("취소되었습니다.");
	}
}
</script>	
