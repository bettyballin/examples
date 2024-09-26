<?php

define("ENCRYPTION_KEY", "QaY7e4d1c");
$string = "Ã¡Ã½Å¾ÅÄÅ¡Ä";

echo $encrypted = encrypt($string, ENCRYPTION_KEY);
echo "\n";
echo $decrypted = decrypt($encrypted, ENCRYPTION_KEY);

function encrypt($pure_string, $encryption_key)
{
    $iv_size = openssl_cipher_iv_length('aes-256-cbc');
    $iv = random_bytes($iv_size);
    $encrypted_string = openssl_encrypt(
        utf8_encode($pure_string),
        'aes-256-cbc',
        $encryption_key,
        OPENSSL_RAW_DATA,
        $iv
    );
    return base64_encode($iv . $encrypted_string);
}

function decrypt($encrypted_base64, $encryption_key)
{
    $encrypted_base64 = base64_decode($encrypted_base64);
    $iv_size = openssl_cipher_iv_length('aes-256-cbc');
    $iv = substr($encrypted_base64, 0, $iv_size);
    $encrypted_string = substr($encrypted_base64, $iv_size);
    return utf8_decode(
        openssl_decrypt(
            $encrypted_string,
            'aes-256-cbc',
            $encryption_key,
            OPENSSL_RAW_DATA,
            $iv
        )
    );
}

?>