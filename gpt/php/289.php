
function encryptStringWithPassword($string, $password) {
    $method = 'AES-256-CBC';
    $key = hash('sha256', $password, true);
    $ivLength = openssl_cipher_iv_length($method);
    $iv = openssl_random_pseudo_bytes($ivLength);

    $encrypted = openssl_encrypt($string, $method, $key, OPENSSL_RAW_DATA, $iv);
    // We'll prepend the IV for it to be available during decryption
    $encrypted = base64_encode($iv . $encrypted);

    return $encrypted;
}

function decryptStringWithPassword($encrypted, $password) {
    $method = 'AES-256-CBC';
    $key = hash('sha256', $password, true);

    $data = base64_decode($encrypted);
    $ivLength = openssl_cipher_iv_length($method);
    $iv = substr
