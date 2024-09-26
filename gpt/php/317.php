
// When storing a new password:
$hash = password_hash($password, PASSWORD_DEFAULT);

// When verifying a submitted password:
if (password_verify($submittedPassword, $storedHash)) {
    // Password is correct
} else {
    // Password is incorrect
}

