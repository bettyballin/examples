<?php
session_start();

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $token = $_POST['csrf_token'];

    // Check if tokens match (prevents CSRF attacks)
    if (!hash_equals($_SESSION['token'], $token)) {
        die('Invalid token');
    }

    // Process the form data...
}
?>