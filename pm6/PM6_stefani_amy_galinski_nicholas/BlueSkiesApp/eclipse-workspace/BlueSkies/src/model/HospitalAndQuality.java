package model;


public class HospitalAndQuality {
	private Hospital hospital;
	private HospitalQuality quality;
	
	public HospitalAndQuality(Hospital hospital, HospitalQuality quality) {
		this.hospital = hospital;
		this.quality = quality;
	}
	
	public HospitalAndQuality(Hospital hospital) {
		this.hospital = hospital;
	}
	
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public HospitalQuality getQuality() {
		return quality;
	}
	public void setQuality(HospitalQuality quality) {
		this.quality = quality;
	}
	
}
