<?php

$data = 'This is a test message';
$key = file_get_contents('path/to/your-pubkey.pem');
$crypted = '';
openssl_public_encrypt($data, $crypted, $key);
echo base64_encode($crypted);

?>