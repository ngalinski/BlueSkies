package dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    String insertLocation = "INSERT INTO Location(ZipCode,LocationName) VALUE(?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertLocation);
      insertStmt.setInt(1, location.getZipCode());
      insertStmt.setString(2, location.getLocationName());
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

  public Location getLocation(int ZipCode) throws SQLException {
    String selectLocation = "SELECT LocationName,ZipCode FROM Location WHERE ZipCode=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectLocation);
      selectStmt.setInt(1, ZipCode);
      results = selectStmt.executreQuery();
      if(results.next()) {
        String resultLocationName = results.getString("LocationName");
        int ZipCode = results.getInt("ZipCode");
        Location location = new Location(resultLocationName,ZipCode);
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

  public Location updatePopulation() throws SQLException {

  }

  public Location updateLocationName() throws SQLException {

  }

  public Location updateLocationCounty() throws SQLException {

  }

  public Location delete(Location location) throws SQLException {
    String deleteLocation = "DELETE FROM Location WHERE ZipCode=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteLocation;
      deleteStmt.setInt(1, location.getZipCode());
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
}