package dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountyDAO {
  protected ConnectionManager connectionManager;
  private static CountyDAO instance = null;

  protected CountyDAO() {
    connectionManager = new ConnectionManager();
  }

  public static CountyDAO getInstance() {
    if (instance == null) {
      instance = new CountyDAO();
    }
    return instance;
  }

  public County create() throws SQLException {

  }

  public Count getCounty() throws SQLException {

  }

  public County delete() throws SQLException {

  }
}