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

import sjkim.model.UploadFile;

import sjkim.service.UploadFileLocalServiceUtil;

/**
 * The extended model base implementation for the UploadFile service. Represents a row in the &quot;SJKIM_UploadFile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UploadFileImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UploadFileImpl
 * @see UploadFile
 * @generated
 */
public abstract class UploadFileBaseImpl
	extends UploadFileModelImpl implements UploadFile {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a upload file model instance should use the <code>UploadFile</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			UploadFileLocalServiceUtil.addUploadFile(this);
		}
		else {
			UploadFileLocalServiceUtil.updateUploadFile(this);
		}
	}

}