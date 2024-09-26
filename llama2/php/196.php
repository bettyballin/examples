<?php
// Configuration
$password = 'your_password_here'; // Replace with your password
$dbHost = 'your_host_here'; // Replace with your database host
$dbUser = 'your_user_here'; // Replace with your database user
$dbPass = 'your_pass_here'; // Replace with your database password
$dbName = 'your_database_here'; // Replace with your database name

// Generate a random salt using random_bytes()
$salt = random_bytes(16);

// Hash the password with SHA-256 and store it in the database
$hashedPassword = hash('sha256', $password . $salt);

// Create a PDO instance
$dsn = "mysql:host=$dbHost;dbname=$dbName";
$options = [
    PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
    PDO::ATTR_EMULATE_PREPARES   => false,
];
$pdo = new PDO($dsn, $dbUser, $dbPass, $options);

// Prepare the SQL statement
$stmt = $pdo->prepare('INSERT INTO users (password, salt) VALUES (:password, :salt)');

// Bind the parameters
$stmt->bindParam(':password', $hashedPassword);
$stmt->bindParam(':salt', $salt);

// Execute the statement
$stmt->execute();