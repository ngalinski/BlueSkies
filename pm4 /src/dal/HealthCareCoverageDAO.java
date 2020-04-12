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
	String insertHealthCareCoverage = "INSERT INTO HealthCareCoverage(NumberUninsured,NumberInsured,PercentUninsured,PercentInsured,StateName,CountyName) VALUE(?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
	ResultSet resultKey = null;

    try {
      connection = connectionManager.getConnection();

      insertStmt = connection.prepareStatement(insertHealthCareCoverage,
				Statement.RETURN_GENERATED_KEYS);
      insertStmt.setInt(1, healthCareCoverage.getNumberUninsured());
	  insertStmt.setInt(2, healthCareCoverage.getNumberInsured());
	  insertStmt.setDouble(3, healthCareCoverage.getPercentUninsured());
	  insertStmt.setDouble(4, healthCareCoverage.getPercentInsured());
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
}
//    }
//  }
//
//  // READ
//  public HealthCareCoverage getHealthCareCoverageByCoverageCode(int healthCareCoverageCode) throws SQLException {
//	  String selectHealthCareCoverage = "SELECT HealthCareCoverageCode,NumberUninsured,NumberInsured,PercentUninsured,PercentInsured,StateName,CountyName FROM HealthCareCoverage WHERE HealthCareCoverageCode =?;";
//
//	  Connection connection = null;
//	  PreparedStatement selectStmt = null;
//	  ResultSet results = null;
//	
//	  	try {
//			connection = connectionManager.getConnection();
//			selectStmt = connection.prepareStatement(selectHealthCareCoverage);
//			selectStmt.setInt(1, healthCareCoverageCode);
//
//			results = selectStmt.executeQuery();
//
//			if(results.next()) {
//	
//				int resultHealthCareCoverageCode = results.getInt("HealthCareCoverageCode");
//				int numberUninsured = results.getInt("NumberUninsured");
//				int numberInsured = results.getInt("NumberInsured");
//				double percentUninsured = results.getDouble("PercentUninsured");
//				double percentInsured = results.getDouble("PercentInsured");
//				String stateName = results.getString("StateName");
//				String countyName = results.getString("CountyName");
//
//				HealthCareCoverage healthCareCoverage = new HealthCareCoverage(resultHealthCareCoverageCode, numberUninsured, numberInsured, percentUninsured, percentInsured, stateName, countyName);
//				return healthCareCoverage;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//			if(connection != null) {
//				connection.close();
//			}
//			if(selectStmt != null) {
//				selectStmt.close();
//			}
//			if(results != null) {
//				results.close();
//			}
//		}
//		return null;
//	}
//
//
//	// UPDATE
//	public HealthCareCoverage updateHealthCareCoverageByCoverageCode(HealthCareCoverage healthCareCoverage, HealthCareCoverage newHealthCareCoverage) throws SQLException {
//		String updateHealthCareCoverage = "UPDATE HealthCareCoverage SET NumberUninsured=?,NumberInsured=?,PercentUninsured=?,PercentInsured=?,StateName=?,CountyName=? WHERE HealthCareCoverageCode=?;";
//		Connection connection = null;
//		PreparedStatement updateStmt = null;
//		try {
//			connection = connectionManager.getConnection();
//			updateStmt = connection.prepareStatement(updateHealthCareCoverage);
//			updateStmt.setInt(1, newHealthCareCoverage.getNumberUninsured());
//		    updateStmt.setInt(2, newHealthCareCoverage.getNumberInsured());
//		    updateStmt.setDouble(3, newHealthCareCoverage.getPercentUninsured());
//		    updateStmt.setDouble(4, newHealthCareCoverage.getPercentInsured());
//		    updateStmt.setString(5, newHealthCareCoverage.getStateName());
//		    updateStmt.setString(6, newHealthCareCoverage.getCountyName());
//			updateStmt.setInt(7, healthCareCoverage.getHealthCareCoverageCode());
//
//			updateStmt.executeUpdate();
//			
//			// Update the param before returning to the caller.
//			healthCareCoverage.setNumberUninsured(newHealthCareCoverage.getNumberUninsured());
//			healthCareCoverage.setNumberInsured(newHealthCareCoverage.getNumberInsured());
//			healthCareCoverage.setPercentUninsured(newHealthCareCoverage.getPercentUninsured());
//			healthCareCoverage.setPercentInsured(newHealthCareCoverage.getPercentInsured());
//			healthCareCoverage.setStateName(newHealthCareCoverage.getStateName());
//			healthCareCoverage.setCountyName(newHealthCareCoverage.getCountyName());
//
//			return healthCareCoverage;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//			if(connection != null) {
//				connection.close();
//			}
//			if(updateStmt != null) {
//				updateStmt.close();
//			}
//		}
//	}
//	
//	// DELETE
//  public HealthCareCoverage delete(HealthCareCoverage healthCareCoverage) throws SQLException {
//		String deleteHealthCareCoverage = "DELETE FROM HealthCareCoverage WHERE HealthCareCoverageCode=?;";
// 		Connection connection = null;
//		PreparedStatement deleteStmt = null;
//		
//			try {
//				connection = connectionManager.getConnection();
//				deleteStmt = connection.prepareStatement(deleteHealthCareCoverage);
//				deleteStmt.setInt(1, healthCareCoverage.getHealthCareCoverageCode());
//				deleteStmt.executeUpdate();
//
//				// Return null so the caller can no longer operate on the Persons instance.
//				return null;
//			} catch (SQLException e) {
//				e.printStackTrace();
//				throw e;
//			} finally {
//				if(connection != null) {
//					connection.close();
//				}
//				if(deleteStmt != null) {
//					deleteStmt.close();
//				}
//			}
//		}
//}