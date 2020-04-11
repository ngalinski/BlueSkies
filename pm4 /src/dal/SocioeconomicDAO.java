package dal;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SocioeconomicDAO {
  protected ConnectionManager connectionManager;

  // Connection
  private static SocioeconomicDAO instance = null;
  protected SocioeconomicDAO() {
    connectionManager = new ConnectionManager();
  }
  public static SocioeconomicDAO getInstance() {
    if(instance == null) {
      instance = new SocioeconomicDAO();
    }
    return instance;
  }

  // CREATE

  // READ

  // UPDATE

  // DELETE

}