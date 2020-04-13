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
	  	  insertStmt.setString(2, hospitalQuality.getOverallRating());
	  	  insertStmt.setString(3, hospitalQuality.getMortality());
	  	  insertStmt.setString(4, hospitalQuality.getSafety());
	  	  insertStmt.setString(5, hospitalQuality.getReadmission());
	  	  insertStmt.setString(6, hospitalQuality.getPatientExperience());
	  	  insertStmt.setString(7, hospitalQuality.getEffectiveness());
	  	  insertStmt.setString(8, hospitalQuality.getTimeliness());
	  	  insertStmt.setString(9, hospitalQuality.getEfficientUseMedicalImaging());

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
				String rating = results.getString("OverallRating");
				String mortality = results.getString("Mortality");
				String safety = results.getString("Safety");
				String readmission = results.getString("Readmission");
				String patientExperience = results.getString("PatientExperience");
				String effectiveness = results.getString("Effectiveness");
				String timeliness = results.getString("Timeliness");
				String efficientUseMedicalImaging = results.getString("EfficientUseMedicalImaging");

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

	// READ 
	public HospitalQuality getHospitalQualityAvg() throws SQLException {
		String selectHospitalQualityCode = "SELECT AVG(OverallRating),AVG(Mortality),AVG(Safety),AVG(Readmission),"
				+ "AVG(PatientExperience),AVG(Effectiveness),AVG(Timeliness),"
				+ "AVG(EfficientUseMedicalImaging) FROM HospitalQuality;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectHospitalQualityCode);

			results = selectStmt.executeQuery();

			if(results.next()) {
				String rating = results.getString("AVG(OverallRating)");
				String mortality = results.getString("AVG(Mortality)");
				String safety = results.getString("AVG(Safety)");
				String readmission = results.getString("AVG(Readmission)");
				String patientExperience = results.getString("AVG(PatientExperience)");
				String effectiveness = results.getString("AVG(Effectiveness)");
				String timeliness = results.getString("AVG(Timeliness)");
				String efficientUseMedicalImaging = results.getString("AVG(EfficientUseMedicalImaging)");

				HospitalQuality hospitalQuality = new HospitalQuality(0, 0, rating, mortality, safety, readmission, patientExperience, effectiveness, timeliness, efficientUseMedicalImaging);
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


  public HospitalQuality updateOverallRating(HospitalQuality hospitalQuality, String overallRating) throws SQLException {
    String updateOverallRating = "UPDATE HospitalQuality SET OverallRating=? WHERE HospitalQualityCode=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateOverallRating);
      updateStmt.setString(1, overallRating);
      updateStmt.setInt(2, hospitalQuality.getHospitalQualityCode());
	  updateStmt.executeUpdate();

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