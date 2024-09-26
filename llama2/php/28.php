<?php

$encryptedData = 'your_base64_encoded_encrypted_data'; // replace with your encrypted data

$iv = pack('H*', '6745231976618342');
$key = pack('H*', '2F7EC65DB19A5B65');

$encrypted_data = base64_decode($encryptedData);
$decrypted_data = openssl_decrypt($encrypted_data, 'aes-128-cbc', $key, 0, $iv);

echo $decrypted_data;

?>