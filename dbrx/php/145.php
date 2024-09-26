function getCommonDictionaryWords() {
    // Implement this function to fetch a list of commonly used English language words.
    // For demonstration purposes, a static array is used.
    $commonWords = array('password', 'qwerty', 'abc123', 'letmein', 'dragonball');
    return $commonWords;
}

function checkPasswordContainsUsernameOrEmail($username, $email, $password) {
    // Convert all strings to lowercase for case-insensitive comparison
    $lowercaseUsername = strtolower($username);
    $lowercaseEmail = strtolower($email);
    $lowercasePassword = strtolower($password);

    if (strpos($lowercasePassword, $lowercaseUsername) !== false || strpos($lowercasePassword, substr($lowercaseEmail, 0, strpos($lowercaseEmail, '@'))) !== false) {
        return true;
    }

    // Split the password into words and check each word against common dictionary
    foreach (explode(' ', $password) as $word) {
        if (in_array(strtolower($word), getCommonDictionaryWords())) {
            return true;
        }
    }

    return false;
}

// Test the function
$username = 'testuser';
$email = 'testuser@example.com';
$password = 'TestUser123';

echo var_export(checkPasswordContainsUsernameOrEmail($username, $email, $password), true) . "\n";