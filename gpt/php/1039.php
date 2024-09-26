
function deriveAESGCMKeyFromPassword($password, $salt, $iterations = 1000, $length = 32) {
    $salt = base64_decode($salt);
    // Derive the key using PBKDF2 with SHA-256
    $key = hash_pbkdf2("sha256", $password, $salt, $iterations, $length, true);
    return $key;
}

