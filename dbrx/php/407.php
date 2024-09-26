<?php

// Start session
session_start();

// Check token validity (e.g compare with session-stored value)
if (!isset($_GET['token']) || !isset($_SESSION['token']) || $_GET['token'] !== $_SESSION['token']) {
    // Invalid or missing token: deny access and return an error message.
    header('Content-Type: application/json');
    echo json_encode(['error' => 'Invalid token']);
    exit;
}

// Fetch data from the database...
$data = [
    'id' => 1,
    'name' => 'John Doe',
    'email' => 'johndoe@example.com'
];

header('Content-Type: application/json');
echo json_encode($data);

?>