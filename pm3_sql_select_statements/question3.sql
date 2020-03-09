-- 3. What are the top 5 counties in the U.S. rated by air quality?
	SELECT AirQuality.CountyCode, County.CountyName, AirQuality.StateCode, AirQuality.MedianAQI FROM AirQuality
    LEFT JOIN County ON County.CountyCode = AirQuality.CountyCode
		ORDER BY AirQuality.MedianAQI DESC
    LIMIT 5;