package dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalCareUtilizationDAO {
  protected ConnectionManager connectionManager;
  private static HospitalQualityDAO instance = null;

}