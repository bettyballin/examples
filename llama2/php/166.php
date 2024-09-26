<?php

// Connect to the database using PDO
$dsn = 'mysql:host=localhost;dbname=my_database';
$username = 'my_username';
$password = 'my_password';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit;
}

// Sanitize user input using filter_var()
$post = filter_var($_POST['input'], FILTER_SANITIZE_STRING);

?>