<?php
$stored_hashed_password = 'your_hashed_password_here';
$salt = 'your_salt_here';
$loginPassword = 'your_login_password_here';

if (hash('sha256', $loginPassword . $salt) === $stored_hashed_password) {
    echo "Login successful";
} else {
    echo "Invalid password or username.";
}
?>