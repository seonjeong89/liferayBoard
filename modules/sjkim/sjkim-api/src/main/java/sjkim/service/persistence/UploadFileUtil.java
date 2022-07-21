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

package sjkim.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import sjkim.model.UploadFile;

/**
 * The persistence utility for the upload file service. This utility wraps <code>sjkim.service.persistence.impl.UploadFilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UploadFilePersistence
 * @generated
 */
public class UploadFileUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(UploadFile uploadFile) {
		getPersistence().clearCache(uploadFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, UploadFile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UploadFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UploadFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UploadFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UploadFile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UploadFile update(UploadFile uploadFile) {
		return getPersistence().update(uploadFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UploadFile update(
		UploadFile uploadFile, ServiceContext serviceContext) {

		return getPersistence().update(uploadFile, serviceContext);
	}

	/**
	 * Returns all the upload files where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @return the matching upload files
	 */
	public static List<UploadFile> findByuploadFileName(String uploadFileName) {
		return getPersistence().findByuploadFileName(uploadFileName);
	}

	/**
	 * Returns a range of all the upload files where uploadFileName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UploadFileModelImpl</code>.
	 * </p>
	 *
	 * @param uploadFileName the upload file name
	 * @param start the lower bound of the range of upload files
	 * @param end the upper bound of the range of upload files (not inclusive)
	 * @return the range of matching upload files
	 */
	public static List<UploadFile> findByuploadFileName(
		String uploadFileName, int start, int end) {

		return getPersistence().findByuploadFileName(
			uploadFileName, start, end);
	}

	/**
	 * Returns an ordered range of all the upload files where uploadFileName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UploadFileModelImpl</code>.
	 * </p>
	 *
	 * @param uploadFileName the upload file name
	 * @param start the lower bound of the range of upload files
	 * @param end the upper bound of the range of upload files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upload files
	 */
	public static List<UploadFile> findByuploadFileName(
		String uploadFileName, int start, int end,
		OrderByComparator<UploadFile> orderByComparator) {

		return getPersistence().findByuploadFileName(
			uploadFileName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the upload files where uploadFileName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UploadFileModelImpl</code>.
	 * </p>
	 *
	 * @param uploadFileName the upload file name
	 * @param start the lower bound of the range of upload files
	 * @param end the upper bound of the range of upload files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching upload files
	 */
	public static List<UploadFile> findByuploadFileName(
		String uploadFileName, int start, int end,
		OrderByComparator<UploadFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuploadFileName(
			uploadFileName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first upload file in the ordered set where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upload file
	 * @throws NoSuchUploadFileException if a matching upload file could not be found
	 */
	public static UploadFile findByuploadFileName_First(
			String uploadFileName,
			OrderByComparator<UploadFile> orderByComparator)
		throws sjkim.exception.NoSuchUploadFileException {

		return getPersistence().findByuploadFileName_First(
			uploadFileName, orderByComparator);
	}

	/**
	 * Returns the first upload file in the ordered set where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upload file, or <code>null</code> if a matching upload file could not be found
	 */
	public static UploadFile fetchByuploadFileName_First(
		String uploadFileName,
		OrderByComparator<UploadFile> orderByComparator) {

		return getPersistence().fetchByuploadFileName_First(
			uploadFileName, orderByComparator);
	}

	/**
	 * Returns the last upload file in the ordered set where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upload file
	 * @throws NoSuchUploadFileException if a matching upload file could not be found
	 */
	public static UploadFile findByuploadFileName_Last(
			String uploadFileName,
			OrderByComparator<UploadFile> orderByComparator)
		throws sjkim.exception.NoSuchUploadFileException {

		return getPersistence().findByuploadFileName_Last(
			uploadFileName, orderByComparator);
	}

	/**
	 * Returns the last upload file in the ordered set where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upload file, or <code>null</code> if a matching upload file could not be found
	 */
	public static UploadFile fetchByuploadFileName_Last(
		String uploadFileName,
		OrderByComparator<UploadFile> orderByComparator) {

		return getPersistence().fetchByuploadFileName_Last(
			uploadFileName, orderByComparator);
	}

	/**
	 * Returns the upload files before and after the current upload file in the ordered set where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileNo the primary key of the current upload file
	 * @param uploadFileName the upload file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upload file
	 * @throws NoSuchUploadFileException if a upload file with the primary key could not be found
	 */
	public static UploadFile[] findByuploadFileName_PrevAndNext(
			long uploadFileNo, String uploadFileName,
			OrderByComparator<UploadFile> orderByComparator)
		throws sjkim.exception.NoSuchUploadFileException {

		return getPersistence().findByuploadFileName_PrevAndNext(
			uploadFileNo, uploadFileName, orderByComparator);
	}

	/**
	 * Removes all the upload files where uploadFileName LIKE &#63; from the database.
	 *
	 * @param uploadFileName the upload file name
	 */
	public static void removeByuploadFileName(String uploadFileName) {
		getPersistence().removeByuploadFileName(uploadFileName);
	}

	/**
	 * Returns the number of upload files where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @return the number of matching upload files
	 */
	public static int countByuploadFileName(String uploadFileName) {
		return getPersistence().countByuploadFileName(uploadFileName);
	}

	/**
	 * Returns all the upload files where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @return the matching upload files
	 */
	public static List<UploadFile> findByuploadFileBoardNo(
		long uploadFileBoardNo) {

		return getPersistence().findByuploadFileBoardNo(uploadFileBoardNo);
	}

	/**
	 * Returns a range of all the upload files where uploadFileBoardNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UploadFileModelImpl</code>.
	 * </p>
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param start the lower bound of the range of upload files
	 * @param end the upper bound of the range of upload files (not inclusive)
	 * @return the range of matching upload files
	 */
	public static List<UploadFile> findByuploadFileBoardNo(
		long uploadFileBoardNo, int start, int end) {

		return getPersistence().findByuploadFileBoardNo(
			uploadFileBoardNo, start, end);
	}

	/**
	 * Returns an ordered range of all the upload files where uploadFileBoardNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UploadFileModelImpl</code>.
	 * </p>
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param start the lower bound of the range of upload files
	 * @param end the upper bound of the range of upload files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upload files
	 */
	public static List<UploadFile> findByuploadFileBoardNo(
		long uploadFileBoardNo, int start, int end,
		OrderByComparator<UploadFile> orderByComparator) {

		return getPersistence().findByuploadFileBoardNo(
			uploadFileBoardNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the upload files where uploadFileBoardNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UploadFileModelImpl</code>.
	 * </p>
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param start the lower bound of the range of upload files
	 * @param end the upper bound of the range of upload files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching upload files
	 */
	public static List<UploadFile> findByuploadFileBoardNo(
		long uploadFileBoardNo, int start, int end,
		OrderByComparator<UploadFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuploadFileBoardNo(
			uploadFileBoardNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first upload file in the ordered set where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upload file
	 * @throws NoSuchUploadFileException if a matching upload file could not be found
	 */
	public static UploadFile findByuploadFileBoardNo_First(
			long uploadFileBoardNo,
			OrderByComparator<UploadFile> orderByComparator)
		throws sjkim.exception.NoSuchUploadFileException {

		return getPersistence().findByuploadFileBoardNo_First(
			uploadFileBoardNo, orderByComparator);
	}

	/**
	 * Returns the first upload file in the ordered set where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upload file, or <code>null</code> if a matching upload file could not be found
	 */
	public static UploadFile fetchByuploadFileBoardNo_First(
		long uploadFileBoardNo,
		OrderByComparator<UploadFile> orderByComparator) {

		return getPersistence().fetchByuploadFileBoardNo_First(
			uploadFileBoardNo, orderByComparator);
	}

	/**
	 * Returns the last upload file in the ordered set where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upload file
	 * @throws NoSuchUploadFileException if a matching upload file could not be found
	 */
	public static UploadFile findByuploadFileBoardNo_Last(
			long uploadFileBoardNo,
			OrderByComparator<UploadFile> orderByComparator)
		throws sjkim.exception.NoSuchUploadFileException {

		return getPersistence().findByuploadFileBoardNo_Last(
			uploadFileBoardNo, orderByComparator);
	}

	/**
	 * Returns the last upload file in the ordered set where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upload file, or <code>null</code> if a matching upload file could not be found
	 */
	public static UploadFile fetchByuploadFileBoardNo_Last(
		long uploadFileBoardNo,
		OrderByComparator<UploadFile> orderByComparator) {

		return getPersistence().fetchByuploadFileBoardNo_Last(
			uploadFileBoardNo, orderByComparator);
	}

	/**
	 * Returns the upload files before and after the current upload file in the ordered set where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileNo the primary key of the current upload file
	 * @param uploadFileBoardNo the upload file board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upload file
	 * @throws NoSuchUploadFileException if a upload file with the primary key could not be found
	 */
	public static UploadFile[] findByuploadFileBoardNo_PrevAndNext(
			long uploadFileNo, long uploadFileBoardNo,
			OrderByComparator<UploadFile> orderByComparator)
		throws sjkim.exception.NoSuchUploadFileException {

		return getPersistence().findByuploadFileBoardNo_PrevAndNext(
			uploadFileNo, uploadFileBoardNo, orderByComparator);
	}

	/**
	 * Removes all the upload files where uploadFileBoardNo = &#63; from the database.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 */
	public static void removeByuploadFileBoardNo(long uploadFileBoardNo) {
		getPersistence().removeByuploadFileBoardNo(uploadFileBoardNo);
	}

	/**
	 * Returns the number of upload files where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @return the number of matching upload files
	 */
	public static int countByuploadFileBoardNo(long uploadFileBoardNo) {
		return getPersistence().countByuploadFileBoardNo(uploadFileBoardNo);
	}

	/**
	 * Caches the upload file in the entity cache if it is enabled.
	 *
	 * @param uploadFile the upload file
	 */
	public static void cacheResult(UploadFile uploadFile) {
		getPersistence().cacheResult(uploadFile);
	}

	/**
	 * Caches the upload files in the entity cache if it is enabled.
	 *
	 * @param uploadFiles the upload files
	 */
	public static void cacheResult(List<UploadFile> uploadFiles) {
		getPersistence().cacheResult(uploadFiles);
	}

	/**
	 * Creates a new upload file with the primary key. Does not add the upload file to the database.
	 *
	 * @param uploadFileNo the primary key for the new upload file
	 * @return the new upload file
	 */
	public static UploadFile create(long uploadFileNo) {
		return getPersistence().create(uploadFileNo);
	}

	/**
	 * Removes the upload file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uploadFileNo the primary key of the upload file
	 * @return the upload file that was removed
	 * @throws NoSuchUploadFileException if a upload file with the primary key could not be found
	 */
	public static UploadFile remove(long uploadFileNo)
		throws sjkim.exception.NoSuchUploadFileException {

		return getPersistence().remove(uploadFileNo);
	}

	public static UploadFile updateImpl(UploadFile uploadFile) {
		return getPersistence().updateImpl(uploadFile);
	}

	/**
	 * Returns the upload file with the primary key or throws a <code>NoSuchUploadFileException</code> if it could not be found.
	 *
	 * @param uploadFileNo the primary key of the upload file
	 * @return the upload file
	 * @throws NoSuchUploadFileException if a upload file with the primary key could not be found
	 */
	public static UploadFile findByPrimaryKey(long uploadFileNo)
		throws sjkim.exception.NoSuchUploadFileException {

		return getPersistence().findByPrimaryKey(uploadFileNo);
	}

	/**
	 * Returns the upload file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uploadFileNo the primary key of the upload file
	 * @return the upload file, or <code>null</code> if a upload file with the primary key could not be found
	 */
	public static UploadFile fetchByPrimaryKey(long uploadFileNo) {
		return getPersistence().fetchByPrimaryKey(uploadFileNo);
	}

	/**
	 * Returns all the upload files.
	 *
	 * @return the upload files
	 */
	public static List<UploadFile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the upload files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UploadFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upload files
	 * @param end the upper bound of the range of upload files (not inclusive)
	 * @return the range of upload files
	 */
	public static List<UploadFile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the upload files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UploadFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upload files
	 * @param end the upper bound of the range of upload files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of upload files
	 */
	public static List<UploadFile> findAll(
		int start, int end, OrderByComparator<UploadFile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the upload files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UploadFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upload files
	 * @param end the upper bound of the range of upload files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of upload files
	 */
	public static List<UploadFile> findAll(
		int start, int end, OrderByComparator<UploadFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the upload files from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of upload files.
	 *
	 * @return the number of upload files
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UploadFilePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UploadFilePersistence, UploadFilePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UploadFilePersistence.class);

		ServiceTracker<UploadFilePersistence, UploadFilePersistence>
			serviceTracker =
				new ServiceTracker
					<UploadFilePersistence, UploadFilePersistence>(
						bundle.getBundleContext(), UploadFilePersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}