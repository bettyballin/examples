<?php
$host = 'localhost';
$dbname = 'database_name';
$username = 'username';
$password = 'password';

try {
    $pdo = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    die("ERROR: Could not connect. " . $e->getMessage());
}

$user_id = '123';
$comment = 'Hello, World!';

try {
    $sql = "INSERT INTO table_name (user_id, comment) VALUES (:user_id, :comment)";
    $stmt = $pdo->prepare($sql);
    $stmt->bindParam(':user_id', $user_id);
    $stmt->bindParam(':comment', $comment);
    $stmt->execute();
    echo "Records inserted successfully.";
} catch (PDOException $e) {
    die("ERROR: Could not execute $sql. " . $e->getMessage());
}

unset($pdo);
?>