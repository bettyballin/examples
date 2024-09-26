<?php

// Assuming $key, $encryptedDataFromDB, and $iv are defined elsewhere in your code

// Decryption using mcrypt
$decrypted = rtrim(mcrypt_decrypt(MCRYPT_RIJNDAEL_128, $key, $encryptedDataFromDB, MCRYPT_MODE_CBC, $iv), "\0");

// Re-Encryption using OpenSSL
$cipher = 'aes-256-cbc';
if (in_array($cipher, openssl_get_cipher_methods())) {
    // Encrypt
    $encryptedDataForDB = openssl_encrypt($decrypted, $cipher, $key, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING, $iv);
}

?>