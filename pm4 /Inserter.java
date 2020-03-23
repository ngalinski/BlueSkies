package tools;

import model.*;
import dal.*;

import java.sql.SQLException;
import java.util.List;

public class Inserter {

  public static void main(String[] args) throws SQLException {
	 AirQualityDAO airQualityDAO = AirQualityDAO.getInstance();
     CountyDAO countyDAO = CountyDAO.getInstance();
//    HealthCareSpendingDAO healthCareSpendingDAO = HealthCareSpendingDAO.getInstance();
//    HealthCareUtilizationDAO healthCareUtilizationDAO = HealthCareUtilizationDAO.getInstance();
//    HospitalDAO hospitalDAO = HospitalDAO.getInstance();
//    HospitalQualityDAO hospitalQualityDAO = HospitalQualityDAO.getInstance();
//    LocationDAO locationDAO = LocationDAO.getInstance();
//    StateDAO stateDAO = StateDAO.getInstance();

    //CREATE
    AirQuality airQuality = new AirQuality(9999,"WA",2,3,4,5,6,7,8,12,43,13);
	airQuality = airQualityDAO.create(airQuality);

    County county = new County("Testing","WA");
    county = countyDAO.create(county);
	
    //READ
	AirQuality airQuality2 = airQualityDAO.getAirQualityFromCountyCode(9999);
	System.out.format("Air Quality for county (code): %s in the state of %s | MaxAQI: %s, MedianAQI: %s \n",
			airQuality2.getCountyCode(), airQuality2.getStateCode(), airQuality2.getMaxAQI(), airQuality2.getMedianAQI());
	
	List<County> countiesList = countyDAO.getCountiesbyName("King");
	System.out.format("Getting counties named 'King'\n");
	for(County c : countiesList) {
		System.out.format("%s: %s, %s\n",
			c.getCountyCode(), c.getCountyName(), c.getStateCode());
	}
	
	
    //UPDATE	
	airQualityDAO.updateMedianAQI(airQuality2, 678);
	
	AirQuality airQuality2updated = airQualityDAO.getAirQualityFromCountyCode(9999);
	System.out.format("Air Quality for county (code): %s in the state of %s | MaxAQI: %s, MedianAQI: %s \n",
			airQuality2updated.getCountyCode(), airQuality2updated.getStateCode(), airQuality2updated.getMaxAQI(), airQuality2updated.getMedianAQI());
	
	countyDAO.updateCountyName(county, "NewName");
	
    //DELETE
	airQualityDAO.delete(airQuality2updated);
	countyDAO.delete(county);
  }
}