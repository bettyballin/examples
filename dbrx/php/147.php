<?php

function checkPasswordContainsUsernameOrEmail($username, $email, $password) {
    return strpos($password, $username) !== false || strpos($password, $email) !== false;
}

function checkPasswordContainsCommonWord($password) {
    $commonWords = array('password', 'qwerty', 'letmein', 'dragonball', 'baseball');
    return in_array(strtolower($password), $commonWords);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST['username'];
    $email = $_POST['email'];
    $password = $_POST['password'];

    if (checkPasswordContainsUsernameOrEmail($username, $email, $password)) {
        echo "Error: Password cannot contain your username or email.";
    } elseif (checkPasswordContainsCommonWord($password)) {
        echo "Error: Password is too common. Please choose a stronger password.";
    }
}

?>

<form action="" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email"><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br><br>
    <input type="submit" value="Submit">
</form>