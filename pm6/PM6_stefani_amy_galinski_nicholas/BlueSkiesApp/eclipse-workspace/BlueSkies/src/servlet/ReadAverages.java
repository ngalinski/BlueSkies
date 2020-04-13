package servlet;

import dal.*;
import model.*;
import helpers.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Search zip 
 */
@WebServlet("/readaverages")
public class ReadAverages extends HttpServlet {

	protected AirQualityDAO airQualityDAO;


	@Override
	public void init() throws ServletException {
		airQualityDAO = AirQualityDAO.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		AirQuality avgAirQuality;
		try {
			avgAirQuality = airQualityDAO.getAverageAirQuality();
			req.setAttribute("avgairquality", avgAirQuality);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			messages.put("failure", "Error getting averages.");
		}


		//	      req.setAttribute("asthmaimpactbymetric", asthmaImpactByMetric);
		//	      req.setAttribute("healthcarespending", healthCareSpending);
		//	      req.setAttribute("healthcareutilization", healthCareUtilization);
		//	      req.setAttribute("drugutilization", drugUtilization);
		//	      // Metrics for county
		//	      req.setAttribute("county", county);
		//	      req.setAttribute("healthcarecoverage", healthCareCoverage);
		//	      req.setAttribute("socioeconomic", socioeconomic);
		//
		//	      req.getRequestDispatcher("/SearchZip.jsp").forward(req, resp);
		//	      messages.put("failure", "Data not found for that location. Please try again with another zip code.");
		//	      req.setAttribute("location", location);
		//	      req.getRequestDispatcher("/Home.jsp").forward(req, resp);
		//        	

		req.getRequestDispatcher("/SearchZip.jsp").forward(req, resp);
	}


	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		AirQuality avgAirQuality;
		try {
			avgAirQuality = airQualityDAO.getAverageAirQuality();
			req.setAttribute("avgairquality", avgAirQuality);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			messages.put("failure", "Error getting averages.");
		}

		req.getRequestDispatcher("/SearchZip.jsp").forward(req, resp);

	}
}
