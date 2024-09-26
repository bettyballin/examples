<?php
// Define a file path for the whitelist
$whitelist = 'path/to/whitelist.txt';

// Read the IP addresses from the whitelist file
$ips = file($whitelist, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

// Check if the client's IP address is in the whitelist
if (in_array($_SERVER['REMOTE_ADDR'], $ips)) {
    // Allow access to the script
} else {
    // Deny access and display an error message
    header('HTTP/1.0 403 Forbidden');
    echo 'Access denied!';
    exit;
}

// The rest of your PHP script goes here
?>