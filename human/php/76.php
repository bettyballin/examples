<?php
$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "mydatabase";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Escape user input
$_GET = array_map(array($conn, 'real_escape_string'), $_GET);
$_POST = array_map(array($conn, 'real_escape_string'), $_POST);

// Build query
$query = sprintf("SELECT * FROM products WHERE product_id = '%d'", $_GET['id']);

// Execute query
$result = $conn->query($query);

// Print results
if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        print_r($row);
    }
} else {
    echo "0 results";
}

// Close connection
$conn->close();
?>