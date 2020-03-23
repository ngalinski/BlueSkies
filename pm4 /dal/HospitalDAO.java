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

  public Hospital getHospitalbyName(String hospitalName) throws SQLException {
    String selectHospital = "SELECT hospitalName,ZipCode FROM Hospital WHERE hospitalName=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectHospital);
      selectStmt.setString(1, hospitalName);
      results = selectStmt.executreQuery();
      if(results.next()) {
        String resultHospitalName = results.getString("hospitalName");
        int ZipCode = results.getInt("ZipCode");
        Hospital hospital = new Hospital(resultHospitalName, ZipCode);
        return hospital;
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

  public Hospital getHospitalbyType(String HospitalType) throws SQLException {

  }

  public Hospital delete(Hospital hospital) throws SQLException {
    String deleteHospital = "DELETE FROM Hospital WHERE HospitalName=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteHospital);
      deleteStmt.setString(1, hospital.getHospitalName());
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