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


@WebServlet("/countydelete")
public class CountyDelete extends HttpServlet {

  protected CountyDAO countyDAO;

  @Override
  public void init() throws ServletException {
    countyDAO = CountyDAO.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);
    // Provide a title and render the JSP.
    messages.put("title", "Delete County");
    req.getRequestDispatcher("/CountyDelete.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    // Retrieve and validate name.
    String countyCode = req.getParameter("countycode");
    if (countyCode == null || countyCode.trim().isEmpty()) {
      messages.put("title", "County Code not valid");
      messages.put("disableSubmit", "true");
    } else {
      County county = new County(Integer.parseInt(countyCode));
      try {
        county = countyDAO.delete(county);
        // Update the message.
        if (county == null) {
          messages.put("title", "Successfully deleted " + countyCode);
          messages.put("disableSubmit", "true");
        } else {
          messages.put("title", "Failed to delete " + countyCode);
          messages.put("disableSubmit", "false");
        }
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/CountyDelete.jsp").forward(req, resp);
  }
}
