<?php

$key = '0123456789abcdef'; // 16 bytes long
$iv = 'fedcba9876543210'; // 16 bytes long
$ciphertext = 'your_encrypted_text_here'; // replace with your ciphertext

$cipher = mcrypt_decrypt(MCRYPT_RIJNDAEL_128, $key, $ciphertext, MCRYPT_MODE_CBC, $iv);

echo $cipher;

?>