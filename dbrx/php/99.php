<?php

// Establish connection first
$connect = mysqli_connect("localhost", "username", "password", "database");

if (!$connect) {
    die("Connection failed: " . mysqli_connect_error());
}

$username = $_POST['username'];
$password = password_hash($_POST['password'], PASSWORD_DEFAULT); // Always hash passwords before storing

// Escape user input
$escaped_username = mysqli_real_escape_string($connect, $username);

// Prepare and bind a statement to insert data into the database securely
$stmt = mysqli_prepare($connect, "INSERT INTO users (username, password) VALUES (?, ?)");
mysqli_stmt_bind_param($stmt, "ss", $escaped_username, $password);
mysqli_stmt_execute($stmt);

mysqli_stmt_close($stmt);
mysqli_close($connect);

?>