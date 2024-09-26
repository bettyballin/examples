<?php

$input_password_cleartext = 'your_password'; // replace with user input
$password_hash_from_db = 'your_hash_from_db'; // replace with fetched hash from db

$input_password_hash = password_hash($input_password_cleartext, PASSWORD_DEFAULT);

if (password_verify($input_password_cleartext, $password_hash_from_db)) {
    echo 'Authenticated!';
} else {
    echo 'Invalid password!';
}

// Example fetch function (using PDO)
function fetch($db, $password_hash) {
    $stmt = $db->prepare('SELECT password_hash FROM users WHERE username = ?');
    $stmt->execute(['your_username']); // replace with actual username
    return $stmt->fetchColumn();
}

// Example database connection (using PDO)
$db = new PDO('mysql:host=your_host;dbname=your_db', 'your_username', 'your_password');