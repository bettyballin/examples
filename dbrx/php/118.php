<?php

function padBase64($base64String) {
    return str_pad(rtrim($base64String, '='), strlen($base64String) + (4 - strlen($base64String) % 4) % 4, '=', STR_PAD_RIGHT);
}

// Encrypt your JSON payload using RNCryptor PHP functions
$encryptedPayload = "your_encrypted_payload_here"; // replace with your encrypted payload

// Base64 encode the encrypted data and pad it if necessary
$paddedBase64EncodedData = padBase64(base64_encode($encryptedPayload));

// Send padded base64 encoded string to iOS app for decryption
echo $paddedBase64EncodedData;

?>