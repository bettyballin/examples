<?php

function deriveAesGcmKey($password, $salt) {
    return hash_pbkdf2("SHA256", $password, base64_decode($salt), 1000, 32, true);
}

$password = "your_password";
$salt = "your_salt";

$key = deriveAesGcmKey($password, $salt);
echo bin2hex($key);

?>