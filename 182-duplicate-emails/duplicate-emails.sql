# Write your MySQL query statement below
Select email as Email 
From Person p
Group By email
Having COUNT(email) > 1;
