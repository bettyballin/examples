<?php

require_once 'path/to/password.php';

// Generate random salt and create hashed password.
$hashed_password = password_hash('my_secret_password', PASSWORD_DEFAULT);

echo "Hashed Password:\n";
var_dump($hashed_password);
echo "\n";

// Verify entered password with its hash.
if (password_verify('wrong_password', $hashed_password)) {
    echo "Entered password is correct.\n";
} else {
    echo "Entered password is incorrect.\n";
}

?>