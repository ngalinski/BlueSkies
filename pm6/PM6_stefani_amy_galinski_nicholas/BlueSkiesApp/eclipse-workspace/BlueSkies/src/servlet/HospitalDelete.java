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


@WebServlet("/hospitaldelete")
public class HospitalDelete extends HttpServlet {
	
	protected HospitalDAO hospitalDAO;
	
	@Override
	public void init() throws ServletException {
		hospitalDAO = HospitalDAO.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        // Provide a title and render the JSP.
        messages.put("title", "Delete Hospital");        
        req.getRequestDispatcher("/HospitalDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String hospitalCode = req.getParameter("hospitalcode");
        if (hospitalCode == null || hospitalCode.trim().isEmpty()) {
            messages.put("title", "Invalid Hospital Code");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the Hospital.
	        Hospital hospital = new Hospital(Integer.valueOf(hospitalCode));
	        try {
	        	hospital = hospitalDAO.delete(hospital);
	        	// Update the message.
		        if (hospital == null) {
		            messages.put("title", "Successfully deleted " + hospitalCode);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + hospitalCode);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/HospitalDelete.jsp").forward(req, resp);
    }
}
