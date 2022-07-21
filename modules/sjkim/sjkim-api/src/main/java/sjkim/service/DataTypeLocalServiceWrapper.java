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

package sjkim.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DataTypeLocalService
 * @generated
 */
public class DataTypeLocalServiceWrapper
	implements DataTypeLocalService, ServiceWrapper<DataTypeLocalService> {

	public DataTypeLocalServiceWrapper(
		DataTypeLocalService dataTypeLocalService) {

		_dataTypeLocalService = dataTypeLocalService;
	}

	/**
	 * Adds the data type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataType the data type
	 * @return the data type that was added
	 */
	@Override
	public sjkim.model.DataType addDataType(sjkim.model.DataType dataType) {
		return _dataTypeLocalService.addDataType(dataType);
	}

	@Override
	public sjkim.model.DataType cloneDataType(
			long dataTypeNo, String dataTypeVersion, String dataTypeWriter)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.cloneDataType(
			dataTypeNo, dataTypeVersion, dataTypeWriter);
	}

	/**
	 * Creates a new data type with the primary key. Does not add the data type to the database.
	 *
	 * @param dataTypeNo the primary key for the new data type
	 * @return the new data type
	 */
	@Override
	public sjkim.model.DataType createDataType(long dataTypeNo) {
		return _dataTypeLocalService.createDataType(dataTypeNo);
	}

	@Override
	public void daleteDataType(long dataTypeNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		_dataTypeLocalService.daleteDataType(dataTypeNo);
	}

	/**
	 * Deletes the data type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataType the data type
	 * @return the data type that was removed
	 */
	@Override
	public sjkim.model.DataType deleteDataType(sjkim.model.DataType dataType) {
		return _dataTypeLocalService.deleteDataType(dataType);
	}

	/**
	 * Deletes the data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataTypeNo the primary key of the data type
	 * @return the data type that was removed
	 * @throws PortalException if a data type with the primary key could not be found
	 */
	@Override
	public sjkim.model.DataType deleteDataType(long dataTypeNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.deleteDataType(dataTypeNo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataTypeLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dataTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sjkim.model.impl.DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dataTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sjkim.model.impl.DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dataTypeLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dataTypeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _dataTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public sjkim.model.DataType fetchDataType(long dataTypeNo) {
		return _dataTypeLocalService.fetchDataType(dataTypeNo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataTypeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the data type with the primary key.
	 *
	 * @param dataTypeNo the primary key of the data type
	 * @return the data type
	 * @throws PortalException if a data type with the primary key could not be found
	 */
	@Override
	public sjkim.model.DataType getDataType(long dataTypeNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.getDataType(dataTypeNo);
	}

	/**
	 * Returns a range of all the data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sjkim.model.impl.DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of data types
	 */
	@Override
	public java.util.List<sjkim.model.DataType> getDataTypes(
		int start, int end) {

		return _dataTypeLocalService.getDataTypes(start, end);
	}

	/**
	 * Returns the number of data types.
	 *
	 * @return the number of data types
	 */
	@Override
	public int getDataTypesCount() {
		return _dataTypeLocalService.getDataTypesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public sjkim.model.DataType insertDataType(
		String dataTypeName, String dataTypeVersion,
		java.util.Map<java.util.Locale, String> dataTypeExplanation,
		java.util.Map<java.util.Locale, String> dataTypeDisplayName,
		String writer, String dataTypeStructure, String RealfileName,
		String uploadFileName, String contentType, String realPath) {

		return _dataTypeLocalService.insertDataType(
			dataTypeName, dataTypeVersion, dataTypeExplanation,
			dataTypeDisplayName, writer, dataTypeStructure, RealfileName,
			uploadFileName, contentType, realPath);
	}

	@Override
	public java.util.List<sjkim.model.DataType> searchDataTypeList(
		String keyword, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<sjkim.model.DataType>
			orderByComparator) {

		return _dataTypeLocalService.searchDataTypeList(
			keyword, start, end, orderByComparator);
	}

	@Override
	public int searchDataTypeListCount(String keyword) {
		return _dataTypeLocalService.searchDataTypeListCount(keyword);
	}

	/**
	 * Updates the data type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataType the data type
	 * @return the data type that was updated
	 */
	@Override
	public sjkim.model.DataType updateDataType(sjkim.model.DataType dataType) {
		return _dataTypeLocalService.updateDataType(dataType);
	}

	@Override
	public sjkim.model.DataType updateDataTypeAll(
			long dataTypeNo,
			java.util.Map<java.util.Locale, String> dataTypeExplanation,
			java.util.Map<java.util.Locale, String> dataTypeDisplayName,
			String dataTypeStructure, String dataTypeWriter,
			String RealfileName, String uploadFileName, String contentType,
			String realPath)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.updateDataTypeAll(
			dataTypeNo, dataTypeExplanation, dataTypeDisplayName,
			dataTypeStructure, dataTypeWriter, RealfileName, uploadFileName,
			contentType, realPath);
	}

	@Override
	public sjkim.model.DataType updateDataTypeWithoutFile(
			long dataTypeNo,
			java.util.Map<java.util.Locale, String> dataTypeExplanation,
			java.util.Map<java.util.Locale, String> dataTypeDisplayName,
			String dataTypeStructure, String dataTypeWriter)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.updateDataTypeWithoutFile(
			dataTypeNo, dataTypeExplanation, dataTypeDisplayName,
			dataTypeStructure, dataTypeWriter);
	}

	@Override
	public sjkim.model.DataType upgradeDataType(
			long dataTypeNo, String dataTypeWriter)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.upgradeDataType(
			dataTypeNo, dataTypeWriter);
	}

	@Override
	public DataTypeLocalService getWrappedService() {
		return _dataTypeLocalService;
	}

	@Override
	public void setWrappedService(DataTypeLocalService dataTypeLocalService) {
		_dataTypeLocalService = dataTypeLocalService;
	}

	private DataTypeLocalService _dataTypeLocalService;

}