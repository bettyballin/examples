function encrypt($data, $key) {
    return openssl_encrypt(
        str_pad($data, strlen($data) + (16 - strlen($data) % 16), "\0"),
        'AES-256-CBC',
        base64_decode($key),
        OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING,
        str_repeat("\0", openssl_cipher_iv_length('aes-256-cbc'))
    );
}

function decrypt($data, $key) {
    return rtrim(
        openssl_decrypt(
            base64_decode($data),
            'AES-256-CBC',
            base64_decode($key),
            OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING,
            str_repeat("\0", openssl_cipher_iv_length('aes-256-cbc'))
        ),
        "\0"
    );
}