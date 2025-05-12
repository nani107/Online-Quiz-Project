<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h3>Question ${currentQuestionIndex + 1} of ${totalQuestions}</h3>
                    </div>
                    <div class="card-body">
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger">${error}</div>
                        </c:if>
                        <form action="quiz" method="post">
                            <input type="hidden" name="currentQuestionIndex" value="${currentQuestionIndex}">
                            <input type="hidden" name="action" value="${lastQuestion ? 'submit' : 'next'}">
                            <h5>${question.questionText}</h5>
                            <c:forEach var="option" items="${question.options}" varStatus="loop">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="answer" value="${loop.index}" id="option${loop.index}" ${userAnswer == loop.index ? 'checked' : ''} required>
                                    <label class="form-check-label" for="option${loop.index}">${option}</label>
                                </div>
                            </c:forEach>
                            <button type="submit" class="btn btn-primary mt-3">${lastQuestion ? 'Submit Quiz' : 'Next Question'}</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>