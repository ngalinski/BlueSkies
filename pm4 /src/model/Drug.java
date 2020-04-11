package model;

public class Drug{
private String PharmaCompanyName;
private String DrugName;
private String Strength;
private String Route;
private String Unit;

public String getPharmacompanyname(){
        return PharmaCompanyName;
        }

public void setPharmacompanyname(String PharmaCompanyName){
        this.PharmaCompanyName=PharmaCompanyName;
        }

public String getDrugname(){
        return DrugName;
        }

public void setDrugname(String DrugName){
        this.DrugName=DrugName;
        }

public String getStrength(){
        return Strength;
        }

public void setStrength(String Strength){
        this.Strength=Strength;
        }

public String getRoute(){
        return Route;
        }

public void setRoute(String Route){
        this.Route=Route;
        }

public String getUnit(){
        return Unit;
        }

public void setUnit(String Unit){
        this.Unit=Unit;
        }
}