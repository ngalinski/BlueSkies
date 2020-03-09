-- 6. Which counties have above average air quality ratings but no highly rated hospitals?
	SELECT DISTINCT t0.CountyName, t4.StateCode FROM 
    (SELECT County.CountyName, County.CountyCode FROM County) t0
    JOIN
	(SELECT t1.CountyCode, t1.StateCode, t1.MedianAQI, t3.OverallRating FROM   
	(SELECT CountyCode, StateCode, MedianAQI FROM AirQuality WHERE MedianAQI > (SELECT AVG(MedianAQI) FROM AirQuality)) t1
	JOIN
    (SELECT Location.CountyCode, t2.HospitalCode, t2.HospitalName, t2.OverallRating FROM Location JOIN
	(SELECT Hospital.ZipCode, HospitalQuality.HospitalCode, Hospital.HospitalName, HospitalQuality.OverallRating
		FROM HospitalQuality
		JOIN Hospital ON HospitalQuality.HospitalCode = Hospital.HospitalCode
		WHERE HospitalQuality.OverallRating < 4) t2
	ON Location.ZipCode = t2.ZipCode) t3
    ON t1.CountyCode = t3.CountyCode) t4
    ON t0.CountyCode = t4.CountyCode;