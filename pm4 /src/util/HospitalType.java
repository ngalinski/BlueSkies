package util;

public enum HospitalType {
  ACUTE_CARE_HOSPITALS("Acute Care Hospitals"), 
  CRITICAL_ACCESS_HOSPITIALS("Critical Access Hospitals"), 
  PSYCHIATRIC("Psychiatric"), 
  CHILDRENS("Childrens");

  private String string;
  
	HospitalType(String string) {
      this.string = string;
	}

	public String getString() {
      return string;
	}
	
	public static HospitalType fromString(String string) {
		switch(string) {
		   case "Acute Care Hospitals":
		      return HospitalType.ACUTE_CARE_HOSPITALS; 
	
		   case "Critical Access Hospitals":
			  return HospitalType.CRITICAL_ACCESS_HOSPITIALS; 
			      
		   case "Psychiatric":
			  return HospitalType.PSYCHIATRIC; 
			     
		   case "Childrens":
			  return HospitalType.CHILDRENS;
			  
			default:
				return null;
		}
	}
	
}

