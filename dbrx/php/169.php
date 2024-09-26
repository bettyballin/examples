<?php

use ParagonIE\ConstantTime\Base64UrlSafe;
use SodiumException;

function hashPassword(string $password, string $salt): string {
    try {
        return Base64UrlSafe::encode(
            sodium_crypto_pwhash_str(
                $password, 
                $salt, 
                SODIUM_CRYPTO_PWHASH_OPSLIMIT_INTERACTIVE, 
                SODIUM_CRYPTO_PWHASH_MEMLIMIT_INTERACTIVE
            )
        );
    } catch (SodiumException $e) {
        throw new RuntimeException('Failed to hash password', 0, $e);
    }
}

function verifyPassword(string $password, string $hash): bool {
    try {
        return sodium_crypto_pwhash_str_verify(
            Base64UrlSafe::decode($hash), 
            $password
        );
    } catch (SodiumException $e) {
        throw new RuntimeException('Failed to hash password', 0, $e);
    }
}

$password = 'mysecretpassword';
$salt = random_bytes(16);
$hash = hashPassword($password, $salt);

var_dump(verifyPassword($password, $hash)); // bool(true)

?>