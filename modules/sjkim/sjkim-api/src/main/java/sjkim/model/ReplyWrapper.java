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

package sjkim.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Reply}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Reply
 * @generated
 */
public class ReplyWrapper
	extends BaseModelWrapper<Reply> implements ModelWrapper<Reply>, Reply {

	public ReplyWrapper(Reply reply) {
		super(reply);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("replyNo", getReplyNo());
		attributes.put("boardNo", getBoardNo());
		attributes.put("replyContent", getReplyContent());
		attributes.put("replyContentBackUp", getReplyContentBackUp());
		attributes.put("replyWriter", getReplyWriter());
		attributes.put("replyParentReplyNo", getReplyParentReplyNo());
		attributes.put("replyLevel", getReplyLevel());
		attributes.put("replyWriteDate", getReplyWriteDate());
		attributes.put("replyUpdateDate", getReplyUpdateDate());
		attributes.put("replyDeleteYN", getReplyDeleteYN());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long replyNo = (Long)attributes.get("replyNo");

		if (replyNo != null) {
			setReplyNo(replyNo);
		}

		Long boardNo = (Long)attributes.get("boardNo");

		if (boardNo != null) {
			setBoardNo(boardNo);
		}

		String replyContent = (String)attributes.get("replyContent");

		if (replyContent != null) {
			setReplyContent(replyContent);
		}

		String replyContentBackUp = (String)attributes.get(
			"replyContentBackUp");

		if (replyContentBackUp != null) {
			setReplyContentBackUp(replyContentBackUp);
		}

		String replyWriter = (String)attributes.get("replyWriter");

		if (replyWriter != null) {
			setReplyWriter(replyWriter);
		}

		Long replyParentReplyNo = (Long)attributes.get("replyParentReplyNo");

		if (replyParentReplyNo != null) {
			setReplyParentReplyNo(replyParentReplyNo);
		}

		Long replyLevel = (Long)attributes.get("replyLevel");

		if (replyLevel != null) {
			setReplyLevel(replyLevel);
		}

		Date replyWriteDate = (Date)attributes.get("replyWriteDate");

		if (replyWriteDate != null) {
			setReplyWriteDate(replyWriteDate);
		}

		Date replyUpdateDate = (Date)attributes.get("replyUpdateDate");

		if (replyUpdateDate != null) {
			setReplyUpdateDate(replyUpdateDate);
		}

		String replyDeleteYN = (String)attributes.get("replyDeleteYN");

		if (replyDeleteYN != null) {
			setReplyDeleteYN(replyDeleteYN);
		}
	}

	/**
	 * Returns the board no of this reply.
	 *
	 * @return the board no of this reply
	 */
	@Override
	public long getBoardNo() {
		return model.getBoardNo();
	}

	/**
	 * Returns the primary key of this reply.
	 *
	 * @return the primary key of this reply
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reply content of this reply.
	 *
	 * @return the reply content of this reply
	 */
	@Override
	public String getReplyContent() {
		return model.getReplyContent();
	}

	/**
	 * Returns the reply content back up of this reply.
	 *
	 * @return the reply content back up of this reply
	 */
	@Override
	public String getReplyContentBackUp() {
		return model.getReplyContentBackUp();
	}

	/**
	 * Returns the reply delete yn of this reply.
	 *
	 * @return the reply delete yn of this reply
	 */
	@Override
	public String getReplyDeleteYN() {
		return model.getReplyDeleteYN();
	}

	/**
	 * Returns the reply level of this reply.
	 *
	 * @return the reply level of this reply
	 */
	@Override
	public Long getReplyLevel() {
		return model.getReplyLevel();
	}

	/**
	 * Returns the reply no of this reply.
	 *
	 * @return the reply no of this reply
	 */
	@Override
	public long getReplyNo() {
		return model.getReplyNo();
	}

	/**
	 * Returns the reply parent reply no of this reply.
	 *
	 * @return the reply parent reply no of this reply
	 */
	@Override
	public Long getReplyParentReplyNo() {
		return model.getReplyParentReplyNo();
	}

	/**
	 * Returns the reply update date of this reply.
	 *
	 * @return the reply update date of this reply
	 */
	@Override
	public Date getReplyUpdateDate() {
		return model.getReplyUpdateDate();
	}

	/**
	 * Returns the reply write date of this reply.
	 *
	 * @return the reply write date of this reply
	 */
	@Override
	public Date getReplyWriteDate() {
		return model.getReplyWriteDate();
	}

	/**
	 * Returns the reply writer of this reply.
	 *
	 * @return the reply writer of this reply
	 */
	@Override
	public String getReplyWriter() {
		return model.getReplyWriter();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the board no of this reply.
	 *
	 * @param boardNo the board no of this reply
	 */
	@Override
	public void setBoardNo(long boardNo) {
		model.setBoardNo(boardNo);
	}

	/**
	 * Sets the primary key of this reply.
	 *
	 * @param primaryKey the primary key of this reply
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reply content of this reply.
	 *
	 * @param replyContent the reply content of this reply
	 */
	@Override
	public void setReplyContent(String replyContent) {
		model.setReplyContent(replyContent);
	}

	/**
	 * Sets the reply content back up of this reply.
	 *
	 * @param replyContentBackUp the reply content back up of this reply
	 */
	@Override
	public void setReplyContentBackUp(String replyContentBackUp) {
		model.setReplyContentBackUp(replyContentBackUp);
	}

	/**
	 * Sets the reply delete yn of this reply.
	 *
	 * @param replyDeleteYN the reply delete yn of this reply
	 */
	@Override
	public void setReplyDeleteYN(String replyDeleteYN) {
		model.setReplyDeleteYN(replyDeleteYN);
	}

	/**
	 * Sets the reply level of this reply.
	 *
	 * @param replyLevel the reply level of this reply
	 */
	@Override
	public void setReplyLevel(Long replyLevel) {
		model.setReplyLevel(replyLevel);
	}

	/**
	 * Sets the reply no of this reply.
	 *
	 * @param replyNo the reply no of this reply
	 */
	@Override
	public void setReplyNo(long replyNo) {
		model.setReplyNo(replyNo);
	}

	/**
	 * Sets the reply parent reply no of this reply.
	 *
	 * @param replyParentReplyNo the reply parent reply no of this reply
	 */
	@Override
	public void setReplyParentReplyNo(Long replyParentReplyNo) {
		model.setReplyParentReplyNo(replyParentReplyNo);
	}

	/**
	 * Sets the reply update date of this reply.
	 *
	 * @param replyUpdateDate the reply update date of this reply
	 */
	@Override
	public void setReplyUpdateDate(Date replyUpdateDate) {
		model.setReplyUpdateDate(replyUpdateDate);
	}

	/**
	 * Sets the reply write date of this reply.
	 *
	 * @param replyWriteDate the reply write date of this reply
	 */
	@Override
	public void setReplyWriteDate(Date replyWriteDate) {
		model.setReplyWriteDate(replyWriteDate);
	}

	/**
	 * Sets the reply writer of this reply.
	 *
	 * @param replyWriter the reply writer of this reply
	 */
	@Override
	public void setReplyWriter(String replyWriter) {
		model.setReplyWriter(replyWriter);
	}

	@Override
	protected ReplyWrapper wrap(Reply reply) {
		return new ReplyWrapper(reply);
	}

}