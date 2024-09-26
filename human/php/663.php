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

$id  = 1;
$stm = $pdo->prepare("SELECT name FROM table WHERE id=?");
$stm->execute(array($id));
$name = $stm->fetchColumn();

print($name);
?>