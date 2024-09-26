<?php
$client = new SoapClient(
    'https://' . urlencode($login) . ':' . urlencode($password) . '@example.com/WSDL/nameofservice',
    array(
        'login' => $login,
        'password' => $password
    )
);
?>