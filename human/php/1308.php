<?php
$encrypted_data = file_get_contents('input.bin');
$key = hex2bin('4233373441323641373134393034333741413032344534464144443542343937');
$iv = hex2bin('61736466673534336173646667353433');
$decrypted_data = openssl_decrypt($encrypted_data, 'aes-256-cbc', $key, OPENSSL_RAW_DATA, $iv);
file_put_contents('out.bin', $decrypted_data);
?>