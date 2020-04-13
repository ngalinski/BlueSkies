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


@WebServlet("/countyupdate")
public class CountyUpdate extends HttpServlet {

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

    String countyCode = req.getParameter("countycode");
    if (countyCode == null || countyCode.trim().isEmpty()) {
      messages.put("success", "Please enter a valid County Code.");
    } else {
      try {
        County county = countyDAO.getCountyFromCountyCode(Integer.parseInt(countyCode));
        if(county == null) {
          messages.put("success", "County does not exist.");
        }
        req.setAttribute("county", county);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/CountyUpdate.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    String countyCode = req.getParameter("countycode");
    if (countyCode == null || countyCode.trim().isEmpty()) {
      messages.put("success", "Please enter a valid County Code.");
    } else {
      try {
        County county = countyDAO.getCountyFromCountyCode(Integer.parseInt(countyCode));
        if(county == null) {
          messages.put("success", "County does not exist. No update to perform.");
        } else {
          String newName = req.getParameter("countyname2");
          if (newName == null || newName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid new county name.");
          } else {
            countyDAO.updateCountyName(county, newName);
            messages.put("success", "Successfully updated " + newName);
          }
        }
        req.setAttribute("county", county);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/CountyUpdate.jsp").forward(req, resp);
  }
}
