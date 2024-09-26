<?php
$db = new PDO('mysql:host=localhost;dbname=mydatabase', 'username', 'password');

// Prepare the query
$stmt = $db->prepare("SELECT * FROM users WHERE name = :name");

// Set the value of $name
$name = 'John';

// Bind the parameter
$stmt->bindParam(':name', $name, PDO::PARAM_STR);

// Execute the query
$stmt->execute();

// Fetch the results
$rows = $stmt->fetchAll(PDO::FETCH_ASSOC);

// Print the results
print_r($rows);
?>