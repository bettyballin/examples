<?php
session_start();

function logging_in() {
    // Replace this with your actual login logic
    return true;
}

if(logging_in()) {
    $_SESSION['user'] = 'someuser';
    $_SESSION['ip'] = $_SERVER['REMOTE_ADDR'];
}

// The Check on subsequent load
if(isset($_SESSION['ip']) && $_SESSION['ip'] != $_SERVER['REMOTE_ADDR']) {
    die('Session MAY have been hijacked');
}
?>