<?php

// Registration process:
$password = "mySecurePassword";
$salt1 = random_bytes(32);
$salted_password = hash_hmac('sha256', $password, $salt1);
$double_salted_hash = password_hash($salted_password, PASSWORD_DEFAULT);

// Store the double-salted hash and salt 1 in your database
// For demonstration purposes, we'll use an array
$stored_data = [
    "double_salted_hash" => $double_salted_hash,
    "salt1" => $salt1
];

// Gap-fill login process:
$input_positions = [0, 1, 7]; // For example: first, second & eighth characters
$user_input = "mS"; // User input for specific positions (e.g 'mySecurePassword'[input_positions])

.partial_password = "";
foreach ($input_positions as $pos) {
    $partial_password .= $password[$pos];
}

$partial_password_hash = hash_hmac('sha256', $partial_password, $stored_data["salt1"]);
$gap_fill_hash = password_hash($partial_password_hash, PASSWORD_DEFAULT);

// Compare the generated gap-fill hash with stored hashes of corresponding character combinations
if (password_verify($partial_password_hash, $stored_data["double_salted_hash"])) {
    echo "Login successful!";
} else {
    echo "Login failed!";
}

?>