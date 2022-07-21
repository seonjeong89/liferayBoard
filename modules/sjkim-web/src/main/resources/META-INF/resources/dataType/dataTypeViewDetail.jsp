<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="sjkim.model.DataType"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="java.util.Date"%>
<%@page import="sjkim.web.util.OSPTimeUtil"%>
<%@page import="sjkim.web.constants.SjkimWebCommandKeys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./init.jsp" %>

<liferay-portlet:resourceURL var="sampleFileDownloadURL" id="<%=SjkimWebCommandKeys.DATATYPE_FILE_DOWNLOAD_RESOURCE %>" />

<liferay-portlet:renderURL var="dataTypeUpdateFormURL">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%=SjkimWebCommandKeys.DATATYPE_UPDATE_RENDER %>"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="dataTypeDeleteURL" name="<%=SjkimWebCommandKeys.DATATYPE_DELETE_ACTION %>" />

<% 
	DataType dataType = (DataType) renderRequest.getAttribute("dataType");
	Date writeDate = dataType.getDataTypeWriteDate();
	String writeDateBySecond = OSPTimeUtil.getTimeBySecond(writeDate);
	boolean isLogin = themeDisplay.isSignedIn();
	String userName = user.getScreenName();
	//${dataType.dataTypeExplanation}
	String backURL = ParamUtil.getString(renderRequest, "backURL");
%>

<liferay-ui:header
backLabel="뒤로가기"
title="DataType Detail"
backURL="<%= backURL %>"
/>

<aui:button onClick="javascript:location.href='/';" value="목록"></aui:button>
<c:if test="<%=isLogin %>">
	&nbsp;<aui:button onClick="updateFormDataType(${dataType.dataTypeNo});" value="수정" cssClass="editButton" ></aui:button>
	<aui:button onClick="deleteDataTypeAction(${dataType.dataTypeNo});" value="삭제" cssClass="editButton" ></aui:button>
</c:if>

<br><br>

<table class="table" style="width: 100%;">
	<tbody>
		<tr>
			<th scope="row" style="width: 10%; text-align: center;">데이터타입</th>
			<td colspan="5" style="width: 80%;">${dataType.dataTypeNV}</td>
		</tr>
		<tr>
			<th scope="row" style="width: 10%; text-align: center;">작성자</th>
			<td style="width: 10%;">${dataType.dataTypeWriter}</td>
			<th scope="row" style="width: 10%; text-align: center;"></th>
			<td style="width: 10%;"></td>
			<th scope="row" style="width: 10%; text-align: center;">작성일자</th>
			<td style="width: 10%;"><%=writeDateBySecond %></td>
		</tr>
		<tr>
			<th scope="row" style="width: 10%; text-align: center;">디스플레이명</th>
			<td colspan="5" style="width: 80%;">
				<aui:form name="dataTypeDisplayForm">
					<liferay-ui:input-localized type="textarea" xml="${dataType.dataTypeDisplayName}" name="dataTypeDisplayName" readonly="true"></liferay-ui:input-localized>
				</aui:form>
			</td>
		</tr>
		<tr>
			<th scope="row" style="width: 10%; text-align: center;">설명</th>
			<td colspan="5" style="width: 80%;">
				<aui:form name="dataTypeExplainForm">
					<liferay-ui:input-localized type="textarea" xml="${dataType.dataTypeExplanation}" name="dataTypeExplanation" readonly="true"></liferay-ui:input-localized>
				</aui:form>
			</td>
		</tr>
		<tr>
			<th scope="row" style="width: 10%; text-align: center;">샘플파일</th>
			<td colspan="5" style="width: 80%;">
				<c:if test="${empty dataType.sampleFileName}">
					샘플파일이 없습니다.
				</c:if>
				<c:if test="${!empty dataType.sampleFileName}">
					<a href="javascript:sampleFileDownload(${dataType.dataTypeNo});">${dataType.sampleRealFileName}</a>
				</c:if>
			</td>
		</tr>
		<tr>
			<th scope="row" style="width: 10%; text-align: center;">구조</th>
			<td colspan="5" style="width: 80%;"></td>
		</tr>
		<tr>
			<th colspan="6" style="width: 90%;">${dataType.dataTypeStructure}</th>
		</tr>
	</tbody>
</table>

<aui:input name="isLogin" type="hidden" id="isLogin" value="<%=isLogin %>"></aui:input>
<aui:input name="loginUserName" type="hidden" id="userName" value="<%=userName %>"></aui:input>

<script type="text/javascript">
// form 불러오기 상태 여부
var registForm = false;

// 로그인 여부
var isLogin = $('#<portlet:namespace/>isLogin').val();

// 로그인 유저 이름
var loginUserName = $('#<portlet:namespace/>userName').val();

// 로그인에 따라 버튼 보여주기 처리
function showButton(){
	if(isLogin == "false"){
		$('.buttonclass1').css("display", "none");
		$('.buttonclass2').css("display", "none");
		$('.buttonclass3').css("display", "none");
		$('.buttonclass4').css("display", "none");
	}
}

// 파일 다운로드
function sampleFileDownload(dataTypeNo){
	window.location.href = '${sampleFileDownloadURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'dataTypeNo' : dataTypeNo
			})));
}

// 데이터타입 수정 form 이동
function updateFormDataType(dataTypeNo){
	window.location.href = '${dataTypeUpdateFormURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'dataTypeNo' : dataTypeNo
			})));
}

// 데이터타입 삭제 함수
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
