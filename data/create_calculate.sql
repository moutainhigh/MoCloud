-- ------------------------------------------------------------
-- Create table [Calculate.Financial.Product.Period]
-- 20151104 sunhr
-- ------------------------------------------------------------
DROP TABLE `CL_FIN_PRODUCT_PERIOD`
CREATE TABLE `CL_FIN_PRODUCT_PERIOD` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `PRODUCT_CODE`                  VARCHAR(3040), 
   `PRODUCT_ISSUE`                 INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MYISAM DEFAULT CHARSET=utf8; 

ALTER TABLE CL_FIN_PRODUCT_PERIOD 
   ADD CONSTRAINT CL_FIN_PDT_PRD_UK_GID UNIQUE ( GUID ); 
   
-- ------------------------------------------------------------
-- Create table [Calculate.Financial.Customer.Preferpv]
-- 20151105 sunhr
-- ------------------------------------------------------------
DROP TABLE `CL_FIN_CUSTOMER_PREFER_PV`
CREATE TABLE `CL_FIN_CUSTOMER_PREFER_PV` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `MEMBER_ID`                     BIGINT, 
   `PRODUCT_CODE`                  VARCHAR(30), 
   `TIME_SECTION`                  VARCHAR(30), 
   `PV`                            INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE CL_FIN_CUSTOMER_PREFER_PV 
   ADD CONSTRAINT CL_FIN_CST_PRF_PV_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Calculate.Financial.Customer.Productpv]
-- 20151105 sunhr
-- ------------------------------------------------------------
DROP TABLE `CL_FIN_CUSTOMER_PRODUCT_PV`
CREATE TABLE `CL_FIN_CUSTOMER_PRODUCT_PV` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `MEMBER_ID`                     BIGINT, 
   `PRODUCT_CODE`                  VARCHAR(30), 
   `PV`                            INTEGER, 
   `LAST_VIEW_TIME`                VARCHAR(30), 
   `FYEAR_MONTH`                   VARCHAR(30), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE CL_FIN_CUSTOMER_PRODUCT_PV 
   ADD CONSTRAINT CL_FIN_CST_PRD_PV_UK_GID UNIQUE ( GUID ); 