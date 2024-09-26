
// Hashing the password
$password = "user_password";
$hashedPassword = password_hash($password, PASSWORD_DEFAULT);

// Store $hashedPassword in your database

// Verifying the password
$userProvidedPassword = "user_password"; // The password provided by the user during login
$isPasswordCorrect = password_verify($userProvidedPassword, $hashedPassword);

if ($isPasswordCorrect)
