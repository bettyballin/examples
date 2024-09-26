<?php

// Generate a random 32-character string as the password reset token
$token = bin2hex(random_bytes(16));

// Hash and store this unique token in your database
$hashedToken = password_hash($token, PASSWORD_DEFAULT);

// Send an email to users containing a link that includes their hashed tokens
echo "Send email with link: http://example.com/reset-password?token=$hashedToken\n";

// Simulate database storage
function getUserByTokenFromDatabase($token) {
    // Replace with actual database logic
    $users = [
        'hashed_token_1' => ['id' => 1, 'email' => 'user1@example.com'],
        'hashed_token_2' => ['id' => 2, 'email' => 'user2@example.com'],
    ];
    return $users[$token] ?? null;
}

// When someone clicks on the reset-password URL
if (isset($_GET['token'])) {
    $user = getUserByTokenFromDatabase($_GET['token']);

    if ($user && password_verify($token, $_GET['token']) /* check expiration time as well*/) {
        // Allow users to set a new password for their account
        echo "User verified, allow password reset\n";
    } else {
        echo "Invalid or expired token\n";
    }
}

?>