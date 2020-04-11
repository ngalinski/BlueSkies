package dal;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AsthmaImpactDAO {
  protected ConnectionManager connectionManager;

  // Connection
  private static AsthmaImpactDAO instance = null;
  protected AsthmaImpactDAO() {
    connectionManager = new ConnectionManager();
  }
  public static AsthmaImpactDAO getInstance() {
    if(instance == null) {
      instance = new AsthmaImpactDAO();
    }
    return instance;
  }

  // CREATE

  // READ

  // UPDATE

  // DELETE

}