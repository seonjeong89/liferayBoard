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
 * This class is used by SOAP remote services, specifically {@link sjkim.service.http.DataTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataTypeSoap implements Serializable {

	public static DataTypeSoap toSoapModel(DataType model) {
		DataTypeSoap soapModel = new DataTypeSoap();

		soapModel.setDataTypeNo(model.getDataTypeNo());
		soapModel.setDataTypeNV(model.getDataTypeNV());
		soapModel.setDataTypeName(model.getDataTypeName());
		soapModel.setDataTypeVersion(model.getDataTypeVersion());
		soapModel.setDataTypeDisplayName(model.getDataTypeDisplayName());
		soapModel.setDataTypeExplanation(model.getDataTypeExplanation());
		soapModel.setSampleFileName(model.getSampleFileName());
		soapModel.setSampleRealFileName(model.getSampleRealFileName());
		soapModel.setSampleFileUploadPath(model.getSampleFileUploadPath());
		soapModel.setSampleFileType(model.getSampleFileType());
		soapModel.setDataTypeWriter(model.getDataTypeWriter());
		soapModel.setDataTypeWriteDate(model.getDataTypeWriteDate());
		soapModel.setDataTypeUpdateDate(model.getDataTypeUpdateDate());
		soapModel.setDataTypeStructure(model.getDataTypeStructure());

		return soapModel;
	}

	public static DataTypeSoap[] toSoapModels(DataType[] models) {
		DataTypeSoap[] soapModels = new DataTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataTypeSoap[][] toSoapModels(DataType[][] models) {
		DataTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataTypeSoap[] toSoapModels(List<DataType> models) {
		List<DataTypeSoap> soapModels = new ArrayList<DataTypeSoap>(
			models.size());

		for (DataType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataTypeSoap[soapModels.size()]);
	}

	public DataTypeSoap() {
	}

	public long getPrimaryKey() {
		return _dataTypeNo;
	}

	public void setPrimaryKey(long pk) {
		setDataTypeNo(pk);
	}

	public long getDataTypeNo() {
		return _dataTypeNo;
	}

	public void setDataTypeNo(long dataTypeNo) {
		_dataTypeNo = dataTypeNo;
	}

	public String getDataTypeNV() {
		return _dataTypeNV;
	}

	public void setDataTypeNV(String dataTypeNV) {
		_dataTypeNV = dataTypeNV;
	}

	public String getDataTypeName() {
		return _dataTypeName;
	}

	public void setDataTypeName(String dataTypeName) {
		_dataTypeName = dataTypeName;
	}

	public String getDataTypeVersion() {
		return _dataTypeVersion;
	}

	public void setDataTypeVersion(String dataTypeVersion) {
		_dataTypeVersion = dataTypeVersion;
	}

	public String getDataTypeDisplayName() {
		return _dataTypeDisplayName;
	}

	public void setDataTypeDisplayName(String dataTypeDisplayName) {
		_dataTypeDisplayName = dataTypeDisplayName;
	}

	public String getDataTypeExplanation() {
		return _dataTypeExplanation;
	}

	public void setDataTypeExplanation(String dataTypeExplanation) {
		_dataTypeExplanation = dataTypeExplanation;
	}

	public String getSampleFileName() {
		return _sampleFileName;
	}

	public void setSampleFileName(String sampleFileName) {
		_sampleFileName = sampleFileName;
	}

	public String getSampleRealFileName() {
		return _sampleRealFileName;
	}

	public void setSampleRealFileName(String sampleRealFileName) {
		_sampleRealFileName = sampleRealFileName;
	}

	public String getSampleFileUploadPath() {
		return _sampleFileUploadPath;
	}

	public void setSampleFileUploadPath(String sampleFileUploadPath) {
		_sampleFileUploadPath = sampleFileUploadPath;
	}

	public String getSampleFileType() {
		return _sampleFileType;
	}

	public void setSampleFileType(String sampleFileType) {
		_sampleFileType = sampleFileType;
	}

	public String getDataTypeWriter() {
		return _dataTypeWriter;
	}

	public void setDataTypeWriter(String dataTypeWriter) {
		_dataTypeWriter = dataTypeWriter;
	}

	public Date getDataTypeWriteDate() {
		return _dataTypeWriteDate;
	}

	public void setDataTypeWriteDate(Date dataTypeWriteDate) {
		_dataTypeWriteDate = dataTypeWriteDate;
	}

	public Date getDataTypeUpdateDate() {
		return _dataTypeUpdateDate;
	}

	public void setDataTypeUpdateDate(Date dataTypeUpdateDate) {
		_dataTypeUpdateDate = dataTypeUpdateDate;
	}

	public String getDataTypeStructure() {
		return _dataTypeStructure;
	}

	public void setDataTypeStructure(String dataTypeStructure) {
		_dataTypeStructure = dataTypeStructure;
	}

	private long _dataTypeNo;
	private String _dataTypeNV;
	private String _dataTypeName;
	private String _dataTypeVersion;
	private String _dataTypeDisplayName;
	private String _dataTypeExplanation;
	private String _sampleFileName;
	private String _sampleRealFileName;
	private String _sampleFileUploadPath;
	private String _sampleFileType;
	private String _dataTypeWriter;
	private Date _dataTypeWriteDate;
	private Date _dataTypeUpdateDate;
	private String _dataTypeStructure;

}