create index IX_C865533C on FOOO_Board (boardTitle[$COLUMN_LENGTH:75$]);

create index IX_65D9A982 on FOOO_Foo (field2);
create index IX_8FFE440A on FOOO_Foo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B77C450C on FOOO_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4508791D on FOOO_Reply (replyContent[$COLUMN_LENGTH:75$]);

create index IX_BFD9095 on FOOO_UploadFile (uploadFileName[$COLUMN_LENGTH:75$]);

create index IX_2AF9D64B on SJKIM_Board (boardTitle[$COLUMN_LENGTH:255$]);

create index IX_569A751 on SJKIM_DataType (dataTypeNV[$COLUMN_LENGTH:520$]);
create index IX_5257A5B4 on SJKIM_DataType (dataTypeName[$COLUMN_LENGTH:255$]);
create index IX_AB465FF3 on SJKIM_DataType (dataTypeVersion[$COLUMN_LENGTH:255$]);

create index IX_E69563D1 on SJKIM_Foo (field2);
create index IX_BF6CA799 on SJKIM_Foo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C6FC405B on SJKIM_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F8D074BC on SJKIM_Reply (boardNo, replyLevel);
create index IX_5488746C on SJKIM_Reply (replyContent[$COLUMN_LENGTH:2000$]);

create index IX_DCFABCB0 on SJKIM_UploadFile (uploadFileBoardNo);
create index IX_351A0E66 on SJKIM_UploadFile (uploadFileName[$COLUMN_LENGTH:255$]);