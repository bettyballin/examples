<?php
$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "myDB";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$stmt = $conn->prepare("SELECT `salt` FROM admins WHERE `username` = ? LIMIT 1");
$stmt->bind_param("s", $username);

$username = "your_username";
$stmt->execute();
$stmt->bind_result($salt);
$stmt->fetch();

echo $salt;

$stmt->close();
$conn->close();
?>