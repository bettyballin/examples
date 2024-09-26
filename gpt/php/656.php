
function containsSubstring($string, $substring) {
    return strpos($string, $substring) !== false;
}

function isPasswordStrong($email, $username, $password) {
    // Convert email and username to lowercase for case-insensitive search
    $email = strtolower($email);
    $username = strtolower($username);
    $passwordLower = strtolower($password);

    // Check if password contains username or email (or parts of them)
    if (containsSubstring($passwordLower, $username) || 
        containsSubstring($passwordLower, explode('@', $email)[0])) {
        return false; // Password contains username or email
    }

    // Check for common dictionary words (you need a list of common words for this)
    $commonWords = ['password', '123456', '123456789', 'qwerty', 'abc123', ...]; // add more words
    foreach ($commonWords as $
