<?php

function generateAuthToken($username) {
    $userSpecificData = strtolower($username);
    $randomBytes = random_bytes(32); // 256 bits (32 bytes) should provide sufficient randomness

    return hash_hmac('sha256', $userSpecificData . '|' . bin2hex($randomBytes), 'your_secret_key');
}

// Test the function
$username = 'test_user';
echo generateAuthToken($username);

?>