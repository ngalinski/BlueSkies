package servlet;

import dal.*;
import model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hospitalqualityupdate")
public class HospitalQualityUpdate extends HttpServlet {

	protected HospitalQualityDAO hospitalQualityDAO;
	
	@Override
	public void init() throws ServletException {
		hospitalQualityDAO = HospitalQualityDAO.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve hospital and validate.
        String hospitalcode = req.getParameter("hospitalcode");
        if (hospitalcode == null || hospitalcode.trim().isEmpty()) {
            messages.put("success", "Please enter a valid Hospital Code.");
        } else {
        	try {
        		HospitalQuality hospitalQuality = hospitalQualityDAO.getHospitalQualityFromHospitalCode(Integer.valueOf(hospitalcode));
        		if(hospitalQuality == null) {
        			messages.put("success", "Hospital quality record does not exist.");
        		}
        		req.setAttribute("hospitalQuality", hospitalQuality);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/HospitalQualityUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve hospital and validate.
        String hospitalCode = req.getParameter("hospitalcode");
        if (hospitalCode == null || hospitalCode.trim().isEmpty()) {
            messages.put("success", "Please enter a valid Hospital Code.");
        } else {
        	try {
        		HospitalQuality hospitalQuality = hospitalQualityDAO.getHospitalQualityFromHospitalCode(Integer.valueOf(hospitalCode));
        		if(hospitalQuality == null) {
        			messages.put("success", "Hospital does not exist. No update to perform.");
        		} else {
        			String newOverallRating = req.getParameter("newoverallrating");
        			int newRatingInt = 99;
        			try {
        				newRatingInt = Integer.parseInt(newOverallRating);
            		} catch (NumberFormatException e) {
        	        	messages.put("success", "Please enter an integer between 0 and 5");
            		}
        			if (newRatingInt < 0 || newRatingInt > 5) {
        	            messages.put("success", "Please enter a valid hospital overall ratin (either -1, 0, or 1).");
        	        } else {
        	        	hospitalQualityDAO.updateOverallRating(hospitalQuality, newOverallRating);
        	        	messages.put("success", "Successfully updated quality record for hospital code " + hospitalQuality.getHospitalCode());
        	        }
        		}
        		req.setAttribute("hospitalQuality", hospitalQuality);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/HospitalQualityUpdate.jsp").forward(req, resp);
    }
}
