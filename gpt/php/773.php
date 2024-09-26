
function decryptDataWithOpenSSL($encryptedData, $key, $iv) {
    $algorithm = 'aes-256-cbc';

    // Decrypt the data using OpenSSL
    $decrypted = openssl_decrypt($encryptedData, $algorithm, $key, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING, $iv);
    
    // If decryption failed, return false
    if ($decrypted === false) {
        return false;
    }

    // Remove the zero padding from the decrypted data
    $decrypted = rtrim($decrypted, "\0");

    return $decrypted;
}

// Your existing mcrypt encrypted data
$strMcryptData = mcrypt_encrypt
