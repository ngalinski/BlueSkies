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
    String insertHCU = "INSERT INTO HealthCareUtilization() VALUE();";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertHCU);

      insertStmt.executeUpdate();
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

  public HealthCareUtilization getHealthCareUtilization() throws SQLException {

  }

  public HealthCareUtilization delete() throws SQLException {

  }
}