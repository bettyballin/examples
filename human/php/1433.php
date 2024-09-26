<?php
function printCiphertextTag($plaintext, $key, $iv, $taglength){
    $encrypted = openssl_encrypt($plaintext, "aes-256-ccm", $key, OPENSSL_RAW_DATA, $iv, $tag, NULL, $taglength);
    echo sprintf("tag size: %2s, IV size: %2s, IV (hex): %-' 24s, ciphertext (hex): %s, tag (hex): %s\n", $taglength, strlen($iv), bin2hex($iv), bin2hex($encrypted), bin2hex($tag));
}

$plaintext = 'message from python'; 
$key = '01234567890123456789012345678901';
$nonce12 = openssl_random_pseudo_bytes(12);
$nonce7 = substr($nonce12, 0, 7);

printCiphertextTag($plaintext, $key, $iv = $nonce12, $taglength = 8);
printCiphertextTag($plaintext, $key, $iv = $nonce7, $taglength = 8);

printCiphertextTag($plaintext, $key, $iv = $nonce12, $taglength = 16);
printCiphertextTag($plaintext, $key, $iv = $nonce7, $taglength = 16);
?>