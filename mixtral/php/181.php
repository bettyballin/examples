<?php

require_once 'vendor/autoload.php';
use phpseclib3\Crypt\RSA;

$rsa = new RSA();
$rsa->setEncryptionMode(RSA::ENCRYPTION_PKCS1);

//...

// EME-PKCS1-v1_5 decoding
$em = 'your_encrypted_message'; // replace with your encrypted message
if (ord($em[0]) != 0 || ord($em[1]) > 2) {
    trigger_error('Decryption error', E_USER_ERROR);
    return false;
}

//...