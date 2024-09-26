<?php
session_start();

// Generate a random CSRF token and store it in the session.
if (!isset($_SESSION['csrf_token'])) {
  $_SESSION['csrf_token'] = bin2hex(random_bytes(32));
}

$expectedCsrfToken = $_SESSION['csrf_token'];
$receivedCsrfToken = isset($_POST['csrfToken']) ? $_POST['csrfToken'] : '';

if ($expectedCsrfToken !== $receivedCsrfToken) {
  // Invalid CSRF token. Reject the request.
  http_response_code(403);
  echo 'Invalid or missing CSRF token.';
  exit; // Stop script execution
} else {
  // ... existing code to update scores ...
  // Example:
  if (isset($_POST['score'])) {
    $score = (int) $_POST['score'];
    // Update the score in the database or file.
    echo 'Score updated successfully.';
  } else {
    http_response_code(400);
    echo 'Missing score parameter.';
  }
}
?>