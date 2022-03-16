-- INLINEVIEW

-- The Following Query Retrieves The Top 10 Most Employee Names From The Employee Table :

SELECT * FROM
(
    SELECT
        EmployeeNumber , EmployeeName , Job
    FROM
        Employee
    ORDER BY
        Job DESC
)
WHERE
    ROWNUM <= 10;
    
-- The Following Example Joins An Inline View With A Table In The FROM clause. It Returns The Employee Names Categories And The Highest Job Of Employees In Each Category :

SELECT
    DepartmentName
FROM
    Department Dept ,
(
    SELECT
        DepartmentNumber , MAX(Salary) MaximumSalary
    FROM
        Employee
    GROUP BY
        DepartmentNumber
    ) Emp
WHERE
    Dept.DepartmentNumber = Emp.DepartmentNumber
ORDER BY
    DepartmentName;
    
-- By Using The LATERAL Keyword , An Inline View Can Reference The Table On The Left Of The Inline View Definition In The FROM Clause As Shown In The Following Example :

SELECT
    EmployeeName , DepartmentName
FROM
    Employee Emp ,
    LATERAL(
        SELECT * FROM
            Department Dept
        WHERE
            Emp.DepartmentNumber = Dept.DepartmentNumber
    )
ORDER BY
    EmployeeName;