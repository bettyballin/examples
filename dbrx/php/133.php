<?php
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    throw new PDOException($e->getMessage(), (int)$e->getCode());
}

$stmt = $pdo->prepare('SELECT * FROM users WHERE name = :name');
$stmt->bindValue(':name', $_POST['username']);
$stmt->execute();

$result = $stmt->fetchAll();
print_r($result);
?>