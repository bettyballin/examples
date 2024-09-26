$stringToEncrypt = 'Hello, World!';
$key = 'your_secret_key_here'; // 32 bytes

// Encrypt
$iv = random_bytes(openssl_cipher_iv_length('aes-256-cbc'));
$encryptedData = openssl_encrypt($stringToEncrypt, 'aes-256-cbc', $key, 0, $iv);
$encodedIv = base64_encode($iv);
$base64Ciphertext = base64_encode($encryptedData);
$stringToDecrypt = $encodedIv . ':' . $base64Ciphertext;

// Decode
list($encodedIv, $base64Ciphertext) = explode(':', $stringToDecrypt);
$iv = base64_decode($encodedIv);
$ciphertext = base64_decode($base64Ciphertext);
$decryptedData = openssl_decrypt($ciphertext, 'aes-256-cbc', $key, 0, $iv);

echo "Encrypted: $stringToDecrypt\n";
echo "Decrypted: $decryptedData\n";