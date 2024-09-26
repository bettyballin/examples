
// Assuming you have the $cipher_text, $key, and $iv

// 1. Decrypt the second to last ciphertext block, using zeros as IV.       
$second_to_last_cipher_block = substr($cipher_text, -32, 16);
$second_to_last_plain = openssl_decrypt($second_to_last_cipher_block, 'aes-128-cbc', $key, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING, str_repeat("\0", 16));

// 2. Pad
