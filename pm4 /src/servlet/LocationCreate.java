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


@WebServlet("/locationcreate")
public class LocationCreate extends HttpServlet {

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
    //Just render the JSP.
    req.getRequestDispatcher("/LocationCreate.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    // Retrieve and validate name.
    String zipCode = req.getParameter("zipcode");
    String locationName = req.getParameter("locationname");
    String stateCode = req.getParameter("statecode");
    int population = req.getParameter("population");
    int countyCode = req.getParameter("countycode");
    if (zipCode == null || zipCode.trim().isEmpty()) {
      messages.put("success", "Invalid ZipCode");
    } else {
      if (locationName == null || locationName.trim().isEmpty()) {
        messages.put("success", "Invalid Location Name");
      } else {
        if (stateCode == null || stateCode.trim().isEmpty()) {
          messages.put("success", "Invalid State Code");
        } else {
          if (population == null || population.trim().isEmpty()) {
            messages.put("success", "Invalid Population");
          } else {
            if (countyCode == null || countyCode.trim().isEmpty()) {
              messages.put("success", "Invalid County Code");
            } else {
              Location location = new Location(zipCode, locationName, stateCode, population, countyCode);
              try {
                location = locationDAO.create(location);
                messages.put("success", "Successfully created " + zipCode);
              } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw new IOException(e);
              }
            }
          }
        }
      }
    }
    req.getRequestDispatcher("/LocationCreate.jsp").forward(req, resp);
  }
}
