package dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDAO {
  protected ConnectionManager connectionManager;
  private static LocationDAO instance = null;

  protected LocationDAO() {
    connectionManager = new ConnectionManager();
  }

  public static LocationDAO getInstance() {
    if (instance == null) {
      instance = new LocationDAO();
    }
    return instance;
  }

  public Location create() throws SQLException {

  }

  public Location getLocation() throws SQLException {

  }

  public Location delete() throws SQLException {

  }
}