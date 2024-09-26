<?php

$token = $_POST['token'];

function genToken($timestamp) {
    // assuming this function generates a token based on the timestamp
    // replace this with your actual implementation
    return sha1($timestamp . 'your_secret_key');
}

function validate($token) {
    $timestamp = substr($token, 0, 10);
    return 
        (genToken($timestamp) == $token)
        && ($timestamp >= time() - 600);
}

// usage
if(isset($_POST['token'])) {
    if(validate($token)) {
        echo "Token is valid";
    } else {
        echo "Token is invalid";
    }
} else {
    echo "No token provided";
}

?>