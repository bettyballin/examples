<?php

function password_encrypt($password) {
    $options = [
        'cost' => 12
    ];

    return password_hash($password, PASSWORD_BCRYPT, $options);
}

$password = 'your-password';
$hashedPassword = password_encrypt($password);

// To verify a hash
if (password_verify($password, $hashedPassword)) {
   echo "Success! The password is correct";
} else {
   echo "The password is incorrect";
}

?>