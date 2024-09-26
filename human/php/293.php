<?php
$res = openssl_pkey_new();

openssl_pkey_export($res, $privatekey); // Get private key

$publickey = openssl_pkey_get_details($res); // Get public key
$publickey = $publickey["key"];

echo "Private Key: " . $privatekey . "\n";
echo "Public Key: " . $publickey . "\n";
?>