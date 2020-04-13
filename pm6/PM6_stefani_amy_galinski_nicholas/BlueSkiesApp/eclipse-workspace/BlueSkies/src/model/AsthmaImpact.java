package model;

public class AsthmaImpact {
	private int asthmaImpactCode;
	private String stateCode;
	private String metric;
	private String dataType;
	private double dataValue;

	public AsthmaImpact(int asthmaImpactCode, String stateCode, String metric, String dataType, double dataValue) {
		this.asthmaImpactCode = asthmaImpactCode;
		this.stateCode = stateCode;
		this.metric = metric;
		this.dataType = dataType;
		this.dataValue = dataValue;
	}

	public AsthmaImpact(String stateCode, String metric, String dataType, double dataValue) {
		this.stateCode = stateCode;
		this.metric = metric;
		this.dataType = dataType;
		this.dataValue = dataValue;
	}

	public AsthmaImpact(int asthmaImpactCode) {
		this.asthmaImpactCode = asthmaImpactCode;
	}

	public int getAsthmaImpactCode() {
		return asthmaImpactCode;
	}

	public void setAsthmaImpactCode(int asthmaImpactCode) {
		this.asthmaImpactCode = asthmaImpactCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public double getDataValue() {
		return dataValue;
	}

	public void setDataValue(double dataValue) {
		this.dataValue = dataValue;
	}

}