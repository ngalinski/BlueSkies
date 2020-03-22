package dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalCareSpendingDAO {
  protected ConnectionManager connectionManager;
  private static HealthCareSpendingDAO instance = null;

  protected HealthCareSpendingDAO() {
    connectionManager = new ConnectionManager();
  }

  public static HealthCareSpendingDAO getInstance() {
    if (instance == null) {
      instance = new HospitalCareSpendingDAO();
    }
    return instance;
  }

  public HealthCareSpending create(HealthCareSpending healthCareSpending) throws SQLException {
    String insertHCS = "INSERT INTO HealthCareSpending() VALUE();";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertHCS);

      insertStmt.executeUpdate();
      return healthCareSpending;
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

  public HealthCareSpending getHealthCareSpending() throws SQLException {

  }

  public HealthCareSpening delete() throws SQLException {

  }
}