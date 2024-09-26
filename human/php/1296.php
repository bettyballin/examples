<?php

function blowfish_decrypt($encrypted, $key) {
    $cipher = 'blowfish';
    $mode = 'ecb';
    $padding = 'zero';

    $encrypted = base64_decode($encrypted);
    $iv_size = mcrypt_get_iv_size($cipher, $mode);
    $iv = mcrypt_create_iv($iv_size, MCRYPT_RAND);
    $decrypted = mcrypt_decrypt($cipher, $key, $encrypted, $mode, $iv);

    return rtrim($decrypted, "\0");
}

$original = "@€~&gt;|";
$encrypted_with_utf8_encode = "7+XyF+QGcA8lz5AQlLf1FA==";
$encrypted_without = "3oWsAOEF+Kc=";
$key = "t0ps3cr3t";

$decrypted1 = blowfish_decrypt($encrypted_with_utf8_encode, $key);
$decrypted2 = blowfish_decrypt($encrypted_without, $key);
$same = $original === $decrypted1;

var_dump($decrypted1, $decrypted2, $same);

?>