<?php
function decrypt($decrypt, $mc_key, $iv)
{
    $decoded = base64_decode($decrypt);
    $decrypted = trim(openssl_decrypt($decoded, 'aes-256-ecb', $mc_key, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING, $iv));
    return $decrypted;
}

// example usage
$encrypted = "your_base64_encoded_encrypted_string";
$key = "your_secret_key";
$iv = "your_iv";

echo decrypt($encrypted, $key, $iv);
?>