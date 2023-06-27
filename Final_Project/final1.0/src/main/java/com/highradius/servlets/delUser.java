package com.highradius.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;

/**
 * Servlet implementation class delUser
 */
@WebServlet("/delUser")
public class delUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceDao user;

    public void init() {
        user = new InvoiceDaoImpl();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String customerOrderIDStr = request.getParameter("CUSTOMER_ORDER_ID");
//
//        if (customerOrderIDStr != null && !customerOrderIDStr.isEmpty()) {
//            int customerOrderID = Integer.parseInt(customerOrderIDStr);
//
//            try {
//                boolean deleted = user.deleteUser(customerOrderID);
//                if (deleted) {
//                    response.getWriter().println("User deleted successfully.");
//                } else {
//                    response.getWriter().println("Failed to delete user.");
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//                response.getWriter().println("An error occurred while deleting the user.");
//            }
//        } else {
//            response.getWriter().println("Invalid or missing CUSTOMER_ORDER_ID parameter.");
//        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}
	
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerOrderIDStr = request.getParameter("CUSTOMER_ORDER_ID");

        if (customerOrderIDStr != null && !customerOrderIDStr.isEmpty()) {
            int customerOrderID = Integer.parseInt(customerOrderIDStr);

            try {
                boolean deleted = user.deleteUser(customerOrderID);
                if (deleted) {
                    response.getWriter().println("User deleted successfully.");
                } else {
                    response.getWriter().println("Failed to delete user.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred while deleting the user.");
            }
        } else {
            response.getWriter().println("Invalid or missing CUSTOMER_ORDER_ID parameter.");
        }
    }

}
