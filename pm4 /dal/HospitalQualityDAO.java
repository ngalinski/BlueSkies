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

  public HospitalQuality getHQbyCode() throws SQLException {

  }

  public HospitalQuality updateRating() throws SQLException {

  }

  public HospitalQuality updatePatientExp() throws SQLException {

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