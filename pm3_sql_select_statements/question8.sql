-- 8. How many hospitals are in each state?
SELECT Location.StateCode, COUNT(HospitalCode)
FROM BlueSkiesUML.Location
LEFT JOIN BlueSkiesUML.Hospital
ON BlueSkiesUML.Location.Zipcode = BlueSkiesUML.Hospital.ZipCode
GROUP BY StateCode;