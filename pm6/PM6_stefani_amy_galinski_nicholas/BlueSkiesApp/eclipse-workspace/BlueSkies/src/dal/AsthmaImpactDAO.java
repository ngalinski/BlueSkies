package dal;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Data access object (DAO) class to interact with the underlying AsthmaImpact table in your MySQL
 * instance. This is used to store {@link AsthmaImpact} into your MySQL instance and retrieve 
 * {@link AsthmaImpact} from MySQL instance.
 */
public class AsthmaImpactDAO {
	protected ConnectionManager connectionManager;

	// Single pattern: instantiation is limited to one object.
	private static AsthmaImpactDAO instance = null;
	protected AsthmaImpactDAO() {
		connectionManager = new ConnectionManager();
	}
	public static AsthmaImpactDAO getInstance() {
		if(instance == null) {
			instance = new AsthmaImpactDAO();
		}
		return instance;
	}

	// CREATE
	public AsthmaImpact create(AsthmaImpact asthmaImpact) throws SQLException {
		String insertAsthmaImpact = "INSERT INTO AsthmaImpact(StateCode,Metric,DataType,DataValue) "
				+ "VALUES(?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;

		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertAsthmaImpact,
					Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, asthmaImpact.getStateCode());
			insertStmt.setString(2, asthmaImpact.getMetric());
			insertStmt.setString(3, asthmaImpact.getDataType());
			insertStmt.setDouble(4, asthmaImpact.getDataValue());

			insertStmt.executeUpdate();

			resultKey = insertStmt.getGeneratedKeys();
			int asthmaImpactCode = -1;
			if(resultKey.next()) {
				asthmaImpactCode = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			asthmaImpact.setAsthmaImpactCode(asthmaImpactCode);
			return asthmaImpact;
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

	// READ from StateCode
	public AsthmaImpact getAsthmaImpactMetricForState(String stateCode, String metric, String dataType) throws SQLException {
		String selectAsthmaImpact = "SELECT AsthmaImpactCode,StateCode,Metric,DataType,DataValue FROM AsthmaImpact WHERE StateCode=? AND Metric=? AND DataType=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectAsthmaImpact);
			selectStmt.setString(1, stateCode);
			selectStmt.setString(2, metric);
			selectStmt.setString(3, dataType);

			results = selectStmt.executeQuery();

			if(results.next()) {
				int asthmaImpactCode = results.getInt("AsthmaImpactCode");
				String resultStateCode = results.getString("StateCode");
				String resultMetric = results.getString("Metric");
				String resultDataType = results.getString("DataType");
				double dataValue = results.getDouble("DataValue");

				AsthmaImpact asthmaImpact = new AsthmaImpact(asthmaImpactCode, resultStateCode, resultMetric, resultDataType, dataValue);
				return asthmaImpact;
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

	// READ Avg
	public AsthmaImpact getAsthmaImpactAveragesByMetric(String metric, String dataType) throws SQLException {
		String selectAsthmaImpact = "SELECT AVG(DataValue) FROM AsthmaImpact WHERE Metric=? AND DataType=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectAsthmaImpact);
			selectStmt.setString(1, metric);
			selectStmt.setString(2, dataType);

			results = selectStmt.executeQuery();

			if(results.next()) {
				double dataValue = results.getDouble("AVG(DataValue)");

				AsthmaImpact asthmaImpact = new AsthmaImpact(0, "", metric, dataType, dataValue);
				return asthmaImpact;
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
	public AsthmaImpact updateAsthmaDataValue(AsthmaImpact asthmaImpact, double newDataValue) throws SQLException {
		String updateAsthmaImpact = "UPDATE AsthmaImpact SET DataValue=? WHERE AsthmaImpactCode=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateAsthmaImpact);
			updateStmt.setDouble(1, newDataValue);
			updateStmt.setInt(2, asthmaImpact.getAsthmaImpactCode());
			updateStmt.executeUpdate();
			asthmaImpact.setDataValue(newDataValue);
			return asthmaImpact;
			
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
	public AsthmaImpact delete(AsthmaImpact asthmaImpact) throws SQLException {
		String deleteAsthmaImpact = "DELETE FROM AsthmaImpact WHERE AsthmaImpactCode=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteAsthmaImpact);
			deleteStmt.setInt(1, asthmaImpact.getAsthmaImpactCode());
			deleteStmt.executeUpdate();

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
