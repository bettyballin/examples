<?php
// Configuration
$host = 'your_host';
$username = 'your_username';
$password = 'your_password';
$database = 'your_database';

// Create connection
$conn = new mysqli($host, $username, $password, $database);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Create table
$sql = "CREATE TABLE sessions (
session_id VARCHAR(255) PRIMARY KEY,
user_id INT,
ip_address VARCHAR(255),
last_logged_in INT
)";

if ($conn->query($sql) === TRUE) {
    echo "Table sessions created successfully";
} else {
    echo "Error creating table: " . $conn->error;
}

$conn->close();
?>