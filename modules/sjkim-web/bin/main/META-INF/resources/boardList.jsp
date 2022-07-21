<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="sjkim.web.constants.SjkimWebCommandKeys"%>
<%@page import="sjkim.web.constants.SjkimWebPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="sjkim.web.display.BoardDisplayContext"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ include file="./init.jsp"%>
<%
// 	포틀릿에서 보낸 파라미터 받기
	String displayStyle = GetterUtil.getString(request.getAttribute("displayStyle"), "list");
	
	//DisplayContext로 파라미터 넘기기
	BoardDisplayContext displayContext = new BoardDisplayContext(
		request,
		renderRequest,
		renderResponse
	);
	SearchContainer boardSearchContainer = displayContext.getSearchContainer();
	boolean isAdmin = (boolean) renderRequest.getAttribute("isAdmin");
%>

<liferay-portlet:renderURL var="boardViewURL" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>" portletMode="<%= LiferayPortletMode.VIEW.toString() %>">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%= SjkimWebCommandKeys.BOARD_VIEW_RENDER %>"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="boardUpdateFormURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>"  portletMode="<%= LiferayPortletMode.VIEW.toString() %>">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%=SjkimWebCommandKeys.BOARD_UPDATE_RENDER %>"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="boardDeleteURL" name="<%=SjkimWebCommandKeys.BOARD_DELETE_ACTION %>" >
	<liferay-portlet:param name="dataParam" value="dataValue"/>
</liferay-portlet:actionURL>

<h2>Board</h2>
<clay:management-toolbar componentId="tableSearchToolbar"
	clearResultsURL="<%=displayContext.getClearResultsURL()%>"
	filterDropdownItems="<%=displayContext.getFilterDropdownItems()%>"
	searchActionURL="<%=displayContext.getSearchActionURL()%>"
	searchFormName="searchFm"
	showSearch="<%=true%>"
	selectable="<%=false%>"
	searchFormMethod="POST"
	searchContainerId="assigneesSearch"
	itemsTotal="<%=boardSearchContainer.getTotal()%>"
	showCreationMenu="<%=displayContext.showCreationMenu()%>"
	creationMenu="<%=displayContext.getCreationMenu()%>"
	sortingURL="<%=displayContext.getSortingURL()%>"
	sortingOrder="<%=boardSearchContainer.getOrderByType()%>"
	namespace="<%=renderResponse.getNamespace()%>"
	infoPanelId="infoPanelId"
	showInfoButton="<%=false%>"
	filterLabelItems="<%=displayContext.getFilterLabelItems()%>"
/>

<div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />infoPanelId">
	<liferay-frontend:sidebar-panel
		resourceURL="<%=displayContext.getClearResultsURL()%>"
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
	id="boardSearchContainer"
	searchContainer="<%=boardSearchContainer%>"
	var="searchContainer"
	cssClass="text-center theme-table"
	>
<liferay-ui:search-container-row
 		className="sjkim.model.Board"
		escapedModel="<%=true%>" 
 		keyProperty="boardNo" 
 		modelVar="board" 
 		rowIdProperty="boardNo" 
		cssClass="text-center" 
 		indexVar="index" 
	>
 		<%@ include file="./boardList.jspf"%>
 		 
 </liferay-ui:search-container-row>
 	<liferay-ui:search-iterator displayStyle="<%=displayStyle%>" markupView="lexicon" />
</liferay-ui:search-container>

<script type="text/javascript">
function viewBoard(boardNo){
	window.location.href = '${boardViewURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'boardNo' : boardNo
			})));
}

//displyaContext에서 호출하는 함수
function updateFormBoard(boardNo){
	window.location.href = '${boardUpdateFormURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'boardNo' : boardNo
			})));
}

function deleteBoardAction(boardNo){
	var result = confirm("정말 삭제하시겠습니까?");
	
	if(result){
		window.location.href = '${boardDeleteURL}'.concat('&',
				$.param(Liferay.Util.ns('<portlet:namespace/>',{
					'boardNo' : boardNo
				})));
	} else{
		alert("취소되었습니다.");
	}
}
</script>	
