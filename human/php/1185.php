// web/app.php
if (isset($_SERVER['HTTP_X_FORWARDED_PROTO']) && $_SERVER['HTTP_X_FORWARDED_PROTO'] === 'https') {
    $_SERVER['REQUEST_SCHEME'] = 'https';
} elseif (isset($_SERVER['HTTPS']) && $_SERVER['HTTPS'] === 'on') {
    $_SERVER['REQUEST_SCHEME'] = 'https';
} else {
    $_SERVER['REQUEST_SCHEME'] = 'http';
}

if (getenv('APP_ENV') === 'prod' && $_SERVER['REQUEST_SCHEME'] !== 'https') {
    header('Location: https://'.$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI'], true, 301);
    exit;
}