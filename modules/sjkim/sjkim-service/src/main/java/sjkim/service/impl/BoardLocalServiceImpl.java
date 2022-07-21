/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package sjkim.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import sjkim.exception.NoSuchUploadFileException;
import sjkim.model.Board;
import sjkim.model.Reply;
import sjkim.model.UploadFile;
import sjkim.service.BoardLocalServiceUtil;
import sjkim.service.ReplyLocalServiceUtil;
import sjkim.service.UploadFileLocalServiceUtil;
import sjkim.service.UploadFileServiceUtil;
import sjkim.service.base.BoardLocalServiceBaseImpl;
import sjkim.service.persistence.impl.UploadFilePersistenceImpl;

/**
 * The implementation of the board local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>sjkim.service.BoardLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BoardLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=sjkim.model.Board", service = AopService.class
)
public class BoardLocalServiceImpl extends BoardLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>sjkim.service.BoardLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>sjkim.service.BoardLocalServiceUtil</code>.
	 */
	
	// 게시판 글 등록 메소드
	public Board insertBoard(String boardTitle,String boardContent,String boardWriter) {
		
		// 시퀀스 부여
		long insertSeq = CounterLocalServiceUtil.increment(Board.class.getName());
		Board board = BoardLocalServiceUtil.createBoard(insertSeq); // Board board = new Board();
		
		// 오늘 날짜 받기
		Date now = new Date();
		
		// 파라미터 받아서 set으로 추가
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setBoardWriter(boardWriter);
		board.setBoardWriteDate(now);
		System.out.println("insert complete");
		return boardPersistence.update(board);
	}
	
	// 검색 결과 리스트 출력 메소드
	public List<Board> searchBoardList(String keyword, int start, int end, OrderByComparator<Board> orderByComparator){
		List<Board> boardList=boardPersistence.findByboardTitle(keyword, start, end, orderByComparator);
		return boardList;
	}
	
	// 검색 결과 리스트 개수 출력 메소드
	public int searchBoardListCount(String keyword) {
		return boardPersistence.countByboardTitle(keyword);
	}	
	
	// 게시판 글 수정(업데이트) 메소드
	@Override
	public Board updateBoard(Long boardNo, String boardTitle, String boardContent) {
		Board board = null;
		try {
			// 게시판 번호에 맞는 게시글 정보를 가져온다.
			board = BoardLocalServiceUtil.getBoard(boardNo);
			// 오늘 날짜 받기
			Date now = new Date();
			
			// 업데이트 할 정보를 set 해준다.
			board.setBoardTitle(boardTitle);
			board.setBoardContent(boardContent);
			board.setBoardUpdateDate(now);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		System.out.println("update complete");
		return boardPersistence.update(board);
	}
	
	// 글 조회수 증가 메소드
	public Board increaseViewCount(Long boardNo) {
		Board board = null;
		
		try {
			board = BoardLocalServiceUtil.getBoard(boardNo);
			long currentViewCount = board.getBoardViewCount();
			long increaseViewCount = currentViewCount +1;
			board.setBoardViewCount(increaseViewCount);
			BoardLocalServiceUtil.updateBoard(board);
			System.out.println("increaseViewCount 완료");
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		return board;
	}
	
	// 게시판 글 삭제 메소드(파일도 삭제)
	public void deleteBoardWithFileList(Long boardNo) throws PortalException {
		// boardNo에 맞는 파일 리스트 가져오기
		List<UploadFile> uploadFileList = UploadFileLocalServiceUtil.uploadFileList(boardNo);
		String fileName = null;
		String uploadPath = null;
		// for문 돌려가면서 파일삭제하고 DB에서 삭제한다.
		for(int i=0; i<uploadFileList.size(); i++) {
			fileName = uploadFileList.get(i).getUploadFileName();
			uploadPath = uploadFileList.get(i).getUploadFileUploadPath();
			File file = new File(uploadPath+File.separator+fileName);
			
			if( file.exists() ){
				if(file.delete()){
					System.out.println("파일삭제 성공");
					System.out.println("uploadfile no : " + uploadFileList.get(i).getUploadFileNo());
					UploadFileLocalServiceUtil.deleteUploadFile(uploadFileList.get(i).getUploadFileNo());
				}else{
					System.out.println("파일삭제 실패");
				}
			}else{
				System.out.println("파일이 존재하지 않습니다.");
			}
		}
		
		// boardNo에 맞는 댓글 리스트 가져오기
		List<Reply> replyList = ReplyLocalServiceUtil.getReplyList(boardNo);
		// for문 돌려가면서 DB에 댓글 삭제한다.
		for(int i=0; i<replyList.size(); i++) {
			ReplyLocalServiceUtil.deleteReply(replyList.get(i).getReplyNo());
		}
		
		// boardNo에 해당하는 게시 글 지운다.
		boardPersistence.remove(boardNo);
	}
	
}