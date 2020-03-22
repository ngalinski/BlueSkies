package dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalQualityDAO {
  protected ConnectionManager connectionManager;
  private static HospitalQualityDAO instance = null;
  protected HospitalQualityDAO() {
    connectionManager = new ConnectionManager();
  }
  public static HospitalQualityDAO getInstance() {
    if(instance == null) {
      instance = new HospitalQualityDAO();
    }
    return instance;
  }