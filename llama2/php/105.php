<?php

$key = 'my_secret_key';
$session_id = bin2hex(mcrypt_encrypt(MCRYPT_RIJNDAEL_128, $key, session_id(), MCRYPT_MODE_ECB));
session_name($session_id);
session_start();

?>