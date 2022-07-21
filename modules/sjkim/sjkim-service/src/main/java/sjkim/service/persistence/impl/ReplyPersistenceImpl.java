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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import sjkim.exception.NoSuchReplyException;

import sjkim.model.Reply;
import sjkim.model.impl.ReplyImpl;
import sjkim.model.impl.ReplyModelImpl;

import sjkim.service.persistence.ReplyPersistence;
import sjkim.service.persistence.impl.constants.SJKIMPersistenceConstants;

/**
 * The persistence implementation for the reply service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ReplyPersistence.class)
public class ReplyPersistenceImpl
	extends BasePersistenceImpl<Reply> implements ReplyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ReplyUtil</code> to access the reply persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ReplyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByreplyContent;
	private FinderPath _finderPathWithPaginationCountByreplyContent;

	/**
	 * Returns all the replies where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @return the matching replies
	 */
	@Override
	public List<Reply> findByreplyContent(String replyContent) {
		return findByreplyContent(
			replyContent, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the replies where replyContent LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReplyModelImpl</code>.
	 * </p>
	 *
	 * @param replyContent the reply content
	 * @param start the lower bound of the range of replies
	 * @param end the upper bound of the range of replies (not inclusive)
	 * @return the range of matching replies
	 */
	@Override
	public List<Reply> findByreplyContent(
		String replyContent, int start, int end) {

		return findByreplyContent(replyContent, start, end, null);
	}

	/**
	 * Returns an ordered range of all the replies where replyContent LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReplyModelImpl</code>.
	 * </p>
	 *
	 * @param replyContent the reply content
	 * @param start the lower bound of the range of replies
	 * @param end the upper bound of the range of replies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching replies
	 */
	@Override
	public List<Reply> findByreplyContent(
		String replyContent, int start, int end,
		OrderByComparator<Reply> orderByComparator) {

		return findByreplyContent(
			replyContent, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the replies where replyContent LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReplyModelImpl</code>.
	 * </p>
	 *
	 * @param replyContent the reply content
	 * @param start the lower bound of the range of replies
	 * @param end the upper bound of the range of replies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching replies
	 */
	@Override
	public List<Reply> findByreplyContent(
		String replyContent, int start, int end,
		OrderByComparator<Reply> orderByComparator, boolean useFinderCache) {

		replyContent = Objects.toString(replyContent, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByreplyContent;
		finderArgs = new Object[] {replyContent, start, end, orderByComparator};

		List<Reply> list = null;

		if (useFinderCache) {
			list = (List<Reply>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Reply reply : list) {
					if (!StringUtil.wildcardMatches(
							reply.getReplyContent(), replyContent, '_', '%',
							'\\', true)) {

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

			sb.append(_SQL_SELECT_REPLY_WHERE);

			boolean bindReplyContent = false;

			if (replyContent.isEmpty()) {
				sb.append(_FINDER_COLUMN_REPLYCONTENT_REPLYCONTENT_3);
			}
			else {
				bindReplyContent = true;

				sb.append(_FINDER_COLUMN_REPLYCONTENT_REPLYCONTENT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ReplyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindReplyContent) {
					queryPos.add(replyContent);
				}

				list = (List<Reply>)QueryUtil.list(
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
	 * Returns the first reply in the ordered set where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	@Override
	public Reply findByreplyContent_First(
			String replyContent, OrderByComparator<Reply> orderByComparator)
		throws NoSuchReplyException {

		Reply reply = fetchByreplyContent_First(
			replyContent, orderByComparator);

		if (reply != null) {
			return reply;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("replyContentLIKE");
		sb.append(replyContent);

		sb.append("}");

		throw new NoSuchReplyException(sb.toString());
	}

	/**
	 * Returns the first reply in the ordered set where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply, or <code>null</code> if a matching reply could not be found
	 */
	@Override
	public Reply fetchByreplyContent_First(
		String replyContent, OrderByComparator<Reply> orderByComparator) {

		List<Reply> list = findByreplyContent(
			replyContent, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last reply in the ordered set where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	@Override
	public Reply findByreplyContent_Last(
			String replyContent, OrderByComparator<Reply> orderByComparator)
		throws NoSuchReplyException {

		Reply reply = fetchByreplyContent_Last(replyContent, orderByComparator);

		if (reply != null) {
			return reply;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("replyContentLIKE");
		sb.append(replyContent);

		sb.append("}");

		throw new NoSuchReplyException(sb.toString());
	}

	/**
	 * Returns the last reply in the ordered set where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply, or <code>null</code> if a matching reply could not be found
	 */
	@Override
	public Reply fetchByreplyContent_Last(
		String replyContent, OrderByComparator<Reply> orderByComparator) {

		int count = countByreplyContent(replyContent);

		if (count == 0) {
			return null;
		}

		List<Reply> list = findByreplyContent(
			replyContent, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the replies before and after the current reply in the ordered set where replyContent LIKE &#63;.
	 *
	 * @param replyNo the primary key of the current reply
	 * @param replyContent the reply content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reply
	 * @throws NoSuchReplyException if a reply with the primary key could not be found
	 */
	@Override
	public Reply[] findByreplyContent_PrevAndNext(
			long replyNo, String replyContent,
			OrderByComparator<Reply> orderByComparator)
		throws NoSuchReplyException {

		replyContent = Objects.toString(replyContent, "");

		Reply reply = findByPrimaryKey(replyNo);

		Session session = null;

		try {
			session = openSession();

			Reply[] array = new ReplyImpl[3];

			array[0] = getByreplyContent_PrevAndNext(
				session, reply, replyContent, orderByComparator, true);

			array[1] = reply;

			array[2] = getByreplyContent_PrevAndNext(
				session, reply, replyContent, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Reply getByreplyContent_PrevAndNext(
		Session session, Reply reply, String replyContent,
		OrderByComparator<Reply> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_REPLY_WHERE);

		boolean bindReplyContent = false;

		if (replyContent.isEmpty()) {
			sb.append(_FINDER_COLUMN_REPLYCONTENT_REPLYCONTENT_3);
		}
		else {
			bindReplyContent = true;

			sb.append(_FINDER_COLUMN_REPLYCONTENT_REPLYCONTENT_2);
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
			sb.append(ReplyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindReplyContent) {
			queryPos.add(replyContent);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(reply)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Reply> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the replies where replyContent LIKE &#63; from the database.
	 *
	 * @param replyContent the reply content
	 */
	@Override
	public void removeByreplyContent(String replyContent) {
		for (Reply reply :
				findByreplyContent(
					replyContent, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(reply);
		}
	}

	/**
	 * Returns the number of replies where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @return the number of matching replies
	 */
	@Override
	public int countByreplyContent(String replyContent) {
		replyContent = Objects.toString(replyContent, "");

		FinderPath finderPath = _finderPathWithPaginationCountByreplyContent;

		Object[] finderArgs = new Object[] {replyContent};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REPLY_WHERE);

			boolean bindReplyContent = false;

			if (replyContent.isEmpty()) {
				sb.append(_FINDER_COLUMN_REPLYCONTENT_REPLYCONTENT_3);
			}
			else {
				bindReplyContent = true;

				sb.append(_FINDER_COLUMN_REPLYCONTENT_REPLYCONTENT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindReplyContent) {
					queryPos.add(replyContent);
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

	private static final String _FINDER_COLUMN_REPLYCONTENT_REPLYCONTENT_2 =
		"reply.replyContent LIKE ?";

	private static final String _FINDER_COLUMN_REPLYCONTENT_REPLYCONTENT_3 =
		"(reply.replyContent IS NULL OR reply.replyContent LIKE '')";

	private FinderPath _finderPathWithPaginationFindByboardNo;
	private FinderPath _finderPathWithoutPaginationFindByboardNo;
	private FinderPath _finderPathCountByboardNo;

	/**
	 * Returns all the replies where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @return the matching replies
	 */
	@Override
	public List<Reply> findByboardNo(long boardNo) {
		return findByboardNo(
			boardNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the replies where boardNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReplyModelImpl</code>.
	 * </p>
	 *
	 * @param boardNo the board no
	 * @param start the lower bound of the range of replies
	 * @param end the upper bound of the range of replies (not inclusive)
	 * @return the range of matching replies
	 */
	@Override
	public List<Reply> findByboardNo(long boardNo, int start, int end) {
		return findByboardNo(boardNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the replies where boardNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReplyModelImpl</code>.
	 * </p>
	 *
	 * @param boardNo the board no
	 * @param start the lower bound of the range of replies
	 * @param end the upper bound of the range of replies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching replies
	 */
	@Override
	public List<Reply> findByboardNo(
		long boardNo, int start, int end,
		OrderByComparator<Reply> orderByComparator) {

		return findByboardNo(boardNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the replies where boardNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReplyModelImpl</code>.
	 * </p>
	 *
	 * @param boardNo the board no
	 * @param start the lower bound of the range of replies
	 * @param end the upper bound of the range of replies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching replies
	 */
	@Override
	public List<Reply> findByboardNo(
		long boardNo, int start, int end,
		OrderByComparator<Reply> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByboardNo;
				finderArgs = new Object[] {boardNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByboardNo;
			finderArgs = new Object[] {boardNo, start, end, orderByComparator};
		}

		List<Reply> list = null;

		if (useFinderCache) {
			list = (List<Reply>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Reply reply : list) {
					if (boardNo != reply.getBoardNo()) {
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

			sb.append(_SQL_SELECT_REPLY_WHERE);

			sb.append(_FINDER_COLUMN_BOARDNO_BOARDNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ReplyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(boardNo);

				list = (List<Reply>)QueryUtil.list(
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
	 * Returns the first reply in the ordered set where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	@Override
	public Reply findByboardNo_First(
			long boardNo, OrderByComparator<Reply> orderByComparator)
		throws NoSuchReplyException {

		Reply reply = fetchByboardNo_First(boardNo, orderByComparator);

		if (reply != null) {
			return reply;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("boardNo=");
		sb.append(boardNo);

		sb.append("}");

		throw new NoSuchReplyException(sb.toString());
	}

	/**
	 * Returns the first reply in the ordered set where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply, or <code>null</code> if a matching reply could not be found
	 */
	@Override
	public Reply fetchByboardNo_First(
		long boardNo, OrderByComparator<Reply> orderByComparator) {

		List<Reply> list = findByboardNo(boardNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last reply in the ordered set where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	@Override
	public Reply findByboardNo_Last(
			long boardNo, OrderByComparator<Reply> orderByComparator)
		throws NoSuchReplyException {

		Reply reply = fetchByboardNo_Last(boardNo, orderByComparator);

		if (reply != null) {
			return reply;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("boardNo=");
		sb.append(boardNo);

		sb.append("}");

		throw new NoSuchReplyException(sb.toString());
	}

	/**
	 * Returns the last reply in the ordered set where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply, or <code>null</code> if a matching reply could not be found
	 */
	@Override
	public Reply fetchByboardNo_Last(
		long boardNo, OrderByComparator<Reply> orderByComparator) {

		int count = countByboardNo(boardNo);

		if (count == 0) {
			return null;
		}

		List<Reply> list = findByboardNo(
			boardNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the replies before and after the current reply in the ordered set where boardNo = &#63;.
	 *
	 * @param replyNo the primary key of the current reply
	 * @param boardNo the board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reply
	 * @throws NoSuchReplyException if a reply with the primary key could not be found
	 */
	@Override
	public Reply[] findByboardNo_PrevAndNext(
			long replyNo, long boardNo,
			OrderByComparator<Reply> orderByComparator)
		throws NoSuchReplyException {

		Reply reply = findByPrimaryKey(replyNo);

		Session session = null;

		try {
			session = openSession();

			Reply[] array = new ReplyImpl[3];

			array[0] = getByboardNo_PrevAndNext(
				session, reply, boardNo, orderByComparator, true);

			array[1] = reply;

			array[2] = getByboardNo_PrevAndNext(
				session, reply, boardNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Reply getByboardNo_PrevAndNext(
		Session session, Reply reply, long boardNo,
		OrderByComparator<Reply> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_REPLY_WHERE);

		sb.append(_FINDER_COLUMN_BOARDNO_BOARDNO_2);

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
			sb.append(ReplyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(boardNo);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(reply)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Reply> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the replies where boardNo = &#63; from the database.
	 *
	 * @param boardNo the board no
	 */
	@Override
	public void removeByboardNo(long boardNo) {
		for (Reply reply :
				findByboardNo(
					boardNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(reply);
		}
	}

	/**
	 * Returns the number of replies where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @return the number of matching replies
	 */
	@Override
	public int countByboardNo(long boardNo) {
		FinderPath finderPath = _finderPathCountByboardNo;

		Object[] finderArgs = new Object[] {boardNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REPLY_WHERE);

			sb.append(_FINDER_COLUMN_BOARDNO_BOARDNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(boardNo);

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

	private static final String _FINDER_COLUMN_BOARDNO_BOARDNO_2 =
		"reply.boardNo = ?";

	private FinderPath _finderPathWithPaginationFindByreplyLevelList;
	private FinderPath _finderPathWithoutPaginationFindByreplyLevelList;
	private FinderPath _finderPathCountByreplyLevelList;

	/**
	 * Returns all the replies where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @return the matching replies
	 */
	@Override
	public List<Reply> findByreplyLevelList(long boardNo, Long replyLevel) {
		return findByreplyLevelList(
			boardNo, replyLevel, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the replies where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReplyModelImpl</code>.
	 * </p>
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @param start the lower bound of the range of replies
	 * @param end the upper bound of the range of replies (not inclusive)
	 * @return the range of matching replies
	 */
	@Override
	public List<Reply> findByreplyLevelList(
		long boardNo, Long replyLevel, int start, int end) {

		return findByreplyLevelList(boardNo, replyLevel, start, end, null);
	}

	/**
	 * Returns an ordered range of all the replies where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReplyModelImpl</code>.
	 * </p>
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @param start the lower bound of the range of replies
	 * @param end the upper bound of the range of replies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching replies
	 */
	@Override
	public List<Reply> findByreplyLevelList(
		long boardNo, Long replyLevel, int start, int end,
		OrderByComparator<Reply> orderByComparator) {

		return findByreplyLevelList(
			boardNo, replyLevel, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the replies where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReplyModelImpl</code>.
	 * </p>
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @param start the lower bound of the range of replies
	 * @param end the upper bound of the range of replies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching replies
	 */
	@Override
	public List<Reply> findByreplyLevelList(
		long boardNo, Long replyLevel, int start, int end,
		OrderByComparator<Reply> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByreplyLevelList;
				finderArgs = new Object[] {boardNo, replyLevel};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByreplyLevelList;
			finderArgs = new Object[] {
				boardNo, replyLevel, start, end, orderByComparator
			};
		}

		List<Reply> list = null;

		if (useFinderCache) {
			list = (List<Reply>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Reply reply : list) {
					if ((boardNo != reply.getBoardNo()) ||
						!Objects.equals(replyLevel, reply.getReplyLevel())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_REPLY_WHERE);

			sb.append(_FINDER_COLUMN_REPLYLEVELLIST_BOARDNO_2);

			sb.append(_FINDER_COLUMN_REPLYLEVELLIST_REPLYLEVEL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ReplyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(boardNo);

				queryPos.add(replyLevel.longValue());

				list = (List<Reply>)QueryUtil.list(
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
	 * Returns the first reply in the ordered set where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	@Override
	public Reply findByreplyLevelList_First(
			long boardNo, Long replyLevel,
			OrderByComparator<Reply> orderByComparator)
		throws NoSuchReplyException {

		Reply reply = fetchByreplyLevelList_First(
			boardNo, replyLevel, orderByComparator);

		if (reply != null) {
			return reply;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("boardNo=");
		sb.append(boardNo);

		sb.append(", replyLevel=");
		sb.append(replyLevel);

		sb.append("}");

		throw new NoSuchReplyException(sb.toString());
	}

	/**
	 * Returns the first reply in the ordered set where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply, or <code>null</code> if a matching reply could not be found
	 */
	@Override
	public Reply fetchByreplyLevelList_First(
		long boardNo, Long replyLevel,
		OrderByComparator<Reply> orderByComparator) {

		List<Reply> list = findByreplyLevelList(
			boardNo, replyLevel, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last reply in the ordered set where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	@Override
	public Reply findByreplyLevelList_Last(
			long boardNo, Long replyLevel,
			OrderByComparator<Reply> orderByComparator)
		throws NoSuchReplyException {

		Reply reply = fetchByreplyLevelList_Last(
			boardNo, replyLevel, orderByComparator);

		if (reply != null) {
			return reply;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("boardNo=");
		sb.append(boardNo);

		sb.append(", replyLevel=");
		sb.append(replyLevel);

		sb.append("}");

		throw new NoSuchReplyException(sb.toString());
	}

	/**
	 * Returns the last reply in the ordered set where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply, or <code>null</code> if a matching reply could not be found
	 */
	@Override
	public Reply fetchByreplyLevelList_Last(
		long boardNo, Long replyLevel,
		OrderByComparator<Reply> orderByComparator) {

		int count = countByreplyLevelList(boardNo, replyLevel);

		if (count == 0) {
			return null;
		}

		List<Reply> list = findByreplyLevelList(
			boardNo, replyLevel, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the replies before and after the current reply in the ordered set where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param replyNo the primary key of the current reply
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reply
	 * @throws NoSuchReplyException if a reply with the primary key could not be found
	 */
	@Override
	public Reply[] findByreplyLevelList_PrevAndNext(
			long replyNo, long boardNo, Long replyLevel,
			OrderByComparator<Reply> orderByComparator)
		throws NoSuchReplyException {

		Reply reply = findByPrimaryKey(replyNo);

		Session session = null;

		try {
			session = openSession();

			Reply[] array = new ReplyImpl[3];

			array[0] = getByreplyLevelList_PrevAndNext(
				session, reply, boardNo, replyLevel, orderByComparator, true);

			array[1] = reply;

			array[2] = getByreplyLevelList_PrevAndNext(
				session, reply, boardNo, replyLevel, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Reply getByreplyLevelList_PrevAndNext(
		Session session, Reply reply, long boardNo, Long replyLevel,
		OrderByComparator<Reply> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_REPLY_WHERE);

		sb.append(_FINDER_COLUMN_REPLYLEVELLIST_BOARDNO_2);

		sb.append(_FINDER_COLUMN_REPLYLEVELLIST_REPLYLEVEL_2);

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
			sb.append(ReplyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(boardNo);

		queryPos.add(replyLevel.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(reply)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Reply> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the replies where boardNo = &#63; and replyLevel = &#63; from the database.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 */
	@Override
	public void removeByreplyLevelList(long boardNo, Long replyLevel) {
		for (Reply reply :
				findByreplyLevelList(
					boardNo, replyLevel, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(reply);
		}
	}

	/**
	 * Returns the number of replies where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @return the number of matching replies
	 */
	@Override
	public int countByreplyLevelList(long boardNo, Long replyLevel) {
		FinderPath finderPath = _finderPathCountByreplyLevelList;

		Object[] finderArgs = new Object[] {boardNo, replyLevel};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_REPLY_WHERE);

			sb.append(_FINDER_COLUMN_REPLYLEVELLIST_BOARDNO_2);

			sb.append(_FINDER_COLUMN_REPLYLEVELLIST_REPLYLEVEL_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(boardNo);

				queryPos.add(replyLevel.longValue());

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

	private static final String _FINDER_COLUMN_REPLYLEVELLIST_BOARDNO_2 =
		"reply.boardNo = ? AND ";

	private static final String _FINDER_COLUMN_REPLYLEVELLIST_REPLYLEVEL_2 =
		"reply.replyLevel = ?";

	public ReplyPersistenceImpl() {
		setModelClass(Reply.class);

		setModelImplClass(ReplyImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the reply in the entity cache if it is enabled.
	 *
	 * @param reply the reply
	 */
	@Override
	public void cacheResult(Reply reply) {
		entityCache.putResult(
			entityCacheEnabled, ReplyImpl.class, reply.getPrimaryKey(), reply);

		reply.resetOriginalValues();
	}

	/**
	 * Caches the replies in the entity cache if it is enabled.
	 *
	 * @param replies the replies
	 */
	@Override
	public void cacheResult(List<Reply> replies) {
		for (Reply reply : replies) {
			if (entityCache.getResult(
					entityCacheEnabled, ReplyImpl.class,
					reply.getPrimaryKey()) == null) {

				cacheResult(reply);
			}
			else {
				reply.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all replies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ReplyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the reply.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Reply reply) {
		entityCache.removeResult(
			entityCacheEnabled, ReplyImpl.class, reply.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Reply> replies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Reply reply : replies) {
			entityCache.removeResult(
				entityCacheEnabled, ReplyImpl.class, reply.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ReplyImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new reply with the primary key. Does not add the reply to the database.
	 *
	 * @param replyNo the primary key for the new reply
	 * @return the new reply
	 */
	@Override
	public Reply create(long replyNo) {
		Reply reply = new ReplyImpl();

		reply.setNew(true);
		reply.setPrimaryKey(replyNo);

		return reply;
	}

	/**
	 * Removes the reply with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param replyNo the primary key of the reply
	 * @return the reply that was removed
	 * @throws NoSuchReplyException if a reply with the primary key could not be found
	 */
	@Override
	public Reply remove(long replyNo) throws NoSuchReplyException {
		return remove((Serializable)replyNo);
	}

	/**
	 * Removes the reply with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the reply
	 * @return the reply that was removed
	 * @throws NoSuchReplyException if a reply with the primary key could not be found
	 */
	@Override
	public Reply remove(Serializable primaryKey) throws NoSuchReplyException {
		Session session = null;

		try {
			session = openSession();

			Reply reply = (Reply)session.get(ReplyImpl.class, primaryKey);

			if (reply == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReplyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(reply);
		}
		catch (NoSuchReplyException noSuchEntityException) {
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
	protected Reply removeImpl(Reply reply) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(reply)) {
				reply = (Reply)session.get(
					ReplyImpl.class, reply.getPrimaryKeyObj());
			}

			if (reply != null) {
				session.delete(reply);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (reply != null) {
			clearCache(reply);
		}

		return reply;
	}

	@Override
	public Reply updateImpl(Reply reply) {
		boolean isNew = reply.isNew();

		if (!(reply instanceof ReplyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(reply.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(reply);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in reply proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Reply implementation " +
					reply.getClass());
		}

		ReplyModelImpl replyModelImpl = (ReplyModelImpl)reply;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(reply);

				reply.setNew(false);
			}
			else {
				reply = (Reply)session.merge(reply);
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
			Object[] args = new Object[] {replyModelImpl.getBoardNo()};

			finderCache.removeResult(_finderPathCountByboardNo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByboardNo, args);

			args = new Object[] {
				replyModelImpl.getBoardNo(), replyModelImpl.getReplyLevel()
			};

			finderCache.removeResult(_finderPathCountByreplyLevelList, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByreplyLevelList, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((replyModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByboardNo.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					replyModelImpl.getOriginalBoardNo()
				};

				finderCache.removeResult(_finderPathCountByboardNo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByboardNo, args);

				args = new Object[] {replyModelImpl.getBoardNo()};

				finderCache.removeResult(_finderPathCountByboardNo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByboardNo, args);
			}

			if ((replyModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByreplyLevelList.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					replyModelImpl.getOriginalBoardNo(),
					replyModelImpl.getOriginalReplyLevel()
				};

				finderCache.removeResult(
					_finderPathCountByreplyLevelList, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByreplyLevelList, args);

				args = new Object[] {
					replyModelImpl.getBoardNo(), replyModelImpl.getReplyLevel()
				};

				finderCache.removeResult(
					_finderPathCountByreplyLevelList, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByreplyLevelList, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ReplyImpl.class, reply.getPrimaryKey(), reply,
			false);

		reply.resetOriginalValues();

		return reply;
	}

	/**
	 * Returns the reply with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the reply
	 * @return the reply
	 * @throws NoSuchReplyException if a reply with the primary key could not be found
	 */
	@Override
	public Reply findByPrimaryKey(Serializable primaryKey)
		throws NoSuchReplyException {

		Reply reply = fetchByPrimaryKey(primaryKey);

		if (reply == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchReplyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return reply;
	}

	/**
	 * Returns the reply with the primary key or throws a <code>NoSuchReplyException</code> if it could not be found.
	 *
	 * @param replyNo the primary key of the reply
	 * @return the reply
	 * @throws NoSuchReplyException if a reply with the primary key could not be found
	 */
	@Override
	public Reply findByPrimaryKey(long replyNo) throws NoSuchReplyException {
		return findByPrimaryKey((Serializable)replyNo);
	}

	/**
	 * Returns the reply with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param replyNo the primary key of the reply
	 * @return the reply, or <code>null</code> if a reply with the primary key could not be found
	 */
	@Override
	public Reply fetchByPrimaryKey(long replyNo) {
		return fetchByPrimaryKey((Serializable)replyNo);
	}

	/**
	 * Returns all the replies.
	 *
	 * @return the replies
	 */
	@Override
	public List<Reply> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the replies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReplyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of replies
	 * @param end the upper bound of the range of replies (not inclusive)
	 * @return the range of replies
	 */
	@Override
	public List<Reply> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the replies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReplyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of replies
	 * @param end the upper bound of the range of replies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of replies
	 */
	@Override
	public List<Reply> findAll(
		int start, int end, OrderByComparator<Reply> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the replies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReplyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of replies
	 * @param end the upper bound of the range of replies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of replies
	 */
	@Override
	public List<Reply> findAll(
		int start, int end, OrderByComparator<Reply> orderByComparator,
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

		List<Reply> list = null;

		if (useFinderCache) {
			list = (List<Reply>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_REPLY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_REPLY;

				sql = sql.concat(ReplyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Reply>)QueryUtil.list(
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
	 * Removes all the replies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Reply reply : findAll()) {
			remove(reply);
		}
	}

	/**
	 * Returns the number of replies.
	 *
	 * @return the number of replies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_REPLY);

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
		return "replyNo";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_REPLY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ReplyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the reply persistence.
	 */
	@Activate
	public void activate() {
		ReplyModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ReplyModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByreplyContent = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByreplyContent",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByreplyContent = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByreplyContent",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByboardNo = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByboardNo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByboardNo = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByboardNo",
			new String[] {Long.class.getName()},
			ReplyModelImpl.BOARDNO_COLUMN_BITMASK);

		_finderPathCountByboardNo = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByboardNo",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByreplyLevelList = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByreplyLevelList",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByreplyLevelList = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ReplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByreplyLevelList",
			new String[] {Long.class.getName(), Long.class.getName()},
			ReplyModelImpl.BOARDNO_COLUMN_BITMASK |
			ReplyModelImpl.REPLYLEVEL_COLUMN_BITMASK);

		_finderPathCountByreplyLevelList = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByreplyLevelList",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ReplyImpl.class.getName());

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
				"value.object.column.bitmask.enabled.sjkim.model.Reply"),
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

	private static final String _SQL_SELECT_REPLY =
		"SELECT reply FROM Reply reply";

	private static final String _SQL_SELECT_REPLY_WHERE =
		"SELECT reply FROM Reply reply WHERE ";

	private static final String _SQL_COUNT_REPLY =
		"SELECT COUNT(reply) FROM Reply reply";

	private static final String _SQL_COUNT_REPLY_WHERE =
		"SELECT COUNT(reply) FROM Reply reply WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "reply.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Reply exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Reply exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ReplyPersistenceImpl.class);

	static {
		try {
			Class.forName(SJKIMPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}