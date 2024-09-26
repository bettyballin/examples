
<?php
session_start();

$hardcodedUsername = 'admin';
$hardcodedPasswordHash = password_hash('yourSecurePassword', PASSWORD_DEFAULT); // Replace 'yourSecurePassword' with a strong password.

if (isset($_POST['username']) && isset($_POST['password'])) {
    if ($_POST['username'] === $hardcodedUsername && password_verify($_POST['password'], $hardcodedPasswordHash)) {
        $_SESSION['loggedin'] = true;
        header('Location: upload.php'); // Redirect to the upload page.
        exit;
    } else {
        echo "Invalid username
