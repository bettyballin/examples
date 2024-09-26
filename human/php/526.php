This is not PHP code, it appears to be Apache mod_rewrite rules. However, I can help you convert it to PHP. Here is the equivalent PHP code:


if (!empty($_SERVER['HTTP_REFERER'])) {
    $referer = parse_url($_SERVER['HTTP_REFERER']);
    if ($referer['host'] !== 'yourdomain.com' && $referer['host'] !== 'www.yourdomain.com') {
        if ($_SERVER['REQUEST_URI'] === '/hellothere/captcha.php') {
            header('HTTP/1.0 403 Forbidden');
            exit;
        }
    }
}