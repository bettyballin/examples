<?php
$encrypted = 'your_encrypted_data_here';
$publickey = 'your_public_key_here';

openssl_public_decrypt($encrypted, $data, $publickey);

print($data);
?>