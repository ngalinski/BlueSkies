package model;

public class Airquality {
  private int CountyCode;
  private String StateCode;
  private int DaysWithAQI;
  private int GoodDaysCount;
  private int ModerateDaysCount;
  private int UnhealthyForSensitiveDaysCount;
  private int UnhealthyDays;
  private int VeryUnhealthyDays;
  private int HazardousDays;
  private int MaxAQI;
  private int 90thPercentileAQI;
  private int MedianAQI;

  public int getCountycode() {
    return CountyCode;
  }

  public void setCountycode(int CountyCode) {
    this.CountyCode = CountyCode;
  }

  public String getStatecode() {
    return StateCode;
  }

  public void setStatecode(String StateCode) {
    this.StateCode = StateCode;
  }

  public int getDayswithaqi() {
    return DaysWithAQI;
  }

  public void setDayswithaqi(int DaysWithAQI) {
    this.DaysWithAQI = DaysWithAQI;
  }

  public int getFooddayscount() {
    return GoodDaysCount;
  }

  public void setFooddayscount(int GoodDaysCount) {
    this.GoodDaysCount = GoodDaysCount;
  }

  public int getModeratedayscount() {
    return ModerateDaysCount;
  }

  public void setModeratedayscount(int ModerateDaysCount) {
    this.ModerateDaysCount = ModerateDaysCount;
  }

  public int getUnhealthyforsensitivedayscount() {
    return UnhealthyForSensitiveDaysCount;
  }

  public void setUnhealthyforsensitivedayscount(int UnhealthyForSensitiveDaysCount) {
    this.UnhealthyForSensitiveDaysCount = UnhealthyForSensitiveDaysCount;
  }

  public int getUnhealthydays() {
    return UnhealthyDays;
  }

  public void setUnhealthydays(int UnhealthyDays) {
    this.UnhealthyDays = UnhealthyDays;
  }

  public int getVeryunhealthydays() {
    return VeryUnhealthyDays;
  }

  public void Veryunhealthydays(int VeryUnhealthyDays) {
    this.VeryUnhealthyDays = VeryUnhealthyDays;
  }

  public int getHazardousdays() {
    return HazardousDays;
  }

  public void setHazardousdays(int HazardousDays) {
    this.HazardousDays = HazardousDays;
  }

  public int getMaxaqi() {
    return MaxAQI;
  }

  public void setMaxaqi(int MaxAQI) {
    this.MaxAQI = MaxAQI;
  }

  public int get90thpercentileaqi() {
    return 90thPercentileAQI;
  }

  public void set90thpercentileaqi(int 90thPercentileAQI) {
    this.90thPercentileAQI = 90thPercentileAQI;
  }

  public int getMedianaqi() {
    return MedianAQI;
  }

  public void setMedianaqi(int MedianAQI) {
    this.MedianAQI = MedianAQI;
  }
}