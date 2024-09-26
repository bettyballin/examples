
function generateAnonUsername($length = 12) {
    $bytes = random_bytes($length / 2);
    $anonUsername = "__anon__" . bin2hex($bytes);
    return $anonUsername;
}

$anonUsername = generateAnonUsername(); // e.g., __anon__4e52a8cf4b2e

