package dal;

import model.*;
import model.AirQuality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AirQualityDAO {
	protected ConnectionManager connectionManager;
	private static AirQualityDAO instance = null;

	protected AirQualityDAO() {
		connectionManager = new ConnectionManager();
	}

	public static AirQualityDAO getInstance() {
		if (instance == null) {
			instance = new AirQualityDAO();
		}
		return instance;
	}

	// CREATE
	public AirQuality create(AirQuality airQuality) throws SQLException {
		String insertAirQuality = "INSERT INTO AirQuality(CountyCode,StateCode,0_DaysWithAQI,1_GoodDaysCount,2_ModerateDaysCount,3_UnhealthyForSensitiveDaysCount,4_UnhealthyDays,5_VeryUnhealthyDays,6_HazardousDays,MaxAQI,90thPercentileAQI,MedianAQI) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;

		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertAirQuality);

			insertStmt.setInt(1, airQuality.getCountyCode());
			insertStmt.setString(2, airQuality.getStateCode());
			insertStmt.setInt(3, airQuality.getDaysWithAQI());
			insertStmt.setInt(4, airQuality.getGoodDays());
			insertStmt.setInt(5, airQuality.getModerateDays());
			insertStmt.setInt(6, airQuality.getUnhealthyForSensitiveDays());
			insertStmt.setInt(7, airQuality.getUnhealthyDays());
			insertStmt.setInt(8, airQuality.getVeryUnhealthyDays());
			insertStmt.setInt(9, airQuality.getHazardousDays());
			insertStmt.setInt(10, airQuality.getMaxAQI());
			insertStmt.setInt(11, airQuality.getNinetiethPercentileAQI());
			insertStmt.setInt(12, airQuality.getMedianAQI());

			insertStmt.executeUpdate();

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
		String selectAirQuality = "SELECT AirQualityCode,CountyCode,StateCode,0_DaysWithAQI,1_GoodDaysCount,2_ModerateDaysCount,3_UnhealthyForSensitiveDaysCount,4_UnhealthyDays,5_VeryUnhealthyDays,6_HazardousDays,MaxAQI,90thPercentileAQI,MedianAQI FROM AirQuality WHERE CountyCode=?;";
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
				String stateCode = results.getString("StateCode");
				int daysWithAQI = results.getInt("0_DaysWithAQI");
				int goodDays = results.getInt("1_GoodDaysCount");
				int moderateDays = results.getInt("2_ModerateDaysCount");
				int unhealthyForSensitiveDays = results.getInt("3_UnhealthyForSensitiveDaysCount");
				int unhealthyDays = results.getInt("4_UnhealthyDays");
				int veryUnhealthyDays = results.getInt("5_VeryUnhealthyDays");
				int hazardousDays = results.getInt("6_HazardousDays");
				int maxAQI = results.getInt("MaxAQI");
				int ninetiethPercentileAQI = results.getInt("90thPercentileAQI");
				int medianAQI = results.getInt("MedianAQI");

				AirQuality airQuality = new AirQuality(airQualityCode, resultCountyCode, stateCode, daysWithAQI, goodDays, moderateDays, unhealthyForSensitiveDays, unhealthyDays, veryUnhealthyDays, hazardousDays, maxAQI, ninetiethPercentileAQI, medianAQI);
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
}