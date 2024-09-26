<?php
session_start();

function is_logged_in() {
    if (session_id() === $_SESSION['GBuser']) {
        return true;
    }

    return false;
}

// Test the function
$_SESSION['GBuser'] = session_id();
echo var_export(is_logged_in(), true) . "\n";

unset($_SESSION['GBuser']);
echo var_export(is_logged_in(), true) . "\n";
?>