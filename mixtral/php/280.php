<?php

function encrypt($data, $key) {
    return openssl_encrypt(
        json_encode(['text'=>$data]),
        'AES-128-CBC',
        substr(hash('sha256', $key), 0, 32),
        0,
        base64_decode($key)
    );
}

function decrypt($encryptedData, $key){
   return json_decode(openssl_decrypt(
       $encryptedData,
       'AES-128-CBC',
       substr(hash('sha256', $key), 0, 32),
       0,
       base64_decode($key)
    ), true);
}

// Test the functions
$key = base64_encode(openssl_random_pseudo_bytes(16));
$data = "Hello, World!";
$encrypted = encrypt($data, $key);
echo "Encrypted: $encrypted\n";
$decrypted = decrypt($encrypted, $key);
echo "Decrypted: " . $decrypted->text . "\n";

?>