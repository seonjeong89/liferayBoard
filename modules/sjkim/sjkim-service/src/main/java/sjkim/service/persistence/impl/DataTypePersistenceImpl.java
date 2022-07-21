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

import sjkim.exception.NoSuchDataTypeException;

import sjkim.model.DataType;
import sjkim.model.impl.DataTypeImpl;
import sjkim.model.impl.DataTypeModelImpl;

import sjkim.service.persistence.DataTypePersistence;
import sjkim.service.persistence.impl.constants.SJKIMPersistenceConstants;

/**
 * The persistence implementation for the data type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DataTypePersistence.class)
public class DataTypePersistenceImpl
	extends BasePersistenceImpl<DataType> implements DataTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DataTypeUtil</code> to access the data type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DataTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBydataTypeNV;
	private FinderPath _finderPathWithPaginationCountBydataTypeNV;

	/**
	 * Returns all the data types where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findBydataTypeNV(String dataTypeNV) {
		return findBydataTypeNV(
			dataTypeNV, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where dataTypeNV LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeNV the data type nv
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findBydataTypeNV(
		String dataTypeNV, int start, int end) {

		return findBydataTypeNV(dataTypeNV, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where dataTypeNV LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeNV the data type nv
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findBydataTypeNV(
		String dataTypeNV, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findBydataTypeNV(
			dataTypeNV, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where dataTypeNV LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeNV the data type nv
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findBydataTypeNV(
		String dataTypeNV, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		dataTypeNV = Objects.toString(dataTypeNV, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindBydataTypeNV;
		finderArgs = new Object[] {dataTypeNV, start, end, orderByComparator};

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if (!StringUtil.wildcardMatches(
							dataType.getDataTypeNV(), dataTypeNV, '_', '%',
							'\\', true)) {

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

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			boolean bindDataTypeNV = false;

			if (dataTypeNV.isEmpty()) {
				sb.append(_FINDER_COLUMN_DATATYPENV_DATATYPENV_3);
			}
			else {
				bindDataTypeNV = true;

				sb.append(_FINDER_COLUMN_DATATYPENV_DATATYPENV_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDataTypeNV) {
					queryPos.add(dataTypeNV);
				}

				list = (List<DataType>)QueryUtil.list(
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
	 * Returns the first data type in the ordered set where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findBydataTypeNV_First(
			String dataTypeNV, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchBydataTypeNV_First(
			dataTypeNV, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeNVLIKE");
		sb.append(dataTypeNV);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchBydataTypeNV_First(
		String dataTypeNV, OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findBydataTypeNV(
			dataTypeNV, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findBydataTypeNV_Last(
			String dataTypeNV, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchBydataTypeNV_Last(
			dataTypeNV, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeNVLIKE");
		sb.append(dataTypeNV);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchBydataTypeNV_Last(
		String dataTypeNV, OrderByComparator<DataType> orderByComparator) {

		int count = countBydataTypeNV(dataTypeNV);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findBydataTypeNV(
			dataTypeNV, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNo the primary key of the current data type
	 * @param dataTypeNV the data type nv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findBydataTypeNV_PrevAndNext(
			long dataTypeNo, String dataTypeNV,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		dataTypeNV = Objects.toString(dataTypeNV, "");

		DataType dataType = findByPrimaryKey(dataTypeNo);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getBydataTypeNV_PrevAndNext(
				session, dataType, dataTypeNV, orderByComparator, true);

			array[1] = dataType;

			array[2] = getBydataTypeNV_PrevAndNext(
				session, dataType, dataTypeNV, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getBydataTypeNV_PrevAndNext(
		Session session, DataType dataType, String dataTypeNV,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		boolean bindDataTypeNV = false;

		if (dataTypeNV.isEmpty()) {
			sb.append(_FINDER_COLUMN_DATATYPENV_DATATYPENV_3);
		}
		else {
			bindDataTypeNV = true;

			sb.append(_FINDER_COLUMN_DATATYPENV_DATATYPENV_2);
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
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDataTypeNV) {
			queryPos.add(dataTypeNV);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where dataTypeNV LIKE &#63; from the database.
	 *
	 * @param dataTypeNV the data type nv
	 */
	@Override
	public void removeBydataTypeNV(String dataTypeNV) {
		for (DataType dataType :
				findBydataTypeNV(
					dataTypeNV, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @return the number of matching data types
	 */
	@Override
	public int countBydataTypeNV(String dataTypeNV) {
		dataTypeNV = Objects.toString(dataTypeNV, "");

		FinderPath finderPath = _finderPathWithPaginationCountBydataTypeNV;

		Object[] finderArgs = new Object[] {dataTypeNV};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			boolean bindDataTypeNV = false;

			if (dataTypeNV.isEmpty()) {
				sb.append(_FINDER_COLUMN_DATATYPENV_DATATYPENV_3);
			}
			else {
				bindDataTypeNV = true;

				sb.append(_FINDER_COLUMN_DATATYPENV_DATATYPENV_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDataTypeNV) {
					queryPos.add(dataTypeNV);
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

	private static final String _FINDER_COLUMN_DATATYPENV_DATATYPENV_2 =
		"dataType.dataTypeNV LIKE ?";

	private static final String _FINDER_COLUMN_DATATYPENV_DATATYPENV_3 =
		"(dataType.dataTypeNV IS NULL OR dataType.dataTypeNV LIKE '')";

	private FinderPath _finderPathWithPaginationFindBydataTypeName;
	private FinderPath _finderPathWithoutPaginationFindBydataTypeName;
	private FinderPath _finderPathCountBydataTypeName;

	/**
	 * Returns all the data types where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findBydataTypeName(String dataTypeName) {
		return findBydataTypeName(
			dataTypeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where dataTypeName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeName the data type name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findBydataTypeName(
		String dataTypeName, int start, int end) {

		return findBydataTypeName(dataTypeName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where dataTypeName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeName the data type name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findBydataTypeName(
		String dataTypeName, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findBydataTypeName(
			dataTypeName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where dataTypeName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeName the data type name
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findBydataTypeName(
		String dataTypeName, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		dataTypeName = Objects.toString(dataTypeName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBydataTypeName;
				finderArgs = new Object[] {dataTypeName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydataTypeName;
			finderArgs = new Object[] {
				dataTypeName, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if (!dataTypeName.equals(dataType.getDataTypeName())) {
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

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			boolean bindDataTypeName = false;

			if (dataTypeName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DATATYPENAME_DATATYPENAME_3);
			}
			else {
				bindDataTypeName = true;

				sb.append(_FINDER_COLUMN_DATATYPENAME_DATATYPENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDataTypeName) {
					queryPos.add(dataTypeName);
				}

				list = (List<DataType>)QueryUtil.list(
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
	 * Returns the first data type in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findBydataTypeName_First(
			String dataTypeName, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchBydataTypeName_First(
			dataTypeName, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeName=");
		sb.append(dataTypeName);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchBydataTypeName_First(
		String dataTypeName, OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findBydataTypeName(
			dataTypeName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findBydataTypeName_Last(
			String dataTypeName, OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchBydataTypeName_Last(
			dataTypeName, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeName=");
		sb.append(dataTypeName);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchBydataTypeName_Last(
		String dataTypeName, OrderByComparator<DataType> orderByComparator) {

		int count = countBydataTypeName(dataTypeName);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findBydataTypeName(
			dataTypeName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeNo the primary key of the current data type
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findBydataTypeName_PrevAndNext(
			long dataTypeNo, String dataTypeName,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		dataTypeName = Objects.toString(dataTypeName, "");

		DataType dataType = findByPrimaryKey(dataTypeNo);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getBydataTypeName_PrevAndNext(
				session, dataType, dataTypeName, orderByComparator, true);

			array[1] = dataType;

			array[2] = getBydataTypeName_PrevAndNext(
				session, dataType, dataTypeName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getBydataTypeName_PrevAndNext(
		Session session, DataType dataType, String dataTypeName,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		boolean bindDataTypeName = false;

		if (dataTypeName.isEmpty()) {
			sb.append(_FINDER_COLUMN_DATATYPENAME_DATATYPENAME_3);
		}
		else {
			bindDataTypeName = true;

			sb.append(_FINDER_COLUMN_DATATYPENAME_DATATYPENAME_2);
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
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDataTypeName) {
			queryPos.add(dataTypeName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where dataTypeName = &#63; from the database.
	 *
	 * @param dataTypeName the data type name
	 */
	@Override
	public void removeBydataTypeName(String dataTypeName) {
		for (DataType dataType :
				findBydataTypeName(
					dataTypeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @return the number of matching data types
	 */
	@Override
	public int countBydataTypeName(String dataTypeName) {
		dataTypeName = Objects.toString(dataTypeName, "");

		FinderPath finderPath = _finderPathCountBydataTypeName;

		Object[] finderArgs = new Object[] {dataTypeName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			boolean bindDataTypeName = false;

			if (dataTypeName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DATATYPENAME_DATATYPENAME_3);
			}
			else {
				bindDataTypeName = true;

				sb.append(_FINDER_COLUMN_DATATYPENAME_DATATYPENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDataTypeName) {
					queryPos.add(dataTypeName);
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

	private static final String _FINDER_COLUMN_DATATYPENAME_DATATYPENAME_2 =
		"dataType.dataTypeName = ?";

	private static final String _FINDER_COLUMN_DATATYPENAME_DATATYPENAME_3 =
		"(dataType.dataTypeName IS NULL OR dataType.dataTypeName = '')";

	private FinderPath _finderPathWithPaginationFindBydataTypeVersion;
	private FinderPath _finderPathWithoutPaginationFindBydataTypeVersion;
	private FinderPath _finderPathCountBydataTypeVersion;

	/**
	 * Returns all the data types where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @return the matching data types
	 */
	@Override
	public List<DataType> findBydataTypeVersion(String dataTypeVersion) {
		return findBydataTypeVersion(
			dataTypeVersion, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types where dataTypeVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeVersion the data type version
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of matching data types
	 */
	@Override
	public List<DataType> findBydataTypeVersion(
		String dataTypeVersion, int start, int end) {

		return findBydataTypeVersion(dataTypeVersion, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types where dataTypeVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeVersion the data type version
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findBydataTypeVersion(
		String dataTypeVersion, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return findBydataTypeVersion(
			dataTypeVersion, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types where dataTypeVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeVersion the data type version
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data types
	 */
	@Override
	public List<DataType> findBydataTypeVersion(
		String dataTypeVersion, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		dataTypeVersion = Objects.toString(dataTypeVersion, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBydataTypeVersion;
				finderArgs = new Object[] {dataTypeVersion};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydataTypeVersion;
			finderArgs = new Object[] {
				dataTypeVersion, start, end, orderByComparator
			};
		}

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataType dataType : list) {
					if (!dataTypeVersion.equals(
							dataType.getDataTypeVersion())) {

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

			sb.append(_SQL_SELECT_DATATYPE_WHERE);

			boolean bindDataTypeVersion = false;

			if (dataTypeVersion.isEmpty()) {
				sb.append(_FINDER_COLUMN_DATATYPEVERSION_DATATYPEVERSION_3);
			}
			else {
				bindDataTypeVersion = true;

				sb.append(_FINDER_COLUMN_DATATYPEVERSION_DATATYPEVERSION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDataTypeVersion) {
					queryPos.add(dataTypeVersion);
				}

				list = (List<DataType>)QueryUtil.list(
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
	 * Returns the first data type in the ordered set where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findBydataTypeVersion_First(
			String dataTypeVersion,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchBydataTypeVersion_First(
			dataTypeVersion, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeVersion=");
		sb.append(dataTypeVersion);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the first data type in the ordered set where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchBydataTypeVersion_First(
		String dataTypeVersion, OrderByComparator<DataType> orderByComparator) {

		List<DataType> list = findBydataTypeVersion(
			dataTypeVersion, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data type in the ordered set where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	@Override
	public DataType findBydataTypeVersion_Last(
			String dataTypeVersion,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		DataType dataType = fetchBydataTypeVersion_Last(
			dataTypeVersion, orderByComparator);

		if (dataType != null) {
			return dataType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeVersion=");
		sb.append(dataTypeVersion);

		sb.append("}");

		throw new NoSuchDataTypeException(sb.toString());
	}

	/**
	 * Returns the last data type in the ordered set where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public DataType fetchBydataTypeVersion_Last(
		String dataTypeVersion, OrderByComparator<DataType> orderByComparator) {

		int count = countBydataTypeVersion(dataTypeVersion);

		if (count == 0) {
			return null;
		}

		List<DataType> list = findBydataTypeVersion(
			dataTypeVersion, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data types before and after the current data type in the ordered set where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeNo the primary key of the current data type
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType[] findBydataTypeVersion_PrevAndNext(
			long dataTypeNo, String dataTypeVersion,
			OrderByComparator<DataType> orderByComparator)
		throws NoSuchDataTypeException {

		dataTypeVersion = Objects.toString(dataTypeVersion, "");

		DataType dataType = findByPrimaryKey(dataTypeNo);

		Session session = null;

		try {
			session = openSession();

			DataType[] array = new DataTypeImpl[3];

			array[0] = getBydataTypeVersion_PrevAndNext(
				session, dataType, dataTypeVersion, orderByComparator, true);

			array[1] = dataType;

			array[2] = getBydataTypeVersion_PrevAndNext(
				session, dataType, dataTypeVersion, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataType getBydataTypeVersion_PrevAndNext(
		Session session, DataType dataType, String dataTypeVersion,
		OrderByComparator<DataType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DATATYPE_WHERE);

		boolean bindDataTypeVersion = false;

		if (dataTypeVersion.isEmpty()) {
			sb.append(_FINDER_COLUMN_DATATYPEVERSION_DATATYPEVERSION_3);
		}
		else {
			bindDataTypeVersion = true;

			sb.append(_FINDER_COLUMN_DATATYPEVERSION_DATATYPEVERSION_2);
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
			sb.append(DataTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDataTypeVersion) {
			queryPos.add(dataTypeVersion);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DataType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data types where dataTypeVersion = &#63; from the database.
	 *
	 * @param dataTypeVersion the data type version
	 */
	@Override
	public void removeBydataTypeVersion(String dataTypeVersion) {
		for (DataType dataType :
				findBydataTypeVersion(
					dataTypeVersion, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @return the number of matching data types
	 */
	@Override
	public int countBydataTypeVersion(String dataTypeVersion) {
		dataTypeVersion = Objects.toString(dataTypeVersion, "");

		FinderPath finderPath = _finderPathCountBydataTypeVersion;

		Object[] finderArgs = new Object[] {dataTypeVersion};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DATATYPE_WHERE);

			boolean bindDataTypeVersion = false;

			if (dataTypeVersion.isEmpty()) {
				sb.append(_FINDER_COLUMN_DATATYPEVERSION_DATATYPEVERSION_3);
			}
			else {
				bindDataTypeVersion = true;

				sb.append(_FINDER_COLUMN_DATATYPEVERSION_DATATYPEVERSION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDataTypeVersion) {
					queryPos.add(dataTypeVersion);
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

	private static final String
		_FINDER_COLUMN_DATATYPEVERSION_DATATYPEVERSION_2 =
			"dataType.dataTypeVersion = ?";

	private static final String
		_FINDER_COLUMN_DATATYPEVERSION_DATATYPEVERSION_3 =
			"(dataType.dataTypeVersion IS NULL OR dataType.dataTypeVersion = '')";

	public DataTypePersistenceImpl() {
		setModelClass(DataType.class);

		setModelImplClass(DataTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the data type in the entity cache if it is enabled.
	 *
	 * @param dataType the data type
	 */
	@Override
	public void cacheResult(DataType dataType) {
		entityCache.putResult(
			entityCacheEnabled, DataTypeImpl.class, dataType.getPrimaryKey(),
			dataType);

		dataType.resetOriginalValues();
	}

	/**
	 * Caches the data types in the entity cache if it is enabled.
	 *
	 * @param dataTypes the data types
	 */
	@Override
	public void cacheResult(List<DataType> dataTypes) {
		for (DataType dataType : dataTypes) {
			if (entityCache.getResult(
					entityCacheEnabled, DataTypeImpl.class,
					dataType.getPrimaryKey()) == null) {

				cacheResult(dataType);
			}
			else {
				dataType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataType dataType) {
		entityCache.removeResult(
			entityCacheEnabled, DataTypeImpl.class, dataType.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DataType> dataTypes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataType dataType : dataTypes) {
			entityCache.removeResult(
				entityCacheEnabled, DataTypeImpl.class,
				dataType.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, DataTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new data type with the primary key. Does not add the data type to the database.
	 *
	 * @param dataTypeNo the primary key for the new data type
	 * @return the new data type
	 */
	@Override
	public DataType create(long dataTypeNo) {
		DataType dataType = new DataTypeImpl();

		dataType.setNew(true);
		dataType.setPrimaryKey(dataTypeNo);

		return dataType;
	}

	/**
	 * Removes the data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeNo the primary key of the data type
	 * @return the data type that was removed
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType remove(long dataTypeNo) throws NoSuchDataTypeException {
		return remove((Serializable)dataTypeNo);
	}

	/**
	 * Removes the data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data type
	 * @return the data type that was removed
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType remove(Serializable primaryKey)
		throws NoSuchDataTypeException {

		Session session = null;

		try {
			session = openSession();

			DataType dataType = (DataType)session.get(
				DataTypeImpl.class, primaryKey);

			if (dataType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dataType);
		}
		catch (NoSuchDataTypeException noSuchEntityException) {
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
	protected DataType removeImpl(DataType dataType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataType)) {
				dataType = (DataType)session.get(
					DataTypeImpl.class, dataType.getPrimaryKeyObj());
			}

			if (dataType != null) {
				session.delete(dataType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dataType != null) {
			clearCache(dataType);
		}

		return dataType;
	}

	@Override
	public DataType updateImpl(DataType dataType) {
		boolean isNew = dataType.isNew();

		if (!(dataType instanceof DataTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dataType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dataType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dataType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DataType implementation " +
					dataType.getClass());
		}

		DataTypeModelImpl dataTypeModelImpl = (DataTypeModelImpl)dataType;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dataType);

				dataType.setNew(false);
			}
			else {
				dataType = (DataType)session.merge(dataType);
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
			Object[] args = new Object[] {dataTypeModelImpl.getDataTypeName()};

			finderCache.removeResult(_finderPathCountBydataTypeName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBydataTypeName, args);

			args = new Object[] {dataTypeModelImpl.getDataTypeVersion()};

			finderCache.removeResult(_finderPathCountBydataTypeVersion, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBydataTypeVersion, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBydataTypeName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalDataTypeName()
				};

				finderCache.removeResult(_finderPathCountBydataTypeName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBydataTypeName, args);

				args = new Object[] {dataTypeModelImpl.getDataTypeName()};

				finderCache.removeResult(_finderPathCountBydataTypeName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBydataTypeName, args);
			}

			if ((dataTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBydataTypeVersion.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataTypeModelImpl.getOriginalDataTypeVersion()
				};

				finderCache.removeResult(
					_finderPathCountBydataTypeVersion, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBydataTypeVersion, args);

				args = new Object[] {dataTypeModelImpl.getDataTypeVersion()};

				finderCache.removeResult(
					_finderPathCountBydataTypeVersion, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBydataTypeVersion, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, DataTypeImpl.class, dataType.getPrimaryKey(),
			dataType, false);

		dataType.resetOriginalValues();

		return dataType;
	}

	/**
	 * Returns the data type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data type
	 * @return the data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataTypeException {

		DataType dataType = fetchByPrimaryKey(primaryKey);

		if (dataType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dataType;
	}

	/**
	 * Returns the data type with the primary key or throws a <code>NoSuchDataTypeException</code> if it could not be found.
	 *
	 * @param dataTypeNo the primary key of the data type
	 * @return the data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	@Override
	public DataType findByPrimaryKey(long dataTypeNo)
		throws NoSuchDataTypeException {

		return findByPrimaryKey((Serializable)dataTypeNo);
	}

	/**
	 * Returns the data type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataTypeNo the primary key of the data type
	 * @return the data type, or <code>null</code> if a data type with the primary key could not be found
	 */
	@Override
	public DataType fetchByPrimaryKey(long dataTypeNo) {
		return fetchByPrimaryKey((Serializable)dataTypeNo);
	}

	/**
	 * Returns all the data types.
	 *
	 * @return the data types
	 */
	@Override
	public List<DataType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of data types
	 */
	@Override
	public List<DataType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data types
	 */
	@Override
	public List<DataType> findAll(
		int start, int end, OrderByComparator<DataType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data types
	 */
	@Override
	public List<DataType> findAll(
		int start, int end, OrderByComparator<DataType> orderByComparator,
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

		List<DataType> list = null;

		if (useFinderCache) {
			list = (List<DataType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DATATYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DATATYPE;

				sql = sql.concat(DataTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DataType>)QueryUtil.list(
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
	 * Removes all the data types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DataType dataType : findAll()) {
			remove(dataType);
		}
	}

	/**
	 * Returns the number of data types.
	 *
	 * @return the number of data types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DATATYPE);

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
		return "dataTypeNo";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DATATYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DataTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data type persistence.
	 */
	@Activate
	public void activate() {
		DataTypeModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DataTypeModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindBydataTypeNV = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydataTypeNV",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountBydataTypeNV = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBydataTypeNV",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindBydataTypeName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydataTypeName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBydataTypeName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydataTypeName",
			new String[] {String.class.getName()},
			DataTypeModelImpl.DATATYPENAME_COLUMN_BITMASK);

		_finderPathCountBydataTypeName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydataTypeName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindBydataTypeVersion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydataTypeVersion",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBydataTypeVersion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydataTypeVersion",
			new String[] {String.class.getName()},
			DataTypeModelImpl.DATATYPEVERSION_COLUMN_BITMASK);

		_finderPathCountBydataTypeVersion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydataTypeVersion",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DataTypeImpl.class.getName());

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
				"value.object.column.bitmask.enabled.sjkim.model.DataType"),
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

	private static final String _SQL_SELECT_DATATYPE =
		"SELECT dataType FROM DataType dataType";

	private static final String _SQL_SELECT_DATATYPE_WHERE =
		"SELECT dataType FROM DataType dataType WHERE ";

	private static final String _SQL_COUNT_DATATYPE =
		"SELECT COUNT(dataType) FROM DataType dataType";

	private static final String _SQL_COUNT_DATATYPE_WHERE =
		"SELECT COUNT(dataType) FROM DataType dataType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dataType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DataType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DataType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DataTypePersistenceImpl.class);

	static {
		try {
			Class.forName(SJKIMPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}