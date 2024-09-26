<?php
$mysqli = new mysqli("localhost", "username", "password", "database");

if ($mysqli->connect_error) {
    die("Connection failed: " . $mysqli->connect_error);
}

$name = "John Doe";
$email = "johndoe@example.com";

$stmt = $mysqli->prepare("SELECT * FROM users WHERE name = ? AND email = ?");
$stmt->bind_param("ss", $name, $email);
$stmt->execute();
$result = $stmt->get_result();

while ($row = $result->fetch_assoc()) {
    print_r($row);
}

$stmt->close();
$mysqli->close();
?>