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

import sjkim.model.Reply;

/**
 * The cache model class for representing Reply in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReplyCacheModel implements CacheModel<Reply>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ReplyCacheModel)) {
			return false;
		}

		ReplyCacheModel replyCacheModel = (ReplyCacheModel)object;

		if (replyNo == replyCacheModel.replyNo) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, replyNo);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{replyNo=");
		sb.append(replyNo);
		sb.append(", boardNo=");
		sb.append(boardNo);
		sb.append(", replyContent=");
		sb.append(replyContent);
		sb.append(", replyContentBackUp=");
		sb.append(replyContentBackUp);
		sb.append(", replyWriter=");
		sb.append(replyWriter);
		sb.append(", replyParentReplyNo=");
		sb.append(replyParentReplyNo);
		sb.append(", replyLevel=");
		sb.append(replyLevel);
		sb.append(", replyWriteDate=");
		sb.append(replyWriteDate);
		sb.append(", replyUpdateDate=");
		sb.append(replyUpdateDate);
		sb.append(", replyDeleteYN=");
		sb.append(replyDeleteYN);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Reply toEntityModel() {
		ReplyImpl replyImpl = new ReplyImpl();

		replyImpl.setReplyNo(replyNo);
		replyImpl.setBoardNo(boardNo);

		if (replyContent == null) {
			replyImpl.setReplyContent("");
		}
		else {
			replyImpl.setReplyContent(replyContent);
		}

		if (replyContentBackUp == null) {
			replyImpl.setReplyContentBackUp("");
		}
		else {
			replyImpl.setReplyContentBackUp(replyContentBackUp);
		}

		if (replyWriter == null) {
			replyImpl.setReplyWriter("");
		}
		else {
			replyImpl.setReplyWriter(replyWriter);
		}

		replyImpl.setReplyParentReplyNo(replyParentReplyNo);
		replyImpl.setReplyLevel(replyLevel);

		if (replyWriteDate == Long.MIN_VALUE) {
			replyImpl.setReplyWriteDate(null);
		}
		else {
			replyImpl.setReplyWriteDate(new Date(replyWriteDate));
		}

		if (replyUpdateDate == Long.MIN_VALUE) {
			replyImpl.setReplyUpdateDate(null);
		}
		else {
			replyImpl.setReplyUpdateDate(new Date(replyUpdateDate));
		}

		if (replyDeleteYN == null) {
			replyImpl.setReplyDeleteYN("");
		}
		else {
			replyImpl.setReplyDeleteYN(replyDeleteYN);
		}

		replyImpl.resetOriginalValues();

		return replyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		replyNo = objectInput.readLong();

		boardNo = objectInput.readLong();
		replyContent = objectInput.readUTF();
		replyContentBackUp = objectInput.readUTF();
		replyWriter = objectInput.readUTF();

		replyParentReplyNo = objectInput.readLong();

		replyLevel = objectInput.readLong();
		replyWriteDate = objectInput.readLong();
		replyUpdateDate = objectInput.readLong();
		replyDeleteYN = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(replyNo);

		objectOutput.writeLong(boardNo);

		if (replyContent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(replyContent);
		}

		if (replyContentBackUp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(replyContentBackUp);
		}

		if (replyWriter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(replyWriter);
		}

		objectOutput.writeLong(replyParentReplyNo);

		objectOutput.writeLong(replyLevel);
		objectOutput.writeLong(replyWriteDate);
		objectOutput.writeLong(replyUpdateDate);

		if (replyDeleteYN == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(replyDeleteYN);
		}
	}

	public long replyNo;
	public long boardNo;
	public String replyContent;
	public String replyContentBackUp;
	public String replyWriter;
	public long replyParentReplyNo;
	public long replyLevel;
	public long replyWriteDate;
	public long replyUpdateDate;
	public String replyDeleteYN;

}