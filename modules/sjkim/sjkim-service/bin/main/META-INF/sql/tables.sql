create table FOOO_Board (
	boardNo LONG not null primary key,
	boardTitle VARCHAR(75) null,
	boardContent VARCHAR(75) null,
	boardWriter VARCHAR(75) null,
	boardWriteDate DATE null,
	boardUptateDate DATE null,
	boardViewCount LONG
);

create table FOOO_Foo (
	uuid_ VARCHAR(75) null,
	fooId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);

create table FOOO_Reply (
	replyNo LONG not null primary key,
	boardNo LONG,
	replyContent VARCHAR(75) null,
	replyParentReplyNo LONG,
	replyLevel LONG,
	replyWriteDate DATE null,
	replyUpdateDate DATE null,
	replyDeleteYN VARCHAR(75) null
);

create table FOOO_UploadFile (
	uploadFileNo LONG not null primary key,
	boardNo LONG,
	uploadFileName VARCHAR(75) null,
	uploadFileType VARCHAR(75) null,
	uploadFileContent VARCHAR(75) null,
	uploadFileDate DATE null
);

create table SJKIM_Board (
	boardNo LONG not null primary key,
	boardTitle VARCHAR(255) null,
	boardContent VARCHAR(2000) null,
	boardWriter VARCHAR(255) null,
	boardWriteDate DATE null,
	boardUpdateDate DATE null,
	boardViewCount LONG
);

create table SJKIM_DataType (
	dataTypeNo LONG not null primary key,
	dataTypeNV VARCHAR(520) null,
	dataTypeName VARCHAR(255) null,
	dataTypeVersion VARCHAR(255) null,
	dataTypeDisplayName TEXT null,
	dataTypeExplanation TEXT null,
	sampleFileName VARCHAR(255) null,
	sampleRealFileName VARCHAR(255) null,
	sampleFileUploadPath VARCHAR(1000) null,
	sampleFileType VARCHAR(255) null,
	dataTypeWriter VARCHAR(75) null,
	dataTypeWriteDate DATE null,
	dataTypeUpdateDate DATE null,
	dataTypeStructure TEXT null
);

create table SJKIM_Foo (
	uuid_ VARCHAR(75) null,
	fooId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);

create table SJKIM_Reply (
	replyNo LONG not null primary key,
	boardNo LONG,
	replyContent VARCHAR(2000) null,
	replyContentBackUp VARCHAR(2000) null,
	replyWriter VARCHAR(255) null,
	replyParentReplyNo LONG,
	replyLevel LONG,
	replyWriteDate DATE null,
	replyUpdateDate DATE null,
	replyDeleteYN VARCHAR(75) null
);

create table SJKIM_UploadFile (
	uploadFileNo LONG not null primary key,
	uploadFileBoardNo LONG,
	uploadFileName VARCHAR(255) null,
	uploadRealFileName VARCHAR(255) null,
	uploadFileUploadPath VARCHAR(1000) null,
	uploadFileMimeType VARCHAR(75) null,
	uploadFileWriter VARCHAR(255) null,
	uploadFileWriteDate DATE null,
	uploadFileUpdateDate DATE null
);