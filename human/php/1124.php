<?php

$password = 'your_password_here'; // replace with the password you want to hash
$existingHashFromDb = 'your_existing_hash_here'; // replace with the existing hash from the database

// Hash a new password for storing in the database.
// The function automatically generates a cryptographically safe salt.
$hashToStoreInDb = password_hash($password, PASSWORD_DEFAULT);

echo "Hash to store in database: $hashToStoreInDb\n";

// Check if the hash of the entered login password, matches the stored hash.
// The salt and the cost factor will be extracted from $existingHashFromDb.
$isPasswordCorrect = password_verify($password, $existingHashFromDb);

echo "Is password correct? " . ($isPasswordCorrect ? "Yes" : "No") . "\n";

?>