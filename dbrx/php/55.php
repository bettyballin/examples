<?php

function encrypt($data, $key)
{
    // Generate a 16-byte IV.
    $iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));

    // Encrypt the data with OpenSSL.
    $encryptedData = openssl_encrypt(
        $data,
        'aes-256-cbc',
        base64_decode($key),
        OPENSSL_RAW_DATA,
        $iv
    );

    if ($encryptedData === false) {
        throw new Exception('Encryption failed: '.openssl_error_string());
    }

    // Return the encrypted data with IV prefixed.
    return bin2hex($iv).$encryptedData;
}

function decrypt($data, $key)
{
    // Extract and decode the hex-encoded IV from the beginning of the string.
    $ivLength = openssl_cipher_iv_length('aes-256-cbc') * 2;
    $decodedIv = pack('H*', substr($data, 0, $ivLength));

    if ($decodedIv === false) {
        throw new Exception('Decoding failed: '.openssl_error_string());
    }

    // Decrypt the data with OpenSSL.
    $decryptedData = openssl_decrypt(
        substr($data, $ivLength),
        'aes-256-cbc',
        base64_decode($key),
        OPENSSL_RAW_DATA,
        $decodedIv
    );

    if ($decryptedData === false) {
        throw new Exception('Decryption failed: '.openssl_error_string());
    }

    return $decryptedData;
}

// Usage:
$key = 'your-secret-key';
$data = 'hello world!';

$encryptedData = encrypt($data, $key);
echo "Encrypted data:\n";
var_dump(bin2hex($encryptedData));

$decryptedData = decrypt($encryptedData, $key);
echo "Decrypted data:\n";
var_dump($decryptedData);

?>