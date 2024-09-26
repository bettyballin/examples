
    function EncryptAES($data){
        global $KEY;
        $ivlen = openssl_cipher_iv_length("aes-256-cbc");
        $iv = openssl_random_pseudo_bytes($ivlen);
        $ciphertext_raw = openssl_encrypt($data, "aes-256-cbc", $KEY, OPENSSL_RAW_DATA, $iv);
        $hmac = hash_hmac('sha256', $ciphertext_raw, $KEY, $as_binary=true);
        $ciphertext = base64_encode
