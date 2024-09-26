<?php

// Connection to database
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}

// Validate user input
$name = filter_var($_POST['name'], FILTER_SANITIZE_STRING);

// Use prepared statements to prevent SQL Injection
$stmt = $pdo->prepare("SELECT * FROM users WHERE name = :name");
$stmt->bindValue(':name', $name, PDO::PARAM_STR);
$stmt->execute();

// Validate user credentials
if ($stmt->rowCount() == 1) {
    // Check if the password is correct
    $hashedPassword = $stmt->fetch(PDO::FETCH_ASSOC)['password'];
    if (password_verify($_POST['password'], $hashedPassword)) {
        // Start a secure session
        session_start();
        $_SESSION['user'] = $name;
    }
}

// Use output encoding to prevent XSS
header('Content-Type: text/html; charset=UTF-8');

?>