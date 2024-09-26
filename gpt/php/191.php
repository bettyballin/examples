
<?php

// Replace '123.123.123.123' with the static IP of your server
$allowed_ip = '123.123.123.123';

// Get the IP address of the client making the request
$client_ip = $_SERVER['REMOTE_ADDR'];

// Check if client IP matches the allowed IP
if ($client_ip !== $allowed_ip) {
    // If not, terminate the script
    http_response_code(403); // Optional: Set a 403 Forbidden response
    die('Access denied');
}

// Rest of your processing code goes here

?>

