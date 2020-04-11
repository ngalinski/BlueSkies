package dal;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DrugDAO {
  protected ConnectionManager connectionManager;

  // Connection
  private static DrugDAO instance = null;
  protected DrugDAO() {
    connectionManager = new ConnectionManager();
  }
  public static DrugDAO getInstance() {
    if(instance == null) {
      instance = new DrugDAO();
    }
    return instance;
  }

  // CREATE

  // READ

  // UPDATE

  // DELETE

}