import model.*;
import dal.*;

import java.sql.Connection;
import java.sql.Data;
import java.sql.List;
import java.sql.SQLException;

public class Inserter {

  public static void main(String[] args) throws SQLException {
    AirQualityDAO airQualityDAO = AirQualityDAO.getInstance();
    CountyDAO countyDAO = CountyDAO.getInstance();
    HealthCareSpendingDAO healthCareSpendingDAO = HealthCareSpendingDAO.getInstance();
    HealthCareUtilizationDAO healthCareUtilizationDAO = HealthCareUtilizationDAO.getInstance();
    HospitalDAO hospitalDAO = HospitalDAO.getInstance();
    HospitalQualityDAO hospitalQualityDAO = HospitalQualityDAO.getInstance();
    LocationDAO locationDAO = LocationDAO.getInstance();
    StateDAO stateDAO = StateDAO.getInstance();

    //CREATE

    //READ

    //UPDATE

    //DELETE
    
  }
}