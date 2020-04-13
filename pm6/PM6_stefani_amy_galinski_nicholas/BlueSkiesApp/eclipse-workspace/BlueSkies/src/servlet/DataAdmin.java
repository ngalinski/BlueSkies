package servlet;

import dal.*;
import model.*;
import helpers.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Search zip 
 */
@WebServlet("/dataadmin")
public class DataAdmin extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Map for storing messages.
        req.getRequestDispatcher("/DataAdmin.jsp").forward(req, resp);
	 
	}
	
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
		// Map for storing messages.
        req.getRequestDispatcher("/DataAdmin.jsp").forward(req, resp);
	   
	}
	
}
