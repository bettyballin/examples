<?php

use phpseclib\Crypt\AES;

$nonce = base64_decode('Up/x2bc4+QDPk2beZKd');
$key   = base64_decode('yxSWeywwKBWGINr4GyJpfE29xWTnpknff+ExruiKs2o=');
$data  = base64_decode('ooGUzo0YiwKPs9+2wXySYEpdBNfSpyLUHm1M');

$aes   = new AES(AES::MODE_CCM);

// Set the key and nonce (IV)
$aes->setKey($key);
$aes->setNonce($nonce);

// Decrypt data
$decryptedData = $aes->decrypt($data);

echo "Decrypted Data: " . bin2hex($decryptedData) . "\n";

?>