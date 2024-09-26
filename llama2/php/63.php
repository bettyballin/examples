<?php

// Generate a secure salt
$salt = openssl_random_pseudo_bytes(32);

// Use the salt to hash a password
$password = "mysecretpassword";
$hashed_password = hash_pbkdf2("sha256", $password, $salt, 100000, 32, true);

// Store the salt and hashed password in a database
// ...

// Later, to verify a password
$stored_salt = $salt; // retrieve from database
$stored_hash = $hashed_password; // retrieve from database

$new_password = "mysecretpassword"; // input from user
$new_hash = hash_pbkdf2("sha256", $new_password, $stored_salt, 100000, 32, true);

if (hash_equals($stored_hash, $new_hash)) {
    echo "Password is valid!";
} else {
    echo "Password is not valid!";
}

?>