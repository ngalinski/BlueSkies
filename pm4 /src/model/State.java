package model;

import util.Region;

public class State {
  private String stateCode;
  private String stateName;
  private Region region;
  
   public State(String stateCode, String stateName, Region region) {
	  this.stateCode = stateCode;
	  this.stateName = stateName;
	  this.region = region;
   }

   public State(String stateName, Region region) {
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

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

  
}