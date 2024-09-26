<?php

// Configuration
$host = 'your_host';
$dbname = 'your_database';
$username = 'your_username';
$password = 'your_password';

// Create PDO instance
$pdo = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);

// Set table name
$table = 'your_table';

// Prepare the statement
$stmt = $pdo->prepare("SELECT * FROM `{$table}` WHERE id=?");

// Execute with bound parameters
$result = $stmt->execute([$_GET['id']]);

// Fetch and display results
$rows = $stmt->fetchAll(PDO::FETCH_ASSOC);
print_r($rows);

?>