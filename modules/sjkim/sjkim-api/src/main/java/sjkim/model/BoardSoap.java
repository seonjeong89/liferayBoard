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
 * This class is used by SOAP remote services, specifically {@link sjkim.service.http.BoardServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BoardSoap implements Serializable {

	public static BoardSoap toSoapModel(Board model) {
		BoardSoap soapModel = new BoardSoap();

		soapModel.setBoardNo(model.getBoardNo());
		soapModel.setBoardTitle(model.getBoardTitle());
		soapModel.setBoardContent(model.getBoardContent());
		soapModel.setBoardWriter(model.getBoardWriter());
		soapModel.setBoardWriteDate(model.getBoardWriteDate());
		soapModel.setBoardUpdateDate(model.getBoardUpdateDate());
		soapModel.setBoardViewCount(model.getBoardViewCount());

		return soapModel;
	}

	public static BoardSoap[] toSoapModels(Board[] models) {
		BoardSoap[] soapModels = new BoardSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BoardSoap[][] toSoapModels(Board[][] models) {
		BoardSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BoardSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BoardSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BoardSoap[] toSoapModels(List<Board> models) {
		List<BoardSoap> soapModels = new ArrayList<BoardSoap>(models.size());

		for (Board model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BoardSoap[soapModels.size()]);
	}

	public BoardSoap() {
	}

	public long getPrimaryKey() {
		return _boardNo;
	}

	public void setPrimaryKey(long pk) {
		setBoardNo(pk);
	}

	public long getBoardNo() {
		return _boardNo;
	}

	public void setBoardNo(long boardNo) {
		_boardNo = boardNo;
	}

	public String getBoardTitle() {
		return _boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		_boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return _boardContent;
	}

	public void setBoardContent(String boardContent) {
		_boardContent = boardContent;
	}

	public String getBoardWriter() {
		return _boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		_boardWriter = boardWriter;
	}

	public Date getBoardWriteDate() {
		return _boardWriteDate;
	}

	public void setBoardWriteDate(Date boardWriteDate) {
		_boardWriteDate = boardWriteDate;
	}

	public Date getBoardUpdateDate() {
		return _boardUpdateDate;
	}

	public void setBoardUpdateDate(Date boardUpdateDate) {
		_boardUpdateDate = boardUpdateDate;
	}

	public Long getBoardViewCount() {
		return _boardViewCount;
	}

	public void setBoardViewCount(Long boardViewCount) {
		_boardViewCount = boardViewCount;
	}

	private long _boardNo;
	private String _boardTitle;
	private String _boardContent;
	private String _boardWriter;
	private Date _boardWriteDate;
	private Date _boardUpdateDate;
	private Long _boardViewCount;

}