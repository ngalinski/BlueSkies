-- 2. What are the 10 most populous locations without a hospital?
SELECT Location.LocationName, Location.ZipCode, Location.Population, COUNT(HospitalCode)
FROM BlueSkiesUML.Location
LEFT JOIN BlueSkiesUML.Hospital
ON BlueSkiesUML.Location.Zipcode = BlueSkiesUML.Hospital.ZipCode
GROUP BY ZipCode
HAVING COUNT(HospitalCode) < 1
ORDER BY Location.Population DESC
LIMIT 10;