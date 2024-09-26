<?php

// Start a session if one hasn't already been started.
if (session_status() !== PHP_SESSION_ACTIVE) {
    session_start();
}

// Check if a CSRF token has already been generated for this user's session.
$csrf_token = $_SESSION['csrf_token'] ?? bin2hex(random_bytes(32));

// Store the CSRF token in the user's session so that it can be used across multiple forms on different pages.
$_SESSION['csrf_token'] = $csrf_token;

echo '<input type="hidden" name="csrf_token" value="' . $csrf_token . '">';

?>