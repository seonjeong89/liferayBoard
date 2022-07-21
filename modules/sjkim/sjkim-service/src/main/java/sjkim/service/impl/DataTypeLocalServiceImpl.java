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

package sjkim.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.swing.text.DefaultEditorKit.InsertTabAction;

import org.osgi.service.component.annotations.Component;

import sjkim.model.Board;
import sjkim.model.DataType;
import sjkim.service.DataTypeLocalServiceUtil;
import sjkim.service.base.DataTypeLocalServiceBaseImpl;

/**
 * The implementation of the data type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>sjkim.service.DataTypeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataTypeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=sjkim.model.DataType",
	service = AopService.class
)
public class DataTypeLocalServiceImpl extends DataTypeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>sjkim.service.DataTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>sjkim.service.DataTypeLocalServiceUtil</code>.
	 */
	
	// 검색 결과 리스트 출력 메소드
	public List<DataType> searchDataTypeList(String keyword, int start, int end, OrderByComparator<DataType> orderByComparator){
		List<DataType> dataTypeList= dataTypePersistence.findBydataTypeNV(keyword, start, end, orderByComparator);
		return dataTypeList;
	}
	
	// 검색 결과 리스트 개수 출력 메소드
	public int searchDataTypeListCount(String keyword) {
		return dataTypePersistence.countBydataTypeNV(keyword);
	}	
	
	// 데이터타입 등록 메소드
	public DataType insertDataType(String dataTypeName, String dataTypeVersion, Map<Locale, String> dataTypeExplanation, Map<Locale, String> dataTypeDisplayName, String writer, String dataTypeStructure, String RealfileName, String uploadFileName, String contentType, String realPath) {
		
		// 데이터타입명과 버전을 합쳐서 dataTypeNV 컬럼명을 만든다.
		String dataTypeNV = dataTypeName + " " + dataTypeVersion;
		
		// 시퀀스 부여하고 데이터타입 만들기
		long insertSeq = CounterLocalServiceUtil.increment(DataType.class.getName()); 
		DataType dataType = DataTypeLocalServiceUtil.createDataType(insertSeq);
		
		// 오늘 날짜 받기
		Date now = new Date();
		
		// 파라미터 받아서 set으로 추가
		dataType.setDataTypeName(dataTypeName);
		dataType.setDataTypeVersion(dataTypeVersion);
		dataType.setDataTypeNV(dataTypeNV);
		dataType.setDataTypeDisplayNameMap(dataTypeDisplayName);
		dataType.setDataTypeExplanationMap(dataTypeExplanation);
		dataType.setDataTypeWriter(writer);
		dataType.setDataTypeWriteDate(now);
		dataType.setDataTypeStructure(dataTypeStructure);
		dataType.setSampleFileName(uploadFileName);
		dataType.setSampleFileType(contentType);
		dataType.setSampleFileUploadPath(realPath);
		dataType.setSampleRealFileName(RealfileName);
		
		return dataTypePersistence.update(dataType);
	}
	
	// 데이터타입 수정 메소드(파일 관련 미포함)
	public DataType updateDataTypeWithoutFile(long dataTypeNo, Map<Locale, String> dataTypeExplanation, Map<Locale, String> dataTypeDisplayName, String dataTypeStructure, String dataTypeWriter) throws PortalException {
		// 데이터 타입에 맞는 정보를 가져온다.
		DataType dataType = DataTypeLocalServiceUtil.getDataType(dataTypeNo);
		
		// 오늘 날짜 받기
		Date now = new Date();
		
		// 업데이트 할 정보 set 해주기
		dataType.setDataTypeDisplayNameMap(dataTypeDisplayName);
		dataType.setDataTypeExplanationMap(dataTypeExplanation);
		dataType.setDataTypeWriter(dataTypeWriter);
		dataType.setDataTypeUpdateDate(now);
		dataType.setDataTypeStructure(dataTypeStructure);
		
		return dataTypePersistence.update(dataType);
	}
	
	// 데이터타입 수정 메소드(파일 관련 포함)
	public DataType updateDataTypeAll(long dataTypeNo, Map<Locale, String> dataTypeExplanation, Map<Locale, String> dataTypeDisplayName, String dataTypeStructure, String dataTypeWriter,String RealfileName, String uploadFileName, String contentType, String realPath) throws PortalException {
		// 데이터 타입에 맞는 정보를 가져온다.
		DataType dataType = DataTypeLocalServiceUtil.getDataType(dataTypeNo);
		
		// 오늘 날짜 받기
		Date now = new Date();
		
		// 업데이트 할 정보 set 해주기
		dataType.setDataTypeDisplayNameMap(dataTypeDisplayName);
		dataType.setDataTypeExplanationMap(dataTypeExplanation);
		dataType.setDataTypeWriter(dataTypeWriter);
		dataType.setDataTypeUpdateDate(now);
		dataType.setDataTypeStructure(dataTypeStructure);
		dataType.setSampleFileName(uploadFileName);
		dataType.setSampleFileType(contentType);
		dataType.setSampleFileUploadPath(realPath);
		dataType.setSampleRealFileName(RealfileName);
		
		return dataTypePersistence.update(dataType);
	}
	
	// 데이터 타입 복제 메소드
	public DataType cloneDataType(long dataTypeNo, String dataTypeVersion, String dataTypeWriter) throws PortalException {
		DataType oldDataType = DataTypeLocalServiceUtil.getDataType(dataTypeNo);
		String dataTypeName = oldDataType.getDataTypeName();
		String oldUploadPath = oldDataType.getSampleFileUploadPath();
		String oldFileName = oldDataType.getSampleFileName();
		String oldRealFileName = oldDataType.getSampleRealFileName();
		String oldFileType = oldDataType.getSampleFileType();
		
		// 데이터타입명과 버전을 합쳐서 dataTypeNV 컬럼명을 만든다.
		String dataTypeNV = dataTypeName + " " + dataTypeVersion;
		
		// 시퀀스 부여하고 데이터타입 만들기
		long insertSeq = CounterLocalServiceUtil.increment(DataType.class.getName()); 
		DataType cloneDataType = DataTypeLocalServiceUtil.createDataType(insertSeq);
		
		// 오늘 날짜 받기
		Date now = new Date();
		
		// 새로운 파일명 생성
		UUID uuid = UUID.randomUUID();
		String cloneFileName = uuid.toString() + "_" + oldRealFileName;
		
		// 파일 정보를 읽어서 다시 저장
		// 1. 원본 File, 복사할 File 준비
		File file = new File(oldUploadPath+File.separator+oldFileName);
		File cloneFile = new File(oldUploadPath+File.separator+cloneFileName);
		
		// 2. FileInputStream, FileOutputStream 준비
		FileInputStream in;
		FileOutputStream out;
		try {
			in = new FileInputStream(file);
			out = new FileOutputStream(cloneFile);
			
			// 3. 한번에 read 하고, write 할 사이즈 지정
			byte[] buf = new byte[1024];
			
			// 4. buf 사이즈 만큼 input에서 데이터를 읽어서 output에 쏜다.
			int readData;
			while((readData = in.read(buf)) >0) {
				out.write(buf, 0, readData);
			}
			
			// 5. Stream close()
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 파라미터 받아서 set으로 추가
		cloneDataType.setDataTypeName(dataTypeName);
		cloneDataType.setDataTypeVersion(dataTypeVersion);
		cloneDataType.setDataTypeNV(dataTypeNV);
		cloneDataType.setDataTypeExplanationMap(oldDataType.getDataTypeExplanationMap());
		cloneDataType.setDataTypeDisplayNameMap(oldDataType.getDataTypeDisplayNameMap());
		cloneDataType.setDataTypeWriter(dataTypeWriter);
		cloneDataType.setDataTypeWriteDate(now);
		cloneDataType.setDataTypeStructure(oldDataType.getDataTypeStructure());
		cloneDataType.setSampleFileName(cloneFileName);
		cloneDataType.setSampleFileType(oldFileType);
		cloneDataType.setSampleFileUploadPath(oldUploadPath);
		cloneDataType.setSampleRealFileName(oldRealFileName);
		
		return dataTypePersistence.update(cloneDataType);
	}
	
	// 데이터 타입 삭제 메소드
	public void daleteDataType(long dataTypeNo) throws PortalException {
		// 데이터 타입에 맞는 정보를 가져온다.
		DataType dataType = DataTypeLocalServiceUtil.getDataType(dataTypeNo);
		
		// 중간에 삭제 해줘야 하는 테이블 있기 때문에 따로 만들어 둠.
		
		// 해당하는 데이터타입을 지운다.
		dataTypePersistence.remove(dataType);
	}
	
	// 데이터 타입 업그레이드 메소드
	public DataType upgradeDataType(long dataTypeNo, String dataTypeWriter) throws PortalException {
		
		// 현재 선택한 데이터 타입 이름과 버전 출력
		DataType oldDataType = DataTypeLocalServiceUtil.getDataType(dataTypeNo);
		String dataTypeName = oldDataType.getDataTypeName();
		String oldDataTypeVersion = oldDataType.getDataTypeVersion();
		String oldUploadPath = oldDataType.getSampleFileUploadPath();
		String oldFileName = oldDataType.getSampleFileName();
		String oldRealFileName = oldDataType.getSampleRealFileName();
		String oldFileType = oldDataType.getSampleFileType();
		
		// 데이터 타입이름이 같은 데이터 타입 리스트 출력
		List<DataType> dataTypeList = dataTypePersistence.findBydataTypeName(dataTypeName);
		
		// BigInteger 배열 설정
		BigInteger[] arr = new BigInteger[dataTypeList.size()];
		BigInteger max = BigInteger.ZERO;
		
		// 데이터 타입 리스트에서 데이터 major 버전만 뽑아서 int로 변환 후 배열에 넣는다. 
		for(int i = 0; i<dataTypeList.size(); i++) {
			String dataTypeVersion = dataTypeList.get(i).getDataTypeVersion();
			String[] dataTypeVersionSplit = dataTypeVersion.split("\\.");
			String majorS = dataTypeVersionSplit[0];
			
			BigInteger major = new BigInteger(majorS);
			arr[i] = major;
			
			// arr 중에서 가장 큰 값을 구하여 변수에 담는다.
			if(arr[i].compareTo(max) > 0) {
				max = arr[i];
			}
		}
		
		// 현재 선택한 데이터 타입 minor, build 버전 출력
		String[] oldDataTypeVersionSplit = oldDataTypeVersion.split("\\.");
		String minorS = oldDataTypeVersionSplit[1];
		String buildS = oldDataTypeVersionSplit[2];
		
		// 데이터 타입 가장 큰 major 버전 +1 
		BigInteger upgradeMajorVersion = max.add(BigInteger.ONE);
		// 최종 데이터 타입 버전 String 타입(major만 +1 하고 나머지는 기존 버전 그대로 넣는다.)
		String upgradeDataTypeVersion = upgradeMajorVersion + "." + minorS + "." + buildS;
		
		// 데이터타입명과 버전을 합쳐서 dataTypeNV 컬럼명을 만든다.
		String dataTypeNV = dataTypeName + " " + upgradeDataTypeVersion;
		
		// 시퀀스 부여하고 데이터타입 만들기
		long insertSeq = CounterLocalServiceUtil.increment(DataType.class.getName()); 
		DataType upgradeDataType = DataTypeLocalServiceUtil.createDataType(insertSeq);
		
		// 오늘 날짜 받기
		Date now = new Date();
		
		// 새로운 파일명 생성
		UUID uuid = UUID.randomUUID();
		String cloneFileName = uuid.toString() + "_" + oldRealFileName;
		
		// 파일 정보를 읽어서 다시 저장
		// 1. 원본 File, 복사할 File 준비
		File file = new File(oldUploadPath+File.separator+oldFileName);
		File cloneFile = new File(oldUploadPath+File.separator+cloneFileName);
		
		// 2. FileInputStream, FileOutputStream 준비
		FileInputStream in;
		FileOutputStream out;
		try {
			in = new FileInputStream(file);
			out = new FileOutputStream(cloneFile);
			
			// 3. 한번에 read 하고, write 할 사이즈 지정
			byte[] buf = new byte[1024];
			
			// 4. buf 사이즈 만큼 input에서 데이터를 읽어서 output에 쏜다.
			int readData;
			while((readData = in.read(buf)) >0) {
				out.write(buf, 0, readData);
			}
			
			// 5. Stream close()
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 파라미터 받아서 set으로 추가
		upgradeDataType.setDataTypeName(dataTypeName);
		upgradeDataType.setDataTypeVersion(upgradeDataTypeVersion);
		upgradeDataType.setDataTypeNV(dataTypeNV);
		upgradeDataType.setDataTypeExplanationMap(oldDataType.getDataTypeExplanationMap());
		upgradeDataType.setDataTypeDisplayNameMap(oldDataType.getDataTypeDisplayNameMap());
		upgradeDataType.setDataTypeWriter(dataTypeWriter);
		upgradeDataType.setDataTypeWriteDate(now);
		upgradeDataType.setDataTypeStructure(oldDataType.getDataTypeStructure());
		upgradeDataType.setSampleFileName(cloneFileName);
		upgradeDataType.setSampleFileType(oldFileType);
		upgradeDataType.setSampleFileUploadPath(oldUploadPath);
		upgradeDataType.setSampleRealFileName(oldRealFileName);
		
		return dataTypePersistence.update(upgradeDataType);
	}
}