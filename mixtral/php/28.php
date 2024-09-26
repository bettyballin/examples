<?php
session_start();

// Validate your CSRF Token here if you have one

$userId = $_SESSION['userid'];
$username = $_SESSION['username'];

// Continue with processing the request

header('Content-Type: application/json');
echo json_encode(['success' => true]);
exit;
?>