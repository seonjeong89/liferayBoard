<%@page import="sjkim.web.constants.SjkimWebCommandKeys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./init.jsp" %>

<liferay-portlet:actionURL var="boardRegistURL" name="<%=SjkimWebCommandKeys.BOARD_REGIST_ACTION %>" >
	<liferay-portlet:param name="dataParam" value="dataValue"/>
</liferay-portlet:actionURL>

<aui:form action="${boardRegistURL}" method="post" enctype="multipart/form-data">
	<aui:button type="submit" value="등록" />
	<aui:button onClick="listGo();" value="목록" />
	<aui:input  name="title" required="true" pattern="^[가-힣a-zA-Z0-9\s]+$" placeholder="한글,영문,숫자만 가능" label="제목" />
	<aui:input type="textarea" name="content" onkeydown="resize(this)" onkeyup="resize(this)" label="내용" />
	<aui:input type="file" name="uploadedFile" multiple="true" label="첨부 파일" />
</aui:form>

<script>
function listGo(){
	window.location.href="/";
}

function resize(obj) {
    obj.style.height = '1px';
    obj.style.height = (12 + obj.scrollHeight) + 'px';
}
</script>