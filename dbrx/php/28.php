<?php

function base64url_encode($data)
{
    return rtrim(strtr(base64_encode($data), '+/', '-_'), '=');
}

function base64url_decode($data)
{
    return base64_decode(str_pad(strtr($data, '-_', '+/'), strlen($data) % 4, '=', STR_PAD_RIGHT));
}

// Encryption
$iv = random_bytes(openssl_cipher_iv_length('aes-256-cbc'));
$key = 'your_secret_key';
$data = 'your_data_to_encrypt';

$encryptedData = openssl_encrypt(
    $data,
    'aes-256-cbc',
    base64_decode($key),
    OPENSSL_RAW_DATA,
    $iv
);

$output = bin2hex($iv) . base64url_encode($encryptedData);
echo "Encrypted: {$output}\n";

// Decryption
$decryptedIv = hex2bin(substr($output, 0, 32));
$decryptedData = openssl_decrypt(
    base64url_decode(substr($output, 32)),
    'aes-256-cbc',
    base64_decode($key),
    OPENSSL_RAW_DATA,
    $decryptedIv
);

echo "Decrypted: {$decryptedData}\n";

?>