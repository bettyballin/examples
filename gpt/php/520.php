
<?php
session_start();

// Check if the user is authenticated
if (!isset($_SESSION['user_id'])) {
    die('You are not authorized to view this file.');
}

$user_id = $_
