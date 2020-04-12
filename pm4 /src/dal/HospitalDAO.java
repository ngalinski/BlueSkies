package dal;

import model.*;
import util.HospitalType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;


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
    String insertHospital = "INSERT INTO Hospital(HospitalName, ZipCode, HospitalType, EmergencyServices) VALUE(?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
	ResultSet resultKey = null;

    try {
      connection = connectionManager.getConnection();      
      insertStmt = connection.prepareStatement(insertHospital,
				Statement.RETURN_GENERATED_KEYS);
		insertStmt.setString(1, hospital.getHospitalName());
		insertStmt.setString(2, hospital.getZipCode());
		insertStmt.setString(3, hospital.getHospitalType().getString());
		insertStmt.setInt(4, hospital.getEmergencyServices());

		insertStmt.executeUpdate();

		resultKey = insertStmt.getGeneratedKeys();
		int hospitalCode = -1;
		if(resultKey.next()) {
			hospitalCode = resultKey.getInt(1);
		} else {
			throw new SQLException("Unable to retrieve auto-generated key.");
		}
		hospital.setHospitalCode(hospitalCode);
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
  
	// READ from CountyCode
	public Hospital getHospitalFromHospitalCode(int hospitalCode) throws SQLException {
		String selectHospital = "SELECT HospitalCode,HospitalName,ZipCode,HospitalType,EmergencyServices FROM Hospital WHERE Hospital.HospitalCode=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectHospital);
			selectStmt.setInt(1, hospitalCode);
			results = selectStmt.executeQuery();

			if(results.next()) {
				int resultHospitalCode = results.getInt("HospitalCode");
				String hospitalName = results.getString("HospitalName");
				String zipCode = results.getString("ZipCode");
				HospitalType hospitalType = HospitalType.fromString(results.getString("HospitalType"));
				int emergencyServices = results.getInt("EmergencyServices");
				Hospital hospital = new Hospital(resultHospitalCode, hospitalName, zipCode, hospitalType, emergencyServices);
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


  public List<Hospital> getHospitalsByZipCode(String zipCode) throws SQLException {
		List<Hospital> hospitals = new ArrayList<Hospital>();
		String selectHospitals = "SELECT HospitalCode,HospitalName,ZipCode,HospitalType,EmergencyServices FROM Hospital WHERE Hospital.ZipCode=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectHospitals);
			selectStmt.setString(1, zipCode);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int hospitalCode = results.getInt("HospitalCode");
				String hospitalName = results.getString("HospitalName");
				String resultZipCode = results.getString("ZipCode");
				HospitalType hospitalType = HospitalType.fromString(results.getString("HospitalType"));
				int emergencyServices = results.getInt("EmergencyServices");

				Hospital hospital = new Hospital(hospitalCode, hospitalName, resultZipCode, hospitalType, emergencyServices);
				hospitals.add(hospital);
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
		return hospitals;
	}

  public Hospital updateHospital(Hospital hospital, Hospital newHospital) throws SQLException {
    String updateHospital = "UPDATE Hospital SET HospitalName=?,ZipCode=?,HospitalType=?,EmergencyServices=? WHERE HospitalCode=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateHospital);
      updateStmt.setString(1, newHospital.getHospitalName());
      updateStmt.setString(2, newHospital.getZipCode());
      updateStmt.setString(3, newHospital.getHospitalType().getString());
      updateStmt.setInt(4, newHospital.getEmergencyServices());
      updateStmt.setInt(5, hospital.getHospitalCode());

	  updateStmt.executeUpdate();

      hospital.setHospitalName(newHospital.getHospitalName());
      hospital.setHospitalName(newHospital.getZipCode());
      hospital.setHospitalType(newHospital.getHospitalType());
      hospital.setEmergencyServices(newHospital.getEmergencyServices());
		
      return hospital;
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

  public Hospital delete(Hospital hospital) throws SQLException {
    String deleteHospital = "DELETE FROM Hospital WHERE HospitalCode=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteHospital);
      deleteStmt.setInt(1, hospital.getHospitalCode());
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