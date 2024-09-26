<?php

function generateSalt($length = 16) {
    $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_+-={}[]|;.<>?';
    $salt = '';
    for ($i = 0; $i < $length; $i++) {
        $salt .= $characters[mt_rand(0, strlen($characters) - 1)];
    }
    return $salt;
}

$plainTextPassword = 'test';

$salt = generateSalt();
$passwordWithSalt = $plainTextPassword . '{' . $salt . '}';
$hashedPasswordSha512 = hash('sha512', $passwordWithSalt);
$hashedPasswordMd5 = md5($passwordWithSalt);

echo "SHA-512 Hash: {$hashedPasswordSha512}\n";
echo "MD5 Hash: {$hashedPasswordMd5}\n";

?>