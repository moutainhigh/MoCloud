﻿-- ------------------------------------------------------------
-- Create table [Statistics.Controller]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_CONTROLLER`;
CREATE TABLE `ST_CONTROLLER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CODE`                          VARCHAR(40), 
   `IS_VALID`                      TINYINT, 
   `LINK_ID`                       BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `PROCESS_CLASS`                 VARCHAR(200), 
   `PROCESS_PARAMETERS`            VARCHAR(400), 
   `PROCESS_COUNT`                 INTEGER, 
   `PROCESS_UNIT_TOTAL`            INTEGER, 
   `PROCESS_UNIT_COUNT`            INTEGER, 
   `PROCESS_RESULT`                VARCHAR(200), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_CONTROLLER 
   ADD CONSTRAINT ST_CTL_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Dynamic]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_DYNAMIC`;
CREATE TABLE `ST_FIN_DYNAMIC` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LINK_ID`                       BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `DEPARTMENT_ID`                 BIGINT, 
   `DEPARTMENT_LABEL`              VARCHAR(40), 
   `DEPARTMENT_IDS`                VARCHAR(200), 
   `DEPARTMENT_LABELS`             VARCHAR(400), 
   `MARKETER_ID`                   BIGINT, 
   `MARKETER_LABEL`                VARCHAR(40), 
   `MARKETER_STATUS_CD`            INTEGER, 
   `MARKETER_RANK`                 VARCHAR(40), 
   `CUSTOMER_ID`                   BIGINT, 
   `CUSTOMER_LABEL`                VARCHAR(40), 
   `CUSTOMER_PHONE`                VARCHAR(20), 
   `CUSTOMER_CARD`                 VARCHAR(20), 
   `CUSTOMER_ACTION_CD`            INTEGER, 
   `CUSTOMER_ACTION_DATE`          DATETIME, 
   `CUSTOMER_ACTION_AMOUNT`        DOUBLE, 
   `CUSTOMER_ACTION_INTEREST`      DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_DYNAMIC 
   ADD CONSTRAINT ST_FIN_DYN_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_DYNAMIC ADD INDEX ST_FIN_DYN_IX_CST_ACT_DAT(CUSTOMER_ACTION_DATE);

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Amount]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_AMOUNT`;
CREATE TABLE `ST_FIN_AMOUNT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LINK_ID`                       BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `DEPARTMENT_TOTAL`              INTEGER, 
   `MARKETER_TOTAL`                INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_AMOUNT 
   ADD CONSTRAINT ST_FIN_AMT_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Customer]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_CUSTOMER`;
CREATE TABLE `ST_FIN_CUSTOMER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CUSTOMER_ID`                   BIGINT NOT NULL, 
   `LINK_DATE`                     DATETIME, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_CUSTOMER 
   ADD CONSTRAINT ST_FIN_CUS_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_CUSTOMER 
   ADD CONSTRAINT ST_FIN_CUS_UK_CUSTOMER_ID UNIQUE ( CUSTOMER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Marketer]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_MARKETER`;
CREATE TABLE `ST_FIN_MARKETER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `MARKETER_ID`                   BIGINT NOT NULL, 
   `LINK_DATE`                     DATETIME, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_MARKETER 
   ADD CONSTRAINT ST_FIN_MKT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_MARKETER 
   ADD CONSTRAINT ST_FIN_MKT_UK_MARKETER_ID UNIQUE ( MARKETER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Phase]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_PHASE`;
CREATE TABLE `ST_FIN_PHASE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40), 
   `RECORD_YEAR`                   DATETIME NOT NULL, 
   `RECORD_MONTH`                  DATETIME NOT NULL, 
   `RECORD_WEEK`                   DATETIME NOT NULL, 
   `RECORD_DAY`                    DATETIME NOT NULL, 
   `RECORD_HOUR`                   DATETIME NOT NULL, 
   `RECORD_DATE`                   DATETIME NOT NULL, 
   `LINK_ID`                       BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `ACTION_DATE`                   DATETIME, 
   `DEPARTMENT_COUNT`              INTEGER, 
   `DEPARTMENT_TOTAL`              INTEGER, 
   `MARKETER_COUNT`                INTEGER, 
   `MARKETER_TOTAL`                INTEGER, 
   `CUSTOMER_COUNT`                INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `INVESTMENT`                    DOUBLE, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION`                    DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT`                 DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST`                      DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE`                   DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_PHASE 
   ADD CONSTRAINT ST_FIN_PHS_UK_DAT UNIQUE ( RECORD_DATE ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Customer.Amount]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_CUSTOMER_AMOUNT`;
CREATE TABLE `ST_FIN_CUSTOMER_AMOUNT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CUSTOMER_ID`                   BIGINT NOT NULL, 
   `CUSTOMER_LABEL`                VARCHAR(40), 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_CUSTOMER_AMOUNT 
   ADD CONSTRAINT ST_FIN_CST_AMT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_CUSTOMER_AMOUNT 
   ADD CONSTRAINT ST_FIN_CST_AMT_UK_CUSTOMER_ID UNIQUE ( CUSTOMER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Customer.Phase]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_CUSTOMER_PHASE`;
CREATE TABLE `ST_FIN_CUSTOMER_PHASE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40), 
   `RECORD_YEAR`                   DATETIME NOT NULL, 
   `RECORD_MONTH`                  DATETIME NOT NULL, 
   `RECORD_WEEK`                   DATETIME NOT NULL, 
   `RECORD_DAY`                    DATETIME NOT NULL, 
   `RECORD_HOUR`                   DATETIME NOT NULL, 
   `RECORD_DATE`                   DATETIME NOT NULL, 
   `LINK_ID`                       BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `CUSTOMER_ID`                   BIGINT, 
   `CUSTOMER_LABEL`                VARCHAR(40), 
   `CUSTOMER_ACTION_DATE`          DATETIME, 
   `INVESTMENT`                    DOUBLE, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION`                    DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT`                 DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST`                      DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE`                   DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_CUSTOMER_PHASE 
   ADD CONSTRAINT ST_FIN_CST_PHS_UK_DAT UNIQUE ( RECORD_DATE, CUSTOMER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Marketer.Customer]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_MARKETER_CUSTOMER`;
CREATE TABLE `ST_FIN_MARKETER_CUSTOMER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `MARKETER_ID`                   BIGINT, 
   `CUSTOMER_ID`                   BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_MARKETER_CUSTOMER 
   ADD CONSTRAINT ST_FIN_MKT_CUSTOMER_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_MARKETER_CUSTOMER 
   ADD CONSTRAINT ST_FIN_MKT_CUSTOMER_UK_CUS UNIQUE ( MARKETER_ID, CUSTOMER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Marketer.Amount]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_MARKETER_AMOUNT`;
CREATE TABLE `ST_FIN_MARKETER_AMOUNT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `DEPARTMENT_ID`                 INTEGER, 
   `DEPARTMENT_LABEL`              VARCHAR(40), 
   `MARKETER_ID`                   BIGINT NOT NULL, 
   `MARKETER_LABEL`                VARCHAR(40), 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_MARKETER_AMOUNT 
   ADD CONSTRAINT ST_FIN_MKT_AMT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_MARKETER_AMOUNT 
   ADD CONSTRAINT ST_FIN_MKT_AMT_UK_MARKETER_ID UNIQUE ( MARKETER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Marketer.Phase]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_MARKETER_PHASE`;
CREATE TABLE `ST_FIN_MARKETER_PHASE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40), 
   `RECORD_YEAR`                   DATETIME NOT NULL, 
   `RECORD_MONTH`                  DATETIME NOT NULL, 
   `RECORD_WEEK`                   DATETIME NOT NULL, 
   `RECORD_DAY`                    DATETIME NOT NULL, 
   `RECORD_HOUR`                   DATETIME NOT NULL, 
   `RECORD_DATE`                   DATETIME NOT NULL, 
   `LINK_ID`                       BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `DEPARTMENT_ID`                 BIGINT, 
   `DEPARTMENT_LABEL`              VARCHAR(40), 
   `MARKETER_ID`                   BIGINT, 
   `MARKETER_LABEL`                VARCHAR(40), 
   `MARKETER_INVESTMENT`           DOUBLE, 
   `MARKETER_INVESTMENT_TOTAL`     DOUBLE, 
   `MARKETER_REDEMPTION`           DOUBLE, 
   `MARKETER_REDEMPTION_TOTAL`     DOUBLE, 
   `MARKETER_NETINVESTMENT`        DOUBLE, 
   `MARKETER_NETINVESTMENT_TOTAL`  DOUBLE, 
   `MARKETER_INTEREST`             DOUBLE, 
   `MARKETER_INTEREST_TOTAL`       DOUBLE, 
   `MARKETER_PERFORMANCE`          DOUBLE, 
   `MARKETER_PERFORMANCE_TOTAL`    DOUBLE, 
   `CUSTOMER_ACTION_DATE`          DATETIME, 
   `CUSTOMER_REGISTER`             INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_MARKETER_PHASE 
   ADD CONSTRAINT ST_FIN_MKT_PHS_UK_DAT UNIQUE ( RECORD_DATE, MARKETER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Department.Customer]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_DEPARTMENT_CUSTOMER`;
CREATE TABLE `ST_FIN_DEPARTMENT_CUSTOMER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `DEPARTMENT_ID`                 BIGINT, 
   `MARKETER_ID`                   BIGINT, 
   `CUSTOMER_ID`                   BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_DEPARTMENT_CUSTOMER 
   ADD CONSTRAINT ST_FIN_DEP_CUS_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_DEPARTMENT_CUSTOMER 
   ADD CONSTRAINT ST_FIN_DEP_CUS_UK_CST UNIQUE ( DEPARTMENT_ID, CUSTOMER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Department.Marketer]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_DEPARTMENT_MARKETER`;
CREATE TABLE `ST_FIN_DEPARTMENT_MARKETER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `DEPARTMENT_ID`                 BIGINT NOT NULL, 
   `DEPARTMENT_LEVEL`              INTEGER, 
   `MARKETER_ID`                   BIGINT NOT NULL, 
   `LINK_DATE`                     DATETIME, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_DEPARTMENT_MARKETER 
   ADD CONSTRAINT ST_FIN_DEP_MKT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_DEPARTMENT_MARKETER 
   ADD CONSTRAINT ST_FIN_DEP_MKT_UK_MKT UNIQUE ( DEPARTMENT_ID, MARKETER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Department.Amount]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_DEPARTMENT_AMOUNT`;
CREATE TABLE `ST_FIN_DEPARTMENT_AMOUNT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `DEPARTMENT_ID`                 BIGINT NOT NULL, 
   `DEPARTMENT_LABEL`              VARCHAR(40), 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `MARKETER_TOTAL`                INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_DEPARTMENT_AMOUNT 
   ADD CONSTRAINT ST_FIN_DEP_AMOUNT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_DEPARTMENT_AMOUNT 
   ADD CONSTRAINT ST_FIN_DEP_AMOUNT_UK_DEPARTMENT_ID UNIQUE ( DEPARTMENT_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Department.Phase]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_DEPARTMENT_PHASE`;
CREATE TABLE `ST_FIN_DEPARTMENT_PHASE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40), 
   `RECORD_YEAR`                   DATETIME NOT NULL, 
   `RECORD_MONTH`                  DATETIME NOT NULL, 
   `RECORD_WEEK`                   DATETIME NOT NULL, 
   `RECORD_DAY`                    DATETIME NOT NULL, 
   `RECORD_HOUR`                   DATETIME NOT NULL, 
   `RECORD_DATE`                   DATETIME NOT NULL, 
   `LINK_ID`                       BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `DEPARTMENT_ID`                 BIGINT, 
   `DEPARTMENT_LABEL`              VARCHAR(40), 
   `DEPARTMENT_INVESTMENT`         DOUBLE, 
   `DEPARTMENT_INVESTMENT_TOTAL`   DOUBLE, 
   `DEPARTMENT_REDEMPTION`         DOUBLE, 
   `DEPARTMENT_REDEMPTION_TOTAL`   DOUBLE, 
   `DEPARTMENT_NETINVESTMENT`      DOUBLE, 
   `DEPARTMENT_NETINVESTMENT_TOTAL` DOUBLE, 
   `DEPARTMENT_INTEREST`           DOUBLE, 
   `DEPARTMENT_INTEREST_TOTAL`     DOUBLE, 
   `DEPARTMENT_PERFORMANCE`        DOUBLE, 
   `DEPARTMENT_PERFORMANCE_TOTAL`  DOUBLE, 
   `MARKETER_REGISTER`             INTEGER, 
   `MARKETER_TOTAL`                BIGINT, 
   `CUSTOMER_ACTION_DATE`          DATETIME, 
   `CUSTOMER_REGISTER`             INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_DEPARTMENT_PHASE 
   ADD CONSTRAINT ST_FIN_DEP_PHS_UK_DAT UNIQUE ( RECORD_DATE, DEPARTMENT_ID ); 