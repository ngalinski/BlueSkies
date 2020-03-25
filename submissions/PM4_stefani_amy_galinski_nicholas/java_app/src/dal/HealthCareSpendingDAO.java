package dal;


import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class HealthCareSpendingDAO {
  protected ConnectionManager connectionManager;
  private static HealthCareSpendingDAO instance = null;

  protected HealthCareSpendingDAO() {
    connectionManager = new ConnectionManager();
  }

  public static HealthCareSpendingDAO getInstance() {
    if (instance == null) {
      instance = new HealthCareSpendingDAO();
    }
    return instance;
  }


  // CREATE
  public HealthCareSpending create(HealthCareSpending healthCareSpending) throws SQLException {
	String insertHCS = "INSERT INTO HealthCareSpending(StateCode,TotalSpending,InpatientServices,OutpatientServices,ProfessionalServices,RxDrugs) VALUE(?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
	ResultSet resultKey = null;

    try {
      connection = connectionManager.getConnection();

      insertStmt = connection.prepareStatement(insertHCS,
				Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, healthCareSpending.getStateCode());
	  insertStmt.setInt(2, healthCareSpending.getTotalSpending());
	  insertStmt.setInt(3, healthCareSpending.getInpatientServices());
	  insertStmt.setInt(4, healthCareSpending.getOutpatientServices());
	  insertStmt.setInt(5, healthCareSpending.getProfessionalServices());
	  insertStmt.setInt(6, healthCareSpending.getRxDrugs());
	  insertStmt.executeUpdate();

		resultKey = insertStmt.getGeneratedKeys();
		int healthCareSpendingCode = -1;
		if(resultKey.next()) {
			healthCareSpendingCode = resultKey.getInt(1);
		} else {
			throw new SQLException("Unable to retrieve auto-generated key.");
		}
		healthCareSpending.setHealthCareSpendingCode(healthCareSpendingCode);
		return healthCareSpending;
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
  public HealthCareSpending getHealthCareSpendingByState(String stateCode) throws SQLException {
	  String selectHealthCareSpending = "SELECT StateCode,TotalSpending,InpatientServices,OutpatientServices,ProfessionalServices,RxDrugs FROM HealthCareSpending WHERE StateCode =?;";

	  Connection connection = null;
	  PreparedStatement selectStmt = null;
	  ResultSet results = null;
	
	  	try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectHealthCareSpending);
			selectStmt.setString(1, stateCode);

			results = selectStmt.executeQuery();

			if(results.next()) {
				
				String resultStateCode = results.getString("StateCode");
				int totalSpending = results.getInt("TotalSpending");
				int inpatientServices = results.getInt("InpatientServices");
				int outpatientServices = results.getInt("OutpatientServices");
				int professionalServices = results.getInt("ProfessionalServices");
				int rxDrugs = results.getInt("RxDrugs");
			
				HealthCareSpending healthCareSpending = new HealthCareSpending(resultStateCode, totalSpending, inpatientServices, outpatientServices, professionalServices, rxDrugs);
				return healthCareSpending;
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
	public HealthCareSpending updateTotalSpending(HealthCareSpending healthCareSpending, int newTotalSpending) throws SQLException {
		String updateHealthCareSpending = "UPDATE HealthCareSpending SET TotalSpending=? WHERE HealthCareSpendingCode=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateHealthCareSpending);
			updateStmt.setInt(1, newTotalSpending);
			updateStmt.setInt(2, healthCareSpending.getHealthCareSpendingCode());
			updateStmt.executeUpdate();
			
			// Update the param before returning to the caller.
			healthCareSpending.setTotalSpending(newTotalSpending);
			return healthCareSpending;
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
  public HealthCareSpending delete(HealthCareSpending healthCareSpending) throws SQLException {
		String deleteHealthCareSpending = "DELETE FROM HealthCareSpending WHERE HealthCareSpendingCode=?;";
 		Connection connection = null;
		PreparedStatement deleteStmt = null;
		
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteHealthCareSpending);
				deleteStmt.setInt(1, healthCareSpending.getHealthCareSpendingCode());
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