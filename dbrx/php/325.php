<?php

function encrypt($data, $key) {
    $encrypted = openssl_encrypt($data, 'AES-256-CBC', $key, 0, substr($key, 0, 16));
    return base64_encode($encrypted);
}

function decrypt($data, $key) {
    $decrypted = openssl_decrypt(base64_decode($data), 'AES-256-CBC', $key, 0, substr($key, 0, 16));
    return $decrypted;
}

// Example usage:
$key = 'your_secret_key_here_your_secret_key_here';
$data = 'Hello, World!';
$encrypted = encrypt($data, $key);
$decrypted = decrypt($encrypted, $key);

print("Encrypted: $encrypted\n");
print("Decrypted: $decrypted\n");

?>