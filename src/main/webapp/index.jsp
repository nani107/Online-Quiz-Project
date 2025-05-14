<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Authentication</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #a1c4fd, #c2e9fb);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .container {
            max-width: 700px;
        }
        .card {
            border: none;
            border-radius: 20px;
            box-shadow: 0 12px 24px rgba(0, 0, 0, 0.15);
            background: white;
            animation: fadeIn 1s ease-in-out;
        }
        .welcome-title {
            font-size: 3rem;
            font-weight: 600;
            color: #ffffff;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
            margin-bottom: 20px;
        }
        .quiz-image {
            max-width: 100%;
            height: auto;
            border-radius: 15px;
            margin-bottom: 20px;
        }
        .btn-primary, .btn-secondary {
            padding: 12px 40px;
            font-size: 1.2rem;
            border-radius: 30px;
            transition: transform 0.3s, box-shadow 0.3s;
            margin: 0 10px;
        }
        .btn-primary:hover, .btn-secondary:hover {
            transform: translateY(-3px);
            box-shadow: 0 6px 18px rgba(0, 0, 0, 0.2);
        }
        .btn-icon {
            margin-right: 8px;
        }
        .lead {
            font-size: 1.3rem;
            color: #333;
            margin-bottom: 30px;
        }
        @keyframes fadeIn {
            0% { opacity: 0; transform: translateY(20px); }
            100% { opacity: 1; transform: translateY(0); }
        }
        @media (max-width: 576px) {
            .welcome-title {
                font-size: 2rem;
            }
            .btn-primary, .btn-secondary {
                padding: 10px 20px;
                font-size: 1rem;
            }
            .card {
                margin: 20px;
            }
        }
    </style>
</head>
<body>
    <div class="container mt-5 text-center">
        <h1 class="welcome-title">Welcome to Quiz</h1>
        <div class="card">
            <div class="card-body">
                <img src="images/quiz-image.jpg" 
                     alt="Quiz Image" class="quiz-image">
                <h2>Welcome to User Authentication</h2>
                <p class="lead">Join our exciting quiz platform! Register to start or log in to continue your journey.</p>
                <p>
                    <a href="register.jsp" class="btn btn-primary"><i class="fas fa-user-plus btn-icon"></i> Register</a>
                    <a href="login.jsp" class="btn btn-secondary"><i class="fas fa-sign-in-alt btn-icon"></i> Login</a>
                </p>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Font Awesome JS for icons -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/js/all.min.js"></script>
</body>
</html>