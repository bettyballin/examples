<?php

$username = $_SERVER['PHP_AUTH_USER'];
$password = $_SERVER['PHP_AUTH_PW'];

if ($username && $password) {
    // Verify the username and password against the values in the .htpasswd file
    $authResult = authUser($username, $password);

    if ($authResult == true) {
        echo "Access granted!";
    } else {
        header('WWW-Authenticate: Basic realm="My Realm"');
        header('HTTP/1.0 401 Unauthorized');
        echo "Access denied!";
        exit;
    }
}

function authUser($username, $password) {
    // Read the contents of the .htpasswd file
    $htpasswd = file('/path/to/.htpasswd');

    // Split the line into username and password
    foreach ($htpasswd as $line) {
        list($authUsername, $authPassword) = explode(':', $line);
        if ($authUsername == $username && crypt($password, $authPassword) == $authPassword) {
            return true;
        }
    }

    return false;
}

?>