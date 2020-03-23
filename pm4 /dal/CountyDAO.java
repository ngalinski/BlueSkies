package dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountyDAO {
  protected ConnectionManager connectionManager;
  private static CountyDAO instance = null;

  protected CountyDAO() {
    connectionManager = new ConnectionManager();
  }

  public static CountyDAO getInstance() {
    if (instance == null) {
      instance = new CountyDAO();
    }
    return instance;
  }

  public County create(County county) throws SQLException {
    String insertCounty = "INSERT INTO County(CountyName) VALUE(?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertCounty);
      insertStmt.setString(1, county.getCountyName());
      insertStmt.executeUpdate();
      return county;
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

  public County getCountybyName(String countyName) throws SQLException {
    String selectCounty = "SELECT CountyName,CountyCode,StateCode FROM Conuty WHERE countyName=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectCounty);
      selectStmt.setString(1, countyName);
      results = selectStmt.executreQuery();
      if(results.next()) {
        String resultName = results.getString("CountyName");
        String CountyCode = results.getString("CountyCode");
        int StateCode = results.getString("StateCode");
        County county = new County(resultName, CountyCode, StateCode);
        return county;
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

  public County updateCountyName(County county, String newName) throws SQLException {
    String updateName = "UPDATE County SET CountyName=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateName);
      updateStmt.setString(1, newName);
      county.setCountyName(newName);
      return county;
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

  public County delete(County county) throws SQLException {
    String deleteCounty = "DELETE FROM County WHERE CountyName=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteCounty);
      deleteStmt.setString(1, county.getCountyName());
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