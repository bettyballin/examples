<?php

function deriveAesGcmKey($password, $salt) {
    return hash_pbkdf2("SHA256", $password, base64_decode($salt), 1000, 32);
}

$password = "your_password";
$salt = "your_base64_encoded_salt";

$key = deriveAesGcmKey($password, $salt);
echo $key;

?>