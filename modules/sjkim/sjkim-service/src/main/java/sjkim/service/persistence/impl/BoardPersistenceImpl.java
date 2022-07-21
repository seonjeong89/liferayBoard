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

package sjkim.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import sjkim.exception.NoSuchBoardException;

import sjkim.model.Board;
import sjkim.model.impl.BoardImpl;
import sjkim.model.impl.BoardModelImpl;

import sjkim.service.persistence.BoardPersistence;
import sjkim.service.persistence.impl.constants.SJKIMPersistenceConstants;

/**
 * The persistence implementation for the board service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BoardPersistence.class)
public class BoardPersistenceImpl
	extends BasePersistenceImpl<Board> implements BoardPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BoardUtil</code> to access the board persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BoardImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByboardTitle;
	private FinderPath _finderPathWithPaginationCountByboardTitle;

	/**
	 * Returns all the boards where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @return the matching boards
	 */
	@Override
	public List<Board> findByboardTitle(String boardTitle) {
		return findByboardTitle(
			boardTitle, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Board> findByboardTitle(String boardTitle, int start, int end) {
		return findByboardTitle(boardTitle, start, end, null);
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
	@Override
	public List<Board> findByboardTitle(
		String boardTitle, int start, int end,
		OrderByComparator<Board> orderByComparator) {

		return findByboardTitle(
			boardTitle, start, end, orderByComparator, true);
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
	@Override
	public List<Board> findByboardTitle(
		String boardTitle, int start, int end,
		OrderByComparator<Board> orderByComparator, boolean useFinderCache) {

		boardTitle = Objects.toString(boardTitle, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByboardTitle;
		finderArgs = new Object[] {boardTitle, start, end, orderByComparator};

		List<Board> list = null;

		if (useFinderCache) {
			list = (List<Board>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Board board : list) {
					if (!StringUtil.wildcardMatches(
							board.getBoardTitle(), boardTitle, '_', '%', '\\',
							true)) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BOARD_WHERE);

			boolean bindBoardTitle = false;

			if (boardTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_BOARDTITLE_BOARDTITLE_3);
			}
			else {
				bindBoardTitle = true;

				sb.append(_FINDER_COLUMN_BOARDTITLE_BOARDTITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BoardModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBoardTitle) {
					queryPos.add(boardTitle);
				}

				list = (List<Board>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first board in the ordered set where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching board
	 * @throws NoSuchBoardException if a matching board could not be found
	 */
	@Override
	public Board findByboardTitle_First(
			String boardTitle, OrderByComparator<Board> orderByComparator)
		throws NoSuchBoardException {

		Board board = fetchByboardTitle_First(boardTitle, orderByComparator);

		if (board != null) {
			return board;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("boardTitleLIKE");
		sb.append(boardTitle);

		sb.append("}");

		throw new NoSuchBoardException(sb.toString());
	}

	/**
	 * Returns the first board in the ordered set where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching board, or <code>null</code> if a matching board could not be found
	 */
	@Override
	public Board fetchByboardTitle_First(
		String boardTitle, OrderByComparator<Board> orderByComparator) {

		List<Board> list = findByboardTitle(
			boardTitle, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last board in the ordered set where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching board
	 * @throws NoSuchBoardException if a matching board could not be found
	 */
	@Override
	public Board findByboardTitle_Last(
			String boardTitle, OrderByComparator<Board> orderByComparator)
		throws NoSuchBoardException {

		Board board = fetchByboardTitle_Last(boardTitle, orderByComparator);

		if (board != null) {
			return board;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("boardTitleLIKE");
		sb.append(boardTitle);

		sb.append("}");

		throw new NoSuchBoardException(sb.toString());
	}

	/**
	 * Returns the last board in the ordered set where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching board, or <code>null</code> if a matching board could not be found
	 */
	@Override
	public Board fetchByboardTitle_Last(
		String boardTitle, OrderByComparator<Board> orderByComparator) {

		int count = countByboardTitle(boardTitle);

		if (count == 0) {
			return null;
		}

		List<Board> list = findByboardTitle(
			boardTitle, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Board[] findByboardTitle_PrevAndNext(
			long boardNo, String boardTitle,
			OrderByComparator<Board> orderByComparator)
		throws NoSuchBoardException {

		boardTitle = Objects.toString(boardTitle, "");

		Board board = findByPrimaryKey(boardNo);

		Session session = null;

		try {
			session = openSession();

			Board[] array = new BoardImpl[3];

			array[0] = getByboardTitle_PrevAndNext(
				session, board, boardTitle, orderByComparator, true);

			array[1] = board;

			array[2] = getByboardTitle_PrevAndNext(
				session, board, boardTitle, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Board getByboardTitle_PrevAndNext(
		Session session, Board board, String boardTitle,
		OrderByComparator<Board> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOARD_WHERE);

		boolean bindBoardTitle = false;

		if (boardTitle.isEmpty()) {
			sb.append(_FINDER_COLUMN_BOARDTITLE_BOARDTITLE_3);
		}
		else {
			bindBoardTitle = true;

			sb.append(_FINDER_COLUMN_BOARDTITLE_BOARDTITLE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BoardModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindBoardTitle) {
			queryPos.add(boardTitle);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(board)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Board> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the boards where boardTitle LIKE &#63; from the database.
	 *
	 * @param boardTitle the board title
	 */
	@Override
	public void removeByboardTitle(String boardTitle) {
		for (Board board :
				findByboardTitle(
					boardTitle, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(board);
		}
	}

	/**
	 * Returns the number of boards where boardTitle LIKE &#63;.
	 *
	 * @param boardTitle the board title
	 * @return the number of matching boards
	 */
	@Override
	public int countByboardTitle(String boardTitle) {
		boardTitle = Objects.toString(boardTitle, "");

		FinderPath finderPath = _finderPathWithPaginationCountByboardTitle;

		Object[] finderArgs = new Object[] {boardTitle};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOARD_WHERE);

			boolean bindBoardTitle = false;

			if (boardTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_BOARDTITLE_BOARDTITLE_3);
			}
			else {
				bindBoardTitle = true;

				sb.append(_FINDER_COLUMN_BOARDTITLE_BOARDTITLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBoardTitle) {
					queryPos.add(boardTitle);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BOARDTITLE_BOARDTITLE_2 =
		"board.boardTitle LIKE ?";

	private static final String _FINDER_COLUMN_BOARDTITLE_BOARDTITLE_3 =
		"(board.boardTitle IS NULL OR board.boardTitle LIKE '')";

	public BoardPersistenceImpl() {
		setModelClass(Board.class);

		setModelImplClass(BoardImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the board in the entity cache if it is enabled.
	 *
	 * @param board the board
	 */
	@Override
	public void cacheResult(Board board) {
		entityCache.putResult(
			entityCacheEnabled, BoardImpl.class, board.getPrimaryKey(), board);

		board.resetOriginalValues();
	}

	/**
	 * Caches the boards in the entity cache if it is enabled.
	 *
	 * @param boards the boards
	 */
	@Override
	public void cacheResult(List<Board> boards) {
		for (Board board : boards) {
			if (entityCache.getResult(
					entityCacheEnabled, BoardImpl.class,
					board.getPrimaryKey()) == null) {

				cacheResult(board);
			}
			else {
				board.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all boards.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BoardImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the board.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Board board) {
		entityCache.removeResult(
			entityCacheEnabled, BoardImpl.class, board.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Board> boards) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Board board : boards) {
			entityCache.removeResult(
				entityCacheEnabled, BoardImpl.class, board.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, BoardImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new board with the primary key. Does not add the board to the database.
	 *
	 * @param boardNo the primary key for the new board
	 * @return the new board
	 */
	@Override
	public Board create(long boardNo) {
		Board board = new BoardImpl();

		board.setNew(true);
		board.setPrimaryKey(boardNo);

		return board;
	}

	/**
	 * Removes the board with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param boardNo the primary key of the board
	 * @return the board that was removed
	 * @throws NoSuchBoardException if a board with the primary key could not be found
	 */
	@Override
	public Board remove(long boardNo) throws NoSuchBoardException {
		return remove((Serializable)boardNo);
	}

	/**
	 * Removes the board with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the board
	 * @return the board that was removed
	 * @throws NoSuchBoardException if a board with the primary key could not be found
	 */
	@Override
	public Board remove(Serializable primaryKey) throws NoSuchBoardException {
		Session session = null;

		try {
			session = openSession();

			Board board = (Board)session.get(BoardImpl.class, primaryKey);

			if (board == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBoardException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(board);
		}
		catch (NoSuchBoardException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Board removeImpl(Board board) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(board)) {
				board = (Board)session.get(
					BoardImpl.class, board.getPrimaryKeyObj());
			}

			if (board != null) {
				session.delete(board);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (board != null) {
			clearCache(board);
		}

		return board;
	}

	@Override
	public Board updateImpl(Board board) {
		boolean isNew = board.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(board);

				board.setNew(false);
			}
			else {
				board = (Board)session.merge(board);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, BoardImpl.class, board.getPrimaryKey(), board,
			false);

		board.resetOriginalValues();

		return board;
	}

	/**
	 * Returns the board with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the board
	 * @return the board
	 * @throws NoSuchBoardException if a board with the primary key could not be found
	 */
	@Override
	public Board findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBoardException {

		Board board = fetchByPrimaryKey(primaryKey);

		if (board == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBoardException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return board;
	}

	/**
	 * Returns the board with the primary key or throws a <code>NoSuchBoardException</code> if it could not be found.
	 *
	 * @param boardNo the primary key of the board
	 * @return the board
	 * @throws NoSuchBoardException if a board with the primary key could not be found
	 */
	@Override
	public Board findByPrimaryKey(long boardNo) throws NoSuchBoardException {
		return findByPrimaryKey((Serializable)boardNo);
	}

	/**
	 * Returns the board with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param boardNo the primary key of the board
	 * @return the board, or <code>null</code> if a board with the primary key could not be found
	 */
	@Override
	public Board fetchByPrimaryKey(long boardNo) {
		return fetchByPrimaryKey((Serializable)boardNo);
	}

	/**
	 * Returns all the boards.
	 *
	 * @return the boards
	 */
	@Override
	public List<Board> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Board> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Board> findAll(
		int start, int end, OrderByComparator<Board> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Board> findAll(
		int start, int end, OrderByComparator<Board> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Board> list = null;

		if (useFinderCache) {
			list = (List<Board>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOARD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOARD;

				sql = sql.concat(BoardModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Board>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the boards from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Board board : findAll()) {
			remove(board);
		}
	}

	/**
	 * Returns the number of boards.
	 *
	 * @return the number of boards
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BOARD);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "boardNo";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BOARD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BoardModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the board persistence.
	 */
	@Activate
	public void activate() {
		BoardModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		BoardModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, BoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, BoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByboardTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, BoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByboardTitle",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByboardTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByboardTitle",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(BoardImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = SJKIMPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.sjkim.model.Board"),
			true);
	}

	@Override
	@Reference(
		target = SJKIMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SJKIMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BOARD =
		"SELECT board FROM Board board";

	private static final String _SQL_SELECT_BOARD_WHERE =
		"SELECT board FROM Board board WHERE ";

	private static final String _SQL_COUNT_BOARD =
		"SELECT COUNT(board) FROM Board board";

	private static final String _SQL_COUNT_BOARD_WHERE =
		"SELECT COUNT(board) FROM Board board WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "board.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Board exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Board exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BoardPersistenceImpl.class);

	static {
		try {
			Class.forName(SJKIMPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}