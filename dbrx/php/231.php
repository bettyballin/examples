<?php
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $pdo = new PDO($dsn, $username, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}

$userCode = 'your_user_code'; // replace with your user code

$stmt = $pdo->prepare('INSERT INTO posts (code) VALUES (:code)');
$stmt->execute(['code' => htmlspecialchars($userCode)]);