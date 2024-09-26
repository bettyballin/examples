<?php
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $db = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}

$author_id = 1; // replace with actual author id

$stm1 = $db->prepare("UPDATE user SET rep = rep + 15 WHERE id = :author_id");
$stm1->bindParam(':author_id', $author_id);
$stm1->execute();
?>