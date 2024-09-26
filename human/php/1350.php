<?php
use phpseclib3\Crypt\RSA;
use phpseclib3\Crypt\Hash;
use phpseclib3\File\X509;

$publicKey = new RSA();
$publicKey->loadPublicKey('your_public_key_here');

$payload = "tejashwi kalp taru";
$publicKey->setEncryptionMode(RSA::ENCRYPTION_OAEP);
$publicKey->setHash('sha1');
$publicKey->setMGFHash('sha1');
$encryptedBytes = $publicKey->encrypt($payload);
$encryptedData = base64_encode($encryptedBytes);

// send encryptedData to server for decryption
?>