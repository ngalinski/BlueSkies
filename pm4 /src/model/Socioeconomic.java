package model;

public class Socioeconomic {
	private int socioeconomicCode;
	private int countyCode;
	private double unemploymentRte;
	private double percentPopulationInPoverty;
	private int medianHouseholdIncome;
	private double percentLessThanHSDiploma;
	private double percentHSDiplomaOnly;
	private double percentSomeCollegeOnly;
	private double percentBachelorsOrMore;
	
	public Socioeconomic(int socioeconomicCode, int countyCode, double unemploymentRte,
			double percentPopulationInPoverty, int medianHouseholdIncome, double percentLessThanHSDiploma,
			double percentHSDiplomaOnly, double percentSomeCollegeOnly, double percentBachelorsOrMore) {
		this.socioeconomicCode = socioeconomicCode;
		this.countyCode = countyCode;
		this.unemploymentRte = unemploymentRte;
		this.percentPopulationInPoverty = percentPopulationInPoverty;
		this.medianHouseholdIncome = medianHouseholdIncome;
		this.percentLessThanHSDiploma = percentLessThanHSDiploma;
		this.percentHSDiplomaOnly = percentHSDiplomaOnly;
		this.percentSomeCollegeOnly = percentSomeCollegeOnly;
		this.percentBachelorsOrMore = percentBachelorsOrMore;
	}
	
	public Socioeconomic(int countyCode, double unemploymentRte,
			double percentPopulationInPoverty, int medianHouseholdIncome, double percentLessThanHSDiploma,
			double percentHSDiplomaOnly, double percentSomeCollegeOnly, double percentBachelorsOrMore) {
		this.countyCode = countyCode;
		this.unemploymentRte = unemploymentRte;
		this.percentPopulationInPoverty = percentPopulationInPoverty;
		this.medianHouseholdIncome = medianHouseholdIncome;
		this.percentLessThanHSDiploma = percentLessThanHSDiploma;
		this.percentHSDiplomaOnly = percentHSDiplomaOnly;
		this.percentSomeCollegeOnly = percentSomeCollegeOnly;
		this.percentBachelorsOrMore = percentBachelorsOrMore;
	}
	
	public Socioeconomic(int socioeconomicCode) {
		this.socioeconomicCode = socioeconomicCode;
	}

	public int getSocioeconomicCode() {
		return socioeconomicCode;
	}

	public void setSocioeconomicCode(int socioeconomicCode) {
		this.socioeconomicCode = socioeconomicCode;
	}

	public int getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(int countyCode) {
		this.countyCode = countyCode;
	}

	public double getUnemploymentRte() {
		return unemploymentRte;
	}

	public void setUnemploymentRte(double unemploymentRte) {
		this.unemploymentRte = unemploymentRte;
	}

	public double getPercentPopulationInPoverty() {
		return percentPopulationInPoverty;
	}

	public void setPercentPopulationInPoverty(double percentPopulationInPoverty) {
		this.percentPopulationInPoverty = percentPopulationInPoverty;
	}

	public int getMedianHouseholdIncome() {
		return medianHouseholdIncome;
	}

	public void setMedianHouseholdIncome(int medianHouseholdIncome) {
		this.medianHouseholdIncome = medianHouseholdIncome;
	}

	public double getPercentLessThanHSDiploma() {
		return percentLessThanHSDiploma;
	}

	public void setPercentLessThanHSDiploma(double percentLessThanHSDiploma) {
		this.percentLessThanHSDiploma = percentLessThanHSDiploma;
	}

	public double getPercentHSDiplomaOnly() {
		return percentHSDiplomaOnly;
	}

	public void setPercentHSDiplomaOnly(double percentHSDiplomaOnly) {
		this.percentHSDiplomaOnly = percentHSDiplomaOnly;
	}

	public double getPercentSomeCollegeOnly() {
		return percentSomeCollegeOnly;
	}

	public void setPercentSomeCollegeOnly(double percentSomeCollegeOnly) {
		this.percentSomeCollegeOnly = percentSomeCollegeOnly;
	}

	public double getPercentBachelorsOrMore() {
		return percentBachelorsOrMore;
	}

	public void setPercentBachelorsOrMore(double percentBachelorsOrMore) {
		this.percentBachelorsOrMore = percentBachelorsOrMore;
	}
	
}
	
	
	