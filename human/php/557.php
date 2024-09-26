<?php

// Configuration
$host = 'localhost';
$username = 'username';
$password = 'password';
$db1 = 'onedatabase';
$db2 = 'someotherdatabase';

// Connect to databases
$conn1 = new mysqli($host, $username, $password, $db1);
$conn2 = new mysqli($host, $username, $password, $db2);

// Check connection
if ($conn1->connect_error || $conn2->connect_error) {
    die("Connection failed: " . $conn1->connect_error . " " . $conn2->connect_error);
}

// Query
$query = "SELECT t1.field, t2.field 
          FROM $db1.table AS t1 
          INNER JOIN $db2.table AS t2 
          ON t1.common_field = t2.common_field";

// Execute query
$result = $conn1->query($query);

// Fetch and print results
if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        echo $row["field"] . " " . $row["field"] . "<br>";
    }
} else {
    echo "0 results";
}

// Close connections
$conn1->close();
$conn2->close();

?>