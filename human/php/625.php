<?php
// request_handler.php

$requestUri = $_SERVER['REQUEST_URI'];
$scriptName = $_SERVER['SCRIPT_NAME'];

$path = str_replace($scriptName, '', $requestUri);

if (file_exists($path) === false) {
    // Handle the request
    echo "Request received";
    // Your code here
} else {
    header('HTTP/1.0 404 Not Found');
    echo 'File not found';
}


bash
# .htaccess
RewriteEngine on
RewriteCond %{REQUEST_FILENAME} !-f
RewriteRule ^ /request_handler.php