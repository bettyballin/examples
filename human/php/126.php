<?php

// the plaintext password
$password = (string) $_GET['password'];

// you'll want better RNG in reality
// make sure number is 4 chars long
$salt = str_pad((string) rand(1, 1000), 4, '0', STR_PAD_LEFT);

// you may want to use more measures here too
// concatenate hash with salt
$user_password = hash('sha512', $password . $salt) . $salt;

echo $user_password;