
function encrypt($plain, $key) {
    $ivSize = openssl_cipher_iv_length('aes-256-cfb');
    $iv = openssl_random_pseudo_bytes($ivSize);

    $encrypted = openssl_encrypt($plain, 'aes-256-cfb', $key,
