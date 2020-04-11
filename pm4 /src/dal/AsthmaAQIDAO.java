package dal;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AsthmaAQIDAO {
  protected ConnectionManager connectionManager;

  // Connection
  private static AsthmaAQIDAO instance = null;
  protected AsthmaAQIDAO() {
    connectionManager = new ConnectionManager();
  }
  public static AsthmaAQIDAO getInstance() {
    if(instance == null) {
      instance = new AsthmaAQIDAO();
    }
    return instance;
  }

  // CREATE

  // READ

  // UPDATE

  // DELETE

}