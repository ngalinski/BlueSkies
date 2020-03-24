package model;

public class HealthCareUtilization {
  private int healthCareUtilizationCode;
  private String StateCode;
  private double TotalUtilization;
  private double InpatientServices;
  private double OutpatientServices;
  private double ProfessionalServices;
  private double RxDrugs;

  public HealthCareUtilization(int healthCareUtilizationCode, String stateCode, int totalUtilization, int inpatientServices, int outpatientServices, int professionalServices, int rxDrugs) {
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

  public HealthCareUtilization(String stateCode, int totalUtilization, int inpatientServices, int outpatientServices, int professionalServices, int rxDrugs) {
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

  public String getStatecode() {
    return StateCode;
  }

  public void setStatecode(String StateCode) {
    this.StateCode = StateCode;
  }

  public double getTotalutilization() {
    return TotalUtilization;
  }

  public void setTotalutilization(double TotalUtilization) {
    this.TotalUtilization = TotalUtilization;
  }

  public double getInpatientservices() {
    return InpatientServices;
  }

  public void setInpatientservices(double InpatientServices) {
    this.InpatientServices = InpatientServices;
  }

  public double getOutpatientservices() {
    return OutpatientServices;
  }

  public void setOutpatientservices(double OutpatientServices) {
    this.OutpatientServices = OutpatientServices;
  }

  public double getProfessionalservices() {
    return ProfessionalServices;
  }

  public void setProfessionalservices(double ProfessionalServices) {
    this.ProfessionalServices = ProfessionalServices;
  }

  public double getRxdrugs() {
    return RxDrugs;
  }

  public void setRxdrugs(double RxDrugs) {
    this.RxDrugs = RxDrugs;
  }
}