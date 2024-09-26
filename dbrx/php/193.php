<?php

function decrypt($data, $key)
{
    // Remove the base64 encoding from our key
    $encryption_key = base64_decode($key);

    // To decrypt split the encrypted data from our IV - our unique separator was "::"
    list($encrypted_data, $iv) = explode('::', base64_decode($data), 2);

    return openssl_decrypt($encrypted_data, 'aes-256-cbc', $encryption_key, 0, $iv);
}

// Example usage:
$key = 'your_base64_encoded_key';
$data = 'your_base64_encoded_data';
echo decrypt($data, $key);

?>