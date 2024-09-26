
// Set a cookie that expires in one hour
setcookie('cookie_name', 'cookie_value', time() + 3600, '/', 'yourdomain.com', isset($_SERVER["HTTPS"]), true);

