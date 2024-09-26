<?php
include 'config.php';
$mysqlUser = MYSQL_USER;
$mysqlPassword = MYSQL_PASSWORD;

// Assuming config.php has the following constants defined
// define('MYSQL_USER', 'your_username');
// define('MYSQL_PASSWORD', 'your_password');

// Use the variables
$conn = mysqli_connect("localhost", $mysqlUser, $mysqlPassword);

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
echo "Connected successfully";
mysqli_close($conn);
?>