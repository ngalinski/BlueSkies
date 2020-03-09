-- 4. What cities are home to the top 20 hospitals (ranked across all metrics)?
SELECT Location.LocationName, Location.StateCode, Location.ZipCode, t2.HospitalName, t2.OverallRating, t2.HospitalCode FROM 
	(SELECT t1.HospitalCode, t1.OverallRating, Hospital.HospitalName, Hospital.ZipCode FROM 
	(SELECT * FROM HospitalQuality
		ORDER BY OverallRating DESC, Mortality DESC, Safety DESC, Readmission DESC, PatientExperience DESC, Effectiveness DESC, Timeliness DESC, EfficientUseMedicalImaging DESC
		LIMIT 20) t1
	JOIN Hospital ON t1.HospitalCode = Hospital.HospitalCode) t2
    JOIN Location ON t2.ZipCode = Location.ZipCode
    ORDER BY Location.LocationName ASC;