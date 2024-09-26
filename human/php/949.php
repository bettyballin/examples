<?php

define('CSRF_SALT', 'your_secret_salt_here');

function getToken($action)
{
    return base64_encode(
        hash_hmac(
            'sha256', 
            hash_hmac(
                'sha256',
                date('Ymd') . $_SERVER['REMOTE_ADDR'] . $_SERVER['HTTP_USER_AGENT'],
                hash('sha256', $action, true),
                true
            ),
            CSRF_SALT,
            true
        )
    );
}

echo "<form action='register.php' method='post'>\n";
echo "<input type='hidden' name='security_token' value='".getToken('register.php')."' />\n";
// ...

?>