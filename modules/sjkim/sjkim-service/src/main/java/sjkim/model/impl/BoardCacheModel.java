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

package sjkim.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import sjkim.model.Board;

/**
 * The cache model class for representing Board in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BoardCacheModel implements CacheModel<Board>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BoardCacheModel)) {
			return false;
		}

		BoardCacheModel boardCacheModel = (BoardCacheModel)object;

		if (boardNo == boardCacheModel.boardNo) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, boardNo);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{boardNo=");
		sb.append(boardNo);
		sb.append(", boardTitle=");
		sb.append(boardTitle);
		sb.append(", boardContent=");
		sb.append(boardContent);
		sb.append(", boardWriter=");
		sb.append(boardWriter);
		sb.append(", boardWriteDate=");
		sb.append(boardWriteDate);
		sb.append(", boardUpdateDate=");
		sb.append(boardUpdateDate);
		sb.append(", boardViewCount=");
		sb.append(boardViewCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Board toEntityModel() {
		BoardImpl boardImpl = new BoardImpl();

		boardImpl.setBoardNo(boardNo);

		if (boardTitle == null) {
			boardImpl.setBoardTitle("");
		}
		else {
			boardImpl.setBoardTitle(boardTitle);
		}

		if (boardContent == null) {
			boardImpl.setBoardContent("");
		}
		else {
			boardImpl.setBoardContent(boardContent);
		}

		if (boardWriter == null) {
			boardImpl.setBoardWriter("");
		}
		else {
			boardImpl.setBoardWriter(boardWriter);
		}

		if (boardWriteDate == Long.MIN_VALUE) {
			boardImpl.setBoardWriteDate(null);
		}
		else {
			boardImpl.setBoardWriteDate(new Date(boardWriteDate));
		}

		if (boardUpdateDate == Long.MIN_VALUE) {
			boardImpl.setBoardUpdateDate(null);
		}
		else {
			boardImpl.setBoardUpdateDate(new Date(boardUpdateDate));
		}

		boardImpl.setBoardViewCount(boardViewCount);

		boardImpl.resetOriginalValues();

		return boardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		boardNo = objectInput.readLong();
		boardTitle = objectInput.readUTF();
		boardContent = objectInput.readUTF();
		boardWriter = objectInput.readUTF();
		boardWriteDate = objectInput.readLong();
		boardUpdateDate = objectInput.readLong();

		boardViewCount = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(boardNo);

		if (boardTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(boardTitle);
		}

		if (boardContent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(boardContent);
		}

		if (boardWriter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(boardWriter);
		}

		objectOutput.writeLong(boardWriteDate);
		objectOutput.writeLong(boardUpdateDate);

		objectOutput.writeLong(boardViewCount);
	}

	public long boardNo;
	public String boardTitle;
	public String boardContent;
	public String boardWriter;
	public long boardWriteDate;
	public long boardUpdateDate;
	public long boardViewCount;

}