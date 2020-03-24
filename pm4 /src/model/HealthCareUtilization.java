package model;

public class HealthCareUtilization {
  private int healthCareUtilizationCode;
  private String stateCode;
  private double totalUtilization;
  private double inpatientServices;
  private double outpatientServices;
  private double professionalServices;
  private double rxDrugs;


  public HealthCareUtilization(int healthCareUtilizationCode, String stateCode, double totalUtilization, double inpatientServices, double outpatientServices, double professionalServices, double rxDrugs) {
	  this.healthCareUtilizationCode = healthCareUtilizationCode;
	  this.stateCode = stateCode;
	  this.totalUtilization = totalUtilization;
	  this.inpatientServices = inpatientServices;
	  this.outpatientServices = outpatientServices;
	  this.professionalServices = professionalServices;
	  this.rxDrugs = rxDrugs;
  }
  
  public HealthCareUtilization(int healthCareUtilizationCode) {
	  this.healthCareUtilizationCode = healthCareUtilizationCode;
  }
  
  public HealthCareUtilization(String stateCode, double totalUtilization, double inpatientServices, double outpatientServices, double professionalServices, double rxDrugs) {
	  this.stateCode = stateCode;
	  this.totalUtilization = totalUtilization;
	  this.inpatientServices = inpatientServices;
	  this.outpatientServices = outpatientServices;
	  this.professionalServices = professionalServices;
	  this.rxDrugs = rxDrugs;
  }
  
  
  public int getHealthCareUtilizationCode() {
    return healthCareUtilizationCode;
  }

  public void setHealthCareUtilizationCode(int healthCareUtilizationCode) {
    this.healthCareUtilizationCode = healthCareUtilizationCode;
  }
  
  public String getStateCode() {
    return stateCode;
  }

  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }

  public double getTotalUtilization() {
    return totalUtilization;
  }

  public void setTotalUtilization(double totalUtilization) {
    this.totalUtilization = totalUtilization;
  }

  public double getInpatientServices() {
    return inpatientServices;
  }

  public void setInpatientServices(double inpatientServices) {
    this.inpatientServices = inpatientServices;
  }

  public double getOutpatientServices() {
    return outpatientServices;
  }

  public void setOutpatientServices(double outpatientServices) {
    this.outpatientServices = outpatientServices;
  }

  public double getProfessionalServices() {
    return professionalServices;
  }

  public void setProfessionalServices(double professionalServices) {
    this.professionalServices = professionalServices;
  }

  public double getRxDrugs() {
    return rxDrugs;
  }

  public void setRxDrugs(double rxDrugs) {
    this.rxDrugs = rxDrugs;
  }
}