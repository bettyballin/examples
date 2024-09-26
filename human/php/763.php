<?php
if (count($_POST)) {
    if (!isset($_POST['csrf_key']) or !isset($_POST['csrf_token'])) {
        die('No CSRF token found, invalid request.');
    }

    $key   = $_POST['csrf_key'];
    $token = $_POST['csrf_token'];

    if ($token !== $_SESSION[$key]) {                
        die('Invalid CSRF token, access denied.');
    }
}
?>