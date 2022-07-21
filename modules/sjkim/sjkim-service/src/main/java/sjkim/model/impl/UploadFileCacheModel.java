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

import sjkim.model.UploadFile;

/**
 * The cache model class for representing UploadFile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UploadFileCacheModel
	implements CacheModel<UploadFile>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UploadFileCacheModel)) {
			return false;
		}

		UploadFileCacheModel uploadFileCacheModel =
			(UploadFileCacheModel)object;

		if (uploadFileNo == uploadFileCacheModel.uploadFileNo) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, uploadFileNo);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uploadFileNo=");
		sb.append(uploadFileNo);
		sb.append(", uploadFileBoardNo=");
		sb.append(uploadFileBoardNo);
		sb.append(", uploadFileName=");
		sb.append(uploadFileName);
		sb.append(", uploadRealFileName=");
		sb.append(uploadRealFileName);
		sb.append(", uploadFileUploadPath=");
		sb.append(uploadFileUploadPath);
		sb.append(", uploadFileMimeType=");
		sb.append(uploadFileMimeType);
		sb.append(", uploadFileWriter=");
		sb.append(uploadFileWriter);
		sb.append(", uploadFileWriteDate=");
		sb.append(uploadFileWriteDate);
		sb.append(", uploadFileUpdateDate=");
		sb.append(uploadFileUpdateDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UploadFile toEntityModel() {
		UploadFileImpl uploadFileImpl = new UploadFileImpl();

		uploadFileImpl.setUploadFileNo(uploadFileNo);
		uploadFileImpl.setUploadFileBoardNo(uploadFileBoardNo);

		if (uploadFileName == null) {
			uploadFileImpl.setUploadFileName("");
		}
		else {
			uploadFileImpl.setUploadFileName(uploadFileName);
		}

		if (uploadRealFileName == null) {
			uploadFileImpl.setUploadRealFileName("");
		}
		else {
			uploadFileImpl.setUploadRealFileName(uploadRealFileName);
		}

		if (uploadFileUploadPath == null) {
			uploadFileImpl.setUploadFileUploadPath("");
		}
		else {
			uploadFileImpl.setUploadFileUploadPath(uploadFileUploadPath);
		}

		if (uploadFileMimeType == null) {
			uploadFileImpl.setUploadFileMimeType("");
		}
		else {
			uploadFileImpl.setUploadFileMimeType(uploadFileMimeType);
		}

		if (uploadFileWriter == null) {
			uploadFileImpl.setUploadFileWriter("");
		}
		else {
			uploadFileImpl.setUploadFileWriter(uploadFileWriter);
		}

		if (uploadFileWriteDate == Long.MIN_VALUE) {
			uploadFileImpl.setUploadFileWriteDate(null);
		}
		else {
			uploadFileImpl.setUploadFileWriteDate(
				new Date(uploadFileWriteDate));
		}

		if (uploadFileUpdateDate == Long.MIN_VALUE) {
			uploadFileImpl.setUploadFileUpdateDate(null);
		}
		else {
			uploadFileImpl.setUploadFileUpdateDate(
				new Date(uploadFileUpdateDate));
		}

		uploadFileImpl.resetOriginalValues();

		return uploadFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uploadFileNo = objectInput.readLong();

		uploadFileBoardNo = objectInput.readLong();
		uploadFileName = objectInput.readUTF();
		uploadRealFileName = objectInput.readUTF();
		uploadFileUploadPath = objectInput.readUTF();
		uploadFileMimeType = objectInput.readUTF();
		uploadFileWriter = objectInput.readUTF();
		uploadFileWriteDate = objectInput.readLong();
		uploadFileUpdateDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(uploadFileNo);

		objectOutput.writeLong(uploadFileBoardNo);

		if (uploadFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uploadFileName);
		}

		if (uploadRealFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uploadRealFileName);
		}

		if (uploadFileUploadPath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uploadFileUploadPath);
		}

		if (uploadFileMimeType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uploadFileMimeType);
		}

		if (uploadFileWriter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uploadFileWriter);
		}

		objectOutput.writeLong(uploadFileWriteDate);
		objectOutput.writeLong(uploadFileUpdateDate);
	}

	public long uploadFileNo;
	public long uploadFileBoardNo;
	public String uploadFileName;
	public String uploadRealFileName;
	public String uploadFileUploadPath;
	public String uploadFileMimeType;
	public String uploadFileWriter;
	public long uploadFileWriteDate;
	public long uploadFileUpdateDate;

}