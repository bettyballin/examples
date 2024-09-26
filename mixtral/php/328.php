<?php

const CRYPTKEY = 'your_encryption_key_here';
const CRYPTALGO = 'your_encryption_algorithm_here'; // e.g. 'AES-256-CBC'

public function decrypt($text){
    if (empty(base64_decode($text))) {
        throw new Exception('Invalid input text.');
    }

    $encryption_key = base64_decode(CRYPTKEY);

    list($encrypted_data, $iv) = explode('::', base64_decode($text), 2);

    return openssl_decrypt($encrypted_data, CRYPTALGO, $encryption_key, 0, $iv);
}

// Example usage:
try {
    $encrypted_text = 'your_encrypted_text_here';
    $decrypted_text = decrypt($encrypted_text);
    echo $decrypted_text;
} catch (Exception $e) {
    echo $e->getMessage();
}