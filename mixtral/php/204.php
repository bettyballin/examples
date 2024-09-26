<?php

$allowed_tables = ['table1', 'table2'];
$userInputTableName = 'table1'; // For demonstration purposes

if (in_array($userInputTableName, $allowed_tables)) {
  // Proceed with the query using prepared statements
  $dsn = 'mysql:host=localhost;dbname=your_database';
  $username = 'your_username';
  $password = 'your_password';

  try {
    $pdo = new PDO($dsn, $username, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $stmt = $pdo->prepare("SELECT * FROM $userInputTableName");
    $stmt->execute();
    $result = $stmt->fetchAll();
    print_r($result);
  } catch (PDOException $e) {
    throw new Exception($e->getMessage());
  }
} else {
  throw new Exception('Invalid table name');
}

?>