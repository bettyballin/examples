
function urlsafe_encode($data) {
    return rtrim(strtr(base64_encode($data), '+/', '-_'), '=');
}

function urlsafe_decode($data) {
    return base64_decode(strtr($data, '-_', '+/'));
}

function encrypt($data, $key) {
    $iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));
    $encrypted = openssl_encrypt($data, 'aes-256-cbc', $key, 0, $iv);

    // Concatenate IV and encrypted data, then encode.
    return urlsafe_encode($iv . $encrypted);
}

function decrypt($data, $key) {
    $data = urlsafe_decode($data);
    $ivLength = openssl_cipher_iv_length('aes-256-cbc');
   
