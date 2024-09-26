php
<?php
$dbParams = array(
   'database' => 'my_db',
   'host'     => 'localhost',
   'username' => 'my_web_user',
   'password' => 'abc123',
);

$dsn = "mysql:host={$dbParams['host']};dbname={$dbParams['database']}";
$conn = new PDO($dsn, $dbParams['username'], $dbParams['password']);

// example query
$stmt = $conn->prepare("SELECT * FROM my_table");
$stmt->execute();
$result = $stmt->fetchAll();

print_r($result);
?>