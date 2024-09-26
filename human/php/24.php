<?php
// This is not a PHP code, it's an Apache .htaccess configuration.
// However, I can provide you with a PHP equivalent:

if (!empty($_SERVER['HTTP_REFERER']) && strpos($_SERVER['HTTP_REFERER'], 'http://yourdomain.com') !== 0 && strpos($_SERVER['HTTP_REFERER'], 'http://www.yourdomain.com') !== 0) {
    // your code here
}
?>