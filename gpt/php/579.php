
$bytes = openssl_random_pseudo_bytes(16); // 16 bytes = 128 bits
$token = bin2hex($bytes); // Converts the binary data to hex (32 characters)

