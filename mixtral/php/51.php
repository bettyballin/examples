<?php
$mysqli = new mysqli("localhost", "username", "password", "database");

if ($mysqli->connect_error) {
    die("Connection failed: " . $mysqli->connect_error);
}

$stmt = $mysqli->prepare("INSERT INTO table (column) VALUES (?)");
$stmt->bind_param("s", $_POST['data']);

// execute query
if ($stmt->execute()) {
    echo "New record created successfully";
} else {
    echo "Error: " . $mysqli->error;
}

$stmt->close();
$mysqli->close();
?>