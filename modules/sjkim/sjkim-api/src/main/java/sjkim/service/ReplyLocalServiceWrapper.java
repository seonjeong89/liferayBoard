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
 * Provides a wrapper for {@link ReplyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReplyLocalService
 * @generated
 */
public class ReplyLocalServiceWrapper
	implements ReplyLocalService, ServiceWrapper<ReplyLocalService> {

	public ReplyLocalServiceWrapper(ReplyLocalService replyLocalService) {
		_replyLocalService = replyLocalService;
	}

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
	@Override
	public sjkim.model.Reply addReply(sjkim.model.Reply reply) {
		return _replyLocalService.addReply(reply);
	}

	/**
	 * Creates a new reply with the primary key. Does not add the reply to the database.
	 *
	 * @param replyNo the primary key for the new reply
	 * @return the new reply
	 */
	@Override
	public sjkim.model.Reply createReply(long replyNo) {
		return _replyLocalService.createReply(replyNo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _replyLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public sjkim.model.Reply deleteReply(long replyNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _replyLocalService.deleteReply(replyNo);
	}

	@Override
	public sjkim.model.Reply deleteReply(Long replyNo, String replyContent) {
		return _replyLocalService.deleteReply(replyNo, replyContent);
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
	@Override
	public sjkim.model.Reply deleteReply(sjkim.model.Reply reply) {
		return _replyLocalService.deleteReply(reply);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _replyLocalService.dynamicQuery();
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

		return _replyLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _replyLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _replyLocalService.dynamicQuery(
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

		return _replyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _replyLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public sjkim.model.Reply fetchReply(long replyNo) {
		return _replyLocalService.fetchReply(replyNo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _replyLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _replyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _replyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _replyLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<sjkim.model.Reply> getReplies(int start, int end) {
		return _replyLocalService.getReplies(start, end);
	}

	/**
	 * Returns the number of replies.
	 *
	 * @return the number of replies
	 */
	@Override
	public int getRepliesCount() {
		return _replyLocalService.getRepliesCount();
	}

	/**
	 * Returns the reply with the primary key.
	 *
	 * @param replyNo the primary key of the reply
	 * @return the reply
	 * @throws PortalException if a reply with the primary key could not be found
	 */
	@Override
	public sjkim.model.Reply getReply(long replyNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _replyLocalService.getReply(replyNo);
	}

	@Override
	public java.util.List<sjkim.model.Reply> getReplyList(long boardNo) {
		return _replyLocalService.getReplyList(boardNo);
	}

	@Override
	public sjkim.model.Reply insertReply(
		String replyContent, Long boardNo, String replyWriter) {

		return _replyLocalService.insertReply(
			replyContent, boardNo, replyWriter);
	}

	@Override
	public sjkim.model.Reply insertReReply(
		String replyContent, Long boardNo, Long replyNo, String replyWriter) {

		return _replyLocalService.insertReReply(
			replyContent, boardNo, replyNo, replyWriter);
	}

	@Override
	public java.util.List<sjkim.model.Reply> listReply(
		Long boardNo, Long replyLevel, int startNum) {

		return _replyLocalService.listReply(boardNo, replyLevel, startNum);
	}

	@Override
	public java.util.List<sjkim.model.Reply> listReReply(
		Long boardNo, Long replyLevel) {

		return _replyLocalService.listReReply(boardNo, replyLevel);
	}

	@Override
	public sjkim.model.Reply updateReply(Long replyNo, String replyContent) {
		return _replyLocalService.updateReply(replyNo, replyContent);
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
	@Override
	public sjkim.model.Reply updateReply(sjkim.model.Reply reply) {
		return _replyLocalService.updateReply(reply);
	}

	@Override
	public ReplyLocalService getWrappedService() {
		return _replyLocalService;
	}

	@Override
	public void setWrappedService(ReplyLocalService replyLocalService) {
		_replyLocalService = replyLocalService;
	}

	private ReplyLocalService _replyLocalService;

}