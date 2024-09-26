<?php
$db = new mysqli("localhost", "username", "password", "database");

if ($db->connect_error) {
    die("Connection failed: " . $db->connect_error);
}

$login = "your_login";
$password = "your_password";

$stmt = $db->prepare("INSERT INTO users (login, password) VALUES (?, ?)");

// Hash the password
$hashed_password = password_hash($password, PASSWORD_DEFAULT);

/*
 * Bind variables to prepared statement
 */
$stmt->bind_param("ss", $login, $hashed_password);

if ($stmt->execute()) {
    echo "New records created successfully";
} else {
    echo "Error: " . $stmt->error;
}

$stmt->close();
$db->close();
?>