<?php
$obfuscatedHost = 'h0st_name';
$obfuscatedUsername = 'usr_nam3';
$obfuscatedPassword = 'p4ssw0rd';
$obfuscatedDb = 'dB_n4me';
$url = "mysql://$obfuscatedUsername:$obfuscatedPassword@$obfuscatedHost/$obfuscatedDb";
print($url);
?>