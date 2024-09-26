<?php
require_once 'vendor/autoload.php';
use Defuse\Crypto\Crypto;
use Defuse\Crypto\Key;

$key = Key::createNewRandomKey();
$ciphertext = Crypto::encrypt('text', $key);
$decrypted = Crypto::decrypt($ciphertext, $key);
echo $decrypted;
?>