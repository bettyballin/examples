
// Generate a random salt
$salt = bin2hex(random_bytes(16)); // 16 bytes = 128 bits

// Hash the password with the salt
$hashedPassword = hash('sha256', $salt . $_POST['password']);

// Store both the salt and the hashed password
