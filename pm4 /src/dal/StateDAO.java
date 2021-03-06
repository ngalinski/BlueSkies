package dal;

import model.*;
import util.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StateDAO {
  protected ConnectionManager connectionManager;
  private static StateDAO instance = null;

  protected StateDAO() {
    connectionManager = new ConnectionManager();
  }

  public static StateDAO getInstance() {
    if (instance == null) {
      instance = new StateDAO();
    }
    return instance;
  }

  // CREATE
  public State create(State state) throws SQLException {
    String insertState = "INSERT INTO State(StateCode,StateName,Region) VALUE(?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;

    try {
      connection = connectionManager.getConnection();
      
      insertStmt = connection.prepareStatement(insertState,
				Statement.RETURN_GENERATED_KEYS);
		insertStmt.setString(1, state.getStateCode());
		insertStmt.setString(2, state.getStateName());
		insertStmt.setString(3, state.getRegion().getString());
		
		insertStmt.executeUpdate();

		return state;
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
	public State getStateFromStateCode(String stateCode) throws SQLException {
		String selectState = "SELECT StateCode, StateName, Region FROM State WHERE StateCode=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectState);
			selectStmt.setString(1, stateCode);

			results = selectStmt.executeQuery();

			if(results.next()) {
				String resultStateCode = results.getString("StateCode");
				String stateName = results.getString("StateName");
				Region region = Region.fromString(results.getString("Region"));

				State state = new State(resultStateCode, stateName, region);
				return state;
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

	//UPDATE
  public State updateStateName(State state, String newName) throws SQLException {
    String updateName = "UPDATE State SET StateName=? WHERE StateCode=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateName);
      updateStmt.setString(1, newName);
      updateStmt.setString(2, state.getStateCode());
      state.setStateName(newName);
      return state;
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

  public State updateStateCode(State state, String newCode) throws SQLException {
    String updateCode = "UPDATE State SET StateCode=? WHERE StateName=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateCode);
      updateStmt.setString(1, newCode);
      updateStmt.setString(2, state.getStateName());
      state.setStateCode(newCode);
      return state;
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
  public State delete(State state) throws SQLException {
    String deleteState = "DELETE FROM State WHERE StateCode=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteState);
      deleteStmt.setString(1, state.getStateCode());
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