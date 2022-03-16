-- The Following Statement Returns Two Because The First Argument Is Null :

SELECT
    NVL2 (NULL , 1 , 2)
FROM
    Dual;
    
-- The Following Example Returns The Second Argument Which Is The ABC String Because The First Argument Is Not Null :

SELECT
    NVL2 (1 , 'ABC' , 'XYZ')
FROM
    Dual;
    
-- Create Compensation Table :

CREATE  TABLE Compensation (
    EmployeeID NUMBER ,
    EffectiveDate DATE ,
    Salary NUMBER NOT NULL ,
    Commission NUMBER ,
    PRIMARY KEY (EmployeeID , EffectiveDate) ,
    FOREIGN KEY (EmployeeID) REFERENCES Employees (EmployeeID)
);

-- Insert Data Into Compensation Table :

INSERT INTO Compensation (EmployeeID , EffectiveDate , Salary , Commission) VALUES (7369 , DATE '2017-01-01' , 100000 , NULL);

INSERT INTO Compensation (EmployeeID , EffectiveDate , Salary , Commission) VALUES (7499 , DATE '2017-01-01' , 100000 , 20000);

INSERT INTO Compensation (EmployeeID , EffectiveDate , Salary , Commission) VALUES (7521 , DATE '2017-01-01' , 100000 , 10000);

-- The Following Query Calculates The Total Compensations Of Employees From The Beginning Of 2017 :

SELECT
    EmployeeID , NVL2 (Commission , Salary + Commission , Salary)
FROM
    Compensation
WHERE
    EffectiveDate >= DATE '2017-01-01';