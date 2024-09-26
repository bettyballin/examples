<?php

$username = 'your_username';
$salt = 'your_salt';

$ciphertext = base64_encode(mcrypt_encrypt(MCRYPT_RIJNDAEL_256, md5($username), $salt, MCRYPT_MODE_CBC, md5(md5($username))));

print($ciphertext);

?>