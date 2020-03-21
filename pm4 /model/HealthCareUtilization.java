package model;

public class HealthCareUtilization {
  private String StateCode;
  private double TotalUtilization;
  private double InpatientServices;
  private double OutpatientServices;
  private double ProfessionalServices;
  private double RxDrugs;

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