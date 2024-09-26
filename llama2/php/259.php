<?php
// Connect to the database
$dsn = 'mysql:host=localhost;dbname=mydatabase';
$username = 'root';
$password = '';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}

// Define a function to hash passwords
function hash_password($password) {
    return password_hash($password, PASSWORD_DEFAULT);
}