SELECT
	CompanyName,
	COUNT(*)
FROM
	Drug
GROUP BY
	CompanyName
LIMIT 10;