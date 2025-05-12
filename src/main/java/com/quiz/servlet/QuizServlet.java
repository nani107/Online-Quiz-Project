package com.quiz.servlet;

import com.quiz.dao.QuestionDAO;
import com.quiz.model.Question;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizServlet extends HttpServlet {
    private QuestionDAO questionDAO;

    @Override
    public void init() throws ServletException {
        try {
            questionDAO = new QuestionDAO();
            System.out.println("QuizServlet initialized successfully");
        } catch (Exception e) {
            System.err.println("Error initializing QuizServlet: " + e.getMessage());
            e.printStackTrace();
            throw new ServletException("Failed to initialize QuestionDAO", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            // Initialize quiz
            List<Question> questions = questionDAO.getAllQuestions();
            if (questions.isEmpty()) {
                request.setAttribute("error", "No questions available in the database.");
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
                return;
            }
            session.setAttribute("questions", questions);
            session.setAttribute("currentQuestionIndex", 0);
            session.setAttribute("userAnswers", new Integer[questions.size()]);
            session.setAttribute("totalQuestions", questions.size());

            // Show first question
            showQuestion(request, response, 0);
        } catch (Exception e) {
            System.err.println("SQL Exception in QuizServlet: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        Integer[] userAnswers = (Integer[]) session.getAttribute("userAnswers");
        int currentQuestionIndex = Integer.parseInt(request.getParameter("currentQuestionIndex"));
        String action = request.getParameter("action");

        // Save user's answer
        String answerStr = request.getParameter("answer");
        if (answerStr != null) {
            userAnswers[currentQuestionIndex] = Integer.parseInt(answerStr);
            session.setAttribute("userAnswers", userAnswers);
        } else {
            request.setAttribute("error", "Please select an answer");
            showQuestion(request, response, currentQuestionIndex);
            return;
        }

        if ("next".equals(action)) {
            // Show next question
            showQuestion(request, response, currentQuestionIndex + 1);
        } else if ("submit".equals(action)) {
            // Calculate score and show results
            int score = 0;
            for (int i = 0; i < questions.size(); i++) {
                if (userAnswers[i] != null && userAnswers[i] == questions.get(i).getCorrectAnswer()) {
                    score++;
                }
            }
            session.setAttribute("score", score);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }

    private void showQuestion(HttpServletRequest request, HttpServletResponse response, int index) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        Integer[] userAnswers = (Integer[]) session.getAttribute("userAnswers");
        int totalQuestions = (int) session.getAttribute("totalQuestions");

        request.setAttribute("question", questions.get(index));
        request.setAttribute("currentQuestionIndex", index);
        request.setAttribute("totalQuestions", totalQuestions);
        request.setAttribute("lastQuestion", index == totalQuestions - 1);
        request.setAttribute("userAnswer", userAnswers[index]);
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }
}