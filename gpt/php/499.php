
function encrypt($plaintext, $encryption_key) {
    $iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));
    $encrypted = openssl_encrypt($plaintext, 'aes-256-cbc', $encryption_key, 0, $iv);
    // Combine the IV and encrypted data and then encode it in hexadecimal
    $encrypted_hex = bin2hex($iv . $encrypted);
    return $encrypted_hex;
}

function decrypt($encrypted_hex, $encryption_key) {
    $iv_strlen = 2 * openssl_cipher_iv_length('aes-256-cbc'); // 2x because of hexadecimal representation
    $iv = hex2
