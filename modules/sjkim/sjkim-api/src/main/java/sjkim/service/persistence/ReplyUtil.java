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

import sjkim.model.Reply;

/**
 * The persistence utility for the reply service. This utility wraps <code>sjkim.service.persistence.impl.ReplyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReplyPersistence
 * @generated
 */
public class ReplyUtil {

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
	public static void clearCache(Reply reply) {
		getPersistence().clearCache(reply);
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
	public static Map<Serializable, Reply> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Reply> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Reply> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Reply> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Reply> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Reply update(Reply reply) {
		return getPersistence().update(reply);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Reply update(Reply reply, ServiceContext serviceContext) {
		return getPersistence().update(reply, serviceContext);
	}

	/**
	 * Returns all the replies where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @return the matching replies
	 */
	public static List<Reply> findByreplyContent(String replyContent) {
		return getPersistence().findByreplyContent(replyContent);
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
	public static List<Reply> findByreplyContent(
		String replyContent, int start, int end) {

		return getPersistence().findByreplyContent(replyContent, start, end);
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
	public static List<Reply> findByreplyContent(
		String replyContent, int start, int end,
		OrderByComparator<Reply> orderByComparator) {

		return getPersistence().findByreplyContent(
			replyContent, start, end, orderByComparator);
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
	public static List<Reply> findByreplyContent(
		String replyContent, int start, int end,
		OrderByComparator<Reply> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByreplyContent(
			replyContent, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first reply in the ordered set where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	public static Reply findByreplyContent_First(
			String replyContent, OrderByComparator<Reply> orderByComparator)
		throws sjkim.exception.NoSuchReplyException {

		return getPersistence().findByreplyContent_First(
			replyContent, orderByComparator);
	}

	/**
	 * Returns the first reply in the ordered set where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply, or <code>null</code> if a matching reply could not be found
	 */
	public static Reply fetchByreplyContent_First(
		String replyContent, OrderByComparator<Reply> orderByComparator) {

		return getPersistence().fetchByreplyContent_First(
			replyContent, orderByComparator);
	}

	/**
	 * Returns the last reply in the ordered set where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	public static Reply findByreplyContent_Last(
			String replyContent, OrderByComparator<Reply> orderByComparator)
		throws sjkim.exception.NoSuchReplyException {

		return getPersistence().findByreplyContent_Last(
			replyContent, orderByComparator);
	}

	/**
	 * Returns the last reply in the ordered set where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply, or <code>null</code> if a matching reply could not be found
	 */
	public static Reply fetchByreplyContent_Last(
		String replyContent, OrderByComparator<Reply> orderByComparator) {

		return getPersistence().fetchByreplyContent_Last(
			replyContent, orderByComparator);
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
	public static Reply[] findByreplyContent_PrevAndNext(
			long replyNo, String replyContent,
			OrderByComparator<Reply> orderByComparator)
		throws sjkim.exception.NoSuchReplyException {

		return getPersistence().findByreplyContent_PrevAndNext(
			replyNo, replyContent, orderByComparator);
	}

	/**
	 * Removes all the replies where replyContent LIKE &#63; from the database.
	 *
	 * @param replyContent the reply content
	 */
	public static void removeByreplyContent(String replyContent) {
		getPersistence().removeByreplyContent(replyContent);
	}

	/**
	 * Returns the number of replies where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @return the number of matching replies
	 */
	public static int countByreplyContent(String replyContent) {
		return getPersistence().countByreplyContent(replyContent);
	}

	/**
	 * Returns all the replies where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @return the matching replies
	 */
	public static List<Reply> findByboardNo(long boardNo) {
		return getPersistence().findByboardNo(boardNo);
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
	public static List<Reply> findByboardNo(long boardNo, int start, int end) {
		return getPersistence().findByboardNo(boardNo, start, end);
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
	public static List<Reply> findByboardNo(
		long boardNo, int start, int end,
		OrderByComparator<Reply> orderByComparator) {

		return getPersistence().findByboardNo(
			boardNo, start, end, orderByComparator);
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
	public static List<Reply> findByboardNo(
		long boardNo, int start, int end,
		OrderByComparator<Reply> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByboardNo(
			boardNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first reply in the ordered set where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	public static Reply findByboardNo_First(
			long boardNo, OrderByComparator<Reply> orderByComparator)
		throws sjkim.exception.NoSuchReplyException {

		return getPersistence().findByboardNo_First(boardNo, orderByComparator);
	}

	/**
	 * Returns the first reply in the ordered set where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply, or <code>null</code> if a matching reply could not be found
	 */
	public static Reply fetchByboardNo_First(
		long boardNo, OrderByComparator<Reply> orderByComparator) {

		return getPersistence().fetchByboardNo_First(
			boardNo, orderByComparator);
	}

	/**
	 * Returns the last reply in the ordered set where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	public static Reply findByboardNo_Last(
			long boardNo, OrderByComparator<Reply> orderByComparator)
		throws sjkim.exception.NoSuchReplyException {

		return getPersistence().findByboardNo_Last(boardNo, orderByComparator);
	}

	/**
	 * Returns the last reply in the ordered set where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply, or <code>null</code> if a matching reply could not be found
	 */
	public static Reply fetchByboardNo_Last(
		long boardNo, OrderByComparator<Reply> orderByComparator) {

		return getPersistence().fetchByboardNo_Last(boardNo, orderByComparator);
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
	public static Reply[] findByboardNo_PrevAndNext(
			long replyNo, long boardNo,
			OrderByComparator<Reply> orderByComparator)
		throws sjkim.exception.NoSuchReplyException {

		return getPersistence().findByboardNo_PrevAndNext(
			replyNo, boardNo, orderByComparator);
	}

	/**
	 * Removes all the replies where boardNo = &#63; from the database.
	 *
	 * @param boardNo the board no
	 */
	public static void removeByboardNo(long boardNo) {
		getPersistence().removeByboardNo(boardNo);
	}

	/**
	 * Returns the number of replies where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @return the number of matching replies
	 */
	public static int countByboardNo(long boardNo) {
		return getPersistence().countByboardNo(boardNo);
	}

	/**
	 * Returns all the replies where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @return the matching replies
	 */
	public static List<Reply> findByreplyLevelList(
		long boardNo, Long replyLevel) {

		return getPersistence().findByreplyLevelList(boardNo, replyLevel);
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
	public static List<Reply> findByreplyLevelList(
		long boardNo, Long replyLevel, int start, int end) {

		return getPersistence().findByreplyLevelList(
			boardNo, replyLevel, start, end);
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
	public static List<Reply> findByreplyLevelList(
		long boardNo, Long replyLevel, int start, int end,
		OrderByComparator<Reply> orderByComparator) {

		return getPersistence().findByreplyLevelList(
			boardNo, replyLevel, start, end, orderByComparator);
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
	public static List<Reply> findByreplyLevelList(
		long boardNo, Long replyLevel, int start, int end,
		OrderByComparator<Reply> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByreplyLevelList(
			boardNo, replyLevel, start, end, orderByComparator, useFinderCache);
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
	public static Reply findByreplyLevelList_First(
			long boardNo, Long replyLevel,
			OrderByComparator<Reply> orderByComparator)
		throws sjkim.exception.NoSuchReplyException {

		return getPersistence().findByreplyLevelList_First(
			boardNo, replyLevel, orderByComparator);
	}

	/**
	 * Returns the first reply in the ordered set where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply, or <code>null</code> if a matching reply could not be found
	 */
	public static Reply fetchByreplyLevelList_First(
		long boardNo, Long replyLevel,
		OrderByComparator<Reply> orderByComparator) {

		return getPersistence().fetchByreplyLevelList_First(
			boardNo, replyLevel, orderByComparator);
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
	public static Reply findByreplyLevelList_Last(
			long boardNo, Long replyLevel,
			OrderByComparator<Reply> orderByComparator)
		throws sjkim.exception.NoSuchReplyException {

		return getPersistence().findByreplyLevelList_Last(
			boardNo, replyLevel, orderByComparator);
	}

	/**
	 * Returns the last reply in the ordered set where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply, or <code>null</code> if a matching reply could not be found
	 */
	public static Reply fetchByreplyLevelList_Last(
		long boardNo, Long replyLevel,
		OrderByComparator<Reply> orderByComparator) {

		return getPersistence().fetchByreplyLevelList_Last(
			boardNo, replyLevel, orderByComparator);
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
	public static Reply[] findByreplyLevelList_PrevAndNext(
			long replyNo, long boardNo, Long replyLevel,
			OrderByComparator<Reply> orderByComparator)
		throws sjkim.exception.NoSuchReplyException {

		return getPersistence().findByreplyLevelList_PrevAndNext(
			replyNo, boardNo, replyLevel, orderByComparator);
	}

	/**
	 * Removes all the replies where boardNo = &#63; and replyLevel = &#63; from the database.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 */
	public static void removeByreplyLevelList(long boardNo, Long replyLevel) {
		getPersistence().removeByreplyLevelList(boardNo, replyLevel);
	}

	/**
	 * Returns the number of replies where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @return the number of matching replies
	 */
	public static int countByreplyLevelList(long boardNo, Long replyLevel) {
		return getPersistence().countByreplyLevelList(boardNo, replyLevel);
	}

	/**
	 * Caches the reply in the entity cache if it is enabled.
	 *
	 * @param reply the reply
	 */
	public static void cacheResult(Reply reply) {
		getPersistence().cacheResult(reply);
	}

	/**
	 * Caches the replies in the entity cache if it is enabled.
	 *
	 * @param replies the replies
	 */
	public static void cacheResult(List<Reply> replies) {
		getPersistence().cacheResult(replies);
	}

	/**
	 * Creates a new reply with the primary key. Does not add the reply to the database.
	 *
	 * @param replyNo the primary key for the new reply
	 * @return the new reply
	 */
	public static Reply create(long replyNo) {
		return getPersistence().create(replyNo);
	}

	/**
	 * Removes the reply with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param replyNo the primary key of the reply
	 * @return the reply that was removed
	 * @throws NoSuchReplyException if a reply with the primary key could not be found
	 */
	public static Reply remove(long replyNo)
		throws sjkim.exception.NoSuchReplyException {

		return getPersistence().remove(replyNo);
	}

	public static Reply updateImpl(Reply reply) {
		return getPersistence().updateImpl(reply);
	}

	/**
	 * Returns the reply with the primary key or throws a <code>NoSuchReplyException</code> if it could not be found.
	 *
	 * @param replyNo the primary key of the reply
	 * @return the reply
	 * @throws NoSuchReplyException if a reply with the primary key could not be found
	 */
	public static Reply findByPrimaryKey(long replyNo)
		throws sjkim.exception.NoSuchReplyException {

		return getPersistence().findByPrimaryKey(replyNo);
	}

	/**
	 * Returns the reply with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param replyNo the primary key of the reply
	 * @return the reply, or <code>null</code> if a reply with the primary key could not be found
	 */
	public static Reply fetchByPrimaryKey(long replyNo) {
		return getPersistence().fetchByPrimaryKey(replyNo);
	}

	/**
	 * Returns all the replies.
	 *
	 * @return the replies
	 */
	public static List<Reply> findAll() {
		return getPersistence().findAll();
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
	public static List<Reply> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Reply> findAll(
		int start, int end, OrderByComparator<Reply> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Reply> findAll(
		int start, int end, OrderByComparator<Reply> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the replies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of replies.
	 *
	 * @return the number of replies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ReplyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ReplyPersistence, ReplyPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ReplyPersistence.class);

		ServiceTracker<ReplyPersistence, ReplyPersistence> serviceTracker =
			new ServiceTracker<ReplyPersistence, ReplyPersistence>(
				bundle.getBundleContext(), ReplyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}