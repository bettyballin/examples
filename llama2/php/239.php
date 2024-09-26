<?php

require_once __DIR__.'/config.php';
session_start();

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = $_POST["username"];
    $password = $_POST["password"];

    // Query the database for the user's information
    $stmt = $dbh->prepare("SELECT * FROM users WHERE username=?");
    $stmt->bindValue(1, $username, PDO::PARAM_STR);
    $stmt->execute();

    // Verify the password
    if ($stmt->rowCount() == 1) {
        $user = $stmt->fetchObject();
        if (password_verify($password, $user->password)) {
            // Password is valid continue with login
            echo "Login successful";
        } else {
            echo "Invalid password";
        }
    } else {
        echo "User not found";
    }
} else {
    echo "Invalid request method";
}

?>