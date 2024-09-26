<?php
$conn = new mysqli("localhost", "username", "password", "database");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$username = $_POST["username"];
$password = $_POST["password"];

$username = $conn->real_escape_string($username);

$query = "SELECT password FROM users WHERE username = '$username'";
$result = $conn->query($query);

if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();
    $db_password = $row["password"];

    if($password == md5($db_password)) {
        // Correct password
    } else {
        echo 'Incorrect password.';
    }
} else {
    echo 'User not found.';
}

unset($username, $password, $db_password); // For security, remove variables from memory

$conn->close();
?>