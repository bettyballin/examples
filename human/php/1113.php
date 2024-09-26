<?php
$txtpass = "password in textfile";
$key = "password"; // Encryption password to 'lock and unlock' the data
$iv = "1234567812345678";
$encrypted = openssl_encrypt($txtpass, 'AES-128-CBC', $key, 0, $iv);
$decrypted  = openssl_decrypt($encrypted, 'AES-128-CBC', $key, 0, $iv);

print "Encrypted: $encrypted\n";
print "Decrypted: $decrypted\n";
?>