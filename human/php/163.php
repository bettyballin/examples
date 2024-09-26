<?php
$user_id = 1; // replace with your desired user ID
$dsn = 'mysql:host=localhost;dbname=your_database'; // replace with your database connection settings
$username = 'your_username'; // replace with your database username
$password = 'your_password'; // replace with your database password

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}

$sql = "SELECT status FROM users WHERE id = ?";
$stmt = $pdo->prepare($sql);
$result = $stmt->execute(array($user_id));
$userData = $stmt->fetch();

print_r($userData);
?>