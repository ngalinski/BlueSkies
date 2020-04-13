package model;

public class HealthCareCoverage {
	private int healthCareCoverageCode;
	private int countyCode;
	private int numberUninsured;
	private int numberInsured;
	private double percentUninsured;
	private double percentInsured;
	
	public HealthCareCoverage(int healthCareCoverageCode, int countyCode, int numberUninsured, int numberInsured,
			double percentUninsured, double percentInsured) {
		this.healthCareCoverageCode = healthCareCoverageCode;
		this.countyCode = countyCode;
		this.numberUninsured = numberUninsured;
		this.numberInsured = numberInsured;
		this.percentUninsured = percentUninsured;
		this.percentInsured = percentInsured;
	}
	
	public HealthCareCoverage(int countyCode, int numberUninsured, int numberInsured,
			double percentUninsured, double percentInsured) {
		this.countyCode = countyCode;
		this.numberUninsured = numberUninsured;
		this.numberInsured = numberInsured;
		this.percentUninsured = percentUninsured;
		this.percentInsured = percentInsured;
	}
	
	public HealthCareCoverage(int healthCareCoverageCode) {
		this.healthCareCoverageCode = healthCareCoverageCode;
	}

	public int getHealthCareCoverageCode() {
		return healthCareCoverageCode;
	}

	public void setHealthCareCoverageCode(int healthCareCoverageCode) {
		this.healthCareCoverageCode = healthCareCoverageCode;
	}

	public int getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(int countyCode) {
		this.countyCode = countyCode;
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

	
}
	