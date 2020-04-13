package servlet;

import dal.*;
import model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Search zip 
 */
@WebServlet("/searchzip")
public class SearchZip extends HttpServlet {

	protected LocationDAO locationDao;
	protected HospitalDAO hospitalDao;
	protected HospitalQualityDAO hospitalQualityDAO;
	protected HealthCareSpendingDAO healthCareSpendingDAO;
	protected HealthCareUtilizationDAO healthCareUtilizationDAO;
	protected DrugUtilizationDAO drugUtilizationDAO;
	protected AsthmaImpactDAO asthmaImpactDAO;
	protected CountyDAO countyDAO;
	protected SocioeconomicDAO socioeconomicDAO;
	protected AirQualityDAO airQualityDAO;
	protected HealthCareCoverageDAO healthCareCoverageDAO;

	
	@Override
	public void init() throws ServletException {
		locationDao = LocationDAO.getInstance();
		hospitalDao = HospitalDAO.getInstance();
		hospitalQualityDAO = HospitalQualityDAO.getInstance();
		healthCareSpendingDAO = HealthCareSpendingDAO.getInstance();
		healthCareUtilizationDAO = HealthCareUtilizationDAO.getInstance();
		drugUtilizationDAO = DrugUtilizationDAO.getInstance();
		asthmaImpactDAO = AsthmaImpactDAO.getInstance();
		countyDAO = CountyDAO.getInstance();
		socioeconomicDAO = SocioeconomicDAO.getInstance();
		airQualityDAO = AirQualityDAO.getInstance();
		healthCareCoverageDAO = HealthCareCoverageDAO.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        
        
        // Retrieve and validate zip code.
        String zipCode = req.getParameter("zipcode");
        if (zipCode == null || zipCode.trim().isEmpty()) {
            messages.put("invalidzip", "Please enter a valid zip code.");
            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
      
        // Search zip code for location and hospitals   
        } else {
        	Location location = this.doZipSearch(zipCode);
        	List<Hospital> hospitals = this.doHospitalSearch(zipCode);
        	List<HospitalAndQuality> hospitalsWithQuality = new ArrayList<HospitalAndQuality>();
        	
        	for (int i = 0; i < hospitals.size(); i++) {
        		HospitalQuality quality = doHospitalQualitySearch(hospitals.get(i).getHospitalCode());
        		HospitalAndQuality hospitalAndQuality = new HospitalAndQuality(hospitals.get(i), quality);
        		hospitalsWithQuality.add(hospitalAndQuality);
        	}
       
         	if (location != null) {
	            req.setAttribute("location", location);
	            req.setAttribute("hospitals", hospitalsWithQuality);
	            req.getRequestDispatcher("/SearchZip.jsp").forward(req, resp);
	            
        	} else {
        		messages.put("failure", "Data not found for that location. Please try again with another zip code.");
	            req.setAttribute("location", location);
	            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        	}
        }
	}
	
	// ZIP Metrics --------- 
	
	// Location (City or town)
	protected Location doZipSearch(String zipCode) throws IOException {
        Location location;
        try {
            location = locationDao.getLocationByZipCode(zipCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return location;
	}
	
	// Hospitals
	protected List<Hospital> doHospitalSearch(String zipCode) throws IOException {
		List<Hospital> hospitals;
        try {
        	hospitals = hospitalDao.getHospitalsByZipCode(zipCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return hospitals;
	}
	
	// Hospital Quality
	protected HospitalQuality doHospitalQualitySearch(Integer hospitalCode) throws IOException {
		HospitalQuality hospitalQuality;
        try {
        	hospitalQuality = hospitalQualityDAO.getHospitalQualityFromHospitalCode(hospitalCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return hospitalQuality;
	}
	
	// STATE Metrics --------- 
		
	// Health Care Spending
	protected HealthCareSpending doHealthCareSpendingSearch(String stateCode) throws IOException {
		HealthCareSpending healthCareSpending;
        try {
        	healthCareSpending = healthCareSpendingDAO.getHealthCareSpendingByState(stateCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return healthCareSpending;
	}
	
	// Health Care Utilization
	protected HealthCareUtilization doHealthCareUtilizationSearch(String stateCode) throws IOException {
		HealthCareUtilization healthCareUtilization;
        try {
        	healthCareUtilization = healthCareUtilizationDAO.getHealthCareUtilizationByState(stateCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return healthCareUtilization;
	}
	
	// Drug Utilization
//	protected List<DrugUtilization> doDrugUtilizationSearch(String stateCode) throws IOException {
//		List<DrugUtilization> drugUtilization;
//        try {
//        	drugUtilization = drugUtilizationDAO.getDrugUtilbyState(stateCode);
//         } 
//        catch (SQLException e) {
//    		e.printStackTrace();
//    		throw new IOException(e);
//        }
//		return drugUtilization;
//	}

	// Asthma Impact (Health Outcomes)
	protected HashMap<String, AsthmaImpact> doAsthmaImpactSearch(String stateCode) throws IOException {
		HashMap<String, AsthmaImpact> asthmaImpactForState = new HashMap<String, AsthmaImpact>();
        try {
        	AsthmaImpact mortalityRateCrude = asthmaImpactDAO.getAsthmaImpactMetricForState(stateCode, "Asthma mortality rate", "Crude Rate");
        	AsthmaImpact mortalityRateNumber = asthmaImpactDAO.getAsthmaImpactMetricForState(stateCode, "Asthma mortality rate", "Number");
        	AsthmaImpact prevalence = asthmaImpactDAO.getAsthmaImpactMetricForState(stateCode, "Adult asthma prevalence", "Percent");
        	asthmaImpactForState.put("Mortality (Crude Rate, per 1,000,000)", mortalityRateCrude);
        	asthmaImpactForState.put("Mortality (Number)", mortalityRateNumber);
        	asthmaImpactForState.put("Adult Asthma Prevalence (% of Population)", prevalence);
        } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return asthmaImpactForState;
	}
	
	
	// COUNTY metrics --------- 
	
	// County
	protected County doCountySearch(Integer countyCode) throws IOException {
		County county;
        try {
        	county = countyDAO.getCountyFromCountyCode(countyCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return county;
	}
	
	// Socioeconomic
	protected Socioeconomic doSocioeconomicSearch(Integer countyCode) throws IOException {
		Socioeconomic socioeconomic;
        try {
        	socioeconomic = socioeconomicDAO.getSocioeconomicFromCountyCode(countyCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return socioeconomic;
	}
	
	// Air Quality
	protected AirQuality doAirQualitySearch(Integer countyCode) throws IOException {
		AirQuality airQuality;
        try {
        	airQuality = airQualityDAO.getAirQualityFromCountyCode(countyCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return airQuality;
	}
	
	
	// Health Care Coverage
	protected HealthCareCoverage doHealthCareCoverageSearch(Integer countyCode) throws IOException {
		HealthCareCoverage healthCareCoverage;
        try {
        	healthCareCoverage = healthCareCoverageDAO.getHealthCareCoverageByCountyCode(countyCode);
         } 
        catch (SQLException e) {
    		e.printStackTrace();
    		throw new IOException(e);
        }
		return healthCareCoverage;
	}
	
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate zip code.
        String zipCode = req.getParameter("zipcode");
        if (zipCode == null || zipCode.trim().isEmpty()) {
            messages.put("invalidzip", "Please enter a valid zip code.");
            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
      
        } else {
        	Location location = this.doZipSearch(zipCode);
        	List<Hospital> hospitals = this.doHospitalSearch(zipCode);
        	List<HospitalAndQuality> hospitalsWithQuality = new ArrayList<HospitalAndQuality>();
              	
        	// Get metrics for location
        	for (int i = 0; i < hospitals.size(); i++) {
        		HospitalQuality quality = doHospitalQualitySearch(hospitals.get(i).getHospitalCode());
        		HospitalAndQuality hospitalAndQuality = new HospitalAndQuality(hospitals.get(i), quality);
        		hospitalsWithQuality.add(hospitalAndQuality);
        	}
       
        	// Get metrics for state
         	if (location != null) {
            	HashMap<String, AsthmaImpact> asthmaImpactByMetric = this.doAsthmaImpactSearch(location.getStateCode());
            	HealthCareSpending healthcareSpending = doHealthCareSpendingSearch(location.getStateCode());
            	HealthCareUtilization healthCareUtilization = doHealthCareUtilizationSearch(location.getStateCode());
//            	List<DrugUtilization> drugUtilization = doDrugUtilizationSearch(location.getStateCode());
            	HealthCareCoverage healthCareCoverage = doHealthCareCoverageSearch(location.getCountyCode());
            	AirQuality airQuality = doAirQualitySearch(location.getCountyCode());
            	Socioeconomic socioeconomic = doSocioeconomicSearch(location.getCountyCode());
            	County county = doCountySearch(location.getCountyCode());
            	
	            req.setAttribute("location", location);
	            req.setAttribute("hospitals", hospitalsWithQuality);
	            req.setAttribute("asthmaimpactbymetric", asthmaImpactByMetric);
	            req.setAttribute("healthcarespending", healthcareSpending);
	            req.setAttribute("healthcareutilization", healthCareUtilization);
	            req.setAttribute("county", county);
	            req.setAttribute("healthcarecoverage", healthCareCoverage);
	            req.setAttribute("airquality", airQuality);
	            req.setAttribute("socioeconomic", socioeconomic);

	            
//	            req.setAttribute("drugutilization", drugUtilization);

	            req.getRequestDispatcher("/SearchZip.jsp").forward(req, resp);
	            
        	} else {
        		messages.put("failure", "Data not found for that location. Please try again with another zip code.");
	            req.setAttribute("location", location);
	            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        	}
        }
	}
}
