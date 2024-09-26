<?php

// Start a session if one hasn't already been started.
if (session_status() !== PHP_SESSION_ACTIVE) {
    session_start();
}

// Generate and store a new CSRF token if one doesn't already exist.
if (!isset($_SESSION['csrf_token'])) {
    $_SESSION['csrf_token'] = time() . bin2hex(random_bytes(32));
}

// Check if the submitted CSRF token is valid and has not expired.
$submitted_token = $_POST['_token'] ?? '';
$stored_token = $_SESSION['csrf_token'] ?? '';

if ($submitted_token === $stored_token && time() - strtotime(substr($stored_token, 0, 10)) < 3600 /* one hour */) {
    // The CSRF token is still fresh so proceed with processing the form submission.
    echo "CSRF token is valid.";
} else {
    // The submitted CSRF token does not match or has expired. Reject this request as a potential cross-site forgery attack.
    echo "CSRF token is invalid or has expired.";
}

// Example form to test the CSRF protection
?>
<form action="" method="post">
    <input type="hidden" name="_token" value="<?= $_SESSION['csrf_token']; ?>">
    <input type="submit" value="Submit">
</form>