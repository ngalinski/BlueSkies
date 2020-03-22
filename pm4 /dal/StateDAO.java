package dal;

import blog.model.*;

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
    if(instance == null) {
      instance = new StateDAO();
    }
    return instance;
  }