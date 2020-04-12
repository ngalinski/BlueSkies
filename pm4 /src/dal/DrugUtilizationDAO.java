package dal;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DrugUtilizationDAO {
  protected ConnectionManager connectionManager;

  // Connection
  private static DrugUtilizationDAO instance = null;
  protected DrugUtilizationDAO() {
    connectionManager = new ConnectionManager();
  }
  public static DrugUtilizationDAO getInstance() {
    if (instance == null) {
      instance = new DrugUtilizationDAO();
    }
    return instance;
  }

  // CREATE

  // READ

  // UPDATE

  // DELETE

}