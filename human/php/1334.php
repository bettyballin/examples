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

$query = "SELECT user_n, user_id FROM users WHERE user_id < ? UNION SELECT 1, 2";
$stmt = $pdo->prepare($query);
$stmt->execute([10]); // assuming 10 as the value for user_id

$result = $stmt->fetchAll(PDO::FETCH_ASSOC);
print_r($result);
?>