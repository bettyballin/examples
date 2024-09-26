
function generateRandomPassword() {
    // Define the characters to exclude
    $exclude_chars = 'l1o0';
    
    // Define all allowable characters
    $allowable_chars = 'abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ23456789';
    
    // Initialize the random password
    $password = '';
    
    // Initialize a random desired length
    $desired_length = rand(8, 12);
    
    // Get the length of allowable characters
    $allowable_chars_length = strlen($allowable_chars);
    
    // Generate the password
    for ($length = 0; $length < $desired_length; $length++) {
        // Select a random character from the allowable characters and append to the password
        $index = rand(0, $allowable_chars_length - 1);
        $password .= $allowable_chars[$index];
    }
    
    return $password;
}

// Generate and print a random password
echo generateRandomPassword();

