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

import sjkim.model.DataType;

/**
 * The persistence utility for the data type service. This utility wraps <code>sjkim.service.persistence.impl.DataTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataTypePersistence
 * @generated
 */
public class DataTypeUtil {

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
	public static void clearCache(DataType dataType) {
		getPersistence().clearCache(dataType);
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
	public static Map<Serializable, DataType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DataType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DataType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DataType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DataType update(DataType dataType) {
		return getPersistence().update(dataType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DataType update(
		DataType dataType, ServiceContext serviceContext) {

		return getPersistence().update(dataType, serviceContext);
	}

	/**
	 * Returns all the data types where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @return the matching data types
	 */
	public static List<DataType> findBydataTypeNV(String dataTypeNV) {
		return getPersistence().findBydataTypeNV(dataTypeNV);
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
	public static List<DataType> findBydataTypeNV(
		String dataTypeNV, int start, int end) {

		return getPersistence().findBydataTypeNV(dataTypeNV, start, end);
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
	public static List<DataType> findBydataTypeNV(
		String dataTypeNV, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return getPersistence().findBydataTypeNV(
			dataTypeNV, start, end, orderByComparator);
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
	public static List<DataType> findBydataTypeNV(
		String dataTypeNV, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBydataTypeNV(
			dataTypeNV, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data type in the ordered set where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	public static DataType findBydataTypeNV_First(
			String dataTypeNV, OrderByComparator<DataType> orderByComparator)
		throws sjkim.exception.NoSuchDataTypeException {

		return getPersistence().findBydataTypeNV_First(
			dataTypeNV, orderByComparator);
	}

	/**
	 * Returns the first data type in the ordered set where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	public static DataType fetchBydataTypeNV_First(
		String dataTypeNV, OrderByComparator<DataType> orderByComparator) {

		return getPersistence().fetchBydataTypeNV_First(
			dataTypeNV, orderByComparator);
	}

	/**
	 * Returns the last data type in the ordered set where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	public static DataType findBydataTypeNV_Last(
			String dataTypeNV, OrderByComparator<DataType> orderByComparator)
		throws sjkim.exception.NoSuchDataTypeException {

		return getPersistence().findBydataTypeNV_Last(
			dataTypeNV, orderByComparator);
	}

	/**
	 * Returns the last data type in the ordered set where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	public static DataType fetchBydataTypeNV_Last(
		String dataTypeNV, OrderByComparator<DataType> orderByComparator) {

		return getPersistence().fetchBydataTypeNV_Last(
			dataTypeNV, orderByComparator);
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
	public static DataType[] findBydataTypeNV_PrevAndNext(
			long dataTypeNo, String dataTypeNV,
			OrderByComparator<DataType> orderByComparator)
		throws sjkim.exception.NoSuchDataTypeException {

		return getPersistence().findBydataTypeNV_PrevAndNext(
			dataTypeNo, dataTypeNV, orderByComparator);
	}

	/**
	 * Removes all the data types where dataTypeNV LIKE &#63; from the database.
	 *
	 * @param dataTypeNV the data type nv
	 */
	public static void removeBydataTypeNV(String dataTypeNV) {
		getPersistence().removeBydataTypeNV(dataTypeNV);
	}

	/**
	 * Returns the number of data types where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @return the number of matching data types
	 */
	public static int countBydataTypeNV(String dataTypeNV) {
		return getPersistence().countBydataTypeNV(dataTypeNV);
	}

	/**
	 * Returns all the data types where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @return the matching data types
	 */
	public static List<DataType> findBydataTypeName(String dataTypeName) {
		return getPersistence().findBydataTypeName(dataTypeName);
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
	public static List<DataType> findBydataTypeName(
		String dataTypeName, int start, int end) {

		return getPersistence().findBydataTypeName(dataTypeName, start, end);
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
	public static List<DataType> findBydataTypeName(
		String dataTypeName, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return getPersistence().findBydataTypeName(
			dataTypeName, start, end, orderByComparator);
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
	public static List<DataType> findBydataTypeName(
		String dataTypeName, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBydataTypeName(
			dataTypeName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data type in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	public static DataType findBydataTypeName_First(
			String dataTypeName, OrderByComparator<DataType> orderByComparator)
		throws sjkim.exception.NoSuchDataTypeException {

		return getPersistence().findBydataTypeName_First(
			dataTypeName, orderByComparator);
	}

	/**
	 * Returns the first data type in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	public static DataType fetchBydataTypeName_First(
		String dataTypeName, OrderByComparator<DataType> orderByComparator) {

		return getPersistence().fetchBydataTypeName_First(
			dataTypeName, orderByComparator);
	}

	/**
	 * Returns the last data type in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	public static DataType findBydataTypeName_Last(
			String dataTypeName, OrderByComparator<DataType> orderByComparator)
		throws sjkim.exception.NoSuchDataTypeException {

		return getPersistence().findBydataTypeName_Last(
			dataTypeName, orderByComparator);
	}

	/**
	 * Returns the last data type in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	public static DataType fetchBydataTypeName_Last(
		String dataTypeName, OrderByComparator<DataType> orderByComparator) {

		return getPersistence().fetchBydataTypeName_Last(
			dataTypeName, orderByComparator);
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
	public static DataType[] findBydataTypeName_PrevAndNext(
			long dataTypeNo, String dataTypeName,
			OrderByComparator<DataType> orderByComparator)
		throws sjkim.exception.NoSuchDataTypeException {

		return getPersistence().findBydataTypeName_PrevAndNext(
			dataTypeNo, dataTypeName, orderByComparator);
	}

	/**
	 * Removes all the data types where dataTypeName = &#63; from the database.
	 *
	 * @param dataTypeName the data type name
	 */
	public static void removeBydataTypeName(String dataTypeName) {
		getPersistence().removeBydataTypeName(dataTypeName);
	}

	/**
	 * Returns the number of data types where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @return the number of matching data types
	 */
	public static int countBydataTypeName(String dataTypeName) {
		return getPersistence().countBydataTypeName(dataTypeName);
	}

	/**
	 * Returns all the data types where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @return the matching data types
	 */
	public static List<DataType> findBydataTypeVersion(String dataTypeVersion) {
		return getPersistence().findBydataTypeVersion(dataTypeVersion);
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
	public static List<DataType> findBydataTypeVersion(
		String dataTypeVersion, int start, int end) {

		return getPersistence().findBydataTypeVersion(
			dataTypeVersion, start, end);
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
	public static List<DataType> findBydataTypeVersion(
		String dataTypeVersion, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return getPersistence().findBydataTypeVersion(
			dataTypeVersion, start, end, orderByComparator);
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
	public static List<DataType> findBydataTypeVersion(
		String dataTypeVersion, int start, int end,
		OrderByComparator<DataType> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBydataTypeVersion(
			dataTypeVersion, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data type in the ordered set where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	public static DataType findBydataTypeVersion_First(
			String dataTypeVersion,
			OrderByComparator<DataType> orderByComparator)
		throws sjkim.exception.NoSuchDataTypeException {

		return getPersistence().findBydataTypeVersion_First(
			dataTypeVersion, orderByComparator);
	}

	/**
	 * Returns the first data type in the ordered set where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	public static DataType fetchBydataTypeVersion_First(
		String dataTypeVersion, OrderByComparator<DataType> orderByComparator) {

		return getPersistence().fetchBydataTypeVersion_First(
			dataTypeVersion, orderByComparator);
	}

	/**
	 * Returns the last data type in the ordered set where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	public static DataType findBydataTypeVersion_Last(
			String dataTypeVersion,
			OrderByComparator<DataType> orderByComparator)
		throws sjkim.exception.NoSuchDataTypeException {

		return getPersistence().findBydataTypeVersion_Last(
			dataTypeVersion, orderByComparator);
	}

	/**
	 * Returns the last data type in the ordered set where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	public static DataType fetchBydataTypeVersion_Last(
		String dataTypeVersion, OrderByComparator<DataType> orderByComparator) {

		return getPersistence().fetchBydataTypeVersion_Last(
			dataTypeVersion, orderByComparator);
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
	public static DataType[] findBydataTypeVersion_PrevAndNext(
			long dataTypeNo, String dataTypeVersion,
			OrderByComparator<DataType> orderByComparator)
		throws sjkim.exception.NoSuchDataTypeException {

		return getPersistence().findBydataTypeVersion_PrevAndNext(
			dataTypeNo, dataTypeVersion, orderByComparator);
	}

	/**
	 * Removes all the data types where dataTypeVersion = &#63; from the database.
	 *
	 * @param dataTypeVersion the data type version
	 */
	public static void removeBydataTypeVersion(String dataTypeVersion) {
		getPersistence().removeBydataTypeVersion(dataTypeVersion);
	}

	/**
	 * Returns the number of data types where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @return the number of matching data types
	 */
	public static int countBydataTypeVersion(String dataTypeVersion) {
		return getPersistence().countBydataTypeVersion(dataTypeVersion);
	}

	/**
	 * Caches the data type in the entity cache if it is enabled.
	 *
	 * @param dataType the data type
	 */
	public static void cacheResult(DataType dataType) {
		getPersistence().cacheResult(dataType);
	}

	/**
	 * Caches the data types in the entity cache if it is enabled.
	 *
	 * @param dataTypes the data types
	 */
	public static void cacheResult(List<DataType> dataTypes) {
		getPersistence().cacheResult(dataTypes);
	}

	/**
	 * Creates a new data type with the primary key. Does not add the data type to the database.
	 *
	 * @param dataTypeNo the primary key for the new data type
	 * @return the new data type
	 */
	public static DataType create(long dataTypeNo) {
		return getPersistence().create(dataTypeNo);
	}

	/**
	 * Removes the data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeNo the primary key of the data type
	 * @return the data type that was removed
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	public static DataType remove(long dataTypeNo)
		throws sjkim.exception.NoSuchDataTypeException {

		return getPersistence().remove(dataTypeNo);
	}

	public static DataType updateImpl(DataType dataType) {
		return getPersistence().updateImpl(dataType);
	}

	/**
	 * Returns the data type with the primary key or throws a <code>NoSuchDataTypeException</code> if it could not be found.
	 *
	 * @param dataTypeNo the primary key of the data type
	 * @return the data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	public static DataType findByPrimaryKey(long dataTypeNo)
		throws sjkim.exception.NoSuchDataTypeException {

		return getPersistence().findByPrimaryKey(dataTypeNo);
	}

	/**
	 * Returns the data type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataTypeNo the primary key of the data type
	 * @return the data type, or <code>null</code> if a data type with the primary key could not be found
	 */
	public static DataType fetchByPrimaryKey(long dataTypeNo) {
		return getPersistence().fetchByPrimaryKey(dataTypeNo);
	}

	/**
	 * Returns all the data types.
	 *
	 * @return the data types
	 */
	public static List<DataType> findAll() {
		return getPersistence().findAll();
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
	public static List<DataType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<DataType> findAll(
		int start, int end, OrderByComparator<DataType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<DataType> findAll(
		int start, int end, OrderByComparator<DataType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the data types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of data types.
	 *
	 * @return the number of data types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DataTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DataTypePersistence, DataTypePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DataTypePersistence.class);

		ServiceTracker<DataTypePersistence, DataTypePersistence>
			serviceTracker =
				new ServiceTracker<DataTypePersistence, DataTypePersistence>(
					bundle.getBundleContext(), DataTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}