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

import sjkim.model.DataType;

/**
 * The cache model class for representing DataType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataTypeCacheModel
	implements CacheModel<DataType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataTypeCacheModel)) {
			return false;
		}

		DataTypeCacheModel dataTypeCacheModel = (DataTypeCacheModel)object;

		if (dataTypeNo == dataTypeCacheModel.dataTypeNo) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataTypeNo);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{dataTypeNo=");
		sb.append(dataTypeNo);
		sb.append(", dataTypeNV=");
		sb.append(dataTypeNV);
		sb.append(", dataTypeName=");
		sb.append(dataTypeName);
		sb.append(", dataTypeVersion=");
		sb.append(dataTypeVersion);
		sb.append(", dataTypeDisplayName=");
		sb.append(dataTypeDisplayName);
		sb.append(", dataTypeExplanation=");
		sb.append(dataTypeExplanation);
		sb.append(", sampleFileName=");
		sb.append(sampleFileName);
		sb.append(", sampleRealFileName=");
		sb.append(sampleRealFileName);
		sb.append(", sampleFileUploadPath=");
		sb.append(sampleFileUploadPath);
		sb.append(", sampleFileType=");
		sb.append(sampleFileType);
		sb.append(", dataTypeWriter=");
		sb.append(dataTypeWriter);
		sb.append(", dataTypeWriteDate=");
		sb.append(dataTypeWriteDate);
		sb.append(", dataTypeUpdateDate=");
		sb.append(dataTypeUpdateDate);
		sb.append(", dataTypeStructure=");
		sb.append(dataTypeStructure);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataType toEntityModel() {
		DataTypeImpl dataTypeImpl = new DataTypeImpl();

		dataTypeImpl.setDataTypeNo(dataTypeNo);

		if (dataTypeNV == null) {
			dataTypeImpl.setDataTypeNV("");
		}
		else {
			dataTypeImpl.setDataTypeNV(dataTypeNV);
		}

		if (dataTypeName == null) {
			dataTypeImpl.setDataTypeName("");
		}
		else {
			dataTypeImpl.setDataTypeName(dataTypeName);
		}

		if (dataTypeVersion == null) {
			dataTypeImpl.setDataTypeVersion("");
		}
		else {
			dataTypeImpl.setDataTypeVersion(dataTypeVersion);
		}

		if (dataTypeDisplayName == null) {
			dataTypeImpl.setDataTypeDisplayName("");
		}
		else {
			dataTypeImpl.setDataTypeDisplayName(dataTypeDisplayName);
		}

		if (dataTypeExplanation == null) {
			dataTypeImpl.setDataTypeExplanation("");
		}
		else {
			dataTypeImpl.setDataTypeExplanation(dataTypeExplanation);
		}

		if (sampleFileName == null) {
			dataTypeImpl.setSampleFileName("");
		}
		else {
			dataTypeImpl.setSampleFileName(sampleFileName);
		}

		if (sampleRealFileName == null) {
			dataTypeImpl.setSampleRealFileName("");
		}
		else {
			dataTypeImpl.setSampleRealFileName(sampleRealFileName);
		}

		if (sampleFileUploadPath == null) {
			dataTypeImpl.setSampleFileUploadPath("");
		}
		else {
			dataTypeImpl.setSampleFileUploadPath(sampleFileUploadPath);
		}

		if (sampleFileType == null) {
			dataTypeImpl.setSampleFileType("");
		}
		else {
			dataTypeImpl.setSampleFileType(sampleFileType);
		}

		if (dataTypeWriter == null) {
			dataTypeImpl.setDataTypeWriter("");
		}
		else {
			dataTypeImpl.setDataTypeWriter(dataTypeWriter);
		}

		if (dataTypeWriteDate == Long.MIN_VALUE) {
			dataTypeImpl.setDataTypeWriteDate(null);
		}
		else {
			dataTypeImpl.setDataTypeWriteDate(new Date(dataTypeWriteDate));
		}

		if (dataTypeUpdateDate == Long.MIN_VALUE) {
			dataTypeImpl.setDataTypeUpdateDate(null);
		}
		else {
			dataTypeImpl.setDataTypeUpdateDate(new Date(dataTypeUpdateDate));
		}

		if (dataTypeStructure == null) {
			dataTypeImpl.setDataTypeStructure("");
		}
		else {
			dataTypeImpl.setDataTypeStructure(dataTypeStructure);
		}

		dataTypeImpl.resetOriginalValues();

		return dataTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dataTypeNo = objectInput.readLong();
		dataTypeNV = objectInput.readUTF();
		dataTypeName = objectInput.readUTF();
		dataTypeVersion = objectInput.readUTF();
		dataTypeDisplayName = objectInput.readUTF();
		dataTypeExplanation = objectInput.readUTF();
		sampleFileName = objectInput.readUTF();
		sampleRealFileName = objectInput.readUTF();
		sampleFileUploadPath = objectInput.readUTF();
		sampleFileType = objectInput.readUTF();
		dataTypeWriter = objectInput.readUTF();
		dataTypeWriteDate = objectInput.readLong();
		dataTypeUpdateDate = objectInput.readLong();
		dataTypeStructure = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dataTypeNo);

		if (dataTypeNV == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataTypeNV);
		}

		if (dataTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataTypeName);
		}

		if (dataTypeVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataTypeVersion);
		}

		if (dataTypeDisplayName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataTypeDisplayName);
		}

		if (dataTypeExplanation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataTypeExplanation);
		}

		if (sampleFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sampleFileName);
		}

		if (sampleRealFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sampleRealFileName);
		}

		if (sampleFileUploadPath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sampleFileUploadPath);
		}

		if (sampleFileType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sampleFileType);
		}

		if (dataTypeWriter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataTypeWriter);
		}

		objectOutput.writeLong(dataTypeWriteDate);
		objectOutput.writeLong(dataTypeUpdateDate);

		if (dataTypeStructure == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataTypeStructure);
		}
	}

	public long dataTypeNo;
	public String dataTypeNV;
	public String dataTypeName;
	public String dataTypeVersion;
	public String dataTypeDisplayName;
	public String dataTypeExplanation;
	public String sampleFileName;
	public String sampleRealFileName;
	public String sampleFileUploadPath;
	public String sampleFileType;
	public String dataTypeWriter;
	public long dataTypeWriteDate;
	public long dataTypeUpdateDate;
	public String dataTypeStructure;

}