<?php

// Generate a new AES-256-CBC encryption object.
$imageData = 'your_image_data_here'; // replace with your image data
$secretKey = 'your_secret_key_here'; // replace with your secret key
$aesCipher = openssl_encrypt($imageData, 'AES-256-CBC', $secretKey);

// Encrypt your secret key using RSA with public/private pairs for secure transmission over an insecure channel.
require_once 'vendor/autoload.php';
use phpseclib3\Crypt\RSA;

$rsa = new RSA();
$rsa->setEncryptionMode(RSA::ENCRYPTION_PKCS1);
$rsa->setPrivateKeyFormat(RSA::PRIVATE_FORMAT_PKCS1);
$rsa->setPublicKeyFormat(RSA::PUBLIC_FORMAT_PKCS1);

$publicKey = 'your_public_key_here'; // replace with your public key
$key = "-----BEGIN PUBLIC KEY-----" . $publicKey . "-----END PUBLIC KEY-----";
$rsa->loadKey($key);
$aesSecretKeyEncrypted = base64_encode($rsa->encrypt($secretKey));

print($aesCipher . "\n");
print($aesSecretKeyEncrypted . "\n");

?>