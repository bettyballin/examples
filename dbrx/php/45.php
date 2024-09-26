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

$stmt = $pdo->prepare("SELECT * FROM table WHERE semester=:semester");
$stmt->execute(array(':semester' => $_GET['semester']));

$result = $stmt->fetchAll(PDO::FETCH_ASSOC);
print_r($result);
?>