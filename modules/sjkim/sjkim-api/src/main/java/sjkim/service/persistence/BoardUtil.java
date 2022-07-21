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

import sjkim.model.Board;

/**
 * The persistence utility for the board service. This utility wraps <code>sjkim.service.persistence.impl.BoardPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BoardPersistence
 * @generated
 */
public class BoardUtil {

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
	public static void clearCache(Board board) {
		getPersistence().clearCache(board);
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
	public static Map<Serializable, Board> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Board> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Board> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Board> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Board> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Board update(Board board) {
		return getPersistence().update(board);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Board update(Board board, ServiceContext serviceContext) {
		return getPersistence().update(board, serviceContext);
	}

	/**
	 * Returns all the boards where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @return the matching boards
	 */
	public static List<Board> findByboardTitle(String boardTitle) {
		return getPersistence().findByboardTitle(boardTitle);
	}

	/**
	 * Returns a range of all the boards where boardTitle LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardModelImpl</code>.
	 * </p>
	 *
	 * @param boardTitle the board title
	 * @param start the lower bound of the range of boards
	 * @param end the upper bound of the range of boards (not inclusive)
	 * @return the range of matching boards
	 */
	public static List<Board> findByboardTitle(
		String boardTitle, int start, int end) {

		return getPersistence().findByboardTitle(boardTitle, start, end);
	}

	/**
	 * Returns an ordered range of all the boards where boardTitle LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardModelImpl</code>.
	 * </p>
	 *
	 * @param boardTitle the board title
	 * @param start the lower bound of the range of boards
	 * @param end the upper bound of the range of boards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching boards
	 */
	public static List<Board> findByboardTitle(
		String boardTitle, int start, int end,
		OrderByComparator<Board> orderByComparator) {

		return getPersistence().findByboardTitle(
			boardTitle, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the boards where boardTitle LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardModelImpl</code>.
	 * </p>
	 *
	 * @param boardTitle the board title
	 * @param start the lower bound of the range of boards
	 * @param end the upper bound of the range of boards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching boards
	 */
	public static List<Board> findByboardTitle(
		String boardTitle, int start, int end,
		OrderByComparator<Board> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByboardTitle(
			boardTitle, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first board in the ordered set where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching board
	 * @throws NoSuchBoardException if a matching board could not be found
	 */
	public static Board findByboardTitle_First(
			String boardTitle, OrderByComparator<Board> orderByComparator)
		throws sjkim.exception.NoSuchBoardException {

		return getPersistence().findByboardTitle_First(
			boardTitle, orderByComparator);
	}

	/**
	 * Returns the first board in the ordered set where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching board, or <code>null</code> if a matching board could not be found
	 */
	public static Board fetchByboardTitle_First(
		String boardTitle, OrderByComparator<Board> orderByComparator) {

		return getPersistence().fetchByboardTitle_First(
			boardTitle, orderByComparator);
	}

	/**
	 * Returns the last board in the ordered set where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching board
	 * @throws NoSuchBoardException if a matching board could not be found
	 */
	public static Board findByboardTitle_Last(
			String boardTitle, OrderByComparator<Board> orderByComparator)
		throws sjkim.exception.NoSuchBoardException {

		return getPersistence().findByboardTitle_Last(
			boardTitle, orderByComparator);
	}

	/**
	 * Returns the last board in the ordered set where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching board, or <code>null</code> if a matching board could not be found
	 */
	public static Board fetchByboardTitle_Last(
		String boardTitle, OrderByComparator<Board> orderByComparator) {

		return getPersistence().fetchByboardTitle_Last(
			boardTitle, orderByComparator);
	}

	/**
	 * Returns the boards before and after the current board in the ordered set where boardTitle LIKE &#63;.
	 *
	 * @param boardNo the primary key of the current board
	 * @param boardTitle the board title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next board
	 * @throws NoSuchBoardException if a board with the primary key could not be found
	 */
	public static Board[] findByboardTitle_PrevAndNext(
			long boardNo, String boardTitle,
			OrderByComparator<Board> orderByComparator)
		throws sjkim.exception.NoSuchBoardException {

		return getPersistence().findByboardTitle_PrevAndNext(
			boardNo, boardTitle, orderByComparator);
	}

	/**
	 * Removes all the boards where boardTitle LIKE &#63; from the database.
	 *
	 * @param boardTitle the board title
	 */
	public static void removeByboardTitle(String boardTitle) {
		getPersistence().removeByboardTitle(boardTitle);
	}

	/**
	 * Returns the number of boards where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @return the number of matching boards
	 */
	public static int countByboardTitle(String boardTitle) {
		return getPersistence().countByboardTitle(boardTitle);
	}

	/**
	 * Caches the board in the entity cache if it is enabled.
	 *
	 * @param board the board
	 */
	public static void cacheResult(Board board) {
		getPersistence().cacheResult(board);
	}

	/**
	 * Caches the boards in the entity cache if it is enabled.
	 *
	 * @param boards the boards
	 */
	public static void cacheResult(List<Board> boards) {
		getPersistence().cacheResult(boards);
	}

	/**
	 * Creates a new board with the primary key. Does not add the board to the database.
	 *
	 * @param boardNo the primary key for the new board
	 * @return the new board
	 */
	public static Board create(long boardNo) {
		return getPersistence().create(boardNo);
	}

	/**
	 * Removes the board with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param boardNo the primary key of the board
	 * @return the board that was removed
	 * @throws NoSuchBoardException if a board with the primary key could not be found
	 */
	public static Board remove(long boardNo)
		throws sjkim.exception.NoSuchBoardException {

		return getPersistence().remove(boardNo);
	}

	public static Board updateImpl(Board board) {
		return getPersistence().updateImpl(board);
	}

	/**
	 * Returns the board with the primary key or throws a <code>NoSuchBoardException</code> if it could not be found.
	 *
	 * @param boardNo the primary key of the board
	 * @return the board
	 * @throws NoSuchBoardException if a board with the primary key could not be found
	 */
	public static Board findByPrimaryKey(long boardNo)
		throws sjkim.exception.NoSuchBoardException {

		return getPersistence().findByPrimaryKey(boardNo);
	}

	/**
	 * Returns the board with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param boardNo the primary key of the board
	 * @return the board, or <code>null</code> if a board with the primary key could not be found
	 */
	public static Board fetchByPrimaryKey(long boardNo) {
		return getPersistence().fetchByPrimaryKey(boardNo);
	}

	/**
	 * Returns all the boards.
	 *
	 * @return the boards
	 */
	public static List<Board> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the boards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of boards
	 * @param end the upper bound of the range of boards (not inclusive)
	 * @return the range of boards
	 */
	public static List<Board> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the boards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of boards
	 * @param end the upper bound of the range of boards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of boards
	 */
	public static List<Board> findAll(
		int start, int end, OrderByComparator<Board> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the boards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BoardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of boards
	 * @param end the upper bound of the range of boards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of boards
	 */
	public static List<Board> findAll(
		int start, int end, OrderByComparator<Board> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the boards from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of boards.
	 *
	 * @return the number of boards
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BoardPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BoardPersistence, BoardPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BoardPersistence.class);

		ServiceTracker<BoardPersistence, BoardPersistence> serviceTracker =
			new ServiceTracker<BoardPersistence, BoardPersistence>(
				bundle.getBundleContext(), BoardPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}