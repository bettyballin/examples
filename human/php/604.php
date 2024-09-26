<?php

$password = 'your_password'; // replace with your password

// Hash a new password for storing in the database.
// The function automatically generates a cryptographically safe salt.
$hashToStoreInDb = password_hash($password, PASSWORD_BCRYPT);

echo "Hash to store in DB: $hashToStoreInDb\n";

// Check if the hash of the entered login password, matches the stored hash.
// The salt and the cost factor will be extracted from $existingHashFromDb.
$isPasswordCorrect = password_verify($password, $hashToStoreInDb);

echo "Is password correct? " . ($isPasswordCorrect ? "Yes" : "No") . "\n";

?>