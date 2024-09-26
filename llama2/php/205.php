<?php

$username = "johndoe";
$email = "johndoe@example.com";
$password = "JohnDoe123";

// Validate password
if (preg_match('/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).*$/', $password) && strpos($password, $username) === false && strpos($password, $email) === false) {
    echo "Password is valid";
} else {
    echo "Invalid password. Please try again.";
}

?>