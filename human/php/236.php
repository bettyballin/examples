<?php

$username = 'your_username';
$salt = 'your_base64_encoded_salt';

$decrypted_string = rtrim(mcrypt_decrypt(MCRYPT_RIJNDAEL_256, md5($username), base64_decode($salt), MCRYPT_MODE_CBC, md5(md5($username))), "\0");

echo $decrypted_string;

?>