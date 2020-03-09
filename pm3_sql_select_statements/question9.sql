-- 9. What are the top 5 states with the most hospitals per 1000 residents?

SELECT t2.StateCode, t1.NumHospitals / (t2.TotalPop / 10000) as HospitalPer10000Residents, t1.NumHospitals, t2.TotalPop FROM
	(SELECT Count(t0.HospitalCode) as NumHospitals, t0.StateCode FROM
	(SELECT Hospital.HospitalCode, Hospital.ZipCode, Location.StateCode 
		FROM Hospital JOIN Location ON Hospital.ZipCode = Location.ZipCode 
		ORDER BY Location.StateCode ASC) t0
		GROUP BY t0.StateCode) t1
JOIN (
	SELECT Sum(Population) as TotalPop, StateCode FROM Location
	   GROUP BY StateCode
	   ORDER BY StateCode ASC ) t2
	ON t2.StateCode = t1.StateCode
ORDER BY HospitalPer10000Residents DESC
LIMIT 5;