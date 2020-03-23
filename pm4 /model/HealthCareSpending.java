package model;

public class HealthCareSpending {
  private int healthCareSpendingCode;
  private String stateCode;
  private int totalSpending;
  private int inpatientServices;
  private int outpatientServices;
  private int professionalServices;
  private int rxDrugs;

  public HealthCareSpending(int healthCareSpendingCode, String stateCode, int totalSpending, int inpatientServices, int outpatientServices, int professionalServices, int rxDrugs) {
	  this.healthCareSpendingCode = healthCareSpendingCode;
	  this.stateCode = stateCode;
	  this.totalSpending = totalSpending;
	  this.inpatientServices = inpatientServices;
	  this.outpatientServices = outpatientServices;
	  this.professionalServices = professionalServices;
	  this.rxDrugs = rxDrugs;
  }
  
  public HealthCareSpending(int healthCareSpendingCode) {
	  this.healthCareSpendingCode = healthCareSpendingCode;
  }
  
  public HealthCareSpending(String stateCode, int totalSpending, int inpatientServices, int outpatientServices, int professionalServices, int rxDrugs) {
	  this.stateCode = stateCode;
	  this.totalSpending = totalSpending;
	  this.inpatientServices = inpatientServices;
	  this.outpatientServices = outpatientServices;
	  this.professionalServices = professionalServices;
	  this.rxDrugs = rxDrugs;
  }
  
  public int getHealthCareSpendingCode() {
    return healthCareSpendingCode;
  }

  public void setHealthCareSpendingCode(int healthCareSpendingCode) {
    this.healthCareSpendingCode = healthCareSpendingCode;
  }
  
  public String getStateCode() {
    return stateCode;
  }

  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }

  public int getTotalSpending() {
    return totalSpending;
  }

  public void setTotalSpending(int totalSpending) {
    this.totalSpending = totalSpending;
  }

  public int getInpatientServices() {
    return inpatientServices;
  }

  public void setInpatientServices(int inpatientServices) {
    this.inpatientServices = inpatientServices;
  }

  public int getOutpatientServices() {
    return outpatientServices;
  }

  public void setOutpatientservices(int outpatientServices) {
    this.outpatientServices = outpatientServices;
  }

  public int getProfessionalServices() {
    return professionalServices;
  }

  public void setProfessionalServices(int professionalServices) {
    this.professionalServices = professionalServices;
  }

  public int getRxDrugs() {
    return rxDrugs;
  }

  public void setRxDrugs(int rxDrugs) {
    this.rxDrugs = rxDrugs;
  }
}