SELECT CompanyName, COUNT(*)
FROM Drug
GROUP BY CompanyName
ORDER BY CompanyName DESC
LIMIT 10;