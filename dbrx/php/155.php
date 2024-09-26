<?php

// Check if both username and password fields have been set before processing them further
if (isset($_POST['username']) && isset($_POST['password'])) {
    $username = $_POST['username'];
    $password = $_POST['password'];

    // Sanitize user inputs to prevent any potential code injection or XSS attacks.
    // Using htmlspecialchars() will convert special characters into their HTML entities    // which helps protect against cross-site scripting (XSS) and other related vulnerabilities.

    $sanitizedUsername = htmlspecialchars($username, ENT_QUOTES, 'UTF-8');
    $sanitizedPassword = htmlspecialchars($password, ENT_QUOTES, 'UTF-8');

    // Now you can use the sanitized inputs in your application logic.
    echo "Sanitized Username: $sanitizedUsername\n";
    echo "Sanitized Password: $sanitizedPassword\n";
}

// Simple form to test the script
?>

<form action="" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br><br>
    <input type="submit" value="Submit">
</form>