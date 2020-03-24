package model;

public class HospitalQuality {
  private int hospitalQualityCode;
  private int hospitalCode;
  private int overallRating;
  private int mortality;
  private int safety;
  private int readmission;
  private int patientExperience;
  private int effectiveness;
  private int timeliness;
  private int efficientUseMedicalImaging;
 

  public HospitalQuality(int hospitalQualityCode, int hospitalCode, int overallRating, int mortality, int safety, int readmission, int patientExperience, int effectiveness, int timeliness, int efficientUseMedicalImaging) {
    this.hospitalQualityCode = hospitalQualityCode;
    this.hospitalCode = hospitalCode;
    this.overallRating = overallRating;
    this.mortality = mortality;
    this.safety = safety;
    this.readmission = readmission;
    this.patientExperience = patientExperience;
    this.effectiveness = effectiveness;
    this.timeliness = timeliness;
    this.efficientUseMedicalImaging = efficientUseMedicalImaging;
  }
  

  public HospitalQuality(int hospitalQualityCode) {
    this.hospitalQualityCode = hospitalQualityCode;
  }
	  
  public HospitalQuality(int hospitalCode, int overallRating, int mortality, int safety, int readmission, int patientExperience, int effectiveness, int timeliness, int efficientUseMedicalImaging) {
	this.hospitalCode = hospitalCode;
	this.overallRating = overallRating;
	this.mortality = mortality;
	this.safety = safety;
	this.readmission = readmission;
	this.patientExperience = patientExperience;
	this.effectiveness = effectiveness;
	this.timeliness = timeliness;
	this.efficientUseMedicalImaging = efficientUseMedicalImaging;
  	}
	  
  
  	public int getHospitalQualityCode() {
	  return hospitalQualityCode;
  	}

  	public void setHospitalQualityCode(int hospitalQualityCode) {
	  this.hospitalQualityCode = hospitalQualityCode;
  	}
  
  	public int getHospitalCode() {
  		return hospitalCode;
	}
	
	public void setHospitalCode(int hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	
	public int getOverallRating() {
		return overallRating;
	}
	
	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}
	
	public int getMortality() {
		return mortality;
	}
	
	public void setMortality(int mortality) {
		this.mortality = mortality;
	}
	
	public int getSafety() {
		return safety;
	}
	
	public void setSafety(int safety) {
		this.safety = safety;
	}
	
	public int getReadmission() {
		return readmission;
	}
	
	public void setReadmission(int readmission) {
		this.readmission = readmission;
	}
	
	public int getPatientExperience() {
		return patientExperience;
	}
	
	public void setPatientExperience(int patientExperience) {
		this.patientExperience = patientExperience;
	}
	
	public int getEffectiveness() {
		return effectiveness;
	}
	
	public void setEffectiveness(int effectiveness) {
		this.effectiveness = effectiveness;
	}
	
	public int getTimeliness() {
		return timeliness;
	}
	
	public void setTimeliness(int timeliness) {
		this.timeliness = timeliness;
	}
	
	public int getEfficientUseMedicalImaging() {
		return efficientUseMedicalImaging;
	}
	
	public void setEfficientUseMedicalImaging(int efficientUseMedicalImaging) {
		this.efficientUseMedicalImaging = efficientUseMedicalImaging;
	}

  
  
}