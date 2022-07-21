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
 * This class is a wrapper for {@link Board}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Board
 * @generated
 */
public class BoardWrapper
	extends BaseModelWrapper<Board> implements Board, ModelWrapper<Board> {

	public BoardWrapper(Board board) {
		super(board);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("boardNo", getBoardNo());
		attributes.put("boardTitle", getBoardTitle());
		attributes.put("boardContent", getBoardContent());
		attributes.put("boardWriter", getBoardWriter());
		attributes.put("boardWriteDate", getBoardWriteDate());
		attributes.put("boardUpdateDate", getBoardUpdateDate());
		attributes.put("boardViewCount", getBoardViewCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long boardNo = (Long)attributes.get("boardNo");

		if (boardNo != null) {
			setBoardNo(boardNo);
		}

		String boardTitle = (String)attributes.get("boardTitle");

		if (boardTitle != null) {
			setBoardTitle(boardTitle);
		}

		String boardContent = (String)attributes.get("boardContent");

		if (boardContent != null) {
			setBoardContent(boardContent);
		}

		String boardWriter = (String)attributes.get("boardWriter");

		if (boardWriter != null) {
			setBoardWriter(boardWriter);
		}

		Date boardWriteDate = (Date)attributes.get("boardWriteDate");

		if (boardWriteDate != null) {
			setBoardWriteDate(boardWriteDate);
		}

		Date boardUpdateDate = (Date)attributes.get("boardUpdateDate");

		if (boardUpdateDate != null) {
			setBoardUpdateDate(boardUpdateDate);
		}

		Long boardViewCount = (Long)attributes.get("boardViewCount");

		if (boardViewCount != null) {
			setBoardViewCount(boardViewCount);
		}
	}

	/**
	 * Returns the board content of this board.
	 *
	 * @return the board content of this board
	 */
	@Override
	public String getBoardContent() {
		return model.getBoardContent();
	}

	/**
	 * Returns the board no of this board.
	 *
	 * @return the board no of this board
	 */
	@Override
	public long getBoardNo() {
		return model.getBoardNo();
	}

	/**
	 * Returns the board title of this board.
	 *
	 * @return the board title of this board
	 */
	@Override
	public String getBoardTitle() {
		return model.getBoardTitle();
	}

	/**
	 * Returns the board update date of this board.
	 *
	 * @return the board update date of this board
	 */
	@Override
	public Date getBoardUpdateDate() {
		return model.getBoardUpdateDate();
	}

	/**
	 * Returns the board view count of this board.
	 *
	 * @return the board view count of this board
	 */
	@Override
	public Long getBoardViewCount() {
		return model.getBoardViewCount();
	}

	/**
	 * Returns the board write date of this board.
	 *
	 * @return the board write date of this board
	 */
	@Override
	public Date getBoardWriteDate() {
		return model.getBoardWriteDate();
	}

	/**
	 * Returns the board writer of this board.
	 *
	 * @return the board writer of this board
	 */
	@Override
	public String getBoardWriter() {
		return model.getBoardWriter();
	}

	/**
	 * Returns the primary key of this board.
	 *
	 * @return the primary key of this board
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the board content of this board.
	 *
	 * @param boardContent the board content of this board
	 */
	@Override
	public void setBoardContent(String boardContent) {
		model.setBoardContent(boardContent);
	}

	/**
	 * Sets the board no of this board.
	 *
	 * @param boardNo the board no of this board
	 */
	@Override
	public void setBoardNo(long boardNo) {
		model.setBoardNo(boardNo);
	}

	/**
	 * Sets the board title of this board.
	 *
	 * @param boardTitle the board title of this board
	 */
	@Override
	public void setBoardTitle(String boardTitle) {
		model.setBoardTitle(boardTitle);
	}

	/**
	 * Sets the board update date of this board.
	 *
	 * @param boardUpdateDate the board update date of this board
	 */
	@Override
	public void setBoardUpdateDate(Date boardUpdateDate) {
		model.setBoardUpdateDate(boardUpdateDate);
	}

	/**
	 * Sets the board view count of this board.
	 *
	 * @param boardViewCount the board view count of this board
	 */
	@Override
	public void setBoardViewCount(Long boardViewCount) {
		model.setBoardViewCount(boardViewCount);
	}

	/**
	 * Sets the board write date of this board.
	 *
	 * @param boardWriteDate the board write date of this board
	 */
	@Override
	public void setBoardWriteDate(Date boardWriteDate) {
		model.setBoardWriteDate(boardWriteDate);
	}

	/**
	 * Sets the board writer of this board.
	 *
	 * @param boardWriter the board writer of this board
	 */
	@Override
	public void setBoardWriter(String boardWriter) {
		model.setBoardWriter(boardWriter);
	}

	/**
	 * Sets the primary key of this board.
	 *
	 * @param primaryKey the primary key of this board
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected BoardWrapper wrap(Board board) {
		return new BoardWrapper(board);
	}

}