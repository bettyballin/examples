<?php
session_start();

function isAuthorized() {
    return isset($_SESSION['user_id']) && ($_SESSION['user_id'] != 0);
}

// Test the function
$_SESSION['user_id'] = 1;
var_dump(isAuthorized()); // Should print: bool(true)

unset($_SESSION['user_id']);
var_dump(isAuthorized()); // Should print: bool(false)
?>