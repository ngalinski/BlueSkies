package model;

public class Location {
  private String zipCode;
  private String locationName;
  private String stateCode;
  private int population;
  private int countyCode;
  
  public Location(String zipCode, String locationName, String stateCode, int population, int countyCode) {
	  this.zipCode = zipCode;
	  this.locationName = locationName;
	  this.stateCode = stateCode;
	  this.population = population;
	  this.countyCode = countyCode;
  }
  
  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public String getStateCode() {
    return stateCode;
  }

  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  public int getCountyCode() {
    return countyCode;
  }

  public void setCountyCode(int countyCode) {
    this.countyCode = countyCode;
  }
}