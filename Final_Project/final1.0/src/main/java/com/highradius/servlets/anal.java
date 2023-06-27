package com.highradius.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;

import java.io.PrintWriter;
/**
 * Servlet implementation class anal
 */
@WebServlet("/anal")
public class anal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InvoiceDao user;

    public void init() {
        user = new InvoiceDaoImpl();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public anal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the customer order ID from the request URL parameter
        String customerOrderIDParam = request.getParameter("customerOrderID");

        if (customerOrderIDParam != null && !customerOrderIDParam.isEmpty()) {
            int customerOrderID = Integer.parseInt(customerOrderIDParam);

            // Create an instance of InvoiceDaoImpl
            InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();

            try {
                // Call the getAmountInUSD method to retrieve the amount in USD
                double amountUSD = invoiceDao.getAmountInUSD(customerOrderID);

                // Write the amount in USD as the response
                out.println(amountUSD);
            } catch (SQLException e) {
                // Handle the SQL exception
                out.println("<h1>Error occurred while retrieving amount in USD</h1>");
                out.println("<p>Error message: " + e.getMessage() + "</p>");
                e.printStackTrace();
            }
        } else {
            out.println("<h1>Invalid customerOrderID</h1>");
        }
    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        doGet(request, response);
//    }

}
