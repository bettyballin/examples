<?php
session_start();

function logging_in() {
    // Your login logic here
    return true; // For demonstration purposes
}

if(logging_in()) {
    $_SESSION['user'] = 'someuser';
    $_SESSION['agent'] = $_SERVER['HTTP_USER_AGENT'];
}

// The Check on subsequent load
if(isset($_SESSION['agent']) && $_SESSION['agent'] != $_SERVER['HTTP_USER_AGENT']) {
    die('Session MAY have been hijacked');
}

print_r($_SESSION);
?>