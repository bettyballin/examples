<?php

if (!isset($_SERVER['HTTP_USER_AGENT']) || stripos($_SERVER['HTTP_USER_AGENT'], 'curl') === false) {
    die('Access denied: not a CURL request');
}

$allowed_ips = ['123.45.67.89']; // Add IP addresses allowed to run the script

if (!in_array($_SERVER['REMOTE_ADDR'], $allowed_ips)) {
    die('Access denied: invalid IP address');
}

?>