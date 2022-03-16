-- NULLIF Statement :

-- The Following Statement Returns A Null Value Because The First Argument Equals The Second One :

SELECT
    NULLIF (100 , 100)
FROM
    Dual;
    
-- The Following Example Returns The First Value (100) Because The Two Arguments Are Different :

SELECT
    NULLIF (100 , 200)
FROM
    Dual;

-- The Following Example Causes An Error Because The First Argument Is Literal NULL :

-- SELECT
--    NULLIF (NULL , 100)
-- FROM
--    Dual;

-- The Following Statement Also Causes An Error Because The Data Types Of Arguments Are Different :

-- SELECT
--    NULLIF (10 , '20')
-- FROM
--    Dual;

-- To Fix It , We Use The TO_CHAR() Function To Convert The First Argument To A Value Of Character Data Type :

SELECT
    NULLIF (TO_CHAR(10) , '20')
FROM
    Dual;
    
-- The NULLIF() Function Is Logically Equivalent To The Following Searched CASE Expression :

-- CASE
--  WHEN e1 = e2 THEN
--  NULL
-- ELSE
--  e1
-- END

-- Create Budegt Table :

CREATE TABLE Budget
(
    SalesmanID NUMBER NOT NULL ,
    FiscalYear SMALLINT ,
    CurrentYear NUMBER ,
    PreviousYear NUMBER
);

-- Insert Data Into Budget Table :

INSERT INTO Budget VALUES (54 , 2017 , 120000 , 100000);  
INSERT INTO Budget VALUES (55 , 2017 , 200000 , 200000);  
INSERT INTO Budget VALUES (56 , 2017 , NULL , 150000);  
INSERT INTO Budget VALUES (57 , 2017 , 175000 , 175000);  
INSERT INTO Budget VALUES (59 , 2017 , 220000 , 200000);

-- The Following Query Retrieves The Sales Employees And Their Current Year’s Budgets. If The Current Year’s Budget Is The Same As The Previous Year’s One , It Returns A Literal String “Same As Last Year” :

SELECT
    SalesmanID , COALESCE (TO_CHAR(NULLIF(CurrentYear , PreviousYear)) , 'Same As Last Year') Budget
FROM
    Budget
WHERE
    CurrentYear IS NOT NULL;
    
-- The Following Statement Is Equivalent To The One Above But Uses The CASE Expression Instead :

SELECT
    SalesmanID,
CASE
    WHEN CurrentYear = PreviousYear
    THEN 'Same as last year'
    ELSE TO_CHAR (CurrentYear)
  END
FROM
    Budget
WHERE
    CurrentYear IS NOT NULL;