# Write your MySQL query statement below
Select MAX(salary) as SecondHighestSalary
From Employee
Where salary < (Select MAX(salary) from Employee)