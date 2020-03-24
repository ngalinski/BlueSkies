package dal;

import model.*;

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
    String insertHospital = "INSERT INTO Hospital(HospitalName, ZipCode) VALUE(?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
	ResultSet resultKey = null;

    try {
      connection = connectionManager.getConnection();
      
      insertStmt = connection.prepareStatement(insertHospital,
				Statement.RETURN_GENERATED_KEYS);
		insertStmt.setString(1, hospital.getHospitalName());
		insertStmt.setString(2, hospital.getZipCode());
		
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

  public List<Hospital> getHospitalsByZipCode(String zipCode)
			throws SQLException {
		List<Hospital> hospitals = new ArrayList<Hospital>();
		String selectCounties =
			"SELECT HospitalCode,HospitalName,ZipCode FROM Hospital WHERE Hospital.HospitalName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectCounties);
			selectStmt.setString(1, zipCode);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int hospitalCode = results.getInt("HospitalCode");
				String hospitalName = results.getString("HospitalName");
				String resultZipCode = results.getString("ZipCode");

				Hospital hospital = new Hospital(hospitalCode, hospitalName, resultZipCode);
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


  public Hospital updateHospitalName(Hospital hospital, String newName) throws SQLException {
    String updateName = "UPDATE Hospital SET HospitalName=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateName);
      updateStmt.setString(1, newName);
      hospital.setHospitalName(newName);
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