SELECT BlueSkiesUML.Location.StateCode, BlueSkiesUML.Hospital.HospitalCode
FROM BlueSkiesUML.Location
LEFT JOIN BlueSkiesUML.Hospital
ON BlueSkiesUML.Location.Zipcode = BlueSkiesUML.Hospital.ZipCode
GROUP BY StateCode
ORDER BY COUNT(*) DESC;