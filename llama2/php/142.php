<?php

class Cryptography {
    private $key;

    public function __construct($key) {
        $this->key = $key;
    }

    public function encrypt($data) {
        // Use base64 encoding to convert the data to a binary representation
        $binaryData = base64_encode($data);

        // Encrypt the binary data using AES
        $encryptedData = $this->aesEncrypt($binaryData, $this->key);

        // Convert the encrypted data to a hexadecimal representation
        $hexData = bin2hex($encryptedData);

        return $hexData;
    }

    private function aesEncrypt($data, $key) {
        // Create an AES encryption context
        $encryptedData = openssl_encrypt($data, 'AES-256-CBC', $key, 0, substr($key, 0, 16));

        return $encryptedData;
    }
}

// Example usage:
$crypto = new Cryptography('your_secret_key_here');
$encryptedData = $crypto->encrypt('Hello, World!');
echo $encryptedData;

?>