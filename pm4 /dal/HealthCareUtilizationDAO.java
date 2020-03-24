package dal;


import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class HealthCareUtilizationDAO {
  protected ConnectionManager connectionManager;
  private static HealthCareUtilizationDAO instance = null;

  protected HealthCareUtilizationDAO() {
    connectionManager = new ConnectionManager();
  }

  public static HealthCareUtilizationDAO getInstance() {
    if (instance == null) {
      instance = new HealthCareUtilizationDAO();
    }
    return instance;
  }

  // CREATE
  public HealthCareUtilization create(HealthCareUtilization healthCareUtilization) throws SQLException {
	String insertHCS = "INSERT INTO HealthCareUtilization(StateCode,TotalUtilization,InpatientServices,OutpatientServices,ProfessionalServices,RxDrugs) VALUE(?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
	ResultSet resultKey = null;

    try {
      connection = connectionManager.getConnection();

      insertStmt = connection.prepareStatement(insertHCS,
				Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, healthCareUtilization.getStateCode());
	  insertStmt.setDouble(2, healthCareUtilization.getTotalUtilization());
	  insertStmt.setDouble(3, healthCareUtilization.getInpatientServices());
	  insertStmt.setDouble(4, healthCareUtilization.getOutpatientServices());
	  insertStmt.setDouble(5, healthCareUtilization.getProfessionalServices());
	  insertStmt.setDouble(6, healthCareUtilization.getRxDrugs());
	  insertStmt.executeUpdate();

		resultKey = insertStmt.getGeneratedKeys();
		int healthCareUtilizationCode = -1;
		if(resultKey.next()) {
			healthCareUtilizationCode = resultKey.getInt(1);
		} else {
			throw new SQLException("Unable to retrieve auto-generated key.");
		}
		healthCareUtilization.setHealthCareUtilizationCode(healthCareUtilizationCode);
		return healthCareUtilization;
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
  public HealthCareUtilization getHealthCareUtilizationByState(String stateCode) throws SQLException {
	  String selectHealthCareUtilization = "SELECT StateCode,TotalUtilization,InpatientServices,OutpatientServices,ProfessionalServices,RxDrugs FROM HealthCareUtilization WHERE StateCode =?;";

	  Connection connection = null;
	  PreparedStatement selectStmt = null;
	  ResultSet results = null;
	
	  	try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectHealthCareUtilization);
			selectStmt.setString(1, stateCode);

			results = selectStmt.executeQuery();

			if(results.next()) {
				
				String resultStateCode = results.getString("StateCode");
				double totalUtilization = results.getDouble("TotalUtilization");
				double inpatientServices = results.getDouble("InpatientServices");
				double outpatientServices = results.getDouble("OutpatientServices");
				double professionalServices = results.getDouble("ProfessionalServices");
				double rxDrugs = results.getDouble("RxDrugs");
			
				HealthCareUtilization healthCareUtilization = new HealthCareUtilization(resultStateCode, totalUtilization, inpatientServices, outpatientServices, professionalServices, rxDrugs);
				return healthCareUtilization;
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
	public HealthCareUtilization updateTotalUtilization(HealthCareUtilization healthCareUtilization, double newTotalUtilization) throws SQLException {
		String updateHealthCareUtilization = "UPDATE HealthCareUtilization SET TotalUtilization=? WHERE HealthCareUtilizationCode=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateHealthCareUtilization);
			updateStmt.setDouble(1, newTotalUtilization);
			updateStmt.setInt(2, healthCareUtilization.getHealthCareUtilizationCode());
			updateStmt.executeUpdate();
			
			// Update the param before returning to the caller.
			healthCareUtilization.setTotalUtilization(newTotalUtilization);
			return healthCareUtilization;
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
  public HealthCareUtilization delete(HealthCareUtilization healthCareUtilization) throws SQLException {
		String deleteHealthCareUtilization = "DELETE FROM HealthCareUtilization WHERE HealthCareUtilizationCode=?;";
 		Connection connection = null;
		PreparedStatement deleteStmt = null;
		
			try {
				connection = connectionManager.getConnection();
				deleteStmt = connection.prepareStatement(deleteHealthCareUtilization);
				deleteStmt.setInt(1, healthCareUtilization.getHealthCareUtilizationCode());
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