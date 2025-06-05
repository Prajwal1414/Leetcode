# Write your MySQL query statement below
Select name as Customers
From Customers
Left Join Orders on Customers.id = Orders.customerId
Where Orders.customerId is null