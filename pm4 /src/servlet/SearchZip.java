package servlet;

import dal.*;
import model.*;
import helpers.*;

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

	protected LocationDAO locationDAO;
	protected HospitalDAO hospitalDAO;
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
		locationDAO = LocationDAO.getInstance();
		hospitalDAO = HospitalDAO.getInstance();
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
        	Location location = ZipMetrics.readZip(zipCode, locationDAO);
        	List<Hospital> hospitals = ZipMetrics.readHospital(zipCode, hospitalDAO);
        	List<HospitalAndQuality> hospitalsWithQuality = new ArrayList<HospitalAndQuality>();
             
        	AirQuality avgAirQuality;
			try {
				avgAirQuality = airQualityDAO.getAverageAirQuality();
				req.setAttribute("avgairquality", avgAirQuality);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        	// Get metrics for location
        	for (int i = 0; i < hospitals.size(); i++) {
        		HospitalQuality quality = ZipMetrics.readHospitalQuality(hospitals.get(i).getHospitalCode(), hospitalQualityDAO);
        		HospitalAndQuality hospitalAndQuality = new HospitalAndQuality(hospitals.get(i), quality);
        		hospitalsWithQuality.add(hospitalAndQuality);
        	}
       
        	// Get metrics for state
         	if (location != null) {
            	HashMap<String, AsthmaImpact> asthmaImpactByMetric = StateMetrics.readAsthmaImpact(location.getStateCode(), asthmaImpactDAO);
            	HealthCareSpending healthCareSpending = StateMetrics.readHealthCareSpending(location.getStateCode(), healthCareSpendingDAO);
            	HealthCareUtilization healthCareUtilization = StateMetrics.readHealthCareUtilization(location.getStateCode(), healthCareUtilizationDAO);
             	List<DrugUtilization> drugUtilization = StateMetrics.readDrugUtilization(location.getStateCode(), drugUtilizationDAO);
            	
             	HealthCareCoverage healthCareCoverage = CountyMetrics.readHealthCareCoverage(location.getCountyCode(), healthCareCoverageDAO);
            	AirQuality airQuality = CountyMetrics.readAirQuality(location.getCountyCode(), airQualityDAO);
            	Socioeconomic socioeconomic = CountyMetrics.readSocioeconomic(location.getCountyCode(), socioeconomicDAO);
            	County county = CountyMetrics.readCounty(location.getCountyCode(), countyDAO);
            	
	            req.setAttribute("location", location);
	            req.setAttribute("hospitals", hospitalsWithQuality);
	            req.setAttribute("asthmaimpactbymetric", asthmaImpactByMetric);
	            req.setAttribute("healthcarespending", healthCareSpending);
	            req.setAttribute("healthcareutilization", healthCareUtilization);
	            req.setAttribute("drugutilization", drugUtilization);
	            
	            // Metrics for county
	            req.setAttribute("county", county);
	            req.setAttribute("healthcarecoverage", healthCareCoverage);
	            req.setAttribute("airquality", airQuality);
	            req.setAttribute("socioeconomic", socioeconomic);

	            req.getRequestDispatcher("/SearchZip.jsp").forward(req, resp);
	            
        	} else {
        		messages.put("failure", "Data not found for that location. Please try again with another zip code.");
	            req.setAttribute("location", location);
	            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        	}
        }
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
        	Location location = ZipMetrics.readZip(zipCode, locationDAO);
        	List<Hospital> hospitals = ZipMetrics.readHospital(zipCode, hospitalDAO);
        	List<HospitalAndQuality> hospitalsWithQuality = new ArrayList<HospitalAndQuality>();
              	
        	AirQuality avgAirQuality;
        	AsthmaImpact avgAsthmaImpactMortalityNumber;
        	AsthmaImpact avgAsthmaImpactMortalityCrude;
        	AsthmaImpact avgAsthmaImpactPrevalence;
        	HealthCareCoverage avgHealthCareCoverage;
        	HealthCareSpending avgHealthCareSpending;
        	HealthCareUtilization avgHealthCareUtilization;
        	Socioeconomic avgSocioeconomic;


			try {
				// Get averages
				avgAirQuality = airQualityDAO.getAverageAirQuality();
				avgAsthmaImpactMortalityNumber = asthmaImpactDAO.getAsthmaImpactAveragesByMetric("Asthma mortality rate", "Number");
				avgAsthmaImpactMortalityCrude = asthmaImpactDAO.getAsthmaImpactAveragesByMetric("Asthma mortality rate", "Crude Rate");
				avgAsthmaImpactPrevalence = asthmaImpactDAO.getAsthmaImpactAveragesByMetric("Adult asthma prevalence", "Percent");
				
				HashMap<String, AsthmaImpact> avgAsthmaImpactForState = new HashMap<String, AsthmaImpact>();
				avgAsthmaImpactForState.put("Mortality (Crude Rate, per 1,000,000)", avgAsthmaImpactMortalityCrude);
				avgAsthmaImpactForState.put("Mortality (Number)", avgAsthmaImpactMortalityNumber);
				avgAsthmaImpactForState.put("Adult Asthma Prevalence (% of Population)", avgAsthmaImpactPrevalence);
				
				avgSocioeconomic = socioeconomicDAO.getSocioeconomicAvgs();				
				avgHealthCareCoverage = healthCareCoverageDAO.getAverageHealthCareCov();
				avgHealthCareSpending = healthCareSpendingDAO.getHealthCareSpendingAvgs();
				avgHealthCareUtilization = healthCareUtilizationDAO.getAvgHealthCareUtilization();

				
				req.setAttribute("avgairquality", avgAirQuality);
				req.setAttribute("avgasthmaimpactforstate", avgAsthmaImpactForState);
				req.setAttribute("avghealthcarecoverage", avgHealthCareCoverage);
				req.setAttribute("avghealthcarespending", avgHealthCareSpending);
				req.setAttribute("avghealthcareutilization", avgHealthCareUtilization);
				req.setAttribute("avgsocioeconomic", avgSocioeconomic);

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        	// Get metrics for location
        	for (int i = 0; i < hospitals.size(); i++) {
        		HospitalQuality quality = ZipMetrics.readHospitalQuality(hospitals.get(i).getHospitalCode(), hospitalQualityDAO);
        		HospitalAndQuality hospitalAndQuality = new HospitalAndQuality(hospitals.get(i), quality);
        		hospitalsWithQuality.add(hospitalAndQuality);
        	}
       
        	// Get metrics for state
         	if (location != null) {
            	HashMap<String, AsthmaImpact> asthmaImpactByMetric = StateMetrics.readAsthmaImpact(location.getStateCode(), asthmaImpactDAO);
            	HealthCareSpending healthCareSpending = StateMetrics.readHealthCareSpending(location.getStateCode(), healthCareSpendingDAO);
            	HealthCareUtilization healthCareUtilization = StateMetrics.readHealthCareUtilization(location.getStateCode(), healthCareUtilizationDAO);
             	List<DrugUtilization> drugUtilization = StateMetrics.readDrugUtilization(location.getStateCode(), drugUtilizationDAO);
            	
             	HealthCareCoverage healthCareCoverage = CountyMetrics.readHealthCareCoverage(location.getCountyCode(), healthCareCoverageDAO);
            	AirQuality airQuality = CountyMetrics.readAirQuality(location.getCountyCode(), airQualityDAO);
            	Socioeconomic socioeconomic = CountyMetrics.readSocioeconomic(location.getCountyCode(), socioeconomicDAO);
            	County county = CountyMetrics.readCounty(location.getCountyCode(), countyDAO);
            	
	            req.setAttribute("location", location);
	            req.setAttribute("hospitals", hospitalsWithQuality);
	            req.setAttribute("asthmaimpactbymetric", asthmaImpactByMetric);
	            req.setAttribute("healthcarespending", healthCareSpending);
	            req.setAttribute("healthcareutilization", healthCareUtilization);
	            req.setAttribute("drugutilization", drugUtilization);
	            
	            // Metrics for county
	            req.setAttribute("county", county);
	            req.setAttribute("healthcarecoverage", healthCareCoverage);
	            req.setAttribute("airquality", airQuality);
	            req.setAttribute("socioeconomic", socioeconomic);

	            req.getRequestDispatcher("/SearchZip.jsp").forward(req, resp);
	            
        	} else {
        		messages.put("failure", "Data not found for that location. Please try again with another zip code.");
	            req.setAttribute("location", location);
	            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        	}
        }
	}
}
