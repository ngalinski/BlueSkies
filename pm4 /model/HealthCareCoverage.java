package model;

public class HealthCareCoverage {
	private int healthCareCoverageCode;
	private int numberUninsured;
	private int numberInsured;
	private double percentInsured;
	private double percentUninsured;
	private String stateName;
	private String countyName;
	
	public HealthCareCoverage(int healthCareCoverageCode, int numberUninsured, int numberInsured, double percentUninsured,
			double percentInsured, String stateName, String countyName) {
		this.healthCareCoverageCode = healthCareCoverageCode;
		this.numberUninsured = numberUninsured;
		this.numberInsured = numberInsured;
		this.percentUninsured = percentUninsured;
		this.percentInsured = percentInsured;
		this.stateName = stateName;
		this.countyName = countyName;
	}
	
	public HealthCareCoverage(int healthCareCoverageCode) {
		this.healthCareCoverageCode = healthCareCoverageCode;
	}
	
	public HealthCareCoverage(int numberUninsured, int numberInsured, double percentUninsured,
			double percentInsured, String stateName, String countyName) {
		this.numberUninsured = numberUninsured;
		this.numberInsured = numberInsured;
		this.percentUninsured = percentUninsured;
		this.percentInsured = percentInsured;
		this.stateName = stateName;
		this.countyName = countyName;
	}
	
	public int getHealthCareCoverageCode() {
		return healthCareCoverageCode;
	}
	public void setHealthCareCoverageCode(int healthCareCoverageCode) {
		this.healthCareCoverageCode = healthCareCoverageCode;
	}
	public int getNumberUninsured() {
		return numberUninsured;
	}
	public void setNumberUninsured(int numberUninsured) {
		this.numberUninsured = numberUninsured;
	}
	public int getNumberInsured() {
		return numberInsured;
	}
	public void setNumberInsured(int numberInsured) {
		this.numberInsured = numberInsured;
	}
	public double getPercentUninsured() {
		return percentUninsured;
	}
	public void setPercentUninsured(double percentUninsured) {
		this.percentUninsured = percentUninsured;
	}
	public double getPercentInsured() {
		return percentInsured;
	}
	public void setPercentInsured(double percentInsured) {
		this.percentInsured = percentInsured;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	
	

}
