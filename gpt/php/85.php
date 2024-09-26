
function encryptCookie($value, $key) {
    $ivLength = openssl_cipher_iv_length('aes-256-cbc');
    $iv = openssl_random_pseudo_bytes($ivLength);
    $encryptedValue = openssl_encrypt($value, 'aes-256-cbc', $key, 0, $iv);
    
    // Combine IV with encrypted value; they will be needed together for decryption
    return base64_encode($iv . $encryptedValue);
}

