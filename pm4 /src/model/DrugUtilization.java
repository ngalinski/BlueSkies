package model;

public class Drugutilization {
  private int DrugUtilCode;
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

  public int getDrugUtilCode() {
    return DrugUtilCode;
  }

  public void setDrugUtilCode(int drugUtilCode) {
    this.DrugUtilCode = drugUtilCode;
  }

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

  public String getNdc() {
    return NDC;
  }

  public void setNdc(String NDC) {
    this.NDC = NDC;
  }

  public int getLabel() {
    return Label;
  }

  public void setLabel(int Label) {
    this.Label = Label;
  }

  public int getProduct() {
    return Product;
  }

  public void setProduct(int Product) {
    this.Product = Product;
  }

  public int getSize() {
    return Size;
  }

  public void setSize(int Size) {
    this.Size = Size;
  }
}