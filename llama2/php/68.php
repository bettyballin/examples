<?php
// Configuration
$salt = 'your_secret_salt_here';
$dbHost = 'your_database_host';
$dbName = 'your_database_name';
$dbUser = 'your_database_username';
$dbPass = 'your_database_password';

// Connect to database
$db = new PDO("mysql:host=$dbHost;dbname=$dbName", $dbUser, $dbPass);
$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

// When a user tries to log in
$loginPass = $_POST['password']; // Get the inputted password
$hashedLoginPass = hash('sha256', $salt . $loginPass);

// Query the database for the user's information
$query = "SELECT * FROM users WHERE username = ?";
$stmt = $db->prepare($query);
$stmt->execute(array($_POST['username']));
$row = $stmt->fetch();

if ($row) {
    // Compare the hashed login password with the stored password
    if (hash('sha256', $salt . $row['password']) === $hashedLoginPass) {
        // Authentication successful!
        echo "Welcome " . $_POST['username'] . "!";
    } else {
        // Authentication failed
        echo "Invalid password.";
    }
} else {
    // User not found
    echo "User not found.";
}
?>