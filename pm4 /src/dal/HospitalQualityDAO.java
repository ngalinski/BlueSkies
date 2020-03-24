package dal;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
    String insertHospitalQuality = "INSERT INTO HospitalQuality(HospitalCode,OverallRating,Mortality,Safety,Readmission,PatientExperience,Effectiveness,Timeliness,EfficientUseMedicalImaging) VALUE(?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
	ResultSet resultKey = null;

    try {
        connection = connectionManager.getConnection();

        insertStmt = connection.prepareStatement(insertHospitalQuality,
  				Statement.RETURN_GENERATED_KEYS);
	      insertStmt.setInt(1, hospitalQuality.getHospitalCode());
	  	  insertStmt.setInt(2, hospitalQuality.getOverallRating());
	  	  insertStmt.setInt(3, hospitalQuality.getMortality());
	  	  insertStmt.setInt(4, hospitalQuality.getSafety());
	  	  insertStmt.setInt(5, hospitalQuality.getReadmission());
	  	  insertStmt.setInt(6, hospitalQuality.getPatientExperience());
	  	  insertStmt.setInt(7, hospitalQuality.getEffectiveness());
	  	  insertStmt.setInt(8, hospitalQuality.getTimeliness());
	  	  insertStmt.setInt(9, hospitalQuality.getEfficientUseMedicalImaging());

  	  insertStmt.executeUpdate();

  		resultKey = insertStmt.getGeneratedKeys();
  		int hospitalQualityCode = -1;
  		if(resultKey.next()) {
  			hospitalQualityCode = resultKey.getInt(1);
  		} else {
  			throw new SQLException("Unable to retrieve auto-generated key.");
  		}
  		hospitalQuality.setHospitalQualityCode(hospitalQualityCode);
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
	// READ 
	public HospitalQuality getHospitalQualityFromHospitalCode(int hospitalCode) throws SQLException {
		String selectHospitalQualityCode = "SELECT HospitalQualityCode,HospitalCode,OverallRating,Mortality,Safety,Readmission,PatientExperience,Effectiveness,Timeliness,EfficientUseMedicalImaging FROM HospitalQuality WHERE HospitalCode=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectHospitalQualityCode);
			selectStmt.setInt(1, hospitalCode);

			results = selectStmt.executeQuery();

			if(results.next()) {
				int hospitalQualityCode = results.getInt("HospitalQualityCode");
				int resultHospitalCode = results.getInt("HospitalCode");
				int rating = results.getInt("OverallRating");
				int mortality = results.getInt("Mortality");
				int safety = results.getInt("Safety");
				int readmission = results.getInt("Readmission");
				int patientExperience = results.getInt("PatientExperience");
				int effectiveness = results.getInt("Effectiveness");
				int timeliness = results.getInt("Timeliness");
				int efficientUseMedicalImaging = results.getInt("EfficientUseMedicalImaging");

				HospitalQuality hospitalQuality = new HospitalQuality(hospitalQualityCode, resultHospitalCode, rating, mortality, safety, readmission, patientExperience, effectiveness, timeliness, efficientUseMedicalImaging);
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


  public HospitalQuality updateOverallRating(HospitalQuality hospitalQuality, int overallRating) throws SQLException {
    String updateOverallRating = "UPDATE HospitalQuality SET OverallRating=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateOverallRating);
      updateStmt.setInt(1, overallRating);
      hospitalQuality.setOverallRating(overallRating);
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

  public HospitalQuality delete(HospitalQuality hospitalQuality) throws SQLException {
    String deleteHospitalQuality = "DELETE FROM HospitalQuality WHERE HospitalQualityCode=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteHospitalQuality);
      deleteStmt.setInt(1, hospitalQuality.getHospitalQualityCode());
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