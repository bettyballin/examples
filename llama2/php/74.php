<?php
$username = strtolower($_POST['username']); // Convert desired username to lowercase
$conn = new mysqli("localhost", "username", "password", "database");

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$query = $conn->query("SELECT COUNT(*) as count FROM user_table WHERE username='$username'");
$row = $query->fetch_assoc();

if ($row['count'] > 0) {
    die("Sorry that username is already taken. Please choose a different one.");
}

// If no matching username exists insert the new username into the database
$conn->query("INSERT INTO user_table (username) VALUES ('$username')");

$conn->close();
?>