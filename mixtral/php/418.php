<?php

$servername = getenv('DB_HOST');
$username   = getenv('DB_USERNAME');
$password   = getenv('DB_PASSWORD');

// Create connection
$conn = new mysqli($servername, $username, $password);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// No need to use mysqli_real_connect here, as the connection is already established
// But if you want to use it, here's the correct way:

// $conn = mysqli_init();
// mysqli_real_connect($conn, getenv('DB_HOST'), getenv('DB_USERNAME'), getenv('DB_PASSWORD')) or trigger_error("Failed to connect: " . mysqli_connect_errno());

?>