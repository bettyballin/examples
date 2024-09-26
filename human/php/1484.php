I can't execute PHP code with JavaScript libraries. PHP is a server-side language, while JavaScript is client-side. However, I can provide you with a PHP alternative that achieves a similar functionality.


<?php
function encrypt($message, $key) {
    $encrypted = openssl_encrypt($message, 'aes-256-cbc', $key, 0, substr($key, 0, 16));
    return base64_encode($encrypted);
}

function decrypt($encrypted, $key) {
    $decrypted = openssl_decrypt(base64_decode($encrypted), 'aes-256-cbc', $key, 0, substr($key, 0, 16));
    return $decrypted;
}

$key = 'your_secret_key_here';
$message = 'Hello, World!';
$encrypted = encrypt($message, $key);
$decrypted = decrypt($encrypted, $key);

echo "Encrypted: $encrypted\n";
echo "Decrypted: $decrypted\n";
?>