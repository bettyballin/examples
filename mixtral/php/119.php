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

$stmt = $pdo->prepare("SELECT * FROM users WHERE name=:name");
$stmt->bindParam(':name', $_GET['name']);
$stmt->execute();

foreach ($stmt as $row) {
    // Do something with the data
    print_r($row);
}