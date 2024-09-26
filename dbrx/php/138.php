<?php

class Encryption {
    private $secret;

    function __construct($secret) {
        $this->secret = $secret;
    }

    function encrypt($data) {
        $key = hex2bin('000102030405060708090a0b0c0d0e0f101112131415161718191a1b1c1d1e1f');
        if (32 !== strlen($this->secret))  $this->secret = hash('SHA256', $this->secret, true);
        $padding = 16 - (strlen($data) % 16);
        $data .= str_repeat(chr($padding), $padding);

        // Generate a random IV
        $iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length('aes-256-cbc'));

        $encrypt = openssl_encrypt($data, 'aes-256-cbc', $this->secret, OPENSSL_RAW_DATA, $iv);
        
        return base64_encode($iv . $encrypt); // Return IV and encrypted data together
    }
}

// usage
$encrypt = new Encryption('your_secret_key');
echo $encrypt->encrypt('Hello, World!');