<?php
// Start the session
session_start();

// Generate and store a random token in the session
$_SESSION['token'] = bin2hex(random_bytes(32));

// Print the generated token
print($_SESSION['token']);
?>