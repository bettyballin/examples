<?php
session_start();

function logging_in() {
    // Replace with your actual login logic
    return true;
}

if(logging_in()) {
    $_SESSION['user'] = 'someuser';
    $_SESSION['agent'] = $_SERVER['HTTP_USER_AGENT'];
}

// The Check on subsequent load
if(isset($_SESSION['agent']) && $_SESSION['agent'] != $_SERVER['HTTP_USER_AGENT']) {
    die('Session MAY have been hijacked');
}
?>