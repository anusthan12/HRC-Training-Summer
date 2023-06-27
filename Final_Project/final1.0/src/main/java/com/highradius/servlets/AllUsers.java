package com.highradius.servlets;
import com.google.gson.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

/**
 * Servlet implementation class AllUsers
 */
@WebServlet("/AllUsers")
public class AllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceDao user;
    private Gson gson;

    public void init() {
        user = new InvoiceDaoImpl();
        gson = new Gson();
    }
    /**
     * Default constructor. 
     */
    public AllUsers() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  try {
	            // Fetch all users from the database
	            List<Invoice> userList = user.selectAllUsers();
	            gson = new Gson();
	            // Convert the userList to JSON string
	            String json = gson.toJson(userList);

	            // Set the content type to application/json
	            response.setContentType("application/json");
	            response.setCharacterEncoding("UTF-8");

	            // Write the JSON string as the response
	            response.getWriter().write(json);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
