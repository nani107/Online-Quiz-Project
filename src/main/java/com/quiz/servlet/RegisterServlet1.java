package com.quiz.servlet;

import com.quiz.dao.UserDAO1;
import com.quiz.model.User1;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        if (username == null || password == null || email == null || username.trim().isEmpty() || password.trim().isEmpty() || email.trim().isEmpty()) {
            request.setAttribute("error", "All fields are required");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        User1 user = new User1();
        user.setUsername(username);
        user.setPassword(password); // TODO: Hash password in production
        user.setEmail(email);

        UserDAO1 userDAO = new UserDAO1();
        try {
            if (userDAO.registerUser(user)) {
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("error", "Registration failed. Username may already exist.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}