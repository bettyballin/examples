
$pass = "test";
$hashed_pass = password_hash($pass, PASSWORD_DEFAULT);

// To verify the password later on
$isPasswordCorrect = password_verify($pass, $hashed_pass);

if ($isPasswordCorrect) {
    // Correct password
} else {
    // Wrong
