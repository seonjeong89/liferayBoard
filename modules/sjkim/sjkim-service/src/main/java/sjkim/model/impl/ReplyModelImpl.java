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

package sjkim.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import sjkim.model.Reply;
import sjkim.model.ReplyModel;
import sjkim.model.ReplySoap;

/**
 * The base model implementation for the Reply service. Represents a row in the &quot;SJKIM_Reply&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ReplyModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ReplyImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReplyImpl
 * @generated
 */
@JSON(strict = true)
public class ReplyModelImpl extends BaseModelImpl<Reply> implements ReplyModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a reply model instance should use the <code>Reply</code> interface instead.
	 */
	public static final String TABLE_NAME = "SJKIM_Reply";

	public static final Object[][] TABLE_COLUMNS = {
		{"replyNo", Types.BIGINT}, {"boardNo", Types.BIGINT},
		{"replyContent", Types.VARCHAR}, {"replyContentBackUp", Types.VARCHAR},
		{"replyWriter", Types.VARCHAR}, {"replyParentReplyNo", Types.BIGINT},
		{"replyLevel", Types.BIGINT}, {"replyWriteDate", Types.TIMESTAMP},
		{"replyUpdateDate", Types.TIMESTAMP}, {"replyDeleteYN", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("replyNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("boardNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("replyContent", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("replyContentBackUp", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("replyWriter", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("replyParentReplyNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("replyLevel", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("replyWriteDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("replyUpdateDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("replyDeleteYN", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SJKIM_Reply (replyNo LONG not null primary key,boardNo LONG,replyContent VARCHAR(2000) null,replyContentBackUp VARCHAR(2000) null,replyWriter VARCHAR(255) null,replyParentReplyNo LONG,replyLevel LONG,replyWriteDate DATE null,replyUpdateDate DATE null,replyDeleteYN VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table SJKIM_Reply";

	public static final String ORDER_BY_JPQL = " ORDER BY reply.replyNo ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SJKIM_Reply.replyNo ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long BOARDNO_COLUMN_BITMASK = 1L;

	public static final long REPLYCONTENT_COLUMN_BITMASK = 2L;

	public static final long REPLYLEVEL_COLUMN_BITMASK = 4L;

	public static final long REPLYNO_COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Reply toModel(ReplySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Reply model = new ReplyImpl();

		model.setReplyNo(soapModel.getReplyNo());
		model.setBoardNo(soapModel.getBoardNo());
		model.setReplyContent(soapModel.getReplyContent());
		model.setReplyContentBackUp(soapModel.getReplyContentBackUp());
		model.setReplyWriter(soapModel.getReplyWriter());
		model.setReplyParentReplyNo(soapModel.getReplyParentReplyNo());
		model.setReplyLevel(soapModel.getReplyLevel());
		model.setReplyWriteDate(soapModel.getReplyWriteDate());
		model.setReplyUpdateDate(soapModel.getReplyUpdateDate());
		model.setReplyDeleteYN(soapModel.getReplyDeleteYN());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Reply> toModels(ReplySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Reply> models = new ArrayList<Reply>(soapModels.length);

		for (ReplySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ReplyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _replyNo;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReplyNo(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _replyNo;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Reply.class;
	}

	@Override
	public String getModelClassName() {
		return Reply.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Reply, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Reply, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Reply, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Reply)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Reply, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Reply, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Reply)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Reply, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Reply, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Reply>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Reply.class.getClassLoader(), Reply.class, ModelWrapper.class);

		try {
			Constructor<Reply> constructor =
				(Constructor<Reply>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Reply, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Reply, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Reply, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Reply, Object>>();
		Map<String, BiConsumer<Reply, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Reply, ?>>();

		attributeGetterFunctions.put("replyNo", Reply::getReplyNo);
		attributeSetterBiConsumers.put(
			"replyNo", (BiConsumer<Reply, Long>)Reply::setReplyNo);
		attributeGetterFunctions.put("boardNo", Reply::getBoardNo);
		attributeSetterBiConsumers.put(
			"boardNo", (BiConsumer<Reply, Long>)Reply::setBoardNo);
		attributeGetterFunctions.put("replyContent", Reply::getReplyContent);
		attributeSetterBiConsumers.put(
			"replyContent", (BiConsumer<Reply, String>)Reply::setReplyContent);
		attributeGetterFunctions.put(
			"replyContentBackUp", Reply::getReplyContentBackUp);
		attributeSetterBiConsumers.put(
			"replyContentBackUp",
			(BiConsumer<Reply, String>)Reply::setReplyContentBackUp);
		attributeGetterFunctions.put("replyWriter", Reply::getReplyWriter);
		attributeSetterBiConsumers.put(
			"replyWriter", (BiConsumer<Reply, String>)Reply::setReplyWriter);
		attributeGetterFunctions.put(
			"replyParentReplyNo", Reply::getReplyParentReplyNo);
		attributeSetterBiConsumers.put(
			"replyParentReplyNo",
			(BiConsumer<Reply, Long>)Reply::setReplyParentReplyNo);
		attributeGetterFunctions.put("replyLevel", Reply::getReplyLevel);
		attributeSetterBiConsumers.put(
			"replyLevel", (BiConsumer<Reply, Long>)Reply::setReplyLevel);
		attributeGetterFunctions.put(
			"replyWriteDate", Reply::getReplyWriteDate);
		attributeSetterBiConsumers.put(
			"replyWriteDate",
			(BiConsumer<Reply, Date>)Reply::setReplyWriteDate);
		attributeGetterFunctions.put(
			"replyUpdateDate", Reply::getReplyUpdateDate);
		attributeSetterBiConsumers.put(
			"replyUpdateDate",
			(BiConsumer<Reply, Date>)Reply::setReplyUpdateDate);
		attributeGetterFunctions.put("replyDeleteYN", Reply::getReplyDeleteYN);
		attributeSetterBiConsumers.put(
			"replyDeleteYN",
			(BiConsumer<Reply, String>)Reply::setReplyDeleteYN);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getReplyNo() {
		return _replyNo;
	}

	@Override
	public void setReplyNo(long replyNo) {
		_replyNo = replyNo;
	}

	@JSON
	@Override
	public long getBoardNo() {
		return _boardNo;
	}

	@Override
	public void setBoardNo(long boardNo) {
		_columnBitmask |= BOARDNO_COLUMN_BITMASK;

		if (!_setOriginalBoardNo) {
			_setOriginalBoardNo = true;

			_originalBoardNo = _boardNo;
		}

		_boardNo = boardNo;
	}

	public long getOriginalBoardNo() {
		return _originalBoardNo;
	}

	@JSON
	@Override
	public String getReplyContent() {
		if (_replyContent == null) {
			return "";
		}
		else {
			return _replyContent;
		}
	}

	@Override
	public void setReplyContent(String replyContent) {
		_columnBitmask |= REPLYCONTENT_COLUMN_BITMASK;

		if (_originalReplyContent == null) {
			_originalReplyContent = _replyContent;
		}

		_replyContent = replyContent;
	}

	public String getOriginalReplyContent() {
		return GetterUtil.getString(_originalReplyContent);
	}

	@JSON
	@Override
	public String getReplyContentBackUp() {
		if (_replyContentBackUp == null) {
			return "";
		}
		else {
			return _replyContentBackUp;
		}
	}

	@Override
	public void setReplyContentBackUp(String replyContentBackUp) {
		_replyContentBackUp = replyContentBackUp;
	}

	@JSON
	@Override
	public String getReplyWriter() {
		if (_replyWriter == null) {
			return "";
		}
		else {
			return _replyWriter;
		}
	}

	@Override
	public void setReplyWriter(String replyWriter) {
		_replyWriter = replyWriter;
	}

	@JSON
	@Override
	public Long getReplyParentReplyNo() {
		return _replyParentReplyNo;
	}

	@Override
	public void setReplyParentReplyNo(Long replyParentReplyNo) {
		_replyParentReplyNo = replyParentReplyNo;
	}

	@JSON
	@Override
	public Long getReplyLevel() {
		return _replyLevel;
	}

	@Override
	public void setReplyLevel(Long replyLevel) {
		_columnBitmask |= REPLYLEVEL_COLUMN_BITMASK;

		if (!_setOriginalReplyLevel) {
			_setOriginalReplyLevel = true;

			_originalReplyLevel = _replyLevel;
		}

		_replyLevel = replyLevel;
	}

	public Long getOriginalReplyLevel() {
		return _originalReplyLevel;
	}

	@JSON
	@Override
	public Date getReplyWriteDate() {
		return _replyWriteDate;
	}

	@Override
	public void setReplyWriteDate(Date replyWriteDate) {
		_replyWriteDate = replyWriteDate;
	}

	@JSON
	@Override
	public Date getReplyUpdateDate() {
		return _replyUpdateDate;
	}

	@Override
	public void setReplyUpdateDate(Date replyUpdateDate) {
		_replyUpdateDate = replyUpdateDate;
	}

	@JSON
	@Override
	public String getReplyDeleteYN() {
		if (_replyDeleteYN == null) {
			return "";
		}
		else {
			return _replyDeleteYN;
		}
	}

	@Override
	public void setReplyDeleteYN(String replyDeleteYN) {
		_replyDeleteYN = replyDeleteYN;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Reply.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Reply toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Reply>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ReplyImpl replyImpl = new ReplyImpl();

		replyImpl.setReplyNo(getReplyNo());
		replyImpl.setBoardNo(getBoardNo());
		replyImpl.setReplyContent(getReplyContent());
		replyImpl.setReplyContentBackUp(getReplyContentBackUp());
		replyImpl.setReplyWriter(getReplyWriter());
		replyImpl.setReplyParentReplyNo(getReplyParentReplyNo());
		replyImpl.setReplyLevel(getReplyLevel());
		replyImpl.setReplyWriteDate(getReplyWriteDate());
		replyImpl.setReplyUpdateDate(getReplyUpdateDate());
		replyImpl.setReplyDeleteYN(getReplyDeleteYN());

		replyImpl.resetOriginalValues();

		return replyImpl;
	}

	@Override
	public int compareTo(Reply reply) {
		long primaryKey = reply.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Reply)) {
			return false;
		}

		Reply reply = (Reply)object;

		long primaryKey = reply.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		_originalBoardNo = _boardNo;

		_setOriginalBoardNo = false;

		_originalReplyContent = _replyContent;

		_originalReplyLevel = _replyLevel;

		_setOriginalReplyLevel = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Reply> toCacheModel() {
		ReplyCacheModel replyCacheModel = new ReplyCacheModel();

		replyCacheModel.replyNo = getReplyNo();

		replyCacheModel.boardNo = getBoardNo();

		replyCacheModel.replyContent = getReplyContent();

		String replyContent = replyCacheModel.replyContent;

		if ((replyContent != null) && (replyContent.length() == 0)) {
			replyCacheModel.replyContent = null;
		}

		replyCacheModel.replyContentBackUp = getReplyContentBackUp();

		String replyContentBackUp = replyCacheModel.replyContentBackUp;

		if ((replyContentBackUp != null) &&
			(replyContentBackUp.length() == 0)) {

			replyCacheModel.replyContentBackUp = null;
		}

		replyCacheModel.replyWriter = getReplyWriter();

		String replyWriter = replyCacheModel.replyWriter;

		if ((replyWriter != null) && (replyWriter.length() == 0)) {
			replyCacheModel.replyWriter = null;
		}

		Long replyParentReplyNo = getReplyParentReplyNo();

		if (replyParentReplyNo != null) {
			replyCacheModel.replyParentReplyNo = replyParentReplyNo;
		}

		Long replyLevel = getReplyLevel();

		if (replyLevel != null) {
			replyCacheModel.replyLevel = replyLevel;
		}

		Date replyWriteDate = getReplyWriteDate();

		if (replyWriteDate != null) {
			replyCacheModel.replyWriteDate = replyWriteDate.getTime();
		}
		else {
			replyCacheModel.replyWriteDate = Long.MIN_VALUE;
		}

		Date replyUpdateDate = getReplyUpdateDate();

		if (replyUpdateDate != null) {
			replyCacheModel.replyUpdateDate = replyUpdateDate.getTime();
		}
		else {
			replyCacheModel.replyUpdateDate = Long.MIN_VALUE;
		}

		replyCacheModel.replyDeleteYN = getReplyDeleteYN();

		String replyDeleteYN = replyCacheModel.replyDeleteYN;

		if ((replyDeleteYN != null) && (replyDeleteYN.length() == 0)) {
			replyCacheModel.replyDeleteYN = null;
		}

		return replyCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Reply, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Reply, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Reply, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Reply)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Reply, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Reply, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Reply, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Reply)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Reply>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _replyNo;
	private long _boardNo;
	private long _originalBoardNo;
	private boolean _setOriginalBoardNo;
	private String _replyContent;
	private String _originalReplyContent;
	private String _replyContentBackUp;
	private String _replyWriter;
	private Long _replyParentReplyNo;
	private Long _replyLevel;
	private Long _originalReplyLevel;
	private boolean _setOriginalReplyLevel;
	private Date _replyWriteDate;
	private Date _replyUpdateDate;
	private String _replyDeleteYN;
	private long _columnBitmask;
	private Reply _escapedModel;

}