<?php

// Configuration
$dbHost = 'localhost';
$dbUsername = 'root';
$dbPassword = '';
$dbName = 'users';

// Connect to database
$conn = new mysqli($dbHost, $dbUsername, $dbPassword, $dbName);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Create users table
$usersTable = "CREATE TABLE IF NOT EXISTS users (
    userid INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    isactive BOOLEAN NOT NULL DEFAULT 0
)";

// Create invites table
$invitesTable = "CREATE TABLE IF NOT EXISTS invites (
    inviteid INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    userid INT(6) UNSIGNED NOT NULL,
    hash VARCHAR(255) NOT NULL,
    reinvitesent BOOLEAN NOT NULL DEFAULT 0,
    senton TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userid) REFERENCES users(userid)
)";

// Execute queries
$conn->query($usersTable);
$conn->query($invitesTable);

// Function to hash password
function hashPassword($password) {
    return password_hash($password, PASSWORD_DEFAULT);
}

// Function to create a new user
function createUser($name, $email, $password) {
    global $conn;
    $hashedPassword = hashPassword($password);
    $query = "INSERT INTO users (name, email, password) VALUES ('$name', '$email', '$hashedPassword')";
    if ($conn->query($query) === TRUE) {
        return $conn->insert_id;
    } else {
        return false;
    }
}

// Function to create a new invite
function createInvite($userid) {
    global $conn;
    $hash =uniqid();
    $query = "INSERT INTO invites (userid, hash) VALUES ('$userid', '$hash')";
    if ($conn->query($query) === TRUE) {
        return $hash;
    } else {
        return false;
    }
}

// Test the functions
$name = 'John Doe';
$email = 'john@example.com';
$password = 'password';
$userid = createUser($name, $email, $password);
if ($userid) {
    $inviteHash = createInvite($userid);
    if ($inviteHash) {
        echo "User created with ID: $userid and invite hash: $inviteHash";
    } else {
        echo "Failed to create invite";
    }
} else {
    echo "Failed to create user";
}

$conn->close();

?>