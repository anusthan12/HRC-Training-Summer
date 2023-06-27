package com.highradius.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

/**
 * Servlet implementation class advscr
 */
@WebServlet("/advscr")
public class advscr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceDao user;
    private Gson gson;

    public void init() {
        user = new InvoiceDaoImpl();
        gson = new Gson();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public advscr() {
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
        String customerOrderIDParam = request.getParameter("CUSTOMER_ORDER_ID");
        String saleOrgParam = request.getParameter("SALES_ORG");
       // String DisIDParam = request.getParameter("DISTRIBUTION_CHANNEL");

        if (customerOrderIDParam != null && !customerOrderIDParam.isEmpty()) {
            int customerOrderID = Integer.parseInt(customerOrderIDParam);
            
            int  salesOrg = Integer.parseInt(saleOrgParam);
            //String distributionChannel = request.getParameter("DISTRIBUTION_CHANNEL");

            // Create an instance of InvoiceDaoImpl
//            InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();

            try {
                // Call the getAmountInUSD method to retrieve the amount in USD
            
                List<Invoice> userList = user.advsearch(customerOrderID,salesOrg);
                
                gson = new Gson();
	            // Convert the userList to JSON string
	            String json = gson.toJson(userList);

	            // Set the content type to application/json
	            response.setContentType("application/json");
	            response.setCharacterEncoding("UTF-8");

	            // Write the JSON string as the response
	            response.getWriter().write(json);

                // Write the amount in USD as the response
                
            } catch (Exception e) {
                // Handle the SQL exception
                out.println("<h1>Error occurred while retrieving amount in USD</h1>");
                out.println("<p>Error message: " + e.getMessage() + "</p>");
                e.printStackTrace();
            }
        } else {
            out.println("<h1>Invalid customerOrderID</h1>");
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
