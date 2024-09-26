<?php

$key_hardcoded_in_flash_game = 'your_hardcoded_key_here'; // replace with the actual hardcoded key
$random_128_bit_key = openssl_random_pseudo_bytes(16);

$aes_encrypted = openssl_encrypt($random_128_bit_key, 'AES-128-ECB', $key_hardcoded_in_flash_game, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING);

$hex_encoded = bin2hex($aes_encrypted);

echo $hex_encoded;

?>