<?php

function enc_aes($str, $key, $iv) {
    $aes = mcrypt_module_open(MCRYPT_RIJNDAEL_128, '', MCRYPT_MODE_CBC, '');
    if (!$aes) die("<b>mcrypt_module_open failed!</b>");
    (mcrypt_generic_init($aes, $key, $iv) != -1) or die("<b>mcrypt_generic_init failed!</b>");

    // PHP will pad query with \0 to multiple of block size
    $ret = mcrypt_generic($aes, $str);
    mcrypt_generic_deinit($aes);
    mcrypt_module_close($aes);
    return $ret;
}

function dec_aes($str, $key, $iv) {
    $aes = mcrypt_module_open(MCRYPT_RIJNDAEL_128, '', MCRYPT_MODE_CBC, '');
    if (!$aes) die("<b>mcrypt_module_open failed!</b>");
    (mcrypt_generic_init($aes, $key, $iv) != -1) or die("<b>mcrypt_generic_init failed!</b>");

    // PHP will pad query with \0 to multiple of block size
    $ret = mdecrypt_generic($aes, $str);
    mcrypt_generic_deinit($aes);
    mcrypt_module_close($aes);
    return trim($ret, "\0");
}

// Specifying key & IV as hex. Obviously doing so in the source is rather unsafe...

// For example. Key is 128-bits
$key = pack("H*", "0123456789ABCDEFFEDBCA9876543210");

// For example. Initialization Vector is 64-bits
$iv = pack("H*", "0123456789ABCDEF");
$encrypted_string = enc_aes("decrypted string", $key, $iv);

// Should output "decrypted string" :]
print(dec_aes($encrypted_string, $key, $iv));

?>