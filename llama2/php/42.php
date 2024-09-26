<?php
function sanitize_string($user_input) {
    $sanitized_data = trim(strtolower($user_input));
    $sanitized_data = preg_replace('/[^\w\s]/', '', $sanitized_data);
    return $sanitized_data;
}

// Test the function
$user_input = "Hello, World!";
echo sanitize_string($user_input);
?>