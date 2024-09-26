<?php

function hash_password($password) {
    return password_hash($password, PASSWORD_DEFAULT);
}

function verify_password($password, $hash) {
    if (!password_verify($password, $hash)) {
        // Password verification failed. Re-hash the old MD5 hash.
        $newHash = hash_password($password);

        // Save the new hash in your database for future logins.

        return false;
    }

    return true; // The password is correct
}

// Example usage:
$password = 'testpassword';
$hashedPassword = hash_password($password);

echo "Hashed Password: $hashedPassword\n";

$isVerified = verify_password($password, $hashedPassword);

echo "Is Verified: " . ($isVerified ? 'true' : 'false') . "\n";

?>