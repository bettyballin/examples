<?php
$str = "your_string_here";
$key = "your_key_here";
$iv = "your_iv_here";

echo bin2hex(base64_decode(openssl_encrypt($str, 'aes-128-cbc', $key, OPENSSL_ZERO_PADDING, $iv)));
?>