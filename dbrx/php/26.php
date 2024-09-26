<?php
session_start();
if (!isset($_SESSION['loggedIn'])) {
    die(json_encode(['error' => 'Access denied']));
}

// Example data
$data = ['message' => 'Hello, World!'];

// Perform any necessary actions and return JSON data.
echo json_encode($data);
exit;
?>