<?php

// Allowed pages
$allowed_pages = ['index.php', 'private.php'];

$current_page = basename($_SERVER['PHP_SELF']);

if (!in_array($current_page, $allowed_pages)) {
    header("Location: index.php");
    die("Redirecting to index.php");  // login page
}

require_once('common.php');

// Check if the user is logged in
if (empty($_SESSION['user'])) {
    header("Location: index.php");
    die("Redirecting to index.php");  // login page
}

?>