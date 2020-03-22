package dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalDAO {
  protected ConnectionManager connectionManager;
  private static HospitalDAO instance = null;

  protected HospitalDAO() {
    connectionManager = new ConnectionManager();
  }

  public static HospitalDAO getInstance() {
    if (instance == null) {
      instance = new HospitalDAO();
    }
    return instance;
  }

  public Hospital create(Hospital hospital) throws SQLException {
    String insertHospital = "INSERT INTO Hospital(HospitalName,ZipCode) VALUE(?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertHospital);
      insertStmt.setString(1, hospital.getHospitalName());
      insertStmt.setString(2, hospital.getZipCode());
      insertStmt.executeUpdate();
      return hospital;
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

  public Hospital getHospital() throws SQLException {

  }

  public Hospital delete() throws SQLException {

  }
}