<?php
// Connection to database
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';
$pdo = new PDO($dsn, $username, $password);

// When a user registers or updates their password
$password = $_POST['password'];
$hashedPassword = password_hash($password, PASSWORD_DEFAULT);

// Store the hashed password in the database
$stmt = $pdo->prepare("INSERT INTO users (password) VALUES (:hashedPassword)");
$stmt->bindValue(':hashedPassword', $hashedPassword, PDO::PARAM_STR);
$stmt->execute();

// When a user logs in
$loginPassword = $_POST['password'];

// Retrieve the hashed password from the database
$stmt = $pdo->prepare("SELECT password FROM users WHERE username = :username");
$stmt->bindValue(':username', $_POST['username'], PDO::PARAM_STR);
$stmt->execute();
$hashedLoginPassword = $stmt->fetchColumn();

// Check
if(password_verify($loginPassword, $hashedLoginPassword)) {
    echo "Login successful";
} else {
    echo "Invalid password";
}
?>