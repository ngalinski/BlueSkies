package dal;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;


public class LocationDAO {
	protected ConnectionManager connectionManager;
	private static LocationDAO instance = null;

	protected LocationDAO() {
		connectionManager = new ConnectionManager();
	}

	public static LocationDAO getInstance() {
		if (instance == null) {
			instance = new LocationDAO();
		}
		return instance;
	}

	public Location create(Location location) throws SQLException {
		String insertLocation = "INSERT INTO Location(ZipCode,LocationName,StateCode,Population,CountyCode) VALUE(?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertLocation,
							Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, location.getZipCode());
			insertStmt.setString(2, location.getLocationName());
			insertStmt.setString(3, location.getStateCode());
			insertStmt.setInt(4, location.getPopulation());
			insertStmt.setInt(5, location.getCountyCode());

			insertStmt.executeUpdate();

			return location;
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
	public Location getLocationByZipCode(String zipCode) throws SQLException {
		String selectLocation = "SELECT ZipCode,LocationName,StateCode,Population,CountyCode FROM Location WHERE ZipCode=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectLocation);
			selectStmt.setString(1, zipCode);

			results = selectStmt.executeQuery();

			if(results.next()) {
				String resultZipCode = results.getString("ZipCode");
				String locationName = results.getString("LocationName");
				String stateCode = results.getString("StateCode");
				int population = results.getInt("Population");
				int resultCountyCode = results.getInt("CountyCode");

				Location location = new Location(resultZipCode, locationName, stateCode, population, resultCountyCode);

				return location;
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

	public List<Location> getLocationsByCountyCode(int countyCode)
					throws SQLException {
		List<Location> locations = new ArrayList<Location>();
		String selectLocations =
						"SELECT ZipCode,LocationName,StateCode,Population,CountyCode FROM Location WHERE Location.CountyCode=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectLocations);
			selectStmt.setInt(1, countyCode);
			results = selectStmt.executeQuery();
			while(results.next()) {
				String zipCode = results.getString("ZipCode");
				String locationName = results.getString("LocationName");
				String stateCode = results.getString("StateCode");
				int population = results.getInt("Population");
				int resultCountyCode = results.getInt("CountyCode");

				Location location = new Location(zipCode, locationName, stateCode, population, resultCountyCode);
				locations.add(location);
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
		return locations;
	}


	public Location updatePopulation(Location location, int newPopulation) throws SQLException {
		String updateName = "UPDATE Location SET Population=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateName);
			updateStmt.setInt(1, newPopulation);
			location.setPopulation(newPopulation);
			return location;
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

	public Location delete(Location location) throws SQLException {
		String deleteLocation = "DELETE FROM Location WHERE ZipCode=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteLocation);
			deleteStmt.setString(1, location.getZipCode());
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