
<?php

$encryptedData = file_get_contents("./Cipher2PHP/encrypted.data");
$aesKey = file_get_contents("./Cipher2PHP/aes.key");
$initializationVector = file_get_contents("./Cipher2PHP/initialization.vector");

// You must ensure the input data length is a multiple of the AES block size (16 bytes for AES-128)
// If the Java code uses NoPadding, you must pad the data to the block size if necessary
// In this case, we assume the data is already the correct block size as it's been handled by Java

// Decrypt the data using AES-128-CBC with no padding
$decrypted = openssl_decrypt($encryptedData, 'AES-128-CBC', $aesKey, OPENSSL_RAW_DATA|OPENSSL_ZERO_PADDING, $initializationVector);

// Since we are using NoPadding, there might be extra null bytes at the end of the
