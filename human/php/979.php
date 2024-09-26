<?php
$dbh = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');

$username = $_POST["username"];
$email = $_POST["email"];
$password = $_POST["password"];
$hash = password_hash($password, PASSWORD_DEFAULT);

$stmt = $dbh->prepare("INSERT INTO users (username, email, password) VALUES (?, ?, ?)");
$stmt->execute([$username, $email, $hash]);
?>