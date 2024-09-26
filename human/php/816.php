function DecryptRJ256($prm_key, $prm_iv, $prm_text_to_decrypt) {
    $sEncryptedString = $prm_text_to_decrypt;
    $key = utf8_encode($prm_key);
    $iv = utf8_encode($prm_iv);

    $decrypted = openssl_decrypt($sEncryptedString, 'aes-256-cbc', $key, OPENSSL_RAW_DATA|OPENSSL_ZERO_PADDING, $iv);

    return $decrypted;
}