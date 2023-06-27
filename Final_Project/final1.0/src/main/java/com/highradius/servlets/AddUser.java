package com.highradius.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InvoiceDao invoiceDao;

    public void init() {
        invoiceDao = new InvoiceDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the response type to JSON
        response.setContentType("application/json");
        
        int customerOrderID = Integer.parseInt(request.getParameter("CUSTOMER_ORDER_ID"));
        String salesOrg = request.getParameter("SALES_ORG");
        String distributionChannel = request.getParameter("DISTRIBUTION_CHANNEL");
        int customerNumber = Integer.parseInt(request.getParameter("CUSTOMER_NUMBER"));
        String companyCode = request.getParameter("COMPANY_CODE");
        String orderCurrency = request.getParameter("ORDER_CURRENCY");
        double amountUSD = Double.parseDouble(request.getParameter("AMOUNT_IN_USD"));
        String orderCreationDateStr = request.getParameter("ORDER_CREATION_DATE");

        java.sql.Date orderCreationDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date utilDate = dateFormat.parse(orderCreationDateStr);
            orderCreationDate = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Invoice newInvoice = new Invoice(customerOrderID, salesOrg, distributionChannel, customerNumber, companyCode,
                    orderCurrency, amountUSD, orderCreationDate);

            invoiceDao.insertUser(newInvoice);
            
            // Send a success response
            response.getWriter().write("{\"status\":\"success\"}");
        } catch (SQLException e) {
            e.printStackTrace();
            
            // Send an error response
            response.getWriter().write("{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}");
        }
    }
}
