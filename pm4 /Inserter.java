package tools;

import model.*;
import dal.*;

import java.sql.SQLException;
import java.util.List;

public class Inserter {

  public static void main(String[] args) throws SQLException {
	 AirQualityDAO airQualityDAO = AirQualityDAO.getInstance();
     CountyDAO countyDAO = CountyDAO.getInstance();
     HealthCareSpendingDAO healthCareSpendingDAO = HealthCareSpendingDAO.getInstance();
    HealthCareUtilizationDAO healthCareUtilizationDAO = HealthCareUtilizationDAO.getInstance();
//    HospitalDAO hospitalDAO = HospitalDAO.getInstance();
//    HospitalQualityDAO hospitalQualityDAO = HospitalQualityDAO.getInstance();
//    LocationDAO locationDAO = LocationDAO.getInstance();
//    StateDAO stateDAO = StateDAO.getInstance();

    //CREATE
    AirQuality airQuality = new AirQuality(9999,"WA",2,3,4,5,6,7,8,12,43,13);
	airQuality = airQualityDAO.create(airQuality);

    County county = new County("Testing4","WA");
    county = countyDAO.create(county);
    

    HealthCareSpending healthCareSpending = new HealthCareSpending("TE", 3, 2, 17, 6, 43);
    healthCareSpending = healthCareSpendingDAO.create(healthCareSpending);

    HealthCareUtilization healthCareUtilization = new HealthCareUtilization("AB", 1, 2, 3, 4, 5);
    healthCareUtilization = healthCareUtilizationDAO.create(healthCareUtilization);
	
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
	
	HealthCareSpending healthCareSpending2 = healthCareSpendingDAO.getHealthCareSpendingByState("TE");
	System.out.format("Health Care Spending for State: 'TEST' | Code: %s, TotalSpending: %s, InpatientServices: %s, OutpatientServices: %s, ProfessionalServices: %s, RxDrugs: %s, StateCode: %s \n",
			healthCareSpending2.getHealthCareSpendingCode(), healthCareSpending2.getTotalSpending(), healthCareSpending2.getInpatientServices(), healthCareSpending2.getOutpatientServices(), healthCareSpending2.getProfessionalServices(), healthCareSpending2.getRxDrugs(), healthCareSpending2.getStateCode());

	HealthCareUtilization healthCareUtilization1 = healthCareUtilizationDAO.getHealthCareUtilizationbyState("AB");
		System.out.format("Health Care Utilization for State: 'TEST' | Code: %s, TotalUtilization: %s, InpatientServices: %s, OutpatientServices: %s, ProfessionalServices: %s, RxDrugs: %s, StateCode: %s \n",
						healthCareUtilization1.getHealthCareUtilizationCode(), healthCareUtilization1.getTotalUtilization(), healthCareUtilization1.getInpatientServices(), healthCareUtilization1.getOutpatientServices(), healthCareUtilization1.getProfessionalServices(), healthCareUtilization1.getRxDrugs(), healthCareUtilization1.getStateCode());


		//UPDATE
	airQualityDAO.updateMedianAQI(airQuality2, 678);
	
	AirQuality airQuality2updated = airQualityDAO.getAirQualityFromCountyCode(9999);
	System.out.format("Air Quality for county (code): %s in the state of %s | MaxAQI: %s, MedianAQI: %s \n",
			airQuality2updated.getCountyCode(), airQuality2updated.getStateCode(), airQuality2updated.getMaxAQI(), airQuality2updated.getMedianAQI());
	
	countyDAO.updateCountyName(county, "NewName");
	
	HealthCareSpending healthCareSpending3 = healthCareSpendingDAO.updateTotalSpending(healthCareSpending2, 1234567890);

//	HealthCareSpending healthCareSpending3 = healthCareSpendingDAO.getHealthCareSpendingByState("TE");
	System.out.format("Health Care Spending for State after updating: 'TEST' | Code: %s, TotalSpending: %s, InpatientServices: %s, OutpatientServices: %s, ProfessionalServices: %s, RxDrugs: %s, StateCode: %s \n",
			healthCareSpending3.getHealthCareSpendingCode(), healthCareSpending3.getTotalSpending(), healthCareSpending3.getInpatientServices(), healthCareSpending3.getOutpatientServices(), healthCareSpending3.getProfessionalServices(), healthCareSpending3.getRxDrugs(), healthCareSpending3.getStateCode());

			
	
    //DELETE
	airQualityDAO.delete(airQuality2updated);
	countyDAO.delete(county);
	healthCareSpendingDAO.delete(healthCareSpending2);
	healthCareUtilizationDAO.delete(healthCareUtilization1);
  }
}