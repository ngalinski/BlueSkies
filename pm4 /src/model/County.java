package model;

public class County {
  private int countyCode;
  private String countyName;
  private String stateCode;
  
  public County(int countyCode, String countyName, String stateCode) {
	  this.countyCode = countyCode;
	  this.countyName = countyName;
	  this.stateCode = stateCode;
  }
  
  public County(String countyName, String stateCode) {
	  this.countyName = countyName;
	  this.stateCode = stateCode;
  }
  
  public County(int countyCode) {
	  this.countyCode = countyCode;
  }
  
  public int getCountyCode() {
	  return countyCode;
  }

  public void setCountyCode(int countyCode) {
     this.countyCode = countyCode;
  }
	  
  public String getCountyName() {
    return countyName;
  }

  public void setCountyName(String countyName) {
    this.countyName = countyName;
  }

  public String getStateCode() {
    return stateCode;
  }

  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }
}