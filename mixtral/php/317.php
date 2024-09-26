<?php
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
  $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
  throw new PDOException($e->getMessage(), (int)$e->getCode());
}

$stmt = $pdo->prepare("INSERT INTO table (column) VALUES (?)");

// Bind parameters to placeholders
$stmt->bindParam(1, $txtpost);

try {
  // Execute the statement
  $stmt->execute();
} catch (PDOException $e) {
  throw new PDOException($e->getMessage(), (int)$e->getCode());
}
?>