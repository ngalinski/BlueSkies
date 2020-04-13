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
		String insertLocation = "INSERT INTO Location(ZipCode,StateCode,CountyCode,LocationName,Population) VALUE(?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertLocation,
							Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, location.getZipCode());
			insertStmt.setString(2, location.getStateCode());
			insertStmt.setInt(3, location.getCountyCode());
			insertStmt.setString(4, location.getLocationName());
			insertStmt.setInt(5, location.getPopulation());
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
		String selectLocation = "SELECT ZipCode,StateCode,CountyCode,LocationName,Population FROM Location WHERE ZipCode=?;";
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
				String stateCode = results.getString("StateCode");
				int countyCode = results.getInt("CountyCode");
				String locationName = results.getString("LocationName");
				int population = results.getInt("Population");
				Location location = new Location(resultZipCode, stateCode, countyCode, locationName, population);
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
						"SELECT ZipCode,StateCode,CountyCode,LocationName,Population FROM Location WHERE Location.CountyCode=?;";
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
				String stateCode = results.getString("StateCode");
				int resultCountyCode = results.getInt("CountyCode");
				String locationName = results.getString("LocationName");
				int population = results.getInt("Population");
				Location location = new Location(zipCode, stateCode, resultCountyCode, locationName, population);
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
	

	  public Location updateLocation(Location location, Location newLocation) throws SQLException {
	    String updateLocation = "UPDATE Location SET ZipCode=?,StateCode=?,CountyCode=?,LocationName=?,Population=? WHERE ZipCode=?;";
	    Connection connection = null;
	    PreparedStatement updateStmt = null;
	    try {
	      connection = connectionManager.getConnection();
	      updateStmt = connection.prepareStatement(updateLocation);
	      updateStmt.setString(1, newLocation.getZipCode());
	      updateStmt.setString(2, newLocation.getStateCode());
	      updateStmt.setInt(3, newLocation.getCountyCode());
	      updateStmt.setString(4, newLocation.getLocationName());
	      updateStmt.setInt(5, newLocation.getPopulation());
	      updateStmt.setString(6, location.getZipCode());

		  updateStmt.executeUpdate();

		  location.setZipCode(newLocation.getZipCode());
		  location.setStateCode(newLocation.getStateCode());
		  location.setCountyCode(newLocation.getCountyCode());
		  location.setLocationName(newLocation.getLocationName());
		  location.setPopulation(newLocation.getPopulation());

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