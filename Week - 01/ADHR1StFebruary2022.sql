-- (1). Display All The Information Of The Employee Table :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee;
    
-- (2). Display Unique Jobs From Employee Table :

SELECT 
	DISTINCT Job
FROM
    Employee;
    
-- (3). List The Employees In The Ascending Order Of Their Salaries :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
ORDER BY
	Salary;
    
-- (4). List The Details Of The Employees In Ascending Order Of The Department Numbers And Descending Of Jobs :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
ORDER BY
	DepartmentNumber , Job DESC;
    
-- (5). Display All The Unique Job Groups In The Descending Order :

SELECT 
	DISTINCT Job
FROM
    Employee
ORDER BY
	Job DESC;
    
-- (6). Display All The Details Of All ‘Managers’ :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
WHERE
	Job = 'Manager';
    
-- (7). List The Employees Who Joined Before 81 :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
WHERE
	HireDate < ('01-January-81');

-- (8). List The Employee Number , Employee Name , Salary , Daily Salary Of All Employees In The Ascending Order Of Annual Salary :

SELECT 
    EmployeeNumber , EmployeeName , Salary , ROUND((12 * Salary / 365) , 2) "Daily Salary" , (12 * Salary) "Annual Salary"
FROM
    Employee
ORDER BY
    "Annual Salary";
    
-- (9). Display The Employee Number , Employee Name , Job , HireDate , Experience Of All Managers :
    
SELECT 
    EmployeeNumber , EmployeeName , Job , HireDate , ROUND(MONTHS_BETWEEN(SYSDATE , HireDate)) "Experience"
FROM 
    Employee
WHERE
    Job = 'Manager';

-- (10). List The Employee Number , Employee Name , Salary , Experience Of All Employees Working For Manager 7369.

SELECT 
    EmployeeNumber , EmployeeName , Job , HireDate , ROUND(MONTHS_BETWEEN(SYSDATE , HireDate)) "Experience"
FROM 
    Employee
WHERE
    EmployeeNumber = 7369;
        
-- (11). Display All The Details Of The Employees Whose Commission Is More Than Their Salary :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
WHERE
	Commission > Salary;

-- (12). List The Employees Along With Their Exp And Daily Salary Is More Than Rupees 100 :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber , ROUND((12 * Salary / 365) , 2) "Daily Salary"
FROM
    Employee
WHERE
	Salary / 30 > 100;
    
-- (13). List The Employees Who Are Either ‘Clerk’ Or ‘Analyst’ in the Descending Order :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber , ROUND((12 * Salary / 365) , 2) "Daily Salary"
FROM
    Employee
WHERE
	Job = 'Analyst' OR Job = 'Clerk' 
ORDER BY 
    Job DESC;
    
-- (14). List The Employees Who Joined On 01-May-81 , 03-Dec-81 , 17-Dec-81 , 19-Jan-80 In Ascending Order Of Seniority :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
WHERE
	HireDate IN ('01-May-81' , '03-Dec-81' , '17-Dec-81' , '19-Jan-80')
ORDER BY 
    HireDate;
    
-- (15). List The Employee Who Are Working For The Department Number 10 Or 20 :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
WHERE
    DepartmentNumber = 10 OR DepartmentNumber = 20;
    
-- (16). List The Employees Who Are Joined In The Year 1981 :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
WHERE
    HireDate BETWEEN '01-Jan-81' AND '31-Dec-81';
        
-- (17). List the Employees Who Annual Salary Ranging From 22000 And 45000 :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber , Salary * 12 AS "Annual Salary"
FROM
    Employee
WHERE
    Salary * 12 BETWEEN 22000 AND 45000;
        
-- (18). List The Employee Names Those Are Having Five Characters In Their Names :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
WHERE
    LENGTH(EmployeeName) = 5;
        
-- (19). List The Employee Names Those Are Starting With ‘S’ And With Five Characters :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
WHERE
    EmployeeName LIKE 'S%' AND LENGTH(EmployeeName) = 5;
        
-- (20). List The Employees Those Are Having Four Characters And Third Character Must Be ‘r’ :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
WHERE
    LENGTH(EmployeeName) = 4 AND EmployeeName LIKE '__r%';
        
-- (21). List The Five Character Names Starting With ‘S’ And Ending With ‘H’ :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
WHERE
    LENGTH(EmployeeName) = 5 AND EmployeeName LIKE 'S%h';
        
-- (22). List The Employees Who Joined In January :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
WHERE
    TO_CHAR(HireDate , 'mon') = 'jan';

-- (23). List The Employees Whose Names Having A Character Set ‘ll’ Together :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
WHERE
    EmployeeName LIKE '%ll%';
    
-- (24). List The Employees Who Does Not Belong To Department Number 20 :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
    Employee
WHERE
    DepartmentNumber != 20;
        
-- (25). List All The Employees Except 'President' And 'Manager' In Ascending Order Of Salaries :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
   	Employee
WHERE
    Job NOT IN ('President' , 'Manager')
ORDER BY
	Salary;
    
-- (26). List The Employees Whose Employee Number Not Starting With Digit 78 :

SELECT 
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
   	Employee
WHERE
    EmployeeNumber NOT LIKE '78%';
    
-- (27). List The Employees Who Are Working Under ‘Manager’ :

SELECT
	Emp.EmployeeNumber , Emp.EmployeeName , Emp.Manager , E.EmployeeName
FROM 
    	Employee Emp JOIN Employee E
    	ON Emp.Manager = E.EmployeeNumber;
        
-- (28). List The Employees Who Joined In Any Year But Not Belongs To The Month Of March :

SELECT
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
	Employee
WHERE
	TO_CHAR(HireDate , 'MON') NOT IN ('Mar');

-- (29). List All The Clerks Of Department Number 20 :

SELECT
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
	Employee
WHERE
	Job = 'Clerk' AND DepartmentNumber = 20;
    
-- (30). List The Employees Of Department Number 30 Or 10 Joined In The Year 1981 :

SELECT
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
	Employee
WHERE
	DepartmentNumber = 10 OR DepartmentNumber = 20 AND TO_CHAR(HireDate,'YYYY') = '1981';
    
-- (31). Display The Details Of Smith :

SELECT
	EmployeeNumber , EmployeeName , Job , Manager , HireDate , Salary , Commission , DepartmentNumber , BranchNumber
FROM
	Employee
WHERE
	EmployeeName = 'Smith';

-- (32). Display The Location Of Smith :

SELECT
    E.EmployeeNumber , E.EmployeeName , E.Job , E.Manager , E.HireDate , E.Salary , E.Commission , E.DepartmentNumber , E.BranchNumber , B.Location 
FROM 
    Employee E , Branch B , Department D
WHERE
    E.EmployeeName = 'Smith' AND E.DepartmentNumber = D.DepartmentNumber AND D.BranchNumber = B.BranchNumber;