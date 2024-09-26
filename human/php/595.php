<?php

// will match /login.php and /checkout.php as examples
$force_ssl = preg_match('/\/(login|checkout)\.php(.+)?/', $_SERVER['REQUEST_URI']);
$using_ssl = (isset($_SERVER['HTTPS']) && !empty($_SERVER['HTTPS']) ? true : false);

$url = $_SERVER['HTTP_HOST'] . $_SERVER['REQUEST_URI'];

if ($force_ssl && !$using_ssl) {

    // redirect to SSL
    header('Location: https://' . $url);
    exit;

} elseif (!$force_ssl && $using_ssl) {

    // redirect back to normal
    header('Location: http://' . $url);
    exit;

}