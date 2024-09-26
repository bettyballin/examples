<?php

define('CRYPTKEY', 'your_secret_key_here');
define('CRYPTALGO', 'aes-256-cbc');

class Crypto {
    public function crypt($text){
        if (empty($text)) {
            throw new Exception('Input text cannot be empty.');
        }

        $iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length(CRYPTALGO));
        $encryption_key = base64_decode(CRYPTKEY);

        $crpytedid = openssl_encrypt ($text, CRYPTALGO, $encryption_key, 0, $iv);

        return base64_encode($crpytedid.'::'.$iv);
    }
}

$crypto = new Crypto();
try {
    $encrypted = $crypto->crypt('Hello, World!');
    echo $encrypted . "\n";
} catch (Exception $e) {
    echo 'Caught exception: ',  $e->getMessage(), "\n";
}