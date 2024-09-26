function encryptAESE($text, $base64Key)
{
    // Decode the Base64 key
    $decodedKey = base64_decode($base64Key);

    if ($decodedKey === false){
        throw new Exception('Invalid Key');
    }

    // Use raw binary data for encryption
    $encrypt = openssl_encrypt(
        $text,
        'AES-128-CBC',
        $decodedKey,
        OPENSSL_RAW_DATA
    );

    if (!$encrypt) {
        throw new Exception('AES encryption error');
    }

    return base64_encode($encrypt);
}