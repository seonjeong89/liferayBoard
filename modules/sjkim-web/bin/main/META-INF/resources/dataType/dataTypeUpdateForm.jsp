<%@page import="sjkim.web.constants.SjkimWebCommandKeys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./init.jsp" %>

<liferay-portlet:actionURL var="dataTypeUpdateURL" name="<%=SjkimWebCommandKeys.DATATYPE_UPDATE_ACTION %>" >
</liferay-portlet:actionURL>
<liferay-portlet:resourceURL var="sampleFileDownloadURL" id="<%=SjkimWebCommandKeys.DATATYPE_FILE_DOWNLOAD_RESOURCE %>" />
<liferay-portlet:resourceURL var="fileDeleteURL" id="<%=SjkimWebCommandKeys.DATATYPE_FILE_DELETE_RESOURCE %>" />

<aui:form name="dataTypeUpdateForm" action="${dataTypeUpdateURL}" method="post" enctype="multipart/form-data">
	<aui:input name="dataTypeNV" label="데이터타입" value="${dataType.dataTypeNV}" readonly="true"/>
	<aui:field-wrapper label="디스플레이명">
		<liferay-ui:input-localized xml="${dataType.dataTypeDisplayName}" name="dataTypeDisplayName"></liferay-ui:input-localized>
	</aui:field-wrapper>
	<aui:field-wrapper label="설명">
		<liferay-ui:input-localized type="textarea" xml="${dataType.dataTypeExplanation}" name="dataTypeExplanation"></liferay-ui:input-localized>
	</aui:field-wrapper>
	<aui:input type="textarea" name="dataTypeStructure" onkeydown="resize(this)" onkeyup="resize(this)" placeholder="구조" label="데이터타입 구조" value="${dataType.dataTypeStructure}"/>
	<aui:input type="file" name="sampleFile" label="샘플 파일" />
	<aui:input type="hidden" name="dataTypeNo" value="${dataType.dataTypeNo}"/>
	<aui:input type="hidden" name="sampleFileExist" id="sampleFileExist"/>
	<aui:input type="hidden" name="sampleOldFileExist" id="sampleOldFileExist"/>
</aui:form>
<p>기존 샘플 파일 : </p>
		<c:if test="${empty dataType.sampleFileName}">
				<p>	
					샘플파일이 없습니다.
				<p>	
		</c:if>
		<c:if test="${!empty dataType.sampleFileName}">
			<div id="sampleFileDiv">
					<a href="javascript:sampleFileDownload(${dataType.dataTypeNo});">${dataType.sampleRealFileName}</a>
					<button type='button' class='btn btn-danger btn-xs' data-id="${dataType.dataTypeNo}" onclick='deleteSampleFile(this);'>삭제</button>
			</div>
		</c:if>

<br><br>
<div class="row">
	<div class="col-sm-6">
		<h3>구조 수정</h3>
	</div>
	<div class="col-sm-6" style="text-align: right;">
		<aui:button onClick="jsonChange();" value="변환"></aui:button>
		<aui:button onClick="removeStructure();" value="삭제"></aui:button>
	</div>
</div>
<aui:form name="dataTypeStructureForm">
				<aui:input name="dataTypeStructureName" label="이름" placeholder="영문,숫자시작X,특수문자 _ $ 허용">
				<aui:validator name="custom" errorMessage="잘못된 형식입니다. 확인 후 다시 입력해주세요.">
					function(val, fieldNode, ruleValue) {
						var regex = new RegExp(/^[a-zA-Z]([0-9a-zA-Z_$])*$/);
						
						return regex.test(val);
					}
				</aui:validator>
				</aui:input>
				<aui:select name="dataTypeStructureType" id="dataTypeStructureType" label="타입">
					<aui:option value="" selected="true">타입을 선택하세요</aui:option>
					<aui:option value="String">String</aui:option>
					<aui:option value="Numeric">Numeric</aui:option>
					<aui:option value="Array">Array</aui:option>
					<aui:option value="Dictionary">Dictionary</aui:option>
					<aui:option value="List">List</aui:option>
				</aui:select>
				<aui:field-wrapper label="디스플레이 이름">
					<liferay-ui:input-localized xml="" name="dataTypeStructureDisplayName"></liferay-ui:input-localized>
				</aui:field-wrapper>
				<aui:field-wrapper label="구조 설명">
					<liferay-ui:input-localized type="textarea" xml="" name="dataTypeStructureExplanation"></liferay-ui:input-localized>
				</aui:field-wrapper>
				<div id="StringDiv">
					<aui:input name="StringEx" label="예제"></aui:input>
					<aui:input type="textarea" name="StringRegex" label="정규식"></aui:input>
				</div>
				<div id="NumericDiv">
					<aui:input name="NumericEx" label="예제"></aui:input>
					<aui:input name="NumericUnit" label="유닛"></aui:input>
					
				</div>
				<div id="ArrayDiv">
					<aui:input name="ArrayEx" label="예제"></aui:input>
					<aui:select name="ArrayUnderType" label="하위타입">
						<aui:option value="String">String</aui:option>
						<aui:option value="Numeric">Numeric</aui:option>
					</aui:select>
				</div>
				<div id="DictionaryDiv">
					<aui:input name="DictionaryKeyEx" label="key 예제"></aui:input>
					<aui:input name="DictionaryValueEx" label="value 예제"></aui:input>
					<aui:select name="ValueUnderType" label="하위타입">
						<aui:option value="String">String</aui:option>
						<aui:option value="Numeric">Numeric</aui:option>
					</aui:select>
				</div>
				<div id="ListDiv">
					<aui:input name="ListOption" label="옵션 입력 값"></aui:input>
					<aui:input name="ListOptionValue" label="옵션 Value"></aui:input>
					<aui:field-wrapper cssClass="lfr-textarea-container" label="라벨">
						<liferay-ui:input-localized xml="" name="ListOptionLabel"></liferay-ui:input-localized>
					</aui:field-wrapper>
				</div>
</aui:form>

<br><br>

<aui:button onClick="jsonFileDownload();" value="json파일다운"></aui:button>

<div style="text-align: right;">
	<aui:button onClick="updateDataType();" value="수정" />&nbsp;
	<aui:button onClick="javascript:location.href='/';" value="취소"></aui:button>
</div>

<script>

function resize(obj) {
	obj.style.height = '1px';
	obj.style.height = (12 + obj.scrollHeight) + 'px';
}

function jsonFileDownload(){
	var jsonData = $('#<portlet:namespace/>dataTypeStructure').val();
	
	var fileName = prompt("저장할 파일명을 입력하세요");
	
	if(fileName == ""){
		fileName = "default";
	}
	
	var dataStr = "data:text/json;charset=utf-8," + encodeURIComponent(jsonData);
	var downloadAnchorNode = document.createElement('a');
	downloadAnchorNode.setAttribute("href", dataStr);
	downloadAnchorNode.setAttribute("download", fileName + ".json");
	document.body.appendChild(downloadAnchorNode); // required for firefox
	downloadAnchorNode.click();
	downloadAnchorNode.remove();
}

//파일 다운로드
function sampleFileDownload(dataTypeNo){
	window.location.href = '${sampleFileDownloadURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'dataTypeNo' : dataTypeNo
			})));
}

function deleteSampleFile(e){
	var parentDiv = $(e).parent();
	parentDiv.remove();
}

function updateDataType(){
	
	var sampleFileExist = $('#<portlet:namespace/>sampleFile').val();
	
	if(!sampleFileExist){
		$('#<portlet:namespace/>sampleFileExist').val("false");
	} else{
		$('#<portlet:namespace/>sampleFileExist').val("true");
	}
	
	if ($('#sampleFileDiv').contents().length == 0) {
		$('#<portlet:namespace/>sampleOldFileExist').val("false");
	} else{
		$('#<portlet:namespace/>sampleOldFileExist').val("true");
	}
	
	var formData = $('form[name=<portlet:namespace/>dataTypeUpdateForm]');
	formData.submit();
}

</script>