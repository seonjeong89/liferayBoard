<%@page import="sjkim.web.constants.SjkimWebCommandKeys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./init.jsp" %>

<liferay-portlet:actionURL var="boardUpdateURL" name="<%=SjkimWebCommandKeys.BOARD_UPDATE_ACTION %>" >
	<liferay-portlet:param name="dataParam" value="dataValue"/>
</liferay-portlet:actionURL>
<liferay-portlet:resourceURL var="fileDownloadURL" id="<%=SjkimWebCommandKeys.BOARD_FILE_DOWNLOAD_RESOURCE %>" />
<liferay-portlet:resourceURL var="fileDeleteURL" id="<%=SjkimWebCommandKeys.BOARD_FILE_DELETE_RESOURCE %>" />

<aui:form action="${boardUpdateURL}" method="post" enctype="multipart/form-data">
	<aui:button type="submit" value="수정" />
	<aui:button onClick="listGo();" value="목록" />
	<aui:input  name="title" value="${board.boardTitle}" pattern="^[가-힣a-zA-Z0-9\s]+$" placeholder="한글,영문,숫자만 가능" />
	<aui:input type="textarea" name="content" value="${board.boardContent}" style="height: 100%;" onkeydown="resize(this)" onkeyup="resize(this)" />
	<aui:input type="hidden" name="boardNo" value="${board.boardNo}" />
	<aui:input type="file" name="uploadedFile" multiple="true" />
</aui:form>
<hr/>
<p>첨부파일 : </p>
<c:forEach var="item" items="${uploadFileList}"> 
	<p>
		<a href="javascript:fileDownload(${item.uploadFileNo});">${item.uploadRealFileName}</a>
		<button type='button' class='btn btn-primary btn-sm' data-id="${item.uploadFileNo}" onclick='deleteFile(this);'>삭제</button>
	</p>
</c:forEach>

<script>

function resize(obj) {
    obj.style.height = '1px';
    obj.style.height = (12 + obj.scrollHeight) + 'px';
}

function listGo(){
	window.location.href="./";
}

//파일 다운로드
function fileDownload(uploadFileNo){
	
	location.href = '${fileDownloadURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'uploadFileNo' : uploadFileNo
			})));				
}

// 파일 삭제 메소드
function deleteFile(e){
	var uploadFileNo = $(e).attr("data-id");
	var parentP = $(e).parent();
	var result = confirm("정말 삭제하시겠습니까?");
	
	var resourceURL = '${fileDeleteURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'uploadFileNo' : uploadFileNo
			})));
	
	if(result){
		
		$.ajax({
			type:"post"
			,url: resourceURL
			,success:function(){
				alert("파일 삭제를 성공했습니다.");
				parentP.remove();
			}
			,error:function(){
				alert("파일 삭제를 실패했습니다.");
			}
		});
	}
}
</script>