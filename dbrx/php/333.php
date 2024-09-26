<?php
if (password_verify($password, $userData['password'])) {
    // Correct password. Redirect to Log Entry page.
    header('Location: logEntry.php');
    exit;
} else {
    // Incorrect password. So redirect to Login.php
    header('Location: login.php');
    exit;
}
?>