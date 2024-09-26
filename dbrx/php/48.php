<?php
$parts = explode('/', filter_var($_SERVER['REQUEST_URI'], FILTER_SANITIZE_URL));
Header("HTTP/1.1 301 Moved Permanently"); //SEO friendly redirect
Header("Location: http://www.site.ca/programs/outline/{$parts[3]}/");
exit;
?>