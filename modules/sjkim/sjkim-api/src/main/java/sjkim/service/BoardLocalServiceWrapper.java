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
 * Provides a wrapper for {@link BoardLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BoardLocalService
 * @generated
 */
public class BoardLocalServiceWrapper
	implements BoardLocalService, ServiceWrapper<BoardLocalService> {

	public BoardLocalServiceWrapper(BoardLocalService boardLocalService) {
		_boardLocalService = boardLocalService;
	}

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
	@Override
	public sjkim.model.Board addBoard(sjkim.model.Board board) {
		return _boardLocalService.addBoard(board);
	}

	/**
	 * Creates a new board with the primary key. Does not add the board to the database.
	 *
	 * @param boardNo the primary key for the new board
	 * @return the new board
	 */
	@Override
	public sjkim.model.Board createBoard(long boardNo) {
		return _boardLocalService.createBoard(boardNo);
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
	@Override
	public sjkim.model.Board deleteBoard(sjkim.model.Board board) {
		return _boardLocalService.deleteBoard(board);
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
	@Override
	public sjkim.model.Board deleteBoard(long boardNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _boardLocalService.deleteBoard(boardNo);
	}

	@Override
	public void deleteBoardWithFileList(Long boardNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		_boardLocalService.deleteBoardWithFileList(boardNo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _boardLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _boardLocalService.dynamicQuery();
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

		return _boardLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _boardLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _boardLocalService.dynamicQuery(
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

		return _boardLocalService.dynamicQueryCount(dynamicQuery);
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

		return _boardLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public sjkim.model.Board fetchBoard(long boardNo) {
		return _boardLocalService.fetchBoard(boardNo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _boardLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the board with the primary key.
	 *
	 * @param boardNo the primary key of the board
	 * @return the board
	 * @throws PortalException if a board with the primary key could not be found
	 */
	@Override
	public sjkim.model.Board getBoard(long boardNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _boardLocalService.getBoard(boardNo);
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
	@Override
	public java.util.List<sjkim.model.Board> getBoards(int start, int end) {
		return _boardLocalService.getBoards(start, end);
	}

	/**
	 * Returns the number of boards.
	 *
	 * @return the number of boards
	 */
	@Override
	public int getBoardsCount() {
		return _boardLocalService.getBoardsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _boardLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _boardLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _boardLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public sjkim.model.Board increaseViewCount(Long boardNo) {
		return _boardLocalService.increaseViewCount(boardNo);
	}

	@Override
	public sjkim.model.Board insertBoard(
		String boardTitle, String boardContent, String boardWriter) {

		return _boardLocalService.insertBoard(
			boardTitle, boardContent, boardWriter);
	}

	@Override
	public java.util.List<sjkim.model.Board> searchBoardList(
		String keyword, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<sjkim.model.Board>
			orderByComparator) {

		return _boardLocalService.searchBoardList(
			keyword, start, end, orderByComparator);
	}

	@Override
	public int searchBoardListCount(String keyword) {
		return _boardLocalService.searchBoardListCount(keyword);
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
	@Override
	public sjkim.model.Board updateBoard(sjkim.model.Board board) {
		return _boardLocalService.updateBoard(board);
	}

	@Override
	public sjkim.model.Board updateBoard(
		Long boardNo, String boardTitle, String boardContent) {

		return _boardLocalService.updateBoard(
			boardNo, boardTitle, boardContent);
	}

	@Override
	public BoardLocalService getWrappedService() {
		return _boardLocalService;
	}

	@Override
	public void setWrappedService(BoardLocalService boardLocalService) {
		_boardLocalService = boardLocalService;
	}

	private BoardLocalService _boardLocalService;

}