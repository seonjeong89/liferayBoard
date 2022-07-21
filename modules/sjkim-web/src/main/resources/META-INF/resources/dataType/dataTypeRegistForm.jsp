<%@page import="sjkim.web.constants.SjkimWebCommandKeys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./init.jsp" %>

<liferay-portlet:actionURL var="dataTypeRegistURL" name="<%=SjkimWebCommandKeys.DATATYPE_REGIST_ACTION %>" />
<liferay-portlet:resourceURL var="dataTypeDuplicatedCheckURL" id="<%=SjkimWebCommandKeys.DATATYPE_DUPLICATED_CHECK_RESOURCE %>" />

<portlet:resourceURL var="localizationTestUrl" id="localizationTest">
	<liferay-portlet:param name="mvcRenderCommandName" value="localizationTest"/>
</portlet:resourceURL>

<portlet:resourceURL var="JSONTestUrl" id="JSONTest">
	<liferay-portlet:param name="mvcRenderCommandName" value="JSONTest"/>
</portlet:resourceURL>

<portlet:resourceURL var="JSONFileDownloadURL" id="<%=SjkimWebCommandKeys.DATATYPE_JSON_FILE_DOWNLOAD_RESOURCE %>" />

<h2>DataType 등록</h2>
<br>

<aui:form name="dataTypeRegistForm" action="${dataTypeRegistURL}" method="post" enctype="multipart/form-data">
	<aui:input name="dataTypeName" id="dataTypeName" required="true" label="데이터타입명" placeholder="영문,숫자시작X,특수문자 _ $ 허용">
	<aui:validator name="required" errorMessage="데이터타입명 입력은 필수입니다."></aui:validator>
	<aui:validator name="custom" errorMessage="잘못된 형식입니다. 확인 후 다시 입력해주세요.">
					function(val, fieldNode, ruleValue) {
						var regex = new RegExp(/^[a-zA-Z]([0-9a-zA-Z_$])*$/);
						
						return regex.test(val);
					}
	</aui:validator>
	</aui:input>
	<aui:input name="dataTypeVersion" id="dataTypeVersion" required="true" placeholder="000.000.000" label="데이터타입 버전">
	<aui:validator name="required" errorMessage="데이터타입 버전 입력은 필수입니다."></aui:validator>
	<aui:validator name="custom" errorMessage="버전은 000.000.000 형식으로 입력해야 합니다.">
		function(val, fieldNode, ruleValue) {
			var regex = new RegExp(/^(?:(\d+)\.)+(?:(\d+)\.)+(?:(\d+))$/);
			
			return regex.test(val);
		}
	</aui:validator>
	</aui:input>
		<div style="text-align: right;">
			<aui:button onClick="duplicatedCheck();" value="중복확인" />
		</div>
		<div id="checkResultDiv" style="text-align: center;">
			<span id="notDuplicated" style="color: green; display: none;">* 사용 가능합니다.</span>
			<span id="duplicated" style="color: red; display: none;">* 중복 되는 항목이 있습니다. 수정해주시기 바랍니다.</span>
		</div>
	<br>
	<aui:field-wrapper label="디스플레이명">
		<liferay-ui:input-localized xml="" name="dataTypeDisplayName"></liferay-ui:input-localized>
	</aui:field-wrapper>
	<aui:field-wrapper cssClass="lfr-textarea-container" label="설명">
		<liferay-ui:input-localized type="textarea" xml="" name="dataTypeExplanation"></liferay-ui:input-localized>
	</aui:field-wrapper>
	
	<aui:input type="hidden" name="dataTypeStructure" id="dataTypeStructure"/>
	<aui:input type="file" name="sampleFile" label="샘플 파일" />
	<aui:input type="hidden" name="sampleFileExist" id="sampleFileExist"/>
</aui:form>
<br><br>
<div class="row">
	<div class="col-sm-6">
		<h3>구조 등록</h3>
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
	<aui:button onClick="registDataType();" value="등록" />&nbsp;
	<aui:button onClick="javascript:location.href='/';" value="취소"></aui:button>
</div>

<script>
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

function jsonFileDownload2(){
	var formData = $('form[name=<portlet:namespace/>dataTypeStructureForm]').serialize();
	$.ajax({
		url : '${JSONFileDownloadURL}',
		type : 'post',
		data : formData,
		success : function(data){
			console.log("JSONdata : "+ data);
			alert("저장 성공 ^^");
		},
		error : function(err){
			console.log("err : ", err);
			alert('에러발생!')
		}
	});
}

var jsonStructureArray = new Array();

function jsonChange(){
	var formData = $('form[name=<portlet:namespace/>dataTypeStructureForm]').serialize();
	
	$.ajax({
		url : '${JSONTestUrl}',
		type : 'post',
		data : formData,
		success : function(data){
			console.log("JSONdata : "+ data);
			var obj = JSON.parse(data);
			jsonStructureArray.push(obj);
			var jsonStructureArrayString = JSON.stringify(jsonStructureArray);
			console.log("JSONArrayData : "+ jsonStructureArrayString);
			$('#<portlet:namespace/>dataTypeStructure').val(jsonStructureArrayString);
			$('form[name=<portlet:namespace/>dataTypeStructureForm]')[0].reset();
			
		},
		error : function(err){
			console.log("err : ", err);
			alert('에러발생!')
		}
	});
}

// 중복 확인 검사 여부(false 일때 중복이 아님)
var isDuplicated = true;

// 타입명 + 버전 중복 확인
function duplicatedCheck(){
	var dataTypeName = $('#<portlet:namespace/>dataTypeName').val().trim();
	var dataTypeVersion = $('#<portlet:namespace/>dataTypeVersion').val().trim();
	
	$('#notDuplicated').css("display","none");
	$('#duplicated').css("display","none");
	
	if(dataTypeName == "" || dataTypeVersion == ""){
		alert("입력하지 않은 값이 있습니다. 확인 후 입력해주세요.");
		return;
	}
	
	var regex = new RegExp(/^(?:(\d+)\.)+(?:(\d+)\.)+(?:(\d+))$/);
	
	if(!regex.test(dataTypeVersion)){
		alert("버전 값을 잘못입력하셨습니다. 확인 후 다시 입력해주세요.");
		return;
	}
	
	var resourceURL = '${dataTypeDuplicatedCheckURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'dataTypeName' : dataTypeName,
				'dataTypeVersion' : dataTypeVersion
			})));
	
	$.ajax({
		type:"post"
		,url: resourceURL
		,success:function(data){
			if(data == "no"){
				$('#duplicated').css("display","");
				$('#notDuplicated').css("display","none");
				isDuplicated = true;
			} else if(data == "ok"){
				$('#notDuplicated').css("display","");
				$('#duplicated').css("display","none");
				isDuplicated = false;
			}
		}
		,error:function(){
			alert("에러입니다.");
		}
	});
}

function registDataType(){
	
	var formData = $('form[name=<portlet:namespace/>dataTypeRegistForm]');
	
	var sampleFileExist = $('#<portlet:namespace/>sampleFile').val();
	
	if(!sampleFileExist){
		//alert("파일 첨부 안했습니다.");
		$('#<portlet:namespace/>sampleFileExist').val("false");
	} else{
		//alert("파일 첨부 했습니다.");
		$('#<portlet:namespace/>sampleFileExist').val("true");
	}
	
	if(isDuplicated){
		alert("중복 확인이 제대로 되지 않았습니다. 다시 시도해 주십시오.");
		return;
	} else{
		formData.submit();
	}
}
</script>