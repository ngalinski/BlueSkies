package dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalCareUtilizationDAO {
  protected ConnectionManager connectionManager;
  private static HealthCareUtilizationDAO instance = null;

  protected HealthCareUtilizationDAO() {
    connectionManager = new ConnectionManager();
  }

  public static HealthCareUtilizationDAO getInstance() {
    if (instance == null) {
      instance = new HospitalCareUtilizationDAO();
    }
    return instance;
  }

  public HealthCareUtilization create(HealthCareUtilization healthCareUtilization) throws SQLException {
    String insertHCU = "INSERT INTO HealthCareUtilization(StateCode,TotalSpending,InpatientServices,OutpatientServices,ProfessionalServices,RxDrugs) VALUE(?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;

    try {
      connection = connectionManager.getConnection();

      insertStmt = connection.prepareStatement(insertHCS,
              Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, healthCareUtilization.getStateCode());
      insertStmt.setInt(2, healthCareUtilization.getTotalSpending());
      insertStmt.setInt(3, healthCareUtilization.getInpatientServices());
      insertStmt.setInt(4, healthCareUtilization.getOutpatientServices());
      insertStmt.setInt(5, healthCareUtilization.getProfessionalServices());
      insertStmt.setInt(6, healthCareUtilization.getRxDrugs());
      insertStmt.executeUpdate();

      resultKey = insertStmt.getGeneratedKeys();
      int healthCareUtilizationCode = -1;
      if(resultKey.next()) {
        healthCareUtilizationCode = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      healthCareUtilization.setHealthCareSpendingCode(healthCareUtilizationCode);
      return healthCareUtilization;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(insertStmt != null) {
        insertStmt.close();
      }
    }
  }

  public HealthCareUtilization getHealthCareUtilizationbyState(String StateCode) throws SQLException {
    String selectHCU = "SELECT StateCode,TotalSpending,InpatientServices,OutpatientServices,ProfessionalServices,RxDrugs FROM HealthCareUtilization WHERE StateCode =?;";

    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;

    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectHCU);
      selectStmt.setString(1, stateCode);

      results = selectStmt.executeQuery();

      if(results.next()) {

        String resultStateCode = results.getString("StateCode");
        int totalSpending = results.getInt("TotalSpending");
        int inpatientServices = results.getInt("InpatientServices");
        int outpatientServices = results.getInt("OutpatientServices");
        int professionalServices = results.getInt("ProfessionalServices");
        int rxDrugs = results.getInt("RxDrugs");

        HealthCareUtilization healthCareUtilization = new HealthCareUtilization(resultStateCode, totalSpending, inpatientServices, outpatientServices, professionalServices, rxDrugs);
        return healthCareUtilization;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(selectStmt != null) {
        selectStmt.close();
      }
      if(results != null) {
        results.close();
      }
    }
    return null;
  }

  public HealthCareUtilization updateUtilization(HealthCareUtilization healthCareUtilization, double newUtil) throws SQLException {

  }

  public HealthCareUtilization delete(HealthCareUtilization healthCareUtilization) throws SQLException {
    String deleteHCU = "DELETE FROM HealthCareUtilization WHERE HealthCareUtilizationCode=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteHCU);
      deleteStmt.setInt(1, healthCareUtilization.getHealthCareUtilizationCode());
      deleteStmt.executeUpdate();
      return null;
    } catch (SQLException e) {
      e.printStackTrace();;
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (deleteStmt != null) {
        deleteStmt.close();
      }
    }
  }
}