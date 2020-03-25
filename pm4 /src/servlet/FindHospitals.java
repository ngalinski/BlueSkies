package servlet;

import dal.*;
import model.*;

import java.io.IOException;
import java.sql.SQLException;
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


/**
 * FindHospitals is the primary entry point into the application.
 */
@WebServlet("/findhospitals")
public class FindHospitals extends HttpServlet {
	
	protected HospitalDAO hospitalDao;
	
	@Override
	public void init() throws ServletException {
		hospitalDao = HospitalDAO.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Hospital> hospitals = new ArrayList<Hospital>();
        
        // Retrieve and validate zip code.
        // zip code is retrieved from the URL query string.
        String zipCode = req.getParameter("zipcode");
        if (zipCode == null || zipCode.trim().isEmpty()) {
            messages.put("success", "Please enter a valid zip code.");
        } else {
        	// Retrieve Hospital, and store as a message.
        	try {
            	hospitals = hospitalDao.getHospitalsByZipCode(zipCode);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for zip code" + zipCode);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering FindHospitals.jsp.
        	messages.put("previousZipCode", zipCode);
        }
        req.setAttribute("hospitals", hospitals);
        
        req.getRequestDispatcher("/FindHospitals.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Hospital> hospitals = new ArrayList<Hospital>();
        
        // Retrieve and validate code.
        // hospitalcode is retrieved from the form POST submission. By default, it
        // is populated by the URL query string (in FindHospitals.jsp).
        String zipCode = req.getParameter("zipcode");
        if (zipCode == null || zipCode.trim().isEmpty()) {
            messages.put("success", "Please enter a valid code.");
        } else {
        	// Retrieve Hospital, and store as a message.
        	try {
            	hospitals = hospitalDao.getHospitalsByZipCode(zipCode);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for zip code:" + zipCode);
        }
        req.setAttribute("hospitals", hospitals);
        
        req.getRequestDispatcher("/FindHospitals.jsp").forward(req, resp);
    }
}
