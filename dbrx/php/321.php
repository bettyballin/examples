<?php
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    throw new PDOException($e->getMessage(), (int)$e->getCode());
}

$stmt = $pdo->prepare('INSERT INTO table_name (column) VALUES (:value)');
$stmt->bindParam(':value', $user_input);

$user_input = filter_var($_POST['input'], FILTER_SANITIZE_STRING);
$stmt->execute();