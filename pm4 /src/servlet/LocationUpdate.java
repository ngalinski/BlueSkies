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


@WebServlet("/locationupdate")
public class LocationUpdate extends HttpServlet {

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

    String zipCode = req.getParameter("zipcode");
    if (zipCode == null || zipCode.trim().isEmpty()) {
      messages.put("success", "Please enter a valid Zip Code.");
    } else {
      try {
        Location location = locationDAO.getLocationByZipCode(Integer.valueOf(zipCode));
        if(location == null) {
          messages.put("success", "Location does not exist.");
        }
        req.setAttribute("location", location);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/LocationUpdate.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    String zipCode = req.getParameter("zipcode");
    if (zipCode == null || zipCode.trim().isEmpty()) {
      messages.put("success", "Please enter a valid Zip Code.");
    } else {
      try {
        Location location = locationDAO.getLocationByZipCode(Integer.valueOf(zipCode));
        if(location == null) {
          messages.put("success", "Location does not exist. No update to perform.");
        } else {
          String newPop = req.getParameter("population");
          if (newPop == null || newPop.trim().isEmpty()) {
            messages.put("success", "Please enter a valid population.");
          } else {
            Location locationNew = new Location(location.getZipCode(), location.getLocationName(), location.getStateCode(), newPop, location.getCountyCode());
            location.updatePopulation(location, locationNew);
            messages.put("success", "Successfully updated " + locationNew.getLocationName());
          }
        }
        req.setAttribute("location", location);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/LocationUpdate.jsp").forward(req, resp);
  }
}
