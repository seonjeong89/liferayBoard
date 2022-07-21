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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import sjkim.model.Reply;
import sjkim.service.ReplyLocalServiceUtil;
import sjkim.service.base.ReplyLocalServiceBaseImpl;

/**
 * The implementation of the reply local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>sjkim.service.ReplyLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReplyLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=sjkim.model.Reply", service = AopService.class
)
public class ReplyLocalServiceImpl extends ReplyLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>sjkim.service.ReplyLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>sjkim.service.ReplyLocalServiceUtil</code>.
	 */
	
	// 댓글 등록 메소드
	public Reply insertReply(String replyContent, Long boardNo, String replyWriter) {
		
		// 시퀀스 부여
		long insertSeq = CounterLocalServiceUtil.increment(Reply.class.getName());
		Reply reply = ReplyLocalServiceUtil.createReply(insertSeq);
		
		// 오늘 날짜 받기
		Date now = new Date();
		
		// 파라미터 받아서 set으로 추가
		reply.setReplyContent(replyContent);
		reply.setReplyContentBackUp(replyContent);
		reply.setReplyWriteDate(now);
		reply.setReplyUpdateDate(now);
		reply.setReplyLevel((long) 1);
		reply.setBoardNo(boardNo);
		reply.setReplyWriter(replyWriter);
		reply.setReplyDeleteYN("N");
		System.out.println("insert complete");
		return replyPersistence.update(reply);
	}
	
	// 댓글 리스트 출력 메소드(boardNo를 가진 모든 댓글)
	public List<Reply> getReplyList(long boardNo) {
		List<Reply> replyList = replyPersistence.findByboardNo(boardNo);
		
		return replyList;
	}
	
	// 댓글 리스트 출력 메소드(대댓글 제외 출력)
	public List<Reply> listReply(Long boardNo, Long replyLevel, int startNum) {
		int start = startNum;
		int end = startNum + 10;
		
		List<Reply> replyList = replyPersistence.findByreplyLevelList(boardNo, replyLevel, start, end);
		
		return replyList;
	}
	
	// 댓글 수정 메소드
	public Reply updateReply(Long replyNo, String replyContent) {
		Reply reply = null;
		try {
			// 리플 정보를 가져온다.
			reply = ReplyLocalServiceUtil.getReply(replyNo);
			// 오늘 날짜 받기
			Date now = new Date();
			
			// 업데이트 정보를 set 해준다.
			reply.setReplyContent(replyContent);
			reply.setReplyUpdateDate(now);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return replyPersistence.update(reply);
	}
	
	// 대댓글 리스트 출력 메소드
	public List<Reply> listReReply(Long boardNo, Long replyLevel) {
		
		List<Reply> replyList = replyPersistence.findByreplyLevelList(boardNo, replyLevel);
		List<Reply> replyListReverse = new ArrayList<Reply>();
		replyListReverse.addAll(replyList);
		
		Collections.reverse(replyListReverse);
		
		return replyListReverse;
	}
	
	// 대댓글 등록 메소드
	public Reply insertReReply(String replyContent, Long boardNo, Long replyNo, String replyWriter) {
		
		// 시퀀스 부여
		long insertSeq = CounterLocalServiceUtil.increment(Reply.class.getName());
		Reply reply = ReplyLocalServiceUtil.createReply(insertSeq);
		
		// 오늘 날짜 받기
		Date now = new Date();
		
		// 파라미터 받아서 set으로 추가
		reply.setReplyContent(replyContent);
		reply.setReplyContentBackUp(replyContent);
		reply.setReplyWriteDate(now);
		reply.setReplyUpdateDate(now);
		reply.setReplyLevel((long) 2);
		reply.setReplyParentReplyNo(replyNo);
		reply.setBoardNo(boardNo);
		reply.setReplyWriter(replyWriter);
		reply.setReplyDeleteYN("N");
		System.out.println("insert complete");
		return replyPersistence.update(reply);
	}
	
	// 댓글 대댓글 삭제 메소드(메시지와 상태 업데이트)
	public Reply deleteReply(Long replyNo, String replyContent) {
		Reply reply = null;
		try {
			// 리플 정보를 가져온다.
			reply = ReplyLocalServiceUtil.getReply(replyNo);
			// 오늘 날짜 받기
			Date now = new Date();
			
			// 업데이트 정보를 set 해준다.
			reply.setReplyContent(replyContent);
			reply.setReplyUpdateDate(now);
			reply.setReplyDeleteYN("Y");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return replyPersistence.update(reply);
	}
}