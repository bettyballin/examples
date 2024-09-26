
define("CRYPT_BLOWFISH", 1);

function blowfishCrypt($password, $cost = 7) {
    $salt = sprintf('$2a$%02d$', $cost) . substr(strtr(base64_encode(openssl_random_pseudo_bytes(16)), '+', '.'), 0, 22);
    return crypt($password, $salt);
}

function verifyPassword($password, $hashedPassword) {
    return crypt($password, $hashedPassword) == $hashedPassword;
}

// Usage
$password = "your_password_here";
$hashedPassword = blowfishCrypt($password);

// To verify
$isPasswordCorrect = verifyPassword("your_password_here", $hashedPassword);

