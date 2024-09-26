function mcrypt_decrypt_to_openssl($data, $key, $iv) {
    // Decrypt using PHP-Mcrypt
    $decrypted = rtrim(mcrypt_decrypt(MCRYPT_RIJNDAEL_128, $key, base64_decode($data), MCRYPT_MODE_CBC, $iv));

    // Remove NULL bytes from decrypted text
    $cleaned_decrypted = str_replace("\0", '', $decrypted);

    // Add missing characters to make the length a multiple of 16 for AES-256-CBC (PKCS#5 padding)
    if (($pad_len = strlen($cleaned_decrypted) % 16) !== 0) {
        $missing_chars_count = 16 - $pad_len;
        $padding_char = chr(16);
        $padded_cleaned_decrypted = str_pad($cleaned_decrypted, strlen($cleaned_decrypted) + $missing_chars_count, $padding_char);
    } else {
        $padded_cleaned_decrypted = $cleaned_decrypted;
    }

    // Encrypt again but this time use openssl_encrypt() instead
    return base64_encode(openssl_encrypt($padded_cleaned_decrypted, 'AES-256-CBC', $key, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING, $iv));
}