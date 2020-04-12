package model;

public class Location {
	  private String zipCode;
	  private String stateCode;
	  private int countyCode;
	  private String locationName;
	  private int population;
	  
	public Location(String zipCode, String stateCode, int countyCode, String locationName, int population) {
		this.zipCode = zipCode;
		this.stateCode = stateCode;
		this.countyCode = countyCode;
		this.locationName = locationName;
		this.population = population;
	}
	
	public Location(String stateCode, int countyCode, String locationName, int population) {
		this.stateCode = stateCode;
		this.countyCode = countyCode;
		this.locationName = locationName;
		this.population = population;
	}
	
	public Location(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getStateCode() {
		return stateCode;
	}
	
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	
	public int getCountyCode() {
		return countyCode;
	}
	
	public void setCountyCode(int countyCode) {
		this.countyCode = countyCode;
	}
	
	public String getLocationName() {
		return locationName;
	}
	
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setPopulation(int population) {
		this.population = population;
	}

}