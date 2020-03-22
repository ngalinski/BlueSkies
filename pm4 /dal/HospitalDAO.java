package dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalDAO {
  protected ConnectionManager connectionManager;
  private static HospitalDAO instance = null;
  protected HospitalDAO() {
    connectionManager = new ConnectionManager();
  }
  public static HospitalDAO getInstance() {
    if(instance == null) {
      instance = new HospitalDAO();
    }
    return instance;
  }