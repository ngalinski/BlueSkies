import model.*;
import dal.*;

import java.sql.Connection;
import java.sql.Data;
import java.sql.List;
import java.sql.SQLException;

public class Inserter {

  public static void main(String[] args) throws SQLException {
    AirQualityDAO airQualityDAO = AirQualityDAO.getInstance();
//    CountyDAO countyDAO = CountyDAO.getInstance();
//    HealthCareSpendingDAO healthCareSpendingDAO = HealthCareSpendingDAO.getInstance();
//    HealthCareUtilizationDAO healthCareUtilizationDAO = HealthCareUtilizationDAO.getInstance();
//    HospitalDAO hospitalDAO = HospitalDAO.getInstance();
//    HospitalQualityDAO hospitalQualityDAO = HospitalQualityDAO.getInstance();
//    LocationDAO locationDAO = LocationDAO.getInstance();
//    StateDAO stateDAO = StateDAO.getInstance();

    //CREATE
    AirQuality airQuality = new AirQuality(9999,"WA",2,3,4,5,6,7,8,12,43,13);
	airQuality = airQualityDAO.create(airQuality);

    //READ
	AirQuality airQuality2 = airQualityDAO.getAirQualityFromCountyCode(9999);
	System.out.format("Air Quality for county (code): %s in the state of %s | MaxAQI: %s, MedianAQI: %s \n",
			airQuality2.getCountyCode(), airQuality2.getStateCode(), airQuality2.getMaxAQI(), airQuality2.getMedianAQI());
	
    //UPDATE	
	airQualityDAO.updateMedianAQI(airQuality2, 678);
	
	AirQuality airQuality2updated = airQualityDAO.getAirQualityFromCountyCode(9999);
	System.out.format("Air Quality for county (code): %s in the state of %s | MaxAQI: %s, MedianAQI: %s \n",
			airQuality2updated.getCountyCode(), airQuality2updated.getStateCode(), airQuality2updated.getMaxAQI(), airQuality2updated.getMedianAQI());
	
    //DELETE
	airQualityDAO.delete(airQuality2updated);
  }
}