<?php
$dbConnection = new mysqli('localhost', 'username', 'password', 'database');
if ($dbConnection->connect_error) {
    die("Connection failed: " . $dbConnection->connect_error);
}

$name = 'John Doe';

$statement = $dbConnection->prepare('SELECT * FROM customers WHERE name = ?');
$statement->bind_param('s', $name);
$statement->execute();
$result = $statement->get_result();
while ($row = $result->fetch_assoc()) {
    print_r($row);
}

$dbConnection->close();
?>