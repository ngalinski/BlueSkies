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


@WebServlet("/hospitalcreate")
public class HospitalCreate extends HttpServlet {
	
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
        //Just render the JSP.   
        req.getRequestDispatcher("/HospitalCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String hospitalName = req.getParameter("hospitalname");
    	String zipCode = req.getParameter("zipcode");
        if (hospitalName == null || hospitalName.trim().isEmpty()) {
            messages.put("success", "Invalid Hospital Name");
        } else {
            if (zipCode == null || zipCode.trim().isEmpty()) {
                messages.put("success", "Invalid Zip Code");
            }
            else {
            	Hospital hospital = new Hospital(hospitalName, zipCode);
            	try {
					hospital = hospitalDAO.create(hospital);
					messages.put("success", "Successfully created " + hospitalName);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new IOException(e);
				}
            }
        }
        
        req.getRequestDispatcher("/HospitalCreate.jsp").forward(req, resp);
    }
}
