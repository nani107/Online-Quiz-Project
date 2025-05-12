<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5 text-center">
        <div class="card">
            <div class="card-header">
                <h3>Login Successful</h3>
            </div>
            <div class="card-body">
                <% if (request.getAttribute("error") != null) { %>
                    <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
                <% } %>
                <p>Welcome, <%= session.getAttribute("username") %>!</p>
                <a href="quiz" class="btn btn-success">Start Quiz</a>
                <a href="index.jsp" class="btn btn-primary mt-2">Back to Home</a>
            </div>
        </div>
    </div>
</body>
</html>