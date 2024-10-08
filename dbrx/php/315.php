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

$txtpost = 'Your post title';

$stmt = $pdo->prepare('INSERT INTO posts (title) VALUES (:txtpost)');
$stmt->execute([':txtpost' => $txtpost]);

echo 'Post added successfully!';
?>