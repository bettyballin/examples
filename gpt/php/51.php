
// When storing a new password or updating an existing password
$typed_password = $_POST['password']; // The password typed in by the user
$hashed_password = password_hash($typed_password, PASSWORD_DEFAULT); // Securely hash the password

// Store $hashed_password in the database
// Example SQL query: UPDATE table SET password = :hashed_password WHERE ...

