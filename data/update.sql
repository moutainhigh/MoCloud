﻿SET FOREIGN_KEY_CHECKS=0;
SET FOREIGN_KEY_CHECKS=1;

-- 150904 增加用户身份证号
ALTER TABLE DT_PSN_USER ADD ID_CARD VARCHAR(40)       AFTER CONTACT_MAIL_VERIFY_CD;
ALTER TABLE DT_PSN_USER ADD ID_CARD_VERIFY_CD INTEGER AFTER ID_CARD;

-- 150912 增加统计表
ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL1_ID    BIGINT      AFTER DEPARTMENT_LABEL;
ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL1_LABEL VARCHAR(80) AFTER DEPARTMENT_LEVEL1_ID;

ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL2_ID    BIGINT      AFTER DEPARTMENT_LEVEL1_LABEL;
ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL2_LABEL VARCHAR(80) AFTER DEPARTMENT_LEVEL2_ID;

ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL3_ID    BIGINT      AFTER DEPARTMENT_LEVEL2_LABEL;
ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL3_LABEL VARCHAR(80) AFTER DEPARTMENT_LEVEL3_ID;

ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL4_ID    BIGINT      AFTER DEPARTMENT_LEVEL3_LABEL;
ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL4_LABEL VARCHAR(80) AFTER DEPARTMENT_LEVEL4_ID;

ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL5_ID    BIGINT      AFTER DEPARTMENT_LEVEL4_LABEL;
ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL5_LABEL VARCHAR(80) AFTER DEPARTMENT_LEVEL5_ID;

ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL6_ID    BIGINT      AFTER DEPARTMENT_LEVEL5_LABEL;
ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL6_LABEL VARCHAR(80) AFTER DEPARTMENT_LEVEL6_ID;

ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL7_ID    BIGINT      AFTER DEPARTMENT_LEVEL6_LABEL;
ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL7_LABEL VARCHAR(80) AFTER DEPARTMENT_LEVEL7_ID;

ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL8_ID    BIGINT      AFTER DEPARTMENT_LEVEL7_LABEL;
ALTER TABLE ST_FIN_MARKETER ADD DEPARTMENT_LEVEL8_LABEL VARCHAR(80) AFTER DEPARTMENT_LEVEL8_ID;

-- 150914 增加统计表
ALTER TABLE ST_FIN_CUSTOMER ADD INVESTMENT_FIRST_DATE DATETIME AFTER CARD;
ALTER TABLE ST_FIN_CUSTOMER ADD INVESTMENT_LAST_DATE  DATETIME AFTER INVESTMENT_FIRST_DATE;
ALTER TABLE ST_FIN_CUSTOMER ADD INVESTMENT_NUMBER     INTEGER  AFTER INVESTMENT_LAST_DATE;
ALTER TABLE ST_FIN_CUSTOMER ADD REDEMPTION_FIRST_DATE DATETIME AFTER INVESTMENT_TOTAL;
ALTER TABLE ST_FIN_CUSTOMER ADD REDEMPTION_LAST_DATE  DATETIME AFTER REDEMPTION_FIRST_DATE;
ALTER TABLE ST_FIN_CUSTOMER ADD REDEMPTION_NUMBER     INTEGER  AFTER REDEMPTION_LAST_DATE;

-- 150921 增加GPS坐标
USE EAI_CACHE;
ALTER TABLE CC_SYS_SESSION ADD LOCATION_LONGITUDE DOUBLE AFTER ROLE_MODULES;
ALTER TABLE CC_SYS_SESSION ADD LOCATION_LATITUDE  DOUBLE AFTER LOCATION_LONGITUDE;

USE EAI_DATA;
ALTER TABLE DT_COM_COUNTRY ADD LOCATION_LONGITUDE DOUBLE AFTER ICON_URL;
ALTER TABLE DT_COM_COUNTRY ADD LOCATION_LATITUDE  DOUBLE AFTER LOCATION_LONGITUDE;



USE EAI_LOGGER;
ALTER TABLE LG_PSN_USER_ACCESS ADD LOCATION_LONGITUDE DOUBLE AFTER PAGE_INFO;
ALTER TABLE LG_PSN_USER_ACCESS ADD LOCATION_LATITUDE  DOUBLE AFTER LOCATION_LONGITUDE;

-- 150922 增加日志新表
ADD TABLE LG_SYS_LOGGER;
ADD TABLE LG_SYS_EXCEPTION;

-- 150921 增加统计信息
USE EAI_STATISTICS;
ALTER TABLE ST_FIN_DYNAMIC ADD TENDER_CHANGED       TINYINT     AFTER CUSTOMER_ACTION_INTEREST;
ALTER TABLE ST_FIN_DYNAMIC ADD TENDER_PRIOR_ID      BIGINT      AFTER TENDER_CHANGED;
ALTER TABLE ST_FIN_DYNAMIC ADD TENDER_PRIOR_LINK_ID BIGINT      AFTER TENDER_PRIOR_ID;
ALTER TABLE ST_FIN_DYNAMIC ADD TENDER_PRIOR_MODEL   VARCHAR(20) AFTER TENDER_PRIOR_LINK_ID;

ALTER TABLE ST_FIN_CUSTOMER ADD TENDER_ID      BIGINT      AFTER PERFORMANCE_TOTAL;
ALTER TABLE ST_FIN_CUSTOMER ADD TENDER_LINK_ID BIGINT      AFTER TENDER_ID;
ALTER TABLE ST_FIN_CUSTOMER ADD TENDER_MODEL   VARCHAR(20) AFTER TENDER_LINK_ID;

-- 150924 修改理财师成员的外键 sunhr
ALTER TABLE DT_FIN_MARKETER_MEMBER DROP FOREIGN KEY DT_FIN_MKT_MEM_FK_CUS;
ALTER TABLE DT_FIN_MARKETER_MEMBER CHANGE CUSTOMER_ID MEMBER_ID BIGINT(20) AFTER MARKETER_ID;
ALTER TABLE DT_FIN_MARKETER_MEMBER ADD CONSTRAINT DT_FIN_MKT_MEM_FK_MER FOREIGN KEY (MEMBER_ID) REFERENCES DT_FIN_MEMBER(OUID); 

-- 150925 修改投资项目统计表
ALTER TABLE ST_FIN_TENDER ADD BEGIN_DATE            DATETIME AFTER LABEL;
ALTER TABLE ST_FIN_TENDER ADD END_DATE              DATETIME AFTER BEGIN_DATE;
ALTER TABLE ST_FIN_TENDER ADD INVESTMENT_USER_COUNT INTEGER AFTER INVESTMENT_COUNT;
ALTER TABLE ST_FIN_TENDER ADD REDEMPTION_BEGIN_DATE DATETIME AFTER INVESTMENT_TOTAL;
ALTER TABLE ST_FIN_TENDER ADD REDEMPTION_END_DATE   DATETIME AFTER REDEMPTION_BEGIN_DATE;
ALTER TABLE ST_FIN_TENDER ADD REDEMPTION_USER_COUNT DATETIME AFTER REDEMPTION_COUNT;

-- 151005 修改统计表
ALTER TABLE ST_FIN_MEMBER ADD PHONE_CITY_ID   BIGINT      AFTER PHONE;
ALTER TABLE ST_FIN_MEMBER ADD PHONE_CITY_CODE VARCHAR(40) AFTER PHONE_CITY_ID;
ALTER TABLE ST_FIN_MEMBER ADD REDEMPTION_DATE DATETIME    AFTER INVESTMENT_DATE;

ALTER TABLE ST_FIN_CUSTOMER ADD REGISTER_DATE DATETIME AFTER CARD;

ALTER TABLE ST_FIN_MARKETER ADD REGISTER_DATE DATETIME AFTER PERFORMANCE_TOTAL;


-- 151005 修改版本更新表 sunhr
ALTER TABLE `EAI_DATA`.`DT_SYS_VERSION` ADD COLUMN `DOWNLOAD_URL` VARCHAR(800) NULL AFTER `END_DATE`, ADD COLUMN `DOWNLOAD_SIZE` BIGINT(20) NULL AFTER `DOWNLOAD_URL`; 
-- 151013 修改系统session表  sunhr
ALTER TABLE `EAI_CACHE`.`CC_SYS_SESSION` ADD COLUMN `APPLICATION_ID` BIGINT(20) NULL AFTER `PROJECT_ID`;  



-- 151015 修改统计表
ALTER TABLE ST_FIN_CUSTOMER ADD CARD_AREA   VARCHAR(6) AFTER CARD;
ALTER TABLE ST_FIN_CUSTOMER ADD CARD_BIRTH  VARCHAR(8) AFTER CARD_AREA;
ALTER TABLE ST_FIN_CUSTOMER ADD CARD_GENDER INTEGER    AFTER CARD_BIRTH;

ALTER TABLE ST_FIN_CUSTOMER ADD PHONE_CITY_ID   BIGINT      AFTER PHONE;
ALTER TABLE ST_FIN_CUSTOMER ADD PHONE_CITY_CODE VARCHAR(40) AFTER PHONE_CITY_ID;

ALTER TABLE ST_FIN_MARKETER ADD CARD_AREA   VARCHAR(6) AFTER CARD;
ALTER TABLE ST_FIN_MARKETER ADD CARD_BIRTH  VARCHAR(8) AFTER CARD_AREA;
ALTER TABLE ST_FIN_MARKETER ADD CARD_GENDER INTEGER    AFTER CARD_BIRTH;

ALTER TABLE ST_FIN_MARKETER ADD PHONE_CITY_ID   BIGINT      AFTER PHONE;
ALTER TABLE ST_FIN_MARKETER ADD PHONE_CITY_CODE VARCHAR(40) AFTER PHONE_CITY_ID;

-- 151017 修改版本表 sunhr
ALTER TABLE `EAI_DATA`.`DT_SYS_VERSION` CHANGE `NUMBER` `NUMBER` FLOAT(5,2) NOT NULL; 
-- 151019 修改版本表 sunhr
ALTER TABLE `EAI_DATA`.`DT_SYS_VERSION` CHANGE `CODE` `CODE` VARCHAR(40) CHARSET utf8 COLLATE utf8_general_ci NULL; 

-- 151030 修改版本表 maocy
ALTER TABLE DT_COM_CITY_CARD ADD COUNTRY_ID  BIGINT AFTER GUID;
ALTER TABLE DT_COM_CITY_CARD ADD AREA_ID     BIGINT AFTER COUNTRY_ID;
ALTER TABLE DT_COM_CITY_CARD ADD PROVINCE_ID BIGINT AFTER AREA_ID;

-- 151030 修改新闻、实时数据、销售工具的图片路径长度 sunhr
ALTER TABLE `EAI_DATA`.`DT_LGC_NEWS` CHANGE `ICON_URL` `ICON_URL` VARCHAR(400) CHARSET utf8 COLLATE utf8_general_ci NULL; 
ALTER TABLE `EAI_DATA`.`DT_LGC_SALESTOOLS` CHANGE `ICON_URL` `ICON_URL` VARCHAR(400) CHARSET utf8 COLLATE utf8_general_ci NULL; 
ALTER TABLE `EAI_DATA`.`DT_LGC_TRUETIME` CHANGE `ICON_URL` `ICON_URL` VARCHAR(400) CHARSET utf8 COLLATE utf8_general_ci NULL; 

-- 151102 修改公告的创建用户 sunhr
ALTER TABLE `EAI_DATA`.`DT_LGC_NOTICE` ADD COLUMN `USER_ID` BIGINT(20) NULL AFTER `GUID`; 
ALTER TABLE `EAI_DATA`.`DT_FIN_PRODUCT` ADD COLUMN `ICON_URL` VARCHAR(400) NULL AFTER `LABEL`; 

-- 151104 修改统计表 maocy
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL1_ID`      BIGINT(20)  AFTER `DEPARTMENT_LABEL_PATH`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL1_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL1_ID`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL1_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL1_LINK_ID`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL2_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL1_LABEL`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL2_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL2_ID`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL2_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL2_LINK_ID`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL3_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL2_LABEL`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL3_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL3_ID`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL3_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL3_LINK_ID`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL4_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL3_LABEL`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL4_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL4_ID`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL4_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL4_LINK_ID`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL5_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL4_LABEL`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL5_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL5_ID`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL5_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL5_LINK_ID`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL6_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL5_LABEL`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL6_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL6_ID`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL6_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL6_LINK_ID`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL7_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL6_LABEL`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL7_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL7_ID`; 
ALTER TABLE `ST_FIN_DYNAMIC` ADD COLUMN `DEPARTMENT_LEVEL7_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL7_LINK_ID`; 

ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL1_ID`      BIGINT(20)  AFTER `LABEL`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL1_LINK_ID` BIGINT(20)  AFTER `LEVEL1_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL1_LABEL`   VARCHAR(80) AFTER `LEVEL1_LINK_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL2_ID`      BIGINT(20)  AFTER `LEVEL1_LABEL`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL2_LINK_ID` BIGINT(20)  AFTER `LEVEL2_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL2_LABEL`   VARCHAR(80) AFTER `LEVEL2_LINK_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL3_ID`      BIGINT(20)  AFTER `LEVEL2_LABEL`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL3_LINK_ID` BIGINT(20)  AFTER `LEVEL3_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL3_LABEL`   VARCHAR(80) AFTER `LEVEL3_LINK_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL4_ID`      BIGINT(20)  AFTER `LEVEL3_LABEL`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL4_LINK_ID` BIGINT(20)  AFTER `LEVEL4_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL4_LABEL`   VARCHAR(80) AFTER `LEVEL4_LINK_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL5_ID`      BIGINT(20)  AFTER `LEVEL4_LABEL`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL5_LINK_ID` BIGINT(20)  AFTER `LEVEL5_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL5_LABEL`   VARCHAR(80) AFTER `LEVEL5_LINK_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL6_ID`      BIGINT(20)  AFTER `LEVEL5_LABEL`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL6_LINK_ID` BIGINT(20)  AFTER `LEVEL6_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL6_LABEL`   VARCHAR(80) AFTER `LEVEL6_LINK_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL7_ID`      BIGINT(20)  AFTER `LEVEL6_LABEL`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL7_LINK_ID` BIGINT(20)  AFTER `LEVEL7_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT` ADD COLUMN `LEVEL7_LABEL`   VARCHAR(80) AFTER `LEVEL7_LINK_ID`; 

ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LINK_ID`        BIGINT(20)  AFTER `DEPARTMENT_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL1_ID`      BIGINT(20)  AFTER `DEPARTMENT_LABEL`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL1_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL1_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL1_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL1_LINK_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL2_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL1_LABEL`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL2_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL2_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL2_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL2_LINK_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL3_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL2_LABEL`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL3_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL3_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL3_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL3_LINK_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL4_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL3_LABEL`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL4_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL4_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL4_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL4_LINK_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL5_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL4_LABEL`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL5_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL5_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL5_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL5_LINK_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL6_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL5_LABEL`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL6_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL6_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL6_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL6_LINK_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL7_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL6_LABEL`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL7_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL7_ID`; 
ALTER TABLE `ST_FIN_DEPARTMENT_PHASE` ADD COLUMN `DEPARTMENT_LEVEL7_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL7_LINK_ID`; 

ALTER TABLE `ST_FIN_MARKETER` ADD COLUMN `DEPARTMENT_LEVEL1_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL1_ID`; 
ALTER TABLE `ST_FIN_MARKETER` ADD COLUMN `DEPARTMENT_LEVEL2_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL2_ID`; 
ALTER TABLE `ST_FIN_MARKETER` ADD COLUMN `DEPARTMENT_LEVEL3_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL3_ID`; 
ALTER TABLE `ST_FIN_MARKETER` ADD COLUMN `DEPARTMENT_LEVEL4_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL4_ID`; 
ALTER TABLE `ST_FIN_MARKETER` ADD COLUMN `DEPARTMENT_LEVEL5_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL5_ID`; 
ALTER TABLE `ST_FIN_MARKETER` ADD COLUMN `DEPARTMENT_LEVEL6_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL6_ID`; 
ALTER TABLE `ST_FIN_MARKETER` ADD COLUMN `DEPARTMENT_LEVEL7_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL7_ID`; 

ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LINK_ID`        BIGINT(20)  AFTER `DEPARTMENT_ID`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL1_ID`      BIGINT(20)  AFTER `DEPARTMENT_LABEL`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL1_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL1_ID`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL1_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL1_LINK_ID`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL2_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL1_LABEL`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL2_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL2_ID`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL2_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL2_LINK_ID`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL3_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL2_LABEL`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL3_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL3_ID`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL3_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL3_LINK_ID`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL4_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL3_LABEL`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL4_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL4_ID`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL4_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL4_LINK_ID`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL5_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL4_LABEL`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL5_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL5_ID`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL5_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL5_LINK_ID`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL6_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL5_LABEL`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL6_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL6_ID`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL6_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL6_LINK_ID`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL7_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL6_LABEL`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL7_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL7_ID`; 
ALTER TABLE `ST_FIN_MARKETER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL7_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL7_LINK_ID`; 

ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LABEL`          VARCHAR(80) AFTER `DEPARTMENT_LINK_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL1_ID`      BIGINT(20)  AFTER `DEPARTMENT_LABEL`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL1_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL1_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL1_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL1_LINK_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL2_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL1_LABEL`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL2_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL2_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL2_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL2_LINK_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL3_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL2_LABEL`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL3_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL3_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL3_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL3_LINK_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL4_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL3_LABEL`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL4_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL4_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL4_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL4_LINK_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL5_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL4_LABEL`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL5_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL5_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL5_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL5_LINK_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL6_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL5_LABEL`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL6_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL6_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL6_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL6_LINK_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL7_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL6_LABEL`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL7_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL7_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER` ADD COLUMN `DEPARTMENT_LEVEL7_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL7_LINK_ID`; 

ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_ID`             BIGINT(20)  AFTER `LINK_DATE`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LINK_ID`        BIGINT(20)  AFTER `DEPARTMENT_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LABEL`          VARCHAR(80) AFTER `DEPARTMENT_LINK_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL1_ID`      BIGINT(20)  AFTER `DEPARTMENT_LABEL`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL1_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL1_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL1_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL1_LINK_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL2_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL1_LABEL`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL2_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL2_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL2_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL2_LINK_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL3_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL2_LABEL`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL3_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL3_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL3_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL3_LINK_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL4_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL3_LABEL`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL4_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL4_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL4_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL4_LINK_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL5_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL4_LABEL`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL5_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL5_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL5_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL5_LINK_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL6_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL5_LABEL`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL6_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL6_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL6_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL6_LINK_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL7_ID`      BIGINT(20)  AFTER `DEPARTMENT_LEVEL6_LABEL`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL7_LINK_ID` BIGINT(20)  AFTER `DEPARTMENT_LEVEL7_ID`; 
ALTER TABLE `ST_FIN_CUSTOMER_PHASE` ADD COLUMN `DEPARTMENT_LEVEL7_LABEL`   VARCHAR(80) AFTER `DEPARTMENT_LEVEL7_LINK_ID`; 

-- 151105 修改统计表 maocy
ALTER TABLE `ST_FIN_TENDER` ADD COLUMN `BORROW_STATUS` INTEGER AFTER `END_DATE`; 
ALTER TABLE `ST_FIN_TENDER` ADD COLUMN `RECOMMEND_CD`  INTEGER AFTER `BORROW_INFO`; 

-- 151108 修改金融成员表 sunhr
ALTER TABLE `EAI_DATA`.`DT_FIN_MEMBER` ADD COLUMN `ICON_URL` VARCHAR(400) NULL AFTER `LABEL`; 

