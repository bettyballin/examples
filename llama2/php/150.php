<?php

// Function to create a hash
function create_hash($password) {
    $salt = bin2hex(random_bytes(16));
    $hash = bcrypt($password, $salt);
    return $hash;
}

// Function to hash password using bcrypt
function bcrypt($password, $salt) {
    $options = [
        'salt' => $salt,
    ];
    return password_hash($password, PASSWORD_BCRYPT, $options);
}

// Verify a login
$login_password = 'your_password';
$enteredPassword = create_hash($login_password);

// Assuming a PDO connection has been established
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
}

// Prepare the query
$stmt = $pdo->prepare('SELECT password, salt FROM your_table WHERE username = :username');
$stmt->bindParam(':username', 'your_username');
$stmt->execute();

$storedData = $stmt->fetch(PDO::FETCH_ASSOC);
$storedPassword = $storedData['password'];
$storedSalt = $storedData['salt'];

if (password_verify($login_password, $storedPassword)) {
    // Login successful
    echo 'Login successful';
} else {
    // Login failed
    echo 'Login failed';
}