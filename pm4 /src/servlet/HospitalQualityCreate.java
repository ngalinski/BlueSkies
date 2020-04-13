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


@WebServlet("/hospitalqualitycreate")
public class HospitalQualityCreate extends HttpServlet {
	
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
        //Just render the JSP.   
        req.getRequestDispatcher("/HospitalQualityCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String hospitalCode = req.getParameter("hospitalcode");
        String overallRating = req.getParameter("overallrating");
        String mortality = req.getParameter("mortality");
        String safety = req.getParameter("safety");
        String readmission = req.getParameter("readmission");
        String patientExperience = req.getParameter("patientexperience");
        String effectiveness = req.getParameter("effectiveness");
        String timeliness = req.getParameter("timeliness");
        String medicalImaging =req.getParameter("medicalimaging");

        if (hospitalCode == null || hospitalCode.trim().isEmpty()) {
            messages.put("success", "Invalid Hospital Code");
        } else {
           HospitalQuality hospitalQuality = new HospitalQuality(Integer.valueOf(hospitalCode), overallRating, mortality, safety, readmission, patientExperience, effectiveness, timeliness, medicalImaging);
            try {
            	hospitalQuality = hospitalQualityDAO.create(hospitalQuality);
				messages.put("success", "Successfully created hospital quality record for hospital code #" + hospitalCode);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new IOException(e);
			}
           }
        
        req.getRequestDispatcher("/HospitalQualityCreate.jsp").forward(req, resp);
    }
}
