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

import sjkim.exception.NoSuchDataTypeException;

import sjkim.model.DataType;

/**
 * The persistence interface for the data type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataTypeUtil
 * @generated
 */
@ProviderType
public interface DataTypePersistence extends BasePersistence<DataType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataTypeUtil} to access the data type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the data types where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @return the matching data types
	 */
	public java.util.List<DataType> findBydataTypeNV(String dataTypeNV);

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
	public java.util.List<DataType> findBydataTypeNV(
		String dataTypeNV, int start, int end);

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
	public java.util.List<DataType> findBydataTypeNV(
		String dataTypeNV, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataType>
			orderByComparator);

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
	public java.util.List<DataType> findBydataTypeNV(
		String dataTypeNV, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data type in the ordered set where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	public DataType findBydataTypeNV_First(
			String dataTypeNV,
			com.liferay.portal.kernel.util.OrderByComparator<DataType>
				orderByComparator)
		throws NoSuchDataTypeException;

	/**
	 * Returns the first data type in the ordered set where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	public DataType fetchBydataTypeNV_First(
		String dataTypeNV,
		com.liferay.portal.kernel.util.OrderByComparator<DataType>
			orderByComparator);

	/**
	 * Returns the last data type in the ordered set where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	public DataType findBydataTypeNV_Last(
			String dataTypeNV,
			com.liferay.portal.kernel.util.OrderByComparator<DataType>
				orderByComparator)
		throws NoSuchDataTypeException;

	/**
	 * Returns the last data type in the ordered set where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	public DataType fetchBydataTypeNV_Last(
		String dataTypeNV,
		com.liferay.portal.kernel.util.OrderByComparator<DataType>
			orderByComparator);

	/**
	 * Returns the data types before and after the current data type in the ordered set where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNo the primary key of the current data type
	 * @param dataTypeNV the data type nv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	public DataType[] findBydataTypeNV_PrevAndNext(
			long dataTypeNo, String dataTypeNV,
			com.liferay.portal.kernel.util.OrderByComparator<DataType>
				orderByComparator)
		throws NoSuchDataTypeException;

	/**
	 * Removes all the data types where dataTypeNV LIKE &#63; from the database.
	 *
	 * @param dataTypeNV the data type nv
	 */
	public void removeBydataTypeNV(String dataTypeNV);

	/**
	 * Returns the number of data types where dataTypeNV LIKE &#63;.
	 *
	 * @param dataTypeNV the data type nv
	 * @return the number of matching data types
	 */
	public int countBydataTypeNV(String dataTypeNV);

	/**
	 * Returns all the data types where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @return the matching data types
	 */
	public java.util.List<DataType> findBydataTypeName(String dataTypeName);

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
	public java.util.List<DataType> findBydataTypeName(
		String dataTypeName, int start, int end);

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
	public java.util.List<DataType> findBydataTypeName(
		String dataTypeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataType>
			orderByComparator);

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
	public java.util.List<DataType> findBydataTypeName(
		String dataTypeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data type in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	public DataType findBydataTypeName_First(
			String dataTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<DataType>
				orderByComparator)
		throws NoSuchDataTypeException;

	/**
	 * Returns the first data type in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	public DataType fetchBydataTypeName_First(
		String dataTypeName,
		com.liferay.portal.kernel.util.OrderByComparator<DataType>
			orderByComparator);

	/**
	 * Returns the last data type in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	public DataType findBydataTypeName_Last(
			String dataTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<DataType>
				orderByComparator)
		throws NoSuchDataTypeException;

	/**
	 * Returns the last data type in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	public DataType fetchBydataTypeName_Last(
		String dataTypeName,
		com.liferay.portal.kernel.util.OrderByComparator<DataType>
			orderByComparator);

	/**
	 * Returns the data types before and after the current data type in the ordered set where dataTypeName = &#63;.
	 *
	 * @param dataTypeNo the primary key of the current data type
	 * @param dataTypeName the data type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	public DataType[] findBydataTypeName_PrevAndNext(
			long dataTypeNo, String dataTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<DataType>
				orderByComparator)
		throws NoSuchDataTypeException;

	/**
	 * Removes all the data types where dataTypeName = &#63; from the database.
	 *
	 * @param dataTypeName the data type name
	 */
	public void removeBydataTypeName(String dataTypeName);

	/**
	 * Returns the number of data types where dataTypeName = &#63;.
	 *
	 * @param dataTypeName the data type name
	 * @return the number of matching data types
	 */
	public int countBydataTypeName(String dataTypeName);

	/**
	 * Returns all the data types where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @return the matching data types
	 */
	public java.util.List<DataType> findBydataTypeVersion(
		String dataTypeVersion);

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
	public java.util.List<DataType> findBydataTypeVersion(
		String dataTypeVersion, int start, int end);

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
	public java.util.List<DataType> findBydataTypeVersion(
		String dataTypeVersion, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataType>
			orderByComparator);

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
	public java.util.List<DataType> findBydataTypeVersion(
		String dataTypeVersion, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data type in the ordered set where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	public DataType findBydataTypeVersion_First(
			String dataTypeVersion,
			com.liferay.portal.kernel.util.OrderByComparator<DataType>
				orderByComparator)
		throws NoSuchDataTypeException;

	/**
	 * Returns the first data type in the ordered set where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data type, or <code>null</code> if a matching data type could not be found
	 */
	public DataType fetchBydataTypeVersion_First(
		String dataTypeVersion,
		com.liferay.portal.kernel.util.OrderByComparator<DataType>
			orderByComparator);

	/**
	 * Returns the last data type in the ordered set where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type
	 * @throws NoSuchDataTypeException if a matching data type could not be found
	 */
	public DataType findBydataTypeVersion_Last(
			String dataTypeVersion,
			com.liferay.portal.kernel.util.OrderByComparator<DataType>
				orderByComparator)
		throws NoSuchDataTypeException;

	/**
	 * Returns the last data type in the ordered set where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data type, or <code>null</code> if a matching data type could not be found
	 */
	public DataType fetchBydataTypeVersion_Last(
		String dataTypeVersion,
		com.liferay.portal.kernel.util.OrderByComparator<DataType>
			orderByComparator);

	/**
	 * Returns the data types before and after the current data type in the ordered set where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeNo the primary key of the current data type
	 * @param dataTypeVersion the data type version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	public DataType[] findBydataTypeVersion_PrevAndNext(
			long dataTypeNo, String dataTypeVersion,
			com.liferay.portal.kernel.util.OrderByComparator<DataType>
				orderByComparator)
		throws NoSuchDataTypeException;

	/**
	 * Removes all the data types where dataTypeVersion = &#63; from the database.
	 *
	 * @param dataTypeVersion the data type version
	 */
	public void removeBydataTypeVersion(String dataTypeVersion);

	/**
	 * Returns the number of data types where dataTypeVersion = &#63;.
	 *
	 * @param dataTypeVersion the data type version
	 * @return the number of matching data types
	 */
	public int countBydataTypeVersion(String dataTypeVersion);

	/**
	 * Caches the data type in the entity cache if it is enabled.
	 *
	 * @param dataType the data type
	 */
	public void cacheResult(DataType dataType);

	/**
	 * Caches the data types in the entity cache if it is enabled.
	 *
	 * @param dataTypes the data types
	 */
	public void cacheResult(java.util.List<DataType> dataTypes);

	/**
	 * Creates a new data type with the primary key. Does not add the data type to the database.
	 *
	 * @param dataTypeNo the primary key for the new data type
	 * @return the new data type
	 */
	public DataType create(long dataTypeNo);

	/**
	 * Removes the data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeNo the primary key of the data type
	 * @return the data type that was removed
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	public DataType remove(long dataTypeNo) throws NoSuchDataTypeException;

	public DataType updateImpl(DataType dataType);

	/**
	 * Returns the data type with the primary key or throws a <code>NoSuchDataTypeException</code> if it could not be found.
	 *
	 * @param dataTypeNo the primary key of the data type
	 * @return the data type
	 * @throws NoSuchDataTypeException if a data type with the primary key could not be found
	 */
	public DataType findByPrimaryKey(long dataTypeNo)
		throws NoSuchDataTypeException;

	/**
	 * Returns the data type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataTypeNo the primary key of the data type
	 * @return the data type, or <code>null</code> if a data type with the primary key could not be found
	 */
	public DataType fetchByPrimaryKey(long dataTypeNo);

	/**
	 * Returns all the data types.
	 *
	 * @return the data types
	 */
	public java.util.List<DataType> findAll();

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
	public java.util.List<DataType> findAll(int start, int end);

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
	public java.util.List<DataType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataType>
			orderByComparator);

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
	public java.util.List<DataType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the data types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data types.
	 *
	 * @return the number of data types
	 */
	public int countAll();

}