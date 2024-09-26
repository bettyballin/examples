php
<?php
// Create connection
$conn = new mysqli("localhost", "username", "password", "database");

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// SQL query
$sql = "SELECT * FROM your_table";

// Execute query
$result = $conn->query($sql);

// Check if query executed successfully
if ($result->num_rows > 0) {
    // Fetch data
    $row = $result->fetch_array();
    // Do something with the data
    print_r($row);
} else {
    // Abort
    echo "No results";
}

// Close connection
$conn->close();
?>