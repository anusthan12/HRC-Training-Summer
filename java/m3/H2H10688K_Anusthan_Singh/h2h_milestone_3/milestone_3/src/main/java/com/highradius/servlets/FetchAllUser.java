package com.highradius.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchAllUser
 */
import com.google.gson.Gson;
import com.highradius.dao.UserDAO;
import com.highradius.dao.UserDaoImpl;
import com.highradius.model.POJO;

@WebServlet("/FetchAllUsers")
public class FetchAllUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    private Gson gson;

    public void init() {
        userDAO = new UserDaoImpl();
        gson = new Gson();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Fetch all users from the database
            List<POJO> userList = userDAO.selectAllUsers();
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
