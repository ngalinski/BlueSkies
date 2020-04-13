package dal;


import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class HealthCareCoverageDAO {
  protected ConnectionManager connectionManager;
  private static HealthCareCoverageDAO instance = null;

  protected HealthCareCoverageDAO() {
    connectionManager = new ConnectionManager();
  }

  public static HealthCareCoverageDAO getInstance() {
    if (instance == null) {
      instance = new HealthCareCoverageDAO();
    }
    return instance;
  }

  // CREATE
  public HealthCareCoverage create(HealthCareCoverage healthCareCoverage) throws SQLException {
	String insertHealthCareCoverage = "INSERT INTO HealthCareCoverage(CountyCode,NumberUninsured,NumberInsured,PercentUninsured,PercentInsured) VALUE(?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
	ResultSet resultKey = null;

    try {
      connection = connectionManager.getConnection();

      insertStmt = connection.prepareStatement(insertHealthCareCoverage,
				Statement.RETURN_GENERATED_KEYS);
      insertStmt.setInt(1, healthCareCoverage.getCountyCode());
      insertStmt.setInt(2, healthCareCoverage.getNumberUninsured());
	  insertStmt.setInt(3, healthCareCoverage.getNumberInsured());
	  insertStmt.setDouble(4, healthCareCoverage.getPercentUninsured());
	  insertStmt.setDouble(5, healthCareCoverage.getPercentInsured());
	  insertStmt.executeUpdate();

		resultKey = insertStmt.getGeneratedKeys();
		int healthCareCoverageCode = -1;
		if(resultKey.next()) {
			healthCareCoverageCode = resultKey.getInt(1);
		} else {
			throw new SQLException("Unable to retrieve auto-generated key.");
		}
		healthCareCoverage.setHealthCareCoverageCode(healthCareCoverageCode);
		return healthCareCoverage;
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
  public HealthCareCoverage getHealthCareCoverageByCoverageCode(int healthCareCoverageCode) throws SQLException {
	  String selectHealthCareCoverage = "SELECT HealthCareCoverageCode,CountyCode,NumberUninsured,NumberInsured,PercentUninsured,PercentInsured FROM HealthCareCoverage WHERE HealthCareCoverageCode =?;";

	  Connection connection = null;
	  PreparedStatement selectStmt = null;
	  ResultSet results = null;
	
	  	try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectHealthCareCoverage);
			selectStmt.setInt(1, healthCareCoverageCode);
			results = selectStmt.executeQuery();

			if(results.next()) {
	
				int resultHealthCareCoverageCode = results.getInt("HealthCareCoverageCode");
				int countyCode = results.getInt("CountyCode");
				int numberUninsured = results.getInt("NumberUninsured");
				int numberInsured = results.getInt("NumberInsured");
				double percentUninsured = results.getDouble("PercentUninsured");
				double percentInsured = results.getDouble("PercentInsured");

				HealthCareCoverage healthCareCoverage = new HealthCareCoverage(resultHealthCareCoverageCode, countyCode, numberUninsured, numberInsured, percentUninsured, percentInsured);
				return healthCareCoverage;
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
  public HealthCareCoverage getHealthCareCoverageByCountyCode(int countyCode) throws SQLException {
	  String selectHealthCareCoverage = "SELECT HealthCareCoverageCode,CountyCode,NumberUninsured,NumberInsured,PercentUninsured,PercentInsured FROM HealthCareCoverage WHERE CountyCode =?;";

	  Connection connection = null;
	  PreparedStatement selectStmt = null;
	  ResultSet results = null;
	
	  	try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectHealthCareCoverage);
			selectStmt.setInt(1, countyCode);
			results = selectStmt.executeQuery();

			if(results.next()) {
	
				int healthCareCoverageCode = results.getInt("HealthCareCoverageCode");
				int resultCountyCode = results.getInt("CountyCode");
				int numberUninsured = results.getInt("NumberUninsured");
				int numberInsured = results.getInt("NumberInsured");
				double percentUninsured = results.getDouble("PercentUninsured");
				double percentInsured = results.getDouble("PercentInsured");

				HealthCareCoverage healthCareCoverage = new HealthCareCoverage(healthCareCoverageCode, resultCountyCode, numberUninsured, numberInsured, percentUninsured, percentInsured);
				return healthCareCoverage;
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
	public HealthCareCoverage updateHealthCareCoverageByCoverageCode(HealthCareCoverage healthCareCoverage, HealthCareCoverage newHealthCareCoverage) throws SQLException {
		String updateHealthCareCoverage = "UPDATE HealthCareCoverage SET CountyCode=?,NumberUninsured=?,NumberInsured=?,PercentUninsured=?,PercentInsured=? WHERE HealthCareCoverageCode=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateHealthCareCoverage);
			updateStmt.setInt(1, newHealthCareCoverage.getCountyCode());
			updateStmt.setInt(2, newHealthCareCoverage.getNumberUninsured());
		    updateStmt.setInt(3, newHealthCareCoverage.getNumberInsured());
		    updateStmt.setDouble(4, newHealthCareCoverage.getPercentUninsured());
		    updateStmt.setDouble(5, newHealthCareCoverage.getPercentInsured());
			updateStmt.setInt(6, healthCareCoverage.getHealthCareCoverageCode());

			updateStmt.executeUpdate();
			
			healthCareCoverage.setCountyCode(newHealthCareCoverage.getCountyCode());
			healthCareCoverage.setNumberUninsured(newHealthCareCoverage.getNumberUninsured());
			healthCareCoverage.setNumberInsured(newHealthCareCoverage.getNumberInsured());
			healthCareCoverage.setPercentUninsured(newHealthCareCoverage.getPercentUninsured());
			healthCareCoverage.setPercentInsured(newHealthCareCoverage.getPercentInsured());

			return healthCareCoverage;
			
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
  public HealthCareCoverage delete(HealthCareCoverage healthCareCoverage) throws SQLException {
		String deleteHealthCareCoverage = "DELETE FROM HealthCareCoverage WHERE HealthCareCoverageCode=?;";
 		Connection connection = null;
		PreparedStatement deleteStmt = null;
		
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteHealthCareCoverage);
				deleteStmt.setInt(1, healthCareCoverage.getHealthCareCoverageCode());
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