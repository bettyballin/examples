<?php

function encryptAES($text, $key)
{
    $key = base64_decode($key);
    $encrypt = openssl_encrypt($text, 'aes-128-ecb', $key, OPENSSL_RAW_DATA);
    return base64_encode($encrypt);
}

// Example usage:
$text = "Hello, World!";
$key = base64_encode("0123456789012345"); // 128-bit key
$encryptedText = encryptAES($text, $key);
echo "Encrypted Text: $encryptedText\n";

?>