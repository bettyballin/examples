<?php
require_once 'vendor/autoload.php';
use Defuse\Crypto\Crypto;
use Defuse\Crypto\Key;

$encrypted = 'your_base64_encoded_string';
$theKey = 'your_secret_key';

$key = Key::createNewKey($theKey);
$decrypted = Crypto::decrypt($encrypted, $key);

print($decrypted);
?>