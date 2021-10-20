drop table member purge;

create table member
(
   memberId varchar(16) primary key,
   memberName varchar(15)   NOT NULL,
   memberAge INT NOT NULL,
   memberEmail VARCHAR(30) NOT NULL,
   zipCode varchar(30) NOT NULL,
   memberAddr1 varchar(50) NOT NULL,
   memberAddr2 varchar(50) NOT NULL,
   memberTel varchar(15) NOT NULL,
   memberGender char(1) NOT NULL,
   memberCountry varchar(15) NOT NULL,
   memberPassword varchar(16)
)

DROP table zipCodeTable;
create table zipCodeTable
(

   zipCodeId int auto_increment PRIMARY KEY,
   zipCode VARCHAR(30) UNIQUE NOT NULL,
   do VARCHAR(21) NOT NULL,
   si varchar(21) NOT NULL,
   gu varchar(15) NOT NULL,
   ro varchar(20) NOT NULL,
   bunzi varchar(21) NOT NULL

)

ALTER TABLE member ADD CONSTRAINT member_zipCode_fk
FOREIGN KEY (zipCode)
REFERENCES zipCodeTable(zipCode)


CREATE SEQUENCE zipCodeTable_seq;

INSERT INTO zipCodeTable VALUES(null, '11111','경상북도', '경상시', ' ', '하양로', '13-13');
INSERT INTO zipCodeTable VALUES(null, '11112','경상북도', '경상시', ' ', '하양로', '13-13');
INSERT INTO zipCodeTable VALUES(null, '11113','경상북도', '경상시', ' ', '하양로', '13-13');
INSERT INTO zipCodeTable VALUES(null, '11114','경상북도', '경상시', ' ', '하양로', '13-13');
COMMIT

SELECT * FROM member