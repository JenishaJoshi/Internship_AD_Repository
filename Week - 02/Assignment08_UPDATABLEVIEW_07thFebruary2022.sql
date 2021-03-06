-- UPDATABLEVIEW :

-- Create Brand Table :

CREATE TABLE Brand (
	BrandID NUMBER GENERATED BY DEFAULT AS IDENTITY ,
	BrandName VARCHAR2 (50) NOT NULL ,
	PRIMARY KEY (BrandID)
);

-- Create Car Table :

CREATE TABLE Car (
	CarID NUMBER GENERATED BY DEFAULT AS IDENTITY ,
	CarName VARCHAR2 (255) NOT NULL ,
	BrandID NUMBER NOT NULL ,
	PRIMARY KEY (CarID) ,
	FOREIGN KEY (BrandID) 
	REFERENCES Brand (BrandID) ON DELETE CASCADE
);

-- Insert Data Into Brand Table :

INSERT INTO Brand (BrandName) VALUES('Audi');

INSERT INTO Brand (BrandName) VALUES('BMW');

INSERT INTO Brand (BrandName) VALUES('Ford');

INSERT INTO Brand (BrandName) VALUES('Honda');

INSERT INTO Brand (BrandName) VALUES('Toyota');

-- Insert Data Into Car Table :

INSERT INTO Car (CarName , BrandID) VALUES('Audi R8 Coupe' , 1);

INSERT INTO Car (CarName , BrandID) VALUES('Audi Q2' , 1);

INSERT INTO Car (CarName , BrandID) VALUES('Audi S1' , 1);

INSERT INTO Car (CarName , BrandID) VALUES('BMW 2 - Serie Cabrio' , 2);

INSERT INTO Car (CarName , BrandID) VALUES('BMW I8' , 2);

INSERT INTO Car (CarName , BrandID) VALUES('Ford Edge' , 3);

INSERT INTO Car (CarName , BrandID) VALUES('Ford Mustang Fastback' , 3);

INSERT INTO Car (CarName , BrandID) VALUES('Honda S2000' , 4);

INSERT INTO Car (CarName , BrandID) VALUES('Honda Legend' , 4);

INSERT INTO Car (CarName , BrandID) VALUES('Toyota GT86' , 5);

INSERT INTO Car (CarName , BrandID) VALUES('Toyota C - HR' , 5);

-- The Following Statement Creates A New View Named CarMaster :

CREATE VIEW CarMaster AS 
SELECT
    CarID , CarName
FROM
    Car;
    
-- It?s Possible To Delete A Row From The Car Table Via The CarMaster View , For Example :

DELETE
FROM
    CarMaster
WHERE
    CarID = 1;
    
-- And You Can Update Any Column Values Exposed To The CarMaster View :

UPDATE
    CarMaster
SET
    CarName = 'Audi RS7 Sportback'
WHERE
    CarID = 2;
    
-- Let?s Create A Join View Named AllCars Based On The Cars And Brands Tables :

CREATE VIEW AllCars AS 
SELECT
    CarID , CarName , C.BrandID , BrandName
FROM
    Car c
INNER JOIN Brand B ON
    B.BrandID = C.BrandID; 
    
-- The Following Statement Inserts A New Row Into The Car Table Via The All Cars View :

INSERT INTO AllCars (CarName , BrandID) VALUES ('Audi A5 Cabriolet' , 1);

-- The Following Statement Deletes All Honda Cars From The Cars Table Via The AllCars View :

DELETE
FROM
    AllCars
WHERE
    BrandName = 'Honda';

-- To Find Which Column Can Be Updated , Inserted  Or Deleted , You Use The User_Updatable_Columns View. The Following Example Shows Which Column Of The AllCars View Is Updatable , Insertable And Deletable :

SELECT *
FROM
    USER_UPDATABLE_COLUMNS
WHERE
    TABLE_NAME = 'ALLCARS';