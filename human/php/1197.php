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

$query = $pdo->prepare('SELECT * FROM users WHERE id = ? AND check = ?');
$query->execute([$_GET['id'], $_POST['check']]);
while ($row = $query->fetch()) {
    // your code here
    print_r($row);
}
?>