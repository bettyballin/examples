<?php
// Let the browser know to expect a binary file
header('Content-Type: application/octet-stream');
session_start();
if (!isset($_SESSION['user_session'])) {
    // Block access for users not logged in
    header("HTTP/1.0 403 Forbidden");
    die();
}
$userID = $_SESSION['user_session'];

$path = $_GET['path'];
// Check the logged in user is requesting one of their own files
// (Probably want something more elaborate; this is just an example)
if (strpos($path, '/uploads/' . $userID . '/') === false) {
    header("HTTP/1.0 403 Forbidden");
    die();
}

// Security check the request is valid (again, just one example)
if (strpos($path, '..') !== false) {
    header("HTTP/1.0 403 Forbidden");
    die();
}

// Return the image
readfile('/path/to/uploads' . $path);
?>