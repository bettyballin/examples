<?php
$pdo = new PDO('mysql:host=localhost;dbname=database_name', 'username', 'password');

$id = 1; // replace with your desired ID

$stmt = $pdo->prepare("SELECT * FROM column_name WHERE id = :id");
$stmt->bindValue(':id', (int)$id);
$stmt->execute();

$result = $stmt->fetchAll();

print_r($result);
?>