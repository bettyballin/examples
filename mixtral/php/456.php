<?php

function decryptAesGcmMessage($key, $iv, $message) {
    return openssl_decrypt(
        base64_decode($message),
        'aes-256-gcm',
        $key,
        OPENSSL_RAW_DATA,
        base64_decode($iv)
    );
}

// Example usage:
$key = 'your_secret_key_here';
$iv = 'your_initialization_vector_here';
$message = 'your_base64_encoded_encrypted_message_here';

$decryptedMessage = decryptAesGcmMessage($key, $iv, $message);
echo $decryptedMessage;

?>