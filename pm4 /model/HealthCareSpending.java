package model;

public class Healthcarespending {
  private String StateCode;
  private int TotalSpending;
  private int InpatientServices;
  private int OutpatientServices;
  private int ProfessionalServices;
  private int RxDrugs;

  public String getStatecode() {
    return StateCode;
  }

  public void setStatecode(String StateCode) {
    this.StateCode = StateCode;
  }

  public int getTotalspending() {
    return TotalSpending;
  }

  public void setTotalspending(int TotalSpending) {
    this.TotalSpending = TotalSpending;
  }

  public int getInpatientservices() {
    return InpatientServices;
  }

  public void setInpatientservices(int InpatientServices) {
    this.InpatientServices = InpatientServices;
  }

  public int getOutpatientservices() {
    return OutpatientServices;
  }

  public void setOutpatientservices(int OutpatientServices) {
    this.OutpatientServices = OutpatientServices;
  }

  public int getProfessionalservices() {
    return ProfessionalServices;
  }

  public void setProfessionalservices(int ProfessionalServices) {
    this.ProfessionalServices = ProfessionalServices;
  }

  public int getRxdrugs() {
    return RxDrugs;
  }

  public void setRxdrugs(int RxDrugs) {
    this.RxDrugs = RxDrugs;
  }
}