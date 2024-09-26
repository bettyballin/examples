<?php
$dbConnection = new mysqli("localhost", "username", "password", "database");

if ($dbConnection->connect_error) {
    die("Connection failed: " . $dbConnection->connect_error);
}

$name = 'John Doe'; // replace with your desired name

$stment = $dbConnection->prepare('SELECT * FROM users WHERE name = ?');
$stment->bind_param('s', $name);

$stment->execute();

$result = $stment->get_result();
while ($row = $result->fetch_assoc()) {
    print_r($row);
}

$stment->close();
$dbConnection->close();
?>