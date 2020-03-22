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
      instance = new AirQualityDAO();
    }
    return instance;
  }

  public AirQuality create(AirQuality airQuality) throws SQLException {
    String insertAQI = "INSERT INTO AirQuality() VALUE();";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertAQI);

      insertStmt.executeUpdate();
      return airQuality;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(insertStmt != null) {
        insertStmt.close();
      }
    }
  }

  public AirQuality getAirQuality() throws SQLException {

  }

  public AirQuality delete() throws SQLException {

  }
}