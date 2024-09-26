<?php

// Set the maximum number of allowed login attempts
$maxAttempts = 5;

// Set the time-based threshold for lockout (in minutes)
$lockoutDuration = 5;

// Check if the user has been locked out
if (isset($_COOKIE['locked_out']) && $_COOKIE['locked_out'] === 'true') {
    // If the user is locked out block them from logging in
    header('HTTP/1.1 403 Forbidden');
    echo 'You have been locked out due to excessive login attempts. Try again in ' . $lockoutDuration . ' minutes.';
    exit;
}

// Initialize the number of attempts
$attempts = 0;

// Check if the number of attempts has been stored in the session
if (isset($_SESSION['attempts'])) {
    $attempts = $_SESSION['attempts'];
}

// If the number of attempts exceeds the maximum allowed, lock out the user
if ($attempts >= $maxAttempts) {
    setcookie('locked_out', 'true', time() + ($lockoutDuration * 60));
    header('HTTP/1.1 403 Forbidden');
    echo 'You have exceeded the maximum number of allowed login attempts. You have been locked out for ' . $lockoutDuration . ' minutes.';
    exit;
}

// Increment the number of attempts
$attempts++;
$_SESSION['attempts'] = $attempts;

?>