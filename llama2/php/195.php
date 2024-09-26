<?php
$mysqli = new mysqli('localhost', 'username', 'password', 'database');

// Define the query and parameters
$query = "SELECT * FROM users WHERE name = ? AND email = ?";
$params = array("John Doe", "johndoe@example.com");

// Prepare the statement
$stmt = $mysqli->prepare($query);

// Bind the parameters
$stmt->bind_param("ss", $params[0], $params[1]);

// Execute the query
$stmt->execute();

// Fetch the results
$result = $stmt->get_result();

// Print the results
while ($row = $result->fetch_assoc()) {
    print_r($row);
}

// Close the statement
$stmt->close();

// Close the connection
$mysqli->close();
?>