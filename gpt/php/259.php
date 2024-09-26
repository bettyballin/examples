
// Encrypting a value
function encrypt($data, $key) {
    $cipher = "aes-256-cbc";
    $ivlen = openssl_cipher_iv_length($cipher);
    $iv = openssl_random_pseudo_bytes($ivlen);
    $encrypted = openssl_encrypt($data, $cipher, $key, $options=OPENSSL_RAW_DATA, $iv);
    $encrypted_hex = bin2hex($iv . $encrypted);
    return $encrypted_hex;
}

// Decrypting a value
function decrypt($encrypted_hex, $key
