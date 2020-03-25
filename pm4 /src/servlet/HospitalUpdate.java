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


@WebServlet("/hospitalupdate")
public class HospitalUpdate extends HttpServlet {
	
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

        // Retrieve hospital and validate.
        String hospitalCode = req.getParameter("hospitalcode");
        if (hospitalCode == null || hospitalCode.trim().isEmpty()) {
            messages.put("success", "Please enter a valid Hospital Code.");
        } else {
        	try {
        		Hospital hospital = hospitalDAO.getHospitalFromHospitalCode(Integer.valueOf(hospitalCode));
        		if(hospital == null) {
        			messages.put("success", "Hospital does not exist.");
        		}
        		req.setAttribute("hospital", hospital);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/HospitalUpdate.jsp").forward(req, resp);
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
        		Hospital hospital = hospitalDAO.getHospitalFromHospitalCode(Integer.valueOf(hospitalCode));
        		if(hospital == null) {
        			messages.put("success", "Hospital does not exist. No update to perform.");
        		} else {
        			String newHospitalName = req.getParameter("hospitalname");
        			String newHospitalZipCode = req.getParameter("zipcode");
        			if (newHospitalName == null || newHospitalZipCode.trim().isEmpty() || newHospitalZipCode == null || newHospitalZipCode.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid hospital name and zip code.");
        	        } else {
        	        	Hospital hospitalNew = new Hospital(hospital.getHospitalCode(), newHospitalName, newHospitalZipCode);
        	        	hospitalDAO.updateHospital(hospital, hospitalNew);
        	        	messages.put("success", "Successfully updated " + hospitalNew.getHospitalName());
        	        }
        		}
        		req.setAttribute("hospital", hospital);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/HospitalUpdate.jsp").forward(req, resp);
    }
}
