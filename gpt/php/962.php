
function generateSecureToken($length = 64) {
    if($length < 1) {
        throw new InvalidArgumentException('Length must be a positive integer');
    }

    $binaryToken = random_bytes($length);
    $base64EncodedToken = base64_encode($binaryToken);

    // Replace '+' with '-', '/' with '_', and remove '='
    $token = strtr($base64EncodedToken, '+/', '-_');
    $token = rtrim($token, '=');

    return $token;
}

// Usage
$token = generateSecureToken(32); // You can adjust the length as needed
echo $token;

