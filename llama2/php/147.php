<?php

// When a user registers
$password = "my_super_secret_password";
$salt = time();
$hashed_password = hash('sha256', $password . $salt);
$stored_string = $hashed_password . $salt;

// Store the string in the database
function store_string_in_db($stored_string) {
    // Simulating database storage
    return $stored_string;
}
$stored_string = store_string_in_db($stored_string);

// When the user logs in
$provided_password = "my_super_secret_password";
$stored_string = $stored_string; // retrieve from database

$hashed_password = substr($stored_string, 0, -10); // Remove the salt from the end
$salt = substr($stored_string, -10);
$verified = hash('sha256', $provided_password . $salt) === $hashed_password;

if ($verified) {
    echo "Login successful";
} else {
    echo "Login failed";
}

function retrieve_stored_string_from_db() {
    // Simulating retrieving from database
    global $stored_string;
    return $stored_string;
}

?>