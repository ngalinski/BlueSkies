package model;

public class HospitalQuality {
  private int hospitalQualityCode;
  private int hospitalCode;
  private Integer overallRating;
  private Integer mortality;
  private Integer safety;
  private Integer readmission;
  private Integer patientExperience;
  private Integer effectiveness;
  private Integer timeliness;
  private Integer efficientUseMedicalImaging;
 

  public HospitalQuality(int hospitalQualityCode, int hospitalCode, Integer overallRating, Integer mortality, Integer safety, Integer readmission, Integer patientExperience, Integer effectiveness, Integer timeliness, Integer efficientUseMedicalImaging) {
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
	  
  public HospitalQuality(int hospitalCode, Integer overallRating, Integer mortality, Integer safety, Integer readmission, Integer patientExperience, Integer effectiveness, Integer timeliness, Integer efficientUseMedicalImaging) {
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
	
	public Integer getOverallRating() {
		return overallRating;
	}
	
	public void setOverallRating(Integer overallRating) {
		this.overallRating = overallRating;
	}
	
	public Integer getMortality() {
		return mortality;
	}
	
	public void setMortality(Integer mortality) {
		this.mortality = mortality;
	}
	
	public Integer getSafety() {
		return safety;
	}
	
	public void setSafety(Integer safety) {
		this.safety = safety;
	}
	
	public Integer getReadmission() {
		return readmission;
	}
	
	public void setReadmission(Integer readmission) {
		this.readmission = readmission;
	}
	
	public Integer getPatientExperience() {
		return patientExperience;
	}
	
	public void setPatientExperience(Integer patientExperience) {
		this.patientExperience = patientExperience;
	}
	
	public int getEffectiveness() {
		return effectiveness;
	}
	
	public void setEffectiveness(Integer effectiveness) {
		this.effectiveness = effectiveness;
	}
	
	public Integer getTimeliness() {
		return timeliness;
	}
	
	public void setTimeliness(Integer timeliness) {
		this.timeliness = timeliness;
	}
	
	public Integer getEfficientUseMedicalImaging() {
		return efficientUseMedicalImaging;
	}
	
	public void setEfficientUseMedicalImaging(Integer efficientUseMedicalImaging) {
		this.efficientUseMedicalImaging = efficientUseMedicalImaging;
	}

	// --------------------------------------------------
	
	public String getOverallRatingString() {
		if (overallRating == null) {
			return "No data";
		}
		return String.format("%d/5", overallRating);
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
	
	private String convertQualityKeyToDescriptor(Integer qualityKey) {
		if (qualityKey == null) {
			return "No data";
		}
		switch(qualityKey) {
		
		   case -1:
		    	return "Below national average"; 
	
		   case 0:
				return "Equal to national average"; 
			      
		   case 1:
			   return "Above national average"; 
			  
			default:
				return "No data";
		}
	}
  
  
}