<?php
session_start();

function logging_in() {
    // Replace this with your actual login logic
    return true;
}

if(logging_in()) {
    $_SESSION['user'] = 'someuser';
    $_SESSION['count'] = 5;
}

// The Check on subsequent load
if(isset($_SESSION['count']) && ($_SESSION['count'] -= 1) == 0) {
    session_regenerate_id();
    $_SESSION['count'] = 5;
}

print_r($_SESSION);
?>