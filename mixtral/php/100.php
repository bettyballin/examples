<?php

$clientSecretKey = 'your_secret_key_here'; // replace with your secret key

if(isset($_GET['func']) && $_SERVER["HTTP_AUTHORIZATION"] == 'Bearer '. $clientSecretKey) {
    echo someFunction();
}

// or

$token = isset($_REQUEST['token']) ? trim($_REQUEST['token']): '';

if($token === $clientSecretKey && $_GET['func'] == 'somefunction')
{
    echo someFunction();
}

function someFunction() {
    // your function code here
    return 'Hello, World!';
}

?>