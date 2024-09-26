<?php
$salt = random_bytes(32);
echo "Generated salt: " . bin2hex($salt) . "\n";

$password = "your_password";
$hashed_password = hash_pbkdf2("sha256", $password, $salt, 100000);
echo "Hashed password: " . $hashed_password . "\n";

// Store the generated salt along with the hashed password
$stored_password = bin2hex($salt) . ":" . $hashed_password;
echo "Stored password: " . $stored_password . "\n";
?>