-- UNIQUEINDEX :

-- The Following Example Creates A Unique Index On The Email Column Of The Members Table :

CREATE UNIQUE INDEX IndexMembersEmail
ON Members(Email);

-- Create UniqueIndexDemo Table :

CREATE TABLE UniqueIndexDemo (
    A INT , B INT
);   

-- To Create A Unique Index On The Two Columns A And B , You Use The Following Statement :

CREATE UNIQUE INDEX IndexUniqueIndexAB
ON UniqueIndexDemo (A , B);

-- The Following Statement Inserts A New Row Into The UniqueIndexDemo Table :

INSERT INTO UniqueIndexDemo (A , B) VALUES(1 , 1);

-- The Following Statement Works Because The Pair (1 , 2) Does Not Exist :

INSERT INTO UniqueIndexDemo (A , B) VALUES(1 , 2);

-- The Following Statement Creates A Table Named T1 With A Primary Key :

CREATE TABLE T1 (
    PK1 INT PRIMARY KEY ,
    C1 INT
);

-- To Show The Indexes Of The T1 Table , You Use The Following Statement :

SELECT 
    Index_Name , Index_Type , Visibility , Status 
FROM 
    All_Indexes
WHERE 
    Table_Name = 'T1';
    
-- To Specify The Name For The Primary Key Column , You Use The UNIQUE Index As Shown In The Following Query :

CREATE TABLE T2 (
    PK2 INT PRIMARY KEY 
    USING INDEX (
        CREATE INDEX IndexT1PK1 ON T2 (PK2)
    ) ,
    C2 INT
);

-- In This Example , We Explicitly Specified The Name Of The Unique Index :

SELECT 
    Index_Name , Index_Type , Visibility , Status 
FROM 
    All_Indexes
WHERE 
    Table_Name = 'T2';