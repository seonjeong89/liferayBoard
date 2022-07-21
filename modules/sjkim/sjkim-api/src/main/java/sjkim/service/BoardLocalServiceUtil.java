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
 * Provides the local service utility for Board. This utility wraps
 * <code>sjkim.service.impl.BoardLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BoardLocalService
 * @generated
 */
public class BoardLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>sjkim.service.impl.BoardLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the board to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BoardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param board the board
	 * @return the board that was added
	 */
	public static sjkim.model.Board addBoard(sjkim.model.Board board) {
		return getService().addBoard(board);
	}

	/**
	 * Creates a new board with the primary key. Does not add the board to the database.
	 *
	 * @param boardNo the primary key for the new board
	 * @return the new board
	 */
	public static sjkim.model.Board createBoard(long boardNo) {
		return getService().createBoard(boardNo);
	}

	/**
	 * Deletes the board from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BoardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param board the board
	 * @return the board that was removed
	 */
	public static sjkim.model.Board deleteBoard(sjkim.model.Board board) {
		return getService().deleteBoard(board);
	}

	/**
	 * Deletes the board with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BoardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param boardNo the primary key of the board
	 * @return the board that was removed
	 * @throws PortalException if a board with the primary key could not be found
	 */
	public static sjkim.model.Board deleteBoard(long boardNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteBoard(boardNo);
	}

	public static void deleteBoardWithFileList(Long boardNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteBoardWithFileList(boardNo);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sjkim.model.impl.BoardModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sjkim.model.impl.BoardModelImpl</code>.
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

	public static sjkim.model.Board fetchBoard(long boardNo) {
		return getService().fetchBoard(boardNo);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the board with the primary key.
	 *
	 * @param boardNo the primary key of the board
	 * @return the board
	 * @throws PortalException if a board with the primary key could not be found
	 */
	public static sjkim.model.Board getBoard(long boardNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getBoard(boardNo);
	}

	/**
	 * Returns a range of all the boards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>sjkim.model.impl.BoardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of boards
	 * @param end the upper bound of the range of boards (not inclusive)
	 * @return the range of boards
	 */
	public static java.util.List<sjkim.model.Board> getBoards(
		int start, int end) {

		return getService().getBoards(start, end);
	}

	/**
	 * Returns the number of boards.
	 *
	 * @return the number of boards
	 */
	public static int getBoardsCount() {
		return getService().getBoardsCount();
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

	public static sjkim.model.Board increaseViewCount(Long boardNo) {
		return getService().increaseViewCount(boardNo);
	}

	public static sjkim.model.Board insertBoard(
		String boardTitle, String boardContent, String boardWriter) {

		return getService().insertBoard(boardTitle, boardContent, boardWriter);
	}

	public static java.util.List<sjkim.model.Board> searchBoardList(
		String keyword, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<sjkim.model.Board>
			orderByComparator) {

		return getService().searchBoardList(
			keyword, start, end, orderByComparator);
	}

	public static int searchBoardListCount(String keyword) {
		return getService().searchBoardListCount(keyword);
	}

	/**
	 * Updates the board in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BoardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param board the board
	 * @return the board that was updated
	 */
	public static sjkim.model.Board updateBoard(sjkim.model.Board board) {
		return getService().updateBoard(board);
	}

	public static sjkim.model.Board updateBoard(
		Long boardNo, String boardTitle, String boardContent) {

		return getService().updateBoard(boardNo, boardTitle, boardContent);
	}

	public static BoardLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BoardLocalService, BoardLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BoardLocalService.class);

		ServiceTracker<BoardLocalService, BoardLocalService> serviceTracker =
			new ServiceTracker<BoardLocalService, BoardLocalService>(
				bundle.getBundleContext(), BoardLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}