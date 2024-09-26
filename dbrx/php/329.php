$ciphertext = $row['data'];
$iv         = $row['iv'];
$key        = 'your_secret_key_here'; // replace with your secret key

$decrypted = openssl_decrypt($ciphertext, 'aes-256-cbc', $key, OPENSSL_RAW_DATA, $iv);