<?php

function DecryptAes($key, $iv, $data) {
    return openssl_decrypt(
        base64_decode($data),
        'aes-128-cbc',
        substr(hash('sha256', $key, true), 0, 32),
        OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING,
        base64_decode($iv)
    );
}

// example usage
$key = 'your_key_here';
$iv = 'your_iv_here';
$data = 'your_base64_encoded_data_here';

$decrypted = DecryptAes($key, $iv, $data);
echo $decrypted;

?>