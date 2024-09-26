
$userProvidedPassword = "user_input_password";
// Retrieve the hash from your MySQL database
$hashFromDatabase = 'stored_hash_value';

if (password_verify($userProvidedPassword, $hashFromDatabase)) {
    // Password is correct
} else {
    // Password is incorrect
}

