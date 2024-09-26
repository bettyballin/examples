
<?php
$key = pack('H*', "11223344556677881122334455667788");
$plaintext = pack('H*', "0000000000000000");

// Pad the plaintext to a multiple of the block size for 3DES (8 bytes)
$blockSize = 8;
$pad = $blockSize - (strlen($plaintext) % $blockSize);
$plaintext = str_pad($plaintext, strlen($plaintext) + $pad, chr($pad));

// Encrypt plaintext
$ciphertext = openssl_encrypt($plaintext, 'des-ede3', $key, OPENSSL_RAW_DATA | OPENSSL_NO_PADDING, '');

// Display the ciphertext in hex format
echo bin2hex($ciphertext);
?>

