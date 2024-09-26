
function generateUserId($autoIncrementId, $salt) {
    $entropy = bin2hex(random_bytes(32)); // 32 bytes = 256 bits of entropy
    $timestamp = microtime(true); // Current timestamp with microseconds
    // Concatenate everything and hash it
    return hash('sha256', $salt . $autoIncrementId . $entropy . $timestamp);
}

