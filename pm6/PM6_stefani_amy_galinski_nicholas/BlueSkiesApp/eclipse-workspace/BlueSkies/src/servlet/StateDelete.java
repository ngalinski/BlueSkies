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


@WebServlet("/statedelete")
public class StateDelete extends HttpServlet {

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
    // Provide a title and render the JSP.
    messages.put("title", "Delete State");
    req.getRequestDispatcher("/StateDelete.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    // Retrieve and validate name.
    String stateCode = req.getParameter("statecode");
    if (stateCode == null || stateCode.trim().isEmpty()) {
      messages.put("title", "State Code not valid");
      messages.put("disableSubmit", "true");
    } else {
      State state = new State(stateCode);
      try {
        state = stateDAO.delete(state);
        // Update the message.
        if (state == null) {
          messages.put("title", "Successfully deleted " + stateCode);
          messages.put("disableSubmit", "true");
        } else {
          messages.put("title", "Failed to delete " + stateCode);
          messages.put("disableSubmit", "false");
        }
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/StateDelete.jsp").forward(req, resp);
  }
}
