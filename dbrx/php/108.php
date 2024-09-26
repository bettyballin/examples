<?php

require_once('Crypt/RSA.php');

if (isset($_GET['function']) && $_GET['function'] == 'somefunction' &&
    isset($_GET['signature'])) {
    $rsa = new Crypt_RSA();
    $publickey = file_get_contents('server_public.pem');
    $rsa->loadKey($publickey);
    if ($rsa->verify(base64_decode(urldecode($_GET['signature'])), $_SERVER['REQUEST_URI']) === true) {
        echo somefunction();
    } else {
        die("Invalid signature");
    }
}

function somefunction() {
    return "this is the output of the server";
}

?>