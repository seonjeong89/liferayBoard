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

package sjkim.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import sjkim.exception.NoSuchUploadFileException;

import sjkim.model.UploadFile;
import sjkim.model.impl.UploadFileImpl;
import sjkim.model.impl.UploadFileModelImpl;

import sjkim.service.persistence.UploadFilePersistence;
import sjkim.service.persistence.impl.constants.SJKIMPersistenceConstants;

/**
 * The persistence implementation for the upload file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UploadFilePersistence.class)
public class UploadFilePersistenceImpl
	extends BasePersistenceImpl<UploadFile> implements UploadFilePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UploadFileUtil</code> to access the upload file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UploadFileImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByuploadFileName;
	private FinderPath _finderPathWithPaginationCountByuploadFileName;

	/**
	 * Returns all the upload files where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @return the matching upload files
	 */
	@Override
	public List<UploadFile> findByuploadFileName(String uploadFileName) {
		return findByuploadFileName(
			uploadFileName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UploadFile> findByuploadFileName(
		String uploadFileName, int start, int end) {

		return findByuploadFileName(uploadFileName, start, end, null);
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
	@Override
	public List<UploadFile> findByuploadFileName(
		String uploadFileName, int start, int end,
		OrderByComparator<UploadFile> orderByComparator) {

		return findByuploadFileName(
			uploadFileName, start, end, orderByComparator, true);
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
	@Override
	public List<UploadFile> findByuploadFileName(
		String uploadFileName, int start, int end,
		OrderByComparator<UploadFile> orderByComparator,
		boolean useFinderCache) {

		uploadFileName = Objects.toString(uploadFileName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByuploadFileName;
		finderArgs = new Object[] {
			uploadFileName, start, end, orderByComparator
		};

		List<UploadFile> list = null;

		if (useFinderCache) {
			list = (List<UploadFile>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UploadFile uploadFile : list) {
					if (!StringUtil.wildcardMatches(
							uploadFile.getUploadFileName(), uploadFileName, '_',
							'%', '\\', true)) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_UPLOADFILE_WHERE);

			boolean bindUploadFileName = false;

			if (uploadFileName.isEmpty()) {
				sb.append(_FINDER_COLUMN_UPLOADFILENAME_UPLOADFILENAME_3);
			}
			else {
				bindUploadFileName = true;

				sb.append(_FINDER_COLUMN_UPLOADFILENAME_UPLOADFILENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UploadFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUploadFileName) {
					queryPos.add(uploadFileName);
				}

				list = (List<UploadFile>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first upload file in the ordered set where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upload file
	 * @throws NoSuchUploadFileException if a matching upload file could not be found
	 */
	@Override
	public UploadFile findByuploadFileName_First(
			String uploadFileName,
			OrderByComparator<UploadFile> orderByComparator)
		throws NoSuchUploadFileException {

		UploadFile uploadFile = fetchByuploadFileName_First(
			uploadFileName, orderByComparator);

		if (uploadFile != null) {
			return uploadFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uploadFileNameLIKE");
		sb.append(uploadFileName);

		sb.append("}");

		throw new NoSuchUploadFileException(sb.toString());
	}

	/**
	 * Returns the first upload file in the ordered set where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upload file, or <code>null</code> if a matching upload file could not be found
	 */
	@Override
	public UploadFile fetchByuploadFileName_First(
		String uploadFileName,
		OrderByComparator<UploadFile> orderByComparator) {

		List<UploadFile> list = findByuploadFileName(
			uploadFileName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last upload file in the ordered set where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upload file
	 * @throws NoSuchUploadFileException if a matching upload file could not be found
	 */
	@Override
	public UploadFile findByuploadFileName_Last(
			String uploadFileName,
			OrderByComparator<UploadFile> orderByComparator)
		throws NoSuchUploadFileException {

		UploadFile uploadFile = fetchByuploadFileName_Last(
			uploadFileName, orderByComparator);

		if (uploadFile != null) {
			return uploadFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uploadFileNameLIKE");
		sb.append(uploadFileName);

		sb.append("}");

		throw new NoSuchUploadFileException(sb.toString());
	}

	/**
	 * Returns the last upload file in the ordered set where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upload file, or <code>null</code> if a matching upload file could not be found
	 */
	@Override
	public UploadFile fetchByuploadFileName_Last(
		String uploadFileName,
		OrderByComparator<UploadFile> orderByComparator) {

		int count = countByuploadFileName(uploadFileName);

		if (count == 0) {
			return null;
		}

		List<UploadFile> list = findByuploadFileName(
			uploadFileName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UploadFile[] findByuploadFileName_PrevAndNext(
			long uploadFileNo, String uploadFileName,
			OrderByComparator<UploadFile> orderByComparator)
		throws NoSuchUploadFileException {

		uploadFileName = Objects.toString(uploadFileName, "");

		UploadFile uploadFile = findByPrimaryKey(uploadFileNo);

		Session session = null;

		try {
			session = openSession();

			UploadFile[] array = new UploadFileImpl[3];

			array[0] = getByuploadFileName_PrevAndNext(
				session, uploadFile, uploadFileName, orderByComparator, true);

			array[1] = uploadFile;

			array[2] = getByuploadFileName_PrevAndNext(
				session, uploadFile, uploadFileName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UploadFile getByuploadFileName_PrevAndNext(
		Session session, UploadFile uploadFile, String uploadFileName,
		OrderByComparator<UploadFile> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_UPLOADFILE_WHERE);

		boolean bindUploadFileName = false;

		if (uploadFileName.isEmpty()) {
			sb.append(_FINDER_COLUMN_UPLOADFILENAME_UPLOADFILENAME_3);
		}
		else {
			bindUploadFileName = true;

			sb.append(_FINDER_COLUMN_UPLOADFILENAME_UPLOADFILENAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UploadFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUploadFileName) {
			queryPos.add(uploadFileName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(uploadFile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UploadFile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the upload files where uploadFileName LIKE &#63; from the database.
	 *
	 * @param uploadFileName the upload file name
	 */
	@Override
	public void removeByuploadFileName(String uploadFileName) {
		for (UploadFile uploadFile :
				findByuploadFileName(
					uploadFileName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(uploadFile);
		}
	}

	/**
	 * Returns the number of upload files where uploadFileName LIKE &#63;.
	 *
	 * @param uploadFileName the upload file name
	 * @return the number of matching upload files
	 */
	@Override
	public int countByuploadFileName(String uploadFileName) {
		uploadFileName = Objects.toString(uploadFileName, "");

		FinderPath finderPath = _finderPathWithPaginationCountByuploadFileName;

		Object[] finderArgs = new Object[] {uploadFileName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_UPLOADFILE_WHERE);

			boolean bindUploadFileName = false;

			if (uploadFileName.isEmpty()) {
				sb.append(_FINDER_COLUMN_UPLOADFILENAME_UPLOADFILENAME_3);
			}
			else {
				bindUploadFileName = true;

				sb.append(_FINDER_COLUMN_UPLOADFILENAME_UPLOADFILENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUploadFileName) {
					queryPos.add(uploadFileName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UPLOADFILENAME_UPLOADFILENAME_2 =
		"uploadFile.uploadFileName LIKE ?";

	private static final String _FINDER_COLUMN_UPLOADFILENAME_UPLOADFILENAME_3 =
		"(uploadFile.uploadFileName IS NULL OR uploadFile.uploadFileName LIKE '')";

	private FinderPath _finderPathWithPaginationFindByuploadFileBoardNo;
	private FinderPath _finderPathWithoutPaginationFindByuploadFileBoardNo;
	private FinderPath _finderPathCountByuploadFileBoardNo;

	/**
	 * Returns all the upload files where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @return the matching upload files
	 */
	@Override
	public List<UploadFile> findByuploadFileBoardNo(long uploadFileBoardNo) {
		return findByuploadFileBoardNo(
			uploadFileBoardNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UploadFile> findByuploadFileBoardNo(
		long uploadFileBoardNo, int start, int end) {

		return findByuploadFileBoardNo(uploadFileBoardNo, start, end, null);
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
	@Override
	public List<UploadFile> findByuploadFileBoardNo(
		long uploadFileBoardNo, int start, int end,
		OrderByComparator<UploadFile> orderByComparator) {

		return findByuploadFileBoardNo(
			uploadFileBoardNo, start, end, orderByComparator, true);
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
	@Override
	public List<UploadFile> findByuploadFileBoardNo(
		long uploadFileBoardNo, int start, int end,
		OrderByComparator<UploadFile> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByuploadFileBoardNo;
				finderArgs = new Object[] {uploadFileBoardNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByuploadFileBoardNo;
			finderArgs = new Object[] {
				uploadFileBoardNo, start, end, orderByComparator
			};
		}

		List<UploadFile> list = null;

		if (useFinderCache) {
			list = (List<UploadFile>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UploadFile uploadFile : list) {
					if (uploadFileBoardNo !=
							uploadFile.getUploadFileBoardNo()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_UPLOADFILE_WHERE);

			sb.append(_FINDER_COLUMN_UPLOADFILEBOARDNO_UPLOADFILEBOARDNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UploadFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(uploadFileBoardNo);

				list = (List<UploadFile>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first upload file in the ordered set where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upload file
	 * @throws NoSuchUploadFileException if a matching upload file could not be found
	 */
	@Override
	public UploadFile findByuploadFileBoardNo_First(
			long uploadFileBoardNo,
			OrderByComparator<UploadFile> orderByComparator)
		throws NoSuchUploadFileException {

		UploadFile uploadFile = fetchByuploadFileBoardNo_First(
			uploadFileBoardNo, orderByComparator);

		if (uploadFile != null) {
			return uploadFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uploadFileBoardNo=");
		sb.append(uploadFileBoardNo);

		sb.append("}");

		throw new NoSuchUploadFileException(sb.toString());
	}

	/**
	 * Returns the first upload file in the ordered set where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upload file, or <code>null</code> if a matching upload file could not be found
	 */
	@Override
	public UploadFile fetchByuploadFileBoardNo_First(
		long uploadFileBoardNo,
		OrderByComparator<UploadFile> orderByComparator) {

		List<UploadFile> list = findByuploadFileBoardNo(
			uploadFileBoardNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last upload file in the ordered set where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upload file
	 * @throws NoSuchUploadFileException if a matching upload file could not be found
	 */
	@Override
	public UploadFile findByuploadFileBoardNo_Last(
			long uploadFileBoardNo,
			OrderByComparator<UploadFile> orderByComparator)
		throws NoSuchUploadFileException {

		UploadFile uploadFile = fetchByuploadFileBoardNo_Last(
			uploadFileBoardNo, orderByComparator);

		if (uploadFile != null) {
			return uploadFile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uploadFileBoardNo=");
		sb.append(uploadFileBoardNo);

		sb.append("}");

		throw new NoSuchUploadFileException(sb.toString());
	}

	/**
	 * Returns the last upload file in the ordered set where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upload file, or <code>null</code> if a matching upload file could not be found
	 */
	@Override
	public UploadFile fetchByuploadFileBoardNo_Last(
		long uploadFileBoardNo,
		OrderByComparator<UploadFile> orderByComparator) {

		int count = countByuploadFileBoardNo(uploadFileBoardNo);

		if (count == 0) {
			return null;
		}

		List<UploadFile> list = findByuploadFileBoardNo(
			uploadFileBoardNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UploadFile[] findByuploadFileBoardNo_PrevAndNext(
			long uploadFileNo, long uploadFileBoardNo,
			OrderByComparator<UploadFile> orderByComparator)
		throws NoSuchUploadFileException {

		UploadFile uploadFile = findByPrimaryKey(uploadFileNo);

		Session session = null;

		try {
			session = openSession();

			UploadFile[] array = new UploadFileImpl[3];

			array[0] = getByuploadFileBoardNo_PrevAndNext(
				session, uploadFile, uploadFileBoardNo, orderByComparator,
				true);

			array[1] = uploadFile;

			array[2] = getByuploadFileBoardNo_PrevAndNext(
				session, uploadFile, uploadFileBoardNo, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UploadFile getByuploadFileBoardNo_PrevAndNext(
		Session session, UploadFile uploadFile, long uploadFileBoardNo,
		OrderByComparator<UploadFile> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_UPLOADFILE_WHERE);

		sb.append(_FINDER_COLUMN_UPLOADFILEBOARDNO_UPLOADFILEBOARDNO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UploadFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(uploadFileBoardNo);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(uploadFile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UploadFile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the upload files where uploadFileBoardNo = &#63; from the database.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 */
	@Override
	public void removeByuploadFileBoardNo(long uploadFileBoardNo) {
		for (UploadFile uploadFile :
				findByuploadFileBoardNo(
					uploadFileBoardNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(uploadFile);
		}
	}

	/**
	 * Returns the number of upload files where uploadFileBoardNo = &#63;.
	 *
	 * @param uploadFileBoardNo the upload file board no
	 * @return the number of matching upload files
	 */
	@Override
	public int countByuploadFileBoardNo(long uploadFileBoardNo) {
		FinderPath finderPath = _finderPathCountByuploadFileBoardNo;

		Object[] finderArgs = new Object[] {uploadFileBoardNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_UPLOADFILE_WHERE);

			sb.append(_FINDER_COLUMN_UPLOADFILEBOARDNO_UPLOADFILEBOARDNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(uploadFileBoardNo);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_UPLOADFILEBOARDNO_UPLOADFILEBOARDNO_2 =
			"uploadFile.uploadFileBoardNo = ?";

	public UploadFilePersistenceImpl() {
		setModelClass(UploadFile.class);

		setModelImplClass(UploadFileImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the upload file in the entity cache if it is enabled.
	 *
	 * @param uploadFile the upload file
	 */
	@Override
	public void cacheResult(UploadFile uploadFile) {
		entityCache.putResult(
			entityCacheEnabled, UploadFileImpl.class,
			uploadFile.getPrimaryKey(), uploadFile);

		uploadFile.resetOriginalValues();
	}

	/**
	 * Caches the upload files in the entity cache if it is enabled.
	 *
	 * @param uploadFiles the upload files
	 */
	@Override
	public void cacheResult(List<UploadFile> uploadFiles) {
		for (UploadFile uploadFile : uploadFiles) {
			if (entityCache.getResult(
					entityCacheEnabled, UploadFileImpl.class,
					uploadFile.getPrimaryKey()) == null) {

				cacheResult(uploadFile);
			}
			else {
				uploadFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all upload files.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UploadFileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the upload file.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UploadFile uploadFile) {
		entityCache.removeResult(
			entityCacheEnabled, UploadFileImpl.class,
			uploadFile.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UploadFile> uploadFiles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UploadFile uploadFile : uploadFiles) {
			entityCache.removeResult(
				entityCacheEnabled, UploadFileImpl.class,
				uploadFile.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, UploadFileImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new upload file with the primary key. Does not add the upload file to the database.
	 *
	 * @param uploadFileNo the primary key for the new upload file
	 * @return the new upload file
	 */
	@Override
	public UploadFile create(long uploadFileNo) {
		UploadFile uploadFile = new UploadFileImpl();

		uploadFile.setNew(true);
		uploadFile.setPrimaryKey(uploadFileNo);

		return uploadFile;
	}

	/**
	 * Removes the upload file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uploadFileNo the primary key of the upload file
	 * @return the upload file that was removed
	 * @throws NoSuchUploadFileException if a upload file with the primary key could not be found
	 */
	@Override
	public UploadFile remove(long uploadFileNo)
		throws NoSuchUploadFileException {

		return remove((Serializable)uploadFileNo);
	}

	/**
	 * Removes the upload file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the upload file
	 * @return the upload file that was removed
	 * @throws NoSuchUploadFileException if a upload file with the primary key could not be found
	 */
	@Override
	public UploadFile remove(Serializable primaryKey)
		throws NoSuchUploadFileException {

		Session session = null;

		try {
			session = openSession();

			UploadFile uploadFile = (UploadFile)session.get(
				UploadFileImpl.class, primaryKey);

			if (uploadFile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUploadFileException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(uploadFile);
		}
		catch (NoSuchUploadFileException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UploadFile removeImpl(UploadFile uploadFile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(uploadFile)) {
				uploadFile = (UploadFile)session.get(
					UploadFileImpl.class, uploadFile.getPrimaryKeyObj());
			}

			if (uploadFile != null) {
				session.delete(uploadFile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (uploadFile != null) {
			clearCache(uploadFile);
		}

		return uploadFile;
	}

	@Override
	public UploadFile updateImpl(UploadFile uploadFile) {
		boolean isNew = uploadFile.isNew();

		if (!(uploadFile instanceof UploadFileModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(uploadFile.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(uploadFile);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in uploadFile proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UploadFile implementation " +
					uploadFile.getClass());
		}

		UploadFileModelImpl uploadFileModelImpl =
			(UploadFileModelImpl)uploadFile;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(uploadFile);

				uploadFile.setNew(false);
			}
			else {
				uploadFile = (UploadFile)session.merge(uploadFile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				uploadFileModelImpl.getUploadFileBoardNo()
			};

			finderCache.removeResult(_finderPathCountByuploadFileBoardNo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByuploadFileBoardNo, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((uploadFileModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByuploadFileBoardNo.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					uploadFileModelImpl.getOriginalUploadFileBoardNo()
				};

				finderCache.removeResult(
					_finderPathCountByuploadFileBoardNo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByuploadFileBoardNo, args);

				args = new Object[] {
					uploadFileModelImpl.getUploadFileBoardNo()
				};

				finderCache.removeResult(
					_finderPathCountByuploadFileBoardNo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByuploadFileBoardNo, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, UploadFileImpl.class,
			uploadFile.getPrimaryKey(), uploadFile, false);

		uploadFile.resetOriginalValues();

		return uploadFile;
	}

	/**
	 * Returns the upload file with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the upload file
	 * @return the upload file
	 * @throws NoSuchUploadFileException if a upload file with the primary key could not be found
	 */
	@Override
	public UploadFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUploadFileException {

		UploadFile uploadFile = fetchByPrimaryKey(primaryKey);

		if (uploadFile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUploadFileException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return uploadFile;
	}

	/**
	 * Returns the upload file with the primary key or throws a <code>NoSuchUploadFileException</code> if it could not be found.
	 *
	 * @param uploadFileNo the primary key of the upload file
	 * @return the upload file
	 * @throws NoSuchUploadFileException if a upload file with the primary key could not be found
	 */
	@Override
	public UploadFile findByPrimaryKey(long uploadFileNo)
		throws NoSuchUploadFileException {

		return findByPrimaryKey((Serializable)uploadFileNo);
	}

	/**
	 * Returns the upload file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uploadFileNo the primary key of the upload file
	 * @return the upload file, or <code>null</code> if a upload file with the primary key could not be found
	 */
	@Override
	public UploadFile fetchByPrimaryKey(long uploadFileNo) {
		return fetchByPrimaryKey((Serializable)uploadFileNo);
	}

	/**
	 * Returns all the upload files.
	 *
	 * @return the upload files
	 */
	@Override
	public List<UploadFile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UploadFile> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<UploadFile> findAll(
		int start, int end, OrderByComparator<UploadFile> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<UploadFile> findAll(
		int start, int end, OrderByComparator<UploadFile> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<UploadFile> list = null;

		if (useFinderCache) {
			list = (List<UploadFile>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_UPLOADFILE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_UPLOADFILE;

				sql = sql.concat(UploadFileModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UploadFile>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the upload files from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UploadFile uploadFile : findAll()) {
			remove(uploadFile);
		}
	}

	/**
	 * Returns the number of upload files.
	 *
	 * @return the number of upload files
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_UPLOADFILE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "uploadFileNo";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_UPLOADFILE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UploadFileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the upload file persistence.
	 */
	@Activate
	public void activate() {
		UploadFileModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		UploadFileModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UploadFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UploadFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByuploadFileName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UploadFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuploadFileName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByuploadFileName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByuploadFileName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByuploadFileBoardNo = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UploadFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuploadFileBoardNo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByuploadFileBoardNo = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UploadFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByuploadFileBoardNo", new String[] {Long.class.getName()},
			UploadFileModelImpl.UPLOADFILEBOARDNO_COLUMN_BITMASK);

		_finderPathCountByuploadFileBoardNo = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByuploadFileBoardNo", new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(UploadFileImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = SJKIMPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.sjkim.model.UploadFile"),
			true);
	}

	@Override
	@Reference(
		target = SJKIMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SJKIMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_UPLOADFILE =
		"SELECT uploadFile FROM UploadFile uploadFile";

	private static final String _SQL_SELECT_UPLOADFILE_WHERE =
		"SELECT uploadFile FROM UploadFile uploadFile WHERE ";

	private static final String _SQL_COUNT_UPLOADFILE =
		"SELECT COUNT(uploadFile) FROM UploadFile uploadFile";

	private static final String _SQL_COUNT_UPLOADFILE_WHERE =
		"SELECT COUNT(uploadFile) FROM UploadFile uploadFile WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "uploadFile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UploadFile exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UploadFile exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UploadFilePersistenceImpl.class);

	static {
		try {
			Class.forName(SJKIMPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}