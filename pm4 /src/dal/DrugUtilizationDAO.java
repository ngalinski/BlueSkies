package dal;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;


public class DrugUtilizationDAO {
  // Connection
  private static DrugUtilizationDAO instance = null;
  protected ConnectionManager connectionManager;

  protected DrugUtilizationDAO() {
    connectionManager = new ConnectionManager();
  }

  public static DrugUtilizationDAO getInstance() {
    if (instance == null) {
      instance = new DrugUtilizationDAO();
    }
    return instance;
  }

  // CREATE
  public DrugUtilization create(DrugUtilization drugUtilization) throws SQLException {
    String insertUtil = "INSERT INTO DrugUtilization(StateCode,DrugName,NumReimbursed,NumRx,TotalReimbursed,MedicaidReimbursed,NonMedicaidReimbursed,NDC,Label,Product,Size) VALUE(?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;

    try {
      connection = connectionManager.getConnection();

      insertStmt = connection.prepareStatement(insertUtil,
              Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, drugUtilization.getStatecode());
      insertStmt.setString(2, drugUtilization.getDrugname());
      insertStmt.setString(3, drugUtilization.getNumreimbursed());
      insertStmt.setString(4, drugUtilization.getNumrx());
      insertStmt.setString(5, drugUtilization.getTotalreimbursed());
      insertStmt.setString(6, drugUtilization.getMedicaidreimbursed());
      insertStmt.setString(7, drugUtilization.getNonmedicaidreimbursed());
      insertStmt.setString(8, drugUtilization.getNdc());
      insertStmt.setInt(9, drugUtilization.getLabel());
      insertStmt.setInt(10, drugUtilization.getProduct());
      insertStmt.setInt(11, drugUtilization.getSize());

      insertStmt.executeUpdate();

      resultKey = insertStmt.getGeneratedKeys();
      int drugUtilCode = -1;
      if (resultKey.next()) {
        drugUtilCode = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      drugUtilization.setDrugUtilCode(drugUtilCode);
      return drugUtilization;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (insertStmt != null) {
        insertStmt.close();
      }
    }
  }

  // READ
  public List<DrugUtilization> getDrugUtilbyState(String stateCode) throws SQLException {
    List<DrugUtilization> drugUtilizationList = new ArrayList<DrugUtilization>();
    String selectUtil = "SELECT DrugUtilizationCode,StateCode,DrugName,NumReimbursed,NumRx,TotalReimbursed," +
            "MedicaidReimbursed,NonMedicaidReimbursed,NDC,Label,Product,Size FROM DrugUtilization " +
            "WHERE DrugUtilization.StateCode=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectUtil);
      selectStmt.setString(1, stateCode);
      results = selectStmt.executeQuery();
      while (results.next()) {
        int drugUtilCode = results.getInt("DrugUtilizationCode");
        String resultStateCode = results.getString("StateCode");
        String drugName = results.getString("DrugName");
        String numReim = results.getString("NumReimbursed");
        String numRx = results.getString("NumRx");
        String totalReim = results.getString("TotalReimbursed");
        String medicaidReim = results.getString("MedicaidReimbursed");
        String nonMedicaidReim = results.getString("NonMedicaidReimbursed");
        String ndc = results.getString("NDC");
        int label = results.getInt("Label");
        int prodcut = results.getInt("Product");
        int size = results.getInt("Size");

        DrugUtilization drugUtil = new DrugUtilization(drugUtilCode, resultStateCode, drugName, numReim, numRx, totalReim, medicaidReim, nonMedicaidReim, ndc, label, prodcut, size);
        drugUtilizationList.add(drugUtil);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (selectStmt != null) {
        selectStmt.close();
      }
      if (results != null) {
        results.close();
      }
    }
    return drugUtilizationList;
  }

  // UPDATE
  public DrugUtilization updateDrugUtil(DrugUtilization drugUtilization, DrugUtilization newUtil) throws SQLException {
    String updateUtil = "UPDATE DrugUtilization SET StateCode=?,DrugName=?,NumReimbursed=?, "
            + "NumRx=?, TotalReimbursed=?,MedicaidReimbursed=?,NonMedicaidReimbursed=?,"
            + "NDC=?, Label=?, Product=?, Size=? WHERE DrugUtilizationCode=?;";

    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateUtil);

      updateStmt.setString(1, drugUtilization.getStatecode());
      updateStmt.setString(2, drugUtilization.getDrugname());
      updateStmt.setString(3, drugUtilization.getNumreimbursed());
      updateStmt.setString(4, drugUtilization.getNumrx());
      updateStmt.setString(5, drugUtilization.getTotalreimbursed());
      updateStmt.setString(6, drugUtilization.getMedicaidreimbursed());
      updateStmt.setString(7, drugUtilization.getNonmedicaidreimbursed());
      updateStmt.setString(8, drugUtilization.getNdc());
      updateStmt.setInt(9, drugUtilization.getLabel());
      updateStmt.setInt(10, drugUtilization.getProduct());
      updateStmt.setInt(11, drugUtilization.getSize());

      updateStmt.executeUpdate();

      drugUtilization.setStatecode(newUtil.getStatecode());
      drugUtilization.setDrugname(newUtil.getDrugname());
      drugUtilization.setNumreimbursed(newUtil.getNumreimbursed());
      drugUtilization.setNumrx(newUtil.getNumrx());
      drugUtilization.setTotalreimbursed(newUtil.getTotalreimbursed());
      drugUtilization.setMedicaidreimbursed(newUtil.getMedicaidreimbursed());
      drugUtilization.setNonmedicaidreimbursed(newUtil.getNonmedicaidreimbursed());
      drugUtilization.setNdc(newUtil.getNdc());
      drugUtilization.setLabel(newUtil.getLabel());
      drugUtilization.setProduct(newUtil.getProduct());
      drugUtilization.setSize(newUtil.getSize());

      return drugUtilization;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (updateStmt != null) {
        updateStmt.close();
      }
    }
  }

  // DELETE
  public DrugUtilization delete(DrugUtilization drugUtilization) throws SQLException {

    String deleteUtil = "DELETE FROM DrugUtilization WHERE DrugUtilizationCode=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteUtil);
      deleteStmt.setInt(1, drugUtilization.getDrugUtilCode());
      deleteStmt.executeUpdate();
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      ;
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (deleteStmt != null) {
        deleteStmt.close();
      }
    }
  }
}