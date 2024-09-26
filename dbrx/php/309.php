<?php

function pkcs5_pad($text) {
    $blocksize = 16;
    $pad = $blocksize - (strlen($text) % $blocksize);
    return $text . str_repeat(chr($pad), $pad);
}

$key = pack('H*', "11223344556677881122334455667788");
$plaintext = pkcs5_pad("0000000000000000");

// CBC mode
$ciphertextCBC = mcrypt_encrypt(MCRYPT_3DES, $key, $plaintext, MCRYPT_MODE_CBC);

// CTR mode
$iv_size = mcrypt_get_iv_size(MCRYPT_3DES, MCRYPT_MODE_CFB);
$iv = mcrypt_create_iv($iv_size, MCRYPT_RAND);
$ciphertextCTR = mcrypt_encrypt(MCRYPT_3DES, $key, $plaintext, MCRYPT_MODE_CFB, $iv);

echo "CBC: " . bin2hex($ciphertextCBC) . "\n";
echo "CTR: " . bin2hex($ciphertextCTR) . "\n";

?>