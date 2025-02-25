DROP TABLE MEMBERS;
CREATE TABLE MEMBERS(
    MNO NUMBER NOT NULL
,   EMAIL VARCHAR2(40) NOT NULL
,   PWD VARCHAR2(100) NOT NULL
,   MNAME VARCHAR2(50) NOT NULL
,   CRE_DATE DATE NOT NULL
,   MOD_DATE DATE NOT NULL
);

COMMENT ON TABLE MEMBERS IS '회원기본정보';

COMMENT ON COLUMN MEMBERS.MNO IS '회원번호';
COMMENT ON COLUMN MEMBERS.EMAIL IS '이메일';
COMMENT ON COLUMN MEMBERS.PWD IS '암호';
COMMENT ON COLUMN MEMBERS.MNAME IS '이름';
COMMENT ON COLUMN MEMBERS.CRE_DATE IS '가입일';
COMMENT ON COLUMN MEMBERS.MOD_DATE IS '마지막정보 변경일';


ALTER TABLE MEMBERS
ADD CONSTRAINT MEMBERS_MNO_PK PRIMARY KEY(MNO);

ALTER TABLE MEMBERS
ADD CONSTRAINT MEMBERS_EMIAL_UK UNIQUE(EMAIL);

DROP SEQUENCE MEMBERS_MNO_SEQ;
CREATE SEQUENCE MEMBERS_MNO_SEQ
INCREMENT BY 1
START WITH 1;

INSERT INTO MEMBERS
(MNO, EMAIL, PWD, MNAME, CRE_DATE, MOD_DATE)
VALUES(MEMBERS_MNO_SEQ.NEXTVAL, 's1@test.com', '1111', '홍길동', SYSDATE, SYSDATE);

INSERT INTO MEMBERS
(MNO, EMAIL, PWD, MNAME, CRE_DATE, MOD_DATE)
VALUES(MEMBERS_MNO_SEQ.NEXTVAL, 's2@test.com', '1111', '임꺽정', SYSDATE, SYSDATE);

INSERT INTO MEMBERS
(MNO, EMAIL, PWD, MNAME, CRE_DATE, MOD_DATE)
VALUES(MEMBERS_MNO_SEQ.NEXTVAL, 's3@test.com', '1111', '일지매', SYSDATE, SYSDATE);

INSERT INTO MEMBERS
(MNO, EMAIL, PWD, MNAME, CRE_DATE, MOD_DATE)
VALUES(MEMBERS_MNO_SEQ.NEXTVAL, 's4@test.com', '1111', '이몽룡', SYSDATE, SYSDATE);

INSERT INTO MEMBERS
(MNO, EMAIL, PWD, MNAME, CRE_DATE, MOD_DATE)
VALUES(MEMBERS_MNO_SEQ.NEXTVAL, 's5@test.com', '1111', '성춘향', SYSDATE, SYSDATE);

select *
from members;


commit;