<?php
session_start();

// Replace with your actual validation logic
$username = 'your_username';
$password = 'your_password';

$valid = ($username == 'your_username' && $password == 'your_password');

if($valid) {
    $_SESSION['loggedin'] = true;
    echo "success";
} else {
    echo "error";
}
?>