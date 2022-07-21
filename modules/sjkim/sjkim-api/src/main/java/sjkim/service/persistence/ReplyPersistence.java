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

import sjkim.exception.NoSuchReplyException;

import sjkim.model.Reply;

/**
 * The persistence interface for the reply service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReplyUtil
 * @generated
 */
@ProviderType
public interface ReplyPersistence extends BasePersistence<Reply> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReplyUtil} to access the reply persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the replies where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @return the matching replies
	 */
	public java.util.List<Reply> findByreplyContent(String replyContent);

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
	public java.util.List<Reply> findByreplyContent(
		String replyContent, int start, int end);

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
	public java.util.List<Reply> findByreplyContent(
		String replyContent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reply>
			orderByComparator);

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
	public java.util.List<Reply> findByreplyContent(
		String replyContent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reply>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first reply in the ordered set where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	public Reply findByreplyContent_First(
			String replyContent,
			com.liferay.portal.kernel.util.OrderByComparator<Reply>
				orderByComparator)
		throws NoSuchReplyException;

	/**
	 * Returns the first reply in the ordered set where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply, or <code>null</code> if a matching reply could not be found
	 */
	public Reply fetchByreplyContent_First(
		String replyContent,
		com.liferay.portal.kernel.util.OrderByComparator<Reply>
			orderByComparator);

	/**
	 * Returns the last reply in the ordered set where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	public Reply findByreplyContent_Last(
			String replyContent,
			com.liferay.portal.kernel.util.OrderByComparator<Reply>
				orderByComparator)
		throws NoSuchReplyException;

	/**
	 * Returns the last reply in the ordered set where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply, or <code>null</code> if a matching reply could not be found
	 */
	public Reply fetchByreplyContent_Last(
		String replyContent,
		com.liferay.portal.kernel.util.OrderByComparator<Reply>
			orderByComparator);

	/**
	 * Returns the replies before and after the current reply in the ordered set where replyContent LIKE &#63;.
	 *
	 * @param replyNo the primary key of the current reply
	 * @param replyContent the reply content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reply
	 * @throws NoSuchReplyException if a reply with the primary key could not be found
	 */
	public Reply[] findByreplyContent_PrevAndNext(
			long replyNo, String replyContent,
			com.liferay.portal.kernel.util.OrderByComparator<Reply>
				orderByComparator)
		throws NoSuchReplyException;

	/**
	 * Removes all the replies where replyContent LIKE &#63; from the database.
	 *
	 * @param replyContent the reply content
	 */
	public void removeByreplyContent(String replyContent);

	/**
	 * Returns the number of replies where replyContent LIKE &#63;.
	 *
	 * @param replyContent the reply content
	 * @return the number of matching replies
	 */
	public int countByreplyContent(String replyContent);

	/**
	 * Returns all the replies where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @return the matching replies
	 */
	public java.util.List<Reply> findByboardNo(long boardNo);

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
	public java.util.List<Reply> findByboardNo(
		long boardNo, int start, int end);

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
	public java.util.List<Reply> findByboardNo(
		long boardNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reply>
			orderByComparator);

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
	public java.util.List<Reply> findByboardNo(
		long boardNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reply>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first reply in the ordered set where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	public Reply findByboardNo_First(
			long boardNo,
			com.liferay.portal.kernel.util.OrderByComparator<Reply>
				orderByComparator)
		throws NoSuchReplyException;

	/**
	 * Returns the first reply in the ordered set where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply, or <code>null</code> if a matching reply could not be found
	 */
	public Reply fetchByboardNo_First(
		long boardNo,
		com.liferay.portal.kernel.util.OrderByComparator<Reply>
			orderByComparator);

	/**
	 * Returns the last reply in the ordered set where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	public Reply findByboardNo_Last(
			long boardNo,
			com.liferay.portal.kernel.util.OrderByComparator<Reply>
				orderByComparator)
		throws NoSuchReplyException;

	/**
	 * Returns the last reply in the ordered set where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply, or <code>null</code> if a matching reply could not be found
	 */
	public Reply fetchByboardNo_Last(
		long boardNo,
		com.liferay.portal.kernel.util.OrderByComparator<Reply>
			orderByComparator);

	/**
	 * Returns the replies before and after the current reply in the ordered set where boardNo = &#63;.
	 *
	 * @param replyNo the primary key of the current reply
	 * @param boardNo the board no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reply
	 * @throws NoSuchReplyException if a reply with the primary key could not be found
	 */
	public Reply[] findByboardNo_PrevAndNext(
			long replyNo, long boardNo,
			com.liferay.portal.kernel.util.OrderByComparator<Reply>
				orderByComparator)
		throws NoSuchReplyException;

	/**
	 * Removes all the replies where boardNo = &#63; from the database.
	 *
	 * @param boardNo the board no
	 */
	public void removeByboardNo(long boardNo);

	/**
	 * Returns the number of replies where boardNo = &#63;.
	 *
	 * @param boardNo the board no
	 * @return the number of matching replies
	 */
	public int countByboardNo(long boardNo);

	/**
	 * Returns all the replies where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @return the matching replies
	 */
	public java.util.List<Reply> findByreplyLevelList(
		long boardNo, Long replyLevel);

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
	public java.util.List<Reply> findByreplyLevelList(
		long boardNo, Long replyLevel, int start, int end);

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
	public java.util.List<Reply> findByreplyLevelList(
		long boardNo, Long replyLevel, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reply>
			orderByComparator);

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
	public java.util.List<Reply> findByreplyLevelList(
		long boardNo, Long replyLevel, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reply>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first reply in the ordered set where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	public Reply findByreplyLevelList_First(
			long boardNo, Long replyLevel,
			com.liferay.portal.kernel.util.OrderByComparator<Reply>
				orderByComparator)
		throws NoSuchReplyException;

	/**
	 * Returns the first reply in the ordered set where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reply, or <code>null</code> if a matching reply could not be found
	 */
	public Reply fetchByreplyLevelList_First(
		long boardNo, Long replyLevel,
		com.liferay.portal.kernel.util.OrderByComparator<Reply>
			orderByComparator);

	/**
	 * Returns the last reply in the ordered set where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply
	 * @throws NoSuchReplyException if a matching reply could not be found
	 */
	public Reply findByreplyLevelList_Last(
			long boardNo, Long replyLevel,
			com.liferay.portal.kernel.util.OrderByComparator<Reply>
				orderByComparator)
		throws NoSuchReplyException;

	/**
	 * Returns the last reply in the ordered set where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reply, or <code>null</code> if a matching reply could not be found
	 */
	public Reply fetchByreplyLevelList_Last(
		long boardNo, Long replyLevel,
		com.liferay.portal.kernel.util.OrderByComparator<Reply>
			orderByComparator);

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
	public Reply[] findByreplyLevelList_PrevAndNext(
			long replyNo, long boardNo, Long replyLevel,
			com.liferay.portal.kernel.util.OrderByComparator<Reply>
				orderByComparator)
		throws NoSuchReplyException;

	/**
	 * Removes all the replies where boardNo = &#63; and replyLevel = &#63; from the database.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 */
	public void removeByreplyLevelList(long boardNo, Long replyLevel);

	/**
	 * Returns the number of replies where boardNo = &#63; and replyLevel = &#63;.
	 *
	 * @param boardNo the board no
	 * @param replyLevel the reply level
	 * @return the number of matching replies
	 */
	public int countByreplyLevelList(long boardNo, Long replyLevel);

	/**
	 * Caches the reply in the entity cache if it is enabled.
	 *
	 * @param reply the reply
	 */
	public void cacheResult(Reply reply);

	/**
	 * Caches the replies in the entity cache if it is enabled.
	 *
	 * @param replies the replies
	 */
	public void cacheResult(java.util.List<Reply> replies);

	/**
	 * Creates a new reply with the primary key. Does not add the reply to the database.
	 *
	 * @param replyNo the primary key for the new reply
	 * @return the new reply
	 */
	public Reply create(long replyNo);

	/**
	 * Removes the reply with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param replyNo the primary key of the reply
	 * @return the reply that was removed
	 * @throws NoSuchReplyException if a reply with the primary key could not be found
	 */
	public Reply remove(long replyNo) throws NoSuchReplyException;

	public Reply updateImpl(Reply reply);

	/**
	 * Returns the reply with the primary key or throws a <code>NoSuchReplyException</code> if it could not be found.
	 *
	 * @param replyNo the primary key of the reply
	 * @return the reply
	 * @throws NoSuchReplyException if a reply with the primary key could not be found
	 */
	public Reply findByPrimaryKey(long replyNo) throws NoSuchReplyException;

	/**
	 * Returns the reply with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param replyNo the primary key of the reply
	 * @return the reply, or <code>null</code> if a reply with the primary key could not be found
	 */
	public Reply fetchByPrimaryKey(long replyNo);

	/**
	 * Returns all the replies.
	 *
	 * @return the replies
	 */
	public java.util.List<Reply> findAll();

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
	public java.util.List<Reply> findAll(int start, int end);

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
	public java.util.List<Reply> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reply>
			orderByComparator);

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
	public java.util.List<Reply> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reply>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the replies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of replies.
	 *
	 * @return the number of replies
	 */
	public int countAll();

}