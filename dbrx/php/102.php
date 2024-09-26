<?php
session_start();

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
  // Check for CSRF token validity.
  if (!isset($_POST['_csrf_token']) || !hash_equals($_SESSION['_csrf_token'], $_POST['_csrf_token'])) {
    echo "Cross-site request forgery attempt!";
    exit;
  }
}
?>