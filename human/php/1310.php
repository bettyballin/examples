<?php
$key = chr(208) . chr(193) . chr(208) . chr(49) . chr(81) . chr(84) . chr(244) . chr(181) . chr(234) . chr(244) . chr(94) . chr(164) . chr(44) . chr(55) . chr(244) . chr(64) . chr(233) . chr(97) . chr(4) . chr(64) . chr(179) . chr(155) . chr(161) . chr(155);
$iv = chr(187) . chr(159) . chr(143) . chr(131) . chr(24) . chr(115) . chr(157) . chr(64);

$text = "foobar";

echo openssl_encrypt($text, 'DES-EDE3-CBC', $key, 0, $iv);
?>