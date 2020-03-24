package model;

public class State {
  private String stateCode;
  private String stateName;
  private String region;
  
   public State(String stateCode, String stateName, String region) {
	  this.stateCode = stateCode;
	  this.stateName = stateName;
	  this.region = region;
   }

   public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

  
}