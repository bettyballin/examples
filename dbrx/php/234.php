<?php
function generateRandomPassword() {
    // Initialize allowed ASCII printable range (excluding 4 unwanted chars)
    $allowed_chars = implode('', range(32, 126));
    $allowed_chars = str_split($allowed_chars);
    unset($allowed_chars[array_search('l', $allowed_chars)]);
    unset($allowed_chars[array_search('1', $allowed_chars)]);
    unset($allowed_chars[array_search('o', $allowed_chars)]);
    unset($allowed_chars[array_search('0', $allowed_chars)]);

    // Initialize the random password
    $password = '';

    // Initialize a random desired length (8 to 12)
    $desired_length = rand(8, 12);

    for ($length = 1; $length <= $desired_length; $length++) {
        // Append an allowed ASCII character randomly
        $random_index = array_rand($allowed_chars);
        $password .= $allowed_chars[$random_index];
    }

    return $password;
}

// Test the function
echo generateRandomPassword();
?>