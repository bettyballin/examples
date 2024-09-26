This is not PHP code, but Apache mod_rewrite rules. You can place the following code in an .htaccess file to make it executable:

bash
RewriteEngine on
RewriteCond %{HTTP_REFERER} !^$
RewriteCond %{HTTP_REFERER} !^http://(www\.)?mydomain.com/.*$ [NC]
RewriteRule \.(gif|jpg|js|css)$ - [F]


However, if you want to implement the same logic in PHP, you can use the following code:


if (!empty($_SERVER['HTTP_REFERER'])) {
    $referer = $_SERVER['HTTP_REFERER'];
    if (strpos($referer, 'http://mydomain.com') !== 0 && strpos($referer, 'http://www.mydomain.com') !== 0) {
        $ext = pathinfo($_SERVER['REQUEST_URI'], PATHINFO_EXTENSION);
        if (in_array($ext, array('gif', 'jpg', 'js', 'css'))) {
            header('HTTP/1.1 403 Forbidden');
            exit;
        }
    }
}