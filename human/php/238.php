<?php
$iId = (int)"1 OR 1=1";
$sSql = "SELECT * FROM table WHERE id = $iId";

// Create connection
$conn = new mysqli("localhost", "username", "password", "database");

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Execute query
$result = $conn->query($sSql);

// Print result
if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        print_r($row);
    }
} else {
    echo "0 results";
}

$conn->close();
?>