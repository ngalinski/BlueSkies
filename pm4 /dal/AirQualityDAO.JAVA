package dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AirQualityDAO {
  protected ConnectionManager connectionManager;
  private static AirQualityDAO instance = null;

  protected AirQualityDAO() {
    connectionManager = new ConnectionManager();
  }

  public static AirQualityDAO getInstance() {
    if (instance == null) {
      instance = new LocationDAO();
    }
    return instance;
  }

  public AirQuality create() throws SQLException {

  }

  public AirQuality getAirQuality() throws SQLException {

  }

  public AirQuality delete() throws SQLException {

  }
}