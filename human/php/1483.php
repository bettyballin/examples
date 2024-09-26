<?php
$encData = hex2bin("D5F630E93F36C21293012D78E5A384F1");
$key = hex2bin("A254FE00A791AA74386E8DEF3712B256");
$iv = hex2bin("00000000000000000000000000000000");

$data = openssl_decrypt($encData, 'aes-128-ecb', $key, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING, $iv);
echo bin2hex($data);
?>