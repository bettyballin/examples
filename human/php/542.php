This is not PHP code, it's Apache mod_rewrite configuration. However, here is a PHP equivalent:


$userAgent = $_SERVER['HTTP_USER_AGENT'];

if (preg_match('/^BlackWidow/', $userAgent) || preg_match('/^Zeus/', $userAgent)) {
    header('HTTP/1.1 403 Forbidden');
    exit;
}