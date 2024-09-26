<?php

// Create a new MySQL connection
$mysqli = new mysqli("localhost", "root", "", "");

// Check connection
if ($mysqli->connect_error) {
    die("Connection failed: " . $mysqli->connect_error);
}

// Create a new database
$query = "CREATE DATABASE mydatabase";
if ($mysqli->query($query) === TRUE) {
    echo "Database created successfully\n";
} else {
    echo "Error creating database: " . $mysqli->error . "\n";
}

// Create a new user with privileges for the database
$query = "CREATE USER 'myuser'@'%' IDENTIFIED BY 'mypassword';";
if ($mysqli->query($query) === TRUE) {
    echo "User created successfully\n";
} else {
    echo "Error creating user: " . $mysqli->error . "\n";
}

// Grant privileges for the database
$query = "GRANT SELECT, INSERT, UPDATE, DELETE ON mydatabase.* TO 'myuser'@'%';";
if ($mysqli->query($query) === TRUE) {
    echo "Privileges granted successfully\n";
} else {
    echo "Error granting privileges: " . $mysqli->error . "\n";
}

// Flush privileges
$query = "FLUSH PRIVILEGES;";
if ($mysqli->query($query) === TRUE) {
    echo "Privileges flushed successfully\n";
} else {
    echo "Error flushing privileges: " . $mysqli->error . "\n";
}

// Close connection
$mysqli->close();

?>