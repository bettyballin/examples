<?php

// Connect to the database
$mysqli = new mysqli("localhost", "username", "password", "database");

if ($mysqli->connect_errno) {
    die("Connection failed: " . $mysqli->connect_error);
}

$sql = "SELECT * FROM table WHERE column1 LIKE ? AND column2 = ?";
$stmt = $mysqli->prepare($sql);

// Check for errors
if (!$stmt) {
    die("Prepare failed: (" . $mysqli->errno . ") " . $mysqli->error);
}

$target = $_GET['target'];
$category = $_GET['category'];

// Bind the parameters to the statement
$stmt->bind_param("ss", $target, $category);

// Execute the prepared statement
if (!$stmt->execute()) {
    echo "Execute failed: (" . $stmt->errno . ") " . $stmt->error;
}

$result = $stmt->get_result();
while ($row = $result->fetch_assoc()) {
    // You probably want to do something with the data here
    print_r($row);
}

$stmt->close();
$mysqli->close();

?>