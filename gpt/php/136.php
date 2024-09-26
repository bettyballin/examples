
$pass = "***"; // Your plaintext password

// Create a password hash
$hashedPassword = password_hash($pass, PASSWORD_DEFAULT);

// The hashed password includes the algorithm, cost and salt as part of the returned hash

