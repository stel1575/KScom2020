CREATE TABLE KScomUser(
	MEMBER_ID	VARCHAR(15) PRIMARY KEY,
	MEMBER_PW	VARCHAR(15),
	MEMBER_NAME	VARCHAR(15),
	MEMBER_AGE	INT,
	MEMBER_GENDER	VARCHAR(5),
	MEMBER_EMAIL	VARCHAR(30)
);

INSERT INTO KScomUser VALUES('java','java','오정원',40,'M','aaa@aaa.com');
INSERT INTO KScomUser VALUES('testuser','test','이정현',30,'W','bbb@bbb.com');
INSERT INTO KScomUser VALUES('admin','admin','관리자',40,'M','sss@sss.com');