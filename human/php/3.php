<?php

function hex_encoding($data) {
    return bin2hex($data);
}

$secret_key = 'secret-key-stored-only-on-server';
$timestamp = time();
$user_id = 'user-id';
$random_number = rand(100000, 999999);

$aes_key = hash('sha256', $secret_key, true);
$aes_data = $timestamp . ',' . $user_id . ',' . $random_number;
$aes_encrypted = openssl_encrypt($aes_data, 'aes-256-cbc', $aes_key, 0, substr($aes_key, 0, 16));

$hex_encoded = hex_encoding($aes_encrypted);
print($hex_encoded);

?>