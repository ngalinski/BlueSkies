package model;

public class Socioeconomic{
private double UnemploymentRate;
private double PercentPopulationInPoverty;
private double PercentLessThanHSDiploma;
private double PercentHSDiplomaOnly;
private double PercentSomeCollegeOnly;
private double PercentBachelorsOrMore;

public double getUnemploymentrate(){
        return UnemploymentRate;
        }

public void setUnemploymentrate(double UnemploymentRate){
        this.UnemploymentRate=UnemploymentRate;
        }

public double getPercentpopulationinpoverty(){
        return PercentPopulationInPoverty;
        }

public void setPercentpopulationinpoverty(double PercentPopulationInPoverty){
        this.PercentPopulationInPoverty=PercentPopulationInPoverty;
        }

public double getPercentlessthanhsdiploma(){
        return PercentLessThanHSDiploma;
        }

public void setPercentlessthanhsdiploma(double PercentLessThanHSDiploma){
        this.PercentLessThanHSDiploma=PercentLessThanHSDiploma;
        }

public double getPercenthsdiplomaonly(){
        return PercentHSDiplomaOnly;
        }

public void setPercenthsdiplomaonly(double PercentHSDiplomaOnly){
        this.PercentHSDiplomaOnly=PercentHSDiplomaOnly;
        }

public double getPercentsomecollegeonly(){
        return PercentSomeCollegeOnly;
        }

public void setPercentsomecollegeonly(double PercentSomeCollegeOnly){
        this.PercentSomeCollegeOnly=PercentSomeCollegeOnly;
        }

public double getPercentbachelorsormore(){
        return PercentBachelorsOrMore;
        }

public void setPercentbachelorsormore(double PercentBachelorsOrMore){
        this.PercentBachelorsOrMore=PercentBachelorsOrMore;
        }
}