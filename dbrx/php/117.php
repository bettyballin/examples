<?php

define('SECRET_KEY', 'your_secret_key_here');

function createToken($userId)
{
    $data = [
        'id' => $userId,
        'exp' => time() + 3600 // Token expires after one hour.
    ];

    return base64_encode(openssl_encrypt(json_encode($data), 'AES-256-CBC', SECRET_KEY, OPENSSL_RAW_DATA));
}

function verifyToken($token)
{
    try {
        $decryptedData = openssl_decrypt(base64_decode($token), 'AES-256-CBC', SECRET_KEY, OPENSSL_RAW_DATA);
        
        if (!$decryptedData) {
            throw new Exception('Invalid token');
        }

        return json_decode($decryptedData, true);

    } catch (Exception $e) {
        // Handle the exception.
        echo "Error: " . $e->getMessage();
        return false;
    }
}

// Example usage
$userId = 123;
$token = createToken($userId);
echo "Generated Token: " . $token . "\n";

$verifiedData = verifyToken($token);
if ($verifiedData) {
    echo "Verified Data: ";
    print_r($verifiedData);
} else {
    echo "Invalid token";
}