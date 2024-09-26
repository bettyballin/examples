<?php

require 'vendor/autoload.php';

use ParagonIE\ConstantTime\Base64UrlSafe;

$passwordToHash  = "your_password_here";
$salt = Base64UrlSafe::encode(random_bytes(Sodium\CRYPTO_PWHASH_SALTBYTES));

$storeInDatabase  = Sodium\crypto_pwhash_str(
    $passwordToHash,
    $salt,
    Sodium\CRYPTO_PWHASH_OPSLIMIT_INTERACTIVE,
    Sodium\CRYPTO_PWHASH_MEMLIMIT_INTERACTIVE
);

echo "Store this in your database: $storeInDatabase\n";

?>