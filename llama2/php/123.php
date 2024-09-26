<?php

// Generate a nonce on the server-side
$nonce = bin2hex(random_bytes(16));

// Validate input data
if (empty($_POST['uid']) || empty($_POST['nonce'])) {
    echo 'Bad request';
    exit;
}

// Sanitize input data
$uid = filter_var($_POST['uid'], FILTER_SANITIZE_STRING);
$nonce = filter_var($_POST['nonce'], FILTER_SANITIZE_STRING);

// Rest of your code...

?>