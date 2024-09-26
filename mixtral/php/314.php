<?php

$key = random_bytes(32); // 32 bytes for a 256-bit encryption

// Generate initialization vector
$ivSize = openssl_cipher_iv_length('aes-256-cbc');
$iv = openssl_random_pseudo_bytes($ivSize, $strong);

if(!$strong) {
    throw new Exception("IV generation failed");
}