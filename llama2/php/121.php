<?php
// Start the session
session_start();

// On "Thank You" page check if user has download access
if (isset($_SESSION['download_access']) && $_SESSION['download_access']) {
  // Display download link
  echo '<a href="download.php">Download</a>';
} else {
  // Don't show the link
  echo 'You do not have access to download.';
}
?>