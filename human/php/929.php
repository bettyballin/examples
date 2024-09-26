<?php
// Define allowed subdomains and paths
$allowedSubdomains = array('subdomain1', 'subdomain2');
$allowedPaths = array('/path1', '/path2');

// Get current subdomain and path
$currentSubdomain = explode('.', $_SERVER['HTTP_HOST'])[0];
$currentPath = $_SERVER['REQUEST_URI'];

// Check if current subdomain and path are allowed
if (in_array($currentSubdomain, $allowedSubdomains) && in_array($currentPath, $allowedPaths)) {
    // Code to execute if subdomain and path are allowed
} else {
    // Code to execute if subdomain and path are not allowed
    header('HTTP/1.1 403 Forbidden');
    exit;
}
?>