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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UploadFile. This utility wraps
 * <code>sjkim.service.impl.UploadFileLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UploadFileLocalService
 * @generated
 */
public class UploadFileLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>sjkim.service.impl.UploadFileLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the upload file to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UploadFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param uploadFile the upload file
	 * @return the upload file that was added
	 */
	public static sjkim.model.UploadFile addUploadFile(
		sjkim.model.UploadFile uploadFile) {

		return getService().addUploadFile(uploadFile);
	}

	/**
	 * Creates a new upload file with the primary key. Does not add the upload file to the database.
	 *
	 * @param uploadFileNo the primary key for the new upload file
	 * @return the new upload file
	 */
	public static sjkim.model.UploadFile createUploadFile(long uploadFileNo) {
		return getService().createUploadFile(uploadFileNo);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the upload file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UploadFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param uploadFileNo the primary key of the upload file
	 * @return the upload file that was removed
	 * @throws PortalException if a upload file with the primary key could not be found
	 */
	public static sjkim.model.UploadFile deleteUploadFile(long uploadFileNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteUploadFile(uploadFileNo);
	}

	/**
	 * Deletes the upload file from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UploadFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param uploadFile the upload file
	 * @return the upload file that was removed
	 */
	public static sjkim.model.UploadFile deleteUploadFile(
		sjkim.model.UploadFile uploadFile) {

		return getService().deleteUploadFile(uploadFile);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sjkim.model.impl.UploadFileModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sjkim.model.impl.UploadFileModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static sjkim.model.UploadFile fetchUploadFile(long uploadFileNo) {
		return getService().fetchUploadFile(uploadFileNo);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the upload file with the primary key.
	 *
	 * @param uploadFileNo the primary key of the upload file
	 * @return the upload file
	 * @throws PortalException if a upload file with the primary key could not be found
	 */
	public static sjkim.model.UploadFile getUploadFile(long uploadFileNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUploadFile(uploadFileNo);
	}

	/**
	 * Returns a range of all the upload files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sjkim.model.impl.UploadFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upload files
	 * @param end the upper bound of the range of upload files (not inclusive)
	 * @return the range of upload files
	 */
	public static java.util.List<sjkim.model.UploadFile> getUploadFiles(
		int start, int end) {

		return getService().getUploadFiles(start, end);
	}

	/**
	 * Returns the number of upload files.
	 *
	 * @return the number of upload files
	 */
	public static int getUploadFilesCount() {
		return getService().getUploadFilesCount();
	}

	/**
	 * Updates the upload file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UploadFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param uploadFile the upload file
	 * @return the upload file that was updated
	 */
	public static sjkim.model.UploadFile updateUploadFile(
		sjkim.model.UploadFile uploadFile) {

		return getService().updateUploadFile(uploadFile);
	}

	public static java.util.List<sjkim.model.UploadFile> uploadFileList(
		long boardNo) {

		return getService().uploadFileList(boardNo);
	}

	public static sjkim.model.UploadFile uploadFiles(
		long boardNo, String Writer, String fileName, String uploadFileName,
		String contentType, String uploadPath) {

		return getService().uploadFiles(
			boardNo, Writer, fileName, uploadFileName, contentType, uploadPath);
	}

	public static UploadFileLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UploadFileLocalService, UploadFileLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UploadFileLocalService.class);

		ServiceTracker<UploadFileLocalService, UploadFileLocalService>
			serviceTracker =
				new ServiceTracker
					<UploadFileLocalService, UploadFileLocalService>(
						bundle.getBundleContext(), UploadFileLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}