
<?php
session_start(); // Start the session.

if (isset($_SESSION['is_verified']) && $_SESSION['is_verified']) {
    // Include the secret HTML content.
    include('secret-content.html');
} else {
    // Display an error message.
    echo "Sorry, access not granted!";
}
?>

