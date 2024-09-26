<?php

$pdo = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');

$stmt = $pdo->prepare("SELECT * FROM products WHERE product_id = :id");
$stmt->bindValue(':id', (int)$_GET['id']);
$stmt->execute();

?>