<?php

class Encryption {
    public static function encryptAES($data, $AES_key)
    {
        $AES_key = base64_decode($AES_key);
        $encrypt = openssl_encrypt($data, 'aes-128-cbc', $AES_key, 0, substr($AES_key, 0, 16));
        if (!$encrypt) {
            throw new Exception('AES encryption error');
        }
        return base64_encode($encrypt);
    }
}

// Example usage
$data = 'Hello, World!';
$AES_key = base64_encode('01234567890123456789012345678901');

try {
    $encrypted = Encryption::encryptAES($data, $AES_key);
    echo "Encrypted: $encrypted\n";
} catch (Exception $e) {
    echo "Error: " . $e->getMessage() . "\n";
}