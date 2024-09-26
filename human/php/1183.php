<?php
$encryption_key = 'your_secret_key_here';
$pure_string = 'Hello, World!';
$iv = mcrypt_create_iv(mcrypt_get_iv_size(MCRYPT_BLOWFISH, MCRYPT_MODE_ECB), MCRYPT_RAND);

$encrypted_string = mcrypt_encrypt(MCRYPT_BLOWFISH, $encryption_key, $pure_string, MCRYPT_MODE_ECB, $iv);

echo 'Encrypted String: ' . bin2hex($encrypted_string);
?>