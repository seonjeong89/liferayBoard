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

package sjkim.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DataType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataType
 * @generated
 */
public class DataTypeWrapper
	extends BaseModelWrapper<DataType>
	implements DataType, ModelWrapper<DataType> {

	public DataTypeWrapper(DataType dataType) {
		super(dataType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dataTypeNo", getDataTypeNo());
		attributes.put("dataTypeNV", getDataTypeNV());
		attributes.put("dataTypeName", getDataTypeName());
		attributes.put("dataTypeVersion", getDataTypeVersion());
		attributes.put("dataTypeDisplayName", getDataTypeDisplayName());
		attributes.put("dataTypeExplanation", getDataTypeExplanation());
		attributes.put("sampleFileName", getSampleFileName());
		attributes.put("sampleRealFileName", getSampleRealFileName());
		attributes.put("sampleFileUploadPath", getSampleFileUploadPath());
		attributes.put("sampleFileType", getSampleFileType());
		attributes.put("dataTypeWriter", getDataTypeWriter());
		attributes.put("dataTypeWriteDate", getDataTypeWriteDate());
		attributes.put("dataTypeUpdateDate", getDataTypeUpdateDate());
		attributes.put("dataTypeStructure", getDataTypeStructure());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dataTypeNo = (Long)attributes.get("dataTypeNo");

		if (dataTypeNo != null) {
			setDataTypeNo(dataTypeNo);
		}

		String dataTypeNV = (String)attributes.get("dataTypeNV");

		if (dataTypeNV != null) {
			setDataTypeNV(dataTypeNV);
		}

		String dataTypeName = (String)attributes.get("dataTypeName");

		if (dataTypeName != null) {
			setDataTypeName(dataTypeName);
		}

		String dataTypeVersion = (String)attributes.get("dataTypeVersion");

		if (dataTypeVersion != null) {
			setDataTypeVersion(dataTypeVersion);
		}

		String dataTypeDisplayName = (String)attributes.get(
			"dataTypeDisplayName");

		if (dataTypeDisplayName != null) {
			setDataTypeDisplayName(dataTypeDisplayName);
		}

		String dataTypeExplanation = (String)attributes.get(
			"dataTypeExplanation");

		if (dataTypeExplanation != null) {
			setDataTypeExplanation(dataTypeExplanation);
		}

		String sampleFileName = (String)attributes.get("sampleFileName");

		if (sampleFileName != null) {
			setSampleFileName(sampleFileName);
		}

		String sampleRealFileName = (String)attributes.get(
			"sampleRealFileName");

		if (sampleRealFileName != null) {
			setSampleRealFileName(sampleRealFileName);
		}

		String sampleFileUploadPath = (String)attributes.get(
			"sampleFileUploadPath");

		if (sampleFileUploadPath != null) {
			setSampleFileUploadPath(sampleFileUploadPath);
		}

		String sampleFileType = (String)attributes.get("sampleFileType");

		if (sampleFileType != null) {
			setSampleFileType(sampleFileType);
		}

		String dataTypeWriter = (String)attributes.get("dataTypeWriter");

		if (dataTypeWriter != null) {
			setDataTypeWriter(dataTypeWriter);
		}

		Date dataTypeWriteDate = (Date)attributes.get("dataTypeWriteDate");

		if (dataTypeWriteDate != null) {
			setDataTypeWriteDate(dataTypeWriteDate);
		}

		Date dataTypeUpdateDate = (Date)attributes.get("dataTypeUpdateDate");

		if (dataTypeUpdateDate != null) {
			setDataTypeUpdateDate(dataTypeUpdateDate);
		}

		String dataTypeStructure = (String)attributes.get("dataTypeStructure");

		if (dataTypeStructure != null) {
			setDataTypeStructure(dataTypeStructure);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the data type display name of this data type.
	 *
	 * @return the data type display name of this data type
	 */
	@Override
	public String getDataTypeDisplayName() {
		return model.getDataTypeDisplayName();
	}

	/**
	 * Returns the localized data type display name of this data type in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized data type display name of this data type
	 */
	@Override
	public String getDataTypeDisplayName(java.util.Locale locale) {
		return model.getDataTypeDisplayName(locale);
	}

	/**
	 * Returns the localized data type display name of this data type in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized data type display name of this data type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDataTypeDisplayName(
		java.util.Locale locale, boolean useDefault) {

		return model.getDataTypeDisplayName(locale, useDefault);
	}

	/**
	 * Returns the localized data type display name of this data type in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized data type display name of this data type
	 */
	@Override
	public String getDataTypeDisplayName(String languageId) {
		return model.getDataTypeDisplayName(languageId);
	}

	/**
	 * Returns the localized data type display name of this data type in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized data type display name of this data type
	 */
	@Override
	public String getDataTypeDisplayName(
		String languageId, boolean useDefault) {

		return model.getDataTypeDisplayName(languageId, useDefault);
	}

	@Override
	public String getDataTypeDisplayNameCurrentLanguageId() {
		return model.getDataTypeDisplayNameCurrentLanguageId();
	}

	@Override
	public String getDataTypeDisplayNameCurrentValue() {
		return model.getDataTypeDisplayNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized data type display names of this data type.
	 *
	 * @return the locales and localized data type display names of this data type
	 */
	@Override
	public Map<java.util.Locale, String> getDataTypeDisplayNameMap() {
		return model.getDataTypeDisplayNameMap();
	}

	/**
	 * Returns the data type explanation of this data type.
	 *
	 * @return the data type explanation of this data type
	 */
	@Override
	public String getDataTypeExplanation() {
		return model.getDataTypeExplanation();
	}

	/**
	 * Returns the localized data type explanation of this data type in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized data type explanation of this data type
	 */
	@Override
	public String getDataTypeExplanation(java.util.Locale locale) {
		return model.getDataTypeExplanation(locale);
	}

	/**
	 * Returns the localized data type explanation of this data type in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized data type explanation of this data type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDataTypeExplanation(
		java.util.Locale locale, boolean useDefault) {

		return model.getDataTypeExplanation(locale, useDefault);
	}

	/**
	 * Returns the localized data type explanation of this data type in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized data type explanation of this data type
	 */
	@Override
	public String getDataTypeExplanation(String languageId) {
		return model.getDataTypeExplanation(languageId);
	}

	/**
	 * Returns the localized data type explanation of this data type in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized data type explanation of this data type
	 */
	@Override
	public String getDataTypeExplanation(
		String languageId, boolean useDefault) {

		return model.getDataTypeExplanation(languageId, useDefault);
	}

	@Override
	public String getDataTypeExplanationCurrentLanguageId() {
		return model.getDataTypeExplanationCurrentLanguageId();
	}

	@Override
	public String getDataTypeExplanationCurrentValue() {
		return model.getDataTypeExplanationCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized data type explanations of this data type.
	 *
	 * @return the locales and localized data type explanations of this data type
	 */
	@Override
	public Map<java.util.Locale, String> getDataTypeExplanationMap() {
		return model.getDataTypeExplanationMap();
	}

	/**
	 * Returns the data type name of this data type.
	 *
	 * @return the data type name of this data type
	 */
	@Override
	public String getDataTypeName() {
		return model.getDataTypeName();
	}

	/**
	 * Returns the data type no of this data type.
	 *
	 * @return the data type no of this data type
	 */
	@Override
	public long getDataTypeNo() {
		return model.getDataTypeNo();
	}

	/**
	 * Returns the data type nv of this data type.
	 *
	 * @return the data type nv of this data type
	 */
	@Override
	public String getDataTypeNV() {
		return model.getDataTypeNV();
	}

	/**
	 * Returns the data type structure of this data type.
	 *
	 * @return the data type structure of this data type
	 */
	@Override
	public String getDataTypeStructure() {
		return model.getDataTypeStructure();
	}

	/**
	 * Returns the localized data type structure of this data type in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized data type structure of this data type
	 */
	@Override
	public String getDataTypeStructure(java.util.Locale locale) {
		return model.getDataTypeStructure(locale);
	}

	/**
	 * Returns the localized data type structure of this data type in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized data type structure of this data type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDataTypeStructure(
		java.util.Locale locale, boolean useDefault) {

		return model.getDataTypeStructure(locale, useDefault);
	}

	/**
	 * Returns the localized data type structure of this data type in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized data type structure of this data type
	 */
	@Override
	public String getDataTypeStructure(String languageId) {
		return model.getDataTypeStructure(languageId);
	}

	/**
	 * Returns the localized data type structure of this data type in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized data type structure of this data type
	 */
	@Override
	public String getDataTypeStructure(String languageId, boolean useDefault) {
		return model.getDataTypeStructure(languageId, useDefault);
	}

	@Override
	public String getDataTypeStructureCurrentLanguageId() {
		return model.getDataTypeStructureCurrentLanguageId();
	}

	@Override
	public String getDataTypeStructureCurrentValue() {
		return model.getDataTypeStructureCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized data type structures of this data type.
	 *
	 * @return the locales and localized data type structures of this data type
	 */
	@Override
	public Map<java.util.Locale, String> getDataTypeStructureMap() {
		return model.getDataTypeStructureMap();
	}

	/**
	 * Returns the data type update date of this data type.
	 *
	 * @return the data type update date of this data type
	 */
	@Override
	public Date getDataTypeUpdateDate() {
		return model.getDataTypeUpdateDate();
	}

	/**
	 * Returns the data type version of this data type.
	 *
	 * @return the data type version of this data type
	 */
	@Override
	public String getDataTypeVersion() {
		return model.getDataTypeVersion();
	}

	/**
	 * Returns the data type write date of this data type.
	 *
	 * @return the data type write date of this data type
	 */
	@Override
	public Date getDataTypeWriteDate() {
		return model.getDataTypeWriteDate();
	}

	/**
	 * Returns the data type writer of this data type.
	 *
	 * @return the data type writer of this data type
	 */
	@Override
	public String getDataTypeWriter() {
		return model.getDataTypeWriter();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the primary key of this data type.
	 *
	 * @return the primary key of this data type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sample file name of this data type.
	 *
	 * @return the sample file name of this data type
	 */
	@Override
	public String getSampleFileName() {
		return model.getSampleFileName();
	}

	/**
	 * Returns the sample file type of this data type.
	 *
	 * @return the sample file type of this data type
	 */
	@Override
	public String getSampleFileType() {
		return model.getSampleFileType();
	}

	/**
	 * Returns the sample file upload path of this data type.
	 *
	 * @return the sample file upload path of this data type
	 */
	@Override
	public String getSampleFileUploadPath() {
		return model.getSampleFileUploadPath();
	}

	/**
	 * Returns the sample real file name of this data type.
	 *
	 * @return the sample real file name of this data type
	 */
	@Override
	public String getSampleRealFileName() {
		return model.getSampleRealFileName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the data type display name of this data type.
	 *
	 * @param dataTypeDisplayName the data type display name of this data type
	 */
	@Override
	public void setDataTypeDisplayName(String dataTypeDisplayName) {
		model.setDataTypeDisplayName(dataTypeDisplayName);
	}

	/**
	 * Sets the localized data type display name of this data type in the language.
	 *
	 * @param dataTypeDisplayName the localized data type display name of this data type
	 * @param locale the locale of the language
	 */
	@Override
	public void setDataTypeDisplayName(
		String dataTypeDisplayName, java.util.Locale locale) {

		model.setDataTypeDisplayName(dataTypeDisplayName, locale);
	}

	/**
	 * Sets the localized data type display name of this data type in the language, and sets the default locale.
	 *
	 * @param dataTypeDisplayName the localized data type display name of this data type
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDataTypeDisplayName(
		String dataTypeDisplayName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDataTypeDisplayName(
			dataTypeDisplayName, locale, defaultLocale);
	}

	@Override
	public void setDataTypeDisplayNameCurrentLanguageId(String languageId) {
		model.setDataTypeDisplayNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized data type display names of this data type from the map of locales and localized data type display names.
	 *
	 * @param dataTypeDisplayNameMap the locales and localized data type display names of this data type
	 */
	@Override
	public void setDataTypeDisplayNameMap(
		Map<java.util.Locale, String> dataTypeDisplayNameMap) {

		model.setDataTypeDisplayNameMap(dataTypeDisplayNameMap);
	}

	/**
	 * Sets the localized data type display names of this data type from the map of locales and localized data type display names, and sets the default locale.
	 *
	 * @param dataTypeDisplayNameMap the locales and localized data type display names of this data type
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDataTypeDisplayNameMap(
		Map<java.util.Locale, String> dataTypeDisplayNameMap,
		java.util.Locale defaultLocale) {

		model.setDataTypeDisplayNameMap(dataTypeDisplayNameMap, defaultLocale);
	}

	/**
	 * Sets the data type explanation of this data type.
	 *
	 * @param dataTypeExplanation the data type explanation of this data type
	 */
	@Override
	public void setDataTypeExplanation(String dataTypeExplanation) {
		model.setDataTypeExplanation(dataTypeExplanation);
	}

	/**
	 * Sets the localized data type explanation of this data type in the language.
	 *
	 * @param dataTypeExplanation the localized data type explanation of this data type
	 * @param locale the locale of the language
	 */
	@Override
	public void setDataTypeExplanation(
		String dataTypeExplanation, java.util.Locale locale) {

		model.setDataTypeExplanation(dataTypeExplanation, locale);
	}

	/**
	 * Sets the localized data type explanation of this data type in the language, and sets the default locale.
	 *
	 * @param dataTypeExplanation the localized data type explanation of this data type
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDataTypeExplanation(
		String dataTypeExplanation, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDataTypeExplanation(
			dataTypeExplanation, locale, defaultLocale);
	}

	@Override
	public void setDataTypeExplanationCurrentLanguageId(String languageId) {
		model.setDataTypeExplanationCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized data type explanations of this data type from the map of locales and localized data type explanations.
	 *
	 * @param dataTypeExplanationMap the locales and localized data type explanations of this data type
	 */
	@Override
	public void setDataTypeExplanationMap(
		Map<java.util.Locale, String> dataTypeExplanationMap) {

		model.setDataTypeExplanationMap(dataTypeExplanationMap);
	}

	/**
	 * Sets the localized data type explanations of this data type from the map of locales and localized data type explanations, and sets the default locale.
	 *
	 * @param dataTypeExplanationMap the locales and localized data type explanations of this data type
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDataTypeExplanationMap(
		Map<java.util.Locale, String> dataTypeExplanationMap,
		java.util.Locale defaultLocale) {

		model.setDataTypeExplanationMap(dataTypeExplanationMap, defaultLocale);
	}

	/**
	 * Sets the data type name of this data type.
	 *
	 * @param dataTypeName the data type name of this data type
	 */
	@Override
	public void setDataTypeName(String dataTypeName) {
		model.setDataTypeName(dataTypeName);
	}

	/**
	 * Sets the data type no of this data type.
	 *
	 * @param dataTypeNo the data type no of this data type
	 */
	@Override
	public void setDataTypeNo(long dataTypeNo) {
		model.setDataTypeNo(dataTypeNo);
	}

	/**
	 * Sets the data type nv of this data type.
	 *
	 * @param dataTypeNV the data type nv of this data type
	 */
	@Override
	public void setDataTypeNV(String dataTypeNV) {
		model.setDataTypeNV(dataTypeNV);
	}

	/**
	 * Sets the data type structure of this data type.
	 *
	 * @param dataTypeStructure the data type structure of this data type
	 */
	@Override
	public void setDataTypeStructure(String dataTypeStructure) {
		model.setDataTypeStructure(dataTypeStructure);
	}

	/**
	 * Sets the localized data type structure of this data type in the language.
	 *
	 * @param dataTypeStructure the localized data type structure of this data type
	 * @param locale the locale of the language
	 */
	@Override
	public void setDataTypeStructure(
		String dataTypeStructure, java.util.Locale locale) {

		model.setDataTypeStructure(dataTypeStructure, locale);
	}

	/**
	 * Sets the localized data type structure of this data type in the language, and sets the default locale.
	 *
	 * @param dataTypeStructure the localized data type structure of this data type
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDataTypeStructure(
		String dataTypeStructure, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDataTypeStructure(dataTypeStructure, locale, defaultLocale);
	}

	@Override
	public void setDataTypeStructureCurrentLanguageId(String languageId) {
		model.setDataTypeStructureCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized data type structures of this data type from the map of locales and localized data type structures.
	 *
	 * @param dataTypeStructureMap the locales and localized data type structures of this data type
	 */
	@Override
	public void setDataTypeStructureMap(
		Map<java.util.Locale, String> dataTypeStructureMap) {

		model.setDataTypeStructureMap(dataTypeStructureMap);
	}

	/**
	 * Sets the localized data type structures of this data type from the map of locales and localized data type structures, and sets the default locale.
	 *
	 * @param dataTypeStructureMap the locales and localized data type structures of this data type
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDataTypeStructureMap(
		Map<java.util.Locale, String> dataTypeStructureMap,
		java.util.Locale defaultLocale) {

		model.setDataTypeStructureMap(dataTypeStructureMap, defaultLocale);
	}

	/**
	 * Sets the data type update date of this data type.
	 *
	 * @param dataTypeUpdateDate the data type update date of this data type
	 */
	@Override
	public void setDataTypeUpdateDate(Date dataTypeUpdateDate) {
		model.setDataTypeUpdateDate(dataTypeUpdateDate);
	}

	/**
	 * Sets the data type version of this data type.
	 *
	 * @param dataTypeVersion the data type version of this data type
	 */
	@Override
	public void setDataTypeVersion(String dataTypeVersion) {
		model.setDataTypeVersion(dataTypeVersion);
	}

	/**
	 * Sets the data type write date of this data type.
	 *
	 * @param dataTypeWriteDate the data type write date of this data type
	 */
	@Override
	public void setDataTypeWriteDate(Date dataTypeWriteDate) {
		model.setDataTypeWriteDate(dataTypeWriteDate);
	}

	/**
	 * Sets the data type writer of this data type.
	 *
	 * @param dataTypeWriter the data type writer of this data type
	 */
	@Override
	public void setDataTypeWriter(String dataTypeWriter) {
		model.setDataTypeWriter(dataTypeWriter);
	}

	/**
	 * Sets the primary key of this data type.
	 *
	 * @param primaryKey the primary key of this data type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sample file name of this data type.
	 *
	 * @param sampleFileName the sample file name of this data type
	 */
	@Override
	public void setSampleFileName(String sampleFileName) {
		model.setSampleFileName(sampleFileName);
	}

	/**
	 * Sets the sample file type of this data type.
	 *
	 * @param sampleFileType the sample file type of this data type
	 */
	@Override
	public void setSampleFileType(String sampleFileType) {
		model.setSampleFileType(sampleFileType);
	}

	/**
	 * Sets the sample file upload path of this data type.
	 *
	 * @param sampleFileUploadPath the sample file upload path of this data type
	 */
	@Override
	public void setSampleFileUploadPath(String sampleFileUploadPath) {
		model.setSampleFileUploadPath(sampleFileUploadPath);
	}

	/**
	 * Sets the sample real file name of this data type.
	 *
	 * @param sampleRealFileName the sample real file name of this data type
	 */
	@Override
	public void setSampleRealFileName(String sampleRealFileName) {
		model.setSampleRealFileName(sampleRealFileName);
	}

	@Override
	protected DataTypeWrapper wrap(DataType dataType) {
		return new DataTypeWrapper(dataType);
	}

}