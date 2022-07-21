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
 * This class is a wrapper for {@link UploadFile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UploadFile
 * @generated
 */
public class UploadFileWrapper
	extends BaseModelWrapper<UploadFile>
	implements ModelWrapper<UploadFile>, UploadFile {

	public UploadFileWrapper(UploadFile uploadFile) {
		super(uploadFile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uploadFileNo", getUploadFileNo());
		attributes.put("uploadFileBoardNo", getUploadFileBoardNo());
		attributes.put("uploadFileName", getUploadFileName());
		attributes.put("uploadRealFileName", getUploadRealFileName());
		attributes.put("uploadFileUploadPath", getUploadFileUploadPath());
		attributes.put("uploadFileMimeType", getUploadFileMimeType());
		attributes.put("uploadFileWriter", getUploadFileWriter());
		attributes.put("uploadFileWriteDate", getUploadFileWriteDate());
		attributes.put("uploadFileUpdateDate", getUploadFileUpdateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long uploadFileNo = (Long)attributes.get("uploadFileNo");

		if (uploadFileNo != null) {
			setUploadFileNo(uploadFileNo);
		}

		Long uploadFileBoardNo = (Long)attributes.get("uploadFileBoardNo");

		if (uploadFileBoardNo != null) {
			setUploadFileBoardNo(uploadFileBoardNo);
		}

		String uploadFileName = (String)attributes.get("uploadFileName");

		if (uploadFileName != null) {
			setUploadFileName(uploadFileName);
		}

		String uploadRealFileName = (String)attributes.get(
			"uploadRealFileName");

		if (uploadRealFileName != null) {
			setUploadRealFileName(uploadRealFileName);
		}

		String uploadFileUploadPath = (String)attributes.get(
			"uploadFileUploadPath");

		if (uploadFileUploadPath != null) {
			setUploadFileUploadPath(uploadFileUploadPath);
		}

		String uploadFileMimeType = (String)attributes.get(
			"uploadFileMimeType");

		if (uploadFileMimeType != null) {
			setUploadFileMimeType(uploadFileMimeType);
		}

		String uploadFileWriter = (String)attributes.get("uploadFileWriter");

		if (uploadFileWriter != null) {
			setUploadFileWriter(uploadFileWriter);
		}

		Date uploadFileWriteDate = (Date)attributes.get("uploadFileWriteDate");

		if (uploadFileWriteDate != null) {
			setUploadFileWriteDate(uploadFileWriteDate);
		}

		Date uploadFileUpdateDate = (Date)attributes.get(
			"uploadFileUpdateDate");

		if (uploadFileUpdateDate != null) {
			setUploadFileUpdateDate(uploadFileUpdateDate);
		}
	}

	/**
	 * Returns the primary key of this upload file.
	 *
	 * @return the primary key of this upload file
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the upload file board no of this upload file.
	 *
	 * @return the upload file board no of this upload file
	 */
	@Override
	public long getUploadFileBoardNo() {
		return model.getUploadFileBoardNo();
	}

	/**
	 * Returns the upload file mime type of this upload file.
	 *
	 * @return the upload file mime type of this upload file
	 */
	@Override
	public String getUploadFileMimeType() {
		return model.getUploadFileMimeType();
	}

	/**
	 * Returns the upload file name of this upload file.
	 *
	 * @return the upload file name of this upload file
	 */
	@Override
	public String getUploadFileName() {
		return model.getUploadFileName();
	}

	/**
	 * Returns the upload file no of this upload file.
	 *
	 * @return the upload file no of this upload file
	 */
	@Override
	public long getUploadFileNo() {
		return model.getUploadFileNo();
	}

	/**
	 * Returns the upload file update date of this upload file.
	 *
	 * @return the upload file update date of this upload file
	 */
	@Override
	public Date getUploadFileUpdateDate() {
		return model.getUploadFileUpdateDate();
	}

	/**
	 * Returns the upload file upload path of this upload file.
	 *
	 * @return the upload file upload path of this upload file
	 */
	@Override
	public String getUploadFileUploadPath() {
		return model.getUploadFileUploadPath();
	}

	/**
	 * Returns the upload file write date of this upload file.
	 *
	 * @return the upload file write date of this upload file
	 */
	@Override
	public Date getUploadFileWriteDate() {
		return model.getUploadFileWriteDate();
	}

	/**
	 * Returns the upload file writer of this upload file.
	 *
	 * @return the upload file writer of this upload file
	 */
	@Override
	public String getUploadFileWriter() {
		return model.getUploadFileWriter();
	}

	/**
	 * Returns the upload real file name of this upload file.
	 *
	 * @return the upload real file name of this upload file
	 */
	@Override
	public String getUploadRealFileName() {
		return model.getUploadRealFileName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this upload file.
	 *
	 * @param primaryKey the primary key of this upload file
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the upload file board no of this upload file.
	 *
	 * @param uploadFileBoardNo the upload file board no of this upload file
	 */
	@Override
	public void setUploadFileBoardNo(long uploadFileBoardNo) {
		model.setUploadFileBoardNo(uploadFileBoardNo);
	}

	/**
	 * Sets the upload file mime type of this upload file.
	 *
	 * @param uploadFileMimeType the upload file mime type of this upload file
	 */
	@Override
	public void setUploadFileMimeType(String uploadFileMimeType) {
		model.setUploadFileMimeType(uploadFileMimeType);
	}

	/**
	 * Sets the upload file name of this upload file.
	 *
	 * @param uploadFileName the upload file name of this upload file
	 */
	@Override
	public void setUploadFileName(String uploadFileName) {
		model.setUploadFileName(uploadFileName);
	}

	/**
	 * Sets the upload file no of this upload file.
	 *
	 * @param uploadFileNo the upload file no of this upload file
	 */
	@Override
	public void setUploadFileNo(long uploadFileNo) {
		model.setUploadFileNo(uploadFileNo);
	}

	/**
	 * Sets the upload file update date of this upload file.
	 *
	 * @param uploadFileUpdateDate the upload file update date of this upload file
	 */
	@Override
	public void setUploadFileUpdateDate(Date uploadFileUpdateDate) {
		model.setUploadFileUpdateDate(uploadFileUpdateDate);
	}

	/**
	 * Sets the upload file upload path of this upload file.
	 *
	 * @param uploadFileUploadPath the upload file upload path of this upload file
	 */
	@Override
	public void setUploadFileUploadPath(String uploadFileUploadPath) {
		model.setUploadFileUploadPath(uploadFileUploadPath);
	}

	/**
	 * Sets the upload file write date of this upload file.
	 *
	 * @param uploadFileWriteDate the upload file write date of this upload file
	 */
	@Override
	public void setUploadFileWriteDate(Date uploadFileWriteDate) {
		model.setUploadFileWriteDate(uploadFileWriteDate);
	}

	/**
	 * Sets the upload file writer of this upload file.
	 *
	 * @param uploadFileWriter the upload file writer of this upload file
	 */
	@Override
	public void setUploadFileWriter(String uploadFileWriter) {
		model.setUploadFileWriter(uploadFileWriter);
	}

	/**
	 * Sets the upload real file name of this upload file.
	 *
	 * @param uploadRealFileName the upload real file name of this upload file
	 */
	@Override
	public void setUploadRealFileName(String uploadRealFileName) {
		model.setUploadRealFileName(uploadRealFileName);
	}

	@Override
	protected UploadFileWrapper wrap(UploadFile uploadFile) {
		return new UploadFileWrapper(uploadFile);
	}

}