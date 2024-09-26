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

function myquery() {
  global $pdo;
  $params = func_get_args();
  $sql = array_shift($params);
  $stmt = $pdo->prepare($sql);
  $stmt->execute($params);
  return $stmt; 
}

// example usage
$stmt = myquery('SELECT * FROM your_table WHERE id = ?', 1);
$results = $stmt->fetchAll();
print_r($results);