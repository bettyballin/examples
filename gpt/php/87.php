
// When the user creates a classified
$userPassword = $_POST['password']; // The password they entered
$hashedPassword = password_hash($userPassword, PASSWORD_DEFAULT); // Hash it

// Now store $hashedPassword in your database instead of the plain text password

