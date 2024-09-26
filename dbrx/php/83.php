<?php

// Connect to database using PDO
$pdo = new PDO('mysql:host=localhost;dbname=mydb', 'username', 'password');

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $usernamelogin = $_POST['username'];
    $passwordlogin = $_POST['password'];

    // Prepare a statement to check if the provided username and hashed password exist
    $stmt = $pdo->prepare('SELECT * FROM users WHERE username = :username');
    $stmt->bindParam(':username', $usernamelogin);

    // Execute the statement with provided credentials
    if ($stmt->execute() && $row = $stmt->fetch()) {
        if(password_verify($passwordlogin, $row['password'])) {
            session_start();
            $_SESSION['id'] = bin2hex(random_bytes(32)); // Generate a random token for the user's session ID
            $_SESSION['un'] = $usernamelogin;
        } else {
            echo 'Wrong username or password.';
        }
    } else {
        echo 'Wrong username or password.';
    }
}

?>