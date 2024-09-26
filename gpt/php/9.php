
// Hash a new password for storing in the database.
// The default algorithm is currently bcrypt, which will produce a 60 character result.
$passwordHash = password_hash($password, PASSWORD_DEFAULT);

// Store $passwordHash in your database

