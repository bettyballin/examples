<?php
// Verify a valid token was submitted
session_start();
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
  if (isset($_POST['token']) && isset($_SESSION['token'])) {
    if ($_POST['token'] !== $_SESSION['token']) {
      // invalid post
      http_response_code(403);
      echo 'Invalid token';
      exit;
    }
  } else {
    http_response_code(400);
    echo 'Token is missing';
    exit;
  }
} else {
  http_response_code(405);
  echo 'Method not allowed';
  exit;
}
?>