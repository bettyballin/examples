php
<?php

$dbParams = array(
   'database' => getenv('myapp_db_name'),
   'host'     => getenv('myapp_db_host'),
   'username' => getenv('myapp_db_username'),
   'password' => getenv('myapp_db_password'),
);

// example usage:
$dsn = "mysql:host={$dbParams['host']};dbname={$dbParams['database']}";
$conn = new PDO($dsn, $dbParams['username'], $dbParams['password']);

// example query:
$stmt = $conn->prepare('SELECT * FROM mytable');
$stmt->execute();
$result = $stmt->fetchAll(PDO::FETCH_ASSOC);

print_r($result);

?>