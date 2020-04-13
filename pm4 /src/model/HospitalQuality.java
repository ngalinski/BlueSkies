package model;

public class HospitalQuality {
  private int hospitalQualityCode;
  private int hospitalCode;
  private String overallRating;
  private String mortality;
  private String safety;
  private String readmission;
  private String patientExperience;
  private String effectiveness;
  private String timeliness;
  private String efficientUseMedicalImaging;
 

  public HospitalQuality(int hospitalQualityCode, int hospitalCode, String overallRating, String mortality, String safety, String readmission, String patientExperience, String effectiveness, String timeliness, String efficientUseMedicalImaging) {
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
	  
  public HospitalQuality(int hospitalCode, String overallRating, String mortality, String safety, String readmission, String patientExperience, String effectiveness, String timeliness, String efficientUseMedicalImaging) {
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
	
	public String getOverallRating() {
		return overallRating;
	}
	
	public void setOverallRating(String overallRating) {
		this.overallRating = overallRating;
	}
	
	public String getMortality() {
		return mortality;
	}
	
	public void setMortality(String mortality) {
		this.mortality = mortality;
	}
	
	public String getSafety() {
		return safety;
	}
	
	public void setSafety(String safety) {
		this.safety = safety;
	}
	
	public String getReadmission() {
		return readmission;
	}
	
	public void setReadmission(String readmission) {
		this.readmission = readmission;
	}
	
	public String getPatientExperience() {
		return patientExperience;
	}
	
	public void setPatientExperience(String patientExperience) {
		this.patientExperience = patientExperience;
	}
	
	public String getEffectiveness() {
		return effectiveness;
	}
	
	public void setEffectiveness(String effectiveness) {
		this.effectiveness = effectiveness;
	}
	
	public String getTimeliness() {
		return timeliness;
	}
	
	public void setTimeliness(String timeliness) {
		this.timeliness = timeliness;
	}
	
	public String getEfficientUseMedicalImaging() {
		return efficientUseMedicalImaging;
	}
	
	public void setEfficientUseMedicalImaging(String efficientUseMedicalImaging) {
		this.efficientUseMedicalImaging = efficientUseMedicalImaging;
	}

	// --------------------------------------------------
	
	public String getOverallRatingString() {
		if (overallRating == null) {
			return "No data";
		}
		return String.format("%s/5", overallRating);
	}
	
	public String getMortalityString() {
		if (mortality == null) {
			return "No data";
		}
		return this.convertQualityKeyToDescriptor(mortality);
	}
	
	public String getSafetyString() {
		if (safety == null) {
			return "No data";
		}
		return this.convertQualityKeyToDescriptor(safety);
	}
	
	public String getReadmissionString() {
		if (readmission == null) {
			return "No data";
		}
		return this.convertQualityKeyToDescriptor(readmission);
	}
	
	public String getPatientExperienceString() {
		if (patientExperience == null) {
			return "No data";
		}
		return this.convertQualityKeyToDescriptor(patientExperience);
	}
	
	public String getEffectivenessString() {
		if (effectiveness == null) {
			return "No data";
		}
		return this.convertQualityKeyToDescriptor(effectiveness);
	}
	
	public String getTimelinessString() {
		if (timeliness == null) {
			return "No data";
		}
		return this.convertQualityKeyToDescriptor(timeliness);
	}	
	
	public String getEfficientUseMedicalImagingString() {
		if (efficientUseMedicalImaging == null) {
			return "No data";
		}
		return this.convertQualityKeyToDescriptor(efficientUseMedicalImaging);
	}
	
	private String convertQualityKeyToDescriptor(String qualityKey) {
		if (qualityKey == null) {
			return "No data";
		}
		switch(qualityKey) {
		
		   case "-1":
		    	return "Below national average"; 
	
		   case "0":
				return "Equal to national average"; 
			      
		   case "1":
			   return "Above national average"; 
			  
			default:
				return "No data";
		}
	}
  
  
}