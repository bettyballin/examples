<?php

use OpenSSL\Cipher;

class ReCaptchaV2 {
    const BLOCK_SIZE = 16; // 128 bits (16 bytes)

    public static function generateSecurityToken($secretKey, $nonce) {
        if (!is_string($secretKey)) {
            throw new \InvalidArgumentException('Secret key must be a string');
        }

        if (!is_int($nonce)) {
            throw new \InvalidArgumentException('Nonce must be an integer');
        }

        $cipher = new Cipher('aes-128-cbc', 'encrypt', array(
            'key' => base64_decode($secretKey),
            'iv' => str_repeat(\chr(0), self::BLOCK_SIZE)
        ));

        $token = $cipher->encrypt(pack('V*', $nonce));

        return rtrim(strtr(base64_encode($token), '+/', '-_'), '=');
    }
}

$secretKey = 'YOUR_SECRET_KEY';
$nonce = 1234567890;

echo ReCaptchaV2::generateSecurityToken($secretKey, $nonce);