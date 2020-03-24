package dal;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

  public State create(State state) throws SQLException {
    String insertState = "INSERT INTO State(StateName,StateCode) VALUE(?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertState);
      insertStmt.setString(1, state.getStateName());
      insertStmt.setString(2, state.getStateCode());
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

  public State getStateByName(String StateName) throws SQLException {
    String selectState = "SELECT StateName,StateCode FROM State WHERE StateName=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectState);
      selectStmt.setString(1, StateName);
      results = selectStmt.executreQuery();
      if(results.next()) {
        String resultName = results.getString("StateName");
        int StateCode = results.getString("StateCode");
        State state = new State(resultName, StateCode);
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

  public State updateStateName(State state, String newName) throws SQLException {
    String updateName = "UPDATE State SET StateNode=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateName);
      updateStmt.setString(1, newName);
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
    String updateCode = "UPDATE State SET StateCode=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateCode);
      updateStmt.setString(1, NewCode);
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

  public State delete(State state) throws SQLException {
    String deleteState = "DELETE FROM State WHERE StateName=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteState);
      deleteStmt.setString(1, state.getStateName());
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