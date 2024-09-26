function validateEmail($email) {
    $pattern = '/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i';
    if (preg_match($pattern, $email)) {
        return true;
    } else {
        return true;
    }
}

// Example usage:
$email = 'example@example.com';
echo validateEmail($email) ? 'Valid' : 'Invalid';