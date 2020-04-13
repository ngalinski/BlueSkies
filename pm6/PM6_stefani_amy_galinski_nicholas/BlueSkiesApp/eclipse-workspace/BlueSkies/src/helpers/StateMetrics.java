package helpers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import dal.HealthCareSpendingDAO;
import dal.AsthmaImpactDAO;
import dal.DrugUtilizationDAO;
import dal.HealthCareUtilizationDAO;

import model.AsthmaImpact;
import model.DrugUtilization;
import model.HealthCareSpending;
import model.HealthCareUtilization;

// Class with state metric static methods
public class StateMetrics {

	// Health Care Spending
	public static HealthCareSpending readHealthCareSpending(String stateCode, HealthCareSpendingDAO dao) throws IOException {
		HealthCareSpending healthCareSpending;
		try {
			healthCareSpending = dao.getHealthCareSpendingByState(stateCode);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return healthCareSpending;
	}

	// Health Care Utilization
	public static HealthCareUtilization readHealthCareUtilization(String stateCode, HealthCareUtilizationDAO dao) throws IOException {
		HealthCareUtilization healthCareUtilization;
		try {
			healthCareUtilization = dao.getHealthCareUtilizationByState(stateCode);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return healthCareUtilization;
	}


	// Drug Utilization
	public static List<DrugUtilization> readDrugUtilization(String stateCode, DrugUtilizationDAO dao) throws IOException {
		List<DrugUtilization> drugUtilization;
		try {
			drugUtilization = dao.getDrugUtilbyState(stateCode);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return drugUtilization;
	}


	// Asthma Impact (Health Outcomes)
	public static HashMap<String, AsthmaImpact> readAsthmaImpact(String stateCode, AsthmaImpactDAO dao) throws IOException {
		HashMap<String, AsthmaImpact> asthmaImpactForState = new HashMap<String, AsthmaImpact>();
		try {
			AsthmaImpact mortalityRateCrude = dao.getAsthmaImpactMetricForState(stateCode, "Asthma mortality rate", "Crude Rate");
			AsthmaImpact mortalityRateNumber = dao.getAsthmaImpactMetricForState(stateCode, "Asthma mortality rate", "Number");
			AsthmaImpact prevalence = dao.getAsthmaImpactMetricForState(stateCode, "Adult asthma prevalence", "Percent");
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

}