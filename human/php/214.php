<?php
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    die('Connection failed: ' . $e->getMessage());
}

$id = 1; // replace with your desired ID
$default_id = 1;

$stmt = $pdo->prepare("
    SELECT col1, col2, col3 FROM table WHERE ID = :id
    UNION ALL 
    SELECT col1, col2, col3 FROM table WHERE ID = :default_id
    WHERE NOT EXISTS (SELECT 1 FROM table WHERE ID = :id)
");

$stmt->bindParam(':id', $id);
$stmt->bindParam(':default_id', $default_id);

$stmt->execute();

$result = $stmt->fetchAll(PDO::FETCH_ASSOC);

print_r($result);
?>