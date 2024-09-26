<?php
$dsn = 'mysql:host=localhost;dbname=test';
$username = 'username';
$password = 'password';

try {
    $pdo = new PDO($dsn, $username, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}

$pdo->query("insert into foo set id = 1; insert into foo set id = 2");
?>