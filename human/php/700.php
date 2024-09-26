<?php
require('PasswordHash.php');

// Assuming $PostPassword is the password entered in a form
$PostPassword = $_POST['password'];

$CreateHash = new PasswordHash(8, FALSE);
$HashPassword = $CreateHash->HashPassword($PostPassword);

// Store $HashPassword in the database

// Assuming $DbPass is the hashed password retrieved from the database
$DbPass = 'hashed_password_from_db';

$CreateHash = new PasswordHash(8, FALSE);
$CheckPass = $CreateHash->CheckPassword($PostPassword, $DbPass);

if ($CheckPass) {
    echo 'Password matches';
} else {
    echo 'Password does not match';
}

if (defined("CRYPT_BLOWFISH") && CRYPT_BLOWFISH) {
    // Do all your password stuff
} else {
    echo 'Blowfish algorithm not supported';
}
?>