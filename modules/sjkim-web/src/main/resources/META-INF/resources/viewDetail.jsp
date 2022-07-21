<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="sjkim.web.display.BoardDisplayContext"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="java.util.Date"%>
<%@page import="sjkim.model.Board"%>
<%@page import="sjkim.web.util.OSPTimeUtil"%>
<%@page import="sjkim.web.constants.SjkimWebCommandKeys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./init.jsp" %>

<%-- <liferay-portlet:actionURL var="boardCreateURL" name="<%=SjkimWebCommandKeys.BOARD_INSERT_ACTION %>" > --%>
<%-- 	<liferay-portlet:param name="dataParam" value="dataValue"/> --%>
<%-- </liferay-portlet:actionURL> --%>

<liferay-portlet:resourceURL var="boardReplyListURL" id="<%=SjkimWebCommandKeys.BOARD_REPLY_LIST_RESOURCE %>" />
<liferay-portlet:resourceURL var="boardReplyRegistURL" id="<%=SjkimWebCommandKeys.BOARD_REPLY_REGIST_RESOURCE %>" />
<liferay-portlet:resourceURL var="boardReplyUpdateURL" id="<%=SjkimWebCommandKeys.BOARD_REPLY_UPDATE_RESOURCE %>" />
<liferay-portlet:resourceURL var="boardReplyDeleteURL" id="<%=SjkimWebCommandKeys.BOARD_REPLY_DELETE_RESOURCE %>" />

<liferay-portlet:resourceURL var="boardReReplyListURL" id="<%=SjkimWebCommandKeys.BOARD_RE_REPLY_LIST_RESOURCE %>" />
<liferay-portlet:resourceURL var="boardReReplyRegistURL" id="<%=SjkimWebCommandKeys.BOARD_RE_REPLY_REGIST_RESOURCE %>" />
<liferay-portlet:resourceURL var="boardReReplyDeleteURL" id="<%=SjkimWebCommandKeys.BOARD_RE_REPLY_DELETE_RESOURCE %>" />
<liferay-portlet:resourceURL var="fileDownloadURL" id="<%=SjkimWebCommandKeys.BOARD_FILE_DOWNLOAD_RESOURCE %>" />

<liferay-portlet:renderURL var="boardUpdateFormURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>"  portletMode="<%= LiferayPortletMode.VIEW.toString() %>">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%=SjkimWebCommandKeys.BOARD_UPDATE_RENDER %>"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="boardDeleteURL" name="<%=SjkimWebCommandKeys.BOARD_DELETE_ACTION %>" >
	<liferay-portlet:param name="dataParam" value="dataValue"/>
</liferay-portlet:actionURL>

<%-- ${board} --%>
<% 
	Board board = (Board) renderRequest.getAttribute("board");
	Date writeDate = board.getBoardWriteDate();
	String writeDateBySecond = OSPTimeUtil.getTimeBySecond(writeDate);
	Boolean isLogin = themeDisplay.isSignedIn();
	String userName = user.getScreenName();
%>
<aui:button onClick="listGo();" value="목록으로" ></aui:button>
<c:if test="<%=isLogin %>">
	 &nbsp;<aui:button onClick="updateFormBoard(${board.boardNo});" value="수정" cssClass="editButton" ></aui:button>
	<aui:button onClick="deleteBoardAction(${board.boardNo});" value="삭제" cssClass="editButton" ></aui:button>
</c:if>
<br><br>

<table class="table" style="width: 100%;">
  <tbody>
    <tr>
      <th scope="row" style="width: 10%; text-align: center;">제목</th>
      <td colspan="5" style="width: 80%;">${board.boardTitle}</td>
    </tr>
    <tr>
      <th scope="row" style="width: 10%; text-align: center;">작성자</th>
      <td style="width: 10%;">${board.boardWriter}</td>
      <th scope="row" style="width: 10%; text-align: center;">작성일자</th>
      <td style="width: 10%;"><%=writeDateBySecond %></td>
      <th scope="row" style="width: 10%; text-align: center;">조회수</th>
      <td style="width: 10%;">${board.boardViewCount}</td>
    </tr>
    <tr>
      <th scope="row" style="width: 10%; text-align: center;">내용</th>
      <td colspan="5" style="width: 80%;"></td>
    </tr>
    <tr>
      <th colspan="6" style="width: 80%;"><pre style="font-size: 14px;">${board.boardContent}</pre></th>
    </tr>
  </tbody>
</table>
<hr>
<p>첨부파일 : </p>
<c:if test="${empty uploadFileList}">
	<p style="text-align: center; width: 100%;">첨부파일이 없습니다.</p>
</c:if>

<c:if test="${!empty uploadFileList}">
	<c:forEach var="item" items="${uploadFileList}"> 
	     <a href="javascript:fileDownload(${item.uploadFileNo});">${item.uploadRealFileName}</a>
	</c:forEach>
</c:if>

<c:if test="<%=isLogin %>">
	<hr/>
	<aui:input id="replyContent" type="textarea" name="replyContent" label="댓글 내용"></aui:input> 
	<aui:button onClick="registReply();" value="댓글 등록" />
</c:if>

<aui:input name="isLogin" type="hidden" id="isLogin" value="<%=isLogin %>"></aui:input>
<aui:input name="loginUserName" type="hidden" id="userName" value="<%=userName %>"></aui:input>

<br><br>

<div id="replyAppend"></div>

<script>
// form 불러오기 상태 여부
var registForm = false;

// 로그인 여부
var isLogin = $('#<portlet:namespace/>isLogin').val();

// 로그인 유저 이름
var loginUserName = $('#<portlet:namespace/>userName').val();

// 댓글 시작 번호
var startNum = 0;
// 페이지 로딩 한 후 댓글 리스트 불러오는 함수를 실행한다.
window.onload=function(){
	listReply();
	
	$(window).scroll(function(){
		if ($(this).scrollTop() + $(this).height() +1 >= $(document).height()){
			listReplyAdd();
		}
	});
}

// 로그인에 따라 버튼 보여주기 처리
function showButton(){
	if(isLogin == "false"){
		$('.buttonclass1').css("display", "none");
		$('.buttonclass2').css("display", "none");
		$('.buttonclass3').css("display", "none");
		$('.buttonclass4').css("display", "none");
	}
}

// 맨 처음으로 돌아가는 함수 
function listGo(){
	window.location.href="/";
}

// 댓글 리스트 불러오는 함수(데이터를 불러와서 테이블에 text 형태로 넣어준다. 부모 댓글만 불러온다.)
function listReply(){
	
	var resourceURL = '${boardReplyListURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'boardNo' : '${board.boardNo}',
				'replyLevel' : 1,
				'startNum' : startNum
			})));				

	$.ajax({
		type:"get"
		,url: resourceURL
		,dataType:"json"
		,success:function(data){
			$('#replyAppend').empty();
			registForm = false;
			if(data.length>0){
				
				var td = $("<table class='table' id='replyTable' />");
				
				for( var i in data ){
					var replyContent= data[i].replyContent;
					var replyWriter = data[i].replyWriter;
					var replyUpdateDate = data[i].replyUpdateDate;
					var replyNo = data[i].replyNo;
					var replyDeleteYN = data[i].replyDeleteYN;
					
					var row = $("<tr id="+replyNo+" />").append(
							$("<td style='width: 50%;' id=replyContent"+replyNo+"/>").text(replyContent),
							$("<td style='text-align: center; width: 10%;' data-delete='"+replyDeleteYN+"' id='replyWriter"+replyNo+i+"'/>").text(replyWriter),
							$("<td style='text-align: right;' width: 15%;/>").text(replyUpdateDate),
							$("<td class='buttonclass1' style='text-align: center; padding-right: 0px; width: 8%;'><button type='button' class='btn btn-info btn-sm reReplyRegistButton' id='reReplyRegistButton"+replyNo+"' data-id="+replyNo+" onclick='registReReplyForm(this);'>답글</button></td>"),
							$("<td class='buttonclass2' style='text-align: right; width: 16%;'><button type='button' class='btn btn-info btn-sm replyUpdateButton' id='replyUpdateButton"+replyNo+"' onclick='updateReplyForm(this);' data-id="+replyNo+">수정</button>&nbsp;&nbsp;<button type='button' class='btn btn-danger btn-sm replyDeleteButton' id='replyDeleteButton"+replyNo+"' data-id="+replyNo+" onclick='deleteReply(this);'>삭제</button></td>")
					);
					td.append(row);
				}
				$("#replyAppend").append(td);
				
				for( var j in data ){
					var replyDeleteYN = data[j].replyDeleteYN;
					var replyNo = data[j].replyNo;
					var replyWriter = data[j].replyWriter;
					
					if(replyWriter !== loginUserName){
						$('#replyUpdateButton'+replyNo).css("visibility","hidden");
						$('#replyDeleteButton'+replyNo).css("visibility","hidden");
					}
					
					if(${isAdmin}){
						$('#replyDeleteButton'+replyNo).css("visibility", "visible");
					}
					
					if(replyDeleteYN == "Y"){
						$('#reReplyRegistButton'+replyNo).css("visibility","hidden");
						$('#replyUpdateButton'+replyNo).css("visibility","hidden");
						$('#replyDeleteButton'+replyNo).css("visibility","hidden");
					}
				}
				
				showButton();
				listReReply();
			} else {
				var td = $("<table class='table' />");
				
				var row = $("<tr id="+replyNo+" />").append(
						$("<td style='text-align: center; width: 100%;'/>").text("댓글이 없습니다."),
				);
				td.append(row);
				$("#replyAppend").append(td);
			}
		}
		,error:function(){
			alert("에러입니다.");
		}
	});
}

// 댓글 리스트 추가로 불러오는 함수
function listReplyAdd(){
	
	startNum += 10;
	
	var resourceURL = '${boardReplyListURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'boardNo' : '${board.boardNo}',
				'replyLevel' : 1,
				'startNum' : startNum
			})));				
	var td = $('#replyTable');
	
	$.ajax({
		type:"get"
		,url: resourceURL
		,dataType:"json"
		,success:function(data){
			registForm = false;
			if(data.length>0){
				
				for( var i in data ){
					var replyContent= data[i].replyContent;
					var replyWriter = data[i].replyWriter;
					var replyUpdateDate = data[i].replyUpdateDate;
					var replyNo = data[i].replyNo;
					var replyDeleteYN = data[i].replyDeleteYN;
					console.log("repltDeleteYN : " + replyDeleteYN);
					var row = $("<tr id="+replyNo+" />").append(
							$("<td style='width: 50%;' id=replyContent"+replyNo+"/>").text(replyContent),
							$("<td style='text-align: center; width: 10%;' id='replyWriter"+replyNo+"'/>").text(replyWriter),
							$("<td style='text-align: right;' width: 15%;/>").text(replyUpdateDate),
							$("<td class='buttonclass1' style='text-align: center; padding-right: 0px; width: 8%;'><button type='button' class='btn btn-info btn-sm' id='reReplyRegistButton"+replyNo+"' data-id="+replyNo+" onclick='registReReplyForm(this);'>답글</button></td>"),
							$("<td class='buttonclass2' style='text-align: right; width: 16%;'><button type='button' class='btn btn-info btn-sm' id='replyUpdateButton"+replyNo+"' onclick='updateReplyForm(this);' data-id="+replyNo+">수정</button>&nbsp;&nbsp;<button type='button' class='btn btn-danger btn-sm' id='replyDeleteButton"+replyNo+"' data-id="+replyNo+" onclick='deleteReply(this);'>삭제</button></td>")
					);
					td.append(row);
				}
				
				for( var j in data ){
					var replyDeleteYN = data[j].replyDeleteYN;
					var replyNo = data[j].replyNo;
					var replyWriter = data[j].replyWriter;
					
					if(replyWriter !== loginUserName){
						$('#replyUpdateButton'+replyNo).css("visibility","hidden");
						$('#replyDeleteButton'+replyNo).css("visibility","hidden");
					}
					
					if(${isAdmin}){
						$('#replyDeleteButton'+replyNo).css("visibility", "visible");
					}
					
					if(replyDeleteYN == "Y"){
						$('#reReplyRegistButton'+replyNo).css("visibility","hidden");
						$('#replyUpdateButton'+replyNo).css("visibility","hidden");
						$('#replyDeleteButton'+replyNo).css("visibility","hidden");
					}
				}
				
				showButton();
				listReReply();
			} 
		}
		,error:function(){
			alert("에러입니다.");
		}
	});
}

// 댓글 등록하는 함수(URL에 파라미터로 추가해서 데이터를 보냈다.)
function registReply(){
	var replyContent = $('#<portlet:namespace/>replyContent').val();
	
	if(isLogin == "false"){
		alert("로그인은 필수입니다.");
		return;
	}
	
	if(replyContent == ""){
		alert("댓글 입력은 필수입니다.");
		return;
	}
	
 	var resourceURL = '${boardReplyRegistURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'boardNo' : '${board.boardNo}',
				'replyContent' : replyContent
			})));				

	$.ajax({
		type:"post"
		,url: resourceURL
		,success:function(){
			console.log("ReplyInsert 성공!");
			$('#<portlet:namespace/>replyContent').val("");
			startNum = 0;
			listReply();
		}
		,error:function(){
			alert("에러입니다.");
		}
	});
}

// 댓글 수정 form 불러오는 함수(수정 버튼 클릭시 input 태그 나오도록 구현)
function updateReplyForm(e){
	var replyNo = $(e).attr("data-id");
	var replyContentTd = $("#replyContent"+replyNo);
	if(!registForm){
		registForm = true;
		var updateReplyInput = $("<input id='updateReply' style='width:70%' value='"+replyContentTd.text()+"'/>&nbsp;&nbsp;<button type='button' class='btn btn-info btn-sm' style='width:10%' onclick='updateReply(this);' data-id="+replyNo+">완료</button>&nbsp;&nbsp;<button type='button' class='btn btn-danger btn-sm' onclick='updateCancel();' style='width:10%'>취소</button>")
		replyContentTd.text("");
		replyContentTd.append(updateReplyInput);
	} else {
		alert("이미 수정 중인 작업이 있습니다. \n수정을 완료한 후 다시 시도하시기 바랍니다.");
	}
}

// 댓글 수정하는 함수(URL에 파라미터로 추가해서 데이터를 보냈다.)
function updateReply(e){
	var replyContent = $('#updateReply').val();
	var replyNo = $(e).attr("data-id");
	
	if(replyContent == ""){
		alert("댓글 입력은 필수입니다.");
		return;
	}
	
	var resourceURL = '${boardReplyUpdateURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'replyNo' : replyNo,
				'replyContent' : replyContent
			})));				

	$.ajax({
		type:"post"
		,url: resourceURL
		,success:function(){
			console.log("ReplyUpdate 성공!");
			startNum = 0;
			listReply();
		}
		,error:function(){
			alert("에러입니다.");
		}
	});
	
}

// 댓글 대댓글 수정 취소 했을 때 실행하는 함수
function updateCancel(){
	registForm = false;
	startNum = 0;
	listReply();
}

// 댓글 대댓글 삭제하는 함수(관리자와 작성자 메시지를 다르게 업데이트)
function deleteReply(e){
	var result = confirm("정말 삭제하시겠습니까?");
	var replyNo = $(e).attr("data-id");
	var replyContent = "";
	var resourceURL = "";
	if(result){
		if(${isAdmin}){
			replyContent = "관리자가 해당 댓글을 삭제했습니다.";
			resourceURL = '${boardReplyDeleteURL}'.concat('&',
					$.param(Liferay.Util.ns('<portlet:namespace/>',{
						'replyNo' : replyNo,
						'replyContent' : replyContent
			})));
		} else {
			replyContent = "작성자가 해당 댓글을 삭제했습니다.";
			resourceURL = '${boardReplyDeleteURL}'.concat('&',
				$.param(Liferay.Util.ns('<portlet:namespace/>',{
					'replyNo' : replyNo,
					'replyContent' : replyContent
				})));
		}

		$.ajax({
			type:"post"
			,url: resourceURL
			,success:function(){
				console.log("ReplyDelete 성공!");
				startNum = 0;
				listReply();
			}
			,error:function(){
				alert("에러입니다.");
			}
		});
		
	} else{
		alert("취소되었습니다.");
	}
}

// 대댓글 리스트 출력하는 함수
function listReReply(){
	var resourceURL = '${boardReReplyListURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'boardNo' : '${board.boardNo}',
				'replyLevel' : 2
			})));				

	$.ajax({
		type:"get"
		,url: resourceURL
		,dataType:"json"
		,success:function(data){
			$('.reReplyTr').remove();
 			if(data.length>0){
				
				for( var i in data ){
					var replyContent= data[i].replyContent;
					var replyWriter = data[i].replyWriter;
					var replyUpdateDate = data[i].replyUpdateDate;
					var replyNo = data[i].replyNo;
					var replyParentReplyNo = data[i].replyParentReplyNo;
					
					var row = $("<tr id="+replyNo+" class='reReplyTr' />").append(
							$("<td style='width: 50%; text-indent: 30px;' id=reReplyContent"+replyNo+"/>").text("┗━"+replyContent),
							$("<td style='text-align: center;  width: 10%;' id='reReplyWriter"+replyNo+"'/>").text(replyWriter),
							$("<td style='text-align: right;' width: 15%;/>").text(replyUpdateDate),
							$("<td colspan='2' class='buttonclass4' style='text-align: right; width: 24%;'>"
								+"<button type='button' class='btn btn-info btn-sm' id='reReplyUpdateButton"+replyNo+"' onclick='updateReReplyForm(this);' data-id="+replyNo+">수정</button>&nbsp;&nbsp;"
								+"<button type='button' class='btn btn-danger btn-sm' id='reReplyDeleteButton"+replyNo+"' data-id="+replyNo+" onclick='deleteReply(this);'>삭제</button></td>")
					);
					$('#'+replyParentReplyNo).after(row);
				}
				
				for( var j in data ){
					var replyDeleteYN = data[j].replyDeleteYN;
					var replyNo = data[j].replyNo;
					var replyWriter = data[j].replyWriter;
					
					if(replyWriter !== loginUserName){
						$('#reReplyUpdateButton'+replyNo).css("visibility","hidden");
						$('#reReplyDeleteButton'+replyNo).css("visibility","hidden");
					}
					
					if(${isAdmin}){
						$('#reReplyDeleteButton'+replyNo).css("visibility", "visible");
					}
					
					if(replyDeleteYN == "Y"){
						$('#reReplyUpdateButton'+replyNo).css("visibility","hidden");
						$('#reReplyDeleteButton'+replyNo).css("visibility","hidden");
					}
				}
 			}
 			showButton();
		}
		,error:function(){
			alert("에러입니다.");
		}
	});
}

// 대댓글 등록 form 출력하는 함수
function registReReplyForm(e){
	if(!registForm){
		registForm = true;
		var replyNo = $(e).attr("data-id");
		var parentTr = $('#'+replyNo);
		
		var row = $("<tr id=reReply"+replyNo+" />").append(
				$("<td colspan='3' style='width: 75%;'><textarea style='width: 100%;' id=reReplyContent"+replyNo+"/></td>"),
				$("<td colspan='3' class='buttonclass5' style='text-align: center; width: 24%;'><button type='button' class='btn btn-info btn-sm' data-id="+replyNo+" onclick='registReReply(this);'>등록</button>&nbsp;&nbsp;<button type='button' class='btn btn-danger btn-sm' onclick='updateCancel();'>취소</button></td>")
		);
		parentTr.after(row);
	} else {
		alert("이미 수정 중인 작업이 있습니다. \n수정을 완료한 후 다시 시도하시기 바랍니다.");
	}
}

// 대댓글 등록하는 함수
function registReReply(e){
	var replyNo = $(e).attr("data-id");
	var reReplyContent = $("#reReplyContent"+replyNo).val();
	
	if(reReplyContent == ""){
		alert("댓글 입력은 필수입니다.");
		return;
	}
	
 	var resourceURL = '${boardReReplyRegistURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'boardNo' : '${board.boardNo}',
				'reReplyContent' : reReplyContent,
				'replyNo' : replyNo
			})));				

	$.ajax({
		type:"post"
		,url: resourceURL
		,success:function(){
			console.log("ReReplyInsert 성공!");
			$('#<portlet:namespace/>replyContent').val("");
			startNum = 0;
			listReply();
		}
		,error:function(){
			alert("에러입니다.");
		}
	});
}

//대댓글 수정 form 불러오는 함수(수정 버튼 클릭시 input 태그 나오도록 구현)
function updateReReplyForm(e){
	var replyNo = $(e).attr("data-id");
	var reReplyContentTd = $("#reReplyContent"+replyNo);
	
	if(!registForm){
		registForm = true;
		var updateReReplyInput = $("<input id='updateReReply' style='width:70%' value='"+reReplyContentTd.text()+"'/>&nbsp;&nbsp;<button type='button' class='btn btn-info btn-sm' style='width:10%' onclick='updateReReply(this);' data-id="+replyNo+">완료</button>&nbsp;&nbsp;<button type='button' class='btn btn-danger btn-sm' onclick='updateCancel();' style='width:10%'>취소</button>")
		reReplyContentTd.text("");
		reReplyContentTd.append(updateReReplyInput);
	}else{
		alert("이미 수정 중인 작업이 있습니다. \n수정을 완료한 후 다시 시도하시기 바랍니다.");
	}
}

//대댓글 수정하는 함수(URL에 파라미터로 추가해서 데이터를 보냈다.)
function updateReReply(e){
	var reReplyContent = $('#updateReReply').val();
	var replyNo = $(e).attr("data-id");
	
	if(reReplyContent == ""){
		alert("댓글 입력은 필수입니다.");
		return;
	}
	
	var resourceURL = '${boardReplyUpdateURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'replyNo' : replyNo,
				'replyContent' : reReplyContent
			})));				

	$.ajax({
		type:"post"
		,url: resourceURL
		,success:function(){
			console.log("ReReplyUpdate 성공!");
			startNum = 0;
			listReply();
		}
		,error:function(){
			alert("에러입니다.");
		}
	});
}

// 파일 다운로드
function fileDownload(uploadFileNo){
	
	location.href = '${fileDownloadURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'uploadFileNo' : uploadFileNo,
			})));				
}

// 수정 form 이동
function updateFormBoard(boardNo){
	window.location.href = '${boardUpdateFormURL}'.concat('&',
			$.param(Liferay.Util.ns('<portlet:namespace/>',{
				'boardNo' : boardNo
			})));
}

// 게시글 삭제 함수
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
