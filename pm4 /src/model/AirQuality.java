package model;

public class AirQuality {
  private int airQualityCode;
  private int countyCode;
  private int daysWithAQI;
  private int goodDays;
  private int moderateDays;
  private int unhealthyForSensitiveDays;
  private int unhealthyDays;
  private int veryUnhealthyDays;
  private int hazardousDays;
  private int maxAQI;
  private int ninetiethPercentileAQI;
  private int medianAQI;
 
  public AirQuality(int airQualityCode, int countyCode, int daysWithAQI, int goodDays, int moderateDays, int unhealthyForSensitiveDays,
		  int unhealthyDays, int veryUnhealthyDays, int hazardousDays, int maxAQI, int ninetiethPercentileAQI, int medianAQI) {
		 this.airQualityCode = airQualityCode;
	  	 this.countyCode = countyCode;
		 this.daysWithAQI = daysWithAQI;
		 this.goodDays = goodDays;
		 this.moderateDays = moderateDays;
		 this.unhealthyForSensitiveDays = unhealthyForSensitiveDays;
		 this.unhealthyDays = unhealthyDays;
		 this.veryUnhealthyDays = veryUnhealthyDays;
		 this.hazardousDays = hazardousDays;
		 this.maxAQI = maxAQI;
		 this.ninetiethPercentileAQI =ninetiethPercentileAQI;
		 this.medianAQI = medianAQI;
  }
  
  public AirQuality(int countyCode, int daysWithAQI, int goodDays, int moderateDays, int unhealthyForSensitiveDays,
			 int unhealthyDays, int veryUnhealthyDays, int hazardousDays, int maxAQI, int ninetiethPercentileAQI, int medianAQI) {
		 this.countyCode = countyCode;
		 this.daysWithAQI = daysWithAQI;
		 this.goodDays = goodDays;
		 this.moderateDays = moderateDays;
		 this.unhealthyForSensitiveDays = unhealthyForSensitiveDays;
		 this.unhealthyDays = unhealthyDays;
		 this.veryUnhealthyDays = veryUnhealthyDays;
		 this.hazardousDays = hazardousDays;
		 this.maxAQI = maxAQI;
		 this.ninetiethPercentileAQI =ninetiethPercentileAQI;
		 this.medianAQI = medianAQI;
  }

  
  public AirQuality(int airQualityCode) {
	this.airQualityCode = airQualityCode;
  }
  
  
  public int getAirQualityCode() {
	  return airQualityCode;
  }
  
  public void setAirQualityCode(int airQualityCode) {
	  this.airQualityCode = airQualityCode;
  }
	  
  public int getCountyCode() {
    return countyCode;
  }

  public void setCountyCode(int countyCode) {
    this.countyCode = countyCode;
  }

  public int getDaysWithAQI() {
    return daysWithAQI;
  }

  public void setDaysWithAQI(int daysWithAQI) {
    this.daysWithAQI = daysWithAQI;
  }

  public int getGoodDays() {
    return goodDays;
  }

  public void setGoodDays(int goodDays) {
    this.goodDays = goodDays;
  }

  public int getModerateDays() {
    return moderateDays;
  }

  public void setModerateDays(int moderateDays) {
    this.moderateDays = moderateDays;
  }

  public int getUnhealthyForSensitiveDays() {
    return unhealthyForSensitiveDays;
  }

  public void setUnhealthyForSensitiveDays(int unhealthyForSensitiveDays) {
    this.unhealthyForSensitiveDays = unhealthyForSensitiveDays;
  }

  public int getUnhealthyDays() {
    return unhealthyDays;
  }

  public void setUnhealthyDays(int unhealthyDays) {
    this.unhealthyDays = unhealthyDays;
  }

  public int getVeryUnhealthyDays() {
    return veryUnhealthyDays;
  }

  public void setVeryUnhealthyDays(int veryUnhealthyDays) {
    this.veryUnhealthyDays = veryUnhealthyDays;
  }

  public int getHazardousDays() {
    return hazardousDays;
  }

  public void setHazardousDays(int hazardousDays) {
    this.hazardousDays = hazardousDays;
  }

  public int getMaxAQI() {
    return maxAQI;
  }

  public void setMaxAQI(int maxAQI) {
    this.maxAQI = maxAQI;
  }

  public int getNinetiethPercentileAQI() {
    return ninetiethPercentileAQI;
  }

  public void setNinetiethPercentileAQI(int ninetiethPercentileAQI) {
    this.ninetiethPercentileAQI = ninetiethPercentileAQI;
  }

  public int getMedianAQI() {
    return medianAQI;
  }

  public void setMedianAQI(int medianAQI) {
    this.medianAQI = medianAQI;
  }
}