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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link sjkim.service.http.ReplyServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReplySoap implements Serializable {

	public static ReplySoap toSoapModel(Reply model) {
		ReplySoap soapModel = new ReplySoap();

		soapModel.setReplyNo(model.getReplyNo());
		soapModel.setBoardNo(model.getBoardNo());
		soapModel.setReplyContent(model.getReplyContent());
		soapModel.setReplyContentBackUp(model.getReplyContentBackUp());
		soapModel.setReplyWriter(model.getReplyWriter());
		soapModel.setReplyParentReplyNo(model.getReplyParentReplyNo());
		soapModel.setReplyLevel(model.getReplyLevel());
		soapModel.setReplyWriteDate(model.getReplyWriteDate());
		soapModel.setReplyUpdateDate(model.getReplyUpdateDate());
		soapModel.setReplyDeleteYN(model.getReplyDeleteYN());

		return soapModel;
	}

	public static ReplySoap[] toSoapModels(Reply[] models) {
		ReplySoap[] soapModels = new ReplySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReplySoap[][] toSoapModels(Reply[][] models) {
		ReplySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ReplySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReplySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReplySoap[] toSoapModels(List<Reply> models) {
		List<ReplySoap> soapModels = new ArrayList<ReplySoap>(models.size());

		for (Reply model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReplySoap[soapModels.size()]);
	}

	public ReplySoap() {
	}

	public long getPrimaryKey() {
		return _replyNo;
	}

	public void setPrimaryKey(long pk) {
		setReplyNo(pk);
	}

	public long getReplyNo() {
		return _replyNo;
	}

	public void setReplyNo(long replyNo) {
		_replyNo = replyNo;
	}

	public long getBoardNo() {
		return _boardNo;
	}

	public void setBoardNo(long boardNo) {
		_boardNo = boardNo;
	}

	public String getReplyContent() {
		return _replyContent;
	}

	public void setReplyContent(String replyContent) {
		_replyContent = replyContent;
	}

	public String getReplyContentBackUp() {
		return _replyContentBackUp;
	}

	public void setReplyContentBackUp(String replyContentBackUp) {
		_replyContentBackUp = replyContentBackUp;
	}

	public String getReplyWriter() {
		return _replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		_replyWriter = replyWriter;
	}

	public Long getReplyParentReplyNo() {
		return _replyParentReplyNo;
	}

	public void setReplyParentReplyNo(Long replyParentReplyNo) {
		_replyParentReplyNo = replyParentReplyNo;
	}

	public Long getReplyLevel() {
		return _replyLevel;
	}

	public void setReplyLevel(Long replyLevel) {
		_replyLevel = replyLevel;
	}

	public Date getReplyWriteDate() {
		return _replyWriteDate;
	}

	public void setReplyWriteDate(Date replyWriteDate) {
		_replyWriteDate = replyWriteDate;
	}

	public Date getReplyUpdateDate() {
		return _replyUpdateDate;
	}

	public void setReplyUpdateDate(Date replyUpdateDate) {
		_replyUpdateDate = replyUpdateDate;
	}

	public String getReplyDeleteYN() {
		return _replyDeleteYN;
	}

	public void setReplyDeleteYN(String replyDeleteYN) {
		_replyDeleteYN = replyDeleteYN;
	}

	private long _replyNo;
	private long _boardNo;
	private String _replyContent;
	private String _replyContentBackUp;
	private String _replyWriter;
	private Long _replyParentReplyNo;
	private Long _replyLevel;
	private Date _replyWriteDate;
	private Date _replyUpdateDate;
	private String _replyDeleteYN;

}