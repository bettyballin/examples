<?php
session_start();

// Generate a secure token upon login
$token = bin2hex(random_bytes(32));
$_SESSION['token'] = $token;

// Check the token on every subsequent request
if (isset($_POST['token']) && $_POST['token'] !== $_SESSION['token']) {
    // Token mismatch invalid session
    session_regenerate_id();
    header('Location: login.php');
    exit;
}
?>