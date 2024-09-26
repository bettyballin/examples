<?php
$key = 'your_secret_key_here';
$secret = 'your_secret_message_here';

$td = mcrypt_module_open('blowfish', '', 'ecb', '');
$iv = mcrypt_create_iv(mcrypt_enc_get_iv_size($td), MCRYPT_RAND);
mcrypt_generic_init($td, $key, $iv);
$encrypted_data = mcrypt_generic($td, $secret);
mcrypt_generic_deinit($td);
mcrypt_module_close($td);

$unpacked = unpack("H*", $encrypted_data);
$hexed = implode("", $unpacked);

print($hexed);
?>