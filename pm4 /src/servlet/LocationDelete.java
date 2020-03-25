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


@WebServlet("/locationdelete")
public class LocationDelete extends HttpServlet {

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
    // Provide a title and render the JSP.
    messages.put("title", "Delete Location");
    req.getRequestDispatcher("/LocationDelete.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    // Retrieve and validate name.
    String zipCode = req.getParameter("zipcode");
    if (zipCode == null || zipCode.trim().isEmpty()) {
      messages.put("title", "ZipCode not valid");
      messages.put("disableSubmit", "true");
    } else {
      // Delete the Location.
      Location location = new Location(Integer.parseInt(zipCode));
      try {
        location = locationDAO.delete(location);
        // Update the message.
        if (location == null) {
          messages.put("title", "Successfully deleted " + zipCode);
          messages.put("disableSubmit", "true");
        } else {
          messages.put("title", "Failed to delete " + zipCode);
          messages.put("disableSubmit", "false");
        }
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/LocationDelete.jsp").forward(req, resp);
  }
}
