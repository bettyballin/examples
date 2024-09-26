<?php
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}

$data = 'your_data';
$data2 = 'your_data2';

$stmt = $pdo->prepare('INSERT INTO `Tab`(`data`, `data2`) VALUES (:data, :data2)');
$stmt->bindParam(':data', $data);
$stmt->bindParam(':data2', $data2);
$stmt->execute();