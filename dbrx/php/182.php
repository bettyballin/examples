<?php
require_once 'Crypt/RSA.php';

$rsa = new Crypt_RSA();
$rsa->setEncryptionMode(CRYPT_RSA_ENCRYPTION_OAEP);

$key = 'your_base64_encoded_key_here'; // replace with your key

$aes_key = base64_encode($rsa->decrypt(base64_decode(strrev(base64_decode($key)))));
print($aes_key);
?>