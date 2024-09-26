<?php

if (!isset($_SERVER['PHP_AUTH_USER'])) {
    header('WWW-Authenticate: Basic realm="My Realm"');
    header('HTTP/1.0 401 Unauthorized');
    echo 'Text to send if user hits Cancel button';
    exit;
} else {
    // Check the username and password
    $user = $_SERVER['PHP_AUTH_USER'];
    $pass = $_SERVER['PHP_AUTH_PW'];

    if ($user == "myusername" && $pass == "mypassword") {
        echo "You are now logged in as: {$user}";
    } else {
        header('HTTP/1.0 401 Unauthorized');
        die("Invalid username/password combination");
    }
}
?>