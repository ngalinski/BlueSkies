SELECT StateCode, DrugName, MAX(NumRX)
FROM DrugUtilization
GROUP BY StateCode;