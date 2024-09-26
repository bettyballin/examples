<?php
$key = '0123456789abcdef'; // 16 bytes long
$iv = 'fedcba9876543210'; // 16 bytes long
$plaintext = 'This is a secret message';

$cipher = mcrypt_encrypt(MCRYPT_RIJNDAEL_128, $key, $plaintext, MCRYPT_MODE_CBC, $iv);

echo "Encrypted: " . base64_encode($cipher);
?>