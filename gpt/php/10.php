
// Check if the hash of the provided password matches the stored hash.
$isPasswordCorrect = password_verify($password, $passwordHash);

// $isPasswordCorrect will be true if the password is correct.

