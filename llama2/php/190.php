<?php
session_start();

// Check if the token is present in the request
if (isset($_REQUEST['token']) && isset($_SESSION['token']) && $_SESSION['token'] === $_REQUEST['token']) {
    // Valid user continue with the rest of the page
    display_page();
} else {
    // Token doesn't match or isn't present redirect to login
    header('Location: ./login.php');
    exit;
}

function display_page() {
    // Your page content here
    echo 'Hello, World!';
}
?>