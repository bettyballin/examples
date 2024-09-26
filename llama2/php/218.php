<?php

function getPdoConnection($dsn, $username, $password) {
    try {
        $pdo = parse_url($dsn);
        $username = $username;
        $password = $password;

        // Create a new PDO object with the extracted credentials
        return new PDO($dsn, $username, $password);
    } catch (PDOException $e) {
        // Log a generic error message
        error_log('Error connecting to database: ' . $e->getMessage());

        // Return a null object to indicate the connection failed
        return null;
    }
}

// Example usage
$dsn = 'mysql:host=localhost;dbname=mydatabase';
$username = 'myusername';
$password = 'mypassword';

$pdo = getPdoConnection($dsn, $username, $password);

if ($pdo !== null) {
    echo "Connected to database successfully!";
} else {
    echo "Failed to connect to database.";
}