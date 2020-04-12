package model;

import util.HospitalType;

public class Hospital {
  private int hospitalCode;
  private String hospitalName;
  private String zipCode;
  private HospitalType hospitalType;
  private int emergencyServices;

  public Hospital(int hospitalCode, String hospitalName, String zipCode, HospitalType hospitalType,
		  int emergencyServices) {
	this.hospitalCode = hospitalCode;
	this.hospitalName = hospitalName;
	this.zipCode = zipCode;
	this.hospitalType = hospitalType;
	this.emergencyServices = emergencyServices;
  }
  
  public Hospital(String hospitalName, String zipCode, HospitalType hospitalType,
		  int emergencyServices) {
	this.hospitalName = hospitalName;
	this.zipCode = zipCode;
	this.hospitalType = hospitalType;
	this.emergencyServices = emergencyServices;
  }
  
  	public Hospital(int hospitalCode) {
  		this.hospitalCode = hospitalCode;
	}
	  
	public int getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(int hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public HospitalType getHospitalType() {
		return hospitalType;
	}
	public void setHospitalType(HospitalType hospitalType) {
		this.hospitalType = hospitalType;
	}
	public int getEmergencyServices() {
		return emergencyServices;
	}
	public void setEmergencyServices(int emergencyServices) {
		this.emergencyServices = emergencyServices;
	}
	  
}
  
  
  