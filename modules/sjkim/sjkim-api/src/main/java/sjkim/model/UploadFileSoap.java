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
 * This class is used by SOAP remote services, specifically {@link sjkim.service.http.UploadFileServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UploadFileSoap implements Serializable {

	public static UploadFileSoap toSoapModel(UploadFile model) {
		UploadFileSoap soapModel = new UploadFileSoap();

		soapModel.setUploadFileNo(model.getUploadFileNo());
		soapModel.setUploadFileBoardNo(model.getUploadFileBoardNo());
		soapModel.setUploadFileName(model.getUploadFileName());
		soapModel.setUploadRealFileName(model.getUploadRealFileName());
		soapModel.setUploadFileUploadPath(model.getUploadFileUploadPath());
		soapModel.setUploadFileMimeType(model.getUploadFileMimeType());
		soapModel.setUploadFileWriter(model.getUploadFileWriter());
		soapModel.setUploadFileWriteDate(model.getUploadFileWriteDate());
		soapModel.setUploadFileUpdateDate(model.getUploadFileUpdateDate());

		return soapModel;
	}

	public static UploadFileSoap[] toSoapModels(UploadFile[] models) {
		UploadFileSoap[] soapModels = new UploadFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UploadFileSoap[][] toSoapModels(UploadFile[][] models) {
		UploadFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UploadFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UploadFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UploadFileSoap[] toSoapModels(List<UploadFile> models) {
		List<UploadFileSoap> soapModels = new ArrayList<UploadFileSoap>(
			models.size());

		for (UploadFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UploadFileSoap[soapModels.size()]);
	}

	public UploadFileSoap() {
	}

	public long getPrimaryKey() {
		return _uploadFileNo;
	}

	public void setPrimaryKey(long pk) {
		setUploadFileNo(pk);
	}

	public long getUploadFileNo() {
		return _uploadFileNo;
	}

	public void setUploadFileNo(long uploadFileNo) {
		_uploadFileNo = uploadFileNo;
	}

	public long getUploadFileBoardNo() {
		return _uploadFileBoardNo;
	}

	public void setUploadFileBoardNo(long uploadFileBoardNo) {
		_uploadFileBoardNo = uploadFileBoardNo;
	}

	public String getUploadFileName() {
		return _uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		_uploadFileName = uploadFileName;
	}

	public String getUploadRealFileName() {
		return _uploadRealFileName;
	}

	public void setUploadRealFileName(String uploadRealFileName) {
		_uploadRealFileName = uploadRealFileName;
	}

	public String getUploadFileUploadPath() {
		return _uploadFileUploadPath;
	}

	public void setUploadFileUploadPath(String uploadFileUploadPath) {
		_uploadFileUploadPath = uploadFileUploadPath;
	}

	public String getUploadFileMimeType() {
		return _uploadFileMimeType;
	}

	public void setUploadFileMimeType(String uploadFileMimeType) {
		_uploadFileMimeType = uploadFileMimeType;
	}

	public String getUploadFileWriter() {
		return _uploadFileWriter;
	}

	public void setUploadFileWriter(String uploadFileWriter) {
		_uploadFileWriter = uploadFileWriter;
	}

	public Date getUploadFileWriteDate() {
		return _uploadFileWriteDate;
	}

	public void setUploadFileWriteDate(Date uploadFileWriteDate) {
		_uploadFileWriteDate = uploadFileWriteDate;
	}

	public Date getUploadFileUpdateDate() {
		return _uploadFileUpdateDate;
	}

	public void setUploadFileUpdateDate(Date uploadFileUpdateDate) {
		_uploadFileUpdateDate = uploadFileUpdateDate;
	}

	private long _uploadFileNo;
	private long _uploadFileBoardNo;
	private String _uploadFileName;
	private String _uploadRealFileName;
	private String _uploadFileUploadPath;
	private String _uploadFileMimeType;
	private String _uploadFileWriter;
	private Date _uploadFileWriteDate;
	private Date _uploadFileUpdateDate;

}