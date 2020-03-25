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


@WebServlet("/countycreate")
public class CountyCreate extends HttpServlet {

  protected CountyDAO countyDAO;

  @Override
  public void init() throws ServletException {
    countyDAO = countyDAO.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);
    //Just render the JSP.
    req.getRequestDispatcher("/CountyCreate.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    // Retrieve and validate name.
    String countyCode = req.getParameter("countycode");
    String countyName = req.getParameter("countyname");
    String stateCode = req.getParameter("statecode");
    if (countyCode == null || countyCode.trim().isEmpty()) {
      messages.put("success", "Invalid County Code");
    } else {
      if (countyName == null || countyName.trim().isEmpty()) {
        messages.put("success", "Invalid County Name");
      } else {
        if (stateCode == null || stateCode.trim().isEmpty()) {
          messages.put("success", "Invalid State Code");
        } else {
          County county = new County(Integer.parseInt(countyCode), countyName, stateCode);
          try {
            county = countyDAO.create(county);
            messages.put("success", "Successfully created " + countyCode);
          } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new IOException(e);
          }
        }
      }
    }
    req.getRequestDispatcher("/CountyCreate.jsp").forward(req, resp);
  }
}
