<?php
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    die('Connection failed: ' . $e->getMessage());
}

$query = "SELECT a, b FROM t WHERE x = :val1 AND y = :val2";
$val1 = 'your_value1';
$val2 = 'your_value2';

$stmt = $pdo->prepare($query);
$stmt->bindParam(':val1', $val1);
$stmt->bindParam(':val2', $val2);
$stmt->execute();

$result = $stmt->fetchAll();

print_r($result);
?>