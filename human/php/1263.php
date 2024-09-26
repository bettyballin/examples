<?php

function hex_to_bytes($hex) {
    return hex2bin($hex);
}

function bytes_to_hex($bytes) {
    return bin2hex($bytes);
}

$pt = str_repeat("\0", 16);

$keyData = hex_to_bytes("112233445566778811223344556677881122334455667788");
$desEDE = mcrypt_module_open(MCRYPT_3DES, '', MCRYPT_MODE_ECB, '');
mcrypt_generic_init($desEDE, $keyData, '');
$ct = mcrypt_generic($desEDE, $pt);
mcrypt_generic_deinit($desEDE);
echo bytes_to_hex($ct) . "\n"; // result: 6FB23EAD0534752B

$keyData = hex_to_bytes("112233445566778811223344556677880000000000000000");
mcrypt_generic_init($desEDE, $keyData, '');
$ct = mcrypt_generic($desEDE, $pt);
mcrypt_generic_deinit($desEDE);
echo bytes_to_hex($ct) . "\n"; // result: 8ca64de9c1b123a7

?>