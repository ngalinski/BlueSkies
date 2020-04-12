package model;

import util.HospitalType;

public class State {
  private String stateCode;
  private String stateName;
  private HospitalType region;
  
   public State(String stateCode, String stateName, HospitalType region) {
	  this.stateCode = stateCode;
	  this.stateName = stateName;
	  this.region = region;
   }

   public State(String stateName, HospitalType region) {
	  this.stateName = stateName;
	  this.region = region;
   }

   public State(String stateCode) {
	  this.stateCode = stateCode;
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

	public HospitalType getRegion() {
		return region;
	}

	public void setRegion(HospitalType region) {
		this.region = region;
	}

  
}