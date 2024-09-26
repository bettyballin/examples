
<?php
session_start();
header('Content-Type: application/json');

// Enable HTTPS redirect if not already using HTTPS
if(empty($_SERVER['HTTPS']) || $_SERVER['HTTPS'] === "off"){
    $redirect = 'https://' . $_SERVER['HTTP_HOST'] . $_SERVER['REQUEST_URI'];
    header('HTTP/1.1 301 Moved Permanently');
    header('Location: ' . $redirect);
    exit();
}

// Input validation/sanitization function
function sanitize_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}

// Check if the request is from AJAX and a POST request
if($_SERVER['HTTP_X_REQUESTED_WITH'] == 'XMLHttpRequest' && $_SERVER['REQUEST_METHOD'] == 'POST') {
    // Database connection
    // $db = new PDO(...); // Uncomment and configure for production

    //
