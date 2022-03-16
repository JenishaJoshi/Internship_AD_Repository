-- FUNCTIONBASEDINDEX :

-- The Following Statement Creates An Index On The LastName Column Of The Members Table :

CREATE INDEX IndexMembersLastName 
ON Members (LastName);

-- If You Use The Last Name Column In The WHERE Clause , The Query Optimizer Will Definitely Use The Index :

SELECT * FROM Members
WHERE 
    LastName = 'Short';

-- However , If You Use A Function On The Indexed Column LastName As Follows :

SELECT * FROM Members
WHERE 
    UPPER(LastName) = 'Short';
    
-- The Following Statements Show The Execution Plan Of The Query Above :

EXPLAIN PLAN FOR
SELECT * FROM Members
WHERE 
    UPPER(LastName) = 'Short';

SELECT 
    PLAN_TABLE_OUTPUT 
FROM 
    TABLE(DBMS_XPLAN.DISPLAY());
    
-- The Following Statement Creates A Function - Based Index Based On The UPPER Function :

CREATE INDEX FBIMembersLastName
ON Members(UPPER(LastName));

-- Now , If You Find Members By The Last Name , The Query Optimizer Will Consider The Index As Shown In The Following Query Plan :

EXPLAIN PLAN FOR
SELECT * FROM Members
WHERE 
    UPPER(LastName) = 'Short';

SELECT 
    PLAN_TABLE_OUTPUT 
FROM 
    TABLE(DBMS_XPLAN.DISPLAY());