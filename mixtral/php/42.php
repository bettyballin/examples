<?php

$allowed_extensions = ['mp3', 'wav'];

// Get file extension
$haystack = $_FILES['file']['name'];
$extension = strtolower(pathinfo($haystack, PATHINFO_EXTENSION));

if (!in_array($extension, $allowed_extensions) || preg_match('/\.\./i', $haystack)) {
    die("Unauthorized");
}

?>