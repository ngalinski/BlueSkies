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


@WebServlet("/getcounty")
public class CountyRead extends HttpServlet {

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

    List<County> countyList = new ArrayList<County>();

    String countyName = req.getParameter("countyname");
    if (countyName == null || countyName.trim().isEmpty()) {
      messages.put("success", "Please enter a valid county name.");
    } else {
      try {
        countyList = countyDAO.getCountiesbyName(countyName);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
      messages.put("success", "Displaying results for county name" + countyName);
      messages.put("previousCountyName", countyName);
    }
    req.setAttribute("counties", countyList);

    req.getRequestDispatcher("/CountyRead.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    List<County> countyList = new ArrayList<County>();

    String countyName = req.getParameter("countyname");
    if (countyName == null || countyName.trim().isEmpty()) {
      messages.put("success", "Please enter a valid county name.");
    } else {
      try {
        countyList = countyDAO.getCountiesbyName(countyName);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
      messages.put("success", "Displaying results for county name:" + countyName);
    }
    req.setAttribute("counties", countyList);

    req.getRequestDispatcher("/CountyRead.jsp").forward(req, resp);
  }
}
