<?php

class SecurityTokenGenerator {
    public static function generateSecurityToken($secretKey) {
        $token = array(
            'session_id' => session_id(),
            'ts_ms' => round(microtime(true)*1000)
        );

        openssl_public_encrypt($secretKey, $key);

        $tokenJson = json_encode($token);

        return base64_encode(
            self::pkcs5PadAndEncrypt($tokenJson, $key)
        );
    }

    public static function pkcs5PadAndEncrypt ($text, $key) {
        $pad = strlen($text) % 16 + 1;

        return openssl_encrypt(
            str_repeat(chr($pad), $pad).$text,
            'AES-256-ECB',
            base64_decode($key),
            OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING
        );
    }
}

// Example usage:
$secretKey = 'your_secret_key_here';
echo SecurityTokenGenerator::generateSecurityToken($secretKey);

?>