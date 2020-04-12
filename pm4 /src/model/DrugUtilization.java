package model;

public class DrugUtilization {
  private int DrugUtilizationCode;
  private String StateCode;
  private String DrugName;
  private String NumReimbursed;
  private String NumRx;
  private String TotalReimbursed;
  private String MedicaidReimbursed;
  private String NonMedicaidReimbursed;
  private String NDC;
  private int Label;
  private int Product;
  private int Size;

  public String getStatecode() {
    return StateCode;
  }

  public void setStatecode(String StateCode) {
    this.StateCode = StateCode;
  }

  public String getDrugname() {
    return DrugName;
  }

  public void setDrugname(String DrugName) {
    this.DrugName = DrugName;
  }

  public String getNumreimbursed() {
    return NumReimbursed;
  }

  public void setNumreimbursed(String NumReimbursed) {
    this.NumReimbursed = NumReimbursed;
  }

  public String getNumrx() {
    return NumRx;
  }

  public void setNumrx(String NumRx) {
    this.NumRx = NumRx;
  }

  public String getTotalreimbursed() {
    return TotalReimbursed;
  }

  public void setTotalreimbursed(String TotalReimbursed) {
    this.TotalReimbursed = TotalReimbursed;
  }

  public String getMedicaidreimbursed() {
    return MedicaidReimbursed;
  }

  public void setMedicaidreimbursed(String MedicaidReimbursed) {
    this.MedicaidReimbursed = MedicaidReimbursed;
  }

  public String getNonmedicaidreimbursed() {
    return NonMedicaidReimbursed;
  }

  public void setNonmedicaidreimbursed(String NonMedicaidReimbursed) {
    this.NonMedicaidReimbursed = NonMedicaidReimbursed;
  }
}