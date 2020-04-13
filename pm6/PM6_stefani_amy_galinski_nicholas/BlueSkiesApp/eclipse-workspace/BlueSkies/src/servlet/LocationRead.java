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


@WebServlet("/getlocation")
public class LocationRead extends HttpServlet {

  protected LocationDAO locationDAO;

  @Override
  public void init() throws ServletException {
    locationDAO = LocationDAO.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    Location location;
    
    String zipCode = req.getParameter("zipcode");
    if (zipCode == null || zipCode.trim().isEmpty()) {
      messages.put("success", "Please enter a valid zip code.");
    } else {
      try {
        location = locationDAO.getLocationByZipCode(zipCode);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
      messages.put("success", "Displaying results for county code" + zipCode);
      messages.put("previouszipcode", zipCode);
      req.setAttribute("location", location);
    }

    req.getRequestDispatcher("/LocationRead.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
	  // Map for storing messages.
	    Map<String, String> messages = new HashMap<String, String>();
	    req.setAttribute("messages", messages);

	    Location location;
	    
	    String zipCode = req.getParameter("zipcode");
	    if (zipCode == null || zipCode.trim().isEmpty()) {
	      messages.put("success", "Please enter a valid zip code.");
	    } else {
	      try {
	        location = locationDAO.getLocationByZipCode(zipCode);
	      } catch (SQLException e) {
	        e.printStackTrace();
	        throw new IOException(e);
	      }
	      messages.put("success", "Displaying results for county code" + zipCode);
	      messages.put("previouszipcode", zipCode);
	      req.setAttribute("location", location);
	    }

	    req.getRequestDispatcher("/LocationRead.jsp").forward(req, resp);
	  }

}