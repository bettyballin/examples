<?php

$userInputPassword = 'your-password-here';
$dbHash            = 'stored-hash-from-db';

if (password_verify($userInputPassword, $dbHash)) {
    echo "Password is correct.";
} else {
    echo "Invalid password.";
}