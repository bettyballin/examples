<?php

$plaintext_password = 'your-password';
$user_specific_salt = bin2hex(random_bytes(16));
$global_salt = 'your-secret-key';

// Combine both salts
$combined_salts = $user_specific_salt . $global_salt;

// Hash the password with combined salt
$hashed_password = hash('sha256', $combined_salts . $plaintext_password);

print($hashed_password);

?>