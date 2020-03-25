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

    List<Location> locationList = new ArrayList<Location>();

    String countyCode = req.getParameter("countycode");
    if (countyCode == null || countyCode.trim().isEmpty()) {
      messages.put("success", "Please enter a valid county code.");
    } else {
      try {
        locationList = locationDAO.getLocationsByCountyCode(Integer.parseInt(countyCode));
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
      messages.put("success", "Displaying results for county code" + countyCode);
      messages.put("previousCountyCode", countyCode);
    }
    req.setAttribute("locations", locationList);

    req.getRequestDispatcher("/LocationRead.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    List<Location> locationList = new ArrayList<Location>();

    String countyCode = req.getParameter("countycode");
    if (countyCode == null || countyCode.trim().isEmpty()) {
      messages.put("success", "Please enter a valid county code.");
    } else {
      try {
        locationList = locationDAO.getLocationsByCountyCode(Integer.parseInt(countyCode));
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
      messages.put("success", "Displaying results for county code:" + countyCode);
    }
    req.setAttribute("location", locationList);

    req.getRequestDispatcher("/LocaitonRead.jsp").forward(req, resp);
  }
}
