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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import sjkim.exception.NoSuchUploadFileException;

import sjkim.model.UploadFile;

/**
 * The persistence interface for the upload file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UploadFileUtil
 * @generated
 */
@ProviderType
public interface UploadFilePersistence extends BasePersistence<UploadFile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UploadFileUtil} to access the upload file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the upload files where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @return the matching upload files
	 */
	public java.util.List<UploadFile> findByuploadFileName(
		String uploadFileName);

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
	public java.util.List<UploadFile> findByuploadFileName(
		String uploadFileName, int start, int end);

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
	public java.util.List<UploadFile> findByuploadFileName(
		String uploadFileName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
			orderByComparator);

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
	public java.util.List<UploadFile> findByuploadFileName(
		String uploadFileName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first upload file in the ordered set where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upload file
	 * @throws NoSuchUploadFileException if a matching upload file could not be found
	 */
	public UploadFile findByuploadFileName_First(
			String uploadFileName,
			com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
				orderByComparator)
		throws NoSuchUploadFileException;

	/**
	 * Returns the first upload file in the ordered set where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upload file, or <code>null</code> if a matching upload file could not be found
	 */
	public UploadFile fetchByuploadFileName_First(
		String uploadFileName,
		com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
			orderByComparator);

	/**
	 * Returns the last upload file in the ordered set where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upload file
	 * @throws NoSuchUploadFileException if a matching upload file could not be found
	 */
	public UploadFile findByuploadFileName_Last(
			String uploadFileName,
			com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
				orderByComparator)
		throws NoSuchUploadFileException;

	/**
	 * Returns the last upload file in the ordered set where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upload file, or <code>null</code> if a matching upload file could not be found
	 */
	public UploadFile fetchByuploadFileName_Last(
		String uploadFileName,
		com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
			orderByComparator);

	/**
	 * Returns the upload files before and after the current upload file in the ordered set where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileNo the primary key of the current upload file
	 * @param uploadFileName the upload file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upload file
	 * @throws NoSuchUploadFileException if a upload file with the primary key could not be found
	 */
	public UploadFile[] findByuploadFileName_PrevAndNext(
			long uploadFileNo, String uploadFileName,
			com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
				orderByComparator)
		throws NoSuchUploadFileException;

	/**
	 * Removes all the upload files where uploadFileName LIKE &#63; from the database.
	 *
	 * @param uploadFileName the upload file name
	 */
	public void removeByuploadFileName(String uploadFileName);

	/**
	 * Returns the number of upload files where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @return the number of matching upload files
	 */
	public int countByuploadFileName(String uploadFileName);

	/**
	 * Returns all the upload files where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @return the matching upload files
	 */
	public java.util.List<UploadFile> findByuploadFileBoardNo(
		long uploadFileBoardNo);

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
	public java.util.List<UploadFile> findByuploadFileBoardNo(
		long uploadFileBoardNo, int start, int end);

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
	public java.util.List<UploadFile> findByuploadFileBoardNo(
		long uploadFileBoardNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
			orderByComparator);

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
	public java.util.List<UploadFile> findByuploadFileBoardNo(
		long uploadFileBoardNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first upload file in the ordered set where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upload file
	 * @throws NoSuchUploadFileException if a matching upload file could not be found
	 */
	public UploadFile findByuploadFileBoardNo_First(
			long uploadFileBoardNo,
			com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
				orderByComparator)
		throws NoSuchUploadFileException;

	/**
	 * Returns the first upload file in the ordered set where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upload file, or <code>null</code> if a matching upload file could not be found
	 */
	public UploadFile fetchByuploadFileBoardNo_First(
		long uploadFileBoardNo,
		com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
			orderByComparator);

	/**
	 * Returns the last upload file in the ordered set where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upload file
	 * @throws NoSuchUploadFileException if a matching upload file could not be found
	 */
	public UploadFile findByuploadFileBoardNo_Last(
			long uploadFileBoardNo,
			com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
				orderByComparator)
		throws NoSuchUploadFileException;

	/**
	 * Returns the last upload file in the ordered set where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upload file, or <code>null</code> if a matching upload file could not be found
	 */
	public UploadFile fetchByuploadFileBoardNo_Last(
		long uploadFileBoardNo,
		com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
			orderByComparator);

	/**
	 * Returns the upload files before and after the current upload file in the ordered set where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileNo the primary key of the current upload file
	 * @param uploadFileBoardNo the upload file board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upload file
	 * @throws NoSuchUploadFileException if a upload file with the primary key could not be found
	 */
	public UploadFile[] findByuploadFileBoardNo_PrevAndNext(
			long uploadFileNo, long uploadFileBoardNo,
			com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
				orderByComparator)
		throws NoSuchUploadFileException;

	/**
	 * Removes all the upload files where uploadFileBoardNo = &#63; from the database.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 */
	public void removeByuploadFileBoardNo(long uploadFileBoardNo);

	/**
	 * Returns the number of upload files where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @return the number of matching upload files
	 */
	public int countByuploadFileBoardNo(long uploadFileBoardNo);

	/**
	 * Caches the upload file in the entity cache if it is enabled.
	 *
	 * @param uploadFile the upload file
	 */
	public void cacheResult(UploadFile uploadFile);

	/**
	 * Caches the upload files in the entity cache if it is enabled.
	 *
	 * @param uploadFiles the upload files
	 */
	public void cacheResult(java.util.List<UploadFile> uploadFiles);

	/**
	 * Creates a new upload file with the primary key. Does not add the upload file to the database.
	 *
	 * @param uploadFileNo the primary key for the new upload file
	 * @return the new upload file
	 */
	public UploadFile create(long uploadFileNo);

	/**
	 * Removes the upload file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uploadFileNo the primary key of the upload file
	 * @return the upload file that was removed
	 * @throws NoSuchUploadFileException if a upload file with the primary key could not be found
	 */
	public UploadFile remove(long uploadFileNo)
		throws NoSuchUploadFileException;

	public UploadFile updateImpl(UploadFile uploadFile);

	/**
	 * Returns the upload file with the primary key or throws a <code>NoSuchUploadFileException</code> if it could not be found.
	 *
	 * @param uploadFileNo the primary key of the upload file
	 * @return the upload file
	 * @throws NoSuchUploadFileException if a upload file with the primary key could not be found
	 */
	public UploadFile findByPrimaryKey(long uploadFileNo)
		throws NoSuchUploadFileException;

	/**
	 * Returns the upload file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uploadFileNo the primary key of the upload file
	 * @return the upload file, or <code>null</code> if a upload file with the primary key could not be found
	 */
	public UploadFile fetchByPrimaryKey(long uploadFileNo);

	/**
	 * Returns all the upload files.
	 *
	 * @return the upload files
	 */
	public java.util.List<UploadFile> findAll();

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
	public java.util.List<UploadFile> findAll(int start, int end);

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
	public java.util.List<UploadFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
			orderByComparator);

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
	public java.util.List<UploadFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UploadFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the upload files from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of upload files.
	 *
	 * @return the number of upload files
	 */
	public int countAll();

}