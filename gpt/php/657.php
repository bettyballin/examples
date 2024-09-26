
try {
    $token = bin2hex(random_bytes(32)); // 32 bytes = 256 bits
} catch (Exception $e) {
    // Handle the exception in case the random bytes could not be generated
    error_log($e->getMessage());
    // Generate a fallback token or handle the error appropriately
}

