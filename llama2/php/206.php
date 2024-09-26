<?php
// Connect to the database
$connect = mysqli_connect("localhost", "user", "password", "database");

// Check connection
if (!$connect) {
    die("Connection failed: " . mysqli_connect_error());
}
?>