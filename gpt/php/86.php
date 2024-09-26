
function decryptCookie($cookie, $key) {
    $combined = base64_decode($cookie);
    $ivLength = openssl_cipher_iv_length('aes-256-cbc');
    $iv = substr($combined, 0, $ivLength);
    $
