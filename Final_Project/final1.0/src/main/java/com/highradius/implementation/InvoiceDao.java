package com.highradius.implementation;

import java.sql.SQLException;
import java.util.List;

import com.highradius.model.Invoice;

public interface InvoiceDao {

    void insertUser(Invoice user) throws SQLException;
    
    public double getAmountInUSD(int customerOrderID) throws SQLException ;

    List<Invoice> selectAllUsers();
    
    List<Invoice> search(int cid);
    
    List<Invoice> advsearch(int cid , int sale);

    boolean deleteUser(int customerOrderID) throws SQLException;

    boolean updateUser(Invoice user) throws SQLException;
}
