<?php
$username = mysqli_real_escape_string($conn, isset($_POST['username']) ? $_POST['username'] : '');

// Assuming you have a MySQLi connection established
$conn = mysqli_connect("localhost", "username", "password", "database");

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
?>