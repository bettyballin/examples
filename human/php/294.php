<?php
$data = 'Hello, World!';
$privatekey = openssl_pkey_get_private('file://path/to/private/key.pem');
openssl_private_encrypt($data, $encrypted, $privatekey);
echo base64_encode($encrypted);
?>