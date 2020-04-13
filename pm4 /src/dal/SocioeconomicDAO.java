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

    public Socioeconomic create(Socioeconomic socioeconomic) throws SQLException {
      String insertSocioeconomic = "INSERT INTO Socioeconomic(CountyCode,UnemploymentRate,PercentPopulationInPoverty,MedianHouseholdIncome,PercentLessThanHSDiploma,PercentHSDiplomaOnly,PercentSomeCollegeOnly,PercentBachelorsOrMore) VALUE(?,?,?,?,?,?,?,?);";
      Connection connection = null;
      PreparedStatement insertStmt = null;
  	ResultSet resultKey = null;

      try {
          connection = connectionManager.getConnection();

          insertStmt = connection.prepareStatement(insertSocioeconomic,
    				Statement.RETURN_GENERATED_KEYS);
  	      insertStmt.setInt(1, socioeconomic.getCountyCode());
  	  	  insertStmt.setDouble(2, socioeconomic.getUnemploymentRate());
  	  	  insertStmt.setDouble(3, socioeconomic.getPercentPopulationInPoverty());
  	  	  insertStmt.setInt(4, socioeconomic.getMedianHouseholdIncome());
  	  	  insertStmt.setDouble(5, socioeconomic.getPercentLessThanHSDiploma());
  	  	  insertStmt.setDouble(6, socioeconomic.getPercentHSDiplomaOnly());
  	  	  insertStmt.setDouble(7, socioeconomic.getPercentSomeCollegeOnly());
  	  	  insertStmt.setDouble(8, socioeconomic.getPercentBachelorsOrMore());

    	  insertStmt.executeUpdate();

    		resultKey = insertStmt.getGeneratedKeys();
    		int socioeconomicCode = -1;
    		if(resultKey.next()) {
    			socioeconomicCode = resultKey.getInt(1);
    		} else {
    			throw new SQLException("Unable to retrieve auto-generated key.");
    		}
    		socioeconomic.setSocioeconomicCode(socioeconomicCode);
    		return socioeconomic;
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
  	// READ From CountyCode
  	public Socioeconomic getSocioeconomicFromCountyCode(int countyCode) throws SQLException {
  		String selectSocioeconomicFromCountyCode = "SELECT SocioeconomicCode,CountyCode,UnemploymentRate,PercentPopulationInPoverty,MedianHouseholdIncome,PercentLessThanHSDiploma,PercentHSDiplomaOnly,PercentSomeCollegeOnly,PercentBachelorsOrMore FROM Socioeconomic WHERE CountyCode=?;";
  		Connection connection = null;
  		PreparedStatement selectStmt = null;
  		ResultSet results = null;
  		try {
  			connection = connectionManager.getConnection();
  			selectStmt = connection.prepareStatement(selectSocioeconomicFromCountyCode);
  			selectStmt.setInt(1, countyCode);

  			results = selectStmt.executeQuery();

  			if(results.next()) {
  				int socioeconomicCode = results.getInt("SocioeconomicCode");
  				int resultCountyCode = results.getInt("CountyCode");
  				int unemploymentRate = results.getInt("UnemploymentRate");
  				int percentPopulationInPoverty = results.getInt("PercentPopulationInPoverty");
  				int medianHouseholdIncome = results.getInt("MedianHouseholdIncome");
  				int percentLessThanHSDiploma = results.getInt("PercentLessThanHSDiploma");
  				int percentHSDiplomaOnly = results.getInt("PercentHSDiplomaOnly");
  				int percentSomeCollegeOnly = results.getInt("PercentSomeCollegeOnly");
  				int percentBachelorsOrMore = results.getInt("PercentBachelorsOrMore");

  				Socioeconomic socioeconomic = new Socioeconomic(socioeconomicCode, resultCountyCode, unemploymentRate, percentPopulationInPoverty, medianHouseholdIncome, percentLessThanHSDiploma, percentHSDiplomaOnly, percentSomeCollegeOnly, percentBachelorsOrMore);
  				return socioeconomic;
  			}
  		} catch (SQLException e) {
  			e.printStackTrace();
  			throw e;
  		} finally {
  			if(connection != null) {
  				connection.close();
  			}
  			if(selectStmt != null) {
  				selectStmt.close();
  			}
  			if(results != null) {
  				results.close();
  			}
  		}
  		return null;
  	}
  	
 // READ From SocioeconomicCode
   	public Socioeconomic getSocioeconomicFromSocioeconomicCode(int socioeconomicCode) throws SQLException {
   		String  selectSocioeconomicFromSocioeconomicCode = "SELECT SocioeconomicCode,CountyCode,UnemploymentRate,PercentPopulationInPoverty,MedianHouseholdIncome,PercentLessThanHSDiploma,PercentHSDiplomaOnly,PercentSomeCollegeOnly,PercentBachelorsOrMore FROM Socioeconomic WHERE SocioeconomicCode=?;";
   		Connection connection = null;
   		PreparedStatement selectStmt = null;
   		ResultSet results = null;
   		try {
   			connection = connectionManager.getConnection();
   			selectStmt = connection.prepareStatement(selectSocioeconomicFromSocioeconomicCode);
   			selectStmt.setInt(1, socioeconomicCode);

   			results = selectStmt.executeQuery();

   			if(results.next()) {
   				int resultSocioeconomicCode = results.getInt("SocioeconomicCode");
   				int countyCode = results.getInt("CountyCode");
   				int unemploymentRate = results.getInt("UnemploymentRate");
   				int percentPopulationInPoverty = results.getInt("PercentPopulationInPoverty");
   				int medianHouseholdIncome = results.getInt("MedianHouseholdIncome");
   				int percentLessThanHSDiploma = results.getInt("PercentLessThanHSDiploma");
   				int percentHSDiplomaOnly = results.getInt("PercentHSDiplomaOnly");
   				int percentSomeCollegeOnly = results.getInt("PercentSomeCollegeOnly");
   				int percentBachelorsOrMore = results.getInt("PercentBachelorsOrMore");

   				Socioeconomic socioeconomic = new Socioeconomic(resultSocioeconomicCode, countyCode, unemploymentRate, percentPopulationInPoverty, medianHouseholdIncome, percentLessThanHSDiploma, percentHSDiplomaOnly, percentSomeCollegeOnly, percentBachelorsOrMore);
   				return socioeconomic;
   			}
   		} catch (SQLException e) {
   			e.printStackTrace();
   			throw e;
   		} finally {
   			if(connection != null) {
   				connection.close();
   			}
   			if(selectStmt != null) {
   				selectStmt.close();
   			}
   			if(results != null) {
   				results.close();
   			}
   		}
   		return null;
   	}


    public Socioeconomic updateSocioeconomic(Socioeconomic socioeconomic, Socioeconomic newSocioeconomic) throws SQLException {
      String updateSocioeconomicAll = "UPDATE Socioeconomic SET CountyCode=?,UnemploymentRate=?,PercentPopulationInPoverty=?, "
      		+ "MedianHouseholdIncome=?, PercentLessThanHSDiploma=?,PercentHSDiplomaOnly=?,PercentSomeCollegeOnly=?,"
      		+ "PercentBachelorsOrMore=? WHERE SocioeconomicCode=?;";
      
      Connection connection = null;
      PreparedStatement updateStmt = null;
      try {
        connection = connectionManager.getConnection();
        updateStmt = connection.prepareStatement(updateSocioeconomicAll);
        updateStmt.setInt(1, socioeconomic.getSocioeconomicCode());
        updateStmt.setInt(2, socioeconomic.getCountyCode());
        updateStmt.setDouble(3, socioeconomic.getUnemploymentRate());
        updateStmt.setDouble(4, socioeconomic.getPercentPopulationInPoverty());
        updateStmt.setInt(5, socioeconomic.getMedianHouseholdIncome());
	  	updateStmt.setDouble(6, socioeconomic.getPercentLessThanHSDiploma());
	  	updateStmt.setDouble(7, socioeconomic.getPercentHSDiplomaOnly());
	  	updateStmt.setDouble(8, socioeconomic.getPercentSomeCollegeOnly());
	  	updateStmt.setDouble(9, socioeconomic.getPercentBachelorsOrMore());
		updateStmt.executeUpdate();

	  	
		socioeconomic.setSocioeconomicCode(newSocioeconomic.getCountyCode());
		socioeconomic.setCountyCode(newSocioeconomic.getCountyCode());
		socioeconomic.setUnemploymentRate(newSocioeconomic.getUnemploymentRate());
		socioeconomic.setPercentPopulationInPoverty(newSocioeconomic.getPercentPopulationInPoverty());
		socioeconomic.setMedianHouseholdIncome(newSocioeconomic.getMedianHouseholdIncome());
		socioeconomic.setPercentLessThanHSDiploma(newSocioeconomic.getPercentLessThanHSDiploma());
		socioeconomic.setPercentHSDiplomaOnly(newSocioeconomic.getPercentHSDiplomaOnly());
		socioeconomic.setPercentSomeCollegeOnly(newSocioeconomic.getPercentSomeCollegeOnly());
		socioeconomic.setPercentBachelorsOrMore(newSocioeconomic.getPercentBachelorsOrMore());

        return socioeconomic;
      } catch (SQLException e) {
        e.printStackTrace();
        throw e;
      } finally {
        if(connection != null) {
          connection.close();
        }
        if(updateStmt != null) {
          updateStmt.close();
        }
      }
    }

    public Socioeconomic delete(Socioeconomic socioeconomic) throws SQLException {
      String deleteSocioeconomic = "DELETE FROM Socioeconomic WHERE SocioeconomicCode=?;";
      Connection connection = null;
      PreparedStatement deleteStmt = null;
      try {
        connection = connectionManager.getConnection();
        deleteStmt = connection.prepareStatement(deleteSocioeconomic);
        deleteStmt.setInt(1, socioeconomic.getSocioeconomicCode());
        deleteStmt.executeUpdate();
        return null;
      } catch (SQLException e) {
        e.printStackTrace();;
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