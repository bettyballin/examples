This is not PHP code, it's Apache configuration (.htaccess) code. However, I can provide you with a PHP code that does the same thing using a simple routing mechanism:


<?php
$uri = $_SERVER['REQUEST_URI'];

if ($uri !== '/index.php') {
    include 'index.php';
} else {
    include 'index.php';
}


However, a more proper approach would be to use a router library or a framework that supports routing.

If you want to keep using the Apache configuration, save it in a .htaccess file:

bash
RewriteEngine On
Options -Indexes
RewriteBase /
RewriteCond %{REQUEST_URI} !^/index.php
RewriteRule .* index.php [L]