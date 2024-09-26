<?php
// Connect to the database
$dsn = 'mysql:host=localhost;dbname=my_database';
$username = 'my_username';
$password = 'my_password';

try {
    $pdo = new PDO($dsn, $username, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}
?>