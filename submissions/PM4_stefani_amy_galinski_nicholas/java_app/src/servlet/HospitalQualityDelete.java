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


@WebServlet("/hospitalqualitydelete")
public class HospitalQualityDelete extends HttpServlet {
	
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
        // Provide a title and render the JSP.
        messages.put("title", "Delete Hospital Quality Record");        
        req.getRequestDispatcher("/HospitalQualityDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String hospitalQualityCode = req.getParameter("hospitalqualitycode");
        if (hospitalQualityCode == null || hospitalQualityCode.trim().isEmpty()) {
            messages.put("title", "Invalid Hospital Code");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the Hospital.
        	HospitalQuality hospitalQuality = new HospitalQuality(Integer.valueOf(hospitalQualityCode));
	        try {
	        	hospitalQuality = hospitalQualityDAO.delete(hospitalQuality);
	        	// Update the message.
		        if (hospitalQuality == null) {
		            messages.put("title", "Successfully deleted record.");
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete record " + hospitalQualityCode);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/HospitalQualityDelete.jsp").forward(req, resp);
    }
}
