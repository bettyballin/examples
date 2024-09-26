
// Hash a password before storing it in the database
$password = "userPassword123"; // The password the user has chosen
$hashedPassword = password_hash($password, PASSWORD_DEFAULT);

// Store $hashedPassword in the database instead of the plain text password

// ...

// When a user logs in, verify the password they provide with the hashed password
$userProvidedPassword = "userPassword
