php
<?php
function myquery() {
  global $pdo;
  $params = func_get_args();
  $sql = array_shift($params);
  $stmt = $pdo->prepare($sql);
  $stmt->execute($params);
  return $stmt; // so we can fetch(), etc.
}

// Create a PDO instance
$dsn = 'mysql:host=localhost;dbname=mydatabase';
$username = 'myusername';
$password = 'mypassword';
$pdo = new PDO($dsn, $username, $password);

// Example usage
$stmt = myquery('SELECT * FROM mytable WHERE id = ?', 1);
while ($row = $stmt->fetch()) {
  print_r($row);
}
?>