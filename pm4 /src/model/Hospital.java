package model;

public class Hospital {
  private int hospitalCode;
  private String hospitalName;
  private String zipCode;
  
  public Hospital(String hospitalName, String zipCode) {
	  this.hospitalName = hospitalName;
	  this.zipCode = zipCode;
  }

  public Hospital(int hospitalCode, String hospitalName, String zipCode) {
	  this.hospitalCode = hospitalCode;
	  this.hospitalName = hospitalName;
	  this.zipCode = zipCode;
  }
  

  public Hospital(int hospitalCode) {
	  this.hospitalCode = hospitalCode;
  }   

  
  public void setHospitalCode(int hospitalCode) {
	  this.hospitalCode = hospitalCode;
  }
  
  public int getHospitalCode() {
    return hospitalCode;
  }
  
  public void setHospitalName(String hospitalName) {
	  this.hospitalName = hospitalName;
  }
  
  public String getHospitalName() {
    return hospitalName;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
}