<?php

/*
|--------------------------------------------------------------------------
| HTTPS Only Cookies
|--------------------------------------------------------------------------
|
| By setting this option to true, session cookies will only be sent back
| to the server if the browser has a HTTPS connection. This will keep
| the cookie from being sent to you if it can not be done securely.
|
*/

$httpsOnlyCookies = [
    'secure' => true,
];

// Usage example
session_start();
$params = session_get_cookie_params();
$params["secure"] = $httpsOnlyCookies["secure"];
session_set_cookie_params($params["lifetime"], $params["path"], $params["domain"], $params["secure"], $params["httponly"]);