<?php

// Configuration
$host = 'localhost';
$dbname = 'your_database';
$username = 'your_username';
$password = 'your_password';

// Connect to database
$pdo = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);

// Using named placeholders:
$stmt = $pdo->prepare("SELECT * FROM users WHERE name = :name");
$stmt->execute([':name' => $_GET['username']]);
$result = $stmt->fetchAll();
print_r($result);

// Or using positional placeholders:
$stmt = $pdo->prepare("SELECT * FROM users WHERE id = ?");
$stmt->execute([$_GET['id']]);
$result = $stmt->fetchAll();
print_r($result);

?>