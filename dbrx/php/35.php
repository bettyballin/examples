<?php

// Allowed IPs and User Agents. You can add more as needed.
$allowedIPs = ['127.0.0.1', '192.168.1.100'];
$userAgents = [
    'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3'
];

// Check if the IP is allowed
if (!in_array($_SERVER['REMOTE_ADDR'], $allowedIPs)) {
    die('Access denied');
}

// Check if User Agent matches any of our predefined ones.
$userAgent = $_SERVER['HTTP_USER_AGENT'];
$foundUserAgent = false;
foreach ($userAgents as $agent) {
    if (strpos($userAgent, $agent) !== false) {
        $foundUserAgent = true;
        break; // Stop the loop once we find a match
    }
}

if (!$foundUserAgent) {
    die('Access denied');
}

// Your script here
echo "Access granted!";

?>