This is not PHP code, it's Apache mod_rewrite configuration. However, here is the equivalent PHP code:


if (isset($_SERVER['HTTP_REFERER']) && strpos($_SERVER['HTTP_REFERER'], 'mydomain.com/page') === false) {
    header('HTTP/1.0 403 Forbidden');
    exit;
}