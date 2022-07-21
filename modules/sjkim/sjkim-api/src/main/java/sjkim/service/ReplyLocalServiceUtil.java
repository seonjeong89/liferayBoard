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
 * Provides the local service utility for Reply. This utility wraps
 * <code>sjkim.service.impl.ReplyLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ReplyLocalService
 * @generated
 */
public class ReplyLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>sjkim.service.impl.ReplyLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the reply to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReplyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reply the reply
	 * @return the reply that was added
	 */
	public static sjkim.model.Reply addReply(sjkim.model.Reply reply) {
		return getService().addReply(reply);
	}

	/**
	 * Creates a new reply with the primary key. Does not add the reply to the database.
	 *
	 * @param replyNo the primary key for the new reply
	 * @return the new reply
	 */
	public static sjkim.model.Reply createReply(long replyNo) {
		return getService().createReply(replyNo);
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
	 * Deletes the reply with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReplyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param replyNo the primary key of the reply
	 * @return the reply that was removed
	 * @throws PortalException if a reply with the primary key could not be found
	 */
	public static sjkim.model.Reply deleteReply(long replyNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteReply(replyNo);
	}

	public static sjkim.model.Reply deleteReply(
		Long replyNo, String replyContent) {

		return getService().deleteReply(replyNo, replyContent);
	}

	/**
	 * Deletes the reply from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReplyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reply the reply
	 * @return the reply that was removed
	 */
	public static sjkim.model.Reply deleteReply(sjkim.model.Reply reply) {
		return getService().deleteReply(reply);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sjkim.model.impl.ReplyModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sjkim.model.impl.ReplyModelImpl</code>.
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

	public static sjkim.model.Reply fetchReply(long replyNo) {
		return getService().fetchReply(replyNo);
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
	 * Returns a range of all the replies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sjkim.model.impl.ReplyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of replies
	 * @param end the upper bound of the range of replies (not inclusive)
	 * @return the range of replies
	 */
	public static java.util.List<sjkim.model.Reply> getReplies(
		int start, int end) {

		return getService().getReplies(start, end);
	}

	/**
	 * Returns the number of replies.
	 *
	 * @return the number of replies
	 */
	public static int getRepliesCount() {
		return getService().getRepliesCount();
	}

	/**
	 * Returns the reply with the primary key.
	 *
	 * @param replyNo the primary key of the reply
	 * @return the reply
	 * @throws PortalException if a reply with the primary key could not be found
	 */
	public static sjkim.model.Reply getReply(long replyNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getReply(replyNo);
	}

	public static java.util.List<sjkim.model.Reply> getReplyList(long boardNo) {
		return getService().getReplyList(boardNo);
	}

	public static sjkim.model.Reply insertReply(
		String replyContent, Long boardNo, String replyWriter) {

		return getService().insertReply(replyContent, boardNo, replyWriter);
	}

	public static sjkim.model.Reply insertReReply(
		String replyContent, Long boardNo, Long replyNo, String replyWriter) {

		return getService().insertReReply(
			replyContent, boardNo, replyNo, replyWriter);
	}

	public static java.util.List<sjkim.model.Reply> listReply(
		Long boardNo, Long replyLevel, int startNum) {

		return getService().listReply(boardNo, replyLevel, startNum);
	}

	public static java.util.List<sjkim.model.Reply> listReReply(
		Long boardNo, Long replyLevel) {

		return getService().listReReply(boardNo, replyLevel);
	}

	public static sjkim.model.Reply updateReply(
		Long replyNo, String replyContent) {

		return getService().updateReply(replyNo, replyContent);
	}

	/**
	 * Updates the reply in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReplyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reply the reply
	 * @return the reply that was updated
	 */
	public static sjkim.model.Reply updateReply(sjkim.model.Reply reply) {
		return getService().updateReply(reply);
	}

	public static ReplyLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ReplyLocalService, ReplyLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ReplyLocalService.class);

		ServiceTracker<ReplyLocalService, ReplyLocalService> serviceTracker =
			new ServiceTracker<ReplyLocalService, ReplyLocalService>(
				bundle.getBundleContext(), ReplyLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}