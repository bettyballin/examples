<?php

$data = 'Your sensitive information';
$secretKey = 'YOUR_SECRET_KEY_HERE'; // replace with your secret key
$userID = 'USER_ID_HERE'; // replace with user ID

// Generate a random initialization vector
$iv_length = openssl_cipher_iv_length('AES-256-CBC');
$iv = openssl_random_pseudo_bytes($iv_length);

// Encrypt the data
$encryptedData = openssl_encrypt(
    $data,
    'AES-256-CBC',
    $secretKey,
    0,
    $iv
);

// Send encrypted payload along with IV and user ID
function sendToAndroid($userID, $encryptedData, $iv) {
    // implement your sendToAndroid function here
    echo "Encrypted data: " . $encryptedData . "\n";
    echo "IV: " . $iv . "\n";
    echo "User ID: " . $userID . "\n";
}

sendToAndroid($userID, base64_encode($encryptedData), base64_encode($iv));

?>