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


@WebServlet("/statecreate")
public class StateCreate extends HttpServlet {

  protected StateDAO stateDAO;

  @Override
  public void init() throws ServletException {
    stateDAO = StateDAO.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);
    //Just render the JSP.
    req.getRequestDispatcher("/StateCreate.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    // Retrieve and validate name.
    String stateCode = req.getParameter("statecode");
    String stateName = req.getParameter("statename");
    String region = req.getParameter("region");
    if (stateCode == null || stateCode.trim().isEmpty()) {
      messages.put("success", "Invalid State Code");
    } else {
      if (stateName == null || stateName.trim().isEmpty()) {
        messages.put("success", "Invalid State Name");
      } else {
        if (region == null || region.trim().isEmpty()) {
          messages.put("success", "Invalid State Region");
        } else {
          State state = new State(stateCode, stateName, region);
          try {
            state = stateDAO.create(state);
            messages.put("success", "Successfully created " + stateCode);
          } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new IOException(e);
          }
        }
      }
    }
    req.getRequestDispatcher("/StateCreate.jsp").forward(req, resp);
  }
}
