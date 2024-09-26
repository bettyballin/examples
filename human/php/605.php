<?php

// Example using question mark slots
$stmt = $pdo->prepare('SELECT * FROM users WHERE name = ? AND email = ?');
$stmt->execute(['John Doe', 'john@example.com']);
$result = $stmt->fetchAll();

// Example using named slots
$stmt = $pdo->prepare('SELECT * FROM users WHERE name = :name AND email = :email');
$stmt->bindParam(':name', 'John Doe');
$stmt->bindParam(':email', 'john@example.com');
$stmt->execute();
$result = $stmt->fetchAll();

?>