package com.quiz.dao;

import com.quiz.model.Question;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    // Read database connection details from environment variables
    private String jdbcURL = System.getenv("DB_URL") != null ? System.getenv("DB_URL") : "jdbc:mysql://localhost:3306/quizdb?useSSL=false";
    private String jdbcUsername = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
    private String jdbcPassword = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "sweety";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }
    }

    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT id, question_text, option1, option2, option3, option4, correct_answer FROM questions";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestionText(rs.getString("question_text"));
                String[] options = {
                    rs.getString("option1"),
                    rs.getString("option2"),
                    rs.getString("option3"),
                    rs.getString("option4")
                };
                question.setOptions(options);
                question.setCorrectAnswer(rs.getInt("correct_answer"));
                questions.add(question);
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
        return questions;
    }
}