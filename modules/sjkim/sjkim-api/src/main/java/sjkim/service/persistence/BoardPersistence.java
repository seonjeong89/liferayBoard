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

import sjkim.exception.NoSuchBoardException;

import sjkim.model.Board;

/**
 * The persistence interface for the board service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BoardUtil
 * @generated
 */
@ProviderType
public interface BoardPersistence extends BasePersistence<Board> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BoardUtil} to access the board persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the boards where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @return the matching boards
	 */
	public java.util.List<Board> findByboardTitle(String boardTitle);

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
	public java.util.List<Board> findByboardTitle(
		String boardTitle, int start, int end);

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
	public java.util.List<Board> findByboardTitle(
		String boardTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Board>
			orderByComparator);

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
	public java.util.List<Board> findByboardTitle(
		String boardTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Board>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first board in the ordered set where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching board
	 * @throws NoSuchBoardException if a matching board could not be found
	 */
	public Board findByboardTitle_First(
			String boardTitle,
			com.liferay.portal.kernel.util.OrderByComparator<Board>
				orderByComparator)
		throws NoSuchBoardException;

	/**
	 * Returns the first board in the ordered set where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching board, or <code>null</code> if a matching board could not be found
	 */
	public Board fetchByboardTitle_First(
		String boardTitle,
		com.liferay.portal.kernel.util.OrderByComparator<Board>
			orderByComparator);

	/**
	 * Returns the last board in the ordered set where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching board
	 * @throws NoSuchBoardException if a matching board could not be found
	 */
	public Board findByboardTitle_Last(
			String boardTitle,
			com.liferay.portal.kernel.util.OrderByComparator<Board>
				orderByComparator)
		throws NoSuchBoardException;

	/**
	 * Returns the last board in the ordered set where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching board, or <code>null</code> if a matching board could not be found
	 */
	public Board fetchByboardTitle_Last(
		String boardTitle,
		com.liferay.portal.kernel.util.OrderByComparator<Board>
			orderByComparator);

	/**
	 * Returns the boards before and after the current board in the ordered set where boardTitle LIKE &#63;.
	 *
	 * @param boardNo the primary key of the current board
	 * @param boardTitle the board title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next board
	 * @throws NoSuchBoardException if a board with the primary key could not be found
	 */
	public Board[] findByboardTitle_PrevAndNext(
			long boardNo, String boardTitle,
			com.liferay.portal.kernel.util.OrderByComparator<Board>
				orderByComparator)
		throws NoSuchBoardException;

	/**
	 * Removes all the boards where boardTitle LIKE &#63; from the database.
	 *
	 * @param boardTitle the board title
	 */
	public void removeByboardTitle(String boardTitle);

	/**
	 * Returns the number of boards where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @return the number of matching boards
	 */
	public int countByboardTitle(String boardTitle);

	/**
	 * Caches the board in the entity cache if it is enabled.
	 *
	 * @param board the board
	 */
	public void cacheResult(Board board);

	/**
	 * Caches the boards in the entity cache if it is enabled.
	 *
	 * @param boards the boards
	 */
	public void cacheResult(java.util.List<Board> boards);

	/**
	 * Creates a new board with the primary key. Does not add the board to the database.
	 *
	 * @param boardNo the primary key for the new board
	 * @return the new board
	 */
	public Board create(long boardNo);

	/**
	 * Removes the board with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param boardNo the primary key of the board
	 * @return the board that was removed
	 * @throws NoSuchBoardException if a board with the primary key could not be found
	 */
	public Board remove(long boardNo) throws NoSuchBoardException;

	public Board updateImpl(Board board);

	/**
	 * Returns the board with the primary key or throws a <code>NoSuchBoardException</code> if it could not be found.
	 *
	 * @param boardNo the primary key of the board
	 * @return the board
	 * @throws NoSuchBoardException if a board with the primary key could not be found
	 */
	public Board findByPrimaryKey(long boardNo) throws NoSuchBoardException;

	/**
	 * Returns the board with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param boardNo the primary key of the board
	 * @return the board, or <code>null</code> if a board with the primary key could not be found
	 */
	public Board fetchByPrimaryKey(long boardNo);

	/**
	 * Returns all the boards.
	 *
	 * @return the boards
	 */
	public java.util.List<Board> findAll();

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
	public java.util.List<Board> findAll(int start, int end);

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
	public java.util.List<Board> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Board>
			orderByComparator);

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
	public java.util.List<Board> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Board>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the boards from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of boards.
	 *
	 * @return the number of boards
	 */
	public int countAll();

}