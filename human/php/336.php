<?php
$password = "your_password"; // replace with your password
$salt = uniqid();
$password_hash = hash_hmac('sha512', $password, $salt);
print($password_hash);
?>