<?php

$Username = $_POST['username'];
$Password = $_POST['password'];

// Connect to database
$conn = mysqli_connect("localhost", "username", "password", "database");

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// Fetch hashed password from database for given username.
$query  = mysqli_query($conn, "SELECT * FROM users WHERE username = '$Username'");
$row    = mysqli_fetch_array($query);

if (password_verify($Password, $row['password'])) {
    // Password is correct. Proceed with login process...
    echo "Login successful.";
} else {
    echo "Invalid credentials.";
}

mysqli_close($conn);

?>