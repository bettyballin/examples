<?php

function retrieve_stored_password() {
    // Replace with your actual password retrieval logic
    return 'your_stored_password_hash';
}

$input = 'your_input_password';
$password = password_hash($input, PASSWORD_DEFAULT);

echo "Password Hash: $password\n";

// Store $password securely

// Later when the user logs in
$input = 'your_input_password';
$storedPassword = retrieve_stored_password();

if (password_verify($input, $storedPassword)) {
    echo "Login successful\n";
} else {
    echo "Login failed\n";
}

?>