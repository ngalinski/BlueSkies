package dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalQualityDAO {
  protected ConnectionManager connectionManager;
  private static HospitalQualityDAO instance = null;

  protected HospitalQualityDAO() {
    connectionManager = new ConnectionManager();
  }

  public static HospitalQualityDAO getInstance() {
    if (instance == null) {
      instance = new HospitalQualityDAO();
    }
    return instance;
  }

  public HospitalQuality create(HospitalQuality hospitalQuality) throws SQLException {
    String insertHQ = "INSERT INTO HospitalQuality(HospitalQualityCode) VALUE(?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertHQ);
      insertStmt.setString(1, hospitalQuality.getHospitalQualityCode());
      insertStmt.executeUpdate();
      return hospitalQuality;
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

  public HospitalQuality getHQbyCode(int HospitalQualityCode) throws SQLException {
    String selectHQ = "SELECT HospitalCode,HospitalName FROM HospitalQualityCode WHERE HospitalQualityCode=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectHQ);
      selectStmt.setInt(1, HospitalQualityCode);
      results = selectStmt.executreQuery();
      if(results.next()) {
        String resultHospitalName = results.getString("HospitalName");
        int HospitalCode = results.getInt("HospitalCode");
        HospitalQuality hospitalQuality = new HospitalQuality(resultHospitalName, HospitalCode);
        return hospitalQuality;
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

  public HospitalQuality updateRating(HospitalQuality hospitalQuality, int newRating) throws SQLException {
    String updateRating = "UPDATE HospitalQuality SET Rating=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateRating);
      updateStmt.setString(1, newRating);
      hospitalQuality.setRating(newRating);
      return hospitalQuality;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(updateStmt != null) {
        updateStmt.close();
      }
    }
  }

  public HospitalQuality updatePatientExp(HospitalQuality hospitalQuality, int newExp) throws SQLException {
    String updateExp = "UPDATE HospitalQuality SET PatientExperience=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateExp);
      updateStmt.setString(1, newExp);
      hospitalQuality.setPatientExperience(newExp);
      return hospitalQuality;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(updateStmt != null) {
        updateStmt.close();
      }
    }
  }

  public HosptialQuality delete(HospitalQuality hospitalQuality) throws SQLException {
    String deleteHQ = "DELETE FROM HospitalQuality WHERE HospitalQualityCode=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteHQ);
      deleteStmt.setInt(1, hospital.getHospitalQualityCode());
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