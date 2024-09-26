<?php

// Check if POST request
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = $_POST['user'];
    // Generate password hash
    $passHash = password_hash($_POST['pass'], PASSWORD_BCRYPT);

    // Store $username and $passHash in the database.
    // For demonstration purposes, we'll use a simple array
    $users = array($username => $passHash);

    // To verify a user's password you can use `password_verify()` function:
    $enteredPassword = $_POST['userEnteredPass'];
    $storedHashedPassword = $users[$username];

    if (password_verify($enteredPassword, $storedHashedPassword)) {
        echo "Password is correct";
    } else {
        echo "Invalid password";
    }
} else {
    echo "Invalid request method";
}