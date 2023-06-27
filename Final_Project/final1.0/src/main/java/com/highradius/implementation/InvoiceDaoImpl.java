package com.highradius.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.highradius.connection.DatabaseConnection;
import com.highradius.model.Invoice;

public class InvoiceDaoImpl implements InvoiceDao {

    private static final String INSERT_USER_SQL = "INSERT INTO h2h_oap (CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL, CUSTOMER_NUMBER, COMPANY_CODE, ORDER_CURRENCY, AMOUNT_IN_USD, ORDER_CREATION_DATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_USERS_SQL = "SELECT * FROM h2h_oap LIMIT 500;";
    private static final String DELETE_USER_SQL = "DELETE FROM h2h_oap WHERE CUSTOMER_ORDER_ID = ?";
    private static final String UPDATE_USER_SQL = "UPDATE h2h_oap\r\n"
    		+ "SET SALES_ORG = ?,\r\n"
    		+ "    DISTRIBUTION_CHANNEL =?,\r\n"
    		+ "    CUSTOMER_NUMBER = ?,\r\n"
    		+ "    COMPANY_CODE = ?,\r\n"
    		+ "    ORDER_CURRENCY = ?,\r\n"
    		+ "    AMOUNT_IN_USD = ?,\r\n"
    		+ "    ORDER_CREATION_DATE = ?\r\n"
    		+ "WHERE CUSTOMER_ORDER_ID = ?;";
    private static final String ANAL = "SELECT AMOUNT_IN_USD FROM h2h_oap WHERE CUSTOMER_ORDER_ID = ?;";
    private static final String SCR = "SELECT * FROM h2h_oap WHERE CUSTOMER_ORDER_ID = ?;";
    private static final String ADSCR = "SELECT * FROM h2h_oap WHERE CUSTOMER_ORDER_ID = ? AND SALES_ORG = ?;";
    
    public void insertUser(Invoice user) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setInt(1, user.getCustomerOrderID());
            preparedStatement.setString(2, user.getSalesOrg());
            preparedStatement.setString(3, user.getDistributionChannel());
            preparedStatement.setInt(4, user.getCustomerNumber());
            preparedStatement.setString(5, user.getCompanyCode());
            preparedStatement.setString(6, user.getOrderCurrency());
            preparedStatement.setDouble(7, user.getAmountUSD());
            preparedStatement.setDate(8, new java.sql.Date(user.getOrderCreationDate().getTime()));

            preparedStatement.executeUpdate();
        }
    }
    
    public double getAmountInUSD(int customerOrderID) throws SQLException {
        double amountUSD = 0;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ANAL)) {
            preparedStatement.setInt(1, customerOrderID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                amountUSD = resultSet.getDouble("AMOUNT_IN_USD");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return amountUSD;
    }
    
    public List<Invoice> selectAllUsers() {
        List<Invoice> users = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int customerOrderID = resultSet.getInt("CUSTOMER_ORDER_ID");
                String salesOrg = resultSet.getString("SALES_ORG");
                String distributionChannel = resultSet.getString("DISTRIBUTION_CHANNEL");
                int customerNumber = resultSet.getInt("CUSTOMER_NUMBER");
                String companyCode = resultSet.getString("COMPANY_CODE");
                String orderCurrency = resultSet.getString("ORDER_CURRENCY");
                double amountUSD = resultSet.getDouble("AMOUNT_IN_USD");
                String OrderCreationDateStr = resultSet.getString("ORDER_CREATION_DATE");
                
                java.sql.Date orderCreationDate = null;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    java.util.Date utilDate = dateFormat.parse(OrderCreationDateStr);
                    orderCreationDate = new java.sql.Date(utilDate.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Invoice user = new Invoice(customerOrderID, salesOrg, distributionChannel, customerNumber, companyCode, orderCurrency, amountUSD, orderCreationDate);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    
    public List<Invoice> search(int cid) {
        List<Invoice> invoices = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SCR)) {
            
            preparedStatement.setInt(1, cid);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int customerOrderID = resultSet.getInt("CUSTOMER_ORDER_ID");
                    String salesOrg = resultSet.getString("SALES_ORG");
                    String distributionChannel = resultSet.getString("DISTRIBUTION_CHANNEL");
                    int customerNumber = resultSet.getInt("CUSTOMER_NUMBER");
                    String companyCode = resultSet.getString("COMPANY_CODE");
                    String orderCurrency = resultSet.getString("ORDER_CURRENCY");
                    double amountUSD = resultSet.getDouble("AMOUNT_IN_USD");
                    String orderCreationDateStr = resultSet.getString("ORDER_CREATION_DATE");

                    java.sql.Date orderCreationDate = null;
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        java.util.Date utilDate = dateFormat.parse(orderCreationDateStr);
                        orderCreationDate = new java.sql.Date(utilDate.getTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Invoice invoice = new Invoice(customerOrderID, salesOrg, distributionChannel, customerNumber, companyCode, orderCurrency, amountUSD, orderCreationDate);
                    invoices.add(invoice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return invoices;
    }
    public List<Invoice> advsearch(int cid , int sale) {
        List<Invoice> invoices = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADSCR)) {
            
            preparedStatement.setInt(1, cid);
            preparedStatement.setInt(2, sale);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int customerOrderID = resultSet.getInt("CUSTOMER_ORDER_ID");
                    String salesOrg = resultSet.getString("SALES_ORG");
                    String distributionChannel = resultSet.getString("DISTRIBUTION_CHANNEL");
                    int customerNumber = resultSet.getInt("CUSTOMER_NUMBER");
                    String companyCode = resultSet.getString("COMPANY_CODE");
                    String orderCurrency = resultSet.getString("ORDER_CURRENCY");
                    double amountUSD = resultSet.getDouble("AMOUNT_IN_USD");
                    String orderCreationDateStr = resultSet.getString("ORDER_CREATION_DATE");

                    java.sql.Date orderCreationDate = null;
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        java.util.Date utilDate = dateFormat.parse(orderCreationDateStr);
                        orderCreationDate = new java.sql.Date(utilDate.getTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Invoice invoice = new Invoice(customerOrderID, salesOrg, distributionChannel, customerNumber, companyCode, orderCurrency, amountUSD, orderCreationDate);
                    invoices.add(invoice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return invoices;
    }

    public boolean deleteUser(int customerOrderID) throws SQLException {
        boolean rowDeleted = false;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL)) {
            preparedStatement.setInt(1, customerOrderID);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }

        return rowDeleted;
    }

    public boolean updateUser(Invoice user) throws SQLException {
        boolean rowUpdated = false;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE h2h_oap\r\n"
             		+ "SET SALES_ORG = ?,\r\n"
            		+ "    DISTRIBUTION_CHANNEL =?,\r\n"
            		+ "    CUSTOMER_NUMBER = ?,\r\n"
            		+ "    COMPANY_CODE = ?,\r\n"
            		+ "    ORDER_CURRENCY = ?,\r\n"
            		+ "    AMOUNT_IN_USD = ?,\r\n"
            		+ "    ORDER_CREATION_DATE = ?\r\n"
            		+ "WHERE CUSTOMER_ORDER_ID = ?;")) {
            preparedStatement.setString(1, user.getSalesOrg());
            preparedStatement.setString(2, user.getDistributionChannel());
            preparedStatement.setInt(3, user.getCustomerNumber());
            preparedStatement.setString(4, user.getCompanyCode());
            preparedStatement.setString(5, user.getOrderCurrency());
            preparedStatement.setDouble(6, user.getAmountUSD());
            preparedStatement.setDate(7, new java.sql.Date(user.getOrderCreationDate().getTime()));
            preparedStatement.setInt(8, user.getCustomerOrderID());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }

        return rowUpdated;
    }
}
