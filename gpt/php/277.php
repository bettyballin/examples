
// Function to encrypt the student ID
function encryptStudentId($studentId, $encryptionKey) {
    $ivlen = openssl_cipher_iv_length($cipher="AES-128-CBC");
    $iv = openssl_random_pseudo_bytes($ivlen);
    $ciphertext_raw = openssl_encrypt($studentId, $cipher, $encryptionKey, $options=OPENSSL_RAW_DATA, $iv);
    $hmac = hash_hmac('sha256', $ciphertext_raw, $encryptionKey, $as_binary=true);
    $ciphertext = base64_encode($iv.$hmac.$ciphertext_raw);
    return $ciphertext;
}

// Function to decrypt the student ID
function decryptStudentId($encryptedStudentId, $encryptionKey) {
    $c = base64_decode($encryptedStudentId);
    $ivlen = openssl_cipher_iv_length($cipher="
