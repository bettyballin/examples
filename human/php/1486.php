<?php

$ciphertext = 'OrjgCsq9EkT2TkCZzDOfW492nXQCNIC0BtVJy1FaaTXv2jXAPqx75kaUJVSG/5MCFXXq';
$key = hex2bin('ffa3b5205582d6ea7de6439ec2bafef46a80810003158922');

$plaintext = openssl_decrypt($ciphertext, 'aes-256-ecb', $key, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING);

echo trim($plaintext);

?>