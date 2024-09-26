
// To create a hash
$hash = password_hash("your_password_here", PASSWORD_DEFAULT);

// To verify a password against a hash
$isPasswordCorrect = password_verify("your_password_to_test", $hash);

