<?php

// Hashing a password
$password = 'user_password';
$hashed_password = password_hash($password, PASSWORD_DEFAULT);

echo "Hashed Password: $hashed_password\n";

// Verifying a password
$input_password = 'user_input_password';
if (password_verify($input_password, $hashed_password)) {
    echo 'Password is valid!';
} else {
    echo 'Invalid password.';
}

?>