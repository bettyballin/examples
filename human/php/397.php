<?php
// phpservice.php

// Assuming you want to handle both GET and POST requests
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $data = $_POST;
} elseif ($_SERVER['REQUEST_METHOD'] === 'GET') {
    $data = $_GET;
} else {
    http_response_code(405);
    echo 'Method not allowed';
    exit;
}

// Process the data
$response = array('message' => 'Hello, World!');

// Output the response as JSON
header('Content-Type: application/json');
echo json_encode($response);
?>