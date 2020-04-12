package dal;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Data access object (DAO) class to interact with the underlying Persons table in your MySQL
 * instance. This is used to store {@link Persons} into your MySQL instance and retrieve 
 * {@link Persons} from MySQL instance.
 */
public class AirQualityDAO {
	protected ConnectionManager connectionManager;
	
	// Single pattern: instantiation is limited to one object.
	private static AirQualityDAO instance = null;
	protected AirQualityDAO() {
		connectionManager = new ConnectionManager();
	}
	public static AirQualityDAO getInstance() {
		if(instance == null) {
			instance = new AirQualityDAO();
		}
		return instance;
	}

	// CREATE
	public AirQuality create(AirQuality airQuality) throws SQLException {
		String insertAirQuality = "INSERT INTO AirQuality(CountyCode,"
				+ "DaysWithAQI,GoodDays,ModerateDays,"
				+ "UnhealthyForSensitiveDays,"
				+ "UnhealthyDays,"
				+ "VeryUnhealthyDays,"
				+ "HazardousDays,"
				+ "MaxAQI,"
				+ "90thPercentileAQI,"
				+ "MedianAQI) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;

		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertAirQuality,
					Statement.RETURN_GENERATED_KEYS);
			insertStmt.setInt(1, airQuality.getCountyCode());
			insertStmt.setInt(2, airQuality.getDaysWithAQI());
			insertStmt.setInt(3, airQuality.getGoodDays());
			insertStmt.setInt(4, airQuality.getModerateDays());
			insertStmt.setInt(5, airQuality.getUnhealthyForSensitiveDays());
			insertStmt.setInt(6, airQuality.getUnhealthyDays());
			insertStmt.setInt(7, airQuality.getVeryUnhealthyDays());
			insertStmt.setInt(8, airQuality.getHazardousDays());
			insertStmt.setInt(9, airQuality.getMaxAQI());
			insertStmt.setInt(10, airQuality.getNinetiethPercentileAQI());
			insertStmt.setInt(11, airQuality.getMedianAQI());
			insertStmt.executeUpdate();

			resultKey = insertStmt.getGeneratedKeys();
			int airQualityCode = -1;
			if(resultKey.next()) {
				airQualityCode = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			airQuality.setAirQualityCode(airQualityCode);
			return airQuality;
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
	public AirQuality getAirQualityFromCountyCode(int countyCode) throws SQLException {
		String selectAirQuality = "SELECT AirQualityCode,"
				+ "CountyCode,"
				+ "DaysWithAQI,"
				+ "GoodDays,"
				+ "ModerateDays,"
				+ "UnhealthyForSensitiveDays,"
				+ "UnhealthyDays,"
				+ "VeryUnhealthyDays,"
				+ "HazardousDays,"
				+ "MaxAQI,"
				+ "90thPercentileAQI,"
				+ "MedianAQI FROM AirQuality WHERE CountyCode=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectAirQuality);
			selectStmt.setInt(1, countyCode);

			results = selectStmt.executeQuery();

			if(results.next()) {
				int airQualityCode = results.getInt("AirQualityCode");
				int resultCountyCode = results.getInt("CountyCode");
				int daysWithAQI = results.getInt("DaysWithAQI");
				int goodDays = results.getInt("GoodDays");
				int moderateDays = results.getInt("ModerateDays");
				int unhealthyForSensitiveDays = results.getInt("UnhealthyForSensitiveDays");
				int unhealthyDays = results.getInt("UnhealthyDays");
				int veryUnhealthyDays = results.getInt("VeryUnhealthyDays");
				int hazardousDays = results.getInt("HazardousDays");
				int maxAQI = results.getInt("MaxAQI");
				int ninetiethPercentileAQI = results.getInt("90thPercentileAQI");
				int medianAQI = results.getInt("MedianAQI");

				AirQuality airQuality = new AirQuality(airQualityCode, resultCountyCode, daysWithAQI, goodDays, moderateDays, unhealthyForSensitiveDays, unhealthyDays, veryUnhealthyDays, hazardousDays, maxAQI, ninetiethPercentileAQI, medianAQI);
				return airQuality;
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

	// UPDATE
	public AirQuality updateMedianAQI(AirQuality airQuality, int newMedianAQI) throws SQLException {
		String updateAirQuality = "UPDATE AirQuality SET MedianAQI=? WHERE AirQualityCode=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateAirQuality);
			updateStmt.setInt(1, newMedianAQI);
			updateStmt.setInt(2, airQuality.getAirQualityCode());
			updateStmt.executeUpdate();
			
			// Update the param before returning to the caller.
			airQuality.setMedianAQI(newMedianAQI);
			return airQuality;
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
	
	// DELETE
	public AirQuality delete(AirQuality airQuality) throws SQLException {
		String deleteAirQuality = "DELETE FROM AirQuality WHERE AirQualityCode=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteAirQuality);
			deleteStmt.setInt(1, airQuality.getAirQualityCode());
			deleteStmt.executeUpdate();

			// Return null so the caller can no longer operate on the Persons instance.
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}
}
