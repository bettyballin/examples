This isn't PHP code. It's an Apache configuration directive for setting up Basic HTTP Authentication.

However, if you're looking to create a PHP script to handle Basic HTTP Authentication, here's an example:


<?php

$username = 'your_username';
$password = 'your_password';

if (!isset($_SERVER['PHP_AUTH_USER'])) {
    header('WWW-Authenticate: Basic realm="Password Required"');
    header('HTTP/1.0 401 Unauthorized');
    echo 'Text to send if user hits Cancel button';
    exit;
} else {
    if ($_SERVER['PHP_AUTH_USER'] != $username || $_SERVER['PHP_AUTH_PW'] != $password) {
        header('WWW-Authenticate: Basic realm="Password Required"');
        header('HTTP/1.0 401 Unauthorized');
        echo 'Invalid username or password';
        exit;
    } else {
        // Successfully authenticated
        echo "Hello, {$_SERVER['PHP_AUTH_USER']}";
    }
}