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

package sjkim.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import sjkim.model.Board;
import sjkim.model.UploadFile;
import sjkim.service.BoardLocalServiceUtil;
import sjkim.service.UploadFileLocalServiceUtil;
import sjkim.service.base.UploadFileLocalServiceBaseImpl;
import sjkim.service.persistence.UploadFilePersistence;
import sjkim.service.persistence.impl.UploadFilePersistenceImpl;

/**
 * The implementation of the upload file local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>sjkim.service.UploadFileLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UploadFileLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=sjkim.model.UploadFile",
	service = AopService.class
)
public class UploadFileLocalServiceImpl extends UploadFileLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>sjkim.service.UploadFileLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>sjkim.service.UploadFileLocalServiceUtil</code>.
	 */
	
	// 파일 업로드 메소드
	public UploadFile uploadFiles(long boardNo, String Writer, String fileName, String uploadFileName, String contentType, String uploadPath) {
		
		// 시퀀스 부여
		long insertSeq = CounterLocalServiceUtil.increment(UploadFile.class.getName());
		UploadFile uploadFile = UploadFileLocalServiceUtil.createUploadFile(insertSeq); // UploadFile uploadFile = new UploadFile();
		
		// 오늘 날짜 받기
		Date now = new Date();
		
		// 파라미터 받아서 set으로 추가
		uploadFile.setUploadFileBoardNo(boardNo);
		uploadFile.setUploadFileWriter(Writer);
		uploadFile.setUploadFileName(uploadFileName);
		uploadFile.setUploadRealFileName(fileName);
		uploadFile.setUploadFileMimeType(contentType);
		uploadFile.setUploadFileWriteDate(now);
		uploadFile.setUploadFileUpdateDate(now);
		uploadFile.setUploadFileUploadPath(uploadPath);
		
		return uploadFilePersistence.update(uploadFile);
	}
	
	// 업로드 파일 리스트 출력 메소드
	public List<UploadFile> uploadFileList(long boardNo){
		
		List<UploadFile> uploadFileList = uploadFilePersistence.findByuploadFileBoardNo(boardNo);
		
		return uploadFileList;
	}
}