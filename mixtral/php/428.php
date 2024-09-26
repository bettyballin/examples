<?php
// Start the session
if (!isset($_SESSION)) {
    session_start();
}

// Function to check if user has logged in
function userHasLoggedIn() {
    // Replace this with your actual login logic
    // For demonstration purposes, it's assumed that login is successful
    return true;
}

// Function to check if user has logged out
function userHasLoggedOut() {
    // Replace this with your actual logout logic
    // For demonstration purposes, it's assumed that logout is successful
    return false;
}

// Check if user has logged in
if (userHasLoggedIn()) {

  // Regenerate ID to prevent Session Fixation attacks
  session_regenerate_id(true);

  $_SESSION['loggedin'] = true;

  header('Location: /dashboard.php');
  exit;
}

// Check if user has logged out
if (userHasLoggedOut()) {

    // Destroy the old session
    unset($_SESSION["username"]);

    // Regenerate ID to prevent Session Fixation attacks
    session_regenerate_id(true);

  header('Location: /login.php');
  exit;
}
?>