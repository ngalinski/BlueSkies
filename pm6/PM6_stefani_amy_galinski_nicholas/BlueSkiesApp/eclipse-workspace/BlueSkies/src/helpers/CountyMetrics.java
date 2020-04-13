package helpers;

import java.io.IOException;
import java.sql.SQLException;

import dal.CountyDAO;
import dal.SocioeconomicDAO;
import dal.AirQualityDAO;
import dal.HealthCareCoverageDAO;

import model.AirQuality;
import model.County;
import model.HealthCareCoverage;
import model.Socioeconomic;

// Class with county metric static methods
public class CountyMetrics {


	// County
	public static County readCounty(Integer countyCode, CountyDAO dao) throws IOException {
		County county;
        try {
        	county = dao.getCountyFromCountyCode(countyCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return county;
	}
	
	// Socioeconomic
	public static Socioeconomic readSocioeconomic(Integer countyCode, SocioeconomicDAO dao) throws IOException {
		Socioeconomic socioeconomic;
        try {
        	socioeconomic = dao.getSocioeconomicFromCountyCode(countyCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return socioeconomic;
	}
	
	// Air Quality
	public static AirQuality readAirQuality(Integer countyCode, AirQualityDAO dao) throws IOException {
		AirQuality airQuality;
        try {
        	airQuality = dao.getAirQualityFromCountyCode(countyCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return airQuality;
	}
	
	
	// Health Care Coverage
	public static HealthCareCoverage readHealthCareCoverage(Integer countyCode, HealthCareCoverageDAO dao) throws IOException {
		HealthCareCoverage healthCareCoverage;
        try {
        	healthCareCoverage = dao.getHealthCareCoverageByCountyCode(countyCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return healthCareCoverage;
	}

}