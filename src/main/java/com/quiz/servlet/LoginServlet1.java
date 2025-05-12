package com.quiz.servlet;

import com.quiz.dao.UserDAO1;
import com.quiz.model.User1;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
            request.setAttribute("error", "Username and password are required");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        UserDAO1 userDAO = new UserDAO1();
        try {
            User1 user = userDAO.validateUser(username, password);
            if (user != null) {
                request.getSession().setAttribute("username", user.getUsername());
                response.sendRedirect("welcome.jsp");
            } else {
                response.sendRedirect("incorrect.jsp");
            }
        } catch (SQLException e) {
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}