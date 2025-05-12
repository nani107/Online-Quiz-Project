<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz Results</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h3>Quiz Results</h3>
                    </div>
                    <div class="card-body">
                        <h5>Your Score: ${score} out of ${totalQuestions}</h5>
                        <c:forEach var="question" items="${questions}" varStatus="loop">
                            <div class="mb-3">
                                <p><strong>Question ${loop.index + 1}:</strong> ${question.questionText}</p>
                                <p>Your Answer: ${userAnswers[loop.index] != null ? question.options[userAnswers[loop.index]] : 'Not answered'}</p>
                                <p>Correct Answer: ${question.options[question.correctAnswer]}</p>
                            </div>
                        </c:forEach>
                        <a href="welcome.jsp" class="btn btn-primary">Back to Dashboard</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>