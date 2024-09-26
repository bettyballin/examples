
<?php

$key = "your_secret_key";
$secret = "the_data_to_encrypt";
$method = 'bf-ecb'; // Blowfish in ECB mode

// Pad the secret to a multiple of the block size
$blockSize = openssl_cipher_iv_length($method);
$pad = $blockSize - (strlen($secret) % $blockSize);
$secret .= str_repeat(chr($pad), $pad);

// Encrypt the data
$encrypted = openssl_encrypt($secret, $method, $key, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING);

// Convert to hexadecimal
$code = bin2hex($encrypted);

echo $code;

?>

