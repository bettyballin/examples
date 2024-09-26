<?php
$lifetime = 3600; // 1 hour
$path = "/";
$domain = "example.com";
$secure = true;
$httponly = true;

session_set_cookie_params($lifetime, $path, $domain, $secure, $httponly);

// Test the function
session_start();
$_SESSION['test'] = 'Hello, World!';
print_r($_SESSION);
?>