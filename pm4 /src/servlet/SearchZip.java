package servlet;

import dal.*;
import model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * FindHospitals is the primary entry point into the application.
 */
@WebServlet("/searchzip")
public class SearchZip extends HttpServlet {
	
	protected LocationDAO locationDao;
	
	@Override
	public void init() throws ServletException {
		locationDao = LocationDAO.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        
        Location location;
        
        // Retrieve and validate zip code.
        String zipCode = req.getParameter("zipcode");
        if (zipCode == null || zipCode.trim().isEmpty()) {
            messages.put("invalidzip", "Please enter a valid zip code.");
            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        } else {
        	// Retrieve location, and store as a message.
        	try {
            	location = locationDao.getLocationByZipCode(zipCode);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
         	if (location != null) {
	        	messages.put("success", "Displaying results for zip code:" + zipCode);
	            req.setAttribute("location", location);
	            req.getRequestDispatcher("/SearchZip.jsp").forward(req, resp);
        	} else {
        		messages.put("failure", "Data not found for that location. Please try again with another zip code.");
	            req.setAttribute("location", location);
	            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        	}
        }
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        Location location;
        
        // Retrieve and validate zip code.
        String zipCode = req.getParameter("zipcode");
        if (zipCode == null || zipCode.trim().isEmpty()) {
            messages.put("invalidzip", "Please enter a valid zip code.");
            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        } else {
        	// Retrieve location, and store as a message.
        	try {
            	location = locationDao.getLocationByZipCode(zipCode);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	if (location != null) {
	        	messages.put("invalidzip", "Displaying results for zip code:" + zipCode);
	            req.setAttribute("location", location);
	            req.getRequestDispatcher("/SearchZip.jsp").forward(req, resp);
        	} else {
        		messages.put("failure", "Data not found for that location. Please try again with another zip code.");
	            req.setAttribute("location", location);
	            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        	}
        }
        
    }
}
