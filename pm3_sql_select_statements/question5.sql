-- 5. What are the top 5 counties in the U.S. rated by air quality?
SELECT t2.LocationName, t2.StateCode, t3.CountyName, t3.MedianAQI, t2.HospitalName, t2.OverallRating FROM
	-- Join location names (city names) with hospital and rating, joining on zipcode
	(SELECT Location.LocationName, Location.StateCode, Location.CountyCode, t1.HospitalCode, t1.OverallRating, t1.HospitalName, t1.ZipCode FROM
		(SELECT HospitalQuality.HospitalCode, HospitalQuality.OverallRating, Hospital.HospitalName, Hospital.ZipCode FROM HospitalQuality
			JOIN Hospital ON HospitalQuality.HospitalCode = Hospital.HospitalCode) t1
		JOIN Location ON Location.ZipCode = t1.ZipCode
		ORDER BY t1.OverallRating DESC) t2
	-- Join the highest hospital, ratings, and cities, with air quality based on county code
	 JOIN 
	 (SELECT AirQuality.CountyCode, County.CountyName, AirQuality.StateCode, AirQuality.MedianAQI FROM AirQuality
		 LEFT JOIN County ON County.CountyCode = AirQuality.CountyCode
		  ORDER BY AirQuality.MedianAQI ASC) t3 
	 ON t2.CountyCode = t3.CountyCode
	-- Order based on the highest rated hospitals and the lowest median AQI.
		ORDER BY t2.OverallRating DESC, t3.MedianAQI ASC
    LIMIT 5;