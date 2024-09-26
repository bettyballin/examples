<?php
require_once 'vendor/autoload.php';
use phpseclib3\Crypt\RSA;

$rsa = new RSA();
$rsa->setEncryptionMode(RSA::ENCRYPTION_PKCS1);
?>