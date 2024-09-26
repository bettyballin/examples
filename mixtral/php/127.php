<?php

// Generate a new random Key
$key = openssl_random_pseudo_bytes(32);

// Create Initialization Vector
$ivSize = 16;
$strong = false;
$iv = openssl_random_pseudo_bytes($ivSize, $strong);

// Encrypt
$file = 'your_file.txt'; // replace with your file name
$fileStream = fopen($file, 'r');
$encFileStream = fopen("{$file}.aes", 'w');
stream_filter_append($encFileStream, 'openssl.encryption', STREAM_FILTER_WRITE, [
    'method' => 'AES-256-CBC',
    'options' => OPENSSL_RAW_DATA,
    'key' => $key,
    'iv' => $iv
]);
stream_copy_to_stream($fileStream, $encFileStream);
fclose($encFileStream);
fclose($fileStream);

// Save the IV and encrypted key
$publicKey = 'your_public_key'; // replace with your public key
$encKey = null;
openssl_public_encrypt($key, $encKey, $publicKey);

file_put_contents("{$file}.aes.iv", $iv);
file_put_contents("{$file}.aes.key", $encKey);

?>