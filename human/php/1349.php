<?php
$pubKeyFile = 'public.der';
$keyBytes = file_get_contents($pubKeyFile);

$publicKey = openssl_pkey_get_public($keyBytes);
$publicKeyData = openssl_pkey_get_details($publicKey);

// Use $publicKeyData as needed
?>