package model;

public class Location {
  private String LocationName;
  private String StateCode;
  private int Population;
  private int CountyCode;

  public String getLocationname() {
    return LocationName;
  }

  public void setLocationname(String LocationName) {
    this.LocationName = LocationName;
  }

  public String getStatecode() {
    return StateCode;
  }

  public void setStatecode(String StateCode) {
    this.StateCode = StateCode;
  }

  public int getPopulation() {
    return Population;
  }

  public void setPopulation(int Population) {
    this.Population = Population;
  }

  public int getCountycode() {
    return CountyCode;
  }

  public void setCountycode(int CountyCode) {
    this.CountyCode = CountyCode;
  }
}