
<?php
// Your large file
$file = 'mylargefile.data';

// Generate a random key
$key = openssl_random_pseudo_bytes(32);

// You can generate a random IV for each encryption
$ivLength = openssl_cipher_iv_length('aes-256-cbc');
$iv = openssl_random_pseudo_bytes($ivLength);

// Open the source file and the destination file
$fileStream = fopen($file, 'rb');
$encFileStream = fopen($file . ".enc", 'wb');

// Write the IV at the beginning of the destination file
fwrite($encFileStream, $iv);

// Encrypt the content in chunks
$bufferSize
