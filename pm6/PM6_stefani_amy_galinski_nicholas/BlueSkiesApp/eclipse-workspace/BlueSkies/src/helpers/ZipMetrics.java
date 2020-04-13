package helpers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.Hospital;
import model.HospitalQuality;
import model.Location;

import dal.LocationDAO;
import dal.HospitalDAO;
import dal.HospitalQualityDAO;

public class ZipMetrics {

	
	// Location (City or town)
	public static Location readZip(String zipCode, LocationDAO dao) throws IOException {
        Location location;
        try {
            location = dao.getLocationByZipCode(zipCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return location;
	}
	
	// Hospitals
	public static List<Hospital> readHospital(String zipCode, HospitalDAO dao) throws IOException {
		List<Hospital> hospitals;
        try {
        	hospitals = dao.getHospitalsByZipCode(zipCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return hospitals;
	}
	
	// Hospital Quality
	public static HospitalQuality readHospitalQuality(Integer hospitalCode, HospitalQualityDAO dao) throws IOException {
		HospitalQuality hospitalQuality;
        try {
        	hospitalQuality = dao.getHospitalQualityFromHospitalCode(hospitalCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return hospitalQuality;
	}
	
}
	