<?php

// Validate input
if (!preg_match('/^[A-Za-z0-9+\/=]+$/', $_POST['image'])) {
    die('Invalid base64 string');
}

// Limit file size
const MAX_FILE_SIZE = 1 * 1024 * 1024; // Set your desired limit in bytes
if (strlen($_POST['image']) > MAX_FILE_SIZE) {
    die('File too large');
}

$encodedString = $_POST['image'];

// Strip the crud from the front of the string
$encodedString = substr($encodedString, strpos($encodedString, ',') + 1);

// Cleanup File
$encodedString = str_replace(' ', '+', $encodedString);

// Decode string
$decoded = base64_decode($encodedString);

if ($decoded === false) {
    die('Invalid base64 data');
}

// Save file
file_put_contents(uniqid() . '.png', $decoded);

?>