package dal;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;


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
    String insertCounty = "INSERT INTO County(CountyName, StateCode) VALUE(?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
	ResultSet resultKey = null;

    try {
      connection = connectionManager.getConnection();
      
      insertStmt = connection.prepareStatement(insertCounty,
				Statement.RETURN_GENERATED_KEYS);
		insertStmt.setString(1, county.getCountyName());
		insertStmt.setString(2, county.getStateCode());
		
		insertStmt.executeUpdate();

		resultKey = insertStmt.getGeneratedKeys();
		int countyCode = -1;
		if(resultKey.next()) {
			countyCode = resultKey.getInt(1);
		} else {
			throw new SQLException("Unable to retrieve auto-generated key.");
		}
		county.setCountyCode(countyCode);
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

  public List<County> getCountiesbyName(String countyName)
			throws SQLException {
		List<County> counties = new ArrayList<County>();
		String selectCounties =
			"SELECT CountyCode,CountyName,StateCode FROM County WHERE County.CountyName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectCounties);
			selectStmt.setString(1, countyName);
			results = selectStmt.executeQuery();
			while(results.next()) {
				int countyCode = results.getInt("CountyCode");
				String resultCountyName = results.getString("CountyName");
				String stateCode = results.getString("StateCode");

				County county = new County(countyCode, resultCountyName, stateCode);
				counties.add(county);
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
		return counties;
	}


  public County updateCountyName(County county, String newName) throws SQLException {
    String updateName = "UPDATE County SET CountyName=? WHERE CountyCode=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateName);
      updateStmt.setString(1, newName);
      updateStmt.setInt(2, county.getCountyCode());
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
    String deleteCounty = "DELETE FROM County WHERE CountyCode=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteCounty);
      deleteStmt.setInt(1, county.getCountyCode());
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