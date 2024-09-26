
// Encryption
$plaintextPassword = 'your_password';
$key = getenv('ENCRYPTION_KEY'); // Or another secure source
$method = 'aes-256-cbc';
$iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length($method));

$encryptedPassword = openssl_encrypt($plaintextPassword, $method, $key, 0, $iv);
// Store $encryptedPassword and $iv somewhere safe

// Decryption
$decrypted
