package model;

public class AsthmaAQI{
private String StateCode;
private int UnitsReimbursed;
private int GoodDaysCount;
private int NumRX;
private int TotalReimbursed;
private int ModerateDaysCount;
private int HazardousDays;

public String getStatecode(){
        return StateCode;
        }

public void setStatecode(String StateCode){
        this.StateCode=StateCode;
        }

public int getUnitsreimbursed(){
        return UnitsReimbursed;
        }

public void setUnitsreimbursed(int UnitsReimbursed){
        this.UnitsReimbursed=UnitsReimbursed;
        }

public int getGooddayscount(){
        return GoodDaysCount;
        }

public void setGooddayscount(int GoodDaysCount){
        this.GoodDaysCount=GoodDaysCount;
        }

public int getNumrx(){
        return NumRX;
        }

public void setNumrx(int NumRX){
        this.NumRX=NumRX;
        }

public int getTotalreimbursed(){
        return TotalReimbursed;
        }

public void setTotalreimbursed(int TotalReimbursed){
        this.TotalReimbursed=TotalReimbursed;
        }

public int getModeratedayscount(){
        return ModerateDaysCount;
        }

public void setModeratedayscount(int ModerateDaysCount){
        this.ModerateDaysCount=ModerateDaysCount;
        }

public int getHazardousdays(){
        return HazardousDays;
        }

public void setHazardousdays(int HazardousDays){
        this.HazardousDays=HazardousDays;
        }
}